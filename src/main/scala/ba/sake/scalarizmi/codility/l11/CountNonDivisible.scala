package ba.sake.scalarizmi.codility.l11

object nondiv extends App {
  println((
    CountNonDivisible.solution(Array(3, 1, 2, 3, 6)).toList, //  [2, 4, 3, 2, 0]
    CountNonDivisible.solution(Array(2)).toList //  [0]
  ))
}

// https://github.com/charles-wangkai/codility/blob/master/CountNonDivisible.java
object CountNonDivisible {

  def solution(a: Array[Int]): Array[Int] = {
    println("+" * 30)
    // count how many times every number appears
    val counts = Array.ofDim[Int](2 * a.length + 1) // given in lesson description
    for (elem <- a) {
      counts(elem) += 1
    }
    println("counts: " + counts.toList)

    // find number of divisors
    val largest = a.max
    val divisorCounts = Array.ofDim[Int](largest + 1)
    for {
      i <- 1 to Math.sqrt(largest).toInt // only up to root(max)
      j <- i * i to largest by i
    } {
      println(s"i=$i, j=$j")

      divisorCounts(j) += counts(i)
      if (j != i * i) { // dont count sqrt(largest) twice! :)
        divisorCounts(j) += counts(j / i) // count other divisor also
      }

    }
    println("divisorCounts:" + divisorCounts.toList)

    // count
    val result = Array.ofDim[Int](a.length)
    for (i <- result.indices) {
      result(i) = a.length - divisorCounts(a(i))
    }
    result
  }
}
