package declslides.rendering.text

import declslides.domain.Presentation
import declslides.domain.Slide
import declslides.domain.SlideElement
import declslides.rendering.Document
import declslides.rendering.RenderFormat
import declslides.rendering.Renderer

/** Plain text renderer for validated presentations.
  *
  * The text renderer produces a simple, readable textual representation of the
  * deck. It is especially useful for debugging, quick inspection, or
  * environments where HTML is unnecessary.
  */
object TextRenderer extends Renderer:

  /** The target render format for this renderer, specifying the label, file
    * extension, and accepted input formats. This allows the rendering system to
    * identify when to use this renderer based on the desired output format.
    */
  val Target: RenderFormat =
    RenderFormat(
      label = "text",
      fileExtension = "txt",
      acceptedInputs = Set("text", "txt"),
    )

  override val target: RenderFormat =
    Target

  override def render(presentation: Presentation): Document =
    Document(
      target = target,
      content = renderContent(presentation),
    )

  private def renderContent(presentation: Presentation): String =
    (
      Seq(
        presentation.title,
        s"Theme: ${presentation.theme.name}",
      ) ++
        presentation.footer.toVector.map(value => s"Footer: $value") ++
        Seq("", renderSlides(presentation))
    ).mkString("\n")

  private def renderSlides(presentation: Presentation): String =
    presentation.slides.zipWithIndex
      .map { case (slide, index) => renderSlide(slide, index + 1) }
      .mkString("\n\n")

  private def renderSlide(
    slide: Slide,
    number: Int,
  ): String =
    val lines =
      s"[$number] ${slide.title} (${slide.layout})" +:
        slide.elements.flatMap(renderElementLines)

    lines.mkString("\n")

  private def renderElementLines(element: SlideElement): Seq[String] =
    element match
      case SlideElement.Paragraph(value) =>
        Seq(value)

      case SlideElement.BulletList(items) =>
        items.map(item => s"- $item")

      case SlideElement.CodeBlock(language, source) =>
        Seq(
          s"```$language",
          source,
          "```",
        )

      case SlideElement.Spacer(lines) =>
        List.fill(lines)("")

      case SlideElement.Image(source, altText) =>
        Seq(renderImageLine(source, altText))

  private def renderImageLine(
    source: String,
    altText: String,
  ): String =
    s"![$altText]($source)"
