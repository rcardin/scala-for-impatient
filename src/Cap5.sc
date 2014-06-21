import scala.beans.BeanProperty

/**
 * Created by Riccardo Cardin on 26/05/14.
 */
// Exercise 1
class Counter {
  private var value = 0
  def increment() {
    value =
      if (value < Int.MaxValue) value + 1
      else 0
  }
  def current() = value
}
val c = new Counter
c.increment()
c.increment()
c.current()
//Exercise 2
class BankAccount(private var amount: Int) {
  def deposit(quantity: Int) {
    if (quantity < 0) 
      throw new IllegalArgumentException("Quantity less than zero")
    amount = amount + quantity
  }
  def withdraw(quantity: Int) {
    if (quantity < 0)
      throw new IllegalArgumentException("Quantity less than zero")
    if (quantity > amount)
      throw new IllegalArgumentException("Quantity greater than balance")
    amount = amount - quantity
  }
  def balance = amount
  override def toString = "Balance is " + balance
}
val account = new BankAccount(100)
account.toString
account deposit(23)
account.toString
account withdraw(70)
account.toString
// Exercise 3
class Time(val hours: Int, val minutes: Int) {
  def before(other: Time) = {
    if (this.hours < other.hours) true
    else if (this.hours == other.hours && this.minutes < other.minutes) true
    else false
  }
  override def toString = s"$hours:$minutes"
}
val t1 = new Time(5, 45)
val t2 = new Time(6, 36)
t1.before(t2)
// Exercise 4
class Time2(h: Int, m: Int) {
  private val _minutes = m + h * 60 -1
  val hours = _minutes / 60
  val minutes = _minutes % 60
  def before(other: Time2) = {
    this._minutes < other._minutes
  }
  override def toString = s"$hours:$minutes"
}
val t3 = new Time2(5, 45)
val t4 = new Time2(6, 36)
t3.before(t4)
// Exercise 5
class Student(@BeanProperty var id: Long, @BeanProperty var name: String) { }
val s1 = new Student(0, "Riccardo Cardin")
s1.getName
s1.setName("Daniela Regazzo")
s1.getName
// Exercise 6
class Person(var age: Int) {
  if (age < 0)
    age = 0
  override def toString = s"Person is $age years old"
}
val p1 = new Person(10)
val p2 = new Person(-3)
// Exercise 7
class Person2(val init: String) {
  // Non efficient
  val firstName = init.split(" ")(0)
  val lastName = init.split(" ")(1)
  override def toString = s"Welcome to $firstName $lastName"
}
val p3 = new Person2("Riccardo Cardin")
// Exercise 8
class Car(val manufacturer: String, val model: String, val year: Int = -1, var licensePlate: String = "") {
}
val c1 = new Car("Alfa Romeo", "Giulietta")
// Exercise 10
// TODO