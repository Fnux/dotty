import scala.quoted._

object Test {

  def main(args: Array[String]): Unit = {
    implicit val toolbox: scala.quoted.Toolbox = scala.quoted.Toolbox.make(getClass.getClassLoader)
    val f = run {
      f1
    }
    println(f(42))
    println(f(43))
  }

  def f1 given QuoteContext: Expr[Int => Int] = '{ n => ${f2('n)} }
  def f2 given QuoteContext: Expr[Int => Int] = '{ n => ${f3('n)} }
  def f3 given QuoteContext: Expr[Int => Int] = '{ n => ${f4('n)} }
  def f4 given QuoteContext: Expr[Int => Int] = '{ n => n }
}
