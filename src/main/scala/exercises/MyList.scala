package exercises

import lectures.part2oop.Generics.MyList

import javax.xml.transform.Transformer

abstract class MyList [+A]{

  /*
    head = first element of the list
    tail = reminder of the list
    isEmpty = is this list empty
    add(int) => new list woth this elemetn added
    toString => a string representation of the list
 */

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A] (element: B): MyList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"
  def map[B](transformer: MyTranformer[A,B]): MyList[B]
  def flatMap[B](tranformer: MyTranformer[A, MyList[B]]): MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A]

}

object Empty extends MyList [Nothing]{
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing] (element: B): MyList[B] = new Cons(element,Empty)
  def printElements: String = ""
  def map[B](transformer: MyTranformer[Nothing, B]): MyList[B] = Empty
  def flatMap[B](tranformer: MyTranformer[Nothing, MyList[B]]): MyList[B] = Empty
   def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A] (element: B): MyList[B] = new Cons(element,this)
  def printElements: String = 
    if(t.isEmpty) "" + h.toString
    else h.toString + " " + t.printElements
    
    def filter(predicate: MyPredicate[A]): MyList[A] = 
      if(predicate.test(h)) new Cons(h, t.filter(predicate))
      else t.filter(predicate)
      
    //def map[B](transformer: MyTranformer[A,B]): MyList[B] =
  // new Cons(transformer.transform(h), t.map(transformer))
}

trait MyPredicate[-T] {
  def test(element: T): Boolean
}
trait MyTranformer[-A, B] {
  def transform(element: A): B

}

object LisTest extends App {
  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val lisOfStrings : MyList[String] = new Cons("Hello", new Cons("Scala", Empty))

  
  
  println(listOfIntegers.toString)
  println(lisOfStrings.toString)
  


}
