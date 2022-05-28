package ba.sake.scalarizmi.codility.l3

import ba.sake.scalarizmi.TestUtils._

class TapeEquilibriumTest extends FlatSpec {

  val Solutions = List(TapeEquilibrium1)

  Solutions.foreach { solution =>
    solution.toString should "find minimum absolute difference between sums of left and right subarray" in {
      List(
        Array(3, 1, 2, 4, 3) -> 1,
        Array(1, 2) -> 1
      ).foreach {
        case (array, expected) =>
          val sol = solution.solution(array)
          sol should equal(expected)
      }
    }
  }
}
