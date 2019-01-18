package takata

object sample {
  def main(args: Array[String]): Unit = {
    val list = List(3, 4,4, 5)
    println("Hello world")
    val e = myPack(list)
    println(e)
  }

  def myLast( list: List[Int] ): Int = list match {
    case s :: Nil => s
    case s :: rest => myLast(rest)
  }

  def myButLast( list : List[Int] ): Int = list match {
    case s:: s1:: Nil => s
    case s :: rest => myButLast(rest)
  }

  def nth ( list : List[Int], index: Int ): Int = list match {
    case s :: rest => index match {
      case 0 => s
      case i => nth(rest, index-1)
    }
  }

  def myLen( list : List[Int]): Int = list match {
    case Nil  => 0
    case s :: rest => 1 + myLen(list)
  }

  def myReverse( list : List[Int]): List[Int] = list match {
    case s ::Nil  => List(s)
    case s :: rest => myReverse(rest) ::: List(s)
  }

  def myFlatten( list : List[Any]): List[Int] = list match {
    case s ::Nil => s match {
      case s:List[Int] => s
      case s:Int=> List(s)
    }
    case s :: rest => s match {
      case s:List[Int] => s ::: myFlatten(rest)
      case s:Int=> List(s) ::: myFlatten(rest)
    }
  }

  def myCompress( list : List[Int]): List[Int] = list match {
    case s :: Nil => List(s)
    case s :: rest => rest match {
      case s2:: rest2 if s != s2  => List(s) ::: myCompress(rest)
      case s2:: rest2 => myFlatten(rest)
    }
  }

  def myPack( list : List[Int]): List[List[Int]] = list match {
    case s :: Nil =>List(List(s))
    case s :: rest => myMerge(List(List(s)), myPack(rest))
  }

  def myMerge( list1: List[ List[Int]], list2: List[ List[Int]] ): List[List[Int]] = (list1, list2 ) match {
    case (s1 :: rest1, s2:: rest2) => (s1, s2) match {
      case (s3:: rest3, s4:: rest4) if s3 == s4 => List( s1 ::: s2 ) ::: rest2
      case (s3:: rest3, s4:: rest4) if s3 != s4 => List( s1 ) ::: list2
    }
  }

}
