def check(i: Int): String = {
  (i % 3, i % 5) match {
    case (0, 0) => "FizzBuzz"
    case (0, _) => "Fizz"
    case (_, 0) => "Buzz"
    case (_, _) => s"$i"
  }
}

def fizzBuzzList(n:Int):List[String] = {
  def cyrcle(k:Int, acc: List[String]):List[String] = {
    if (k<=n) cyrcle(k+1, acc :+ check(k)) else acc
  }
  cyrcle(1, Nil)
}

fizzBuzzList(100)

def fizzBuzz(n:Int):Unit = {
  def cyrcle(k:Int, acc: Unit):Unit = {
    if (k<=n) cyrcle(k+1, println(check(k)))
  }
  cyrcle(1, Nil)
}

fizzBuzz(100)