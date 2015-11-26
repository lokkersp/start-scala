class Calculator(brandS:String) {
  val brand: String = brandS
  val color: String = if (brand == "TI") {
    "blue"
  } else if (brand == "HP") {
    "black"
  } else {
    "white"
  }
  class Calculator(brandD : String) {

    }

  def add(m:Int,n:Int): Int = m + n
}

val calc = new Calculator("HP")
calc.add(12,1)
calc.brand
calc.color

val calc2 = new Calculator("TI")
calc2.brand
calc2.color

class SciCalc(brand:String) extends Calculator(brand) {
def log(m:Double,base:Double):Double = math.log(m)/math.log(base)
}

class EvenMoreSciCalc(brand:String) extends SciCalc(brand) {
  def log(m:Int):Double = log(m, math.exp(1))
}

val emsc = new EvenMoreSciCalc("HP")
emsc.log(100)