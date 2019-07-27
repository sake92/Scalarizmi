package ba.sake.scalarizmi.counting

import org.scalatest.Matchers._
import org.scalatest._

class MaxCountersTest extends FlatSpec {

  val Solutions = List(MaxCounters1)

  Solutions.foreach { solution =>
    solution.toString should "calculate values of counters after applying all alternating operations" in {
      List(
        (5, Array(3, 4, 4, 6, 1, 4, 4)) -> Array(3, 2, 2, 4, 2),
        (1, Array(1)) -> Array(1),
        (5, Array(6, 6, 6, 6, 6, 6)) -> Array(0, 0, 0, 0, 0),
        (5, Array(6, 6, 6, 1, 6, 6, 6)) -> Array(1, 1, 1, 1, 1)
      ).foreach {
        case ((n, arr), expected) =>
          val sol = solution.solution(n, arr)
          sol should equal(expected)
      }
    }
  }

}
