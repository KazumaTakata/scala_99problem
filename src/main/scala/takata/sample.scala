package takata

object sample {
  def main(args: Array[String]): Unit = {
    val list = List(3, 4, 5)
    println("Hello world")
    val e = myLast(list)
    println(e)
  }

  def myLast( list: List[Int] ): Int = list match {
    case s :: Nil => s
    case s :: rest => myLast(rest)
  }
}
