package ba.sake.scalarizmi.codility.l7

trait Nesting {
  def solution(s: String): Int
}

// O(n)
object Nesting1 extends Nesting {

  def solution(s: String): Int = {
    var open = 0
    for (c <- s) {
      if (c == '(') {
        open += 1
      } else if (open == 0) {
        return 0
      } else {
        open -= 1
      }
    }
    if (open == 0) 1 else 0
  }
}

// 62%, 100% correct, but perfs 25%
object Nesting2 extends Nesting {

  def solution(s: String): Int = {

    @scala.annotation.tailrec
    def go(str: String, currentOpen: Int): Int = {
      if (str.isEmpty) {
        if (currentOpen == 0) 1
        else 0
      } else {
        val current = str.head
        val rest = str.tail
        if (current == '(')
          go(rest, currentOpen + 1)
        else if (currentOpen > 0)
          go(rest, currentOpen - 1)
        else
          0
      }
    }

    go(s, 0)
  }
}
