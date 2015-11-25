val r = 2::1::"foo"::"bar"::Nil
r.head
r.tail

def drop1[A](l:List[A]) = l.tail

drop1(List(1,2,3))

def toList[A](a:A) = List(a)
//actual not works cause : all type variables must be defined at invocation
/*
def foo[A,B](f:A => List[A],b:B) = f(b)

def foo[A](f: A=>List[A],i:Int) = f(i)
*/

//out of type
//map to type
def id[T](x : T) = x
val intID = id(12)
val arrayID = id(Array(1,2,3,4))

