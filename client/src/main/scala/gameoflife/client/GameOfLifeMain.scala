package gameoflife.client

import gameoflife.client.logger._
import gameoflife.client.services.{AppCircuit, BoardView, Reset}
import org.scalajs.dom._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport
import scalatags.JsDom.all._

@JSExport("GameOfLifeMain")
object GameOfLifeMain extends js.JSApp {

  val boardView = new BoardView(AppCircuit.zoom(identity), AppCircuit)

  @JSExport
  def main(): Unit = {
    val root = document.getElementById("root")

    log.warn("Application starting")
    // send log messages also to the server
    log.enableServerLogging("/logging")
    log.info("This message goes to server as well")

    AppCircuit.subscribe(AppCircuit.zoom(identity))(_ => render(root))

    AppCircuit(Reset)
  }

  def render(root: Element) = {
    log.info("render")
    val e = div(cls := "container",
      h1("Conway's Game of Life"),
      boardView.render // renders the counter view
    ).render
    // clear and update contents
    root.innerHTML = ""
    root.appendChild(e)
  }
}
