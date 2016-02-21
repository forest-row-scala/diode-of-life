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

  import Cursor.limitRange

  require(x >= 0)
  require(x < width)
  require(y >= 0)
  require(y < height)

  def moveBy(xDiff: Int, yDiff: Int): Cursor = copy(x = limitRange(x + xDiff, width), y = limitRange(y + yDiff, height))

  lazy val w = moveBy(-1, 0)

  lazy val e = moveBy(1, 0)

  lazy val s = moveBy(0, 1)

  lazy val n = moveBy(0, -1)

  lazy val neighbors: List[Cursor] = List(n, s, e, w, n.e, n.w, s.e, s.w)
}

object Cursor {
  def limitRange(i: Int, limit: Int): Int = {
    require(limit > 0)

    if (i < 0) i % limit + limit else i % limit
  }
}
