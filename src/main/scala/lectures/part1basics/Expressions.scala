package lectures.part1basics

import java.lang.IO.println

object Expressions extends App {

  val x: Int = 1 + 2 // EXPRESSIONS
  println(x)


  var aVariable = 2
  aVariable += 3
  println(aVariable)

  println(!(1 == x))


  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3
  println(aConditionedValue)
  println(if(aCondition) 5 else 3)

  var i = 0
    while (i < 10) {
      println(i)
      i += 1
    }

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z >  2) "hello" else "goodbye"


  }


}
