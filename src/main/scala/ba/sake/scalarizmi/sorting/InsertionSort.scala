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
  import SortingAlgorithm._

  override def name = "Insertion sort"

  override def sort[T](array: Array[T])(implicit ord: Ordering[T]): Array[T] = {
    import ord._

    val arrayLength = array.length
    var i = 1
    var j = 0
    while (i < arrayLength) {
      j = i
      while (j > 0 && array(j - 1) > array(j)) {
        array.swap(j - 1, j)
        j = j - 1
      }
      i = i + 1
    }
    array
  }

}
