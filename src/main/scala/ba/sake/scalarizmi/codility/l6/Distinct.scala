package ba.sake.scalarizmi.codility.l6

trait Distinct {
  def solution(a: Array[Int]): Int
}

// this is cheating, but hey... xD
object Distinct1 extends Distinct {

  def solution(a: Array[Int]): Int =
    a.toSet.size
}
