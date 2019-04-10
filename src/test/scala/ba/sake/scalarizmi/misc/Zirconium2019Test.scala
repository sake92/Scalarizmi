package ba.sake.scalarizmi.misc

import org.scalatest.Matchers._
import org.scalatest._

class Zirconium2019Test extends FlatSpec {

  val Solutions = List(Zirconium2019_1)

  Solutions.foreach { solution =>
    solution.toString should "find missing element" in {
      List(
        (Array(4, 2, 1), Array(2, 5, 3), 2) -> 10,
        (Array(4, 2, 6), Array(2, 5, 7), 2) -> 15
      ).foreach { case ((a, b, f), expected) =>
        val sol = solution.solution(a, b, f)
        sol should equal(expected)
      }
    }
  }
}