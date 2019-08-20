package ba.sake.scalarizmi.codility.l8

trait Dominator {
  def solution(a: Array[Int]): Int
}

object Dominator1 extends Dominator {
  import scala.collection.mutable

  def solution(a: Array[Int]): Int = {
    // remember only counts, we'll return last index
    val counts = mutable.Map.empty[Int, Int].withDefaultValue(0)
    val lengthHalf = a.length / 2

    for ((elem, i) <- a.zipWithIndex) {
      counts(elem) += 1
      if (counts(elem) > lengthHalf) {
        return i
      }
    }
    -1
  }
}
