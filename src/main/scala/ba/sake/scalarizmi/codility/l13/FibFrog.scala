package ba.sake.scalarizmi.codility.l13

object frogfib extends App {
  val f = new FibFrog
  println(f.solution(Array(0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0))) // 3
  println(f.solution(Array(1))) // 1
  println(f.solution(Array())) // 1
  println(f.solution(Array(0, 0, 0))) // -1
  println(f.solution(Array(1, 1))) // 1

}

// 75% correct, not perfy: O(N * log(N) ** N)
class FibFrog {

  def solution(a: Array[Int]): Int = {

    val fibs = Array.ofDim[Boolean](a.length + 3)
    fibs(0) = true
    fibs(1) = true

    var prevPrevFib = 0
    var prevFib = 1
    while (prevFib + prevPrevFib < fibs.length) {
      val fib = prevFib + prevPrevFib
      fibs(fib) = true
      prevPrevFib = prevFib
      prevFib = fib
    }
    println(fibs.toList)

    val availableJumps = a.toBuffer.zipWithIndex.filter(_._1 == 1).map(_._2)
    availableJumps.prepend(-1)
    availableJumps.append(a.length)

    val minJumpsTo = Array.fill(availableJumps.length)(Int.MaxValue)
    minJumpsTo(0) = 0
    for (i <- minJumpsTo.indices.tail) {
      for (j <- 0 until i) {
        val diff = availableJumps(i) - availableJumps(j)
        val isFib = fibs(diff)
        val isSmaller = minJumpsTo(j) + 1 < minJumpsTo(i)
        val isOverflow = minJumpsTo(j) == Int.MaxValue
        if (isFib && isSmaller && !isOverflow) {
          minJumpsTo(i) = minJumpsTo(j) + 1
        }
      }
    }
    println(availableJumps.toList)
    println(minJumpsTo.zipWithIndex.toList)

    val last = minJumpsTo.last
    if (last == Int.MaxValue) -1 else last
  }
}
