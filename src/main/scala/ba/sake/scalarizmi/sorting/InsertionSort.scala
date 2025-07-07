package ba.sake.scalarizmi.sorting

/**
  * Time complexity: O( n^2 ) <br>
  * Uses FIRST element as ALREADY SORTED SUBARRAY. <br>
  * Adds rest of elements to that subarray AT THE CORRECT POSITION. <br>
  *
  *
  * @author Sake
  *
  */
object InsertionSort extends SortingAlgorithm {

  override def name = "Insertion sort"

  override def sort[T](array: Array[T])(implicit ord: Ordering[T]): Array[T] = {
    import ord._

    val arrayLength = array.length
    for (i <- 0 until arrayLength) {
      for {
        j <- i until 0 by -1
        if array(j - 1) > array(j)
      } {
        array.swap(j - 1, j)
      }
    }
    array
  }

}
