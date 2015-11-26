object Timer {
  var count = 0

  def crntCnt(): Long = {
    count += 1
    count
  }
}
//usage
Timer.crntCnt()
class Bar(foo:String)

object Bar {
  def apply(foo:String) = new Bar(foo)
}

Bar.apply("foo")

val b = Bar.apply("bar")

//function as object
object addOne extends Function1[Int,Int] {
  def apply(m: Int): Int = m + 1
}

addOne(1)

class AddOne extends Function1[Int,Int] {
  def apply(m:Int) = m +1
}

val plusOne = new AddOne
plusOne(1)

class AddOneAnother extends (Int => Int) {
  def apply(m: Int) = m +1
}

val addOneAnother = new AddOneAnother
addOneAnother(1)