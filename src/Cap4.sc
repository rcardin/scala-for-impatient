import java.io.File
import java.util
import java.util.{Calendar, Scanner}
/**
 * Created by Riccardo Cardin on 25/05/14.
 */
// Exercise 1
val gizmos = Map("MacBook" -> 1500.0, "Nexus 5" -> 329.0, "Lego \"Death Star\" set" -> 499.0)
val discountedGizmos = for ((k, v) <- gizmos) yield (k, v * 0.90)
// Exercise 2 & 3
val frequencies = new scala.collection.mutable.HashMap[String, Int]()
var frequencies2 = Map.empty[String, Int]
val in = new Scanner(new File("I:\\Lavoro\\Libri\\Scala for the impatient\\exercises\\testo.txt"))
while (in.hasNext) {
  val sz = in.next()
  val freq = frequencies.getOrElse(sz, 0)
  val freq2 = frequencies2.getOrElse(sz, 0)
  frequencies(sz) = freq + 1
  frequencies2 = frequencies2 + (sz -> (freq2 + 1))
}
frequencies.mkString("; ")
frequencies2.mkString("; ")
// Exercise 6
val daysOfWeek = scala.collection.mutable.LinkedHashMap("Monday" -> Calendar.MONDAY,  "Tuesday" -> Calendar.TUESDAY, "Wensday" -> Calendar.WEDNESDAY, "Thursday" -> Calendar.THURSDAY, "Friday" -> Calendar.FRIDAY, "Saturday" -> Calendar.SATURDAY, "Sunday" -> Calendar.SUNDAY)
for ((k, v) <- daysOfWeek) println(v)







// Exercise 7
import scala.collection.JavaConversions.propertiesAsScalaMap
val sysProps: scala.collection.Map[String, String] = System.getProperties()

val maxLength = sysProps.keys.maxBy(_.length).length
for ((k, v) <- sysProps) {
  println(k.padTo(30, ' ') + "| " + v)
}







































// Exercise 8
def minmax(values: Array[Int]) = {
  if (values == null) throw new IllegalArgumentException("Null array")
  (values.min, values.max)
}
minmax(Array(1,2,3,4,5,6,7,8,9,0))
// Exercise 9
def lteqgt(values: Array[Int], v: Int) = {
  if (values == null) throw new IllegalArgumentException("Null array")
  (values.filter(_ < v).length, values.filter(_ == v).length, values.filter(_ > v).length)
}
lteqgt(Array(1,2,3,4,5,6,7,8,9,0), 5)
// Exercise 10
"Hello".zip("World")

