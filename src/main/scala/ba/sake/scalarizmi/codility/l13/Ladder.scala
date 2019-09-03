package ba.sake.scalarizmi.codility.l13

object lllll extends App {

  val l = new Ladder
  println(
    l.solution(
        Array(4, 4, 5, 5, 1, 50000),
        Array(3, 2, 4, 3, 1, 3)
      )
      .toList)

}

// 87% ... :'(
// extreme_large  WRONG ANSWER,  got [0, 0, 0, 0, 0, 0, 0,.. expected [890883426, 2, 169097..
class Ladder {
  private val Limit = 50000
  private val Modulo = 1 << 30

  def solution(a: Array[Int], b: Array[Int]): Array[Int] = {

    val fibs = Array.ofDim[Int](Limit + 2)
    fibs(0) = 0
    fibs(1) = 1
    for (i <- 2 to Limit) {
      fibs(i) = fibs(i - 1) + fibs(i - 2)
      fibs(i) %= Modulo // modulo 2^30 (maximum number in B) to avoid overflow
    }

    val res = Array.ofDim[Int](a.length)
    for (i <- a.indices) {
      val twoToB = 1 << b(i)
      res(i) = fibs(a(i) + 1) % twoToB
    }
    res
  }
}
