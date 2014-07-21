import scala.Boolean

/**
 * Created by Riccardo Cardin on 08/07/2014.
 */
// Exercise 1
def values(fun: (Int) => Int, low: Int, high: Int) = {
  for (i <- low to high) yield (i, fun(i))
}
values(x => x * x, -5, 5)
// Exercise 2
val a1 = Array(3, 5, 7, 2, 9, 7, 13, 5, -6)
a1.reduceLeft {
  (x, y) =>
    if (x < y) y else x
}
// Exercise 3
def fact(n: Int): Int =
  if (n == 0) 1
  else (1 to n).reduceLeft(_ * _)
fact(1)
// Exercise 4
def fact2(n: Int): Int = (1 to n).foldLeft(1)(_ * _)
fact2(0)
// Exercise 5
def largest(fun: (Int) => Int, inputs: Seq[Int]) =
  inputs.map(fun(_)).max
largest(x => 10 * x - x * x, 1 to 10)
// Exercise 6
def largestElement(fun: (Int) => Int, inputs: Seq[Int]) =
  inputs.maxBy(fun(_))
largestElement(x => 10 * x - x * x, 1 to 10)
// Exercise 7
def adjustToPair(fun: (Int, Int) => Int): ((Int, Int)) => Int = {
  (pair: (Int, Int)) => fun(pair._1, pair._2)
}
adjustToPair(_ * _)(6, 7)
val pairs = (1 to 10) zip (11 to 20)
pairs.map {
  case (x, y) => adjustToPair(_ + _)(x, y)
}.sum
// Why this?
pairs.map(adjustToPair(_ + _)).sum
// Exercise 8
val a = Array("Hello", "World")
val b = Array(5, 5)
a.corresponds(b)(_.length == _)
// Exercise 9
// TODO
// Exercise 10
def unless(condition: => Boolean)(block: => Unit) {
  if (!condition) block
}
unless (0 == 1) {
  println("Ok, good.")
}