package gameoflife.client

import gameoflife.client.logger._
import gameoflife.client.services.{AppCircuit, BoardView, Reset}
import gameoflife.model.Board
import org.scalajs.dom._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport
import scalatags.JsDom.all._

@JSExport("AppMain")
object AppMain extends js.JSApp {

  val boardView = new BoardView(AppCircuit)

  @JSExport
  def main(): Unit = {
    val root = document.getElementById("root")

    log.warn("Application starting")
    // send log messages also to the server
    log.enableServerLogging("/logging")
    log.info("This message goes to server as well")

    val modelR = AppCircuit.zoom(identity)
    AppCircuit.subscribe(modelR)(_ => render(root, modelR.value))

    AppCircuit(Reset)
  }

  def render(root: Element, board: Board) = {
    log.info("render")
    val e = div(cls := "container",
      h1("Conway's Game of Life"),
      boardView.render(board) // renders the counter view
    ).render
    // clear and update contents
    root.innerHTML = ""
    root.appendChild(e)
  }
}
