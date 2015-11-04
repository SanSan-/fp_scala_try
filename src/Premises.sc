import scala.annotation.tailrec

@tailrec
def Premises(n:Int,k:Int=2,acc:List[Int]=Nil):List[Int] = {
    @tailrec
    def Check(lst:List[Int],i:Int):Boolean = lst match {
      case Nil => true
      case head::tail if i % head == 0 => false
      case head::tail if i % head != 0 => Check(tail,i)
    }
    if (k>n) acc else Premises(n,k+1,if (Check(acc,k)) acc:+k else acc)
}

Premises(100)
Premises(100).foreach(println(_))
Premises(100).foreach(e => println(e))

/*
  make our premises func shorter \w high-order functions
  use 'H\O func' List().exist against our Check() function
  get one row function
 */
@tailrec
def PremisesShort(n:Int,k:Int=2,acc:List[Int]=Nil):List[Int] = if (k>n) acc else PremisesShort(n,k+1, if (acc.exists(k%_==0)) acc else acc:+k)
PremisesShort(100)