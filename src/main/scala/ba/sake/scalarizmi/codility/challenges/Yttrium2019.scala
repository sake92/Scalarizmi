package ba.sake.scalarizmi.codility.challenges

import scala.collection.mutable

// Find the shortest substring of S that, after removal, leaves S containing exactly K different characters.
trait Yttrium2019 {
  def solution(s: String, k: Int): Int
}

object Yttrium2019_1 extends Yttrium2019 {

  def solution(s: String, k: Int): Int = {

    val uniqueCharListLeft = uniqueCharList(s, k)
    val uniqueCharListRight = uniqueCharList(s.reverse, k)
    val allCharCombinations = for (i <- 0 to k) yield {
      val leftChars = uniqueCharListLeft.take(i) // always unique
      val rightChars = uniqueCharListRight.filterNot(leftChars.contains).take(k - i)
      (leftChars ++ rightChars).toSet
    }

    val results = allCharCombinations.toSet
      .map { diffChars: Set[Char] =>
        possibleSolution(s, k, diffChars)
      }
      .toVector
      .sorted

    results.dropWhile(_ < 0).headOption.getOrElse(-1)
  }

  private def possibleSolution(s: String, k: Int, diffChars: Set[Char]): Int = {

    var diffCharsRemaining = Set.empty[Char]

    def dropF(c: Char): Boolean = {
      if (diffChars(c)) {
        diffCharsRemaining += c
        true
      } else false
    }

    val res = s.dropWhile(dropF).reverse.dropWhile(dropF)

    if (diffCharsRemaining.size == k) res.length // if remaining==k solution is ok
    else -1
  }

  private def uniqueCharList(str: String, k: Int): List[Char] = {
    val uniqueSet = mutable.Set.empty[Char]
    val uniqueList = mutable.ListBuffer.empty[Char]
    var i = 0
    while (uniqueSet.size < k && i < str.size) {
      val c = str(i)
      if (!uniqueSet(c)) {
        uniqueSet += c
        uniqueList += c
      }
      i += 1
    }
    uniqueList.toList
  }
}
