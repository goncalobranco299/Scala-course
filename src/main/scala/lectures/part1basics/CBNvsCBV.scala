package lectures.part1basics

object CBNvsCBV extends  App{

  def calledByValue(x: Long): Unit = {
    println("by value" + x)
    println("by value" + x)
  }

  def calledByName(x: => Long): Unit = {
    println("by value" + x)
    println("by value" + x)


  }

  calledByName(System.nanoTime)
  calledByValue(System.nanoTime())

  def infinite(): Int = 1 + infinite()

}
