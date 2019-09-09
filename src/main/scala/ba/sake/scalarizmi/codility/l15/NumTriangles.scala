package ba.sake.scalarizmi.codility.l15

object trrrrr extends App {
  val nt = new NumTriangles
  println(
    nt.solution(Array(4, 5, 6, 8)) // 4
  )
}

// must be sorted
class NumTriangles {

  def solution(sticks: Array[Int]): Int = {

    var count = 0
    for (i <- 0 until sticks.length - 2) { // from first to last-2
      for (j <- i + 1 until sticks.length - 1) { // from second to last-1
        var k = j + 1 // from third to last
        while (k < sticks.length && isTriangle(sticks(i), sticks(j), sticks(k))) {
          println("YEP: ", sticks(i), sticks(j), sticks(k))
          count += 1
          k += 1
        }
      }
    }
    count
  }

  private def isTriangle(a: Int, b: Int, c: Int) =
    a + b > c
  // here we take advantage of the fact a<b<c (given in task!)
  // no need to check a+c>b (c always >b)
  // no need to check b+c>a (c always >a, b always >a)
  // a + b > c && a + c > b && b + c > a
}
