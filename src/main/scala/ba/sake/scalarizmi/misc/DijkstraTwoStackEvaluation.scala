package ba.sake.scalarizmi.misc

import scala.collection.mutable.Stack

object DijkstraTwoStackEvaluation extends App {

  val c = 'f'
  val cccc = '\u0000'

  println(
    evaluate(" ( 1 + ( 2 * sqrt ( 4 ) ) ) ") // 5
  )

  def evaluate(input: String): Double = {
    val ops = new Stack[String]
    val vals = new Stack[Double]
    for (c <- input.split("\\s+").filterNot(_.trim.isEmpty)) {
      val s = c.toString
      s match {
        case "(" | " "                      => // ignore
        case "+" | "-" | "*" | "/" | "sqrt" => ops.push(s)
        case ")" =>
          val op = ops.pop
          val val1 = vals.pop
          op match {
            case "+" =>
              val val2 = vals.pop
              vals.push(val1 + val2)
            case "-" =>
              val val2 = vals.pop
              vals.push(val1 - val2)
            case "*" =>
              val val2 = vals.pop
              vals.push(val1 * val2)
            case "/" =>
              val val2 = vals.pop
              vals.push(val1 / val2)
            case "sqrt" =>
              vals.push(Math.sqrt(val1))
          }
        case num => vals.push(num.toDouble)
      }
    }
    vals.pop
  }
}
