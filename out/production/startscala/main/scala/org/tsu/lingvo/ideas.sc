import scala.collection.mutable.ListBuffer

val s= "((a+b)*(c+d))"
s.length()
val ca = s.toCharArray()
//ca.ta
var t:ListBuffer[Array[Char]]= ListBuffer[Array[Char]]()
def cutFromTo( r: Array[Char],a:Int,b:Int):Array[Char] = {
  return r.takeRight(b-a)
}
var j = 0;
for(i<- 0 until ca.length) {
 if(ca.charAt(i) == '(') {t+=cutFromTo(ca,i,ca.length)
 j+=1;
 }
}

t.toList
