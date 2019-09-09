package ba.sake.scalarizmi.codility.l14

object nailsss extends App {
  val n = new NailingPlanks1
  println(
    n.solution(
      Array(1, 4, 5, 8),
      Array(4, 5, 9, 10),
      Array(4, 6, 7, 10, 2)
    ) // 4
  )

  println(
    n.solution(
      Array(1, 4, 5, 8),
      Array(4, 5, 9, 10),
      Array(8, 6, 7, 10, 2)
    ) // -1, no solution
  )
}

/*
Bisect on the LENGTH OF C (nails provided).
Prefix-sum solution stolen from http://disq.us/p/188p6ce
 */
class NailingPlanks1 {

  def solution(a: Array[Int], b: Array[Int], c: Array[Int]): Int = {
    var beg = 1 // minimum one nail
    var end = c.length // can't be bigger than all nails count..
    var result = -1
    while (beg <= end) {
      val mid = (beg + end) / 2
      if (check(a, b, c, mid)) { // if it is a solution
        end = mid - 1
        result = mid
      } else {
        beg = mid + 1
      }
    }
    result
  }

  private def check(a: Array[Int], b: Array[Int], c: Array[Int], nailsCount: Int): Boolean = {
    val nails = Array.ofDim[Int](2 * c.length + 1) // prefix sum of nails
    for (i <- 0 until nailsCount)
      nails(c(i)) = 1
    for (i <- nails.indices.tail)
      nails(i) += nails(i - 1)

    var allNailed = true
    for (i <- a.indices if allNailed) {
      allNailed = nails(b(i)) - nails(a(i) - 1) > 0
    }
    allNailed
  }

}

/*
Bisect on the LENGTH OF C (nails provided).
This is the most straightforward solution.
87%, not performant
 */
class NailingPlanks2 {

  def solution(a: Array[Int], b: Array[Int], c: Array[Int]): Int = {
    var beg = 1 // minimum one nail
    var end = c.length // can't be bigger than all nails count..
    var result = -1
    while (beg <= end) {
      val mid = (beg + end) / 2
      val nails = c.take(mid).toSet
      if (check(a, b, nails)) { // if it is a solution
        end = mid - 1
        result = mid
      } else {
        beg = mid + 1
      }
    }
    result
  }

  private def check(a: Array[Int], b: Array[Int], nails: Set[Int]): Boolean = {

    var ok = true
    for (i <- a.indices if ok) {
      val hasProperNail = nails.exists(n => a(i) <= n && n <= b(i))
      if (!hasProperNail)
        ok = false
    }
    println(s"ok=$ok nails=$nails")
    ok
  }
}
