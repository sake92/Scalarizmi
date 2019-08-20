package ba.sake.scalarizmi.codility.l5

import org.scalatest.Matchers._
import org.scalatest._

class PassingCarsTest extends FlatSpec {

  val Solutions = List(PassingCars1)

  Solutions.foreach { solution =>
    solution.toString should "count the number of passing cars on the road" in {
      List(
        Array(0, 1, 0, 1, 1) -> 5
      ).foreach {
        case (arr, expected) =>
          val sol = solution.solution(arr)
          sol should equal(expected)
      }
    }
  }

}
