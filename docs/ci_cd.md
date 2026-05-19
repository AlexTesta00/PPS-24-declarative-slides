# Continuous Integration e Deployment

Il progetto utilizza una pipeline di **Continuous Integration e Continuous Deployment** basata su **GitHub Actions**.  
La pipeline è definita in un workflow chiamato `CI/CD` e viene eseguita automaticamente a ogni `push` e a ogni `pull_request`.

L'obiettivo principale della CI è verificare che il progetto rimanga stabile nel tempo, controllando in modo automatico test, compilazione, generazione degli artefatti e pubblicazione della documentazione.

## Esecuzione automatica

Il workflow viene avviato in due situazioni principali:

- quando viene effettuato un `push` sul repository;
- quando viene aperta o aggiornata una `pull_request`.

Questa scelta permette di intercettare rapidamente eventuali problemi introdotti durante lo sviluppo, sia sul ramo principale sia durante il lavoro su branch separati.

## Test su più sistemi operativi

La prima fase della pipeline è dedicata ai test.

I test vengono eseguiti su una matrice di sistemi operativi:

- Ubuntu;
- Windows;
- macOS.

Questa scelta rende la verifica più robusta, perché permette di controllare che il progetto non funzioni correttamente solo in un ambiente specifico.  
Dato che il progetto può essere eseguito da riga di comando e si basa su strumenti come Java e sbt, testarlo su più piattaforme aiuta a individuare differenze di comportamento legate al sistema operativo.

Per ogni sistema operativo la pipeline:

1. scarica il codice del repository;
2. configura Java tramite la distribuzione Temurin;
3. configura sbt;
4. esegue la suite di test.

Sui sistemi diversi da Ubuntu viene eseguito semplicemente:

```bash
sbt test
```

Su Ubuntu, invece, i test vengono eseguiti insieme alla misurazione della copertura:

```bash
sbt clean coverage test coverageReport
```

In questo modo Ubuntu viene usato come ambiente principale per produrre il report di coverage, evitando di ripetere la stessa operazione su tutti i sistemi operativi.

## Code coverage con Codecov

Dopo l'esecuzione dei test su Ubuntu, la pipeline carica il report di copertura su **Codecov**.

Il report generato da `scoverage` viene recuperato dal percorso:

```text
./target/scala-*/scoverage-report/scoverage.xml
```

La pubblicazione del coverage permette di monitorare nel tempo quanto codice è coperto dai test.  
Questo non garantisce automaticamente la correttezza del progetto, ma fornisce un indicatore utile per capire quali parti del codice sono verificate e quali potrebbero richiedere maggiore attenzione.

La pipeline è configurata per fallire se il caricamento su Codecov non va a buon fine.  
Questa scelta rende il controllo più rigoroso, perché evita che un problema nella pubblicazione del report passi inosservato.

## Verifica della compilazione

Dopo i test viene eseguito un job separato di build.

Anche questa fase viene eseguita su Ubuntu, Windows e macOS.  
Il job di build dipende dal completamento del job di test, quindi viene avviato solo dopo che la fase di testing è terminata correttamente.

Il comando utilizzato è:

```bash
sbt clean compile
```

Questa fase verifica che il progetto sia compilabile da zero e che non siano presenti errori di compilazione.  
Separare test e build rende la pipeline più chiara, perché distingue il controllo del comportamento del codice dalla verifica della sua compilabilità.

## Release automatica

La fase di release viene eseguita solo in condizioni specifiche:

- l'evento deve essere un `push`;
- il branch deve essere `main`;
- i job precedenti devono essere completati con successo.

Questo evita che una release venga generata da una pull request o da un branch secondario.

Durante questa fase la pipeline prepara l'ambiente necessario alla pubblicazione:

- configura Java e sbt;
- configura Node.js;
- configura Python;
- installa le dipendenze di sistema richieste da WeasyPrint;
- installa le dipendenze Node tramite `npm ci`;
- installa le dipendenze Python per MkDocs;
- genera il jar assemblato;
- genera la documentazione MkDocs anche in formato PDF;
- avvia `semantic-release`.

Il jar viene prodotto con:

```bash
sbt clean assembly
```

La documentazione viene invece generata con:

```bash
mkdocs build --strict --site-dir ./site/docs
```

L'opzione `--strict` è importante perché trasforma warning e problemi della documentazione in errori di build.  
In questo modo la documentazione viene trattata come una parte integrante del progetto, non come un elemento secondario.

La release vera e propria viene gestita da `semantic-release`, che automatizza la pubblicazione in base alla cronologia dei commit.  
Questo rende il processo più ripetibile e riduce il rischio di errori manuali durante il rilascio.

## Pubblicazione della documentazione

Dopo la release viene eseguita una fase dedicata alla generazione del sito per **GitHub Pages**.

Anche questa fase viene eseguita solo sul branch `main` e solo dopo il completamento della release.

Il sito pubblicato contiene due sezioni principali:

- la documentazione MkDocs, generata sotto `/docs`;
- la documentazione API generata con Scaladoc, copiata sotto `/api`.

La documentazione MkDocs viene costruita con esportazione PDF abilitata tramite la variabile:

```bash
ENABLE_PDF_EXPORT=1
```

Successivamente viene generata anche la documentazione API con:

```bash
sbt doc
```

I file prodotti da Scaladoc vengono copiati nella cartella `site/api`, così da essere inclusi nello stesso artefatto pubblicato su GitHub Pages.

## Deploy su GitHub Pages

L'ultimo job della pipeline si occupa del deploy vero e proprio.

Il job prende l'artefatto prodotto nella fase precedente e lo pubblica su GitHub Pages tramite l'azione ufficiale di deploy.  
Anche questa fase è limitata ai push sul branch `main`, così da pubblicare solo versioni considerate stabili.

La pipeline richiede permessi specifici per poter scrivere su GitHub Pages e generare il token di identità necessario al deploy.

## Controllo dello stile prima del commit

Oltre ai controlli eseguiti dalla pipeline di GitHub Actions, il progetto prevede anche una verifica locale prima di ogni commit.

Questa verifica è gestita tramite **Husky**, che permette di configurare hook Git automatici. In particolare, è stato configurato un hook di tipo `pre-commit`, eseguito ogni volta che si tenta di creare un nuovo commit.

Lo scopo di questo controllo è verificare lo stile e la formattazione del codice prima che le modifiche vengano effettivamente salvate nella cronologia del repository.  

Se il codice non rispetta le regole di formattazione previste, il commit viene bloccato e, di conseguenza, non è possibile proseguire con il push delle modifiche.

Questa scelta aiuta a mantenere il codice più uniforme e leggibile, riducendo la possibilità che vengano introdotte modifiche non formattate o non coerenti con lo stile del progetto.

Inoltre, spostare una parte dei controlli già nella fase di commit permette di individuare alcuni problemi prima ancora dell'esecuzione della CI remota.

## Considerazioni finali

Nel complesso, la pipeline automatizza le attività principali necessarie a mantenere il progetto stabile e pubblicabile:

- esecuzione dei test;
- controllo della copertura;
- verifica della compilazione;
- generazione del jar;
- creazione della documentazione;
- generazione della documentazione API;
- pubblicazione su GitHub Pages;
- gestione automatica della release.

Questa configurazione rende il processo di sviluppo più affidabile, perché ogni modifica viene controllata automaticamente prima di arrivare alla pubblicazione.  

Inoltre, l'esecuzione su più sistemi operativi aumenta la fiducia nella portabilità del progetto e riduce il rischio che il tool funzioni correttamente solo nell'ambiente di sviluppo originale.
