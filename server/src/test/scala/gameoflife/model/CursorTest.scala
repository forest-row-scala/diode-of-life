package gameoflife.model

import org.scalatest.{FlatSpec, Matchers}

class CursorTest extends FlatSpec with Matchers {
  "Cursor.n" should "move north" in {
    Cursor(1, 1, 10, 10).n shouldBe Cursor(1, 0, 10, 10)
    Cursor(1, 0, 10, 10).n shouldBe Cursor(1, 9, 10, 10)
  }

  it should "move south" in {
    Cursor(1, 1, 10, 10).s shouldBe Cursor(1, 2, 10, 10)
    Cursor(1, 9, 10, 10).s shouldBe Cursor(1, 0, 10, 10)
  }

  it should "move east" in {
    Cursor(1, 1, 10, 10).e shouldBe Cursor(2, 1, 10, 10)
    Cursor(9, 1, 10, 10).e shouldBe Cursor(0, 1, 10, 10)
  }

  it should "move west" in {
    Cursor(1, 1, 10, 10).w shouldBe Cursor(0, 1, 10, 10)
    Cursor(0, 1, 10, 10).w shouldBe Cursor(9, 1, 10, 10)
  }

  "Cursor.limitRange" should "correctly limit range" in {
    Cursor.limitRange(13, 7) shouldBe 6
    Cursor.limitRange(5, 7) shouldBe 5
    Cursor.limitRange(-5, 7) shouldBe 2
    Cursor.limitRange(-13, 7) shouldBe 1
  }
}
