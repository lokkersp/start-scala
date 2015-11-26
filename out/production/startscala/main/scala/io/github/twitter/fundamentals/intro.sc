
/*

def mult(a:Int)(b:Int):Int = a*b
mult(2)(2)
//currying
val timesTwo = mult(2)_
timesTwo(2)


//   partial callback
def adder(m:Int,n:Int) = m + n
val add2 = adder(_:Int,2)
add2(2)
(adder _).curried
/*
val decimal = 12345L
val hexa = 0x23
//val octa = 023
val exp = 1E30
val π = scala.math.Pi

/*
val someMap = Map("foo" -> 1, "bar" -> 2)


val computers = Array(
  Map("name" -> "Macbook", "color" -> "white"),
  Map("name" -> "HP Pavillion", "color" -> "black")
)

class UAPExample {
  val someField = "hi"
  def someMethod = "there"
}
val o = new UAPExample
o.someField
o.someMethod

val hasUpperCase = "String".exists(_.isUpper)
val hasUpperCase1 = "string".exists(_.isUpper)

val src = scala.io.Source.fromFile("/Users/noctuam/Dropbox/tsu/TSSA/ranking.csv")
val cnt = src.getLines().map(x =>1).sum
//List(1, 2, 3).par.map(x => x * x)
class FileAsIter {
  def iterator = scala.io.Source.fromFile("/Users/noctuam/Dropbox/tsu/TSSA/ranking.csv").getLines()
}

val newIter = new FileAsIter with Iterable[String]
newIter.foreach {line => println(line)} */
/*
import java.util.{Calendar, TimeZone}
def ƒ(a: Int,b:Int) = a+b
def µ(timeZone: TimeZone) =
  Calendar.getInstance(timeZone).getTime
ƒ(2,3)
µ(TimeZone.getDefault)
val inc = (x : Int) => x + 1
inc(ƒ(2,3))
List(1,2,3).map((x:Int) => x)
def loopTill(cond: => Boolean)(body: => Unit) : Unit = {
  if(cond) {
    body
    loopTill(cond)(body)
  }
}
var i = 10
loopTill(i > 0) {
  println(i)
  i -=1
}
*/
