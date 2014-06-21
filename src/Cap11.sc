/**
 * Created by Riccardo Cardin on 18/06/2014.
 */
// Exercise 1
3 + 4 -> 5
//3 -> 4 + 5
// Exercise 2
// Because of the predecence of char ^, which is very low
// Exercise 3
class Fraction(n: Int, d: Int) {
  private val num: Int = if (d == 0) 1 else n * sign(d) / gcd(n, d)
  private val den: Int = if (d == 0) 0 else d * sign(d) / gcd(n, d)

  def sign(a: Int) = if (a > 0) 1 else if (a < 0) -1 else 0
  def abs(a: Int) = if (sign(a) < 0) -a else a
  def gcd(a: Int, b: Int): Int = if (b == 0) abs(a) else gcd(b, a % b)

  // Operators
  def +(other: Fraction) = new Fraction(num * other.den + other.num * den, den * other.den)
  def -(other: Fraction) = new Fraction(num * other.den - other.num * den, den * other.den)
  def *(other: Fraction) = new Fraction(num * other.num, den * other.den)
  def /(other: Fraction) = new Fraction(num * other.den, den * other.num)

  override def toString = s"$num/$den"
}
val f1 = new Fraction(3, 15)
val f2 = new Fraction(4, 8)
val f3 = f1 - f2
// Exercise 4
class Money(d: Int, c: Int) {
  private val dollars = d + c / 100
  private val cents = c % 100

  // Operators
  def +(other: Money) = new Money(dollars + other.dollars, cents + other.cents)
  def -(other: Money) = new Money(dollars - other.dollars, cents - other.cents)

  def abs(a: Int) = if (sign(a) < 0) -a else a

  override def toString = "" + dollars + "." + cents + "$"
}
object Money {
  def apply(d: Int, c: Int) = new Money(d, c)
}
val m1 = Money(3, 125)