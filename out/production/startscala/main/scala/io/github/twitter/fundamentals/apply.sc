/*
object FooMaker {
  def apply() = new FooMaker
}
*/

class Bar {
  def apply() = 0
}

val bar = new Bar
bar()