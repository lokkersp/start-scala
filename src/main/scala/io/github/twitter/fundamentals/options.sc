val numbers = Map("one"->1,"two"->2,"three"->3,"four"->4,"five"->5)

numbers.get("one")
val r= numbers.get("six")
val result = r match {
 case Some(n) => n * 2
 case None => 0
}

def doubleOneOf(m:Map[String,Int],which:String): Int = {
  val e = m.get(which)
  val result = e match {
    case Some(n) => n * 2
    case None => 0
  }
  return result
}

doubleOneOf(numbers,"six")
doubleOneOf(numbers,"five")

numbers.flatMap((i:Int)=>i)