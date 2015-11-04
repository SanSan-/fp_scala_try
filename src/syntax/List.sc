val lst = List(1,3,4,8,6,9)
val head::tailList = lst // this is how to take (and declare) first element of list with head
val headList:+tail = lst // this is how to take (and declare) last element of list with tail
lst:+42 // append element at end of list
42+:lst // append element at start of list
42::lst // same thing
val rem = List(3,6,8)
val checkOut = lst diff rem // remove rem's elements from lst
lst.diff(List(3)) // lst \wo '3'
// High-Order Functions
lst.reduceLeft(_+_) // same as a lst.sum
lst.reduceLeft((acc,x)=>{printf("%d, %d\n",acc,x);acc+x})
lst.reduceRight(_+_) // looks like a reduceLeft, but not exactly
lst.reduceRight((x,acc)=>{printf("%d, %d\n",x,acc);x+acc})
lst.foldLeft(0)(_+_) // works as both upper reducers, but..
lst.foldLeft(0)((acc,x)=>{printf("%d, %d\n",acc,x);acc+x})
lst.foldRight(0)((x,acc)=>{printf("%d, %d\n",x,acc);x+acc})
lst.map(_%2==0) // make List of boolean
lst.find(_%2==0) // find first even number in List
lst.find(18%_==0)
lst.exists(5%_==0) // is lst exist number that divided by 5