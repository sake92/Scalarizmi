package ba.sake.scalarizmi.codility.l9

import ba.sake.scalarizmi.TestUtils._

class MaxDoubleSliceSumTest extends FlatSpec {

  val Solutions = List(MaxDoubleSliceSum1)

  Solutions.foreach { solution =>
    solution.toString should "find maximum sum of double slice" in {
      List(
        Array(3, 2, 6, -1, 4, 5, -1, 2) -> 17
      ).foreach {
        case (arr, expected) =>
          val sol = solution.solution(arr)
          sol should equal(expected)
      }
    }
  }

}
