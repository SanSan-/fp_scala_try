val nums = Array.fill(100)(math.random)

nums.map(e => e*e).filter(_ < 0.25).sum // each time every new method create a new temporary collection
// how to avoid this?
nums.view.map(e => e*e).filter(_ < 0.25).sum // this is how
val arr = Array(1,1,1,1,1,1,1)
arr.foreach(printf("%d ",_))
def fillArray(a:Array[Int], thing: Int, i:Int):Unit = {
  if (i < a.length) {
    a(i) = thing
    fillArray(a,thing,i+1)
  }
}

fillArray(arr, 33, 0) // dangerous mutation of array

arr.foreach(printf("%d ",_)) // array is mutable (list is not)