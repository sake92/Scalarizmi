package ba.sake.scalarizmi.codility.l3

// An array A consisting of N different integers is given.
// The array contains integers in the range [1..(N + 1)], so exactly one element is missing.
// Find that missing element.
trait PermMissingElem {
  def solution(a: Array[Int]): Int
}

object PermMissingElem1 extends PermMissingElem {

  // for an array of length 3,
  // all possible values are [1,2,3,4]

  // then we just find the difference...
  // if there's no difference, means that array is empty, so we return 1
  def solution(a: Array[Int]): Int = {
    val should = a.indices.appended(a.length).map(_ + 1)
    val difference = should.diff(a)
    difference.headOption.getOrElse(1)
  }
}
