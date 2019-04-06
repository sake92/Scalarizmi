package ba.sake.scalarizmi.misc

import org.scalatest.Matchers._
import org.scalatest._

class BinaryGapTest extends FlatSpec {

  val Solutions = List(BinaryGap1, BinaryGap2)

  Solutions.foreach { solution =>
    solution.toString should "find longest sequence of zeros in binary representation of an integer" in {
      List(
        "10100100000" -> 2,
        "10100100001" -> 4,
        "10100010100" -> 3,
        "00010100000" -> 1
      ).foreach { case (n, expected) =>
        val sol = solution.solution(Integer.parseInt(n, 2))
        sol should equal(expected)
      }
    }
  }

}
