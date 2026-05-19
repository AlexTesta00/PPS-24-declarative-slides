# Processo di sviluppo
Il processo di sviluppo adottato è stato di tipo iterativo, con una forte attenzione alla progressione incrementale e alla qualità continua. Il progetto non è stato costruito in un solo passaggio, ma attraverso piccoli step, ognuno dei quali ha portato una funzionalità, un refactor o un miglioramento alla struttura esistente.

L’approccio seguito è stato **Scrum-inspired**, ma alleggerito e adattato a un progetto tecnico di dimensione contenuta. In pratica, il lavoro è stato organizzato in task ben definiti, con cicli di implementazione basati su obiettivi chiari: prima introdurre una funzionalità tramite test, poi implementare il codice minimo necessario, infine rifinire con refactoring e pulizia architetturale.

Una parte significativa del lavoro è stata svolta con **TDD** o comunque con una forte **priorità ai test**. Questo ha permesso di rendere esplicite le aspettative su DSL, dominio, renderer e CLI prima di consolidare l’implementazione. L’effetto più importante non è stato solo l’aumento della copertura, ma la definizione più chiara del comportamento desiderato.

Dal punto di vista collaborativo, ```Git``` è stato usato come strumento centrale di coordinamento, con un’attenzione specifica ai commit piccoli, descrittivi e allineati al principio di tracciabilità. L’uso di **Conventional Commits** ha contribuito a mantenere leggibile la storia del progetto e a supportare il rilascio automatizzato tramite ```semantic-release```.

Infine si è scelto di utilizzare la piattaforma ```CodeCov``` per monitorare la copertura dei test, con l’obiettivo di mantenere un alto standard qualitativo e di identificare rapidamente eventuali aree non sufficientemente testate. Questo ha contribuito a garantire che ogni nuova funzionalità fosse accompagnata da un adeguato set di test, rafforzando la stabilità complessiva del progetto.

## Tabella del processo
| **Aspetto**               | **Scelta Adottata**  | **Motivazione**                                                                                                          |
|---------------------------|----------------------|--------------------------------------------------------------------------------------------------------------------------|
| **Gestione del lavoro**   | Approccio Iterativo  | permette di sviluppare per incrementi, con feedback continuo                                                             |
| **Sviluppo funzionalità** | TDD/test-first       | chiarisce il comportamento atteso e riduce regressioni                                                                   |
| **Versionamento**         | Git                  | supporta collaborazione, rollback e tracciabilità                                                                        |
| **Conventional Commit**   | Conventional Commits | migliora leggibilità della history e release automation                                                                  |
| **Revisione**             | Scalafmt & Scalafix  | garantiscono coerenza stilistica e qualità del codice                                                                    |
| **Qualità continua**      | CI (GithubActions)   | automatizza test, linting e code coverage                                                                                |
| **Rilascio**              | Semantic-Release     | automatizza il processo di rilascio basato sui commit e sulla semantica delle versioni e di pubblicazione dell'artefatto |
| **Docs**                  | Mkdocs (GithubPages) | facilita la creazione e la pubblicazione di documentazione accessibile e ben strutturata                                 |

## Requisiti
La definizione dei requisiti è stata fondamentale per dare direzione al progetto e per collegare le scelte di design al valore reale prodotto. I requisiti sono stati organizzati distinguendo tra necessità di business, requisiti funzionali, requisiti non funzionali, estensioni opzionali e possibili sviluppi futuri.

### Requisiti di Business
Dal punto di vista del valore d’uso, il sistema doveva permettere di trattare una presentazione come artefatto software, e non solo come documento visuale. Questo implica che il contenuto debba essere:

- Versionabile;
- Riproducibile;
- Leggibile nel tempo;
- Validabile;
- Renderizzabile in più formati.

Un secondo requisito di business consisteva nel poter usare il progetto sia come strumento pratico sia come oggetto di studio ingegneristico, con un’attenzione forte alla struttura del codice e alla dimostrazione delle scelte architetturali.

### Requisiti Funzionali
| **Codice**    | **Descrizione**                                      | **Area**            | **Stato** | **Note** |
|-----------|--------------------------------------------------|-----------------|------||
| **RF-01** | Definire una presentazione tramite DSL           | DSL             | Implementato | Sintassi dichiarativa tramite Scala 3 |
| **RF-02** | Definire slide con titolo e layout               | DSL/Domain      | Implementato | Supporto a layout ``Flow`` e ``Centered`` |
| **RF-03** | Inserire paragrafi di testo                      | DSL/Domain      | Implementato | Validazione su contenuto non vuoto |
| **RF-04** | Inserire liste puntate                           | DSL/Domain      | Implementato | Validazione della lista e sui singoli item |
| **RF-05** | Inserire blocchi di codice                       | DSL/Domain      | Implementato | Con linguaggio sorgente |
| **RF-06** | Inserire spaziature                              | DSL/Domain      | Implementato | |
| **RF-07** | Inserire immagini                                | DSL/Domain      | Implementato | Con URL e Alt text |
| **RF-08** | Configurare un tema                              | DSL/Domain      | Implementato | ```Default```, ```Dark```, ```Conference``` |
| **RF-09** | Configurazione di un footer                      | DSL/Domain      | Implementato | Footer opzionale globale |
| **RF-10** | Renderizzare in HTML                             | Renderer        | Implementato | Layout full screen e navigazione |
| **RF-11** | Renderizzare in Testo semplice                   | Renderer        | Implementato | Utile ai fini di debug e ispazione |
| **RF-12** | Renderizzare in Markdown                         | Renderer        | Implementato | Utile per documentazione |
| **RF-13** | Fornire una CLI per renderizzare                 | CLI/Application | Implementato | Supporto a input ``.sc`` da file e output su file |
| **RF-14** | Validare in modo esplicito gli errori di dominio | Domain          | Implementato | Errori tipizzati con messaggi chiari |
| **RF-15** | Fornire tutta la documentazione                  | Docs            | Implementato | Documentare tutto il progetto a fini conoscitivi |

### Requisiti Non Funzionali
#### Usabilità
Il DSL doveva essere leggibile e vicino alla struttura logica di una presentazione. La CLI doveva essere semplice da usare e basata su parametri espliciti (``--input``, ``--format``, ``--output``).
#### Manutenibilità
La codebase doveva essere organizzata in moduli e package coerenti, con responsabilità ben separate. L’aggiunta di nuove funzionalità non doveva richiedere modifiche pervasive e incontrollate.
#### Testabilità
Il sistema doveva consentire test unitari e di integrazione mirati, con componenti facilmente isolabili. Le funzioni di parsing, i renderer e la validazione del dominio dovevano poter essere verificati senza dipendere dall’intero sistema.
#### Estendibilità
Il progetto doveva essere predisposto all’aggiunta di nuovi renderer, nuovi elementi di slide e nuove opzioni del DSL.
#### Portabilità
La pipeline CI doveva verificare il comportamento su più sistemi operativi, così da evitare accoppiamenti impliciti con un solo ambiente.
#### Documentazione
Era richiesto che il progetto fosse accompagnato da una documentazione leggibile, sia per l’uso, sia per la comprensione architetturale.

### Requisiti Opzionali
- Sito di presentazione pubblicato automaticamente;
- GUI per la creazione e modifica di presentazioni.

## Verifiche di qualità

Prima della consegna il progetto dovrebbe essere verificato con:

```bash
sbt clean compile
sbt test
sbt scalafmtCheckAll
sbt "scalafixAll --check"
sbt assembly
```

### Sviluppi Futuri
- Supporto a temi personalizzati definiti dall’utente;
- Supporto a layout aggiuntivi (es. griglia, split);
- Supporto a elementi multimediali (video, audio);
- Supporto a formati di output aggiuntivi (es. PDF, PowerPoint);