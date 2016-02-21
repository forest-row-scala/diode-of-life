package gameoflife.model

case class Matrix(width: Int, height: Int, cells: List[List[Boolean]]) {
  require(cells.length == height)
  require(cells.forall(_.length == width))

  /**
    * Perhaps not the most efficient algorithm
    *
    * @return a Matrix with cell states calculated based on this Matrix
    */
  def nextState: Matrix = {
    val newCells = cells.zipWithIndex.map {
      case (row, y) => row.zipWithIndex.map {
        case (_, x) => newState(Cursor(x, y, width, height))
      }
    }
    copy(cells = newCells)
  }

  def cellState(cell: Cursor): Boolean = cells(cell.y)(cell.x)

  def newState(cell: Cursor): Boolean = (cellState(cell), neighborCount(cell)) match {
    case (true, count) if count == 2 || count == 3 => true
    case (false, count) if count == 3 => true
    case _ => false
  }

  def neighborCount(cell: Cursor): Int = cell.neighbors.foldLeft[Int](0) {
    case (liveCount: Int, c: Cursor) if cellState(c) => liveCount + 1
    case (liveCount, _) => liveCount
  }


  def rep: List[String] = cells.map { row => "." + row.map(alive => if (alive) "*" else " ").mkString + "." }

  def isEmpty: Boolean = cells.forall(_.forall(_ == false))
}
