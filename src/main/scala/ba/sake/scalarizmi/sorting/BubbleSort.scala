package ba.sake.scalarizmi.sorting

import SortingHelpers._

/**
 * Time complexity: O( n^2 ) <br>
 * Swaps adjacent elements if necessary. <br>
 * Biggest element "bubbles" to one end of array... <br>
 *
 * @author Sake
 *
 */
object BubbleSort extends SortingAlgorithm {

  override def name = "Bubble sort"

  override def sort[T](array: Array[T])(implicit ord: Ordering[T]): Array[T] = {
    import ord._

    val arrayLength = array.length
    var i = 0
    var j = 0
    while (i < arrayLength) {
      j = 0
      while (j < arrayLength - 1 - i) {
        if (array(j) > array(j + 1)) {
          array.swap(j, j + 1)
        }
        j = j + 1
      }
      i = i + 1
    }
    array
  }

}
