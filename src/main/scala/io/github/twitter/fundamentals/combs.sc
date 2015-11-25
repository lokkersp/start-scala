val numbers = List(1,2,3,4,5,6,7,8,9,10)
numbers.map((i:Int)=>i*2)

def timesTwo(i:Int):Int = i*2
numbers.map(timesTwo _)

numbers.foreach((i:Int)=> i*2)
numbers.filter((i:Int)=> i % 2 == 0)
val l = List(1,2,3).zip(List("a","b","c"))
List(1,2,3,4,5,6,7,8,9,10).partition(_ % 2 == 0)

val dropped = numbers.drop(5)

val whileDropped = numbers.dropWhile(_ % 2 != 0)

val foldL = numbers.foldLeft(0)((m:Int,n:Int)=>m+n)


numbers.foldLeft(0) {
  (m:Int,n:Int) =>println("m:%d,n:%d".format(m,n));
    m + n
}

List(List(1,2),List(3,4)).flatten

val nestedList = List(List(1,2),List(3,4))
nestedList.flatMap(x=>x.map(_ * 2))

def myMap(mt:List[Int],f:Int=>Int):List[Int] = {
mt.foldRight(List[Int]()) {
  (x:Int,xs:List[Int]) => f(x)::xs
}
}

myMap(numbers,timesTwo _)

val extensions = Map("steve" -> 100, "bob" -> 101, "joe" -> 201)

// too fat by data collected with tuple;-> solution with pm
extensions.filter((tupled:(String,Int))=> tupled._2 < 200)

//let's pattern match
extensions.filter({case (name,number) => number < 200})