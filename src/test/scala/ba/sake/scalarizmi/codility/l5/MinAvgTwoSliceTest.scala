package ba.sake.scalarizmi.codility.l5

import ba.sake.scalarizmi.TestUtils._

class MinAvgTwoSliceTest extends FlatSpec {

  val Solutions = List(MinAvgTwoSlice1)

  Solutions.foreach { solution =>
    solution.toString should "find minimal average of any slice containing at least two elements" in {
      List(
        Array(4, 2, 2, 5, 1, 5, 8) -> 1
      ).foreach {
        case (arr, expected) =>
          val sol = solution.solution(arr)
          sol should equal(expected)
      }
    }
  }

}
