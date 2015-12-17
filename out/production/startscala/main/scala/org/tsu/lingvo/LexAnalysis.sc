import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/*
S -> S+T|S-T|T
T -> T*E|T/E
E -> F
F -> X|V|I|(S)
O -> {+,-,*,/,(,)}
*/
def howMany(s:String):Int = {
  var count:Int = 0;
  val ca = s.toCharArray()
  for(x <- ca)
  if(x == ';') count +=1;
  return count;
}
def oneOf(s:String) = {
  val sep:String = ";";
 // s.filter(';')
}
def howManyChars(ca:Array[Char],c:Char):Int = {
  var count:Int = 0;
  for(x <- ca)
    if(x == c) count +=1;
  return count;
}

def exprCount(s:String):Any = {
}
def hasRightHooks(s:String): Boolean = {
  val o:Char = '('
  val c:Char = ')'
  val sCA = s.toCharArray()
  if (sCA.contains(o) && sCA.contains(c)) {
    if (howManyChars(sCA,o) == howManyChars(sCA,c)){
    return true;
    } else return false;
  }
  else return false;
}

def expDiff(s:String):Map[Int,String] = {
  var m:Map[Int,String]=Map()

  return m;
}
def returnNestedEx(ca:Array[Char]) = {
  var n:Int = 0;
  val l:Char = '(';
  val r:Char = ')';
  var ex:String = "";
  var exList:List[String] = List();
  for(x<-ca) {
    if(x == l) {

    }

  }
}
"array1;array2;".endsWith(";")//.indexOf(";")
howMany("")
hasRightHooks("(array1;array2;)")
hasRightHooks("(array1;array2;))")
"((a+b)*(c+d))".lastIndexOf(')')
"(()())".indexOf('(')
val s = "(()())"
var i:Int = 0
for(v <- s) {
  if (v == '(') i+= 1
}
"((a+b)*(c+d))".charAt(0)
"((a+b)*(c+d))".charAt(12)
"((a+b)*(c+d))".length
def getHooksPos():ListBuffer[ListBuffer[Int]] = {
  val ca = "((a+b)*(c+d))".toCharArray()
  var a: ListBuffer[Int] =  new ListBuffer[Int]()
  var b: ListBuffer[Int] = new ListBuffer[Int]()
  for (i <- 0 to ca.length-1) {
    if (ca.charAt(i) == '(') a+=i
    if (ca.charAt(i) == ')') b+=i
  }
  val r: ListBuffer[ListBuffer[Int]] =ListBuffer(a,b)
  return r;
}
def exprPairs(L:ListBuffer[ListBuffer[Int]]) = {
}

val L = getHooksPos()
var a = L.toList(0)
var b = L.toList(1)
List(a,b).foldRight(_=>_)

var temp = mutable.Map[Int,ListBuffer[Int]]()
val pair = mutable.Map[Int,Int]()
for(i<-0 to a.size-1) {
  temp += a(i)->b.filter(t=>a(i)<t)
}
temp
for ((k,v)<-temp) {
  val t:Int = v.toList.head
  pair += k->t
  temp.remove(k)
  for (elem <- temp) {
    elem._2.drop(t)
  }
}
temp
pair

