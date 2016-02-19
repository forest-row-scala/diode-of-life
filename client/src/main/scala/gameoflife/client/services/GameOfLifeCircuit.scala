package gameoflife.client.services

import diode._
import diode.react.ReactConnector

// Actions

case class RootModel()

// Application circuit
object GameOfLifeCircuit extends Circuit[RootModel] with ReactConnector[RootModel] {
  // initial application model
  override protected def initialModel = RootModel()

  // combine all handlers into one
  override protected val actionHandler = combineHandlers()
}