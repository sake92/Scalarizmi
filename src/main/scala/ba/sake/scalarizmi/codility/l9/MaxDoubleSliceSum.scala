package ba.sake.scalarizmi.codility.l9

trait MaxDoubleSliceSum {
  def solution(a: Array[Int]): Int
}

object MaxDoubleSliceSum1 extends MaxDoubleSliceSum {

  // stolen from https://rafal.io/posts/codility-max-double-slice-sum.html
  def solution(a: Array[Int]): Int = {
    val length = a.length

    val K1 = Array.ofDim[Int](length)
    val K2 = Array.ofDim[Int](length)

    for (i <- 1 until length) {
      K1(i) = Math.max(K1(i - 1) + a(i), 0)
    }
    for (i <- (length - 2) until 1 by -1) {
      K2(i) = Math.max(K2(i + 1) + a(i), 0)
    }

    var max = 0
    for (i <- 1 until length - 1) {
      max = Math.max(K1(i - 1) + K2(i + 1), max)
    }

    max
  }
}
