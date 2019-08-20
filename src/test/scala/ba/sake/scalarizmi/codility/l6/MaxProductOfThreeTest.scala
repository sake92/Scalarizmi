package ba.sake.scalarizmi.codility.l6

import org.scalatest.Matchers._
import org.scalatest._

class MaxProductOfThreeTest extends FlatSpec {

  val Solutions = List(MaxProductOfThree1)

  Solutions.foreach { solution =>
    solution.toString should "find max product of three numbers" in {
      List(
        Array(1, 2, 3) -> 6,
        Array(-3, 1, 2, -2, 5, 6) -> 60,
        Array(-5, 5, -5, 4) -> 125,
        Array(4, 7, 3, 2, 1, -3, -5) -> 105
      ).foreach {
        case (arr, expected) =>
          val sol = solution.solution(arr)
          sol should equal(expected)
      }
    }
  }

}
