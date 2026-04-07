package lectures.part2oop

object Objects extends App {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCIONALITY ("static")
  object Person { // type + its only istance
    // "static"/"class" - level funcionality
    val N_EYES = 2
    def canFly: Boolean = false

    def apply(mother: Person, father: Person): Person = new Person("Boobie")
  }

  class Person(val name: String) {
    // instance-level funcionality
  }

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = SINGLETON INSTANCE
  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john)

  val person1 = Person
  val person2 = Person
  println( person1 == person2)

  val boobie = Person(mary, john)

  // Scala Applications = Scala object with
  // def main(args: Array[String]): Unit


}
