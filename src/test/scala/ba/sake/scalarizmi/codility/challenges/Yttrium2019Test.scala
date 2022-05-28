package ba.sake.scalarizmi.codility.challenges

import ba.sake.scalarizmi.TestUtils._

class Yttrium2019Test extends FlatSpec {

  val Solutions = List(Yttrium2019_1)

  Solutions.foreach { solution =>
    solution.toString should "find shortest substring to remove, leaving K different characters" in {
      List(
        ("abaacbca", 2) -> 3,
        ("aabcabc", 1) -> 5,
        ("zaaaa", 1) -> 1,
        ("aaaa", 2) -> -1,
        ("b", 1) -> 0
      ).foreach {
        case ((str, k), expected) =>
          val sol = solution.solution(str, k)
          sol should equal(expected)
      }
    }
  }
}
