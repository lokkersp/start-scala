/* equivalent descriptions below
def count[A](l:List[A]) = l.size
def count(l:List[_]) = l.size
def count[T](l: List[T forSome {type T}]) = l.size
*/
/*
def drop1(l:List[_]) = l.tail
def drop1(l:List[T forSome {type T}]) = l.tail
drop1(List(1,2,3,4))
*/

def hashcodes(l: Seq[_ <: AnyRef]) = l map (_.hashCode)
//fall down below
//hashcodes(Seq(1,2,23))
hashcodes(Seq("one","two","three"))
hashcodes(Seq(1,2,3).asInstanceOf[Seq[AnyRef]])