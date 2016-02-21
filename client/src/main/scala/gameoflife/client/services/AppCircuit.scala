package gameoflife.client.services

import diode._
import gameoflife.client.logger._
import gameoflife.model.Board

// Actions

case class RootModel()

// Application circuit
object AppCircuit extends Circuit[Board] {
  // initial application model
  override protected def initialModel = Board.random

  override protected def actionHandler = combineHandlers(new StepHandler(zoomRW(b => b)((m, b) => b)))
}


case object Step

case object Reset

class StepHandler(modelRW: ModelRW[Board, Board]) extends ActionHandler[Board, Board](modelRW) {
  override def handle: PartialFunction[AnyRef, ActionResult[Board]] = {
    case Step => updated(value.step)
    case Reset =>
      log.info("reset")
      updated(Board.random)
  }
}