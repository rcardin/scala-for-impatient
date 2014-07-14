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
