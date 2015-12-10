import scala.util.matching.Regex
def IsRG(s:String):Boolean = {
  if(s.length == 2 ) if (IsGPR(s) || IsIDXR(s) || IsPTRR(s) || IsSMGR(s)) return true
  return false
}
def IsGPR(s:String):Boolean = {
  s match {
    case "AX" => return true
    case "BX" => return true
    case "CX" => return true
    case "DX" => return true
    case _ => return false;
  }
}
def IsIDXR(s:String):Boolean = {
  s match {
    case "SI" => return true
    case "DI" => return true
    case _ => return false
  }
}
def IsPTRR(s:String):Boolean = {
  s match {
    case "BP" => return true
    case "SP" => return true
    case _ => return false
  }
}
  def IsSMGR(s:String):Boolean = {
    s match {
      case "CS" => return true
      case "DS" => return true
      case "ES" => return true
      case "SS" => return true
      case _ => return false
    }
  }
def IsCMD(c:String):Boolean = c match {
case "AAA" => return true
case "AAD" => return true
case "AAM" => return true
case "AAS" => return true
case "ADC" => return true
case "ADD" => return true
case "AND" => return true
case "BSWAP" => return true
case "BT" => return true
case "CALL" => return true
case "JMP" => return true
case "PUSH" => return true
case "MOV" => return true
case "CLC" => return true
case "POP" => return true
case _ => return false
}
def isASMSCandidate(s:String):Boolean = {
  val pat = "(|[A-Z]+:\\s)[A-Z]+(|\\s\\w+|\\s\\w+,\\w+)\\z".r
  val rs = pat findFirstIn s.trim()
  if(rs != None) {
    if (rs.get == s.trim())
      rs match {
        case Some(v) => return true;
        case _ => return false;
      }
  }
  return false;
}

def withoutLabelWithoutParams(s:String):Boolean = {
  val pat = "[A-Z]+\\z".r
  val rs = pat findFirstIn s.trim()
  if(rs != None) {
    if (rs.get == s.trim())
      rs match {
        case Some(v) => return true;
        case _ => return false;
      }
  }
  return false;
}

def withLabelWithoutParams(s:String):Boolean = {
  val pat = "[A-Z]+:\\s[A-Z]+\\z".r
      val rs = pat findFirstIn s.trim()
  if(rs != None) {
    if (rs.get == s.trim())
      rs match {
        case Some(v) => return true;
        case _ => return false;
      }
  }
  return false;
}

def withLabelWithParams(s:String):Boolean = {
  val pat = "[A-Z]+:\\s[A-Z]+\\s(\\w+|\\w+,\\w+)\\z".r
  val rs = pat findFirstIn s.trim()
  if(rs != None) {
    if (rs.get == s.trim())
      rs match {
        case Some(v) => return true;
        case _ => return false;
      }
  }
  return false;
}
def withoutLabelWithParams(s:String):Boolean = {
  val pat = "[A-Z]+\\s(\\w+|\\w+,\\w+)\\z".r
  val rs = pat findFirstIn s.trim()
  if(rs != None) {
    if (rs.get == s.trim())
      rs match {
        case Some(v) => return true;
        case _ => return false;
      }
  }
  return false;
}

def parseString(s:String):Any = {
  val labelPattern = "[A-Z]+:".r
  val singleParamPattern = "\\s\\w+".r
  val twoParamPattern = "\\s\\w+,\\w+\\z".r
  if (isASMSCandidate(s)) {
    if(withoutLabelWithoutParams(s)) {
      var lex:Map[String,String] = Map("cmd"-> s.trim())
      return lex;
    }
    if(withoutLabelWithParams(s))
    if(withLabelWithoutParams(s))
    if(withLabelWithParams(s)) {
      val pat = "[A-Z]+:".r
      var h = pat findFirstIn s
      //lbl = lbl.get

    }
  }
}
