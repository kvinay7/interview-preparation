# Design Patterns

## 1. Creational Design Patterns

### 1. Singleton Design Pattern
It ensures a class has only one instance and provides a global point of access to that instance.

1. **Eager Initialization Singleton:** The instance is created when the class is loaded. It is thread-safe by default because the instance is created before any threads can access it.

```java
    public class Singleton {
        // The instance is created at class loading time
        private static final Singleton instance = new Singleton();

        // Private constructor to prevent instantiation from outside the class
        private Singleton() {}

        // Public method to provide access to the instance
        public static Singleton getInstance() {
            return instance;
        }
    }
```
