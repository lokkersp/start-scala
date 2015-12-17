sealed abstract class ParseResult[+T] {
  def get: T
  val next: Input
}
case class Success[+T](result:T,override val next: Input) extends ParseResult[T]{

}