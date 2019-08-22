package ba.sake.scalarizmi.sorting

/**
  *
  * Time complexity: O( n ) <br>
  *
  * @author Sake
  *
  */
object CountingSort extends SortingAlgorithm {

  override def name = "Counting sort"

  def sort[T](arr: Array[T])(implicit ord: Ordering[T]): Array[T] = {
    val array = arr.asInstanceOf[Array[Int]] // ignore this...

    // assumes k different possible values, here we take 1000...
    val counts = Array.ofDim[Int](1000)
    for (elem <- array) {
      if (elem < 0) throw new RuntimeException("Sorry, can't handle negative numbers")
      counts(elem) += 1
    }
    for (i <- 1 until counts.length) {
      counts(i) += counts(i - 1) // now it's how many nums <= i
    }

    val result = Array.ofDim[Int](array.length)
    for (elem <- array.reverse) {
      val elemIndex = counts(elem) - 1
      result(elemIndex) = elem
      counts(elem) -= 1 // when multiple same elements, move index
    }

    result.asInstanceOf[Array[T]] // ignore this...
  }

}
