import scala.util.matching.Regex

var avgCollision:Double = 0
var avgComCount:Double = 0

def IsPattern(s:String,p:Regex):Boolean = s match {
  case p => return true;
  case _=> return false;
}

def hashCompute(s:String):Int = {
  val c = s.toCharArray()
  return (c.head:Int) + (c.last:Int);
}

def getHash(s:String):Int = {
  var r:Int = 0;
  val pattern = new Regex("[A-Z]+")
  if(IsPattern(s,pattern)) {
    return hashCompute(s);
  }
  return r;
}
def reHash(s:String):Int = {
  val c = s.toCharArray()
  if (!c.head.isUpper && c.last.isLower){
  return (c.head.toUpper:Int) + (c.last.toUpper:Int);}
  return (c.head:Int) + (c.last.toUpper:Int)
}
def IsCollision(m:Map[Int,String],k:Int):Boolean = {
  m.contains(k);
}

def putToMap(mx:Map[Int,String],ex:String):Map[Int,String] = {
  val k= getHash(ex);
  var e:String = ex;
  var m:Map[Int,String] = mx;
  if(!IsCollision(mx,k)) {
    m += (k->e);
  }
  return m;
}

var m:Map[Int,String] = Map()
m = putToMap(m,"first")
m = putToMap(m,"First")
m += ("first".hashCode()->"first")
m
m += ("first".hashCode()->"first")
m
m = putToMap(m,"First")
//m: Map[Int,String] = Map()
//m: Map[Int,String] = Map(218 -> first)
//m: Map[Int,String] = Map(218 -> first, 186 -> First)
//res0: Unit = ()
//res1: Map[Int,String] = Map(218 -> first, 186 -> First, 97440432 -> first)
//res2: Unit = ()
//res3: Map[Int,String] = Map(218 -> first, 186 -> First, 97440432 -> first)
//m: Map[Int,String] = Map(218 -> first, 186 -> First, 97440432 -> first)
