package ba.sake.scalarizmi.codility.l16

object CoinChangingGreedy extends App {
  val coins = List(1, 2, 5)
  val c = new CoinChangingGreedy
  println(c.getCoins(coins, 6).sortBy(-_._1))
}

class CoinChangingGreedy {
  def getCoins(coins: List[Int], amount: Int) = {

    var result = List.empty[(Int, Int)]
    var tmpAmount = amount
    for (coin <- coins.reverse) {
      result = coin -> (tmpAmount / coin) :: result
      tmpAmount %= coin
    }
    result
  }
}
