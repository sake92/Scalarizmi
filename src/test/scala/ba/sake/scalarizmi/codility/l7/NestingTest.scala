package ba.sake.scalarizmi.codility.l7

import org.scalatest.Matchers._
import org.scalatest._

class NestingTest extends FlatSpec {

  val Solutions = List(Nesting1, Nesting2)

  Solutions.foreach { solution =>
    solution.toString should "check braces nesting" in {
      List(
        "(()(())())" -> 1, // true
        "())" -> 0, //  // false
        "" -> 1,
        "(" -> 0,
        ")" -> 0,
        ")(" -> 0
      ).foreach {
        case (str, expected) =>
          val sol = solution.solution(str)
          sol should equal(expected)
      }
    }
  }

}
