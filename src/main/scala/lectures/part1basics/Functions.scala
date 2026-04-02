package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String =
    a + " " + b


  println(aFunction("hello world", 3))


  def aParamaterlessFunction(): Int = 42

  println(aParamaterlessFunction())
  println(aParamaterlessFunction())

  def InfoAboutKid(name: String, age: Int, lbs: Float): String =
    "Hello my name is " + name + " and im " + age + " years old " + " i have " + lbs

  println(InfoAboutKid("David", 18, 80.25))


  def factorial(n: Int): Int =
    if (n <= 0) 1
    else n * factorial(n - 1)

  println(factorial(5))

  def fibonacci(n: Int): Int =
    if (n <= 1) 1
    else fibonacci(n - 1) + fibonacci(n - 2)

  println(fibonacci(8)) // 1 + 1 + 2 + 3 + 5 + 8 + 13 + 21 + 34

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)

    isPrimeUntil(n / 2)
  }

  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37 * 17))
}
