package ba.sake.scalarizmi.codility.l6

trait MaxProductOfThree {
  def solution(a: Array[Int]): Int
}

// - INDICES dont matter (P<Q<R) since we try all combos, they just need to be different
// - it is either LAST 3, obvious when positive _or_ FIRST 2 (negative) times LAST
// - cant be first 3 coz:
// - it would have negative result
// - third is positive, we get the same... it would be included in last 3..
object MaxProductOfThree1 extends MaxProductOfThree {

  // O(N * log(N))
  def solution(a: Array[Int]): Int = {

    val smallest3 = Array(a(0), a(1), a(2))
    val biggest3 = Array(a(0), a(1), a(2))

    for (n <- a.drop(3)) {

      val biggestInSmall = smallest3.max
      if (n < biggestInSmall) {
        smallest3(smallest3.indexOf(biggestInSmall)) = n
      }

      val smallestInBig = biggest3.min
      if (n > smallestInBig) {
        biggest3(biggest3.indexOf(smallestInBig)) = n
      }
    }

    val smallest3Sorted = smallest3.sorted // probably would be O(n) without these
    val biggest3Sorted = biggest3.sorted
    val lastThree = biggest3Sorted(0) * biggest3Sorted(1) * biggest3Sorted(2)
    val first2Last = smallest3Sorted(0) * smallest3Sorted(1) * biggest3Sorted(2)
    if (lastThree > first2Last) lastThree
    else first2Last
  }

  /// by sorting
  def solution2(a: Array[Int]): Int = {
    val sortedArray = a.sorted
    val lastThree = sortedArray.takeRight(3).fold(1)(_ * _)
    val first2Last = (sortedArray.take(2) :+ sortedArray.last).fold(1)(_ * _)
    if (lastThree > first2Last) lastThree
    else first2Last
  }

}
