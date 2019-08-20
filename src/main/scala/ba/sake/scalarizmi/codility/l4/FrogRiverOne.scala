package ba.sake.scalarizmi.codility.l4

// Find the earliest time when a frog can jump to the other side of a river.
trait FrogRiverOne {
  def solution(x: Int, a: Array[Int]): Int
}

object FrogRiverOne1 extends FrogRiverOne {
  import scala.collection.mutable.SortedSet

  def solution(x: Int, a: Array[Int]): Int = {
    val beforeX = SortedSet.empty[Int] // we use a sorted set
    for ((elem, i) <- a.zipWithIndex) {
      if (elem <= x) { // if we need this leaf, add it to set
        beforeX += elem
      }
      if (beforeX.size == x) { // if set is same size as x (frog's goal)
        return i // that's the solution :)
      }
    }
    -1
  }

}
