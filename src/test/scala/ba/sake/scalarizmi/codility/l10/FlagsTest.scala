package ba.sake.scalarizmi.codility.l10

import ba.sake.scalarizmi.TestUtils._

class FlagsTest extends FlatSpec {

  val Solutions = List(Flags1)

  Solutions.foreach { solution =>
    solution.toString should "count factors" in {
      List(
        Array(1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2) -> 3,
        Array(1) -> 0,
        Array(1, 2) -> 0,
        Array(1, 2, 3, 5) -> 0,
        Array(1, 3, 2) -> 1,
        Array(0, 0, 0, 0, 0, 1, 0, 1, 0, 1) -> 2
      ).foreach {
        case (arr, expected) =>
          val sol = solution.solution(arr)
          sol should equal(expected)
      }
    }
  }

}
