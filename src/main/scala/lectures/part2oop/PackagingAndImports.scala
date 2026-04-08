package lectures.part2oop

import lectures.part2oop.OOBasics.Writer
import playground.{PrinceCharming, Cindrella => Princess}

import java.util.Date
import java.sql.{Date => SqlDate}

object PackagingAndImports extends App {

  // package members are accessible by their simple name
  val writter = new Writer("David", "RockTheJVM", 2018)

  // import the package
  val princess = new Princess // playground.Cindrella = ful qualified name

  // packages are in hierarchy
  // matching folder structure

  // package object
  sayHello
  println(SPEED_OF_LIGH)

  // imports
  val prince = new PrinceCharming

  // 1. use FQ names
  val date = new Date
  val sqlDate = new SqlDate(2018,4, 5)
  // 2. use aliasing

  // default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???
}
