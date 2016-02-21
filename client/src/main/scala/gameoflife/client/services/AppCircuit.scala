package gameoflife.client.services

import diode._
import gameoflife.client.logger._
import gameoflife.model.Board

object AppCircuit extends Circuit[Board] {
  override protected def initialModel = Board.random()

  override protected def actionHandler = combineHandlers(new StepHandler(zoomRW(b => b)((m, b) => b)))
}

case object Step

case object Reset

class StepHandler(modelRW: ModelRW[Board, Board]) extends ActionHandler[Board, Board](modelRW) {
  override def handle: PartialFunction[AnyRef, ActionResult[Board]] = {
    case Step => updated(value.next)
    case Reset => updated(Board.random())
  }
}