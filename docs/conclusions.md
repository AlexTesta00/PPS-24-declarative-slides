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

# Conclusione
DeclSlides rappresenta un progetto software di dimensione contenuta ma di forte densità ingegneristica. Il problema affrontato, descrivere e generare presentazioni in modo dichiarativo, validato e multi-formato, è stato risolto con una soluzione coerente, tecnicamente solida e progressivamente estesa senza compromettere la struttura del sistema.

Gli obiettivi iniziali sono stati raggiunti: il progetto permette di definire una presentazione tramite DSL, validarla con regole esplicite, renderizzarla in più formati, eseguirla da CLI e presentarla tramite un sito dedicato. Ancora più importante, queste funzionalità non sono state costruite in modo monolitico o improvvisato, ma inserite in un’architettura chiara, con una forte attenzione alla separazione delle responsabilità, alla leggibilità del codice e alla qualità del processo di sviluppo.

Le principali scelte ingegneristiche, dominio tipizzato, error handling esplicito, layer distinti, registry dei renderer, refactoring progressivi, TDD, hanno dato al progetto una struttura che va oltre l’esercizio didattico. DeclSlides si presenta come un sistema piccolo, ma progettato seriamente, capace di mostrare non soltanto un risultato finale funzionante, ma anche un percorso di sviluppo consapevole.

Dal punto di vista formativo e professionale, il progetto ha permesso di consolidare competenze fondamentali di ingegneria del software: analisi, modellazione, design, test, automazione, documentazione e comunicazione tecnica. Per questo motivo, DeclSlides può essere considerato non solo un prodotto software riuscito, ma anche una dimostrazione concreta di metodo, rigore e maturità progettuale.