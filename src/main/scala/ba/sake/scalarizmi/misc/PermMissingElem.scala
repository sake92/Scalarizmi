package ba.sake.scalarizmi.misc

// An array A consisting of N different integers is given.
// The array contains integers in the range [1..(N + 1)], so exactly one element is missing.
// Find that missing element.
trait PermMissingElem {
  def solution(a: Array[Int]): Int
}

object PermMissingElem1 extends PermMissingElem {

  // for an array of length 3,
  // possible values are 1,2,3,4 (indices plus size of array, incremented by one)
  // then we just find the difference...
  // if there's no difference, means that array is empty, so we return 1
  def solution(a: Array[Int]): Int = {
    val should = (a.indices :+ a.length).map(_ + 1)
    val difference = should diff a
    difference.headOption.getOrElse(1)
  }
}