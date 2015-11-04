import scala.annotation.tailrec

def check(i: Int): String = {
  (i % 3, i % 5) match {
    case (0, 0) => "FizzBuzz"
    case (0, _) => "Fizz"
    case (_, 0) => "Buzz"
    case (_, _) => s"$i"
  }
}

def fizzBuzzList(n:Int):List[String] = {
  @tailrec
  def cyrcle(k:Int = 1, acc: List[String]):List[String] = {
    if (k<=n) cyrcle(k+1, acc :+ check(k)) else acc
  }
  cyrcle(acc = Nil)
}

fizzBuzzList(100)

def fizzBuzz(n:Int):Unit = {
  @tailrec
  def cyrcle(k:Int = 1, acc: Unit):Unit = {
    if (k<=n) cyrcle(k+1, println(check(k)))
  }
  cyrcle(acc = Nil)
}

fizzBuzz(100)