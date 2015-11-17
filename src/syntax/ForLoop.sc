for (i <- 1 to 10) println(i) // have side effects

for (i <- 1 to 10) yield i // have not side effects

(1 to 10).map(i => i) // actually same thing

for (i <- 0.0 to 1.0 by 0.1) yield i

for (i <- 1 to 10; j <- 1 to 10) yield (i, j)

for {i <- 1 to 10 if i % 2 != 0; j <- 1 to 10 if j % 2 == 0} yield (i, j)

for (i <- 1 to 10; if i % 2 != 0) yield {
  for (j <- 1 to 10; if j % 2 == 0) yield (i, j)
}

val arr = Array(1, 2, 3, 4, 5)
for (e <- arr) yield e + 1

for (e <- arr; doubl = e * e + e * e - e; if doubl % 2 == 0) yield doubl

val tuples = List((1, 3), (2, 4), (1, 5), (3, 7), (6, 1))

for ((1, j) <- tuples) yield j

// non parallel operation
var k = 0
for (i <- 1 to 10000000) k += 1
println(k)

// parallel operation
var t = 0
for (i <- (1 to 10000000).par) t += 1
println(t)
