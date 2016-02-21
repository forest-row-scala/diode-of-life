package gameoflife.model

object Test {
  def main(args: Array[String]) {
    val m: Matrix = Matrix(5, 5,
      List(
        List(false, false, false, false, false),
        List(false, false, true, false, false),
        List(false, false, true, false, false),
        List(false, false, true, false, false),
        List(false, false, false, false, false)
      ))

    println(m.rep.mkString("\n"))
    println
    println(m.nextState.rep.mkString("\n"))
    println
    println(m.nextState.nextState.rep.mkString("\n"))
  }
}
