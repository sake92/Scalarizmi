package ba.sake.scalarizmi.codility.l15

object CountTriangles extends App {
  val nt = new CountTriangles
  println(
    nt.solution(Array(10, 2, 5, 1, 8, 12)) // 4
  )
}

// must be sorted
class CountTriangles {

  def solution(a: Array[Int]): Int = {

    var count = 0
    for (i <- 0 until a.length - 2) { // from first to last-2
      for (j <- i + 1 until a.length - 1) { // from second to last-1
        var k = j + 1 // from third to last
        while (k < a.length) {
          println(s"try ($i,$j,$k)")
          if (isTriangle(a(i), a(j), a(k))) {
            println(s"YEP: ($i,$j,$k):", a(i), a(j), a(k))
            count += 1
          }
          k += 1
        }
      }
    }
    count
  }

  private def isTriangle(a: Int, b: Int, c: Int) =
    a + b > c && a + c > b && b + c > a
}
