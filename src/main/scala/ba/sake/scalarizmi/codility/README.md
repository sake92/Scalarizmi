
## Sum of range (i,j) using prefix sums
```scala
val array = Array(1, 2, 3)
val prefixSums = Array.ofDim[Int](array.length + 1) // Array(0, 1, 3, 6)
for (i <- prefixSums.indices.tail)
  prefixSums(i) = prefixSums(i - 1) + array(i - 1)

def sumBetween(i: Int, j: Int) = 
  prefixSums(j + 1) - prefixSums(i) 

println(sumBetween(0,2)) // 6
println(sumBetween(1,2)) // 5
```

## Count between (i,j) using prefix sums
```scala
val array = Array(4, 6, 7, 2)
val prefixCounts = Array.ofDim[Int](10)
for (i <- array.indices)
  prefixCounts(array(i) + 1) = 1 // note it's shifted +1 !!!
for (i <- prefixCounts.indices.tail)
  prefixCounts(i) += prefixCounts(i - 1)
  
def countBetween(i: Int, j: Int) = 
  prefixCounts(j + 1) - prefixCounts(i)

println(countBetween(0, 2)) // 1 (just 2)
println(countBetween(4, 7)) // 3 (4,6 and 7)
```