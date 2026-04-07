package lectures.part2oop

object AnonymousClasses extends  App {

  abstract class Animal {
    def eat: Unit
  }

  // anonymou class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("Helloooooooo")
  }
  /*
    equivalent with

    class AnonymosClasses$$anon$1 extends Animal {
      override def eat: Unit = println("Helloooooooo")
    }
    val funnyAnimal: Animal = new AnonymousClasses$$ano$1
   */

  println(funnyAnimal.getClass)

  class Person(name: String) {

    def sayHi: Unit = println(s"Hi my bame is $name, how can I help? ")
  }

  val jim = new Person ("Jim") {
    override def sayHi: Unit = println(s"Hi my bame is Jim, how can I help be of service? ")

  }

  /*
    1. Generic trait MyPredicate[T]
    2. Generic trait MyTranformer[A, B]
    3 . MyList:
        - map(tranformer) => MyList
        - filter(predicate) => Mylist
        - flatMap(tranformer from A to MyList[B]) => MyList[B]
   */
  

}

