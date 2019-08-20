package ba.sake.scalarizmi.codility.l5

import org.scalatest.Matchers._
import org.scalatest._

class GenomicRangeQueryTest extends FlatSpec {

  val Solutions = List(GenomicRangeQuery1)

  Solutions.foreach { solution =>
    solution.toString should "find minimal nucleotide" in {
      List(
        ("CAGCCTA", Array(2, 5, 0), Array(4, 5, 6)) -> Array(2, 4, 1),
        ("A", Array(0), Array(0)) -> Array(1),
        ("AC", Array(0, 0, 1), Array(0, 1, 1)) -> Array(1, 1, 2)
      ).foreach {
        case ((s, p, q), expected) =>
          val sol = solution.solution(s, p, q)
          sol should equal(expected)
      }
    }
  }

}
