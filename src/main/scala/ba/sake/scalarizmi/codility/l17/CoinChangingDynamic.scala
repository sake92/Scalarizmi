package ba.sake.scalarizmi.codility.l17

object CoinChangingDynamic extends App {
  val c = new CoinChangingDynamic
  println(
    "coins: 1,3,4\n" +
      c.solution(Array(1, 3, 4), 6).zipWithIndex.map(_.swap).toList
  )
}

class CoinChangingDynamic {
  def solution(allCoins: Array[Int], k: Int): Array[Int] = {
    val c = allCoins.filter(_ <= k).sorted
    val rowNum = c.length + 1
    val colNum = k + 1
    val dp = Array.fill[Int](rowNum, colNum)(Int.MaxValue)

    // to pay 0 we need 0 coins
    dp.indices.foreach { i =>
      dp(i)(0) = 0
    }

    for (i <- 1 until rowNum) {
      // copy solutions for those SMALLER than COIN
      for (j <- 0 to c(i - 1)) {
        dp(i)(j) = dp(i - 1)(j)
      }
      // try better solution for BIGGER_OR_EQUAL to COIN
      for (j <- c(i - 1) until colNum) {
        val newSolution = dp(i)(j - c(i - 1)) + 1
        val prevSolution = dp(i - 1)(j)
        dp(i)(j) = newSolution min prevSolution
      }
    }

    dp(c.length)
  }
}
