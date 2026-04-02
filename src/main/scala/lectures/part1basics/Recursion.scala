package lectures.part1basics

import scala.jdk.Accumulator

object Recursion extends App {

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + "- I first need factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)
      result
    }

  println(factorial(10))

  def anotherFactorial(n: Int): Int = {
    def factHelper(x: Int, accumulator: Int): Int =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION = use recursive call as the LAST expression

    factHelper(n, 1)
  }

  def cocatenateTailrec (aString: String,n: Int, accumulator: String): String = {
    if ( n <= 0) accumulator
    else cocatenateTailrec(aString, n-1, aString + accumulator)
  }
  println(cocatenateTailrec("ola",4, ""))

  def isPrime (n: Int): Boolean = {
    def isPrimeTailrec(t: Int, isStillprime: Boolean): Boolean =
    if (!isStillprime) false
    else if (t <=1) true
    else isPrimeTailrec(t-1, n % t != 0 && isStillprime)

  isPrimeTailrec(n / 2, true)

  }

  def fibonacci (n: Int): Int = {
    def fiboTailrec(i: Int, last: Int,  nextToLast: Int): Int =
      if(i >= n) last
      else fiboTailrec(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fiboTailrec(2,1,1)
    }
    println(fibonacci(8))
  }