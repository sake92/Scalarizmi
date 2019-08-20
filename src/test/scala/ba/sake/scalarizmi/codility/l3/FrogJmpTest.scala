package ba.sake.scalarizmi.codility.l3

import org.scalatest.Matchers._
import org.scalatest._

class FrogJmpTest extends FlatSpec {

  val Solutions = List(FrogJmp1, FrogJmp2)

  Solutions.foreach { solution =>
    solution.toString should "find minimal number of jumps frog must perform to reach its target" in {
      List(
        (10, 85, 30) -> 3,
        (5, 2, 10) -> 0
      ).foreach {
        case ((x, y, d), expected) =>
          val sol = solution.solution(x, y, d)
          sol should equal(expected)
      }
    }
  }
}
