# Stack Tecnologico
Le tecnologie adottate non sono state scelte in modo decorativo, ma in relazione diretta alle esigenze del progetto.

| **Tecnologia** | **Ruolo nel progetto** | **Motivazione**|
| --- | --- ||
| **Scala 3** | Linguaggio di programmazione principale | offre ottimo supporto a DSL, immutabilità, ADT, enum, espressività tipizzata|
| **Sbt** | Build Tool | standard nell’ecosistema Scala, adatto a test e build|
| **Scala CLI** | Esecuzione script utente | permette di valutare ```.sc``` in modo semplice e integrabile|
| **ScalaTags** | Generazione HTML | consente di costruire HTML tipizzato e leggibile senza template engine esterno|
| **GitHub Actions** | CI/CD | automatizza test e build, integrato con GitHub|
| **os-lib** | File system e processi | semplifica I/O, path handling e chiamate di processo in modo chiaro|
| **ScalaTest** | Testing | API leggibile e coerente con lo stile del progetto|
| **Semantic-Release** | Release automation | automatizza versionamento e pubblicazione dell'artefatto |
| **GitHub Pages** | Pubblicazione del sito | soluzione leggera per ospitare il sito del progetto |
| **Tailwind CSS via CDN** | Stile visuale HTML | permette di ottenere rapidamente una resa moderna senza build frontend dedicata |
| **Commit Lint**| Linting dei commit | garantisce coerenza nei messaggi di commit, facilitando la gestione del progetto e l'automazione delle release |
| **Scala Fmt**| Formattazione del codice | assicura uno stile di codice uniforme e leggibile |
| **Scala Fix**| Refactoring automatico | aiuta a mantenere il codice pulito e aggiornato con le best practice di Scala |
| **Husky**| Git Hooks | automatizza l'esecuzione di script prima dei commit e dei push, garantendo la qualità del codice e la coerenza dei commit |
| **Codecov** | Monitoraggio della copertura dei test | fornisce metriche dettagliate sulla copertura del codice, aiutando a identificare aree non sufficientemente testate |
| **Mkdocs** | Documentazione | facilita la creazione e la pubblicazione di documentazione accessibile e ben strutturata |
| **Mermaid** | Diagrammi | consente di creare diagrammi di classe e altri tipi di visualizzazioni direttamente nei documenti Markdown |
| **Renovate**| Gestione delle dipendenze | automatizza l'aggiornamento delle dipendenze, mantenendo il progetto sicuro e aggiornato |

## Motivazione delle scelte
### Scala 3
Scala 3 è stata una scelta naturale per un progetto che ruota attorno a un DSL. La possibilità di modellare il dominio con ```enum```, ```case class```, ```pattern matching``` e ```funzioni di alto livello``` ha reso più agevole costruire una sintassi espressiva senza compromettere il rigore.
### Sbt
Sbt è lo standard de facto per i progetti Scala. La sua flessibilità e il supporto per la gestione delle dipendenze, i test e la compilazione incrementale lo rendono ideale per un progetto che richiede iterazione rapida e affidabilità.
### Scala CLI

Scala CLI è stata una scelta pragmatica. Il progetto aveva bisogno di eseguire file `.sc` scritti dall’utente, ma implementare un parser o un interprete dedicato avrebbe spostato il lavoro su un problema secondario rispetto al DSL.

Usare Scala CLI mi ha permesso di riutilizzare l’infrastruttura Scala esistente e di concentrarmi sul dominio, sulla validazione e sui renderer. Il limite è che la CLI di DeclSlides non è completamente autonoma: dipende da un eseguibile esterno e da una variabile d’ambiente configurata correttamente.

Questa scelta è accettabile per un progetto universitario e per uno strumento tecnico, ma sarebbe da ripensare in una distribuzione più matura.
### ScalaTags
Per il renderer HTML si è preferito evitare un motore di template tradizionale. ScalaTags si integra bene con Scala, permette una costruzione programmatica del DOM e mantiene il rendering vicino alla logica che lo governa aumentando l'espressività.
### Tailwind CSS via CDN
Per il sito e per l’HTML è stata privilegiata la semplicità operativa. L’uso del CDN elimina una pipeline frontend dedicata e accelera l’iterazione grafica. È una scelta consapevole, adatta a questa scala progettuale.
### Commit Lint
L'adozione di Commit Lint è stata motivata dalla necessità di mantenere una storia dei commit chiara e coerente. Questo non solo facilita la collaborazione, ma è anche essenziale per l'automazione delle release con Semantic-Release, che si basa sui messaggi di commit per determinare le versioni da rilasciare.
### Scala Fmt e Scala Fix
L'uso di Scala Fmt e Scala Fix è stato dettato dalla volontà di mantenere un codice pulito, leggibile e conforme alle best practice. Scala Fmt assicura uno stile uniforme, mentre Scala Fix aiuta a refactorare il codice in modo automatico, mantenendo il progetto aggiornato con le evoluzioni del linguaggio e delle librerie utilizzate.
### Husky
Husky è stato scelto per automatizzare l'esecuzione di script prima dei commit e dei push. Questo garantisce che i test vengano eseguiti, che i commit siano formattati correttamente e che i messaggi di commit rispettino le convenzioni stabilite, contribuendo a mantenere la qualità del codice e la coerenza del progetto.
### Codecov
L'adozione di Codecov è stata motivata dalla necessità di monitorare la copertura dei test in modo dettagliato. Codecov fornisce metriche precise sulla copertura del codice, aiutando a identificare aree che potrebbero essere insufficientemente testate e a mantenere un alto standard qualitativo per il progetto.
### Mkdocs
Mkdocs è stato scelto per la documentazione del progetto grazie alla sua semplicità d'uso e alla capacità di generare siti statici ben strutturati. La possibilità di scrivere la documentazione in Markdown e di ospitarla facilmente su GitHub Pages lo rende una soluzione ideale per rendere accessibile e ben organizzata la documentazione di DeclSlides.
### Mermaid
Mermaid è stato adottato per la creazione di diagrammi direttamente nei documenti Markdown. Questo strumento consente di rappresentare visivamente concetti complessi come la struttura del dominio o l'architettura del sistema in modo chiaro e integrato con la documentazione, migliorando la comprensione e la comunicazione delle idee chiave del progetto.
### Renovate
Renovate è stato scelto per automatizzare la gestione delle dipendenze del progetto. Questo strumento monitora le dipendenze utilizzate e crea pull request automatiche quando sono disponibili aggiornamenti, contribuendo a mantenere il progetto sicuro e aggiornato senza richiedere un intervento manuale costante. Renovate supporta anche la configurazione di regole personalizzate per gestire le dipendenze in modo flessibile, adattandosi alle esigenze specifiche del progetto.