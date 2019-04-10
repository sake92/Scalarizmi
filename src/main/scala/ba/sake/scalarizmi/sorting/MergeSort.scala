package ba.sake.scalarizmi.sorting

/**
  * Time complexity: O( n*log(n) ) <br>
  * Divide & conquer. <br>
  * Recursively calls itself, divides problem onto simplest ones: <br>
  * <ul>
  * <li>Two arrays with one element, trivial sort, just compare them</li>
  * <li>One array with one element, sorted already :p</li>
  * </ul>
  *
  * @author Sake
  *
  */
object MergeSort extends SortingAlgorithm {

  override def name = "Merge sort"

  override def sort[T](array: Array[T])(implicit ord: Ordering[T]): Array[T] = {

    mergeSort(array, 0, array.length - 1)
  }

  private def mergeSort[T](array: Array[T], low: Int, high: Int)(implicit ord: Ordering[T]): Array[T] = {
    if (low < high) {
      val mid = (low + high) / 2
      mergeSort(array, low, mid)
      mergeSort(array, mid + 1, high)
      merge(array, low, mid, high)
    } else {
      array
    }
  }

  private def merge[T](array: Array[T], low: Int, mid: Int, high: Int)(implicit ord: Ordering[T]): Array[T] = {
    import ord._

    // copy subarrays
    val left = array.slice(low, mid + 1)
    val right = array.slice(mid + 1, high + 1)

    var i = 0
    var j = 0
    var k = low
    while (k < high + 1) {
      // must check if empty to avoid exceptions
      if (i > left.length - 1) {
        array(k) = right(j)
        j = j + 1
      } else if (j > right.length - 1) {
        array(k) = left(i)
        i = i + 1
      } else if (left(i) <= right(j)) {
        array(k) = left(i)
        i = i + 1
      } else {
        array(k) = right(j)
        j = j + 1
      }
      k = k + 1
    }
    array
  }

}
