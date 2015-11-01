val lst = List(1,3,4,8,6,9)
val head::tailList = lst // this is how to take (and declare) first element of list with head
val headList:+tail = lst // this is how to take (and declare) last element of list with tail

lst:+42 // append element at end of list
42+:lst // append element at start of list
42::lst // same thing

val rem = List(3,6,8)
val checkOut = lst diff rem // remove rem's elements from lst
lst.diff(List(3)) // lst \wo '3'
