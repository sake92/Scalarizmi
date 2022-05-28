package ba.sake.scalarizmi.codility.l3

import ba.sake.scalarizmi.TestUtils._

class PermMissingElemTest extends FlatSpec {

  val Solutions = List(PermMissingElem1)

  Solutions.foreach { solution =>
    solution.toString should "find missing element" in {
      List(
        Array.empty[Int] -> 1,
        Array(1, 2, 3, 5) -> 4,
        Array(1) -> 2,
        Array(2) -> 1
      ).foreach {
        case (array, expected) =>
          val sol = solution.solution(array)
          sol should equal(expected)
      }
    }
  }
}
