package ba.sake.scalarizmi.sorting

object RadixSort extends SortingAlgorithm {

  override def name = "Radix sort"

  def sort[T](arr: Array[T])(implicit ord: Ordering[T]): Array[T] = {
    var array = arr.asInstanceOf[Array[Int]] // ignore this...

    val max = maxElem(array)
    var exp = 1
    while (max / exp > 0) {
      array = countSort(array, exp)
      exp *= 10
    }

    array.asInstanceOf[Array[T]] // ignore this...
  }

  private def countSort(array: Array[Int], exp: Int): Array[Int] = {

    // 10 possible values here, digits :)
    val counts = Array.ofDim[Int](10)
    for (elem <- array) {
      val digit = (elem / exp) % 10
      counts(digit) += 1
    }
    for (i <- 1 until counts.length) {
      counts(i) += counts(i - 1) // now it's how many nums <= i
    }

    val result = Array.ofDim[Int](array.length)
    for (elem <- array.reverse) {
      val digit = (elem / exp) % 10
      val elemIndex = counts(digit) - 1
      result(elemIndex) = elem
      counts(digit) -= 1 // when multiple same elements, move index
    }

    result
  }

  private def maxElem(arr: Array[Int]): Int = {
    arr.max
  }

}
