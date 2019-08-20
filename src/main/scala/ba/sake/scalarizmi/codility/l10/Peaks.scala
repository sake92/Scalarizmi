package ba.sake.scalarizmi.codility.l10

trait Peaks {
  def solution(a: Array[Int]): Int
}

object Peaks1 extends Peaks {
  import scala.collection.mutable.ArrayBuffer

  def solution(a: Array[Int]): Int = {

    val length = a.length
    if (length <= 2) 0
    else {
      // first, collect peak indices
      val peakIdxs = ArrayBuffer.empty[Int]
      for (i <- 1 until length - 1) {
        val (a1, a2, a3) = (a(i - 1), a(i), a(i + 1))
        if (a1 < a2 && a2 > a3) {
          peakIdxs += i
        }
      }

      // find max number of blocks
      if (peakIdxs.isEmpty) 0
      else {
        var max = 1 // we can always have whole array...
        for (i <- 2 to length if length % i == 0) {
          var partSize = length / i
          var part = partSize

          var ok = true // is this solution ok?
          var partOk = false // is this slice ok? need at least one peak
          var j = 0
          while (j < peakIdxs.length && ok) {
            if (peakIdxs(j) < part) {
              partOk = true
              j += 1
            } else {
              if (partOk) { // this part is done, go to next slice
                part += partSize
                partOk = false
              } else { // if no peak in this slice, cant be a solution
                ok = false
              }
            }
          }

          if (ok && part >= length) {
            max = i
          }
        }
        max
      }
    }
  }
}
