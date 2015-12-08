import scala.util.matching.Regex

def IsLanguageExp(s:String):Boolean = {
  var Is: Boolean = false;
  val pattern = new Regex("[0-1]+")
  if(s match {
    case pattern => true;
    case _ => false
  }) {
    if (s.length() % 2 == 0) {
      if (s.reverse == s ) Is = true;
    }
  }
  return Is;
}

IsLanguageExp("0")
IsLanguageExp("01")
IsLanguageExp("010")
IsLanguageExp(" ")
IsLanguageExp("9khasgdjkh")
IsLanguageExp("0102309")
IsLanguageExp("0101")
IsLanguageExp("0110")
IsLanguageExp("101101101101")
