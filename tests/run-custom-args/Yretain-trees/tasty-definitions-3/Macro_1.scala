import scala.quoted._
import scala.quoted.autolift._

object Foo {

  inline def inspectBody(i: => Int): String =
    ${ inspectBodyImpl('i) }

  def inspectBodyImpl(x: Expr[Int]) given (qctx: QuoteContext): Expr[String] = {
    import qctx.tasty._
    def definitionString(tree: Tree): Expr[String] = tree.symbol match {
      case IsDefDefSymbol(sym) => sym.tree.showExtractors
      case IsValDefSymbol(sym) => sym.tree.showExtractors
      case IsBindSymbol(sym) => sym.tree.showExtractors
    }
    x.unseal match {
      case Inlined(None, Nil, arg) => definitionString(arg)
      case arg => definitionString(arg) // TODO should all by name parameters be in an inline node?
    }
  }
}
