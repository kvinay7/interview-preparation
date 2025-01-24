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
    - [Plus One](https://leetcode.com/problems/plus-one/description/)
    - [Add to Array-Form of Integer](https://leetcode.com/problems/add-to-array-form-of-integer/description/)
    - [Target Array](https://leetcode.com/problems/create-target-array-in-the-given-order/description/)
    - [Build Array from Permutation](https://leetcode.com/problems/build-array-from-permutation/description/)
    - [Last Moment Before All Ants Fall Out of a Plank](https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/description/)
    - [Can Place Flowers](https://leetcode.com/problems/can-place-flowers/description/)
    - [Increasing Triplet Subsequence](https://leetcode.com/problems/increasing-triplet-subsequence/description/)
    - [Stock Problems](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solutions/108870/most-consistent-ways-of-dealing-with-the-series-of-stock-problems/)
    - [Number of Zero-Filled Subarrays](https://leetcode.com/problems/number-of-zero-filled-subarrays/description/)
    - [Majority Element II](https://leetcode.com/problems/majority-element-ii/description/)
    
    
  - [Two Pointers](https://blog.algomaster.io/p/69025a2e-b0d5-4705-8507-bba16c2691f1)
    - [Merge Without Extra Space](https://www.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1)
    - [Remove Element](https://leetcode.com/problems/remove-element/description/)
    - [Remove Duplicates from Sorted Array II](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/)
    - [2Sum in RSA](https://www.geeksforgeeks.org/problems/pair-sum-in-a-sorted-and-rotated-array/1)
    - [2Sum closest](https://www.geeksforgeeks.org/problems/pair-in-array-whose-sum-is-closest-to-x1124/0)
    - [2Sum Count](https://www.geeksforgeeks.org/problems/pair-with-given-sum-in-a-sorted-array4940/1)
    - [3Sum Count](https://www.geeksforgeeks.org/problems/count-all-triplets-with-given-sum-in-sorted-array/1)
    - [3Sum Closest](https://www.geeksforgeeks.org/problems/3-sum-closest/1)
    - [Valid Triangle Number](https://leetcode.com/problems/valid-triangle-number/description/)
    - [Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/description/)
  
  - [Sliding Window](https://blog.algomaster.io/p/f4412a17-7a3a-4d0b-8e39-9ea8f429bf7c)
    - [Max No of Vowels in a Substring](https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/?envType=study-plan-v2&envId=leetcode-75)
    - [Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/description/)
    - [Shortest Subarray with Sum at Least K](https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/description/)
    - [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/description/)
    - [Maximum Sum Circular Subarray](https://leetcode.com/problems/maximum-sum-circular-subarray/description/)
    - [Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/description/)
    - [Best Sightseeing Pair](https://leetcode.com/problems/best-sightseeing-pair/description/)
    - [Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/description/)
    - [Longest Subarray of 1's After Deleting One Element](https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/)
    - [Minimum Removals for Target Sum](https://www.geeksforgeeks.org/problems/minimum-removals-for-target-sum/1)
    
  - Prefix Sum:
    - [Running Sum](https://leetcode.com/problems/running-sum-of-1d-array/description/)
    - [Find Pivot Index](https://leetcode.com/problems/find-pivot-index/description/)
    - [Range Sum Query - Immutable](https://leetcode.com/problems/range-sum-query-immutable/description/)
    - [Range Sum Query 2D - Immutable](https://leetcode.com/problems/range-sum-query-2d-immutable/description/)
    - [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/description/)

  - Multidimensional Arrays: If the innner arrays of lengths are not equal then they're known as a jagged array or a non-rectangular array.
  ```java
    int[][] jaggedArray = new int[3][];  // Declares an array with 3 rows, but columns will be different
    jaggedArray[0] = new int[2];  // Row 0 has 2 elements
    jaggedArray[1] = new int[3];  // Row 1 has 3 elements
    jaggedArray[2] = new int[4];  // Row 2 has 4 elements
   ```
  - Matrix:
    - [Matrix Diagonal Sum](https://leetcode.com/problems/matrix-diagonal-sum/description/)
    - [Transpose Matrix (m*n)](https://leetcode.com/problems/transpose-matrix/description/)
    - [Transpose Matrix (n*n)](https://www.geeksforgeeks.org/problems/transpose-of-matrix-1587115621/1)
    - [Clockwise Rotate](https://leetcode.com/problems/rotate-image/description/)
    - [Anti-Clockwise Rotate](https://www.geeksforgeeks.org/problems/rotate-by-90-degree-1587115621/1)
    - [Reshape the Matrix](https://leetcode.com/problems/reshape-the-matrix/description/)
    - [Game of Life](https://leetcode.com/problems/game-of-life/description/)
    - [Spiral Matrix - III](https://leetcode.com/problems/spiral-matrix-iii/description/)
    - [Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes/description/)
    - [Find Valid Matrix](https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/description/)

  - Intervals:
    - [Summary Ranges](https://leetcode.com/problems/summary-ranges/description/)
    - [Insert Interval](https://leetcode.com/problems/insert-interval/description/)
    - [Merge Intervals](https://leetcode.com/problems/merge-intervals/description/)
    - [Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/description/)
    - [Max No of Events to Attend](https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/description/)
      
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
    - [Integer to English Words](https://leetcode.com/problems/integer-to-english-words/description/)
    - [Search Pattern (KMP-Algorithm)](https://www.geeksforgeeks.org/problems/search-pattern0205/1)
    - [Repeated String Match](https://leetcode.com/problems/repeated-string-match/description/)
    - [Count Prefix and Suffix Pairs](https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/description/)
    - [Longest Happy Prefix](https://leetcode.com/problems/longest-happy-prefix/description/)
    - [Min Chars to Add for Palindrome](https://www.geeksforgeeks.org/problems/minimum-characters-to-be-added-at-front-to-make-string-palindrome/0)
    - [Min Insertions to Make a String Palindrome](https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/)

## Hash Table:
A [`hash table`](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#collections-framework) is a data structure that stores `key-value` pairs and uses a `hashing` technique to efficiently map each key to an index in an array (called a bucket) using a `hash function` `(hash(k) = k % size)`. The hash function takes an input (the key) and computes a `hash code`, which determines the index where the associated value will be stored. This allows for fast O(1) average-time complexity for inserting, deleting, and looking up key-value pairs. However, hash `collisions` can occur when different keys produce the same hash code.

### Collision Resolution Techniques:
Load Factor is the ratio of the number of elements in the hash table to the size of the table. A high load factor increases the likelihood of collisions. When the load factor exceeds a certain threshold (e.g., 0.75), the hash table is typically rehashed—the table size is increased, and the existing entries are redistributed according to the new size. This process helps maintain efficient access times and reduces collisions.

  - **Seperate Chaining** (Open Hashing): Chaining involves storing multiple elements at the same index using a `linked list` or another list-like structure. Each array index (bucket) holds a reference to a list of key-value pairs, allowing the bucket to store multiple entries that hash to the same index.
    
  - **Open Addressing** (Closed Hashing): Open addressing resolves collisions by finding another open slot within the hash table array itself. The key idea is that all elements remain in the table (in the array itself), rather than being stored in linked lists.
      - `Linear Probing`: Search for the next available slot linearly (clustering). Formula: `(hash(k) + i) % tableSize`, where i is the number of probes (0, 1, 2,...).
      
      - `Quadratic Probing`: Search for the next slot using a quadratic sequence (clustering). Formula: `(hash(k) + i^2) % tableSize`, where i is the number of probes.
     
      - `Double Hashing`: Use a second hash function for probing. Formula: `(hash(k) + i * hash'(k)) % tableSize`, where hash'(k) = p - (k % p) and p is randomFixedPrime.

  - Problems:
    - [4 Sum - Distinct quadruples](https://www.geeksforgeeks.org/problems/find-all-four-sum-numbers1732/1)
    - [4 Sum – All quadruples](https://www.geeksforgeeks.org/problems/count-quadruplets-with-given-sum/1)
    - [Count Subarrays with given XOR](https://www.geeksforgeeks.org/problems/count-subarray-with-given-xor/1)
    - [Subarrays with K Different Integers](https://leetcode.com/problems/subarrays-with-k-different-integers/description/)
    - [Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/description/)
    - [Subarray Sums Divisible by K](https://leetcode.com/problems/subarray-sums-divisible-by-k/description/)
    - [Continuous Subarray Sum](https://leetcode.com/problems/continuous-subarray-sum/description/)
    - [Contiguous Array](https://leetcode.com/problems/contiguous-array/description/)
    - [Split Array into Consecutive Subsequences](https://leetcode.com/problems/split-array-into-consecutive-subsequences/description/)
    - [Group Shifted String](https://www.geeksforgeeks.org/problems/group-shifted-string/1)

## [Linked Lists](https://leetcode.com/discuss/study-guide/1800120/become-master-in-linked-list)
## [Binary Search](https://leetcode.com/discuss/study-guide/3726061/Binary-Search%3A-A-Comprehensive-Guide)
---

## [Topic-wise Problems](https://algomaster.io/practice/dsa-patterns)
## [Overall Problems](https://drive.google.com/file/d/1H6gnAtlRZPuOiNq-s-0F9BSkFTsnPJHO/view)
