package takata

object hof {
  def main(args: Array[String]): Unit = {
    val list = List(3, 4,4, 5)
    val list2 = myMap((x:Any) => x*2 , list)
    println("Hello world")
  }



  def myMap( f: Any => Any, list: List[Any] ) : List[Any] = list match {
    case s::Nil =>  List(f(s))
    case s::rest => List(f(s))::: myMap(f ,rest)

  }
}
