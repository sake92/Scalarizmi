package ba.sake.scalarizmi.misc

// Find minimum absolute difference
// between sums of left and right subarray
// NOTE: Array always has 2 elements minimum!
trait TapeEquilibrium {
  def solution(a: Array[Int]): Int
}

object TapeEquilibrium1 extends TapeEquilibrium {

  def solution(a: Array[Int]): Int = {
    // traverse once to get total sum
    // then it's easier to get right sum, just subtract from left
    val totalSum = a.sum
    var leftSum = 0
    var minAbsDiff = Int.MaxValue
    for (elem <- a.init) { // all except last !
      leftSum += elem
      val rightSum = totalSum - leftSum
      val absDiff = Math.abs(leftSum - rightSum)
      if (absDiff < minAbsDiff) minAbsDiff = absDiff
    }
    minAbsDiff
  }
}
