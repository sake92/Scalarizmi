package ba.sake.scalarizmi.sorting

/**
  * Time complexity: `O( n^2 )`  
  * Swaps adjacent elements if necessary. 
  * Biggest element "bubbles" to one end of array... 
  *
  *
  * @author Sake
  *
  */
object BubbleSort extends SortingAlgorithm {

  override def name = "Bubble sort"

  override def sort[T](array: Array[T])(implicit ord: Ordering[T]): Array[T] = {
    import ord._

    val arrayLength = array.length
    for (i <- 0 until arrayLength) {
      for (j <- 0 until arrayLength - 1 - i) {
        if (array(j) > array(j + 1)) {
          array.swap(j, j + 1)
        }
      }
    }
    array
  }

}
