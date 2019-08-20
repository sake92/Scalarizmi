package ba.sake.scalarizmi.codility.l7

trait Brackets {
  def solution(s: String): Int
}

object Brackets1 extends Brackets {
  import scala.collection.mutable.Stack

  def solution(s: String): Int = {

    var stack = Stack.empty[Char]

    for (c <- s) {
      if (c == '(' || c == '[' || c == '{') {
        stack push c
      } else {
        if (stack.isEmpty) return 0

        val last = stack.pop()
        val mismatch = (c == ')' && last != '(') ||
          (c == ']' && last != '[') ||
          (c == '}' && last != '{')

        if (mismatch) return 0
      }
    }

    if (stack.isEmpty) 1
    else 0
  }
}
