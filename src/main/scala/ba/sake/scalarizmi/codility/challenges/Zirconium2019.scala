package ba.sake.scalarizmi.codility.challenges

/*
Choose F frontend developers, from array A.
Choose N-F backend developers, from array B.
You can select K-th developer either from A or from B!
Value of A[i] or B[i] is developer's contribution.

What is the maximum sum of contributions the company can achieve?

Examples:

Given A = [4, 2, 1], B = [2, 5, 3] and F = 2, the function should return 10.
The 0th and 2nd developers should be assigned to the front-end team
(with contributions 4 and 1) and the 1st developer should be assigned to the back-end team (with contribution 5).
 */
trait Zirconium2019 {
  def solution(a: Array[Int], b: Array[Int], f: Int): Int
}

object Zirconium2019_1 extends Zirconium2019 {

  def solution(a: Array[Int], b: Array[Int], f: Int): Int = {

    val frontendVsBackend =
      a.zip(b).map { case (fr, ba) => (fr, ba, fr - ba) } // find differences (frontend-backend)
        .sortBy(-_._3) // order by difference (front vs back)

    val (front, back) = frontendVsBackend.splitAt(f)

    front.map(_._1).sum + back.map(_._2).sum
  }
}