package ba.sake.scalarizmi.misc

// Rotate array right k places
trait CyclicRotation {
  def solution(a: Array[Int], k: Int): Array[Int]
}

object CyclicRotation1 extends CyclicRotation {

  def solution(a: Array[Int], k: Int): Array[Int] = {
    if (a.length <= 1) a
    else {
      val n = k % a.length // if k bigger than length, avoid unnecessary rotations
      a.takeRight(n) ++ a.take(a.length - n)
    }
  }
}

object CyclicRotation2 extends CyclicRotation {

  def solution(a: Array[Int], k: Int): Array[Int] = {
    if (a.length <= 1) a
    else {
      val n = k % a.length // if k bigger than length, avoid unnecessary rotations
      val (first, second) = a.splitAt(a.length - n)
      second ++ first
    }
  }
}
