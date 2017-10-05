package ba.sake.scalarizmi.sorting

import SortingHelpers._

/**
 * Time complexity: O( n^2 ) <br>
 * Finds NEXT MINIMAL element and switches it with CURRENT element. <br>
 *
 * @author Sake
 *
 */
object SelectionSort extends SortingAlgorithm {

  override def name = "Selection sort"

  override def sort[T](array: Array[T])(implicit ord: Ordering[T]): Array[T] = {
    import ord._

    val arrayLength = array.length
    var i = 0
    var j = 0
    var indexOfMin = 0
    while (i < arrayLength - 1) {
      // assume next minimal is first
      indexOfMin = i
      j = i + 1
      while (j < arrayLength) {
        if (array(j) < array(indexOfMin)) {
          indexOfMin = j
        }
        j = j + 1
      }
      array.swap(i, indexOfMin)
      i = i + 1
    }
    array
  }

}

