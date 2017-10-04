package ba.sake.scalarizmi.sorting

import scala.concurrent.duration._
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import scala.util.Random

class SortTest extends FlatSpec with Matchers {

  val sortAlgorithms = Vector(InsertionSort, SelectionSort)
  val NumIterations = 100
  val NumElements = 500

  val unsortedArray = Array.fill(NumElements)(Random.nextInt())
  val sortedArray = unsortedArray.sorted

  // copies array because some algorithms sort in-place while others don't
  def getArray = unsortedArray.clone

  // do the tests
  for (alg <- sortAlgorithms) {
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
        info(f"Average time for <${alg.name}> to sort $NumElements elements is $avgMillis%3.3f millis")
      }
    }
  }

}

