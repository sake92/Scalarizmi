package ba.sake.scalarizmi.codility.l7

import ba.sake.scalarizmi.TestUtils._

class BracketsTest extends FlatSpec {

  val Solutions = List(Brackets1)

  Solutions.foreach { solution =>
    solution.toString should "check brackets nesting" in {
      List(
        "{[()()]}" -> 1,
        "([)()]" -> 0,
        ")(" -> 0
      ).foreach {
        case (str, expected) =>
          val sol = solution.solution(str)
          sol should equal(expected)
      }
    }
  }

}
