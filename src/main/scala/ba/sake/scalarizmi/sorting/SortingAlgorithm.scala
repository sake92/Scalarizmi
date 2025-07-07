package ba.sake.scalarizmi.sorting

// sorting in place, except for merge-sort
trait SortingAlgorithm {

  def sort[T](array: Array[T])(implicit ord: Ordering[T]): Array[T]

  /**
    * @return Name of the algorithm
    */
  def name = getClass.getName
}
