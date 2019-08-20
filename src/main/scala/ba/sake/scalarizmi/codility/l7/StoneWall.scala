package ba.sake.scalarizmi.codility.l7

trait StoneWall {
  def solution(h: Array[Int]): Int
}

object StoneWall1 extends StoneWall {
  import scala.collection.mutable.Stack

  def solution(h: Array[Int]): Int = {
    val existingBlocks = Stack.empty[Int]
    var count = 0
    for (height <- h) {
      while (existingBlocks.nonEmpty && height < existingBlocks.head) {
        existingBlocks.pop() // remove all higher than current
      }

      if (existingBlocks.isEmpty) {
        count += 1
      } else if (existingBlocks.head != height) {
        count += 1
      }
      existingBlocks push height
    }
    count
  }
}
