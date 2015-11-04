def process(f: (Int, Int) => Int)(a:Int):Int => Int = b => f(a,b)


def plus(x: Int, y: Int): Int = x+y
def multiplie(x: Int, y: Int): Int = x*y
def add(a: Int): Int => Int = process(plus)(a)
def add2(a: Int): Int => Int = process(_+_)(a)
val addFour = add(4)
addFour(3)
add(4)(3)
addFour(5)
add(4)(5)
def mult(a: Int): Int => Int = process(multiplie)(a)
val multThree = mult(3)
multThree(4)
mult(3)(4)
def add3(a:Int)(b:Int): Int = a+b
add3(5)(3)
def addmod(a:Int)(b:Int):Int = {
  def map(f: (Int,Int) => Int):Int = {
    f(a,b)
  }
  map(_+_)
}
addmod(1)(5)

def add4(a: Int): Int => Int = b => a+b

val addTwo = add4(2)
addTwo(6)
add4(2)(6)