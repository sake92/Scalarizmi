package ba.sake.scalarizmi.codility.l15

object countDist extends App {
  val c = new CountDistinctSlices
  println((
    c.solution(6, Array(3, 4, 5, 5, 2)), // 9
    c.solution(6, Array(3)), // 1
    c.solution(6, Array()) // 0
  ))
}

/*
Example for Array(3, 4, 5, 5, 2):
- 3
- 3,4
- 3,4,5
- 4,5
- 4
- 5
- 5,2
- 5 // the second one
- 2
 */
class CountDistinctSlices {

  private val Max = 1000000000

  def solution(m: Int, a: Array[Int]): Int = {
    println("+" * 30)

    var total = 0
    val seen = Array.ofDim[Boolean](m + 1) // instead of allocating new Set in each iteration, reuse this array

    var left = 0
    var right = 0
    while (left < a.length && right < a.length) {
      if (seen(a(right))) {
        seen(a(left)) = false
        left += 1 // move +1, this isnt a solution
      } else {
        total += right - left + 1
        if (total > Max) {
          return Max
        }
        //println(seen.toList, left, right)
        println(a.slice(left, right + 1).mkString(","))
        seen(a(right)) = true
        right += 1
      }
    }
    total
  }

}
