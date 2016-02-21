package gameoflife.model

case class Board(stepNum: Int, state: Matrix) {
  def step = copy(stepNum + 1, state.step)
}

object Board {
  val r = scala.util.Random

  def random: Board = {
    val width = r.nextInt(20) + 4
    val height = r.nextInt(20) + 4

    val cells: List[List[Boolean]] = (1 to height).toList.map { y =>
      (1 to width).toList.map { x =>
        r.nextBoolean()
      }
    }

    Board(0, Matrix(width, height, cells))
  }
}
