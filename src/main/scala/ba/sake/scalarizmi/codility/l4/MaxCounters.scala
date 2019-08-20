package ba.sake.scalarizmi.codility.l4

// Calculate the values of counters after applying all alternating operations:
// increase counter by 1; set value of all counters to current maximum.
trait MaxCounters {
  def solution(n: Int, a: Array[Int]): Array[Int]
}

object MaxCounters1 extends MaxCounters {

  def solution(n: Int, a: Array[Int]): Array[Int] = {
    var counters = Array.fill(n)(0)
    var maxCurrent = 0
    var didReset = false // avoid unnecessary resets, perfy
    for (operation <- a) {
      if (1 <= operation && operation <= n) {
        val i = operation - 1
        counters(i) += 1 // increment i-th element
        if (counters(i) > maxCurrent) { // set if new max
          maxCurrent = counters(i)
        }
        didReset = false
      } else if (!didReset) { // if we get MAX,MAX,MAX... we only MAX once :)
        for (i <- counters.indices)
          counters(i) = maxCurrent
        didReset = true
      }
    }
    counters
  }
}
