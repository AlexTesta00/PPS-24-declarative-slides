# Problemi incontrati e soluzioni
## Problema 1: rischio di accoppiamento tra DSL e dominio
All’inizio era facile far confluire troppe responsabilità nel DSL. La soluzione adottata è stata mantenere il DSL come layer di composizione e delegare la validazione al dominio. Questo ha reso più chiaro il ruolo di ciascun componente.

## Problema 2: crescita della CLI e opacità del flusso
La CLI inizialmente rischiava di diventare un punto di concentrazione eccessiva. Il refactor ha portato all’estrazione di parser, config, errori, usage e programma CLI, rendendo il flusso più leggibile e più testabile.

## Problema 3: gestione degli asset e script nel renderer HTML
L’integrazione di uno script di navigazione e di risorse statiche ha richiesto attenzione. Si è scelto di rendere più esplicita la gestione delle resource e di evitare fallback silenziosi che avrebbero nascosto errori reali.

## Problema 4: mantenere estendibilità durante l’aggiunta di nuove feature
L’introduzione di immagini, footer e renderer Markdown avrebbe potuto generare modifiche troppo invasive. Il fatto che le estensioni siano state integrate con modifiche mirate mostra che l’architettura era già predisposta a crescere.

## Problema 5: equilibrio fra pulizia architetturale e pragmatismo
Non tutte le scelte “perfette” erano giustificate dal contesto. In alcuni casi si è preferita una soluzione semplice ma pulita, evitando di introdurre complessità eccessiva per problemi ancora piccoli.