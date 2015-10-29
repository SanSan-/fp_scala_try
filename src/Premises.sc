def premises(n:Int):List[Int] = {
  def premLoop(k:Int = 2, acc:List[Int]):List[Int] = {
    def checkIt(i:Int):List[Int] = {
      def check(lst:List[Int]):Boolean = lst match {
        case Nil => true
        case head::tail if i % head == 0 => false
        case head::tail if i % head != 0 => check(tail)
      }
      if (check(acc)) acc :+ k else acc
    }
    if (k > n) acc else premLoop(k+1, checkIt(k))
  }
  premLoop(acc = Nil)
}

premises(100)
premises(100).foreach(println(_))
premises(100).foreach(e => println(e))