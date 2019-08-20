package ba.sake.scalarizmi.codility.l8

import scala.collection.mutable.Map

trait EquiLeader {
  def solution(a: Array[Int]): Int
}

// - only the leader of WHOLE ARRAY can be equi-leader.
// Since leader_count > n/2, it will be leader in one of subarrays,
// no matter how we divide array a:
// 1:n-1    => in right subarray
// n-1:1    => in left subarray
// n/2:n/2  => in one of two subarrays... :)
// - partial-sums approach was used to count the leader element by indices
object EquiLeader1 extends EquiLeader {

  def solution(a: Array[Int]): Int = {

    val length = a.length
    val theLeader = leader(a)
    if (theLeader == Int.MaxValue) 0 // no leader => no equileader
    else {
      var theLeaderTotalCount = 0
      val theLeaderCounts = Array.fill(length)(0) // idx -> theLeaderCount
      for ((elem, i) <- a.zipWithIndex) {
        if (elem == theLeader) {
          theLeaderTotalCount += 1
        }
        theLeaderCounts(i) = theLeaderTotalCount
      }

      // count equileaders
      var count = 0
      for (i <- 0 to length - 1) {
        val tlcCountLeft = theLeaderCounts(i)
        val tlcCountRight = theLeaderCounts(length - 1) - tlcCountLeft
        val isLeaderLeft = tlcCountLeft > (i + 1) / 2
        val isLeaderRight = tlcCountRight > (length - i - 1) / 2

        if (isLeaderLeft && isLeaderRight) {
          count += 1
        }
      }
      count
    }
  }

  def leader(a: Array[Int]): Int = {
    // remember only count, we'll return last index
    val counts = Map.empty[Int, Int].withDefaultValue(0)
    val lengthHalf = a.length / 2
    for (elem <- a) {
      counts(elem) += 1
      if (counts(elem) > lengthHalf) {
        return elem
      }
    }
    Int.MaxValue
  }
}

// 55% "brute force"
object EquiLeader2 extends EquiLeader {
  def solution(a: Array[Int]): Int = {

    var count = 0
    for (i <- 1 until a.length) {

      val (left, right) = a.splitAt(i)
      val leftLeader = leader(left)
      val rightLeader = leader(right)

      if (leftLeader == rightLeader && leftLeader != Int.MaxValue) {
        count += 1
      }
    }
    count
  }

  def leader(a: Array[Int]): Int = {
    // remember only count, we'll return last index
    val counts = Map.empty[Int, Int].withDefaultValue(0)
    val lengthHalf = a.length / 2
    for (elem <- a) {
      counts(elem) += 1
      if (counts(elem) > lengthHalf) {
        return elem
      }
    }
    Int.MaxValue
  }
}
