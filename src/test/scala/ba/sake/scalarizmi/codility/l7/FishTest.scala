package ba.sake.scalarizmi.codility.l7

import ba.sake.scalarizmi.TestUtils._

class FishTest extends FlatSpec {

  val Solutions = List(Fish1)

  Solutions.foreach { solution =>
    solution.toString should "count alive fish" in {
      List(
        (Array(4, 3, 2, 1, 5), Array(0, 1, 0, 0, 0)) -> 2
      ).foreach {
        case ((a, b), expected) =>
          val sol = solution.solution(a, b)
          sol should equal(expected)
      }
    }
  }

}
