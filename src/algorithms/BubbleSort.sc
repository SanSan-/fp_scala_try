import scala.annotation.tailrec

// classical unsafe example of this piece of shit
val arr = Array(4, 2, 7, 3, 9, 8, 1, 5)

def bubble(arr: Array[Int]): Unit = {
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

// re:write it to fp-style
val arr2 = Array(4, 2, 7, 3, 9, 8, 1, 5)

@tailrec
def bubbleSort(a: Array[Int], i: Int = 0): Array[Int] = {
  @tailrec
  def bubbleUp(b: Array[Int], i: Int, j: Int = 0): Array[Int] = {
    def bubbleIt(c: Array[Int]): Array[Int] = {
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