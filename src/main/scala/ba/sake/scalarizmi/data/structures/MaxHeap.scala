package ba.sake.scalarizmi.data.structures

object MaxHeapTest extends App {

  val heap1 = new MaxHeap(16, Array(16, 14, 10, 8, 7, 9, 3, 2, 4, 1))
  println(heap1)
  println("values(1)=" + heap1.values(1))
  println("parentIndex=" + heap1.values(heap1.parentIndex(1)))
  println("leftIndex=" + heap1.values(heap1.leftIndex(1)))
  println("rightIndex=" + heap1.values(heap1.rightIndex(1)))
  println("max=" + heap1.max)

  // heapify works !
  println("HEAPIFYYYYYYYYYYYYYYYYY")
  heap1.values(0) = 6
  println(heap1)
  heap1.heapify(0)
  println(heap1)

  // buildHeap
  println("BUILDDDDDDDDDDDd")
  val heap2 = new MaxHeap(16, Array(9, 2, 10, 8, 7, 16, 3, 14, 4, 1))
  println(heap2)

  // heapsort
  println("SORTTTTTTTTTTT")
  heap2.heapsort()
  println(heap2)

  // extract max
  val heap3 = new MaxHeap(16, Array(9, 2, 10, 8, 7, 16, 3, 14, 4, 1))
  println("EXTRACTTTTT")
  println(heap3.extractMax)
  println(heap3)

  println("INCRRRRR")
  heap3.incrValue(2, 17)
  println(heap3)

  println("ADDDD")
  heap3.addValue(15)
  println(heap3)
}

class MaxHeap(capacity: Int, arr: Array[Int]) {

  val values: Array[Int] = Array.ofDim[Int](capacity + 5) // +2 coz I'm lazy
  Array.copy(arr, 0, values, 0, arr.length)

  private var size = arr.length // pointer to last
  buildHeap()

  def parentIndex(i: Int): Int =
    if (i == 0) 0 else i / 2
  def leftIndex(i: Int): Int =
    i * 2 + 1
  def rightIndex(i: Int): Int =
    i * 2 + 2

  def max: Int =
    values(0)

  def extractMax: Int = {
    if (size < 1) throw new RuntimeException("No max in empty heap")
    val max = values(0)
    values(0) = values(size - 1)
    size -= 1
    heapify(0)
    max
  }

  def incrValue(i: Int, newValue: Int): Unit = {
    if (newValue < values(i)) throw new RuntimeException("New value is not bigger")
    values(i) = newValue
    var idx = i
    while (idx > 0 && values(idx) > values(parentIndex(idx))) {
      swap(idx, parentIndex(idx))
      idx = parentIndex(idx)
    }
  }

  def addValue(newValue: Int): Unit = {
    size += 1
    values(size - 1) = Int.MinValue
    incrValue(size - 1, newValue)
  }

  def heapify(i: Int): Unit = {

    val leftIdx = leftIndex(i)
    val rightIdx = rightIndex(i)
    var maxIdx = i
    if (leftIdx < size && values(leftIdx) > values(maxIdx)) {
      maxIdx = leftIdx
    }
    if (leftIdx < size && values(rightIdx) > values(maxIdx)) {
      maxIdx = rightIdx
    }
    if (maxIdx != i) { // not ok, must push it down
      swap(i, maxIdx)
      heapify(maxIdx)
    }
  }

  def buildHeap(): Unit = {
    // if i>n/2 it means that's  a leaf
    // so we heapify just the parents
    for (i <- size / 2 to 0 by -1) {
      heapify(i)
    }
  }

  // sorts in ASC order: 1,2,3
  def heapsort(): Unit = {
    // - swap 0-th (max) with n-1
    // - size--
    // heapify and repeat :)
    buildHeap()
    for (i <- size - 1 to 1 by -1) {
      swap(0, i)
      size -= 1
      heapify(0)
    }
  }

  private def swap(i: Int, j: Int): Unit = {
    val tmp = values(i)
    values(i) = values(j)
    values(j) = tmp
  }

  override def toString: String = values.mkString(",")
}
