/*
mutability:
Main question of mixing OOP & polymorphism :
"If T' is subclass of T.
It's correct that Container[T'] is subclass of Container[T]?

covariant
  C[T'] is subclass(sic!) of class C[T]
  Scala's notation:[+T]
contravariant
  C[T] is subclass(sic!) of class C[T']
  Scala's notation:[-T]
invariant
  C[T] & C[T'] hasn't relations
  Scala's notation:[T]

  All that big feature builds on dependency of types and definition
  relations between types
 */

class Covariant[+A]
val cv:Covariant[AnyRef] = new Covariant[String]
//errored,why?
//val cv1:Covariant[String] = new Covariant[AnyRef]
/*
I think: String isn't subclass of AnyRef, so:
 C[String] => C[AnyRef],
 isn't backward dependency:C[AnyRef] => C[String]
 so backward dependency is contravariant
 */
class Contravariant[-A]
val cnv:Contravariant[String] = new Contravariant[AnyRef]
//Yep yep, I was rigth :)
//val cnv1: Contravariant[AnyRef] = new Contravariant[String]

class Invariant[A]
//it's ok
val inv: Invariant[String] = new Invariant[String]
/* it's fall down cause class haven't types dependency
val errInv: Invariant[AnyRef] = new Invariant[String]
val errInv: Invariant[String] = new Invariant[AnyRef]
*/