import collection.mutable.ListBuffer
def XOR(p1:Boolean,p2:Boolean):Boolean = {
  return p1 ^ p2;
}
def AND(p1:Boolean,p2:Boolean):Boolean = {
  return p1 && p2;
}
def OR(p1:Boolean,p2:Boolean):Boolean = {
  return p1 || p2;
}
def NOT(p1:Boolean):Boolean = {
  return !p1;
}
def reflect(s:String):Boolean = s match {
  case "1"=>true
  case "0"=> false
}
def backReflect(b:Boolean):String = b match {
  case true => "1"
  case false => "0"
}
def ops(o:String,p1:Boolean,p2:Boolean):Boolean = o match {
  case "AND" => AND(p1,p2)
  case "XOR" => XOR(p1,p2)
  case "OR" => OR(p1,p2)
}



def evaluateAtomic(s:String):Boolean = {
  val e ="([0-1]{1,1})\\s(AND|OR|NOT|XOR)\\s([0-1]{1,1})".r
  val p1Pattern = "([0-1]{1,1})\\s".r
  val p2Pattern = "\\s([0-1]{1,1})".r
  val notPP = "(\\s)?NOT\\s[0-1](\\s.*)?".r
  val funcPattern = "\\s(AND|OR|NOT|XOR)\\s".r
  var p1:Boolean = true;
  var p2:Boolean = true;
  var funcOp = ""
  var f:Boolean = true;

  if(p1Pattern findFirstIn(s) isDefined) {
    p1 = reflect((p1Pattern findFirstIn(s) get).trim())
  }
  if(p2Pattern findFirstIn(s) isDefined) {
    p2 = reflect((p2Pattern findFirstIn(s) get).trim())
  }
  if(funcPattern findFirstIn(s) isDefined) {
    funcOp = (funcPattern findFirstIn(s) get).trim()
  }

if(funcOp == "NOT") {
  f = NOT(p1);
} else {
  f = ops(funcOp,p1,p2)
}

  return f

}

def refToList(s:String):ListBuffer[String] = {
  var l:ListBuffer[String] = new ListBuffer[String]()
  var rs = s
  val rec = "([NOT]?([0-1]{1,1})|.*)\\s(AND|OR||XOR)\\s([NOT]?([0-1]{1,1})|.*)".r
  val notP = "[NOT]*(\\s)?([0-1]{1,1})\\s".r
  val e ="(NOT\\s)?([0-1]{1,1})\\s(AND|OR|NOT|XOR)\\s(NOT\\s)?([0-1]{1,1})".r
  var eval:Boolean = false;
  while(rs != "") {
      if(e findFirstIn(rs) isDefined) {
        eval = evaluateAtomic(e findFirstIn(rs) get)
        l += (e findFirstIn(rs) get)
        rs = rs.replaceFirst(e findFirstIn(rs) get,"")
      }
     else {
      rs = ""
    }
  }
  return l
}
val e ="(!)?([0-1]{1,1})\\s(AND|OR|NOT|XOR)\\s([0-1]{1,1})".r
val rec = "([NOT]?([0-1]{1,1})|.*)\\s(AND|OR||XOR)\\s([NOT]?([0-1]{1,1})|.*)".r
val testRec = "NOT 0 AND 1"
val TRM = rec findFirstIn(testRec)

val s = "1 XOR 1"
//val f = e findFirstIn(s) get
val eval = evaluateAtomic(s)
val re = refToList(testRec)


