val times = 1

times match {
 case 1 => "one"
 case 2 => "two"
 case _ => "something else"
}

def matchInt(some:Int):String = {
  return some match {
    case 1 => "one"
    case 2 => "two"
    case _ => "something else"
  }
}

matchInt(2)

case class Calculation(brand:String,model:String)
val hp20b = Calculation("hp","20b")
val hp20B = Calculation("hp", "20b")
val hp30b = Calculation("hp","30b")
val t = (a:Calculation,b:Calculation) => a == b

t(hp20b,hp20B)

def cType(c:Calculation) = c match {
  case Calculation("hp","20b") => "fin"
  case Calculation("hp","48g") => "sci"
  case Calculation("hp","30b") => "busi"
  case Calculation(ourB,ourM) => "C (%s,%s) is unknown type".format(ourB,ourM)
}

cType(Calculation("canon","you"))
