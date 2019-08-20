package ba.sake.scalarizmi.codility.l4
import org.scalatest.Matchers._
import org.scalatest._

class FrogRiverOneTest extends FlatSpec {

  val Solutions = List(FrogRiverOne1)

  Solutions.foreach { solution =>
    solution.toString should "find the earliest time when a frog can jump to the other side of a river" in {
      List(
        (5, Array(1, 3, 1, 4, 2, 3, 5, 4)) -> 6,
        (4, Array(2, 1, 3)) -> -1,
        (2, Array(2, 2, 2, 2, 2)) -> -1,
        (3, Array(1, 3, 1, 3, 2, 1, 3)) -> 4
      ).foreach {
        case ((n, arr), expected) =>
          val sol = solution.solution(n, arr)
          sol should equal(expected)
      }
    }
  }

}
