import declslides.domain.Layout.{Centered, Flow}
import declslides.domain.Theme
import declslides.dsl.DSL._

presentation("Declarative Slides: un DSL interno in Scala 3")
  .use(Theme.default)
  .withFooter("PPS - Declarative Slides - Alex Testa"){
    deck(

      slide("Paradigmi di programmazione e Sviluppo", Centered){
        content(
          text("Alex Testa - Declerative Slides"),
          image("https://images.unsplash.com/photo-1505373877841-8d25f7d46678?q=80&w=2612&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", "Conferenza")
        )
      },

      slide("Declarative Slides") {
        content(
          text("L’idea è quella di trasformare una presentazione in codice dichiarativo: facile da comprendere, semplice da comporre e sicuro da validare."),
          spacer(),
          bullets(
            "Il DSL descrive il dominio: slide, contenuti, layout, temi e formati di output",
            "Il codice assume la forma di una rappresentazione chiara e strutturata della presentazione",
            "La pipeline genera automaticamente HTML, Markdown o testo a partire da un file .sc"
          )
        )
      },

      slide("1. Contesto del progetto") {
        content(
          text("Declarative Slides nasce per creare presentazioni in modo dichiarativo, usando Scala 3, invece di manipolare direttamente un formato finale."),
          text("Si sviluppa a partire dall’idea di abbandonare la logica del 'what you see is what you get'"),
          bullets(
            "Il dominio non è il rendering HTML o Markdown: è la presentazione",
            "Le primitive del linguaggio sono slide, testi, bullet list, codice, immagini, layout e tema",
            "Il file .sc diventa una specifica dichiarativa della presentazione",
            "Il rendering è separato dalla definizione del contenuto"
          )
        )
      },

      slide("Il problema affrontato") {
        content(
          text("Creare slide attraverso i classici strumenti (PowerPoint, Google Slides, Markdown, HTML) mescola contenuto e forma, rendendo difficile mantenere coerenza e qualità."),
          bullets(
            "Il contenuto è mescolato a dettagli di formattazione",
            "Il dominio della presentazione è nascosto dietro tag HTML o sintassi Markdown",
            "Errori di struttura (slide vuote, titoli duplicati) emergono tardi",
            "Difficile mantenere coerenza visiva tra presentazioni diverse"
          ),
          spacer(),
          text("Il progetto risponde con un linguaggio dedicato e una pipeline esplicita.")
        )
      },

      slide("Vantaggi di un DSL") {
        content(
          text("Il DSL permette di scrivere ciò che si vuole ottenere, non come costruirlo manualmente."),
          bullets(
            "Per il programmatore: codice più breve, leggibile e componibile",
            "Per l’utente: struttura della presentazione immediatamente riconoscibile",
            "Per il progetto: dominio validato prima del rendering",
            "Per l’organizzazione: output multipli senza riscrivere il contenuto"
          )
        )
      },

      slide("2. Che cos’è un DSL") {
        content(
          text("Un Domain Specific Language è un linguaggio progettato per esprimere concetti di un dominio specifico."),
          bullets(
            "Usa un lessico vicino al problema da modellare",
            "Riduce dettagli tecnici non essenziali",
            "Guida l’utente verso primitive corrette",
            "Rende il codice una rappresentazione del dominio"
          ),
          spacer(),
          text("Il progetto mira a rendere dichiarativa la definizione di una presentazione.")
        )
      },

      slide("General purpose, DSL interno, DSL esterno") {
        content(
          bullets(
            "Linguaggio general purpose: risolve problemi generici, ma richiede più infrastruttura",
            "DSL interno: usa sintassi e type system di un linguaggio ospite",
            "DSL esterno: ha parser, grammatica e toolchain propri"
          ),
          spacer(),
          text("Declarative Slides è un DSL interno: la presentazione sfrutta la sintassi di Scala 3, ma con primitive dedicate al dominio delle slide.")
        )
      },

      slide("Obiettivi del DSL") {
        content(
          bullets(
            "Aumentare l’espressività del codice",
            "Ridurre il rumore sintattico",
            "Avvicinare il codice al linguaggio del dominio",
            "Limitare errori comuni con validazioni esplicite",
            "Rendere il sistema più estendibile e manutenibile"
          )
        )
      },

      slide("Da Scala 3 al DSL - Esempio") {
        content(
          text("La presentazione viene descritta con primitive di dominio, non con istruzioni di rendering."),
          code(
            "scala",
            """presentation("Hello DeclSlides").use(Theme.default) {
  deck(
    slide("Intro", Flow) {
      content(
        text("Questo è il tool declerative slides"),
        bullets(
          "Testi",
          "Pezzi di codice",
          "Liste puntate",
          "Spaziature",
          "Immagini"
        )
      )
    }
  )
}"""
          ),
          text("La struttura è leggibile: presentation → deck → slide → content → elementi."),
          text("La struttura è rappresentata come un albero di stati immutabili che viene validato e trasformato in un modello del dominio, separato dal rendering."),
          spacer(),
          text("Nota: nella versione attuale si è scelto di preservare la descrittività a discapito della verbosità.")
        )
      },

      slide("Da Scala 3 al DSL - Vantaggi") {
        content(
          text("Il DSL interno, sfrutta direttamente Scala 3."),
          bullets(
            "Non introduce una grammatica separata",
            "Non richiede un parser custom per la sintassi utente",
            "Usa funzioni e tipi Scala come primitive del linguaggio",
            "Restituisce Either[Vector[DomainError], Presentation]",
            "Mantiene type safety e composizione del linguaggio ospite"
          )
        )
      },

      slide("3. Perché Scala 3 è adatto") {
        content(
          text("Scala 3 consente di costruire un DSL interno espressivo senza uscire da un linguaggio general purpose."),
          bullets(
            "Sintassi compatta per chiamate annidate",
            "Case class ed ADTs per modellare il dominio",
            "Either per validazione esplicita",
            "Pattern matching per interpretare gli elementi",
            "Funzioni come trasformazioni di stato componibili"
          )
        )
      },

      slide("Sintassi compatta e leggibilità") {
        content(
          text("Nel progetto, le primitive DSL hanno nomi del dominio: presentation, deck, slide, content, text, bullets, code, spacer, image."),
          code(
            "scala",
            """slide("Code", Flow) {
  content(
    text("Ecco un esempio di codice:"),
    code(
      "scala",
      """ + "\"\"\"" + """println("hello declslides")""" + "\"\"\"" + """
    )
  )
}"""
          ),
          text("La sintassi Scala rimane valida, ma il risultato si legge come una descrizione della slide.")
        )
      },

      slide("Type safety e ADT") {
        content(
          text("Gli elementi della slide sono modellati come algebraic data type tramite enum."),
          code(
            "scala",
            """enum SlideElement derives CanEqual:
  case Paragraph(value: String)
  case BulletList(items: Vector[String])
  case CodeBlock(language: String, source: String)
  case Spacer(lines: Int)
  case Image(source: URL, altText: String)"""
          ),
          text("Il renderer può usare pattern matching esaustivo sui casi del dominio.")
        )
      },

      slide("Pattern matching e semantica") {
        content(
          text("La semantica degli elementi è esplicita nella validazione e nel rendering."),
          spacer(),
          text("File: SlideElement.scala"),
          code(
            "scala",
            """def validate(element: SlideElement): Vector[DomainError] =
  element match
    case SlideElement.Paragraph(value) =>
      Option.when(value.trim.isEmpty)(DomainError.EmptyParagraph).toVector

    case SlideElement.CodeBlock(language, source) =>
      Option.when(language.trim.isEmpty)(DomainError.EmptyCodeLanguage).toVector ++
        Option.when(source.trim.isEmpty)(DomainError.EmptyCodeBlock).toVector

    case SlideElement.Spacer(lines) =>
      Option.when(lines <= 0)(DomainError.NonPositiveSpacer(lines)).toVector"""
          ),
          text("Ogni costrutto del DSL ha una regola di correttezza associata.")
        )
      },

      slide("Concetti non usati consapevolmente") {
        content(
          text("Alcune funzionalità di Scala 3 non sono centrali nel progetto attuale."),
          bullets(
            "Gli extension methods non emergono come meccanismo centrale nella definizione del DSL",
            "I costrutti given/using non costituiscono un asse portante dell’architettura.",
            "Non si è fatto ricorso agli opaque types",
            "Non risulta necessario l’impiego di inline, macro o tecniche di metaprogrammazione."
          )
        )
      },

      slide("Approccio tradizionale vs DSL in Scala 3") {
        content(
          code(
            "text",
            """Approccio tradizionale
- costruzione manuale dell’output
- logica di rendering mescolata al contenuto
- errori scoperti tardi
- codice più verboso

Approccio DSL in Scala 3
- primitive del dominio
- dominio validato prima del rendering
- output multipli tramite renderer
- codice leggibile, componibile e tipato"""
          ),
          text("Scala 3 permette di ottenere un linguaggio dedicato senza rinunciare alla potenza del linguaggio ospite.")
        )
      },

      slide("4. Il progetto come prodotto") {
        content(
          text("Declarative Slides offre i seguenti vantaggi: "),
          bullets(
            "Un unico sorgente dichiarativo",
            "Output HTML, Markdown o testo",
            "Validazione strutturale prima della generazione",
            "Separazione tra contenuto e resa grafica",
            "Architettura estendibile tramite nuovi renderer",
            "CLI dedicata per eseguire script .sc e generare output in modo riproducibile"
          )
        )
      },

      slide("Punti chiave") {
        content(
          bullets(
            "Chiarezza: la struttura della presentazione è evidente nel codice",
            "Affidabilità: gli errori di dominio sono modellati e riportati esplicitamente",
            "Produttività: una presentazione si scrive con poche primitive",
            "Portabilità: lo stesso modello può essere renderizzato in formati diversi",
            "Estendibilità: nuovi formati possono essere aggiunti dietro il contratto Renderer"
          )
        )
      },

      slide("Perché adottarlo") {
        content(
          text("Il progetto riduce complessità dove contenuto tecnico e output devono restare allineati."),
          bullets(
            "Maggiore chiarezza per chi legge il sorgente",
            "Minore possibilità di errore grazie alla validazione",
            "Codice più vicino al dominio della presentazione",
            "Onboarding più semplice per nuovi contributor",
            "Aggiunta di formati senza riscrivere il DSL"
          )
        )
      },

      slide("Scenario aziendale realistico") {
        content(
          text("Un team tecnico deve produrre deck ricorrenti per demo, formazione interna e documentazione di progetto."),
          bullets(
            "Gli sviluppatori scrivono il contenuto in .sc versionato su Git",
            "La CI può generare HTML per la presentazione e Markdown per la documentazione",
            "Le regole di validazione evitano slide vuote, titoli duplicati o blocchi codice incompleti",
            "Il tema mantiene coerenza visiva tra presentazioni diverse"
          )
        )
      },

      slide("Rischi ridotti") {
        content(
          bullets(
            "Incoerenza tra documentazione e presentazione",
            "Output generati manualmente e difficili da riprodurre",
            "Errori silenziosi nella struttura delle slide",
            "Duplicazione della logica tra formati diversi",
            "Dipendenza da strumenti visuali non versionabili"
          ),
          spacer(),
          text("La presentazione diventa un artefatto software: leggibile, versionabile e verificabile.")
        )
      },

      slide("5. Struttura tecnica del progetto") {
        content(
          text("Il repository è organizzato per responsabilità architetturali."),
          bullets(
            "declslides.domain: modello, vincoli e tipi del dominio",
            "declslides.dsl: sintassi dichiarativa e builder della presentazione",
            "declslides.application: validazione input, bootstrap ed esecuzione",
            "declslides.rendering: contratti e renderer HTML, Markdown e Text",
            "declslides.cli: parsing argomenti e comando utente",
            "examples e readme: casi d’uso reali del DSL",
            "src/test: copertura per dominio, DSL, CLI, application e rendering"
          )
        )
      },

      slide("Vista architetturale", Flow) {
        content(
          code(
            "text",
            """File .sc utente
      |
      v
declslides.dsl
  sintassi dichiarativa e builder
      |
      v
declslides.domain
  Presentation, Slide, SlideElement, Theme, Layout
      |
      v
declslides.application
  validazione input, bootstrap, Scala CLI
      |
      v
declslides.rendering
  HTML / Markdown / Text
      |
      v
Output finale"""
          )
        )
      },

      slide("Pipeline adattata al progetto") {
        content(
          code(
            "text",
            """1. Scrittura del DSL
   examples/*.sc o readme/Readme.sc

2. Costruzione
   presentation/deck/slide/content producono PendingSlide e stati immutabili

3. Validazione
   Presentation, Slide e SlideElement restituiscono DomainError espliciti

4. Esecuzione
   ScalaCliScriptRunner genera un bootstrap e invoca scala-cli

5. Output
   DefaultRendererRegistry seleziona HTML, Markdown o Text"""
          )
        )
      },

      slide("Bootstrap ed esecuzione") {
        content(
          text("Il progetto non interpreta un file .sc con un parser custom: genera un programma Scala di bootstrap."),
          spacer(),
          text("File: bootsrap-template.txt"),
          code(
            "scala",
            """val resolvedPresentation = Bootstrap.resolve {
  {{USER_SOURCE}}
}

val registry = DefaultRendererRegistry.live
val target = registry.parse(format).getOrElse {
  System.err.println("Unsupported format '" + format + "'.")
  sys.exit(1)
}

Files.writeString(
  destination,
  renderer.render(resolvedPresentation).content,
  StandardCharsets.UTF_8
)"""
          ),
          text("Il DSL rimane interno a Scala, mentre l’applicazione controlla validazione, renderer e output.")
        )
      },

      slide("DSL.scala - stato e costruzione") {
        content(
          text("File: DSL.scala"),
          code(
            "scala",
            """final case class PresentationState(
  title: String,
  theme: Theme = Theme.default,
  footer: Option[String] = None,
  pendingSlides: Vector[PendingSlide] = Vector.empty
):
  def appendSlide(slide: PendingSlide): PresentationState =
    copy(pendingSlides = pendingSlides :+ slide)

final case class SlideState(
  title: String,
  layout: Layout,
  elements: Vector[SlideElement] = Vector.empty
):
  def appendElement(element: SlideElement): SlideState =
    copy(elements = elements :+ element)"""
          ),
          text("Lo stato è immutabile: ogni operazione produce una nuova versione invece di modificare quella esistente.")
        )
      },

      slide("DSL.scala - composizione delle primitive", Flow) {
        content(
          text("File: DSL.scala"),
          code(
            "scala",
            """final case class PresBuild(run: PresentationState => PresentationState)

final case class SlideBuild(run: SlideState => SlideState)

def deck(items: PresBuild*): PresBuild =
  PresBuild.combineAll(items)

def content(items: SlideBuild*): SlideBuild =
  SlideBuild.combineAll(items)

def text(value: String): SlideBuild =
  appendElement(SlideElement.Paragraph(value))

def bullets(items: String*): SlideBuild =
  appendElement(SlideElement.BulletList(items.toVector))"""
          ),
          text("Le primitive sono trasformazioni componibili: una slide è il risultato della composizione dei suoi elementi.")
        )
      },

      slide("DSL.scala - ideazione") {
        content(
          bullets(
            "presentation crea la configurazione globale",
            "deck combina più slide in un unico PresBuild",
            "slide apre uno SlideState con titolo e layout",
            "content combina text, bullets, code, spacer e image",
            "gli elementi vengono raccolti come SlideElement",
            "alla fine i PendingSlide vengono validati e trasformati in Slide"
          ),
          spacer(),
          text("Questo file dimostra il cuore del DSL: sintassi dichiarativa sopra una costruzione funzionale controllata.")
        )
      },

      slide("DSL.scala - collegamento con il sistema", Flow) {
        content(
          text("Il DSL non produce direttamente HTML o Markdown."),
          bullets(
            "Produce un modello Presentation validato oppure errori di dominio",
            "La validazione rimane nel domain layer",
            "Il rendering rimane nel rendering layer",
            "L’esecuzione rimane nell’application layer",
            "La sintassi utente resta piccola, leggibile e stabile"
          )
        )
      },

      slide("ScalaCliScriptRunner.scala") {
        content(
          bullets(
            "Orchestra l’esecuzione dello script .sc tramite Scala CLI",
            "Rappresenta il punto di raccordo tra DSL, bootstrap, runtime e generazione dell’output",
            "Gestisce aspetti applicativi come dependency injection, propagazione degli errori e cleanup",
            "Mantiene confinata l’esecuzione esterna dietro l’astrazione ScriptRunner"
          )
        )
      },

      slide("ScalaCliScriptRunner - orchestrazione") {
        content(
          code(
            "scala",
            """override def render(
  input: os.Path,
  target: RenderFormat,
  output: os.Path,
): Either[ApplicationError, Unit] =
  for
    _ <- inputValidator.validate(input)
    userSource <- inputReader.read(input)
    bootstrapSource <- bootstrapSourceFactory.create(
      userSource = userSource,
      declslidesDependency = declslidesDependency,
      scalaVersion = scalaVersion,
    )
    _ <- executeBootstrap(
      bootstrapSource = bootstrapSource,
      target = target,
      output = output,
    )
  yield ()"""
          ),
          text("La for-comprehension rende esplicita la pipeline applicativa e ferma l’esecuzione al primo errore.")
        )
      },

      slide("ScalaCliScriptRunner - esecuzione controllata") {
        content(
          code(
            "scala",
            """private def invokeScalaCli(
  bootstrapFile: os.Path,
  target: RenderFormat,
  output: os.Path,
  workingDirectory: os.Path,
): os.CommandResult =
  os.proc(
    scalaCliBinary,
    ScalaCliScriptRunner.RunSubcommand,
    bootstrapFile.toString,
    ScalaCliScriptRunner.ArgumentSeparator,
    target.label,
    normalizedOutputPath(output),
  ).call(
    cwd = workingDirectory,
    check = false,
    stdout = os.Pipe,
    stderr = os.Pipe,
  )"""
          ),
          text("Il processo esterno è incapsulato: input, formato, output, directory di lavoro, stdout e stderr sono gestiti in un unico punto.")
        )
      },

      slide("ScalaCliScriptRunner - passo per passo") {
        content(
          bullets(
            "1. Verifica che l’input esista e abbia estensione .sc",
            "2. Legge il sorgente scritto con il DSL",
            "3. Genera il bootstrap Scala con dipendenza e versione",
            "4. Crea una workspace temporanea",
            "5. Invoca scala-cli run sul bootstrap",
            "6. Verifica la corretta esecuzione tramite validazione",
            "7. Rimuove la workspace nel finally"
          )
        )
      },

      slide("7. Evoluzioni future") {
        content(
          bullets(
            "Sviluppare il render PDF",
            "Sviluppare una GUI",
            "Supportare elementi avanzati come tabelle, grafici, video, citazioni",
            "Possibilità di cambiare font e stile della presentazione, definendone uno personale",
            "Possibilità di definire animazioni per ogni elemento della slide",
            "Pubblicazione tramite CLI della presentazione su servizi di hosting",
            "Possibilità di definire un render personalizzato"
          )
        )
      },

      slide("Conclusione", Centered) {
        content(
          text("Declarative Slides non è solo codice per generare slide."),
          spacer(),
          text("È un esempio di come Scala 3 possa trasformare un dominio specifico in un linguaggio espressivo, leggibile, validato e manutenibile."),
          spacer(),
          text("Questa presentazione stessa è stata scritta con il DSL di Declarative Slides, dimostrando la potenza di un linguaggio dedicato per descrivere ciò che si vuole ottenere, senza preoccuparsi di come costruirlo manualmente.")
        )
      },

      slide("Grazie!", Centered){
        text("Grazie per l’attenzione!")
      }
    )
  }
