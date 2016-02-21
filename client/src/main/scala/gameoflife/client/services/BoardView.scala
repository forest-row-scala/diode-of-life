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
        pre(cls := "board",
          board.value.state.rep.map(l => Seq[Frag](l, br))
        )
      ),
      div(cls := "btn-group", stepButton)
    )
  }

  def stepButton: Frag =
    if (board.value.state.isEmpty) p("Board is empty")
    else if (board.value.state == board.value.state.step) p("Board is stable")
    else button(cls := "btn btn-default", onclick := { () => dispatch(Step) }, "Step")
}
