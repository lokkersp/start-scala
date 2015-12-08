implicit def strToInt (x:String)= x.toInt
//implicit def floatToInt (x:Float) = x.toInt
//val y:Int = "123"

class Container [A <% Int] {def addIt(x:A) = 123 + x}
/*
A <% Int : said what, A is visible like Int type
 */
(new Container[String]).addIt("123")
(new Container[Int]).addIt(123)
/*
(new Container[Float]).addIt(123.5F)
No implicit view available from Float => Int.
it's must be defined thought function
 */

/*
Another type restrictions:
A =:= B   A must be EQUALS B
A <:< B   A must be SUBTYPE of B
A <%< B   A must be LOOKS LIKE B
 */
class ContainerE[A](value:A) {
 /*
    falls:
    def addIt(implicit evidence: A =:= Int) = 123 + value
    why: we can't prove that String =:= Int
    how-to fix: replace =:= with <%<
    def addIt[A](evidence: A <%< Int) = 123 + value
  */

}
(new ContainerE("123"))
//(new ContainerE("123")).addIt
