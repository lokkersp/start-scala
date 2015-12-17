import scala.util.parsing.combinator.RegexParsers

class  Parsers extends RegexParsers {
  def bool: Parser[Boolean] = ("true" | "false") ^^ {
    case tree => tree.toBoolean
    case _ => throw new Exception("Invalid booleans")
  }
  def and: Parser[Boolean] = bool ~ opt("&&" ~ bool) ^^ {
    case tree1 ~ None => tree1
    case tree1 ~ Some("&&" ~ tree2) => tree1 && tree2
  }
  def or: Parser[Boolean] = bool ~ rep("||" ~> bool) ^^ {
    case tree1 ~ Nil => tree1
    case tree1 ~ bools => tree1 || bools.reduce(_||_)
  }
  def xor: Parser[Boolean] = bool ~ opt("^" ~ bool) ^^ {
    case tree1 ~ None => tree1
    case tree1 ~ Some("^" ~ tree2) => tree1 ^ tree2
  }
  def not: Parser[Boolean] = bool ~ opt("!" ~ bool) ^^ {
    case tree1 ~ None => tree1
    case tree1 ~ bools => !(tree1)
  }
}
val parser = new Parsers
val exp = "true ^ true "
parser.parseAll(parser.bool,exp)