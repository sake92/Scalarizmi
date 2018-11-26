# Scalarizmi
Algorithms and data structures, in Scala


## Sorting algorithms

~ easier to harder (my opinion):

- [Insertion sort](https://github.com/sake92/Scalarizmi/blob/master/src/main/scala/ba/sake/scalarizmi/sorting/InsertionSort.scala)
- [Selection sort](https://github.com/sake92/Scalarizmi/blob/master/src/main/scala/ba/sake/scalarizmi/sorting/SelectionSort.scala)
- [Bubble sort](https://github.com/sake92/Scalarizmi/blob/master/src/main/scala/ba/sake/scalarizmi/sorting/BubbleSort.scala)
- [Merge sort](https://github.com/sake92/Scalarizmi/blob/master/src/main/scala/ba/sake/scalarizmi/sorting/MergeSort.scala)

## Maximum subarray
See [wiki](https://en.wikipedia.org/wiki/Maximum_subarray_problem) for more details.  
Gist of the problem is to find a subarray with maximum sum of its elements.  
- When all elements are positive, solution is trivially the sum of all elements
- When all elements are negative, solution is trivially the largest element
- Only interesting case is when there are mixed numbers, solution has to start with a positive number (kinda obvious)

- [Divide & Conquer](https://github.com/sake92/Scalarizmi/blob/master/src/main/scala/ba/sake/scalarizmi/misc/max_subarray/DivideAndConquer.scala)
