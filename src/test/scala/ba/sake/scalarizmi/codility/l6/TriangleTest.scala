package ba.sake.scalarizmi.codility.l6

import org.scalatest.Matchers._
import org.scalatest._

class TriangleTest extends FlatSpec {

  val Solutions = List(Triangle1)

  Solutions.foreach { solution =>
    solution.toString should "determine whether a triangle can be built from a given set of edges" in {
      List(
        Array(10, 2, 5, 1, 8, 20, -50) -> 1, // true
        Array(Int.MaxValue - 2, Int.MaxValue - 1, Int.MaxValue) -> 1, // handle overflow...
        Array(1, 2, 5) -> 0
      ).foreach {
        case (arr, expected) =>
          val sol = solution.solution(arr)
          sol should equal(expected)
      }
    }
  }

}
