
import test.MacroDef._
import test._

object App{
  
  def main(args : Array[String]){    
    
    val start = System.currentTimeMillis
    printValsMacro(User("Bob",23))
  }
}


case class User(nickname : String,age : Int)