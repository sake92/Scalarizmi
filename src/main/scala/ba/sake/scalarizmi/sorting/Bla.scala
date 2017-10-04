package ba.sake.scalarizmi.sorting

object Bla extends App {

  //val alg = InsertionSort
  val alg = SelectionSort
  
  val array = Array(5,2,4,-5,15,16,1)
  
  val res =alg.sort(array)
  


println(res.toList)


}
