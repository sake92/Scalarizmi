package ba.sake.scalarizmi.misc.max_subarray

/**
  * Find the nonempty, contiguous subarray of `array` whose values have the largest sum.
  */
trait MaximumSubarrayAlgorithm {

  /** @return (start-index, end-index, sum) */
  def sort(array: Array[Int]): (Int, Int, Int)

  /** @return Name of the algorithm */
  def name = getClass.getName

}
