import scala.annotation.tailrec

val arr = Array.fill(10)(math.round(math.random * 100))

def minSort(arr: Array[Long]): Unit = {
  for (i <- 0 until arr.length - 1) {
    var min = i
    for (j <- i + 1 until arr.length) {
      if (arr(j) < arr(min)) min = j
    }
    val tmp = arr(i)
    arr(i) = arr(min)
    arr(min) = tmp
  }
}

minSort(arr)
arr.foreach(printf("%d ", _))

val arr2 = Array.fill(10)(math.round(math.random * 100))

@tailrec
def minimalSort(a: Array[Long], i: Int = 0): Array[Long] = {
  def setMin(b: Array[Long]): Array[Long] = {
    @tailrec
    def findMin(min: Int, j: Int): Int = {
      if (j == b.length) min else findMin(if (b(j) < b(min)) j else min, j + 1)
    }
    val min = findMin(i, i + 1)
    val tmp = b(i)

    b(i) = b(min)
    b(min) = tmp
    b
  }
  if (i == a.length - 1) a else minimalSort(setMin(a), i + 1)
}

minimalSort(arr2)