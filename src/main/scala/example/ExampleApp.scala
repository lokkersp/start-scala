package main.scala.example

/**
  * Created by noctuam on 15.11.15.
  */
object ExampleApp extends App {
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

  def parseString(s:String):Map[String,String] = {
    var lex:Map[String,String] = Map()
    val labelPattern = "[A-Z]+:".r
    val cmdPattern =  "([A-Z]+|:\\s[A-Z]+)".r
    val singleParamPattern = "(\\w+\\z|\\s\\w+\\z)".r
    val twoParamsPattern = "(\\w+,\\w+\\z|\\w+,\\w+\\z)".r
    val firstParamPattern = "(\\s\\w+,|\\w+,)".r
    val secondParamPattern = "\\w+\\z".r

    if (isASMSCandidate(s)) {
      if(withoutLabelWithoutParams(s)) {
        lex += ("cmd"-> s.trim())
        return lex;
      }
      if(withoutLabelWithParams(s)) {
        val pCMD = (cmdPattern.findFirstIn(s)).get
        lex += ("cmd"->pCMD)
        val ts = s.replaceAll(pCMD,"")
        var pPARAM:String = ""
        var pPARAM1:String = ""
        var pPARAM2:String = ""
        if (twoParamsPattern.findFirstIn(ts).get == None) {
          pPARAM = singleParamPattern.findFirstIn(ts).get
          lex += ("param"->pPARAM)
        } else {
          pPARAM1 = firstParamPattern.findFirstIn(ts).get
          lex += ("param1"->pPARAM1)
          val ts1 = ts.replaceFirst(pPARAM1,"")
          pPARAM2 = secondParamPattern.findFirstIn(ts1).get
          lex += ("param2"->pPARAM2.replaceFirst(",",""))
        }

      }
      if(withLabelWithoutParams(s)) {
        val pLBL = (labelPattern.findFirstIn(s).get)
        lex += ("lbl"->pLBL.replaceAll(":","").trim())
        val ts = s.replaceFirst(pLBL,"")
        val pCMD = cmdPattern.findFirstIn(ts).get
        lex += ("cmd"->pCMD.trim())
      }
      if(withLabelWithParams(s)) {
        val pLBL = (labelPattern.findFirstIn(s).get)
        lex += ("lbl"->pLBL.replaceAll(":","").trim())
        val ts = s.replaceFirst(pLBL,"")
        val pCMD = cmdPattern.findFirstIn(ts).get
        lex += ("cmd"->pCMD.trim())
        val ts1 = ts.replaceFirst(pCMD,"").trim()
        var pPARAM:String = ""
        var pPARAM1:String = ""
        var pPARAM2:String = ""
        if (!twoParamsPattern.findFirstIn(ts1).isDefined) {
          pPARAM = singleParamPattern.findFirstIn(ts1).get
          lex += ("param"->pPARAM)
        } else {
          pPARAM1 = firstParamPattern.findFirstIn(ts1).get
          lex += ("param1"->pPARAM1)
          val ts2 = ts.replaceFirst(pPARAM1,"")
          pPARAM2 = secondParamPattern.findFirstIn(ts2).get
          lex += ("param2"->pPARAM2.replaceFirst(",",""))
        }
      }
    }
    return lex;
  }

  parseString("POP 1")
}
