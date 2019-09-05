package ba.sake.scalarizmi.data.structures

object binnnnnn extends App {
  val bin = new BinaryTree(1, new BinaryTree(2, null, null), null)
  println(bin)
}

class BinaryTree(
    val value: Int,
    val left: BinaryTree,
    val right: BinaryTree
) {
  override def toString: String = s"BinTree(value=$value, left=$left, right=$right)"
}
