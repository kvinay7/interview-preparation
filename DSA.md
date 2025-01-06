## Arrays:
  - Array Resizing:
    ```java
    ensureCapacity(){
      if(size == arr.length){
          int newCapacity = arr.length * 2;
          arr = Arrays.copyOf(arr, newCapacity);
      }
    }
    ```
    - [Concatenation of Array](https://leetcode.com/problems/concatenation-of-array/description/)
      
  - By default array elements are initialized to 0 if they are a numeric type ( int or double ), false if they are of type boolean , or null if they are an object type like String .
    -  [Find N Unique Integers Sum up to Zero](https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/description/)
  
  - Moore Voting Algo:
    - [Majority Element](https://leetcode.com/problems/majority-element/description/)
    - [Majority Element II](https://leetcode.com/problems/majority-element-ii/description/)

  - Problems:
    - [Build Array from Permutation](https://leetcode.com/problems/build-array-from-permutation/description/)
    - [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/)
    - [Last Moment Before All Ants Fall Out of a Plank](https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/description/)
    - [Increasing Triplet Subsequence](https://leetcode.com/problems/increasing-triplet-subsequence/description/)
    - [Can Place Flowers](https://leetcode.com/problems/can-place-flowers/description/)
   
