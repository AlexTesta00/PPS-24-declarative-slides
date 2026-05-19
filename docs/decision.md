# Decisioni progettuali

Questa pagina raccoglie alcune decisioni prese durante lo sviluppo e le alternative considerate.

## Decisione 1: embedded DSL invece di formato custom

### Scelta

Usare Scala 3 come linguaggio ospite del DSL.

### Alternative considerate

- YAML/JSON;
- Markdown esteso;
- parser custom.

### Motivazione

Un embedded DSL permette di usare funzioni, composizione e controllo statico del linguaggio ospite. Inoltre evita di implementare un parser da zero.

### Costo

La sintassi è adatta soprattutto a utenti tecnici e richiede familiarità minima con Scala.

## Decisione 2: validazione nel dominio

### Scelta

Il DSL costruisce uno stato intermedio; il dominio valida il risultato finale.

### Motivazione

In questo modo le regole non sono disperse tra funzioni DSL e renderer.

### Costo

Alcuni errori vengono rilevati a runtime, non a compile-time.

## Decisione 3: Scala CLI per eseguire script `.sc`

### Scelta

Usare Scala CLI come esecutore esterno.

### Motivazione

Riduce la complessità del progetto e permette di concentrarsi su dominio, DSL e rendering.

### Costo

La CLI non è completamente standalone.