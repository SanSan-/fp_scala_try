type Point = (Double, Double, Double)
val p:Point = (1.0,2.0,3.0) // not (1,2,3) because i can't *sad*
def mag (p:Point):Double = math.sqrt(p._1*p._1 + p._2*p._2 + p._3*p._3 )
mag(p)
case class Point3D (x: Double, y: Double, z:Double) {
  def mag():Double = math.sqrt(x*x + y*y + z*z)

  def distance(that:Point3D):Double = {
    Point3D(this.x - that.x, this.y - that.y, this.z - that.z).mag()
  }
}
val p1 = Point3D(1,2,3)
val p2 = Point3D(4,5,6)
p1.x
p1.y
p1.z
p1.mag()
p2.distance(p1)
p2 distance p1 // same thing
val points = Array.fill(10)(Point3D(math.random,math.random,math.random))
for (point <- points) yield point.mag()
case class Human(name: String = "Peter", surname: String = "Venkman", cash:List[Int] = List(0)) {
  def checkBalance():Int = cash.sum
  def sayName():Unit = printf("%s %s \n", name, surname)
}
val alexFranz = Human("Alex", "Franz", List(78,-92,54))
alexFranz.checkBalance()
alexFranz.sayName()
// partial declaration of object
val peterVenkman = Human(cash = List(999999999,-56)) // that's shorter
peterVenkman.sayName()
// clone method \w mutations
peterVenkman.copy(name = "Janine") // this is how to get a modified immutable case class
// filtering
val humans = alexFranz :: peterVenkman :: Nil
for (Human(n,_,List(x1,x2)) <- humans) printf ("Now %s has %d dollars\n", n, x1+x2) // pattern as a filter

// How to make immutable data mutable in case class
case class Zerg(var point:Int) {
  def setPoint(value:Int):Unit = point=value
  def getPoint():Int = this.point
}

val mutalisk = Zerg(77)
println(mutalisk.getPoint())
mutalisk.setPoint(42)
println(mutalisk.getPoint())
mutalisk.point = 46
println(mutalisk.getPoint())