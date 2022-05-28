package ba.sake.scalarizmi.codility.l16

object TieRopes extends App {
  val t = new TieRopes
  println((
    t.solution(4, Array(1, 2, 3, 4, 1, 1, 3)), // 3
    t.solution(4, Array(1, 2, 3, 4, 1, 1, 3, 1)), // 3, tests edge case
    t.solution(4, Array(1)) // 0
  ))
}

class TieRopes {
  def solution(k: Int, a: Array[Int]): Int = {

    var total = 0
    var i = 0
    while (i < a.length) {
      var tmp = 0
      while (i < a.length && tmp < k) { // add while you can
        tmp += a(i)
        i += 1
      }
      if (tmp >= k) { // count if ok
        total += 1
      }
    }
    total
  }
}
