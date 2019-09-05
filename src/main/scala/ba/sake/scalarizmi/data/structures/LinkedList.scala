package ba.sake.scalarizmi.data.structures

object linkeddd extends App {
  val list = new LinkedList(1, new LinkedList(2, null))
  println(list)
  println(list.find(2))
  println(list.find(5)) // None
}

class LinkedList(
    val value: Int,
    val next: LinkedList
) {
  override def toString: String = s"LinkedList($value, $next)"

  def find(x: Int): Option[Int] = {
    var res = this
    while (res != null && res.value != x) {
      res = res.next
    }
    Option(res).map(_.value)
  }
}

///////////////////////////
///////////////////////////
/* doubly linked list */
object doublyLinked extends App {
  val list = new DoublyLinkedList(1, new DoublyLinkedList(2, new DoublyLinkedList(3, null)))
  println(list)

  var bla = list
  while (bla != null) {
    println(s"value=${bla.value}\t next=${bla.next}\t prev=${bla.prev}")
    bla = bla.next
  }
}

class DoublyLinkedList(
    val value: Int,
    var next: DoublyLinkedList
) {
  var prev: DoublyLinkedList = _

  if (next != null) {
    next.prev = this
  }

  override def toString: String = s"DoublyLinkedList($value, $next)"
}
