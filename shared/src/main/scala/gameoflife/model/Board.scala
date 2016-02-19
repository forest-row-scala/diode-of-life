package gameoflife.model

/**
  * Cursor gives us a way to move around a board easily. When we move past the edge of
  * the board we will get wrapped around to the other edge.
  *
  * Positions are zero-indexed from the top-left. The maximum x and y positions are
  * therefore 1 less that the width and height.
  *
  * @param x      - left-right position counting from left of board
  * @param y      - top-bottom position counting from top of board
  * @param width  - number of columns on the board
  * @param height - number of rows on the board
  */
case class Cursor(x: Int, y: Int, width: Int, height: Int) {
  require(x >= 0)
  require(x < width)
  require(y >= 0)
  require(y < height)

  def moveBy(xDiff: Int, yDiff: Int): Cursor = copy(x = add(x + xDiff, width), y = add(y + yDiff, height))

  private def add(i: Int, limit: Int): Int = i match {
    case i1 if i1 < 0 => i1 + limit
    case i1 if i1 > (width - 1) => i1 % limit
    case i1 => i1
  }

  lazy val w = moveBy(-1, 0)

  lazy val e = moveBy(1, 0)

  lazy val s = moveBy(0, 1)

  lazy val n = moveBy(0, -1)
}


case class Matrix(width: Int, height: Int, cells: List[List[Boolean]]) {


  def step: Matrix = {
    ???
  }
}


case class Board(step: Int, state: Matrix) {

}
