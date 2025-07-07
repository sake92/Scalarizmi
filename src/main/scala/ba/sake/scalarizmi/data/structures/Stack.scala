package ba.sake.scalarizmi.data.structures

@main def stackMain(): Unit = {

  val s = new Stack()
  s.push(5)
  s.push(7)
  println(s.pop())
  println(s.isEmpty)
  s.pop()
  println(s.isEmpty)
  s.pop() // Underflow
}

class Stack(capacity: Int = 100) {
  require(capacity > 0, "Capacity must be positive")

  private val values: Array[Int] = Array.ofDim(capacity)

  private var topIndex: Int = -1

  def isEmpty: Boolean =
    topIndex == -1

  def push(newValue: Int): Unit = {
    topIndex += 1
    values(topIndex) = newValue
  }

  def pop(): Int = {
    if (isEmpty) throw new RuntimeException("Underflow")
    val value = values(topIndex)
    topIndex -= 1
    value
  }
}
