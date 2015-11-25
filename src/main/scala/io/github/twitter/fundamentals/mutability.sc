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

//usages of contravariant
//trait Function1[-T,+R] extends AnyRef

//And couple of examples:
// simple hierarchy
class Animal { val sound = "rustle" }
class Bird extends Animal {override val sound = "tweet"}
class Chicken extends Animal {override val sound = "cluck"}
/*
Huston we have a problem:
We have simple library of animals, which have a function, doing something but it take Animal param.
In the most of cases, if we said "I need <some>, I have subclass of class <className>" and it ok.
But params of function are contravariant.
And if we need a function which take Bird param and we have a function taking "Chicken param", it's
will be shocked "Duck param" as input. But with function which taking Animal as param all will be ok.
 */

val getTweet:(Bird => String) = ((a:Animal) => a.sound)
val getCluck:(Chicken => String) = ((a:Animal)=>a.sound)
getTweet(new Bird)
//val hatch:( ()=> Bird )= (() => new Chicken )

//restrictions
// restrictions reflect relations btw subtypes
// next doesn't correct cause things nothing knows about sound
//def cacaphony[T](things:Seq[T]) = things map (_.sound)

//let's fix
def biophony[T<:Animal](things:Seq[T]) = things map (_.sound)

biophony(Seq(new Bird,new Chicken))
