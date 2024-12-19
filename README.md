# Java

Java is a general-purpose, class-based, object-oriented, high-level programming language developed by James Gosling and his team at Sun Microsystems in the mid-1990's. The main goal of creating Java was to achieve platform-independent, simple, and secure features.
### Features
- ***Simplicity:*** Java's syntax is designed to be easy to learn, write and maintain code.
- ***Platform Independent:*** Java code is compiled into bytecode (platform-independent code), which runs on the JVM. This abstraction allows the same bytecode to execute on any platform that has a compatible JVM, achieving true platform independence.
- ***Portability:*** "Write Once, Run Anywhere" (WORA) emphasizes its design for cross-platform compatability and architecture-neutral.
- ***Security:*** Java provides robust security features like bytecode verification, a security manager, and sandboxing to protect against security threats.
- ***High Performance:*** Java uses Just-In-Time (JIT) compilation to optimize performance by compiling bytecode to machine code at runtime.
- ***Dynamic Linking:*** Classes are linked at runtime rather than at compile time. This allows Java programs to load classes dynamically, ensuring better flexibility and scalability.
- ***Robustness:*** Java's strong memory management, type checking, and exception handling make it a reliable language for building robust applications.

### Terminologies
- ***JDK:*** Java Development Kit is need to compile java source code into bytecode and contains JRE & develop, debug, deploy tools.
- ***JRE:*** Java Runtime Environment is need to run a java program and contains JVM & libraries.
- ***JVM:*** Java Virtual Machine interprets the java bytecode to machine code and contains class loader (dynamic linking), bytecode verifier, JIT compiler.
- ***IDE:*** Integrated Development Environment makes writing code, compiling, executing, debbuging and test Easy!.

### Identifier
An identifier is the name used to identify a variable & method (CamelCase), class & interface (PascalCase), constants (UPPER_CASE, UC) or any other user-defined item in the program.
- The first character must be a letter (A-Z or a-z), a dollar sign $, or an underscore _. It cannot be a digit (0-9).
- Identifiers are case-sensitive and cannot be the keywords or literals.

### Variables and Data Types
A variable is a container for storing data values and Data types define the type of data that can be stored in a variable.

- **Reference Data Types:** refer to objects and arrays and can be null

- **Primitive Data Types**
Java isn't considered a pure oop language mainly because it has primitive types which represent single value and can't be null.
1. ***boolean:*** default - false
2. ***char:*** default - '\u0000' (%c), size - 2 bytes and range is 0-65,535
3. ***byte:*** default - 0 and size - 8 bits
4. ***short:*** default - 0 and size - 2 bytes
5. ***int:*** default - 0 (%d) and size - 4 bytes
6. ***long:*** default - 0L and size - 8 bytes
7. ***float:*** default - 0.0f (%f) and size - 4 bytes
8. ***double:*** default - 0.0d (%lf) and size - 8 bytes

In memory, char are stored as ASCII values, 48-57 -> '0'-'9', 65-90 -> 'A'-'Z', 97-122 -> 'a'-'z'. 
Range for signed types: -(2^(n-1)) to (2^(n-1))-1, n is no.of bits.

**Type Casting**
- ***Implicit/Widening:*** automatically converts smaller data type to larger.
- ***Explicit/Narrowing:*** converting from a larger data type to a smaller.
- ***Manual boxing:*** wType.valueOf(primitive) - smallerOrSamePrimitive to largerOrSameWrapper, largerPrimitive to smallerWrapper's primitive to smallerWrapper
- ***Manual unboxing:*** wVar.typeValue() - Wrapper to Primitive, Wrapper to Wrapper
