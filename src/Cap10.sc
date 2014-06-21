import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Bean
import java.awt.geom.Ellipse2D
import java.beans.{PropertyChangeSupport, PropertyChangeListener, PropertyChangeEvent}
import java.io.{FileInputStream, InputStream}
import java.text.SimpleDateFormat
import java.util.Calendar

/**
 * Created by Riccardo Cardin on 06/06/2014.
 */
// Exercise 1
trait RectangleLike {

  def setFrame(x: Double, y: Double, w: Double, h: Double)
  def getX(): Double
  def getY(): Double
  def getHeight(): Double
  def getWidth(): Double

  def translate(dx: Int, dy: Int) {
    setFrame(dx + getX(), dy + getY(), getWidth(), getHeight())
  }
  def grow(h: Int, v: Int) {
    setFrame(getX() - h, getY() - v, getWidth() + 2 * h, getHeight() + 2 * v)
  }
}
val egg = new Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
egg.translate(10, -10)
egg.grow(10, 20)
// Exercise 2
class OrderedPoint(x: Int, y: Int) extends java.awt.Point(x, y) with math.Ordered[java.awt.Point] {
  def compare(that: java.awt.Point): Int = {
    if (this.getX == that.getX && this.getY == that.getY) 0
    if (this.getX <= that.getX && this.getY < that.getY) -1
    1
  }
}
val p1 = new OrderedPoint(3, 6)
val p2 = new OrderedPoint(2, 7)
p1 <= p2
// Exercise 4
trait CryptoLogger {
  private val alphaU='A' to 'Z'
  private val alphaL='a' to 'z'

  protected val key = 3
  def log(text:String ) = text.map {
    case c if alphaU.contains(c) => rot(alphaU, c, key)
    case c if alphaL.contains(c) => rot(alphaL, c, key)
    case c => c
  }
  // def decode(text:String, key:Int)=encode(text,-key)
  private def rot(a:IndexedSeq[Char], c:Char, key:Int)=a((c-a.head+key+a.size)%a.size)
}
class A extends CryptoLogger {
 def a(value: String) {
   log(value)
 }
}
val a1 = new A
val loggedMsg: Unit = a1.a("Riccardo")
// Exercise 5
trait PropertyChangeSupportLike {
  private val support = new java.beans.PropertyChangeSupport(this)

  def addPropertyChangeListener(listener: PropertyChangeListener) {
    support.addPropertyChangeListener(listener)
  }

  def addPropertyChangeListener(propertyName: String, listener: PropertyChangeListener) {
    support.addPropertyChangeListener(propertyName, listener)
  }

  def	fireIndexedPropertyChange(propertyName: String, index: Int, oldValue: Boolean, newValue: Boolean) {
    support.fireIndexedPropertyChange(propertyName, index, oldValue, newValue)
  }

  def fireIndexedPropertyChange(propertyName: String, index: Int, oldValue: Int, newValue: Int) {
    support.fireIndexedPropertyChange(propertyName, index, oldValue, newValue)
  }

  def fireIndexedPropertyChange(propertyName: String, index: Int, oldValue: Object, newValue: Object) {
    support.fireIndexedPropertyChange(propertyName, index, oldValue, newValue)
  }

  def firePropertyChange(evt: PropertyChangeEvent) {
    support.firePropertyChange(evt)
  }

  def	firePropertyChange(propertyName: String, oldValue: Boolean, newValue: Boolean) {
    support.firePropertyChange(propertyName, oldValue, newValue)
  }

  def	firePropertyChange(propertyName: String, oldValue: Int, newValue: Int) {
    support.firePropertyChange(propertyName, oldValue, newValue)
  }

  def	firePropertyChange(propertyName: String, oldValue: Object, newValue: Object) {
    support.firePropertyChange(propertyName, oldValue, newValue)
  }

  def getPropertyChangeListeners(): Array[PropertyChangeListener] = support.getPropertyChangeListeners()
  def getPropertyChangeListeners(propertyName: String): Array[PropertyChangeListener] = support.getPropertyChangeListeners(propertyName)

  def hasListeners(propertyName: String): Boolean = support.hasListeners(propertyName)

  def removePropertyChangeListener(listener: PropertyChangeListener) = support.removePropertyChangeListener(listener)
  def	removePropertyChangeListener(propertyName: String, listener: PropertyChangeListener) = support.removePropertyChangeListener(listener)
}
class BeanPoint(x: Int, y: Int) extends java.awt.Point(x, y) with PropertyChangeSupportLike
val p3 = new BeanPoint(3, 8)
// Exercise 7
class Person(val name: String) {

  override def toString() = { s"My name is $name"}
}
val ricky = new Person("Riccardo")
trait Superpower {
  def doSomethingSuper(): String
}
trait WallwalkPower extends Superpower {
  override abstract def doSomethingSuper() = {
    "Wallwalk " + super.doSomethingSuper()
  }
}
trait FlyingPower extends Superpower {
  override abstract def doSomethingSuper() = {
    "Fly " + super.doSomethingSuper()
  }
}
class Superhero(name: String) extends Person(name) with Superpower {
  override def doSomethingSuper() = ""
  override def toString() = super.toString() + " and my superpowers are: " + doSomethingSuper()
}
val spiderman = new Superhero("Spiderman") with WallwalkPower
// Exercise 8
trait BufferedStream {
  this: InputStream =>

  private val BUFFER_SIZE = 10

  override def read(): Int = {
    // TODO
    this.read()
  }
}
// Exercise 10
trait IterableInputStream extends InputStream with Iterable[Byte] {

  class InputStreamIterator(outer: IterableInputStream) extends Iterator[Byte] {
    def hasNext: Boolean = outer.available() > 0
    def next: Byte = outer.read().toByte
  }

  def iterator: Iterator[Byte] = new InputStreamIterator(this)
}

val f = new FileInputStream("I:\\Lavoro\\Libri\\Scala for the impatient\\exercises\\testo.txt") with IterableInputStream
for(b <- f) println(b.toChar)