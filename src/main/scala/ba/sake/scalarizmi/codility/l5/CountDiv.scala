package ba.sake.scalarizmi.codility.l5

trait CountDiv {
  def solution(a: Int, b: Int, k: Int): Int
}

// every k-th number is divisible by k...
object CountDiv1 extends CountDiv {

  def solution(a: Int, b: Int, k: Int): Int = {
    var count = 0
    var left: Integer = null
    var right: Integer = null

    var i = a
    while (i <= b && left == null) {
      if (i % k == 0) left = i
      i += 1
    }

    i = b
    while (i >= a && right == null) {
      if (i % k == 0) right = i
      i -= 1
    }

    if (left != null && right != null) {
      count = (right - left) / k
      count += 1
    } else if (left != null) {
      count += 1
    } else if (right != null) {
      count += 1
    }

    count
  }

}
