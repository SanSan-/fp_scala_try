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
arr.foreach(printf("%d ",_))