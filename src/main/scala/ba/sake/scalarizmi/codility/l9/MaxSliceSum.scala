package ba.sake.scalarizmi.codility.l9

trait MaxSliceSum {

  def solution(a: Array[Int]): Int
}

// a version of Kadane's algorithm
object MaxSliceSum1 extends MaxSliceSum {

  def solution(a: Array[Int]): Int = {

    var maxCurrentSum = 0
    var maxTotalSum = a(0)
    for (elem <- a) {
      maxCurrentSum += elem
      if (maxCurrentSum > maxTotalSum) {
        maxTotalSum = maxCurrentSum
      }
      if (maxCurrentSum < 0) { // if we go negative, it's better to start from 0
        maxCurrentSum = 0
      }
    }
    maxTotalSum
  }

}
