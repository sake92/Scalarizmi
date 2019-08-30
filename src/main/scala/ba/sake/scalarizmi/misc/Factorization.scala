package ba.sake.scalarizmi.misc

import scala.collection.mutable.ArrayBuffer

object facttttt extends App {
  val f = new Factorization
  println(
    f.smallestPrimeDivisors(20).zipWithIndex
  )

  println(
    f.factorize(20)
  )
}

class Factorization {

  def factorize(n: Int): Seq[Int] = {
    val factors = ArrayBuffer.empty[Int]
    val divisors = smallestPrimeDivisors(n)
    var tmp = n
    while (divisors(tmp) > 0) {
      factors += divisors(tmp)
      tmp /= divisors(tmp)
    }
    factors += tmp // add prime that's left :)
    factors
  }

  def smallestPrimeDivisors(n: Int): Seq[Int] = {

    val result = ArrayBuffer.fill(n + 1)(0)

    for {
      i <- 2 to Math.sqrt(n).toInt
      j <- (i * i) to n by i
    } {
      if (result(j) == 0)
        result(j) = i
    }

    result
  }
}
