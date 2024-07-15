import scala.annotation.tailrec

object Fibonacci {
  private def fibonacci(n: Int): Int = n match {
    case 0 => 0
    case 1 => 1
    case _ => fibonacci(n - 1) + fibonacci(n - 2)
  }

  private def printFibonacci(n: Int): Unit = {
    @tailrec
    def loop(i: Int): Unit = {
      if (i < n) {
        print(s"${fibonacci(i)} ")
        loop(i + 1)
      }
    }

    loop(0)
  }

  def main(args: Array[String]): Unit = {
    val n = 10
    println(s"First $n Fibonacci numbers:")
    printFibonacci(n)
  }
}
