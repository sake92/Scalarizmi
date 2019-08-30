package ba.sake.scalarizmi.data.structures

object qqqqqq extends App {
  val q = new Queue(4)

  for (i <- 1 to 3) {
    q.enqueue(i)
    println(q)
  }

  println(q.dequeue())
  println(q.dequeue())
  println(q.dequeue())
  println(q)
  println(q.dequeue()) // empty

}

class Queue(capacity: Int = 16) {
  require(capacity > 0)

  private val values: Array[Int] = Array.ofDim(capacity)

  private var head = 0 // take from the start, head
  private var tail = 0 // insert at the end, tail

  def enqueue(x: Int): Unit = {
    if (nextTail == head)
      throw new RuntimeException("Full")

    values(tail) = x
    tail = nextTail
  }

  def dequeue(): Int = {
    if (tail - head == 0)
      throw new RuntimeException("Empty")

    val res = values(head)
    head = nextHead
    res
  }

  private def nextHead =
    if (head == values.length - 1) 0 else head + 1

  private def nextTail =
    if (tail == values.length - 1) 0 else tail + 1

  override def toString: String = s"Q(${values.mkString(",")}) h=$head t=$tail"
}
