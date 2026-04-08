package exercises

object joking extends App {

  val number = 5
  var number2 = 10

  number2 = number2 + 5

  var result =
    if (number > 10) "maior"
    else "menor ou igual"

  println(s"O numero $number é $result")


  def greet(name: String, age: Int): String = {
    "Olá, o meu nome é " + name + "e tenho " + age + " anos "
  }

  println(greet("João,", 18))

  class Person(name:String, age: Int) {
    def greet: String = s"Hello my name is $name, and I have $age years old"

  }
  val mary = new Person("Mary",15)
  println(mary.greet)

  def factorial(n: Int): Int =
    if (n <= 0) 1
    else n * factorial(n - 1)

  println(factorial(5))


}


