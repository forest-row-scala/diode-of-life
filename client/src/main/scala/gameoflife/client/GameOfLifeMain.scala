package gameoflife.client

import gameoflife.client.components.GlobalStyles
import gameoflife.client.logger._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport
import scalacss.Defaults._
import scalacss.ScalaCssReact._

@JSExport("GameOfLifeMain")
object GameOfLifeMain extends js.JSApp {



  @JSExport
  def main(): Unit = {
    log.warn("Application starting")
    // send log messages also to the server
    log.enableServerLogging("/logging")
    log.info("This message goes to server as well")

    // create stylesheet
    GlobalStyles.addToDocument()
  }
}
