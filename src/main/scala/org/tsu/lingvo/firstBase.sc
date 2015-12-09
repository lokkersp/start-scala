import scala.util.matching.Regex
def IsLanguageExp(s:String):Boolean = {
  var Is: Boolean = false;
  val pattern = new Regex("[0-1]+")
  if(s match {
              case pattern => true;
              case _       => false
  }) {
    if (s.length() % 2 == 0) {
      if (s.reverse == s ) Is = true;
    }
  }
  return Is;
}


IsLanguageExp("0") //false
IsLanguageExp("01") //false
IsLanguageExp("010") //false
IsLanguageExp(" ") //false
IsLanguageExp("9khasgdjkh") //false
IsLanguageExp("0102309") //false
IsLanguageExp("0101") //false
IsLanguageExp("0110") //true
IsLanguageExp("101101101101") //true
