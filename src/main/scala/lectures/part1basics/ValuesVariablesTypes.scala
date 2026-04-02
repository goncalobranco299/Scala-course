package lectures.part1basics

object ValuesVariablesTypes extends App {
  val x: Int = 42
  println(x)
  // VALS ARE IMMUTABLE

  // COMPILER can infer types

  val aString: String = "hello"
  val anotherString: String = "goodbye"
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 2324
  val aLong: Long = 124353151634252L
  val aFloat: Float = 2.0F
  val aDouble: Double = 4.521151511D

  println(aString)

  // variables
  var aVariables: Int = 4
}
