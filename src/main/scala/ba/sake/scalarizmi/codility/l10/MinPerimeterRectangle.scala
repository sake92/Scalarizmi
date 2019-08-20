package ba.sake.scalarizmi.codility.l10

trait MinPerimeterRectangle {
  def solution(n: Int): Int
}

// A = a*b
// P = 2*a + 2*b
// P = 2*(A/b) + 2*b
// P' = -2A/b^2 + 2
// when derivative is zero, that's max/min, so
// b = sqrt(A)
object MinPerimeterRectangle1 extends MinPerimeterRectangle {

  def solution(n: Int): Int = {
    var b = Math.sqrt(n.toDouble).toInt
    var a = n / b
    while (a * b != n) { // find nearest to square root
      b = b - 1
      a = n / b
    }
    2 * a + 2 * b
  }
}
