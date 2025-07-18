# [Object-Oriented Programming in Java](https://www.youtube.com/playlist?list=PLsyeobzWxl7pe_IiTfNyr55kwJPWbgxB5)

- [Introduction](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#introduction)
    - [Features](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#features)
    - [Terminologies](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#terminologies)
    - [Console](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#console)
- [Basics](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#basics)
    - [Identifiers](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#identifier)
    - [Variables and Data Types](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#variables-and-data-types)
    - [Standard I/O](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#standard-io)
        - [Logging](https://www.digitalocean.com/community/tutorials/logger-in-java-logging-example)  
    - [Operators](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#operators)
        - [Precedence and Associativity](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#precedence-and-associativity)
    - [Control Statements](https://www.javatpoint.com/control-flow-in-java)
    - [Coding Practice](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#coding-practice)
    - [Data Structures and Algorithms](https://github.com/kvinay7/interview-preparation/blob/main/DSA.md)
- [OOP](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#object-oriented-programming-oop)
    - [Stack vs Heap memory](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#stack-vs-heap-memory)
    - [Packages](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#packages)
    - [Access Modifiers](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#access-modifiers)
    - [Encapsulation](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#encapsulation)
    - [Inheritance](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#inheritance)
        - [`this` vs `super`](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#this-vs-super)
    - [Polymorphism](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#polymorphism)
        - [Dynamic Method Dispatch](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#dynamic-method-dispatch)
        - [Covariant Return Type](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#covariant-return-type)
    - [Non-Access Modifiers](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#non-access-modifiers)
    - [Abstraction](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#abstraction)
        - [`abstract` vs `interface`](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#abstract-vs-interface)
    - [OOP Practice](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#oop-practice)
    - [Enums](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#enums)
    - [Generics](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#generics)
- [Collections](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#collections-framework)
- [File Handling](https://www.geeksforgeeks.org/file-handling-in-java/?ref=lbp)
- [Java-8](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#imperative-vs-declarative)
    - [Stream API](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#stream-api)
    - [Optional](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#optional)
- [Exception Handling](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#exception-handling)
- [Multithreading (OS)](https://github.com/kvinay7/interview-preparation/blob/main/OS.md)
- [Design Practice](https://algomaster.io/learn/lld) ([e.g.](https://github.com/kvinay7/Insurance/blob/main/README.md))
- [Interview Questions](https://www.interviewbit.com/java-interview-questions/)
- [Spring Framework](https://github.com/kvinay7/interview-preparation/blob/main/Spring.md)

## Introduction:
Java is a general-purpose, class-based, object-oriented, high-level programming language developed by James Gosling and his team at Sun Microsystems (acquired by Oracle in 2010) in the mid-1990's. The main goal of creating Java was to achieve platform-independent, simple, and secure features.

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
- **JVM:** Java Virtual Machine interprets the java bytecode to machine code and contains class loader (dynamic linking), bytecode verifier, JIT compiler.
- **IDE:** Integrated Development Environment makes writing code, compiling, executing, debbuging and test Easy!.

### Console:
- **Compile:** C:\\> javac Hello.java
- **Run:** C:\\> java Hello

## Basics:
- A set of instructions is known as a program and the act of creating a program is known as programming.
- **Tokens** are the smallest elements of a program that have meaning and are used to form the syntax of the language. Java programs are parsed and analyzed by the compiler in terms of tokens. Examples: Keywords, Identifiers, Literals, Operators and Special Characters.

### Identifier:
An identifier is the name used to identify a variable & method (CamelCase), class & interface (PascalCase), constants (UPPER_CASE, UC) or any other user-defined item in the program.
- The first character must be a letter (A-Z or a-z), a dollar sign $, or an underscore _. It cannot be a digit (0-9).
- Identifiers are case-sensitive and cannot be the keywords(50) or literals.

## Variables and Data Types:
A variable is a container for storing data values and Data types define the type of data that can be stored in a variable.
- **Reference Data Types:** refer to objects, [arrays](https://github.com/kvinay7/interview-preparation/blob/main/DSA.md#arrays), [strings](https://github.com/kvinay7/interview-preparation/blob/main/DSA.md#strings), enum and can be null.
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
      /**
      * This is a Javadoc comment.
      * It describes a class, method, or interface.
     */
  
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

---

## Coding Practice:
- Swap two numbers with and without using third variable.
- Find min and max of three numbers. (Math Class usage)
- Calculator program with all operators.
- Find factorial of a number and check given number is factorial or not.
- Find sum of digits of a number. (Reverse number)
- Fibonacci series upto N terms.
- Given number is prime or not
- Find LCM and GCD (HCF) of two numbers.
---

# Object-Oriented Programming (OOP): 
It is a programming paradigm that organizes software design around objects, which represent real-world entities or concepts. These objects encapsulate data (attributes or properties) and behavior (methods or functions) to create efficient, modular, reusable, and maintainable code.
- **[Class](https://github.com/ashishps1/awesome-low-level-design/tree/main/oop/java/classesandobjects):** A blueprint or template for creating objects. It defines the properties and behaviors of objects.
- **Object:** An instance of a class. It is a concrete realization of the class's blueprint.
- **Methods & Functions:** Methods belong to a class or an object and have access to its data members, while functions are standalone. Java does not have standalone functions like some other languages. Every block of reusable code must be defined inside a class, making them methods.
- **Constructor:** It is used to initialize the state of an object when it is created. It has the same name as the class and doesn't have any return type but can use 'return' for exiting from the constructor.

### Stack vs Heap memory:

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

## [Encapsulation](https://github.com/ashishps1/awesome-low-level-design/tree/main/oop/java/encapsulation):
Encapsulation is one of the core principles of object-oriented programming (OOP). It involves bundling the data (variables) and the methods (functions) that operate on that data into a single unit, typically a class, and restricting direct access to some of the object's components to ensure controlled access and protection of data.

## [Inheritance](https://github.com/ashishps1/awesome-low-level-design/tree/main/oop/java/inheritance):
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
| **Static Context**          | Cannot be used in static methods. | Cannot be used in static methods.                |

## [Polymorphism](https://github.com/ashishps1/awesome-low-level-design/tree/main/oop/java/polymorphism):
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

| Feature                        | Abstract Class                                  | [Interface](https://github.com/ashishps1/awesome-low-level-design/tree/main/oop/java/interfaces)                                     |
|--------------------------------|------------------------------------------------|----------------------------------------------|
| **Inheritance**                | A class can extend only one abstract class.    | A class can implement multiple interfaces.   |
| **Methods**                    | Can have both abstract and concrete methods. Supports static methods.  | Only abstract methods (Java 7 and earlier). Supports default and static methods (Java 8+). |
| **Fields**                     | Can include instance variables with any access modifier. | Only `public static final` constants.        |
| **Access Modifiers for Methods**| Can have `public`, `protected`, or `private`.  | All methods are implicitly `public`.         |
| **Constructor**                | Can have constructors to initialize fields but it cannot be instantiated directly. The subclass can call the abstract class constructor using super().    | Cannot have constructors.                    |
| **Abstract Keyword in Methods**| Abstract methods must be explicitly declared.  | Abstract by default (prior to Java 8).       |
| **Multiple Inheritance**       | Not supported (can extend only one class).     | Supported (via multiple interfaces).         |

---

<details>
    <summary><h2>OOP Practice</h2></summary>

### **Beginner Level**

1. **Class and Object Basics**

   * Create a `Book` class with attributes like title, author, and price.
   * Create multiple objects and display their details.

2. **Constructor Overloading**

   * Create a `Rectangle` class with overloaded constructors for different input cases (e.g., square, rectangle).

3. **Encapsulation**

   * Create a `Student` class with private fields and public getters/setters.
   * Implement validation in setters (e.g., age must be > 0).

4. **Simple Aggregation**

   * Create a `Library` class that contains an array/list of `Book` objects.
   * Provide methods to add and display books.

---

### **Intermediate Level**

5. **Inheritance**

   * Create a `Person` superclass with `Employee` and `Manager` subclasses.
   * Override a `getDetails()` method in each class.

6. **Polymorphism**

   * Implement a `Shape` superclass with `Rectangle`, `Circle`, and `Triangle` subclasses.
   * Create a method to calculate and display area using overridden methods.

7. **Abstraction**

   * Use an abstract class `Vehicle` with subclasses like `Car` and `Bike`.
   * Include abstract and concrete methods.

8. **Interface Implementation**

   * Define a `Playable` interface with a method `play()`.
   * Implement it in classes like `Guitar`, `Piano`, and `Drum`.

9. **Composition**

   * Model a `Computer` class composed of `CPU`, `RAM`, and `HardDrive` classes.

---

### **Advanced Level**

10. **Banking System Simulation**

    * Classes: `Bank`, `Account`, `Customer`
    * Implement deposit, withdrawal, and transfer methods.
    * Use exception handling for invalid operations.

11. **Online Shopping Cart**

    * Classes: `Product`, `Cart`, `User`, `Order`
    * Handle adding/removing items and order checkout with discounts.

12. **Hotel Reservation System**

    * Classes: `Room`, `Guest`, `Booking`, `Hotel`
    * Include functionality to check room availability and make a booking.

13. **File I/O with OOP**

    * Extend any problem (like `Library` or `Banking`) to save/load data using file input/output.

14. **Design a Mini ATM**

    * Classes: `ATM`, `UserAccount`, `Transaction`
    * Implement a text-based UI and handle user authentication, balance check, etc.

</details>

## Enums:
Enums in Java offer a powerful way to define a set of constants, allowing for more readable, type-safe, and organized code. They can include fields, constructors, and methods, making them much more flexible than simple constant values.

- **Defining an Enum**:
    ```java
        // Enum to represent days of the week
        enum Day {
            MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
        }
    ```

- **Using Enums**:
    ```java
        public class EnumExample {
            public static void main(String[] args) {
                Day today = Day.MONDAY;
        
                switch (today) {
                    case MONDAY:
                        System.out.println("Start of the work week!");
                        break;
                    case FRIDAY:
                        System.out.println("End of the work week!");
                        break;
                    case SATURDAY:
                    case SUNDAY:
                        System.out.println("Weekend!");
                        break;
                    default:
                        System.out.println("Midweek!");
                }
            }
        }
    ```

- **Enum with Fields and Methods**:
    ```java
        enum Day {
            MONDAY("Start of the work week"), 
            FRIDAY("End of the work week"),
            SATURDAY("Weekend fun"),
            SUNDAY("Relax and prepare for next week");

            private String description;

            // Constructor to initialize the field
            Day(String description) {
                this.description = description;
            }

            // Method to get the description
            public String getDescription() {
                return description;
            }
        }

        public class EnumWithFields {
            public static void main(String[] args) {
                for (Day day : Day.values()) {
                    System.out.println(day + ": " + day.getDescription());
                }
            }
        }
    ```

- **Enum Methods**:
    - `values()` – Returns an array of all enum constants.
    - `valueOf(String name)` – Returns the enum constant with the specified name.
    - `ordinal()` – Returns the position of the enum constant in its enum declaration (zero-based index).

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
  - **List**: `ArrayList`, `LinkedList` is doubly linked list, `Vector` (thread-safe), `Stack`
  - **Set**:
    | Set Type         | Allows Null Element? | Maintains Order         | Sorted?        | Thread-Safe |
    |------------------|----------------------|--------------------------|----------------|-------------|
    | HashSet          | Yes (only one null)  | No                       | No             | No          |
    | LinkedHashSet    | Yes (only one null)\*| Yes (insertion order)    | No             | No          |
    | TreeSet          | No                   | No                       | Yes (sorted)   | No          |

  - **Queue**: `PriorityQueue`, `ArrayDeque` - Use Deque for efficient stack and queue operations (ArrayDeque is faster than Stack and LinkedList)

- **Map Interface:**
  | Map Type           | Allows Null Key?     | Allows Null Value(s)? | Maintains Order         | Sorted?           | Thread-Safe |
  |--------------------|----------------------|------------------------|--------------------------|--------------------|--------------|
  | HashMap            | Yes (only one key)   | Yes                    | No                       | No                 | No           |
  | LinkedHashMap      | Yes (only one key)   | Yes                    | Yes (insertion order)    | No                 | No           |
  | TreeMap            | No                   | Yes                    | No                       | Yes (sorted by key)| No           |
  | Hashtable          | No                   | No                     | No                       | No                 | Yes          |

    
- **Iterator:**
    - Different collections have different internal structures, Iterator gives a common interface to loop through them.
    - Removing items while looping with a for or foreach loop can cause errors. `Iterator.remove()` is designed to safely remove elements during iteration.

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
  ```java
  Arrays.sort(arr, Collections.reverseOrder());
  Collections.sort(list, Collections.reverseOrder());
  ```

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
        Collections.sort(students, new Comparator<Student>() { // Annonymous inner class is a local class without a name. It's used to define a one-time-use subclass or implementation of an interface or abstract class—all in one expression.
            public int compare(Student s1, Student s2) {
                return s1.name.compareTo(s2.name);  // Sort by name
            }
        });
        System.out.println("Sorted by Name (Comparator without Lambda): " + students);  // Output: [Alice, Bob, Charlie]

        // Sorting using Comparator (Name) - With Lambda (A concise way to represent an implementation of a functional interface) - Annonymous inner class with Single Abstract Method (SAM - Funtional Interface - 1.8)
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
| **Use Case**                  | Suitable for tasks requiring detailed control, such as system-level programming. Performance-critical.| Suitable for tasks where the goal is to describe the outcome, like querying data, UI construction. When readability and maintainability matter more than micro-performance. |

- **Functional Programming**: It emphasizes immutability, pure functions, and declarative code over imperative, state-changing operations. Java supports functional programming from Java-8 with key features: Functional Interfaces, Lamda Expressions, Method References, Streams, Optional.
    - **Pure Functions**: It always produces the same output for the same input. It does not modify any external state.
    - **Impure Functions**: An impure function is a function that has side effects, depends on external state or may produce different results for the same input.
    - **First-class functions**: Functions can be assigned to variables, passed as arguments, or returned.
    - **Higher-order functions**: Functions that take other functions as parameters or return functions.
---
## Stream API:
Introduced in Java 8 as part of the `java.util.stream` package. It is used to process collections of data in a functional and declarative style (pipeline of functions). It doesn't store data. 

- [Primitive Streams](https://www.baeldung.com/java-8-primitive-streams)

- Declaring Streams:
    - `Stream<T> Arrays.stream(T[])`
    - `Stream<T> Collection.stream()`
    - `Stream<T> Stream.of(T...)`
    - `Stream<T> Stream.empty()`
    - `Stream<T> Stream.generate(Supplier<T>)`
    - `Stream<T> Stream.iterate(T seed, UnaryOperator<T>)`
    - `Stream.Builder<T> Stream.builder()`

- Intermediate Operations (lazy): they not executed until a terminal operation is invoked.
    - `Stream<R> map(Function<T, R>)`
    - `Stream<T> filter(Predicate<T>)`
    - `Stream<T> sorted()`
    - `Stream<T> sorted(Comparator<T>)`
    - `Stream<T> distinct()`
    - `Stream<T> limit(long maxSize)`
    - `Stream<T> skip(long n)`
    - `Stream<R> flatMap(Function<T, Stream<R>>)`
    - `Stream<T> peek(Consumer<T>)`
    
- Terminal Operations: once a terminal operation is invoked, stream can't be reused.
    - `T collect(`[Collectors](https://www.baeldung.com/java-collectors)`)`
    - `void forEach(Consumer<T>)`
    - `Optional<T> reduce(BinaryOperator<T>)`
    - `long count()`
    - `Optional<T> min(Comparator)`
    - `Optional<T> max(Comparator)`
    - `T[] toArray()`

- Short Circuit Operations: terminates the stream early when a condition is met. Used in searching.
    - `Optional<T> findFirst()`
    - `Optional<T> findAny()`
    - `boolean anyMatch(Predicate<T>)`
    - `boolean allMatch(Predicate<T>)`
    - `boolean noneMatch(Predicate<T>)`

- Practice: [See here](https://github.com/kvinay7/Practice-Kotlin-Fundamentals/blob/main/streams.md)
- Example: [See here](https://docs.google.com/document/d/e/2PACX-1vQDAFhUiB2iRfZppq4tFrJKnX8yVGsHBAPrSMmXLlj4CxcU2yi47QqBtAo4n-C4awhj2MNwt14XjOLP/pub)
  
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
