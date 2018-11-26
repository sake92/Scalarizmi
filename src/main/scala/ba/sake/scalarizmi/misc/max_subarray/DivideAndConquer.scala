package ba.sake.scalarizmi.misc.max_subarray

object DivideAndConquer extends MaximumSubarrayAlgorithm {

  /** @return (start-index, end-index, sum) */
  override def sort(array: Array[Int]): (Int, Int, Int) = {
    maxSubarray(array, 0, array.length - 1)
  }

  private def maxSubarray(array: Array[Int], low: Int, high: Int): (Int, Int, Int) = {
    if (high == low) {
      (low, high, array(low)) // base case: only one element
    } else {
      val mid = (low + high) / 2
      val maxLeft@(_, _, sumLeft) = maxSubarray(array, low, mid)
      val maxRight@(_, _, sumRight) = maxSubarray(array, mid + 1, high)
      val maxMiddle@(_, _, sumMiddle) = maxMiddleSubarray(array, low, mid, high)

      if (sumLeft >= sumRight && sumLeft >= sumMiddle) maxLeft
      else if (sumRight >= sumLeft && sumRight >= sumMiddle) maxRight
      else maxMiddle
    }
  }

  private def maxMiddleSubarray(array: Array[Int], low: Int, mid: Int, high: Int): (Int, Int, Int) = {

    var leftIndex = -1
    var rightIndex = -1
    var sumLeft = Int.MinValue
    var sumRight = Int.MinValue

    var tmpSum = 0
    for (i <- mid to low by -1) {
      tmpSum += array(i)
      if (tmpSum > sumLeft) {
        sumLeft = tmpSum
        leftIndex = i
      }
    }

    tmpSum = 0
    for (i <- (mid + 1) to high) {
      tmpSum += array(i)
      if (tmpSum > sumRight) {
        sumRight = tmpSum
        rightIndex = i
      }
    }

    (leftIndex, rightIndex, sumLeft + sumRight)
  }
}
