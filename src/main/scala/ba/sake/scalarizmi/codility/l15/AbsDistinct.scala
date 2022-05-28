package ba.sake.scalarizmi.codility.l15

object abssssDist extends App {
  val a = new AbsDistinct
  println((
    a.solution(Array(-5, -3, -1, 0, 0, 3, 6, 6)), // 5
    a.solution(Array(Int.MinValue, Int.MinValue + 1, Int.MaxValue)), // 2, coz MinValue+1==MaxValue
    a.solution(Array(2)), // 1
    a.solution(Array(2, 2, 2)), // 1
    a.solution(Array(2, 2, 2, 2)) // 1
  ))
}

class AbsDistinct {

  def solution(a: Array[Int]): Int = {
    var total = 0
    var left = 0
    var right = a.length - 1
    while (left <= right) {
      val leftValue = a(left)
      val rightValue = a(right)
      while (left + 1 < a.length && leftValue == a(left + 1)) left += 1 // move to last same element
      while (right - 1 >= 0 && rightValue == a(right - 1)) right -= 1 // move to last same element

      if (leftValue == Int.MinValue) {
        left += 1 // special case.. :/
      } else {
        val leftValueAbs = a(left).abs
        val rightValueAbs = a(right).abs
        if (leftValueAbs == rightValueAbs) {
          left += 1
          right -= 1
        } else if (leftValueAbs > rightValueAbs) {
          left += 1
        } else {
          right -= 1
        }
      }
      total += 1
    }
    total
  }
}

// 92%, getting OutOfMemory on one test.. :/
class AbsDistinct2 {

  def solution(a: Array[Int]): Int = {
    var hasMinInt = false
    val distincts = scala.collection.mutable.BitSet.empty
    for (elem <- a) {
      if (elem == Int.MinValue)
        hasMinInt = true // must handle MIN_INT explicitly, coz MinValue.abs==MinValue :)
      else
        distincts add elem.abs
    }
    var total = distincts.size
    if (hasMinInt) total += 1
    total
  }
}
