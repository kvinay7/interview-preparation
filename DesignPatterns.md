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

### 2. Builder Design Pattern 
It is used to construct an object by specifying its type and content, allows to create a complex object with many optional components in a readable and flexible way.

```java
    public class Computer {
        private String CPU;
        private String RAM;
        private String storage;
        private String graphicsCard;
    
        // Private constructor to force the use of the builder
        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.storage = builder.storage;
            this.graphicsCard = builder.graphicsCard;
        }

        @Override
        public String toString() {
            return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + storage + ", GraphicsCard=" + graphicsCard + "]";
        }

        // Static Builder class to construct a Computer
        public static class Builder {
            private String CPU;
            private String RAM;
            private String storage;
            private String graphicsCard;

            // Setters for each component, which return the builder object itself for chaining
            public Builder setCPU(String CPU) {
                this.CPU = CPU;
                return this;
            }

            public Builder setRAM(String RAM) {
                this.RAM = RAM;
                return this;
            }

            public Builder setStorage(String storage) {
                this.storage = storage;
                return this;
            }

            public Builder setGraphicsCard(String graphicsCard) {
                this.graphicsCard = graphicsCard;
                return this;
            }

            // Build method to create the final Computer object
            public Computer build() {
                return new Computer(this);
            }
        }
    }
```
```java
    public class Main {
        public static void main(String[] args) {
            // Using the builder pattern to create a complex Computer object
            Computer computer = new Computer.Builder()
                    .setCPU("Intel i7")
                    .setRAM("16GB")
                    .setStorage("1TB SSD")
                    .setGraphicsCard("NVIDIA GTX 1650")
                    .build();

            System.out.println(computer);
        }
    }
```

