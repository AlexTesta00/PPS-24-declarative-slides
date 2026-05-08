# Introduzione
DeclSlides è un progetto software pensato per semplificare la creazione di presentazioni attraverso un approccio dichiarativo. Il cuore del sistema è un DSL (Domain-Specific Language) sviluppato in Scala, che permette di descrivere una presentazione in modo chiaro, tipizzato ed estendibile, separando la definizione dei contenuti dalla loro effettiva rappresentazione grafica.

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

presentation("Hello DeclSlides")
 .use(Theme.default)
 .withFooter("Footer text") {
 deck(
  slide("Intro", Flow) {
   content(
    text("This is the declerative slides tool"),
    text("Here you can write presentations in a declarative way through a DSL in scala"),
    text("The DSL supports: "),
    bullets(
     "Texts",
     "Code snippets",
     "Bullet lists",
     "Spacing",
     "Images"
      )
    )
  },
```

## Contesto di sviluppo
DeclSlides è un progetto accademico sviluppato come parte di un corso universitario.

[A.A 2024-2025 - Paradigmi di Programmazione e Sviluppo](https://www.unibo.it/it/studiare/insegnamenti-competenze-trasversali-moocs/insegnamenti?codiceMateria=81612&annoAccademico=2024&codiceCorso=8614&single=True&search=True)

## Autori
- [Alex Testa](https://github.com/AlexTesta00)