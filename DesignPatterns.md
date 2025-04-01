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

2. **Bill Pugh Singleton Design:** The instance is created only when the getInstance() method is called, and it takes advantage of Java's class-loading mechanism to ensure thread safety.

```java
    public class Singleton {
        // Static inner class - the Singleton instance is created only when the class is referenced
        private static class SingletonHelper {
            private static final Singleton INSTANCE = new Singleton();
        }

        private Singleton() {}

        public static Singleton getInstance() {
            return SingletonHelper.INSTANCE;
        }
    }
```

