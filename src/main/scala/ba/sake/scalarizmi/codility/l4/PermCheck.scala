package ba.sake.scalarizmi.codility.l4

// Check whether array A is a permutation (1==YES, 0==NO).
// permutation is a sequence containing each element from 1 to N once, and only once
trait PermCheck {
  def solution(a: Array[Int]): Int
}

object PermCheck1 extends PermCheck {

  def solution(a: Array[Int]): Int = {
    val diffElems = a.toSet
    if (diffElems.size == a.size) {
      if (diffElems.exists(elem => elem < 1 || elem > a.size)) 0
      else 1
    } else {
      0
    }
  }
  // could also sort and see if index==elem-1

}
