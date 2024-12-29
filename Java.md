# Java

- [Introduction](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#introduction)
    - [Features](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#features)
    - [Terminologies](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#terminologies)
    - [Console](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#console)
- [Basics](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#tokens)
    - [Identifiers](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#identifier)
    - [Variables and Data Types](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#variables-and-data-types)
    - [Standard I/O](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#standard-io)
    - [Operators](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#operators)
        - [Precedence and Associativity](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#precedence-and-associativity)
    - [Control Statements](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#control-structures)
    - [Stack vs Heap memory](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#stack-vs-heap-memory)
- [OOP](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#object-oriented-programming-oop)
    - [Packages](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#packages)
    - [Access Modifiers](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#access-modifiers)
    - [Encapsulation](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#encapsulation)
    - [Inheritance](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#inheritance):
        - [`this` vs `super`](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#this-vs-super)
    - [Polymorphism](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#polymorphism)
        - [Dynamic Method Dispatch](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#dynamic-method-dispatch)
        - [Covariant Return Type](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#covariant-return-type)
    - [Non-Access Modifiers](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#non-access-modifiers)
    - [Abstraction](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#abstraction)
        - [`abstract` vs `interface`](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#abstract-vs-interface)
    - [Generics](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#generics)
- [Collections](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#collections-framework)
- [Java-8](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#imperative-vs-declarative)
    - [Stream API](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#stream-api)
    - [Optional](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#optional)
- [Exception Handling](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#exception-handling)
- [File I/O](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#file-io)
- [Multithreading](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#multithreading)
- [Interview Questions](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#java-interview-questions-see-here) 

## Introduction:
Java is a general-purpose, class-based, object-oriented, high-level programming language developed by James Gosling and his team at Sun Microsystems in the mid-1990's. The main goal of creating Java was to achieve platform-independent, simple, and secure features.

### Features:
- **Simplicity:** Java's syntax is designed to be easy to learn, write and maintain code.
- **Platform Independent:** Java code is compiled into bytecode (platform-independent code), which runs on the JVM. This abstraction allows the same bytecode to execute on any platform that has a compatible JVM, achieving true platform independence.
- **Portability:** "Write Once, Run Anywhere" (WORA) emphasizes its design for cross-platform compatability and architecture-neutral.
- **Security:** Java provides robust security features like bytecode verification, a security manager, and sandboxing to protect against security threats.
- **High Performance:** Java uses Just-In-Time (JIT) compilation to optimize performance by compiling bytecode to machine code at runtime.
- **Dynamic Linking:** Classes are linked at runtime rather than at compile time. This allows Java programs to load classes dynamically, ensuring better flexibility and scalability.
- **Robustness:** Java's strong memory management, type checking, and exception handling make it a reliable language for building robust applications.

### Terminologies:
- **JDK:** Java Development Kit is need to compile java source code into bytecode and contains JRE & develop, debug, deploy tools.
- **JRE:** Java Runtime Environment is need to run a java program and contains JVM & libraries.
- **JVM:** Java Virtual Machine interprets the java bytecode to machine code and contains class loader (dynamic linking), bytecode verifier, JIT compiler. [see here](https://www.interviewbit.com/java-cheat-sheet/#java-terminology)
- **IDE:** Integrated Development Environment makes writing code, compiling, executing, debbuging and test Easy!.

### Console:
- **Compile:** C:\\> javac Hello.java
- **Run:** C:\\> java Hello

## Tokens:
Tokens are the smallest elements of a program that have meaning and are used to form the syntax of the language. Java programs are parsed and analyzed by the compiler in terms of tokens.
 - Examples: Keywords, Identifiers, Literals, Operators and Special Characters.

### Identifier:
An identifier is the name used to identify a variable & method (CamelCase), class & interface (PascalCase), constants (UPPER_CASE, UC) or any other user-defined item in the program.
- The first character must be a letter (A-Z or a-z), a dollar sign $, or an underscore _. It cannot be a digit (0-9).
- Identifiers are case-sensitive and cannot be the keywords(50) or literals.

## Variables and Data Types:
A variable is a container for storing data values and Data types define the type of data that can be stored in a variable.
- **Reference Data Types:** refer to objects, arrays, enum and can be null.
- **Primitives:** Java isn't considered a pure oop language mainly because it has primitive types which represent single value and can't be null. In memory, char are stored as ASCII values, 48-57 -> '0'-'9', 65-90 -> 'A'-'Z', 97-122 -> 'a'-'z'. Signed values range: -(2^(n-1)) to (2^(n-1))-1.
  - **boolean:** default - false 
  - **char:** default - '\u0000' (%c), size - 2 bytes and range is 0-65,535
  - **byte:** default - 0 and size - 8 bits
  - **short:** default - 0 and size - 2 bytes
  - **int:** default - 0 (%d) and size - 4 bytes
  - **long:** default - 0L and size - 8 bytes
  - **float:** default - 0.0f (%f) and size - 4 bytes
  - **double:** default - 0.0d (%lf) and size - 8 bytes

- **Type Casting:**
  - Implicit/Widening: automatically converts smaller data type to larger.
  - Explicit/Narrowing: converting from a larger data type to a smaller.
  - Manual boxing: wType.valueOf(primitive) - smallerOrSamePrimitive to largerOrSameWrapper, largerPrimitive to smallerWrapper's primitive to smallerWrapper.
  - Manual unboxing: wVar.typeValue() - Wrapper to Primitive, Wrapper to Wrapper.

- **Number Systems:** 0b-Binary (%b), 0-Octal (%o), 0x-Hex (%x, %X)
  - Decimal to Hexa: Integer.toHexString()
  - Hexa to Decimal: Integer.parseInt(String, 16)

## Standard I/O:
- **Scanner Class:**
  ```java
      import java.util.Scanner;
      class StandardIO {
          public static void main(String[] args) {
              Scanner sc = new Scanner(System.in);
              String str1 = sc.nextLine();  // reads a line of text
              String str2 = sc.next();      // reads a word
              //EOF: sc.hasNext(), nextBoolean(), nextByte(), nextShort(), nextInt(), nextFloat(), nextLong(), nextDouble()
  
              System.out.print(str1 +"\n"); // print() - prints text without a newline.
              System.out.println(str2);     // println() - prints text with a newline.
              System.out.printf("%%")       // prints - %
  
              PrintStream out = System.out;
              out.printf("%d", 2486);       // prints in a field width of 4, by default equal to no.of digits in integer
              out.printf("|%7d|", 2486);    // prints in a field width of 7 right justified - |   2486|
              out.printf("|%-7d|", 2486);   // prints in a field width of 7 left justified - |2486   |
              out.printf("%07d", 2486);     // prints in a field width of 7 with leading zeroes - 0002486
              out.printf("%#x", 255);       // converts to alternate form
              out.printf("%f", 98.724);     // prints the real value in a field width of 9 with 6 digits of precision and tailing zeroes
              out.printf("%11.2f", 98.724); // prints in a field width of 11 with 2 digits of precision with right justified
              out.printf("%-11.2f", 98.724);// prints in a field width of 11 with 2 digits of precision with left justified
              out.printf("|%.2f|", 98.724); // |98.72|
              out.printf("%.0f", 98.724);   // prints the rounded integer of the given float value in a field width of 2 right justified
          }
      }
---

## Operators:
Operators are special symbols that perform operations on variables or values and java doesn't support operator overloading.
- **Arithematic:** +, -, *, /, %
- **Relational/Comparison:** ==, !=, >, <, >=, <=
- **Logical:** &&, ||
- **Assignment:** =, +=, -=, *=, /=, %=
- **Unary:** ++, --, ~, !
- **Bitwise:** &, |, ^, <<, >>, >>>
- **instanceof:** checks whether an object is an instance of a specific class or an interface.

### Precedence and Associativity:
Higher precedence operators are evaluated first. Operators with the same precedence are evaluated based on associativity.

| **Precedence** | **Operator(s)**                    | **Description**                        | **Associativity**  |
|----------------|------------------------------------|----------------------------------------|--------------------|
| 1              | `()`                               | Parentheses (used for grouping)        |   Left-to-right    |
| 2              | `[]`, `.`, `++`, `--`              | Array indexing, method invocation, post|   Left-to-right    |
| 3              | `++`, `--`, `+`, `-`, `~`, `!`     | Pre, unary operators                   |   Right-to-left    |
| 4              | `*`, `/`, `%`                      | Multiplication, division, modulus      |   Left-to-right    |
| 5              | `+`, `-`                           | Addition, subtraction                  |   Left-to-right    |
| 6              | `<<`, `>>`, `>>>`                  | Bitwise shifts                         |   Left-to-right    |
| 7              | `<`, `<=`, `>`, `>=`, `instanceof` | Relational and type comparison         |   Left-to-right    |
| 8              | `==`, `!=`                         | Equality and inequality comparison     |   Left-to-right    |
| 9              | `&`, `^`, `&&`                     | Bitwise, Logical                       |   Left-to-right    | 
| 10             | `? :`                              | Ternary conditional operator           |   Right-to-left    |
| 11             | `=`, `+=`, `-=`, `*=`, `/=`, `%=`  | Assignment operators                   |   Right-to-left    |
| 12             | `,`                                | Comma operator                         |   Left-to-right    |

## Control Structures:
- if, if-else, else-if, switch -> (byte, short, int, char, string, enum), while, do-while, for, for-each, break, continue, return

## Stack vs Heap memory:

| **Aspect**                 | **Stack Memory**                                         | **Heap Memory**                                           |
|----------------------------|----------------------------------------------------------|-----------------------------------------------------------|
| **Memory Allocation**      | Automatically managed by JVM.                            | Dynamically allocated by the JVM using the `new` keyword. |
| **Memory Size**            | Limited, typically small in size.                        | Larger in size compared to stack.                         |
| **Memory Structure**       | Follows Last In, First Out (LIFO) principle.             | Structured as a large pool of memory for objects.         |
| **Storage**                | Stores primitive data types and object references.       | Stores objects and arrays.                                |
| **Life Cycle**             | Memory is automatically freed when the method call ends. | Memory is managed by the garbage collector (GC).          |
| **Access Speed**           | Faster, as it follows a simple memory structure.         | Slower, due to dynamic allocation and garbage collection. |
| **Thread-Specific**        | Yes, each thread has its own stack.                      | Shared among all threads.                                 |
| **Size Limit**             | Typically smaller (limited by JVM settings).             | Can grow dynamically (limited by available system memory).|
| **Garbage Collection**     | Not applicable.                                          | Objects in the heap are subject to garbage collection.    |
| **Data Persistence**       | Data is lost when the method call ends.                  | Data persists as long as the reference is alive.          |
---

# Object-Oriented Programming (OOP): 
It is a programming paradigm that organizes software design around objects, which represent real-world entities or concepts. These objects encapsulate data (attributes or properties) and behavior (methods or functions) to create modular, reusable, and maintainable code.
- **Class:** A blueprint or template for creating objects. It defines the properties and behaviors of objects.
- **Object:** An instance of a class. It is a concrete realization of the class's blueprint.
- **Methods & Functions:** Methods belong to a class or an object and have access to its data members, while functions are standalone. Java does not have standalone functions like some other languages. Every block of reusable code must be defined inside a class, making them methods.
- **Constructor:** It is used to initialize the state of an object when it is created. It has the same name as the class and doesn't have any return type.

### Packages:
A package in Java is a way to group related classes and interfaces together. It provides a namespace to avoid name conflicts and allows for better organization, modularity, and reusability of code.
```java
    package mypackage;
    import package.name.class; // import a single class
    import package.name.*;     // import the whole package & sub-packages not be imported.
```
### Access Modifiers:
Access modifiers in Java are keywords used to define the visibility and accessibility of classes, methods, constructors, and variables. They control how and where these members can be accessed within a program, ensuring better control, security, and encapsulation. For classes - public or default

| **Modifier**    | **Class**  | **Package** | **Subclass** | **World (Other Packages)** |
|-----------------|------------|-------------|--------------|----------------------------|
| **private**     | ✅         | ❌         | ❌           | ❌                        |
| **default**     | ✅         | ✅         | ❌           | ❌                        |
| **protected**   | ✅         | ✅         | ✅           | ❌                        |
| **public**      | ✅         | ✅         | ✅           | ✅                        |

## Encapsulation:
Encapsulation is one of the core principles of object-oriented programming (OOP). It involves bundling the data (variables) and the methods (functions) that operate on that data into a single unit, typically a class, and restricting direct access to some of the object's components to ensure controlled access and protection of data.

## Inheritance:
One of the core concepts of Object-Oriented Programming (OOP) that allows one class to acquire the properties (fields) and behaviors (methods) of another class. It promotes code reuse, modularity, and logical structuring of programs. Java does not support multiple inheritance with classes to avoid ambiguity (but it can be achieved using interfaces) and can't assign an object of parent class to a reference of derived class.

### `this` vs `super`:

| **Feature**                | **`this`**                                      | **`super`**                                     |
|----------------------------|-------------------------------------------------|-------------------------------------------------|
| **Refers to**               | Current instance of the class.                 | Parent class of the current instance.           |
| **Use Case**                | Access fields, methods, or constructors of the current class. | Access fields, methods, or constructors of the parent class. |
| **Constructor Call**        | Calls another constructor of the same class (`this()`). | Calls a constructor of the parent class (`super()`). |
| **Access Modifier Rules**   | No restriction on fields/methods of the current class. | Can only access non-private fields/methods of the parent class. |
| **Can be used in**          | Methods and constructors.                      | Methods (except static methods) and constructors. |
| **Example**                 | `this.variableName`, `this.methodName()`        | `super.variableName`, `super.methodName()`      |
| **Static Context**          | Can be used in both static and instance methods. | Cannot be used in static methods.                |

## Polymorphism:
One of the core principles of Object-Oriented Programming (OOP) that allows an object to take on many forms and enables to write flexible and reusable code.

| **Feature**                  | **Compile-time Polymorphism**                       | **Runtime Polymorphism**                        |
|------------------------------|-----------------------------------------------------|-------------------------------------------------|
| **Also Known As**             | Static Polymorphism                                | Dynamic Polymorphism                            |
| **Achieved By**               | Method Overloading                                 | Method Overriding                               |
| **Binding Type**              | Early Binding (Compile-time)                       | Late Binding (Runtime)                          |
| **Method Resolution**         | Determined at compile time                         | Determined at runtime                           |
| **Example**                   | Method overloading (same method name, different parameters) | Method overriding (same method signature, different implementation) |
| **Flexibility**               | Less flexible, as method is selected at compile time | More flexible, as method is selected at runtime |
| **Performance**               | Slightly better performance due to compile-time resolution | May have slight performance overhead due to runtime resolution |

### Dynamic Method Dispatch:
Dynamic Method Dispatch (also called Late Binding or Run-time Polymorphism) is a mechanism in Java where a method call to an overridden method is resolved at runtime, rather than compile time. This allows Java to decide which method to invoke based on the actual object type that is being referred to, rather than the reference type.

### Covariant Return Type:
A covariant return type allows a subclass method to return a more specific (derived) type than the method in the superclass. This feature enhances flexibility and allows more specific objects to be returned from overridden methods while maintaining the contract of the superclass method. In other words, in Java, the return type of an overridden method in a subclass can be a subclass type of the return type in the parent class.
```java        
    class Animal {
        public Animal getInstance() {
            return new Animal();
        }
    }

    class Dog extends Animal {
        @Override
        public Dog getInstance() {
            return new Dog();  // More specific return type (Dog instead of Animal)
        }
    }

    public class Main {
        public static void main(String[] args) {
            Animal animal = new Animal();
            Dog dog = new Dog();

            Animal animalInstance = animal.getInstance();  // Returns an Animal instance
            Dog dogInstance = dog.getInstance();            // Returns a Dog instance
            System.out.println(animalInstance.getClass());  // class Animal
            System.out.println(dogInstance.getClass());     // class Dog
        }
    }
```
---

## Non-Access Modifiers:
Non-access modifiers are don't control access level, but provides other funtionality.

| Modifier      | Applicable To        | Description                                                                 |
|---------------|----------------------|-----------------------------------------------------------------------------|
| `final`       | Class, Method, Field | Prevents inheritance, method overriding, and reassignment of fields.        |
| `abstract`    | Class, Method        | Declares incomplete classes and methods.                                    |
| `static`      | Field, Method (can't override)        | Belongs to class rather than an instance. Used to refer common property.    |
| `synchronized`| Method               | Restricts method access to one thread at a time.                            |
| `native`      | Method               | Indicates implementation in a non-Java language.                            |
| `strictfp`    | Class, Method        | Ensures consistent floating-point operations across platforms.              |
| `volatile`    | Field                | Ensures visibility of field updates across threads.                         |
| `transient`   | Field                | Prevents the field from being serialized.                                   |

---
## Abstraction:
Abstraction in Java is a core concept in object-oriented programming (OOP) that focuses on hiding implementation details and showing only the essential features of an object. It helps simplify complex systems by breaking them into smaller, more manageable parts.

### `abstract` vs `interface`:

| Feature                        | Abstract Class                                  | Interface                                     |
|--------------------------------|------------------------------------------------|----------------------------------------------|
| **Inheritance**                | A class can extend only one abstract class.    | A class can implement multiple interfaces.   |
| **Methods**                    | Can have both abstract and concrete methods. Supports static methods.  | Only abstract methods (Java 7 and earlier). Supports default and static methods (Java 8+). |
| **Fields**                     | Can include instance variables with any access modifier. | Only `public static final` constants.        |
| **Access Modifiers for Methods**| Can have `public`, `protected`, or `private`.  | All methods are implicitly `public`.         |
| **Constructor**                | Can have constructors to initialize fields.    | Cannot have constructors.                    |
| **Abstract Keyword in Methods**| Abstract methods must be explicitly declared.  | Abstract by default (prior to Java 8).       |
| **Multiple Inheritance**       | Not supported (can extend only one class).     | Supported (via multiple interfaces).         |

---

## Generics:
Introduced in Java 5 to provide type safety and reusability. They allow to write code that can work with any data type while ensuring compile-time type checking.

### Wildcards:
Generics can use wildcards (`?`) to work with unknown types.

- **Unbounded Wildcard (`?`)**: Accepts any type.
  ```java
  void printList(List<?> list) {
      for (Object element : list) {
          System.out.println(element);
      }
  }

- **Upper Bounded Wildcard (`? extends Type`)**: Accepts `Type` or its subclasses.
  ```java
  void processNumbers(List<? extends Number> list) {
      // Can read from the list but can't modify it
  }

- **Lower Bounded Wildcard (`? super Type`)**: Accepts `Type` or its superclasses.
  ```java
  void addNumbers(List<? super Integer> list) {
      list.add(10);
  }
---

## Collections Framework: 
Collections Framework provides a unified architecture for storing and manipulating groups of objects.

- **Collection Interface:**
  - **List**: `ArrayList`, `LinkedList`, `Vector` (thread-safe), `Stack`
  - **Set**: `HashSet` (allow null), `LinkedHashSet` (not allow null. Insertion order), `TreeSet` (not allow null. Sorted order)
  - **Queue**: `PriorityQueue`, `ArrayDeque`
- **Map Interface:**
  - `HashMap` (allow null), `LinkedHashMap` (allow null), `TreeMap` (key can't be null), `Hashtable` (thread-safe, not allow null)
    
- **Iterator:**
  ```java
      Iterator<T> itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
  ```
  
- **StringTokenizer:**
  ```java
      StringTokenizer st = new StringTokenizer("String");
      while(st.hasMoreTokens())
          System.out.println(st.nextToken());
      System.out.println(st.countTokens());
  ```

- **Comparable** and **Comparator:**

  | **Feature**               | **Comparable**                               | **Comparator**                                   |
  |---------------------------|----------------------------------------------|------------------------------------------------|
  | **Package**               | `java.lang`                                 | `java.util`                                    |
  | **Method**                | `compareTo(T o)`                            | `compare(T o1, T o2)`                          |
  | **Sorting Logic**         | Defined in the class itself.                | Defined in separate classes or lambdas.        |
  | **Number of Sort Orders** | Only one (natural ordering).                | Multiple (custom orders).                      |
  | **Modifies Original Class** | Yes (requires class implementation).        | No (works externally).                         |
  | **Usage**                 | Best for single, natural ordering.          | Best for multiple or custom sorting.           |
  
- Example:
```java
import java.util.*;

class Student implements Comparable<Student> {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Comparable: Sort by ID
    public int compareTo(Student other) {
        return this.id - other.id;
    }

    public String toString() {
        return name;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student(3, "Alice"),
            new Student(1, "Bob"),
            new Student(2, "Charlie")
        );

        // Sorting using Comparable (ID)
        Collections.sort(students);
        System.out.println("Sorted by ID (Comparable): " + students);  // Output: [Bob, Charlie, Alice]

        // Sorting using Comparator (Name)
        Collections.sort(students, new Comparator<Student>() { // Annonymous inner class
            public int compare(Student s1, Student s2) {
                return s1.name.compareTo(s2.name);  // Sort by name
            }
        });
        System.out.println("Sorted by Name (Comparator without Lambda): " + students);  // Output: [Alice, Bob, Charlie]

        // Sorting using Comparator (Name) - With Lambda - Annonymous inner class with Single Abstract Method (SAM - Funtional Interface - 1.8)
        students.sort((s1, s2) -> s1.name.compareTo(s2.name));  // Sort by name using Lambda
        System.out.println("Sorted by Name (Comparator with Lambda): " + students);  // Output: [Alice, Bob, Charlie]
    }
}
```
---

## Imperative vs Declarative:

| **Feature**                  | **Imperative/Procedural Programming**                             | **Declarative/Functional Programming**                            |
|------------------------------|-------------------------------------------------------------------|--------------------------------------------------------------------|
| **Focus**                     | Focuses on the *how* (step-by-step instructions).                | Focuses on the *what* (desired result).                           |
| **Control Flow**              | The programmer defines the flow and logic explicitly.            | The framework or system controls the execution flow.              |
| **Code Structure**            | Code is usually more detailed, involving explicit loops, conditions, and assignments. | Code is more concise, expressing the intention rather than the steps. |
| **Use Case**                  | Suitable for tasks requiring detailed control, such as system-level programming. | Suitable for tasks where the goal is to describe the outcome, like querying data, UI construction. |

---
## Stream API:
Introduced in Java 8 as part of the java.util.stream package. It is used to process collections of data in a functional and declarative style (pipeline of functions). It doesn't store data. 

- Declaring Streams: `stream.of(1,2,3)`, `Arrays.stream(arr)`, `list.stream()`
- Intermediate Operations (lazy): they not executed until a terminal operation is invoked.
    - `map()`, `filter()`, `sorted()`, `distinct()`, `limit()`, `skip()`, `flatMap()`, `peek()`
- Terminal Operations: once a terminal operation is invoked, stream can't be reused.
    - `collect(Collectors.toList())`, `forEach()`, `reduce()`, `count()`, `min()`, `max()`, `toArray()`
- Short Circuit Operations: terminates the stream early when a condition is met. Used in searching.
    - `findFirst()`, `findAny()`, `anyMatch()`, `allMatch()`, `noneMatch()`
- Example: [See the code](https://github.com/kvinay7/Practice-Kotlin-Fundamentals/blob/main/Main.java)
  
**Parallel Stream:** to perform operations in parallel on multi-core processors, which can result in performance improvements for large datasets.
  ```java
      List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
      int sum = numbers.parallelStream()
                 .reduce(0, Integer::sum); // Parallel sum
      System.out.println(sum); // Output: 21
  ```

### Optional:
The primary purpose of `Optional` is to represent the possibility of absence of a value, without relying on `null` values.
  ```java
    public final class Optional<T> {
        boolean isPresent();
        T get();
        void ifPresent(Consumer<T>);
        Optional<T> filter(Predicate<T>);
        <U> Optional<U> map(Function<T, U>);
        <U> Optional<U> flatMap(Function<T, Optional<U>>);
        T orElse(T);
        T orElseGet(Supplier<T>);
        <X extends Throwable> T orElseThrow(Supplier<X>) throws X;
    }
  ```
---

## Exception Handling:
- **Errors:** represents irrecoverable conditions such as JVM running out-of-memory, memory leaks, stack-overflow errors, library incompatability, infinite recursion, etc. Errors are usually beyond the control of the programmer, and we should not try to handle errors.
 
- **Exception:** is an unwanted or unexpected event, which occurs during the execution of program, i.e. at run-time, that disrupts the normal flow of the program's instructions. Ex: Invalid user input, device failure, loss of network connection, physical limitations (out of disk memory), code errors, opening an unavailable file.
  
-  **Exception Handling:** It is a mechanism to handle runtime errors such as ClassNotFoundException, IOException, SQLException, etc. If an exception has occured, the method creates an object known as exception object and hand it off to the JVM is called throwing an exception. The uncaught exceptions are automatically caught and handled by the java built-in exception handler.
   -  Checked Exceptions (compile-time exceptions): IOException, SQLException, ClassNotFoundException, FileNotFoundException, DataAccessException, InstantiationException.
   -  Unchecked Exceptions (run-time exceptions): NullPointerException, ArrayIndexOutOfBoundException, IllegalArgumentException, IllegalStateException, NumberFormatException, ArithmeticException.
   -  Ducking exceptions: means allowing the exception to propagate up the call stack without catching it in the current scope. The calling function or the runtime must handle the exception.
- Example:
   ```java
       // Custom Exception
       class CustomException extends Exception {
          public CustomException(String message) {
            super(message);
          }
       }

       class ResourceExample {
         @Override
         protected void finalize() throws Throwable { // finalize() is used for cleanup tasks before an object is destroyed by the garbage collector. However, due to its unpredictable behavior, performance issues, and potential memory leaks, finalize() was deprecated in Java 9 and removed in Java 18.
            System.out.println("Finalize called for cleanup.");
         }
       }

       public class ExceptionDemo {
         public static void main(String[] args) {
           // Try-Catch-Finally
           try {                           // try is used to define a block of code where exceptions may occur.
              validateNumber(-1);          // Throws CustomException
              int result = divide(10, 0);  // Handle the exception here - Ducking Exception
           } catch (CustomException | ArithmeticException e) {   // catch is used to handle the exception thrown by the try block.
              System.out.println("Caught exception: " + e.getMessage());
           } finally {                     // A block that always executes, whether or not an exception occurs, even if a return statement is present in the try or catch block. Used for cleanup activities like closing resources.
              System.out.println("This is the finally block.");
           }

           // Try-With-Resources - Resources are automatically closed at the end of the try block, ensuring proper resource management without explicitly using finally.
           try (java.io.FileReader reader = new java.io.FileReader("example.txt")) {
              System.out.println("File opened successfully.");
           } catch (java.io.IOException e) {
              System.out.println("Error: " + e.printStackTrace());
           }

           // Demonstrate finalize
           ResourceExample resource = new ResourceExample();
           resource = null; // Make object eligible for GC
           System.gc(); // Request Garbage Collection
           System.out.println("End of program.");
         }

          public static void validateNumber(int number) throws CustomException { // declares exceptions that a method can throw. (checked exceptions)
            if (number < 0) {
              throw new CustomException("Number cannot be negative!");  // throw is used to explicitly throw an exception.
            }
          }
   
          // Ducking the exception (no handling here)
          public static int divide(int a, int b) throws ArithmeticException {
            return a / b; // ArithmeticException will propagate
          }
      }
   ```
---

## File I/O:

## Multithreading:
Multithreading in Java is a programming technique that allows multiple threads to run concurrently, sharing the same process. This is particularly useful for performing tasks simultaneously, such as executing background tasks, responding to user input, or improving the performance of computationally intensive programs.

- **Process:** A process is a complete execution of a task which has its privite memory space and resources. A process can have multiple threads.
- **Concurrency:** Concurrency in programming refers to the ability of a system to handle multiple tasks or processes at the same time.
- **Thread:** A thread is a part of the process which has its run-time stack and shares the process resources. Every thread in Java is created and controlled by a unique object of the java.lang.Thread class. When a standalone application is run, a user thread is automatically created to execute the main() method. This thread is called the main thread.
- Thread creation with `Runnable` Interface:
  ```java
      public class RunnableThreadExample {
        public static void main(String[] args) {
            final int[] count = {0};  // Use an array to allow updates within lambda (due to final requirement)

            // Lambda expression to define the Runnable
            Runnable task = () -> {
                System.out.println("RunnableThread starting.");
                try {
                    while (count[0] < 5) {
                        Thread.sleep(500);
                        count[0]++;
                    }
                } catch (InterruptedException exc) {
                    System.out.println("RunnableThread interrupted.");
                }
                System.out.println("RunnableThread terminating.");
            };
  
            // Create and start the thread using lambda directly in Thread constructor
            Thread thread = new Thread(task);

            // Start the thread
            thread.start();

            // Main thread waits until count reaches 5
            while (count[0] != 5) {
                try {
                    Thread.sleep(250);
                } catch (InterruptedException exc) {
                    exc.printStackTrace();
                }
            }
        }
    }
  ```
---

## Java Interview Questions: [See here](https://www.interviewbit.com/java-interview-questions/)
