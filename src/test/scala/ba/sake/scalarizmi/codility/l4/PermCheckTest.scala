package ba.sake.scalarizmi.codility.l4
import org.scalatest.Matchers._
import org.scalatest._

class PermCheckTest extends FlatSpec {

  val Solutions = List(PermCheck1)

  Solutions.foreach { solution =>
    solution.toString should "check whether array is a permutation" in {
      List(
        Array(4, 1, 3, 2) -> 1,
        Array(4, 1, 3) -> 0
      ).foreach {
        case (arr, expected) =>
          val sol = solution.solution(arr)
          sol should equal(expected)
      }
    }
  }

}
