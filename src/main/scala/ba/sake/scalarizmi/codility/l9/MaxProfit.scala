package ba.sake.scalarizmi.codility.l9

object MaxProfitApp extends App {
  println(

  )
}


trait MaxProfit {

  def solution(a: Array[Int]): Int
  }

// - move minimum price dinamically if we find better
// - calculate new possible max diff... :)
object MaxProfit1 extends MaxProfit {
  def solution(a: Array[Int]): Int = {
    if (a.length <= 1) return 0

    var minPrice = a(0)
    var maxProfit = 0
    for (i <- 1 until a.length) {
      if (a(i) < minPrice) { // case 1: no increase -> no need to calculate max
        minPrice = a(i)
      } else { // case 2: maybe new max
        val curProfit = a(i) - minPrice
        if (curProfit > maxProfit) { // update max profit
          maxProfit = curProfit
        }
      }

    }
    maxProfit
  }
}

object MaxProfit2 extends MaxProfit{

  def solution(a: Array[Int]): Int = {
    val length = a.length
    if (length <= 1) 0
    else {
      val diffs = a.sliding(2).map { case Array(a1, a2, _*) => a2 - a1 }.toArray

      val maxProfit = maxSliceSum(diffs)
      if (maxProfit > 0) maxProfit else 0
    }
  }

  private def maxSliceSum(a: Array[Int]): Int = {

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
