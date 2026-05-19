# Introduzione

DeclSlides è un progetto Scala 3 nato per sperimentare la costruzione di un embedded DSL per presentazioni. L’idea di partenza è semplice: trattare una presentazione come un artefatto software, quindi versionabile, validabile, testabile e generabile in più formati.

In questa versione, DeclSlides permette di definire una presentazione tramite script `.sc`, validarla attraverso un modello di dominio tipizzato e renderizzarla in HTML, Markdown o testo semplice. La CLI esegue lo script tramite Scala CLI, genera il modello `Presentation` e seleziona il renderer richiesto.

## Perché un DSL?

Ho scelto un embedded DSL perché Scala 3 permette di combinare una sintassi leggibile con un modello fortemente tipizzato. In questo modo una slide non è una stringa da concatenare, ma una struttura composta da titolo, layout ed elementi di contenuto.

Il compromesso principale è che non tutti i vincoli sono garantiti a compile-time: alcune regole, come “una slide non deve essere vuota” o “i titoli delle slide devono essere univoci”, vengono validate quando il DSL produce il modello finale.

## Obiettivo
L’obiettivo principale di DeclSlides è fornire agli utenti un modo semplice e flessibile per creare presentazioni, senza dover affrontare la complessità di strumenti di authoring tradizionali. Grazie alla natura dichiarativa del DSL, gli utenti possono concentrarsi sulla struttura e sui contenuti della presentazione, lasciando a DeclSlides il compito di gestire la formattazione e la generazione del risultato finale.

L’utente può partire da un semplice script con estensione ```.sc```, all’interno del quale definire gli elementi principali della presentazione.

Una volta descritta la presentazione, DeclSlides si occupa di trasformarla automaticamente nel formato di output desiderato. In questo modo, lo stesso sorgente può essere riutilizzato per generare rappresentazioni differenti, favorendo la manutenibilità del progetto e riducendo la duplicazione del lavoro.

## Elementi supportati

- **Testo**: Titoli, paragrafi, elenchi puntati, spaziature.
- **Immagini**: Inserimento di immagini.
- **Blocchi di codice**: Visualizzazione di codice sorgente.

## Formati di output supportati

- **HTML**: Generazione di presentazioni web-based, facilmente condivisibili e visualizzabili su qualsiasi dispositivo.
- **Markdown**: Creazione di documenti Markdown, utili per la condivisione su piattaforme come GitHub o per l’integrazione in altri sistemi di documentazione.
- **Testo Semplice**: Esportazione in formato testo, ideale per la stampa o per l’utilizzo in ambienti con limitate capacità di rendering.

## Esempio di utilizzo
Ecco un esempio di come potrebbe apparire un semplice script in DeclSlides:
```scala

import declslides.domain.*
import declslides.domain.Layout.*
import declslides.dsl.DSL.*

presentation("Hello DeclSlides")
  .use(Theme.default)
  .withFooter("PPS 2024/2025 - Alex Testa") {
    deck(
      slide("Intro", Flow) {
        content(
          text("DeclSlides lets you describe presentations as Scala code."),
          bullets(
            "DSL embedded in Scala 3",
            "Immutable domain model",
            "Explicit validation",
            "Multiple renderers"
          )
        )
      },
      slide("Code example", Flow) {
        content(
          code(
            "scala",
            """presentation("Demo") {
              |  deck(
              |    slide("Intro") {
              |      content(text("Hello"))
              |    }
              |  )
              |}
              |""".stripMargin
          )
        )
      }
    )
  }
```

## Contesto di sviluppo
DeclSlides è un progetto accademico sviluppato come parte di un corso universitario.

[A.A 2024-2025 - Paradigmi di Programmazione e Sviluppo](https://www.unibo.it/it/studiare/insegnamenti-competenze-trasversali-moocs/insegnamenti?codiceMateria=81612&annoAccademico=2024&codiceCorso=8614&single=True&search=True)

## Autori
- [Alex Testa](https://github.com/AlexTesta00)