# [Data Structures and Algorithms](https://www.techinterviewhandbook.org/coding-interview-study-plan/) - [LeetCode Patterns](https://algomaster.io/practice/dsa-patterns)
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

  - Multidimensional Array: If the innner arrays of lengths are not equal then they're known as a jagged array or a non-rectangular array.
    ```java
      int[][] jaggedArray = new int[3][];  // Columns will be different of size
      jaggedArray[0] = new int[2];  // Row 0 has 2 elements
      jaggedArray[1] = new int[3];  // Row 1 has 3 elements
      jaggedArray[2] = new int[4];  // Row 2 has 4 elements
    ```
---

## Strings:

| Feature                | **String**                          | **StringBuilder**                    | **StringBuffer**                    |
|------------------------|-------------------------------------|--------------------------------------|-------------------------------------|
| **Immutability**        | Immutable                           | Mutable                              | Mutable                             |
| **Thread Safety**       | Thread-safe (because of immutability) | Not thread-safe                      | Thread-safe (synchronized methods)  |
| **Performance**         | Less efficient for concatenation (new objects created for each modification) | More efficient for concatenation (no new objects created) | Less efficient than `StringBuilder` (due to synchronization overhead) |
| **Memory Efficiency**   | Less efficient for frequent modifications | More memory-efficient for frequent modifications | More memory-efficient than `String`, but less efficient than `StringBuilder` |
| **Use Case**            | When immutability is needed, or when string literals are being used | For frequent string concatenation or modification in a single thread | When thread safety is required in multi-threaded environments |
| **Example Usage**       | `String str = "Hello";`             | `StringBuilder sb = new StringBuilder("Hello");` | `StringBuffer sbf = new StringBuffer("Hello");` |

---

## Hash Table:
A [`hash table`](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#collections-framework) is a data structure that stores `key-value` pairs and uses a `hashing` technique to efficiently map each key to an index in an array (called a bucket) using a `hash function` `(hash(k) = k % size)`. The hash function takes an input (the key) and computes a `hash code`, which determines the index where the associated value will be stored. This allows for fast O(1) average-time complexity for inserting, deleting, and looking up key-value pairs. However, hash `collisions` can occur when different keys produce the same hash code.

### Collision Resolution Techniques:
Load Factor is the ratio of the number of elements in the hash table to the size of the table. A high load factor increases the likelihood of collisions. When the load factor exceeds a certain threshold (e.g., 0.75), the hash table is typically rehashed—the table size is increased, and the existing entries are redistributed according to the new size. This process helps maintain efficient access times and reduces collisions.

  - **Seperate Chaining** (Open Hashing): Chaining involves storing multiple elements at the same index using a `linked list` or another list-like structure. Each array index (bucket) holds a reference to a list of key-value pairs, allowing the bucket to store multiple entries that hash to the same index.
    
  - **Open Addressing** (Closed Hashing): Open addressing resolves collisions by finding another open slot within the hash table array itself. The key idea is that all elements remain in the table (in the array itself), rather than being stored in linked lists.
      - `Linear Probing`: Search for the next available slot linearly (clustering). Formula: `(hash(k) + i) % tableSize`, where i is the number of probes (0, 1, 2,...).
      
      - `Quadratic Probing`: Search for the next slot using a quadratic sequence (clustering). Formula: `(hash(k) + i^2) % tableSize`, where i is the number of probes.
     
      - `Double Hashing`: Use a second hash function for probing. Formula: `(hash(k) + i * hash'(k)) % tableSize`, where hash'(k) = p - (k % p) and p is randomFixedPrime.
---

## [Linked List](https://leetcode.com/discuss/study-guide/1800120/become-master-in-linked-list)
## [Trees](https://leetcode.com/discuss/study-guide/1820334/Become-Master-in-Tree)
## [Heaps](https://leetcode.com/discuss/study-guide/6149018/Heap-and-Priority-Queue-in-Java-Cheat-Sheet/)
