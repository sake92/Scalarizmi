package ba.sake.scalarizmi.codility.l5

// Count the number of passing cars on the road.
trait PassingCars {
  def solution(a: Array[Int]): Int
}

object PassingCars1 extends PassingCars {

  def solution(a: Array[Int]): Int = {
    // we go from behind/reverse, counting temporarily,
    // until we see a zero, then add that to the total
    var tmpCount = 0
    var totalCount = 0
    for (elem <- a.reverse) {
      if (elem == 1)
        tmpCount += 1
      else {
        try {
          totalCount = Math.addExact(totalCount, tmpCount)
          if (totalCount > 1000000000)
            return -1
        } catch {
          case _: ArithmeticException =>
            return -1
        }
      }
    }
    totalCount
  }
}
