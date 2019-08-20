package ba.sake.scalarizmi.codility.l1

// Find longest sequence of zeros in binary representation of an integer.
trait BinaryGap {
  def solution(n: Int): Int
}

// solution #1
// count consecutive 0-s,
// when a 1 is encountered:
// - see if that's the max seq of 0-s
// - reset the counter
// - last 0-s won't count, because there's no 1 on the end... :)
object BinaryGap1 extends BinaryGap {

  def solution(n: Int): Int = {
    val nAsBinary = n.toBinaryString
    var longestSeq = 0
    var tmpLongestSeq = 0
    for (c <- nAsBinary) {
      if (c == '0') tmpLongestSeq += 1
      else {
        if (tmpLongestSeq > longestSeq)
          longestSeq = tmpLongestSeq
        tmpLongestSeq = 0
      }
    }
    longestSeq
  }
}

// solution #2
// using regex, simpler to understand
object BinaryGap2 extends BinaryGap {

  def solution(n: Int): Int = {
    val nAsBinary = n.toBinaryString.reverse.dropWhile(_ == '0').reverse // drop trailing zeros

    val consecZerosGroups = nAsBinary
      .split("1+") // split by ones
      .sortBy(-_.length) // sort by length descending

    if (consecZerosGroups.isEmpty) 0
    else consecZerosGroups(0).length
  }
}
