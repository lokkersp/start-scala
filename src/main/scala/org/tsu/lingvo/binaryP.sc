import scala.util.parsing.combinator.{ImplicitConversions, JavaTokenParsers}
import scala.util.parsing.combinator.syntactical.StandardTokenParsers
sealed trait Expr
case class Num(i:Int) extends Expr
case class Logical(i:Boolean) extends Expr
case class Var(n:String) extends Expr

case class Add(e1:Expr,e2:Expr) extends Expr
case class Mul(e1:Expr,e2:Expr) extends Expr
case class And(e1:Expr,e2:Expr) extends Expr
case class Or(e1:Expr,e2:Expr) extends Expr
case class Xor(e1:Expr,e2:Expr) extends Expr
case class Not(e1:Expr) extends Expr

object ArithParsers extends StandardTokenParsers with ImplicitConversions {
  lexical.delimiters += ("(",")","+","*")
  def expr:Parser[Expr] =
    term ~ ("+" ~> expr) ^^ Add | term
  def term: Parser[Expr] =
    factor ~ ("*" ~> term) ^^ Mul | factor
  def factor: Parser[Expr] =
  numericLit ^^ {s=>Num(s.toInt)} | ident ^^ Var | "(" ~> expr <~ ")"

  def parseExpr(s:String) = phrase(expr)(new lexical.Scanner(s))
}
object LogicalParsers extends StandardTokenParsers with ImplicitConversions {
  lexical.delimiters += ("(",")","&&","||","^","!")
  def expr:Parser[Expr] =
    term ~ ("||" ~> expr) ^^ Or | term
  def term:Parser[Expr] =
  factor ~ ("&&" ~> term) ^^ And | factor
  def factor:Parser[Expr] =
  numericLit ^^ {s=>Logical(s.toBoolean)}| ident ^^ Var |"(" ~> expr <~ ")"

  def parseExpr(s:String) = phrase(expr)(new lexical.Scanner(s))
}

val at0 = ArithParsers.parseExpr("1")
val at1 = ArithParsers.parseExpr("1 + 1 * 2")
val bt0 = LogicalParsers.parseExpr("true")
val bt01 = LogicalParsers.parseExpr("true || false && true")
