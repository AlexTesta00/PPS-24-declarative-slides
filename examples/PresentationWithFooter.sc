import declslides.domain.Layout.Flow
import declslides.domain.Theme
import declslides.dsl.DSL._

presentation("Presentation with Footer")
  .use(Theme.default)
  .withFooter("This is a footer"){
  deck(
    slide("Slide 1", Flow) {
      content(
        text("This is the first slide")
      )
    },
    slide("Slide 2", Flow) {
      content(
        text("This is the second slide")
      )
    }
  )
}