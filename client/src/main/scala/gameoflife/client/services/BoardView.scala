package gameoflife.client.services

import diode._
import gameoflife.model.Board

import scalatags.JsDom.all._

/**
  * Render the current state of the board
  *
  * @param dispatch Dispatcher
  */
class BoardView(dispatch: Dispatcher) {
  def render(board: Board) = {
    div(
      p("Step = ", b(board.stepNum), br, br,
        pre(cls := "board", board.rep.map(l => Seq[Frag](l, br)))
      ),
      div(cls := "btn-group",
        button(cls := "btn btn-default", onclick := { () => dispatch(Reset) }, "Reset"),
        stepButton(board)
      )
    )
  }

  def stepButton(board: Board): Frag =
    if (board.cells.isEmpty) p("Board is empty")
    else if (board.cells == board.cells.nextState) p("Board is stable")
    else button(cls := "btn btn-default", onclick := { () => dispatch(Step) }, "Step")
}
