package ba.sake.scalarizmi.codility.l10

trait CountFactors {
  def solution(n: Int): Int
}

object CountFactors1 extends CountFactors {

  def solution(n: Int): Int = {

    if (n == 1) 1
    else {
      var count = 2 // 1 and n
      val sqrt = Math.sqrt(n).toInt
      for (i <- 2 to sqrt) { // up to sqrt, but count by 2 factors
        if (n % i == 0)
          count += 2

      }
      if (sqrt * sqrt == n) {
        count -= 1 // if it's square, that's only one number, not two.. :)
      }
      count
    }
  }

}
