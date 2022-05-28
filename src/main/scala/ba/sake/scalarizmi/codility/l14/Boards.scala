package ba.sake.scalarizmi.codility.l14

object boardsssss extends App {
  val b = new Boards
  println((
    b.boards(Array(0, 1, 1, 0, 1), 1), // 4 to cover all 4 with one board
    b.boards(Array(0, 1, 1, 0, 1), 2), // 2, coz 2 consecutive
    b.boards(Array(0, 1, 1, 0, 1), 3) // 1
  ))
}

/*
By bisecting the problem, we get the final solution.
First we try n/2:
- if it is a solution, we try a smaller one: n/4 (finding a more precise solution)
- if it isn't a solution, we try a bigger one: 3n/4 (finding a solution)
etc etc. :)
 */
class Boards {

  def boards(A: Array[Int], k: Int): Int = {
    var beg = 1
    var end = A.length
    var result = -1
    while (beg <= end) {
      val mid = (beg + end) / 2
      if (check(A, mid) <= k) { // if it is a solution
        end = mid - 1
        result = mid
      } else {
        beg = mid + 1
      }
    }
    result
  }

  // how many boards of 'size' length
  // do we need to cover all holes
  private def check(A: Array[Int], size: Int): Int = {
    var boards = 0
    var last = -1
    for (i <- A.indices) {
      if (A(i) == 1 && last < i) {
        boards += 1
        last = i + size - 1 // we cover all from i to (i+size) :)
      }
    }
    boards
  }
}
