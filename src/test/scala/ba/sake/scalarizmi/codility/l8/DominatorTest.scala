package ba.sake.scalarizmi.codility.l8

import ba.sake.scalarizmi.TestUtils._

class DominatorTest extends FlatSpec {

  val Solutions = List(Dominator1)

  Solutions.foreach { solution =>
    solution.toString should "find dominator index, if it has one" in {
      List(
        Array(3, 4, 3, 2, 3, -1, 3, 3) -> Set(0, 2, 4, 6, 7), // returns ONE OF POSSIBLE INDICES
        Array(3, 4, 3, 2) -> Set(-1)
      ).foreach {
        case (arr, expected) =>
          val sol = solution.solution(arr)
          expected should contain(sol)
      }
    }
  }

}
