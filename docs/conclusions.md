# Sintesi
DeclSlides è un sistema software progettato per affrontare un problema molto concreto: la difficoltà di costruire presentazioni in modo riproducibile, tipizzato, controllabile e facilmente estendibile quando si lavora in un contesto tecnico. Nella pratica, gran parte degli strumenti di presentazione più diffusi è fortemente orientata all’editing visuale, ma meno adatta a chi desidera trattare una presentazione come artefatto software, versionabile, testabile e integrabile in una pipeline di build.

Il progetto introduce quindi un DSL dichiarativo in Scala che permette di descrivere una presentazione come codice strutturato. L’utente definisce il titolo del deck, il tema, l’eventuale footer, l’insieme delle slide, il layout di ciascuna slide e i singoli elementi di contenuto, come paragrafi, bullet list, blocchi di codice, spaziatori e immagini. Il risultato di questa descrizione non resta confinato al solo modello dati: il sistema è in grado di validare il contenuto e di renderizzarlo in diversi formati, con un approccio coerente e unificato.

Dal punto di vista architetturale, il progetto è stato costruito con una separazione netta fra dominio, DSL, application layer, rendering e interfaccia CLI. Il dominio definisce le regole e i vincoli della presentazione; il DSL fornisce una sintassi leggibile e guidata; il livello applicativo orchestra validazione, bootstrap ed esecuzione; il rendering traduce una presentazione validata nei diversi output; la CLI rende il sistema utilizzabile da terminale attraverso uno script ```.sc``` e un ```jar eseguibile```. Questa organizzazione migliora leggibilità, manutenibilità, testabilità ed estendibilità.

Le tecnologie adottate sono state selezionate con criterio. ```Scala 3``` offre un linguaggio espressivo adatto a modellazione, immutabilità e DSL; ```sbt``` governa build e test; ```Scala CLI``` viene sfruttato per l’esecuzione degli script utente; ```ScalaTags``` supporta la generazione del markup HTML; ```ScalaTest``` garantisce una suite di test leggibile e coerente. Sul piano DevOps, ```GitHub Actions``` automatizza test multi-piattaforma, build, rilascio e pubblicazione del sito di presentazione del progetto.

Il valore del progetto non risiede solo nel prodotto finale, ma anche nel percorso ingegneristico seguito. DeclSlides dimostra come principi di progettazione del software, validazione esplicita, refactoring iterativo e TDD possano essere applicati con efficacia anche a un dominio apparentemente semplice come quello delle presentazioni. Il risultato è un sistema piccolo ma serio, con una chiara identità architetturale, un’attenzione concreta alla qualità del codice e una base solida per sviluppi futuri.

# Retrospettiva
Guardando il progetto nel suo insieme, emergono diversi aspetti positivi. Il primo è la coerenza architetturale: il sistema non appare come un insieme di soluzioni casuali, ma come un piccolo ecosistema con ruoli ben definiti. Il secondo è la qualità del percorso di sviluppo: TDD, refactoring e modularizzazione hanno contribuito a costruire un codice leggibile e relativamente facile da estendere.

Ha funzionato bene anche il collegamento fra esigenze pratiche e obiettivi formativi. DeclSlides non è solo una dimostrazione teorica di DSL e renderer: è anche uno strumento realmente utilizzabile per generare presentazioni da script.

Le aree migliorabili riguardano soprattutto l’evoluzione verso una struttura più ampia: packaging della libreria, supporto a plugin, raffinamento del sito, e potenziale separazione più netta tra core e CLI in ottica distribuzione.

Dal punto di vista delle competenze, il progetto ha permesso di consolidare abilità in:

- modellazione di dominio;
- progettazione di DSL;
- testing in Scala;
- CI/CD;
- refactoring architetturale;
- documentazione tecnica tramite mkdocs;

# Sviluppi futuri
Gli sviluppi futuri del progetto possono essere articolati in più direzioni.

## Miglioramenti funzionali

- esportazione PDF;
- supporto a elementi avanzati come tabelle o citazioni;
- possibilità di cambiare font e stile della presentazione, definendone uno personale;
- possibilità di definire animazioni per ogni elemento della slide;
- pubblicazione tramite CI della presentazione su servizi di hosting.

## Miglioramenti tecnici

- plugin renderer esterni;
- miglioramento del bootstrap e del runtime;
- eventuale passaggio a un modello asset più strutturato per HTML.

## Limiti noti
Il renderer HTML è il formato più curato, mentre Markdown e testo semplice sono pensati soprattutto come output di ispezione. 

In particolare, alcune informazioni visuali, come il layout centrato, non hanno ancora una rappresentazione forte in Markdown. 

Una possibile evoluzione sarebbe introdurre metadata espliciti nel Markdown o distinguere tra renderer “di presentazione” e renderer “di documentazione”.

# Conclusione

DeclSlides ha raggiunto l’obiettivo principale: mostrare come un dominio relativamente semplice, quello delle presentazioni, possa essere modellato con un DSL embedded in Scala 3, validato esplicitamente e trasformato in più formati di output.

La parte più riuscita del progetto è la separazione tra dominio, DSL, application layer, renderer e CLI. Questa separazione ha reso possibile aggiungere progressivamente nuove funzionalità, come immagini, footer e Markdown, senza riscrivere il nucleo del sistema.

La parte più delicata rimane la distribuzione della CLI. La scelta di usare Scala CLI per eseguire gli script `.sc` ha semplificato l’implementazione, ma richiede una configurazione esterna tramite `DECLSLIDES_SCALA_CLI`. Per una versione più matura sarebbe utile ridurre questa dipendenza o documentare ancora meglio il processo di installazione.

Dal punto di vista formativo, il progetto è stato utile perché ha costretto a prendere decisioni concrete: quali vincoli mettere nel dominio, quali lasciare al DSL, come rappresentare gli errori, come mantenere estendibile il rendering e come separare un’interfaccia CLI dal resto dell’applicazione.

Il risultato non è un framework completo per creare presentazioni, ma un prototipo solido e coerente che dimostra l’applicazione di principi di programmazione funzionale, modellazione di dominio, testing e progettazione modulare.