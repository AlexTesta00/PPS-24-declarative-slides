# Testing e qualità

La fase di testing è stata pensata come una parte centrale del progetto, non solo come controllo finale sul codice scritto.  
L'obiettivo principale è stato verificare che i diversi componenti funzionassero correttamente in isolamento, mantenendo il comportamento del sistema prevedibile e facilmente controllabile.

Per rendere i test più leggibili ed espressivi è stato utilizzato **ScalaTest**, in particolare lo stile:

```scala
extends AnyFlatSpec with Matchers
```

## Test del dominio

I test del dominio verificano che `Presentation`, `Slide` e `SlideElement` rispettino i vincoli principali:

- titolo della presentazione non vuoto;
- almeno una slide;
- titoli delle slide univoci;
- slide non vuota;
- paragrafi non vuoti;
- bullet list non vuota;
- codice non vuoto;
- spacer positivo;
- immagini con sorgente e testo alternativo.

## Test del DSL

I test del DSL verificano che la sintassi utente produca il modello atteso e che gli errori vengano propagati correttamente dal dominio.

## Test dei renderer

I renderer vengono testati separatamente per evitare che HTML, Markdown e testo semplice siano accoppiati fra loro.

## Test della CLI

La CLI viene testata sul parsing degli argomenti:

- opzioni mancanti;
- opzioni duplicate;
- formato non supportato;
- argomento inatteso;
- valore mancante.

## Limite attuale

Un miglioramento importante sarebbe aggiungere un test end-to-end che esegua il jar assemblato su un file `.sc` reale. I test unitari verificano molte parti isolate, ma non sostituiscono completamente una prova del flusso completo.