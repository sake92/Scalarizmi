package ba.sake.scalarizmi.sorting

trait SortingAlgorithm {

  def sort[T](array: Array[T])(implicit ord: Ordering[T]): Array[T]

  /**
    * @return Name of the algorithm
    */
  def name = getClass.getName

}

object SortingAlgorithm {

  implicit class ArraySortOps[T](array: Array[T]) {

    def swap(i: Int, j: Int): Unit = {
      val temp = array(i)
      array(i) = array(j)
      array(j) = temp
    }
  }

}