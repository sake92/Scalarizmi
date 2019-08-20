package ba.sake.scalarizmi.codility.l6

trait NumberOfDiscIntersections {
  def solution(a: Array[Int]): Int
}

// we count how many circles are "active" when an event occurs
// (new circle starts or old ends)

object NumberOfDiscIntersections1 extends NumberOfDiscIntersections {
  import scala.collection.mutable.ListBuffer // IDK, coulda/shoulda use ArrayBuffer

  def solution(a: Array[Int]): Int = {
    if (a.size < 2) return 0

    // remember events at indices where circle starts and ends
    val events = ListBuffer.empty[(Int, Int)]
    for ((n, i) <- a.zipWithIndex) {
      var left = i - n
      var right = i + n
      if (left > i) left = Int.MinValue // if overflow
      if (right < i) right = Int.MaxValue // if overflow
      events += (left -> 1)   // circle start
      events += (right -> -1) // circle end
    }

    // VERY important, +1 MUST COME BEFORE -1 :D
    val eventsSorted = events.sortBy(t => (t._1, -t._2))

    var currCount = 0
    var total = 0
    for ((_, e) <- eventsSorted) {

      if (e > 0) {
        total += currCount
      }
      currCount += e

      if (total > 10e6) return -1 // overflow
    }
    total
  }
}
