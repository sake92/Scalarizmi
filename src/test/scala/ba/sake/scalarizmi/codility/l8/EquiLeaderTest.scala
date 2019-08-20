package ba.sake.scalarizmi.codility.l8

import org.scalatest.Matchers._
import org.scalatest._

class EquiLeaderTest extends FlatSpec {

  val Solutions = List(EquiLeader1, EquiLeader2)

  Solutions.foreach { solution =>
    solution.toString should "find # of equileaders" in {
      List(
        Array(4, 3, 4, 4, 4, 2) -> 2,
        Array[Int]() -> 0,
        Array(4) -> 0,
        Array(4, 4) -> 1
      ).foreach {
        case (arr, expected) =>
          val sol = solution.solution(arr)
          sol should equal(expected)
      }
    }
  }

}
