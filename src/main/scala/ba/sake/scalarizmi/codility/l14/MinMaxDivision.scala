package ba.sake.scalarizmi.codility.l14

object minmaxxxxxxxdiv extends App {
  println(
    MinMaxDivision.solution(3, 5, Array(2, 1, 5, 1, 2, 2, 2)) // 6
  )
}

/*
We first find the MAXIMUM SUM. It is a trivial solution.
Then we check if maxSum/2 satisfies the solution:
- if it does, try even smaller one, maxSum/4
- if it doesn't, try a bigger one, 3*maxSum/4
 */
object MinMaxDivision {

  def solution(k: Int, m: Int, a: Array[Int]): Int = {

    var beg = a.max // can't be smaller than the max element! :)
    var end = a.sum // can't be bigger than maximum total sum..
    var result = 0
    while (beg <= end) {
      val mid = (beg + end) / 2
      val chk = check(a, mid)
      if (chk <= k) { // if it is a solution
        end = mid - 1
        result = mid
      } else {
        beg = mid + 1
      }
    }
    result
  }

  private def check(a: Array[Int], sum: Int): Int = {
    var blocks = 1 // first block we already start counting..
    var tmpSum = 0
    for (elem <- a) {
      if (tmpSum + elem <= sum) { // if we can add even this number, still <= sum
        tmpSum += elem
      } else {
        blocks += 1 // else we need another block
        tmpSum = elem // not zero, we start from this current element.. :)
      }
    }
    blocks
  }
}
