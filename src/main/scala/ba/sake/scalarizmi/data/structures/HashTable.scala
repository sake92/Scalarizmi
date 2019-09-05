package ba.sake.scalarizmi.data.structures

object mappppppppppp extends App {
  val map = new HashTable()
  map.put(1, 5)
  map.put(2, 6)
  map.put(21, 7) // should be in same bucket as 5
  println(map)
}

class HashTableEntry(
    val key: Int,
    val value: Int,
    var next: HashTableEntry // linked list of entries with same hash
)

class HashTable(numBuckets: Int = 10) {

  private val values = Array.ofDim[HashTableEntry](numBuckets)

  def hash(key: Int): Int = {
    key % numBuckets
  }

  def put(key: Int, value: Int): Unit = {
    val keyHash = hash(key)
    var existingEntry = values(keyHash)
    if (existingEntry == null) {
      existingEntry = new HashTableEntry(key, value, null)
      values(keyHash) = existingEntry
    } else {
      while (existingEntry.next != null) {
        existingEntry = existingEntry.next // get to the last element
      }
      existingEntry.next = new HashTableEntry(key, value, null)
    }
  }

  override def toString: String = {
    val sb = new StringBuilder
    for (e <- values if e != null) {
      toString(sb, e)
      var next = e.next
      while (next != null) {
        toString(sb, next)
        next = next.next
      }
    }
    sb.toString()
  }

  private def toString(sb: StringBuilder, e: HashTableEntry): Unit = {
    sb.append(e.key)
    sb.append("->")
    sb.append(e.value)
    sb.append(", ")
  }

}
