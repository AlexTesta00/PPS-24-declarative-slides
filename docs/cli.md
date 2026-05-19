# Guida CLI

DeclSlides include una CLI per renderizzare presentazioni scritte come script Scala `.sc`.

La CLI non interpreta direttamente il DSL. Il flusso è il seguente:

1. legge gli argomenti da terminale;
2. valida `--input`, `--format` e `--output`;
3. genera un piccolo bootstrap Scala;
4. esegue lo script tramite Scala CLI;
5. costruisce una `Presentation`;
6. seleziona il renderer richiesto;
7. scrive il file di output.

## Requisiti

Per usare la CLI servono:

- JDK 17 o superiore;
- il jar di DeclSlides;
- Scala CLI installato;
- la variabile d’ambiente `DECLSLIDES_SCALA_CLI`.

Esempio:

```bash
export DECLSLIDES_SCALA_CLI=/usr/local/bin/scala-cli
```

Su Powershell:

```powershell
$env:DECLSLIDES_SCALA_CLI = "C:\path\to\scala-cli.exe"
```

## Sintassi

```bash
java -jar declslides-1.0.1.jar \
  --input <file.sc> \
  --format <html|markdown|md|text|txt> \
  --output <output-file>
```

## Opzioni
- `--input`: il file `.sc` da processare;
- `--format`: il formato di output desiderato (`html`, `markdown`/`md`, `text`/`txt`);
- `--output`: il percorso del file di output

## Errori comuni
- **Scala CLI non trovato**: assicurati che `DECLSLIDES_SCALA_CLI` punti al percorso corretto di Scala CLI.
- **File di input mancante**: verifica che il file `.sc` esista e sia accessibile.
- **Formato non supportato**: controlla che il formato specificato sia uno tra `html`, `markdown`/`md`, `text`/`txt`.

**DeclSlides supporta solo**:

- html
- markdown / md
- text / txt

**Controlla il file `.sc`**

Se lo script non costruisce una presentazione valida, DeclSlides interrompe il rendering e mostra gli errori di dominio raccolti.

### Esempio di errori

- titolo della presentazione vuoto;
- presentazione senza slide;
- slide senza contenuto;
- testo vuoto;
- bullet list vuota;
- immagine senza sorgente o alt text.