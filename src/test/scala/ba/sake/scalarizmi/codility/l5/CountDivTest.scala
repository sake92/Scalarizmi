package ba.sake.scalarizmi.codility.l5

import ba.sake.scalarizmi.TestUtils._

class CountDivTest extends FlatSpec {

  val Solutions = List(CountDiv1)

  Solutions.foreach { solution =>
    solution.toString should "count the number of numbers divisible by k" in {
      List(
        (5, 11, 2) -> 3 // coz 6,8,10
      ).foreach {
        case ((a, b, k), expected) =>
          val sol = solution.solution(a, b, k)
          sol should equal(expected)
      }
    }
  }

}
