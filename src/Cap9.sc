import java.io.PrintWriter
import scala.io.Source

/**
 * Created by Riccardo Cardin on 03/06/2014.
 */
// Exercise 1
val source: Source = Source.fromFile("""I:\Lavoro\Libri\Scala for the impatient\exercises\9.1.txt""")
val reverseLines = source.getLines.toArray.reverse
val output = new PrintWriter("""I:\Lavoro\Libri\Scala for the impatient\exercises\9.1_rev.txt""")
for (line <- reverseLines) {
  output.println(line)
}
output.close()
source.close()
//Exercise 2
val source2 = Source.fromFile("""I:\Lavoro\Libri\Scala for the impatient\exercises\9.2.txt""")
val content = source2.mkString split "\\t"
content mkString ", "

val output2 = new PrintWriter("""I:\Lavoro\Libri\Scala for the impatient\exercises\9.2_notab.txt""")
content foreach { token =>
  output2.print( token + "    ")
}
output2.close()
source2.close()
// Exercise 3
val file = """I:\Lavoro\Libri\Scala for the impatient\exercises\9.3.txt"""
Source.fromFile(file).mkString.split("\\s").filter(token => (token.length() >= 12)).foreach(token => print(s" $token"))
// Exercise 4
val source4 = Source.fromFile("""I:\Lavoro\Libri\Scala for the impatient\exercises\9.4.txt""")
val doubleArray = source4.mkString.split("\\s").map(token => token.toDouble)
println("Sum: " + doubleArray.sum)

println("Average: " + (doubleArray.sum / doubleArray.length))

println("Minimum: " + doubleArray.min)

println("Maximum: " + doubleArray.max)

// Exercise 5
for (pow <- 0 to 20) {
  println("%8.0f  %f".format(math.pow(2.0, pow), math.pow(2.0, -pow)))
}



















// Exercise 7
val floatNumberRegex = "[-+]?[0-9]*\\.?[0-9]+".r
val floatArray = floatNumberRegex.findAllIn(Source.fromFile("""I:\Lavoro\Libri\Scala for the impatient\exercises\9.7.txt""").mkString).toArray
println(floatArray.mkString(", "))



