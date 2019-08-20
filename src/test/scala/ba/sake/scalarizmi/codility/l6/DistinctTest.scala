package ba.sake.scalarizmi.codility.l6

import org.scalatest.Matchers._
import org.scalatest._

class DistinctTest extends FlatSpec {

  val Solutions = List(Distinct1)

  Solutions.foreach { solution =>
    solution.toString should "count distinct elements" in {
      List(
        Array(2, 1, 1, 2, 3, 1) -> 3,
        Array[Int]() -> 0,
        Array(66) -> 1
      ).foreach {
        case (arr, expected) =>
          val sol = solution.solution(arr)
          sol should equal(expected)
      }
    }
  }

}
