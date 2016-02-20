package gameoflife.client.services

import diode._
import gameoflife.model.Board

import scalatags.JsDom.all._

/**
  * Render the current state of the board
  *
  * @param dispatch Dispatcher
  */
class BoardView(board: ModelR[Board, Board], dispatch: Dispatcher) {
  def render = {
    div(
      p("Step = ", b(board.value.stepNum), br, br,
        code(cls := "board",
          board.value.state.rep.map(l => Seq[Frag](l, br))
        )
      ),
      div(cls := "btn-group",
        button(cls := "btn btn-default", onclick := { () => dispatch(Step) }, "Step")))
  }
}
