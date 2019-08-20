package ba.sake.scalarizmi.codility.l10

import org.scalatest.Matchers._
import org.scalatest._

class MinPerimeterRectangleTest extends FlatSpec {

  val Solutions = List(MinPerimeterRectangle1)

  Solutions.foreach { solution =>
    solution.toString should "find min perimeter rectangle" in {
      List(
        30 -> 22, // coz (5,6)
        16 ->   16, // coz (4,4)
        10 ->14, // coz (5,2)
      ).foreach {
        case (arr, expected) =>
          val sol = solution.solution(arr)
          sol should equal(expected)
      }
    }
  }

}
