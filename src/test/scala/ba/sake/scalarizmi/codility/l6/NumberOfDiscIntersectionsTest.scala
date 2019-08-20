package ba.sake.scalarizmi.codility.l6

import org.scalatest.Matchers._
import org.scalatest._

class NumberOfDiscIntersectionsTest extends FlatSpec {

  val Solutions = List(NumberOfDiscIntersections1)

  Solutions.foreach { solution =>
    solution.toString should "count number of intersections" in {
      List(
        Array(1, 5, 2, 1, 4, 0) -> 11,
        Array(1, 1, 1) -> 3,
        Array(1, 2147483647, 0) -> 2
      ).foreach {
        case (arr, expected) =>
          val sol = solution.solution(arr)
          sol should equal(expected)
      }
    }
  }

}
