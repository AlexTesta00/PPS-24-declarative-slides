# Obiettivi del progetto
Gli obiettivi del progetto sono stati definiti in modo da tenere insieme prodotto, qualità del software e valore formativo. Non si è trattato soltanto di costruire “qualcosa che funzioni”, ma di realizzare un sistema piccolo, coerente e progettato con metodo.

## Caratteristiche di base

- Definizione di una presentazione composta da una sequenza di slide;
- Creazione di slide tramite costrutti dichiarativi della DSL
- Supporto per diversi tipi di contenuto all’interno delle slide (testo, liste puntate, blocchi di codice, immagini);
- Composizione e riutilizzo di componenti di slide tramite funzioni e astrazioni del linguaggio;
- Rappresentazione interna della presentazione tramite una struttura dati immutabile;
- Generazione di una rappresentazione visualizzabile della presentazione tramite un sistema di rendering (ad esempio HTML o formato testuale).

## Caratteristiche aggiuntive

- Rendering delle slide tramite interfaccia a linea di comando (CLI): l’utente potrà fornire il file contenente la definizione della presentazione e ottenere automaticamente il rendering delle slide.
- Supporto a diversi formati di output (ad esempio HTML, Markdown).
- Sviluppo di una interfaccia grafica per l’editing delle slide.

## Obiettivi funzionali
Il primo gruppo di obiettivi riguarda **ciò che il sistema deve fare concretamente**.

Il progetto doveva permettere di **definire una presentazione in modo dichiarativo**, tramite un DSL leggibile e naturale. Questa scelta nasce dalla volontà di ridurre il rumore sintattico e di fare in modo che il codice della presentazione assomigli il più possibile alla sua struttura concettuale. L’autore deve poter esprimere titolo, tema, footer, slide, layout e contenuti con una sintassi chiara e coerente.

Un secondo obiettivo funzionale era la **renderizzazione multi-formato**. La stessa presentazione deve poter essere trasformata in HTML, testo semplice e Markdown, senza duplicazione dei contenuti. Questo obiettivo è importante perché dimostra che il modello di dominio non è accoppiato a una singola vista o tecnologia di output.

Un terzo obiettivo era fornire una **CLI utilizzabile a partire da un file ```.sc```**, in modo che il progetto potesse essere usato anche fuori dal codice sorgente interno, come strumento vero e proprio.

## Obiettivi tecnici
Sul piano tecnico, l’obiettivo principale era **costruire una soluzione con una separazione netta delle responsabilità**. Il dominio doveva restare puro e indipendente dai dettagli di rendering; la DSL doveva restare espressiva ma non diventare il luogo in cui si annidano i vincoli; la CLI doveva orchestrare, non contenere logica di dominio.

Un altro obiettivo tecnico era **garantire estendibilità**. L’aggiunta progressiva di immagini, footer, renderer Markdown e sito di presentazione mostra che il progetto è stato pensato per evolvere senza richiedere continue riscritture strutturali.

Infine, un obiettivo essenziale era la **testabilità**. Molte parti del sistema sono state progettate in modo da poter essere isolate e verificate direttamente, dalla validazione del dominio al parsing CLI, fino ai singoli renderer.

## Obiettivi di qualità
DeclSlides doveva essere **leggibile, coerente e manutenibile**. Questo significa evitare magic numbers, ridurre l’opacità del codice, esplicitare i concetti con nomi significativi, centralizzare i messaggi e preferire modelli tipizzati ai valori grezzi.

La qualità non è stata intesa come un attributo astratto, ma come una somma di pratiche concrete: refactoring, TDD, documentazione, test, CI e commit convenzionali.

Le performance attualmente non ricoprono un obiettivo primario.

## Obiettivi formativi
Dal punto di vista formativo, il progetto doveva rappresentare un caso realistico in cui applicare principi di ingegneria del software. In particolare:
- modellazione di dominio;
- separazione di responsabilità;
- costruzione di un DSL;
- progettazione a layer;
- validazione esplicita tramite ```Either``` ed errori tipizzati;
- sviluppo guidato dai test(TDD);
- integrazione con pipeline CI/CD;
- documentazione tecnica strutturata.

## Obiettivi non implementati / futuri
Alcuni obiettivi possono essere considerati opzionali, nel senso che rappresentano funzionalità aggiuntive che arricchiscono il progetto ma non sono essenziali per la sua validità. Tra questi:

- Supporto a temi personalizzati, con definizione di palette cromatiche e stili;
- Implementazione di un sistema di layout più sofisticato, con posizionamento libero degli elementi
- Sviluppo di una GUI per l’editing visuale delle presentazioni, con anteprima in tempo reale;
- Performance ottimizzata per presentazioni di grandi dimensioni, con caching e rendering incrementale;