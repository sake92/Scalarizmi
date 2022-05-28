package ba.sake.scalarizmi.codility.l7

import ba.sake.scalarizmi.TestUtils._

class StoneWallTest extends FlatSpec {

  val Solutions = List(StoneWall1)

  Solutions.foreach { solution =>
    solution.toString should "check brackets nesting" in {
      List(
        Array(8, 8, 5, 7, 9, 8, 7, 4, 8) -> 7
      ).foreach {
        case (arr, expected) =>
          val sol = solution.solution(arr)
          sol should equal(expected)
      }
    }
  }

}
