package ba.sake.scalarizmi.codility.l4

import org.scalatest.Matchers._
import org.scalatest._

class MissingIntegerTest extends FlatSpec {

  val Solutions = List(MissingInteger1)

  Solutions.foreach { solution =>
    solution.toString should "find the smallest positive integer that does not occur in a given sequence" in {
      List(
        Array(1, 3, 6, 4, 1, 2) -> 5,
        Array(1, 2, 3) -> 4,
        Array(-1, -3) -> 1,
        Array(4, 5, 6, 2) -> 1,
        Array(1) -> 2
      ).foreach {
        case (arr, expected) =>
          val sol = solution.solution(arr)
          sol should equal(expected)
      }
    }
  }

}
