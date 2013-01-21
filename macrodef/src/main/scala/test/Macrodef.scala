package test

import language.experimental.macros
import scala.reflect.macros._


object MacroDef{
  

  def printValsMacro[T](obj:T) : Unit = macro printVals[T]

  def printVals[T](c:Context)( obj : c.Expr[T]) : c.Expr[Unit] = {
    import c.universe._
    println("Start compile")
    val t = obj.actualType
    val vals = t.members.collect({
      case t : TermSymbol if t.isVal => t
    })
    val trees = vals.map(v => {
        Apply(Select(reify(Predef).tree, newTermName("printf")), 
          List(
            Literal(Constant(v.getter.name.encoded + " = %s\n")),
            Select(obj.tree, v.getter.name)
          )
        )
    }).toList
    
    c.Expr[Unit](Block(trees :_*))
    
  }
  
}
