package ba.sake.scalarizmi.codility.l10

import ba.sake.scalarizmi.TestUtils._

class CountFactorsTest extends FlatSpec {

  val Solutions = List(CountFactors1)

  Solutions.foreach { solution =>
    solution.toString should "count factors" in {
      List(
        24 -> 8,
        10 -> 4,
        15 -> 4,
        16 -> 5,
        1 -> 1,
        2 -> 2
      ).foreach {
        case (arr, expected) =>
          val sol = solution.solution(arr)
          sol should equal(expected)
      }
    }
  }

}
