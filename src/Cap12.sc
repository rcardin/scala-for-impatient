/**
 * Created by Riccardo Cardin on 08/07/2014.
 */
// Exercise 1
def values(fun: (Int) => Int, low: Int, high: Int) = {
  for (i <- low to high) yield (i, fun(i))
}
values(x => x * x, -5, 5)
// Exercise 2
