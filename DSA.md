# Data Structures and Algorithms
Data structures are ways of organizing and storing data efficiently to perform operations such as retrieval, insertion, deletion, and searching. Algorithms are step-by-step instructions to solve a problem or perform a computation. Efficient algorithms often need to be designed with the appropriate data structures.

## Arrays:
An array is a data structure that can store fixed-size collections of elements of the same type in a single variable. By default array elements are initialized to 0 if they are a numeric type ( int or double ), false if they are of type boolean , or null if they are an object type like String.

  - Declaring and Initializing Arrays:
    ```java
    int[] nums = new int[5]; // Creates an array of 5 integers, default values are 0
    int[] numbers = {1, 2, 3, 4, 5}; // Initializes with values
    System.out.print(numbers[2]); // Accesing array values
    ```

  - Anonymous Array: is a one-time-use array that is not stored in a variable but used directly in method calls or expressions.
    ```java
    int[] anonymousArray(){
        return new int[]{};
    }
    ```
    
  - Array Resizing:
    ```java
    void ensureCapacity(){
      if(size == arr.length){
          int newCapacity = arr.length * 2;
          arr = Arrays.copyOf(arr, newCapacity);
      }
    }
    ```
  - Problems:
    - [Find N Unique Integers Sum up to Zero](https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/description/)
    - [Concatenation of Array](https://leetcode.com/problems/concatenation-of-array/description/)
    - [Plus One](https://leetcode.com/problems/plus-one/description/)
    - [Add to Array-Form of Integer](https://leetcode.com/problems/add-to-array-form-of-integer/description/)
    - [Target Array](https://leetcode.com/problems/create-target-array-in-the-given-order/description/)
    - [Build Array from Permutation](https://leetcode.com/problems/build-array-from-permutation/description/)
    - [Can Place Flowers](https://leetcode.com/problems/can-place-flowers/description/)
    - [Increasing Triplet Subsequence](https://leetcode.com/problems/increasing-triplet-subsequence/description/)
    - [Last Moment Before All Ants Fall Out of a Plank](https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/description/)
    - [Stock Problems](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solutions/108870/most-consistent-ways-of-dealing-with-the-series-of-stock-problems/)
 
  - Moore Voting Algo:
    - [Majority Element](https://leetcode.com/problems/majority-element/description/)
    - [Majority Element II](https://leetcode.com/problems/majority-element-ii/description/)
 
  - [Two Pointers](https://leetcode.com/discuss/study-guide/1688903/Solved-all-two-pointers-problems-in-100-days)
  - [Sliding Window](https://blog.algomaster.io/p/f4412a17-7a3a-4d0b-8e39-9ea8f429bf7c):
    - [Max Sum of Distinct Subarrays With Length K](https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/)
    - [Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/description/)
    - [Shortest Subarray with Sum at Least K](https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/description/)
    - [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/description/)
    - [Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/description/)
    - [Maximum Sum Circular Subarray](https://leetcode.com/problems/maximum-sum-circular-subarray/description/)
    - [Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/description/)
    - [Longest Subarray of 1's After Deleting One Element](https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/)
    - [Best Sightseeing Pair](https://leetcode.com/problems/best-sightseeing-pair/description/)
    - [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/description/)

  - Multidimensional Arrays: If the innner arrays of lengths are not equal then they're known as a jagged array or a non-rectangular array.
  ```java
    int[][] jaggedArray = new int[3][];  // Declares an array with 3 rows, but columns will be different
    jaggedArray[0] = new int[2];  // Row 0 has 2 elements
    jaggedArray[1] = new int[3];  // Row 1 has 3 elements
    jaggedArray[2] = new int[4];  // Row 2 has 4 elements
   ```
  - Matrix:
    - [Multiply Matrices](https://www.geeksforgeeks.org/problems/multiply-matrices/1)
    - [Matrix Diagonal Sum](https://leetcode.com/problems/matrix-diagonal-sum/description/)
    - [Transpose Matrix (m*n)](https://leetcode.com/problems/transpose-matrix/description/)
    - [Transpose Matrix (n*n)](https://www.geeksforgeeks.org/problems/transpose-of-matrix-1587115621/1)
    - [Clockwise Rotate](https://leetcode.com/problems/rotate-image/description/)
    - [Anti-Clockwise Rotate](https://www.geeksforgeeks.org/problems/rotate-by-90-degree-1587115621/1)
    - [Reshape the Matrix](https://leetcode.com/problems/reshape-the-matrix/description/)
    - [Spiral Matrix - I](https://leetcode.com/problems/spiral-matrix/description/)
    - [Spiral Matrix - III](https://leetcode.com/problems/spiral-matrix-iii/description/)
    - [Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes/description/)

  - Intervals:
    - [Summary Ranges](https://leetcode.com/problems/summary-ranges/description/)
    - [Insert Interval](https://leetcode.com/problems/insert-interval/description/)
    - [Merge Intervals](https://leetcode.com/problems/merge-intervals/description/)
    - [Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/description/)

## Strings:
A String is an object that represents a sequence of 16-bit unicode characters.

| Feature                | **String**                          | **StringBuilder**                    | **StringBuffer**                    |
|------------------------|-------------------------------------|--------------------------------------|-------------------------------------|
| **Immutability**        | Immutable                           | Mutable                              | Mutable                             |
| **Thread Safety**       | Thread-safe (because of immutability) | Not thread-safe                      | Thread-safe (synchronized methods)  |
| **Performance**         | Less efficient for concatenation (new objects created for each modification) | More efficient for concatenation (no new objects created) | Less efficient than `StringBuilder` (due to synchronization overhead) |
| **Memory Efficiency**   | Less efficient for frequent modifications | More memory-efficient for frequent modifications | More memory-efficient than `String`, but less efficient than `StringBuilder` |
| **Use Case**            | When immutability is needed, or when string literals are being used | For frequent string concatenation or modification in a single thread | When thread safety is required in multi-threaded environments |
| **Example Usage**       | `String str = "Hello";`             | `StringBuilder sb = new StringBuilder("Hello");` | `StringBuffer sbf = new StringBuffer("Hello");` |

  - Problems:
    
    - [Count and Say](https://leetcode.com/problems/count-and-say/description/)
    - [Zigzag Conversion](https://leetcode.com/problems/zigzag-conversion/description/)
    - [String to Integer (atoi)](https://leetcode.com/problems/string-to-integer-atoi/description/)
    - [Search Pattern (KMP-Algorithm)](https://www.geeksforgeeks.org/problems/search-pattern0205/1)
    - [Min Chars to Add for Palindrome](https://www.geeksforgeeks.org/problems/minimum-characters-to-be-added-at-front-to-make-string-palindrome/0)
    - [Min Insertions to Make a String Palindrome](https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/)
