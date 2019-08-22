package ba.sake.scalarizmi.sorting

/**
  *
  * Time complexity: O( n^2 ), but mostly O( n*log(n) ) <br>
  * Merge sort but with additional improvement. <br>
  * Divides array to LEFT, PIVOT(one element), RIGHT. All elements in LEFT are < PIVOT, all in RIGHT are > PIVOT.
  * So, when they're sorted, no need for merge step. :)
  *
  *
  * @author Sake
  *
  */
object QuickSort extends SortingAlgorithm {
  import SortingAlgorithm._

  override def name = "Quick sort"

  override def sort[T](array: Array[T])(implicit ord: Ordering[T]): Array[T] = {
    quicksort(array, 0, array.length - 1)
    array
  }

  private def quicksort[T](array: Array[T], left: Int, right: Int)(
      implicit ord: Ordering[T]): Unit = {
    if (left < right) {
      val pivotIdx = partition(array, left, right)
      quicksort(array, left, pivotIdx - 1)
      quicksort(array, pivotIdx + 1, right)
    }
  }

  private def partition[T](array: Array[T], left: Int, right: Int)(
      implicit ord: Ordering[T]): Int = {
    import ord._

    val pivot = array(right)
    var i = left - 1 // last left element
    for (j <- left until right) {
      if (array(j) <= pivot) {
        i += 1
        array.swap(i, j) // move to left subarray
      }
    }
    array.swap(i + 1, right) // put pivot left
    i + 1 // return pivot index
  }

  // in randomized version, PIVOT is chosen randomly from the range (left,right)...
  // the rest is the same
}
