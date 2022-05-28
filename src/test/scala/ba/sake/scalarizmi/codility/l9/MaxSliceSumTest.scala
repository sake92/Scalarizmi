package ba.sake.scalarizmi.codility.l9

import ba.sake.scalarizmi.TestUtils._

class MaxSliceSumTest extends FlatSpec {

  val Solutions = List(MaxSliceSum1)

  Solutions.foreach { solution =>
    solution.toString should "find max slice sum" in {
      List(
        Array(3, 2, -6, 4, 0) -> 5,
        Array(3, 2, -1, 2) -> 6,
        Array(3) -> 3,
        Array(-3) -> -3,
        Array(-3, -7) -> -3,
        Array(-7, -3) -> -3
      ).foreach {
        case (arr, expected) =>
          val sol = solution.solution(arr)
          sol should equal(expected)
      }
    }
  }

}
