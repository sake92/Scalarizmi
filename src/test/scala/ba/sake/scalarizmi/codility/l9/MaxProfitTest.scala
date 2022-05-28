package ba.sake.scalarizmi.codility.l9

import ba.sake.scalarizmi.TestUtils._

class MaxProfitTest extends FlatSpec {

  val Solutions = List(MaxProfit1, MaxProfit2)

  Solutions.foreach { solution =>
    solution.toString should "find maximum profit" in {
      List(
        Array(23171, 21011, 21123, 21366, 21013, 21367) -> 356, // 356 = A[5] − A[1] = 21367 − 21011
        Array[Int]() -> 0,
        Array(1) -> 0,
        Array(1, 2) -> 1,
        Array(2, 1) -> 0,
        Array(98, 100, 1, 55) -> 54
      ).foreach {
        case (arr, expected) =>
          val sol = solution.solution(arr)
          sol should equal(expected)
      }
    }
  }

}
