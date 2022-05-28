package ba.sake.scalarizmi.codility.l15

object MinAbsSumOfTwo extends App {
  val s = new MinAbsSumOfTwo
  println((
    s.solution(Array(1, 4, -3)), // 1 = 4-3
    s.solution(Array(-8, 4, 5, -10, 3)), // 3 = 8-5
    s.solution(Array(5)), // 10 = 5+5
    s.solution(Array(5, 7, -5)) // 0 = 5-5
  ))
}

class MinAbsSumOfTwo {

  def solution(a: Array[Int]): Int = {
    println("---------------")
    val sortedInput = a.sorted
    var left = 0
    var right = a.length - 1
    var minAbsSum = Int.MaxValue
    while (left <= right) {
      val currentSum = sortedInput(left) + sortedInput(right)
      if (currentSum.abs < minAbsSum) {
        minAbsSum = currentSum.abs
      }
      if (currentSum == 0) return 0 // cant be <0
      else if (currentSum < 0) left += 1
      else right -= 1
      println(s"left=$left right=$right curr=$currentSum")
    }
    minAbsSum
  }
}
