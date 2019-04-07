package ba.sake.scalarizmi.misc

import org.scalatest._
import org.scalatest.Matchers._

class OddOccurrencesInArrayTest extends FlatSpec {

  val Solutions = List(OddOccurrencesInArraySolution1)

  Solutions.foreach { solution =>
    solution.toString should "only unpaired integer in non-empty array" in {
      List(
        Array(9, 3, 9, 3, 9, 7, 9) -> 7,
        Array(7, 3, 7, 3, 9, 7, 9) -> 7,
        Array(5) -> 5
      ).foreach { case (array, expected) =>
        val sol = solution.solution(array)
        sol should equal(expected)
      }
    }
  }
}
