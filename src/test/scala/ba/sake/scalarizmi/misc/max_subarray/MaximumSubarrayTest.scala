package ba.sake.scalarizmi.misc.max_subarray

import org.scalatest.{FlatSpec, Matchers}

class MaximumSubarrayTest extends FlatSpec with Matchers {

  val Algorithms = Vector(DivideAndConquer)

  val Arrays = Vector(
    (3, 6, 6) -> Array(-2, 1, -3, 4, -1, 2, 1, -5, 4), // sum( 4,-1,2,1 ) == 6
    (2, 6, 7) -> Array(-2, -3, 4, -1, -2, 1, 5, -3) // sum( 4,-1,-2,1,5 ) == 7
  )

  for (alg <- Algorithms) {
    alg.name should "find maximum subarray" in {

      for ((expected, array) <- Arrays) {
        val result @ (leftIndex, rightIndex, sum) = alg.sort(array)
        result shouldBe expected
        info(
          s"Maximum subarray is ${array.slice(leftIndex, rightIndex + 1).mkString(",")}")
      }
    }
  }

}
