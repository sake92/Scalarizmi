package ba.sake.scalarizmi.codility.l12

object choco extends App {
  val c = new ChocolatesByNumbers
  println(c.solution(10, 4))
  println(c.solution(7, 2))
}

// O(log(N + M))
// LCM/n == ... == n/gcd
// LCM (Least Common multiple, Majmanji zajednički sadržalac)
class ChocolatesByNumbers {

  def solution(n: Int, m: Int): Int = {
    val gcd = euclid(n, m)
    n / gcd
  }

  private def euclid(a: Int, b: Int): Int = {
    val rem = a % b
    if (rem == 0) b
    else euclid(b, rem)
  }
}

// uses too much memory, only 62% score
object ChocolatesByNumbers2 {

  def solution(n: Int, m: Int): Int = {
    val eatenChocolates = Array.fill(n)(false)
    println(eatenChocolates.zipWithIndex.toList)
    var numEaten = 0
    var chocoIdx = 0
    while (!eatenChocolates(chocoIdx)) {
      println(s"i=$chocoIdx")
      numEaten += 1
      eatenChocolates(chocoIdx) = true
      chocoIdx = (chocoIdx + m) % n
    }
    numEaten
  }
}
