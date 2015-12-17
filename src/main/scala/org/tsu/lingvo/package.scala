package main.scala.org.tsu

import scala.util.matching.Regex

/**
  * Created by noctuam on 08.12.15.
  */
package object lingvo extends App{

  def IsLanguageExp(s:String):Unit = {
    var Is: Boolean = false;
    val pattern = new Regex("[0-1]+")
    if(s match {
      case pattern => true;
      case _ => false
    }) {
 if (s.length % 2 == 0) {
   if (s.reverse == s ) Is = true;
  }
  }
    return Is;
}

}
