package ba.sake.scalarizmi.codility.l5

trait MinAvgTwoSlice {
  def solution(a: Array[Int]): Int
}

/*
Any slice of >= 4 numbers can be split on slices of 2 and 3 numbers.
The key insight is that the *sum of smaller slices* is always **bigger or equal to one of subslices**.
Lets see simplest example, only 2 subslices:
a + b >= a  OR a + b >= b

Example: a=0,b=4 => a+b=4 => 4>=0 OR 4>=4
Example: a=-5,b=3 => a+b=-2 => -2>=-5 OR -2>=3

So, the minimum stays the same, either we took (a+b) or one of its subslices.
Proof is done.

// could also do it with 2 loops, still O(n)
// a.sliding(2) and once a.sliding(3)
 */
object MinAvgTwoSlice1 extends MinAvgTwoSlice {
  def solution(a: Array[Int]): Int = {
    if (a.length == 2) 0
    else {
      var minAvg = Double.MaxValue
      var minIndex = 0
      var i = 0
      a.sliding(3).foreach {
        case Array(a1, a2, a3) =>
          val avg2_1 = (a1 + a2).toDouble / 2
          val avg2_2 = (a2 + a3).toDouble / 2 // needed for LAST 2
          val avg3 = (a1 + a2 + a3).toDouble / 3
          if (avg2_1 < minAvg) {
            minAvg = avg2_1
            minIndex = i
          }
          if (avg2_2 < minAvg) {
            minAvg = avg2_2
            minIndex = i + 1
          }
          if (avg3 < minAvg) {
            minAvg = avg3
            minIndex = i
          }
          i += 1
      }
      minIndex
    }
  }
}
