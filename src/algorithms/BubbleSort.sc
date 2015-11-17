import scala.annotation.tailrec

// classical unsafe example of this piece of shit
val arr = Array.fill(10)(math.round(math.random*100))

def bubble(arr: Array[Long]): Unit = {
  for (i <- 0 until arr.length - 1) {
    for (j <- 0 until arr.length - 1 - i) {
      if (arr(j) > arr(j + 1)) {
        val tmp = arr(j)
        arr(j) = arr(j + 1)
        arr(j + 1) = tmp
      }
    }
  }
}
bubble(arr)
arr.foreach(printf("%d ", _))

// let's rewrite it to fp-style
val arr2 = Array.fill(10)(math.round(math.random*100))

@tailrec
def bubbleSort(a: Array[Long], i: Int = 0): Array[Long] = {
  @tailrec
  def bubbleUp(b: Array[Long], i: Int, j: Int = 0): Array[Long] = {
    def bubbleIt(c: Array[Long]): Array[Long] = {
      if (c(j) > c(j + 1)) {
        val tmp = c(j)
        c(j) = c(j + 1)
        c(j + 1) = tmp
      }
      c
    }
    if (j == b.length - 1 - i) b else bubbleUp(bubbleIt(b), i, j + 1)
  }
  if (i == a.length - 1) a else bubbleSort(bubbleUp(a, i), i + 1)
}

bubbleSort(arr2)