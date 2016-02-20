package gameoflife.model

object Test {
  def main(args: Array[String]) {
    val m1: Matrix = Matrix(5, 5,
      List(
        List(false, false, false, false, false),
        List(false, false, true, false, false),
        List(false, false, true, false, false),
        List(false, false, true, false, false),
        List(false, false, false, false, false)
      ))

    val m = Board.random.state
    println(m.rep)
    println
    println(m.step.rep)
    println
    println(m.step.step.rep)
  }
}
