package gameoflife.model

case class Board(stepNum: Int, cells: Matrix) {
  /**
    * Calculate the next state of the board
    */
  def next: Board = copy(stepNum + 1, cells.nextState)

  /**
    * Produce a basic string representation of the board
    */
  def rep: List[String] = cells.rep
}

object Board {
  private val r = scala.util.Random

  /**
    * Produce a randomly populated board
    *
    * @param width  the width of the new board. Default is a random value in range 4 to 24
    * @param height the height of the new board. Default is a random value in range 4 to 24
    * @return a new Board of the given width and height, randomly populated
    */
  def random(width: Int = r.nextInt(20) + 4, height: Int = r.nextInt(20) + 4): Board = {
    val cells: List[List[Boolean]] = (1 to height).toList.map { y =>
      (1 to width).toList.map { x =>
        r.nextBoolean()
      }
    }

    Board(0, Matrix(width, height, cells))
  }
}
