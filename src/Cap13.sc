/**
 * Created by Riccardo Cardin on 20/07/2014.
 */
// Exercise 1
def indexes(sz: String): collection.mutable.Map[Char, collection.mutable.Set[Int]] = {
  val m = collection.mutable.Map[Char, collection.mutable.Set[Int]]()
  for ((c, i) <- sz.zipWithIndex) {
    val c = sz(i)
    m get(c) match {
      case Some(s) => m.update(c , s + i)
      case None => m.put(c, collection.mutable.SortedSet(i))
    }   // m get(sz(i)) match
  }   // for (i <- 0 until sz.length)
  m
}
indexes("Mississippi")
// Exercise 2
def indexesImmutable(sz: String): Map[Char, List[Int]] = {
//  def indexStep(m: Map[Char, List[Int]], l: List[(Char, Int)]): Map[Char, List[Int]] =
//    l match {
//      case Nil => m
//      case (c, i) :: xs => {
//        indexStep(m + (c -> (i :: m.getOrElse(c, List[Int]()))), xs)
//      }
//    }
//  indexStep(Map[Char, List[Int]](), sz.zipWithIndex.toList)
  sz.zipWithIndex.groupBy(_._1).map {
    item => (item._1, item._2.map(_._2).toList)
  }
}
indexesImmutable("Mississippi")
// Exercise 3
def removeZeroes(list: List[Int]): List[Int] = {
  for (item <- list if item != 0) yield item
}
val l = List(3, 5, 3, 0, 5, 1, 0, 9, 4, 0)
removeZeroes(l)
// Exercise 4
def extract(arr: Seq[String], m: Map[String, Int]): Seq[Int] = {
  arr.map(m.get(_)).flatMap(x => x)
}
extract(Array("Tom", "Fred", "Harry"), Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5))
// Exercise 5
def mkString(a: Array[Int], sep: String): String = {
  a.map(_.toString).reduceLeft((x1, x2) => x1 + sep + x2)
}
val a1 = Array(0, 1, 2, 3, 4)
mkString(a1, ", ")
// Exercise 6
val lst = List(1, 2, 3, 4, 5)
(lst :\ List[Int]())((xs, x) => x :+ xs)
(List[Int]() /: lst)((xs, x) => x :: xs)
// Exercise 7
val prices = List(5.0, 20.0, 9.95)
val quantities = List(10, 2, 1)
(prices zip quantities) map Function.tupled(_ * _)
// Exercise 8
val a2: Array[Double] = Array[Double](1, 2, 3, 4, 5, 6)
def toMatrix(arr: Array[Double], length: Int): Array[Array[Double]] = {
  arr.grouped(length).toArray
}
toMatrix(a2, 3).deep.mkString(", ")
// Exercise 10
