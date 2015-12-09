import scala.util.matching.Regex

/*
Во всех вариантах требуется разработать программу,
 реализующую комбинированный способ организации таблицы идентификаторов.
  Для организации таблицы используется простейшая хэш-функция - "Сумма кодов первой и последней букв"
  а при возникновении коллизий используется дополнительный метод размещения идентификаторов в памяти.
  Если в качестве этого метода используется дерево или список,
  то они должны быть связаны с элементом главной хэш-таблицы.
В каждом варианте требуется, чтобы программа сообщала
среднее число коллизий и
среднее количество сравнений,
выполненных для поиска идентификатора.

Простое рехеширование


 */
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
  return (c.head:Int) + (c.last.toUpper:Int);
}
def IsCollision(m:Map[Int,String],k:Int):Boolean = {
  m.contains(k);
}

def putToMap(mx:Map[Int,String],ex:String) = {
  val k= getHash(ex);
  var e:String = ex;
  var m:Map[Int,String] = mx;
  if(!IsCollision(mx,k)) {
    m += (k->e);
  } else {
    if(m.get(k) != e) {
      m += reHash(e)->e;
    } else {
      m += ((reHash(e) + (e.size % m.size)) ->e)
    }
  }
}


var myHashMap = Map(getHash("i")->"i")
myHashMap +=(getHash("I")->"I")
