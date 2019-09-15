package ba.sake.scalarizmi.codility.l16

object MaxNonoverlappingSegments extends App {
  val m = new MaxNonoverlappingSegments
  println(
    m.solution(Array(1, 3, 7, 9, 9), Array(5, 6, 8, 9, 10)) // 3
  )
}

class MaxNonoverlappingSegments {
  def solution(a: Array[Int], b: Array[Int]): Int = {

    var total = 0
    var lastEnd = -1
    for (i <- a.indices) {
      if (a(i) > lastEnd) {
        println(s"i=$i")
        total += 1 // count if ok
        lastEnd = b(i)
      }
    }
    total
  }
}
