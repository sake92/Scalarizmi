package ba.sake.scalarizmi.sorting

// helpers for array
extension [T](array: Array[T]) {

  def swap(i: Int, j: Int): Unit = {
    val temp = array(i)
    array(i) = array(j)
    array(j) = temp
  }
}
