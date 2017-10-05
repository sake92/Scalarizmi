package ba.sake.scalarizmi.sorting

object Bla extends App {

  val alg = BubbleSort

  val array = Array(5, 2, 4, 1)

  val res = alg.sort(array)

  println(res.toList)

}
