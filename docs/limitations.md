# Limiti noti e sviluppi futuri

## Limiti noti

### CLI non completamente standalone

La CLI richiede Scala CLI installato e configurato tramite `DECLSLIDES_SCALA_CLI`.

### Markdown semplificato

Il renderer Markdown privilegia leggibilità e portabilità, ma non conserva tutte le informazioni visuali disponibili in HTML.

### Layout limitati

Sono disponibili solo layout semplici. Non sono ancora presenti griglie, colonne, speaker notes o animazioni.

### Nessun export PDF/PowerPoint

La versione attuale supporta HTML, Markdown e testo semplice.

### Validazione non completamente type-level

Alcuni vincoli vengono controllati dal dominio alla fine della costruzione, non direttamente dal compilatore Scala.

## Sviluppi futuri

- renderer PDF;
- renderer Reveal.js;
- supporto a colonne e griglie;
- golden tests per i renderer;
- CLI con `--help` e `--version`;
- distribuzione più semplice senza configurazione manuale di Scala CLI;
- documentazione degli errori con esempi reali.