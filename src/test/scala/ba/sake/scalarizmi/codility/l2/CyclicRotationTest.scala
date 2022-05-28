package ba.sake.scalarizmi.codility.l2

import ba.sake.scalarizmi.TestUtils._

class CyclicRotationTest extends FlatSpec {

  val Solutions = List(CyclicRotation1, CyclicRotation2)

  Solutions.foreach { solution =>
    solution.toString should "rotate array right k places" in {
      List(
        (Array(3, 8, 9, 7, 6), 3) -> Array(9, 7, 6, 3, 8),
        (Array(1, 2, 3, 4), 4) -> Array(1, 2, 3, 4),
        (Array(5, -1000), 1) -> Array(-1000, 5),
        (Array.empty[Int], 0) -> Array.empty[Int]
      ).foreach {
        case ((arr, k), expected) =>
          val sol = solution.solution(arr, k)
          sol should equal(expected)
      }
    }
  }

}
