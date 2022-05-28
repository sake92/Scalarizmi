package ba.sake.scalarizmi.misc

import scala.collection.mutable.ArrayBuffer

object o extends App {

  val e = new Erathostenes()
  println(e.sieve(200).zipWithIndex.filter(_._1).map(_._2))
}

class Erathostenes {

  def sieve(n: Int): Seq[Boolean] = {

    val result = ArrayBuffer.fill(n)(true)
    result(0) = false // not prime
    result(1) = false // not prime

    for {
      i <- 2 to Math.sqrt(n).toInt
      j <- (i * i) until n by i
    } { // start from i^2 coz it's already sieved! :)
      result(j) = false
    }

    result.toSeq
  }
}
