/**
 * Created by Riccardo Cardin on 14/02/14.
 */
// Exercise 1
def signum(number : Int) =
  if (number < 0) -1
  else if (number > 0) 1
  else 0
signum(-1)

// Exercise 3
var y = 2
val x = y = 1

// Exercise 4
for (i <- 10 to 0 by -1)
   print(i + " ")

// Exercise 5
def countdown(n: Int) =
  for (i <- n to 0 by -1)
    print(i + " ")
countdown(13)
// Exercise 6
val str = "Hello"
var l: Long = 1L
for (c <- str) {
  l = l * c.toLong
}
print(l)
// Exercise 7
val str1 = "Hello"
val l1 = str1.foldLeft(1L)(_ * _)
// Exercise 9
def product(s: String): Long =
  if (s.length == 0) 1
  else
    s.head.toLong * product(s.tail)
product("Hello")
// Exercise 10
def pow(x: Double, n: Int): Double =
    if (n == 0) 1
    else if (n < 0) 1 / pow(x, -n)
    else if (n % 2 == 0) pow(x, n / 2) * pow(x, n / 2)
    else x * pow(x, n - 1)
pow(3, 3)
"Ciao"