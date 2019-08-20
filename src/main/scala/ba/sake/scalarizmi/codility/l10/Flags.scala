package ba.sake.scalarizmi.codility.l10

trait Flags {
  def solution(a: Array[Int]): Int
}

object Flags1 extends Flags {
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

      // find max number of flags
      if (peakIdxs.isEmpty) 0
      else {
        var max = 1 // we can always put one flag...
        var found = false
        for (i <- 2 to peakIdxs.length if !found) {

          var flagsLeft = i - 1 // coz first is already added
          var flagsPut = 1
          var lastFlagIdx = 0
          var j = 1
          while (j < peakIdxs.length && flagsLeft > 0) {
            if (peakIdxs(j) - peakIdxs(lastFlagIdx) >= i) {
              flagsPut += 1
              flagsLeft -= 1 // we only get to put i flags
              lastFlagIdx = j
            }
            j += 1
          }
          if (flagsPut > max) {
            max = flagsPut
          }
          if (flagsLeft > 0) {
            found = true // don't try bigger numbers, when we cant satisfy this one...
          }
        }
        max
      }
    }
  }
}
