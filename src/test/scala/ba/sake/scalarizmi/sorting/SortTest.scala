package ba.sake.scalarizmi.sorting

import ba.sake.scalarizmi.TestUtils._

import scala.concurrent.duration._
import scala.util.Random

class SortTest extends FlatSpec {

  val Algorithms =
    Vector(InsertionSort, SelectionSort, MergeSort, BubbleSort, QuickSort, CountingSort, RadixSort)
  val NumIterations = 100
  val NumElements = 500

  val unsortedArray = Array.fill(NumElements)(Random.nextInt(NumElements))
  val sortedArray = unsortedArray.sorted

  // copies array because some algorithms sort in-place while others don't
  def getArray = unsortedArray.clone

  // do the tests
  for (alg <- Algorithms) {
    alg.name should "sort array properly" in {

      // run once just to see if it works
      val result = alg.sort(getArray)
      result should contain theSameElementsInOrderAs sortedArray

      // if works, run N times for statistics
      if (result.toSeq == sortedArray.toSeq) {
        var totalNanos = 0L
        for (iter <- 0 to NumIterations) {
          val startTimeNanos = System.nanoTime()
          alg.sort(getArray)
          val endTimeNanos = System.nanoTime()
          totalNanos += endTimeNanos - startTimeNanos
        }
        val avgMillis = (totalNanos / NumIterations).nanoseconds.toNanos.toDouble / 1000
        info(
          f"Average time for <${alg.name}> to sort $NumElements elements is $avgMillis%3.3f millis")
      }
    }
  }

}
