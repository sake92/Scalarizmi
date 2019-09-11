package ba.sake.scalarizmi.codility.l15

object cater extends App {
  val c = new Caterpillar
  println(c.solution(Array(6, 2, 7, 4, 1, 3, 6), 12)) // true: 7+4+1
  println(c.solution(Array(6, 2, 7, 4, 1, 3, 6), 24)) // false
}

// check if array contains contiguous subarray of sum n.
class Caterpillar {

  def solution(array: Array[Int], n: Int): Boolean = {

    var found = false
    for (begin <- array.indices if !found) {
      var idx = begin
      var sum = 0
      while (sum < n && idx < array.length) {
        sum += array(idx)
        idx += 1
      }
      if (sum == n) {
        val sub = array.slice(begin, idx).toList
        println(s"solution starting at index=$begin, ending at ${idx - 1}: $sub")
        found = true
      }
    }
    found
  }
}
