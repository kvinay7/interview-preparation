# Data Structures and Algorithms
Data structures are ways of organizing and storing data efficiently to perform operations such as retrieval, insertion, deletion, and searching. Algorithms are step-by-step instructions to solve a problem or perform a computation. Efficient algorithms often need to be designed with the appropriate data structures.

## Arrays:
An array is a data structure that can store fixed-size collections of elements of the same type in a single variable. By default array elements are initialized to 0 if they are a numeric type ( int or double ), false if they are of type boolean , or null if they are an object type like String.

  - Declaring and Initializing Arrays:
    ```java
    int[] nums = new [5]; // Creates an array of 5 integers, default values are 0
    int[] numbers = {1, 2, 3, 4, 5}; // Initializes with values
    ```
    -  [Find N Unique Integers Sum up to Zero](https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/description/)

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
    - [Concatenation of Array](https://leetcode.com/problems/concatenation-of-array/description/)
    - [Plus One](https://leetcode.com/problems/plus-one/description/)
    - [Add to Array-Form of Integer](https://leetcode.com/problems/add-to-array-form-of-integer/description/)
  
  - Moore Voting Algo:
    - [Majority Element](https://leetcode.com/problems/majority-element/description/)
    - [Majority Element II](https://leetcode.com/problems/majority-element-ii/description/)

  - Intervals:
    - [Summary Ranges](https://leetcode.com/problems/summary-ranges/description/)
    - [Insert Interval](https://leetcode.com/problems/insert-interval/description/)
    - [Merge Intervals](https://leetcode.com/problems/merge-intervals/description/)
    - [Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/description/)

  - Problems:
    - [Target Array](https://leetcode.com/problems/create-target-array-in-the-given-order/description/)
    - [Build Array from Permutation](https://leetcode.com/problems/build-array-from-permutation/description/)
    - [Can Place Flowers](https://leetcode.com/problems/can-place-flowers/description/)
    - [Increasing Triplet Subsequence](https://leetcode.com/problems/increasing-triplet-subsequence/description/)
    - [Last Moment Before All Ants Fall Out of a Plank](https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/description/)
    - [Stock Problems](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solutions/108870/most-consistent-ways-of-dealing-with-the-series-of-stock-problems/)
