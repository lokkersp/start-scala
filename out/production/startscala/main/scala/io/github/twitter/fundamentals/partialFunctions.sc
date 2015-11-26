val one: PartialFunction[Int, String] = { case 1 => "one" }
one.isDefinedAt(1)
one.isDefinedAt(2)
one(1)

val two: PartialFunction[Int, String] = { case 2 => "two" }
val three: PartialFunction[Int, String] = { case 3 => "three" }
val wildcard: PartialFunction[Int, String] = { case _ => "something else" }

val pf = one orElse two orElse three orElse wildcard
pf.isDefinedAt(3)
pf(3)
pf.isDefinedAt(4)
pf(4)
