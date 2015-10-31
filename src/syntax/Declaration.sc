val Array(a,b,c) = "1,2,3".split(",").map(_.toInt)
val str = "Why this is %02x so equal to %d".format(132,84)
val ff = "%x".format(255)

val col1 = List(1,2,3)
val col2 = "a b c ".split(" ")
val col3 = col1.zip(col2) // now we got collections of a couples of element from col1 and col2
col3.map(e => e._2*e._1)
val col4 = (col1,col2).zipped // Different thing when we concat them \w zipped
col4.map((num,str) => str*num) // same map result as we do \w col3
