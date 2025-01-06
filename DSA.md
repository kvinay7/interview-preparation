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
