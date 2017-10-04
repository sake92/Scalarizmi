package ba.sake.scalarizmi.sorting

object SortingHelpers {

  implicit class ArraySortOps[T](array: Array[T]) {

    /**
     * Swaps 2 elements at indices i and j
     * @param i First element index
     * @param j Second element index
     */
    def swap(i: Int, j: Int): Unit = {
      val temp = array(i)
      array(i) = array(j)
      array(j) = temp
    }

  }

}
