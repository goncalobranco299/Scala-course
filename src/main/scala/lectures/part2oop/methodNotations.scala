package lectures.part2oop

object methodNotations extends App {
  /*
  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck?!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and i like $favoriteMovie"
  }
   val mary = new Person("Mary","Inception")
   println(mary.likes("Inception"))
   println(mary likes "Inception") // equivalent
   // infix notation = operator notation

   // "operators" in Scala

   val tom = new Person("Tom", "Figth Club")
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+ (2))

  // ALL OPERATORS ARE METHODS.

  val x = -1
  val y = 1.unary_-
  // unary_ prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)

  // postfix notation
  println(mary.isAlive)

  // apply
  println(mary.apply())
  println(mary()) // equivalent


  1.  overload the + operator
      mary + "the rockstar" => new person "Mary (the rockstar)

  2.  Add an age to the Person class
      Add am unary + operator => new person with the age + 1
      +mary => mary with the age increment

  3.  Add a "learns" method in the Person class => "Mary learns Scala"
      Add a learnsScala method, calls learns method with "Scala".
      Use it in postfix notation.

  4.  overload the apply method
      mary.apply(2) "Mary watched Inception 2 times"
  */

  // 1
  class Person(val name: String, movie: String) {
    def +(person: Person): String = s"${this.name}, gosta do mesmo filme que é o $movie, ${person.name}"
  }


}
