import scala.collection.mutable.ArrayBuffer

/**
 * Created by Riccardo Cardin on 31/05/14.
 */
// Exercise 1
class BankAccount(initialBalance: Double) {
  private var balance = initialBalance
  def currentBalance = balance
  def deposit(amount: Double) = {
    balance += amount
    balance
  }
  def withdraw(amount: Double) = {
    balance -= amount
    balance
  }
  override def toString = s"Balance: $balance"
}
class CheckingAccount(initialBalance: Double)
  extends BankAccount(initialBalance) {
  override def deposit(amount: Double) = {
    super.deposit(amount - 1.0)
  }
  override def withdraw(amount: Double) = {
    super.withdraw(amount + 1.0)
  }
}
val account = new CheckingAccount(50.0)
account.deposit(25.0)
account.withdraw(40.0)
// Exercise 2
class SavingsAccount(initialBalance: Double)
  extends BankAccount(initialBalance) {
  // Interest rate
  private val monthlyInterest: Double = 0.03
  private val freeOpsPerMonth: Int = 3
  private var freeOpsAvailable = freeOpsPerMonth
  def earnMonthlyInterest() = {
    freeOpsAvailable = freeOpsPerMonth
    super.deposit(currentBalance * monthlyInterest)
  }
  override def deposit(amount: Double) = {
    freeOpsAvailable -= 1
    super.deposit(if (freeOpsAvailable >= 0) amount else  amount - 1.0)
  }
  override def withdraw(amount: Double) = {
      freeOpsAvailable -= 1
      super.withdraw(if (freeOpsAvailable >= 0) amount else  amount + 1.0)
  }
}
val savingsAcc = new SavingsAccount(100.0)
savingsAcc.earnMonthlyInterest()
savingsAcc.deposit(10.0)
savingsAcc.deposit(40.0)
savingsAcc.withdraw(25.0)
savingsAcc.withdraw(10.0)
savingsAcc.earnMonthlyInterest()
savingsAcc.deposit(15.0)
// Exercise 4
abstract class Item {
  def price: Double
  def description: String
}
class SimpleItem(val price: Double, val description: String)
  extends Item {
  override def toString = s"$description: $price"
}
class Bundle extends Item {
  val items: ArrayBuffer[Item] = ArrayBuffer()
  def add(item: Item) {
    items += item
  }
  def price: Double = items.foldLeft(0.0)(_ + _.price)
  def description: String = items mkString(", ")
}
val s1 = new SimpleItem(10.0, "iPhone")
val s2 = new SimpleItem(3.0, "Nexus 4")
val b1 = new Bundle
b1.add(s1)
b1.add(s2)
b1.price
b1.description
// Exercise 5
class Point(val x: Double, val y: Double) {
  override def toString = s"($x, $y)"
}
class LabeledPoint(val description: String, val xCoord: Double, val yCoord: Double)
  extends Point(xCoord, yCoord)
val l = new LabeledPoint("Black Thursday", 1929, 230.07)
// Exercise 6
abstract class Shape {
  def centerPoint: Point
}
class Rectangle(val topLeft: Point, val height: Double, val length: Double)
  extends Shape {
  val centerPoint: Point = new Point(topLeft.x + length / 2, topLeft.y - height / 2)
}
class Circle(val centerPoint: Point, val ray: Double) extends Shape
val rect = new Rectangle(new Point(0, 0), 3, 7)
rect.centerPoint
// Exercise 7
class Square(x: Int, y: Int, width: Int)
  extends java.awt.Rectangle(x, y, width, width) {
  def this(width: Int) {
    this(0, 0, width)
  }
  def this() {
    this(0, 0, 0)
  }
}
// Exercise 9
class Creature {
  def range: Int = 10
  val env: Array[Int] = new Array[Int](range)
}
class Ant extends Creature {
  override def range = 2
}
val a = new Ant
a.env.length