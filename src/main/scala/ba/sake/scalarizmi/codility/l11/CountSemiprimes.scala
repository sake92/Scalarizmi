package ba.sake.scalarizmi.codility.l11

object countSemiiiiiii extends App {
  println(
    CountSemiprimes
      .solution(
        26,
        Array(1, 4, 16),
        Array(26, 10, 20)
      )
      .toList // [10,4,0]
  )
}

object CountSemiprimes {
  import scala.collection.mutable.ArrayBuffer

  def solution(n: Int, p: Array[Int], q: Array[Int]): Array[Int] = {

    val answers = Array.ofDim[Int](p.length)
    val divisors = smallestPrimeDivisors(n)

    def isSemiPrime(n: Int): Boolean = {
      val divOfN = divisors(n)
      if (divOfN > 0) divisors(n / divOfN) == 0 // next must be prime
      else false
    }

    val numSemiprimesBefore = ArrayBuffer.fill(n + 1)(0) // prefix sums
    for (i <- 1 to n) {
      val semi = if (isSemiPrime(i)) 1 else 0
      numSemiprimesBefore(i) = numSemiprimesBefore(i - 1) + semi
    }
    println(numSemiprimesBefore.zipWithIndex)

    for (i <- p.indices) {
      answers(i) = numSemiprimesBefore(q(i)) - numSemiprimesBefore(p(i) - 1)
    }
    answers
  }

  private def smallestPrimeDivisors(n: Int): Seq[Int] = {
    val result = ArrayBuffer.fill(n + 1)(0)
    for {
      i <- 2 to Math.sqrt(n).toInt
      j <- (i * i) to n by i
    } {
      if (result(j) == 0)
        result(j) = i
    }
    result.toSeq
  }
}
