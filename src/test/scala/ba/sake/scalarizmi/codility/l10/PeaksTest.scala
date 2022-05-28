package ba.sake.scalarizmi.codility.l10

import ba.sake.scalarizmi.TestUtils._

class PeaksTest extends FlatSpec {

  val Solutions = List(Peaks1)

  Solutions.foreach { solution =>
    solution.toString should "find max # of peaks" in {
      List(
        Array(1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2) -> 3,
        Array(1) -> 0,
        Array(1, 2) -> 0,
        Array(1, 2, 3) -> 0,
        Array(1, 3, 2) -> 1,
        Array(1, 3, 2, 1) -> 1,
      ).foreach {
        case (arr, expected) =>
          val sol = solution.solution(arr)
          sol should equal(expected)
      }
    }
  }

}
