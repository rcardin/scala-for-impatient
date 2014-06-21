/**
 * Created by Riccardo Cardin on 29/05/14.
 */
// Exercise 1
object Conversions {
  def inchesToCentimeters(inches: Double) = {
    inches * 2.54
  }
  def gallonsToLiters(gallons: Double) = {
    gallons * 3.7854
  }
  def milesToKilometers(miles: Double) = {
    miles * 1.609
  }
}
Conversions.inchesToCentimeters(2.5)
// Exercise 2
class UnitConversion(val factor: Double) {
  def convert(units: Double): Double = { units * factor }
}
object InchesToCentimeters extends UnitConversion(2.54)
object GallonsToLiters extends UnitConversion(3.7854)
object MilesToKilometers extends UnitConversion(1.609)
InchesToCentimeters.convert(2.5)
// Exercise 3
// Class Point has methods that allow to modify an object after its creation.
// So, it's not possibile to guarantee the immutability of Origin object
object Origin extends java.awt.Point
// Exercise 4
class Point(val x: Double , val y: Double) {
  override def toString = s"($x, $y)"
}
object Point {
  def apply(x: Double, y: Double) = new Point(x, y)
}
val p1 = Point(3, 4)
// Exercise 5
object Reverse extends App {
  println(args.reverse.mkString(" "))
}
// Exercise 6 and 7
object CardSuite extends  Enumeration {
  type CardSuite = Value
  val Picche = Value("♠")
  val Cuori = Value("♥")
  val Quadri = Value("♦")
  val Fiori = Value("♣")

  def isRed(suite: CardSuite) =
    suite == Cuori || suite == Quadri
}
println(CardSuite.values)
CardSuite.isRed(CardSuite.Picche)
CardSuite.isRed(CardSuite.Quadri)
// Exercise 8
object RGBCubeCorner extends Enumeration {
  type RGBCubeCorner = Value
  val Black = Value(0x000000)
  val Blue = Value(0x0000ff)
  val Magenta = Value(0xff00ff)
  val Red = Value(0xff0000)
  val Green = Value(0x00ff00)
  val Cyan = Value(0x00ffff)
  val White = Value(0xffffff)
  val Yellow = Value(0xffff00)
}

