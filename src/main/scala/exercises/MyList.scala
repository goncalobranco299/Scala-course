package exercises

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
  // polymorphic call
  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: MyTransformer[A,B]): MyList[B]
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A]

  // concatenation
  def ++[B >: A](list: MyList[B]): MyList[B]

}

object Empty extends MyList [Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing] (element: B): MyList[B] = new Cons(element,Empty)
  def printElements: String = ""
  def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  def printElements: String = 
    /*
          [1,2,3].filter(n % 2 == 0) =
          [2,3].filter(n % 2 == 0) =
            = new Cons(2, [3].filter(n % 2 == 0))
            = new Cons(2, Empty.filter(n % " == 0))
            = new Cons(2,Empty)
         */
    if (t.isEmpty) "" + h.toString
    else h.toString + " " + t.printElements
    
  

  def filter(predicate: MyPredicate[A]): MyList[A] = 
    /*
         [1,2,3].map(n * 2)
           = new Cons(2, [2,3].map(n * 2))
           = new Cons(2, new Cons(4, [3].map(n * 2)))
           = new Cons(2, new Cons(4, new Cons(6, Empty.map(n * 2)))
           = new Cons(2, new Cons(4, new Cons(6, Empty)
     */
    if (predicate.test(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
    
  /*
       [1,2] ++ [3,4,5]
       = new Cons(1, [2] ++ [3,4,5])
       = new Cons(1, new Cons(2, Empty ++ [3,5,5])))
       = new Cons (1, new Cons(2, new Cons(3, new Cons(4, new Cons(5)))
      */

  def map[B](transformer: MyTransformer[A, B]): MyList[B] =
    new Cons(transformer.transform(h), t.map(transformer))

   
  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

   
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] = 
      transformer.transform(h) ++ t.flatMap(transformer)

}

  trait MyPredicate[-T] {
  def test(element: T): Boolean

  }

  trait MyTransformer[-A, B] {
    def transform(element: A): B
  }

    object LisTest extends App {
      val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
      val anotherlistOfIntegers: MyList[Int] = new Cons(4, new Cons(5, Empty))
      val lisOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))


      println(listOfIntegers.toString)
      println(lisOfStrings.toString)

      println(listOfIntegers.map(new MyTransformer[Int,Int] {
        override def transform(elem: Int): Int = elem * 2
      }).toString)

      println(listOfIntegers.filter(new MyPredicate[Int] {
        override def test(elem: Int): Boolean = elem % 2 == 0
      }).toString)
      
      println((listOfIntegers ++ anotherlistOfIntegers).toString)
      println(listOfIntegers.flatMap(new MyTransformer[Int, MyList[Int]] {
        override def transform(elem: Int): MyList[Int] = new Cons(elem,new Cons(elem + 1, Empty))
      }).toString)
    }