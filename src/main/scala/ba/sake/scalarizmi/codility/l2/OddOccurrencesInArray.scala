package ba.sake.scalarizmi.codility.l2

// TASK: Find the only unpaired integer in array
// - array is not empty!
trait OddOccurrencesInArray {
  def solution(a: Array[Int]): Int
}

object OddOccurrencesInArraySolution1 extends OddOccurrencesInArray {
  import scala.collection.mutable

  def solution(a: Array[Int]): Int = {
    val occurs = mutable.Map.empty[Int, Int].withDefaultValue(0)
    for (n <- a) {
      occurs(n) += 1
    }
    // find only element which occurs ODD times
    occurs.find(_._2 % 2 == 1).get._1
  }
}
