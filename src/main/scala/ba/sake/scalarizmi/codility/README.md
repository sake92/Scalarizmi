
## Sum of range (i,j) using prefix sums
```scala
val array = Array(1, 2, 3)
val ps = Array.ofDim[Int](array.length + 1) // Array(0, 1, 3, 6)
for (i <- ps.indices.tail)
  ps(i) = ps(i - 1) + array(i - 1)

def sumBetween(i: Int, j: Int) = 
  ps(j + 1) - ps(i) 

println(sumBetween(0,2)) // 6
println(sumBetween(1,2)) // 5
```

## Count between (i,j) using prefix sums
```scala
val array = Array(4, 6, 7, 2)
val pc = Array.ofDim[Int](10)
for (i <- array.indices)
  pc(array(i) + 1) = 1 // note it's shifted +1 !!!
for (i <- pc.indices.tail)
  pc(i) += pc(i - 1)
  
def countBetween(i: Int, j: Int) = 
  pc(j + 1) - pc(i)

println(countBetween(0, 2)) // 1 (just 2)
println(countBetween(4, 7)) // 3 (4,6 and 7)
```
