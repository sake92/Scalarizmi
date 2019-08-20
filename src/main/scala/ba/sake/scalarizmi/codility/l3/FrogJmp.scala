package ba.sake.scalarizmi.codility.l3

/*
Frog is currently located at X and wants to get to a position >= Y.
Frog always jumps a fixed distance, D.
Count the *minimal number of jumps* frog must perform to reach its target.
 */
trait FrogJmp {
  def solution(x: Int, y: Int, d: Int): Int
}

// proper, performant solution
object FrogJmp1 extends FrogJmp {

  def solution(x: Int, y: Int, d: Int): Int = {
    // N*d + x >= y
    // N >= (y - x)/d
    Math.ceil((y - x).toDouble / d).toInt
  }
}

// nope, doesn't satisfy performance
object FrogJmp2 extends FrogJmp {

  def solution(x: Int, y: Int, d: Int): Int = {
    var numJumps = 0
    var tempPos = x
    while (tempPos < y) {
      tempPos += d
      numJumps += 1
    }
    numJumps
  }
}