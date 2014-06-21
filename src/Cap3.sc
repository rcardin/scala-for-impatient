import java.util.TimeZone
import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/**
 * Created by Riccardo Cardin on 22/05/14.
 */
// Exercise 1
val n: Int = 11
val a = new Array[Int](n)
for (i <- 0 until n) {
  a(i) = Random.nextInt(n)
}
a.mkString(", ")
// Exercise 2
for (i <- (0 until n).filter(_ % 2 == 0)) {
  if (i < n - 1) {
    val b = a(i)
    a(i) = a(i + 1)
    a(i + 1) = b
  }
}
a.mkString(", ")
// Exercise 3
for (i <- 0 until n) yield {
  if (i % 2 == 0)
    if (i + 1 < n ) a(i + 1) else a(i)
  else a(i - 1)
}
// Exercise 4
val g = Array(1, 4, -3, 2, -9, -6, 3, 0)
val c = (for (elem <- g if elem >= 0) yield elem) ++ (for (elem <- g if elem < 0) yield elem)
c mkString(", ")
// Exercise 5
val avg = g.foldLeft(0)(_ + _) / g.length
// Exercise 6
g.sortWith(_ > _) mkString(", ")
// Exercise 7
val j = Array(4, 4, 3, 6, 3, 7, 8, 7, 4, 9)
j.distinct mkString(", ")
// Exercise 9
TimeZone.getAvailableIDs() filter( _ contains("America")) map(_ replace("America/", "")) sortWith (_ < _) mkString(", ")
// Exercise 10
import java.awt.datatransfer._
val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]
import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.mutable.Buffer
val buffer: Buffer[String] = flavors.getNativesForFlavor(DataFlavor.imageFlavor)