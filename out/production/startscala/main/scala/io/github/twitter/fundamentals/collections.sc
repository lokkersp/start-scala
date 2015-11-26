val nums = List(1,2,3,4,5) //list

val setOfNums = Set(1,1,2) //set
//domain

val netAdress = ("localhost",80)

netAdress._1
netAdress._2
netAdress match {
  case ("localhost",80) => "std HTTP local port"
  case ("localhost",_) => "not resolved port"
}

val myMap = Map (1 -> 2)
myMap.get(1)
val textMap = Map("foo"->"bar")
val textInv = Map("bar"->"foo")
val hybrid = Map(1->textMap,2->textInv)
//hybrid.get(1).get("bar") noSuchElementException
hybrid.get(1).getOrElse("bar","foo")

