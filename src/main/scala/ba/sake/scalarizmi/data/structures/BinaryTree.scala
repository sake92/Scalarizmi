package ba.sake.scalarizmi.data.structures

import pprint.*

@main def binTreeMain(): Unit = {
  val bin = BinaryTree(
    BinaryTree(
      None,
      10,
      None
    ),
    50,
    BinaryTree(
      BinaryTree(
        None,
        60,
        None
      ),
      70,
      BinaryTree(
        None,
        90,
        None
      )
    )
  )
  pprintln(bin)

  pprintln(BinaryTree.search(bin, 70))
  pprintln(BinaryTree.search(bin, 77))
}

case class BinaryTree(
    left: Option[BinaryTree],
    value: Int,
    right: Option[BinaryTree]
)

object BinaryTree {
  def apply(left: BinaryTree, value: Int, right: BinaryTree): BinaryTree =
    BinaryTree(Some(left), value, Some(right))
  
  def search(bt: BinaryTree, x: Int): Option[Int] =
    if x == bt.value then Some(x)
    else if x < bt.value then bt.left.flatMap(search(_, x))
    else bt.right.flatMap(search(_, x))
}
