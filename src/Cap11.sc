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
// Should be implemented in a better way to treat negative numbers
// in a more elegant way
class Money(d: BigInt, c: BigInt) {
  private val dollars: BigInt = d + c / 100
  private val cents: BigInt = c % 100
  private def toCent(): BigInt = dollars * 100 + cents
  private def fromCent(c: BigInt): Money = new Money(0, c)
  // Operators
  def +(other: Money) = fromCent(toCent() + other.toCent())
  def -(other: Money) = fromCent(toCent() - other.toCent())
  def ==(other: Money) = toCent() == other.toCent()
  def <(other: Money) = toCent() < other.toCent()
  override def toString =
    (if (cents < 0 && dollars >= 0) "-" else "") + dollars + "." + cents.abs + "$"
}
object Money {

  def apply(d: Int, c: Int) = {
    if (c < 0) throw new IllegalArgumentException("Cents cannot be less than zero")
    new Money(d, c)
  }
}
val m1 = Money(3, 125)
val m2 = Money(4, 25) + Money(3, 125)
val m3 = Money(3, 75) - Money(3, 25)
m3 == Money(0, 50)
Money(1, 35) < m3
// Exercise 5
class Table {
  // Inverse representation
  private var table: List[List[String]] = (Nil) :: Nil
  def |(s: String): Table = {
    table = (s :: table.head) :: table.tail
    this
  }
  def ||(s: String): Table = {
    table = (s :: Nil) :: table
    this
  }
  // This is the power of Scala language ;)
  override def toString: String =
    "<table>" + table.reverse.foldRight("")("<tr>" + _.reverse.foldLeft("")(_ + "<td>" + _ + "</td>") + "</tr>" + _) + "</table>"
}
object Table {
  def apply() = { new Table }
}

val t = new Table() | "Java" | "Scala" || "Gosling" | "Odersky" || "JVM" | "JVM, .NET"
// Exercise 6
class ASCIIArt(lines: List[String]) {
  // TODO
}
// Exercise 7
class BitSequence(bits: Long) {
  var bitsSeq: Array[Int] = {
    // Transform long in a string and ciclying over it
    val bitList = bits.toString.reverse.padTo(64, '0').toArray
    for (bit <- bitList) yield {
      bit match {
        case '0' => 0
        case '1' => 1
        case _ => throw new IllegalArgumentException(s"Long value $bits supplied is not a sequence of bits")
      }   // bit match
    }   // for (bit <- bitList) yield
  }   // var bitsSeq: Array[Int]

  def apply(index: Int): Int = bitsSeq(index)
  def update(index: Int, value: Int) = {
    if (value != 0 && value != 1)
      throw new IllegalArgumentException(s"Value $value is not a bit")
    bitsSeq(index) = value
  }

  override def toString = bitsSeq.mkString
}
val bits = new BitSequence(101101010L)
bits(1)
bits(1) = 0
bits(1)
// Exercise 8
// TODO
// Exercise 9 / 10
object RichFile {
// Ex 9
//  def unapply(path: String) =
//    if (path == null || path.length == 0 || path.lastIndexOf("/") == -1 || path.lastIndexOf(".") == -1)
//      None
//    else
//      Some((
//        path.substring(0, path.lastIndexOf("/")),
//        path.substring(path.lastIndexOf("/") + 1, path.lastIndexOf(".")),
//        path.substring(path.lastIndexOf(".") + 1)
//      ))
// Ex 10
  def unapplySeq(path: String): Option[Seq[String]] =
    if (path.lastIndexOf("/") == -1) None
    else Some(path.split("/"))
}
val RichFile(path, name, ext) = "root/user/bash.sh"
val RichFile(path1, path2, path3, path4) = "root/user/home/bash.sh"