package ba.sake.scalarizmi.codility.l4

// Find the smallest positive integer that does not occur in a given sequence.
trait MissingInteger {
  def solution(a: Array[Int]): Int
}

object MissingInteger1 extends MissingInteger {
  
  def solution(a: Array[Int]): Int = {
    val hasN = Array.fill[Boolean](1000000)(false)
    for (elem <- a) {
      if (elem >= 1)
        hasN(elem - 1) = true // mark every seen element
    }
    hasN.indexWhere(!_) + 1 // find first that's missing
  }
}
