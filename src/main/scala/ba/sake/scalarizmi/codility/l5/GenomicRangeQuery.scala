package ba.sake.scalarizmi.codility.l5

trait GenomicRangeQuery {
  def solution(s: String, p: Array[Int], q: Array[Int]): Array[Int]
}

// - count number of ONES, if there's one -> 1
// same for 2,3,4
// - count is "sum of ones"
object GenomicRangeQuery1 extends GenomicRangeQuery {
  import scala.collection.mutable

  private val Nucleotides = Map('A' -> 1, 'C' -> 2, 'G' -> 3, 'T' -> 4)

  def solution(s: String, p: Array[Int], q: Array[Int]): Array[Int] = {
    val arrLength = s.length
    val prefixCounts =
      mutable.Seq.fill(4)(
        mutable.Seq.fill(arrLength + 1)(0)
      )

    for (i <- 0 until arrLength) {
      val elem = Nucleotides(s(i))
      for (nuc <- Nucleotides.values) {
        val nucIndex = nuc - 1
        val toCount = if (elem == nucIndex) 1 else 0
        prefixCounts(nucIndex)(i + 1) = prefixCounts(nucIndex)(i) + toCount
      }
    }

    def sumBetween(from: Int, to: Int): Int = {
      if (prefixCounts(1)(to) - prefixCounts(1)(from) != 0) 1
      else if (prefixCounts(2)(to) - prefixCounts(2)(from) != 0) 2
      else if (prefixCounts(3)(to) - prefixCounts(3)(from) != 0) 3
      else 4
    }

    (p zip q) map {
      case (pIndex, qIndex) =>
        sumBetween(pIndex, qIndex + 1)
    }
  }
}
