package ba.sake.scalarizmi.codility.l6

trait Triangle {
  def solution(a: Array[Int]): Int
}

object Triangle1 extends Triangle {

  def solution(a: Array[Int]): Int = {
    val positive = a.filterNot(_ <= 0)

    if (positive.length < 3) 0
    else {
      val sorted = positive.sorted
      val has = sorted.sliding(3).find {
        case Array(p, q, r) =>
          val pqSum = p + q
          val prSum = p + r
          val qrSum = q + r
          if (pqSum > 0 && prSum > 0 && qrSum > 0)
            p + q > r && p + r > q && q + r > p
          else {
            BigInt(p) + BigInt(q) > BigInt(r) && // for overflowed numbers..
            BigInt(p) + BigInt(r) > BigInt(q) &&
            BigInt(q) + BigInt(r) > BigInt(p)
          }
      }

      if (has.isDefined) 1 else 0
    }
  }
}
