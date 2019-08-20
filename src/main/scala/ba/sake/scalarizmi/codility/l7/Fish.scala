package ba.sake.scalarizmi.codility.l7

trait Fish {
  def solution(a: Array[Int], b: Array[Int]): Int
}

// - collect all fish going downstream, last on top (that's why we use Stack)
// - remove if upstream fish is bigger
object Fish1 extends Fish {
  import scala.collection.mutable.Stack

  def solution(a: Array[Int], b: Array[Int]): Int = {

    var i = 0
    var countAlive = a.length
    val downstreamFish = Stack.empty[Int]
    while (i < a.length) {
      val currentWeight = a(i)
      val currentDirection = b(i)

      if (currentDirection == 1) {
        downstreamFish push currentWeight
      } else {
        var currentEaten = false
        while (downstreamFish.nonEmpty && !currentEaten) {

          if (currentWeight > downstreamFish.head) {
            downstreamFish.pop()
          } else {
            currentEaten = true
          }
          countAlive -= 1
        }
      }
      i += 1
    }

    countAlive
  }
}
