package ba.sake.scalarizmi.codility.l12

object comm extends App {
  val c = new CommonPrimeDivisors
  println(
    c.solution(
      Array(15, 10, 3),
      Array(75, 30, 5)
    )) // 1, just the (15,75) pair
}

class CommonPrimeDivisors {

  def solution(a: Array[Int], b: Array[Int]): Int = {
    var count = 0
    for (i <- a.indices) {
      if (haveSamePrimeDivisors(a(i), b(i))) {
        count += 1
      }
    }
    count
  }

  /*
    a = gcd * k
    b = gcd * j

    In order to have same divisors, k must divide b AND j must divide a !
    E.g. in case od (10,30) the number 3 doesn't divide 10... :)
   */
  private def haveSamePrimeDivisors(a: Int, b: Int): Boolean = {

    val gcdTotal = euclid(a, b)
    var aRem = a
    var bRem = b

    var gcdA = 0
    while (gcdA != 1) {
      gcdA = euclid(aRem, gcdTotal)
      aRem = aRem / gcdA
    }

    var gcdB = 0
    while (gcdB != 1) {
      gcdB = euclid(bRem, gcdTotal)
      bRem = bRem / gcdB
    }

    println(s"arem=$aRem, brem=$bRem")
    (aRem == 1) && (bRem == 1)
  }

  private def euclid(a: Int, b: Int): Int = {
    val rem = a % b
    if (rem == 0) b
    else euclid(b, rem)
  }
}
