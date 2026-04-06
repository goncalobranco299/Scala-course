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


  def factorial(n: Int): Int =
    if (n <= 0) 1
    else n * factorial(n - 1)

  println(factorial(5))


}


