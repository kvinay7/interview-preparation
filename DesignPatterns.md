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
---

### 2. Builder Design Pattern 
It is used to construct an object by specifying its type and content, allows to create a complex object with many optional components in a readable and flexible way.

- Example: 
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
- Using the Builder:
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
---

### 3. Prototype Design Pattern
It allows cloning of existing objects to create new instances instead of constructing new ones from scratch.

- Example:

```java
    class Address {
        private String street;
        private String city;

        public Address(String street, String city) {
            this.street = street;
            this.city = city;
        }

        // Copy constructor for deep cloning
        public Address(Address other) {
            this(other.street, other.city);
        }

        public String getStreet() {
            return street;
        }

        public String getCity() {
            return city;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public void setCity(String city) {
            this.city = city;
        }

        @Override
        public String toString() {
            return street + ", " + city;
        }
    }

    // Shallow Copy Person class (references shared)
    class ShallowCopyPerson implements Cloneable {
        private String name;
        private Address address;

        public ShallowCopyPerson(String name, Address address) {
            this.name = name;
            this.address = address;
        }

        // Shallow clone method (clones only the reference of Address)
        @Override
        public ShallowCopyPerson clone() {
            try {
                return (ShallowCopyPerson) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        }

        public String getName() {
            return name;
        }

        public Address getAddress() {
            return address;
        }

        @Override
        public String toString() {
            return name + " lives at " + address;
        }
    }

    // Deep Copy Person class (independent Address objects)
    class DeepCopyPerson implements Cloneable {
        private String name;
        private Address address;

        public DeepCopyPerson(String name, Address address) {
            this.name = name;
            this.address = address;
        }

        // Deep clone method (clones a new Address object)
        @Override
        public DeepCopyPerson clone() {
            try {
                // Perform shallow clone first (to clone the fields)
                DeepCopyPerson cloned = (DeepCopyPerson) super.clone();
                // Deep clone the Address object to ensure the cloned object has its own address
                cloned.address = new Address(this.address);
                return cloned;
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        }

        public String getName() {
            return name;
        }

        public Address getAddress() {
            return address;
        }

        @Override
        public String toString() {
            return name + " lives at " + address;
        }
    }

    // Testing the Shallow and Deep Copy functionality
    public class PrototypePatternTest {
        public static void main(String[] args) {
            // Create an original address and person for both shallow and deep copies
            Address address1 = new Address("123 Main St", "New York");
        
            // Shallow Copy Test
            ShallowCopyPerson person1 = new ShallowCopyPerson("Alice", address1);
        
            // Create a shallow copy
            ShallowCopyPerson person2 = (ShallowCopyPerson) person1.clone();
        
            // Modify the address in person2
            person2.getAddress().setStreet("456 Another St");
        
            // Shallow copy: Changing address of person2 will affect person1 because they share the same address object
            System.out.println("Shallow Copy:");
            System.out.println("Original: " + person1);
            System.out.println("Cloned: " + person2);
        
            // Deep Copy Test
            Address address2 = new Address("789 Elm St", "Los Angeles");
        
            // Create a deep copy
            DeepCopyPerson person3 = new DeepCopyPerson("Bob", address2);
        
            // Create a deep copy
            DeepCopyPerson person4 = (DeepCopyPerson) person3.clone();
        
            // Modify the address in person4
            person4.getAddress().setStreet("101 Oak Ave");
        
            // Deep copy: Changing address of person4 will NOT affect person3 because they have different Address objects
            System.out.println("\nDeep Copy:");
            System.out.println("Original: " + person3);
            System.out.println("Cloned: " + person4);
        }
    }
```
---

## 2. Behavioral Design Pattern

### 1. Strategy Design Pattern (with Factory)
Strategy Design Pattern enables selecting an algorithm or behavior at runtime. In the Factory Design Pattern, instead of calling a constructor directly to create an object, we use a factory method to handle object creation. 

#### Step 1: Define the Strategy Interface

```java
    public interface SortStrategy {
        void sort(int[] numbers);
    }
```

#### Step 2: Create Concrete Strategy Classes

```java
    public class BubbleSort implements SortStrategy {
        @Override
        public void sort(int[] numbers) {
            System.out.println("Sorting using Bubble Sort");
        }
    }

    public class QuickSort implements SortStrategy {
        @Override
        public void sort(int[] numbers) {
            System.out.println("Sorting using Quick Sort");
        }
    }
```

#### Step 3: Factory for Strategy Instantiation

```java
    public class SortingStrategyFactory {

        // Map to hold the strategy names and their corresponding strategy objects
        private static final Map<String, SortStrategy> strategies = new HashMap<>();

        static {
            strategies.put("BubbleSort", new BubbleSort());
            strategies.put("QuickSort", new QuickSort());
            // New strategies can be added here, without modifying existing code.
        }

        public static SortStrategy getSortStrategy(String strategyType) {
            SortStrategy strategy = strategies.get(strategyType);
            if (strategy == null) {
                throw new IllegalArgumentException("Unknown sorting strategy");
            }
            return strategy;
        }
    }
```

#### Step 4: Context Class (NumberSorter)

```java
    public class NumberSorter {
        private SortStrategy sortStrategy;

        public NumberSorter(SortStrategy sortStrategy) {
            this.sortStrategy = sortStrategy;
        }

        public void sortNumbers(int[] numbers) {
            sortStrategy.sort(numbers);
        }

        public void setSortStrategy(SortStrategy sortStrategy) {
            this.sortStrategy = sortStrategy;
        }
    }
```

### Step 5: Client Code

```java
    public class StrategyPatternWithFactoryExample {
        public static void main(String[] args) {
            int[] numbers = {5, 2, 9, 1, 5, 6};

            // Get a sorting strategy from the Factory
            SortStrategy bubbleSort = SortingStrategyFactory.getSortStrategy("BubbleSort");
            NumberSorter sorter = new NumberSorter(bubbleSort);
            sorter.sortNumbers(numbers);  // Output: Sorting using Bubble Sort

            // Switch strategy at runtime
            SortStrategy quickSort = SortingStrategyFactory.getSortStrategy("QuickSort");
            sorter.setSortStrategy(quickSort);
            sorter.sortNumbers(numbers);  // Output: Sorting using Quick Sort
        }
    }
```
---

### 2. Observer Design Pattern:
It's commonly used in scenarios where an object (the "subject") needs to notify other objects (observers) of changes without knowing who or what those objects are.

#### 1. Define the Observer Interface

```java
    public interface Observer {
        void update(float temperature, float humidity);
    }
```

#### 2. Define the Subject Interface

```java
    public interface Subject {
        void registerObserver(Observer observer);
        void removeObserver(Observer observer);
        void notifyObservers();
    }
```

#### 3. Concrete Subject (WeatherStation)

```java
    public class WeatherStation implements Subject {
        private List<Observer> observers;
        private float temperature;
        private float humidity;

        public WeatherStation() {
            observers = new ArrayList<>();
        }

        @Override
        public void registerObserver(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void removeObserver(Observer observer) {
            observers.remove(observer);
        }

        @Override
        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(temperature, humidity);
            }
        }

        // Method to set new weather data
        public void setWeatherData(float temperature, float humidity) {
            this.temperature = temperature;
            this.humidity = humidity;
            notifyObservers(); // Notify all observers about the change
        }
    }
```

#### 4. Concrete Observers (TemperatureDisplay and HumidityDisplay)

```java
    public class TemperatureDisplay implements Observer {
        @Override
        public void update(float temperature, float humidity) {
            System.out.println("Temperature updated: " + temperature + "°C");
        }
    }

    public class HumidityDisplay implements Observer {
        @Override
        public void update(float temperature, float humidity) {
            System.out.println("Humidity updated: " + humidity + "%");
        }
    }
```

#### 5. Main Class (Client Code)

```java
    public class Main {
        public static void main(String[] args) {
            // Create the weather station (subject)
            WeatherStation weatherStation = new WeatherStation();

            // Create observers
            Observer temperatureDisplay = new TemperatureDisplay();
            Observer humidityDisplay = new HumidityDisplay();

            // Register observers with the weather station
            weatherStation.registerObserver(temperatureDisplay);
            weatherStation.registerObserver(humidityDisplay);

            // Update weather data and notify observers
            weatherStation.setWeatherData(25.5f, 60.0f); // Notify all observers
            weatherStation.setWeatherData(30.0f, 70.0f); // Notify all observers
        }
    }
```
---

### 3. Command Design Pattern
It is used to encapsulate a request as an object, thereby allowing us to parameterize clients with queues, requests, and operations. It decouples the sender of a request from its receiver (actual object that knows how to perform the operation).

#### 🔧 Use Case
The Command pattern is useful when:
- We want to queue operations.
- We need to support undo/redo functionality.
- We want to log changes or operations.
- We want to decouple the class that invokes the operation from the one that knows how to perform it.

---

#### 1. Command Interface
```java
    public interface Command {
        void execute();
    }
```

#### 2. Receiver
```java
    public class Light {
        public void turnOn() {
            System.out.println("Light is ON");
        }

        public void turnOff() {
            System.out.println("Light is OFF");
        }
    }
```

#### 3. Concrete Commands
```java
    public class LightOnCommand implements Command {
        private Light light;

        public LightOnCommand(Light light) {
            this.light = light;
        }

        public void execute() {
            light.turnOn();
        }
    }

    public class LightOffCommand implements Command {
        private Light light;

        public LightOffCommand(Light light) {
            this.light = light;
        }

        public void execute() {
            light.turnOff();
        }
    }
```

#### 4. Invoker
```java
    public class RemoteControl {
        private Command command;

        public void setCommand(Command command) {
            this.command = command;
        }

        public void pressButton() {
            command.execute();
        }
    }
```

#### 5. Client
```java
    public class CommandPatternDemo {
        public static void main(String[] args) {
            Light light = new Light();
            Command lightOn = new LightOnCommand(light);
            Command lightOff = new LightOffCommand(light);

            RemoteControl remote = new RemoteControl();

            remote.setCommand(lightOn);
            remote.pressButton(); // Output: Light is ON

            remote.setCommand(lightOff);
            remote.pressButton(); // Output: Light is OFF
        }
    }
```
---

### Mediator Design Pattern
It promotes **loose coupling** by preventing objects from referring to each other explicitly. Instead, they communicate through a **mediator** object.

#### ✅ When to Use
- Have a set of objects that communicate in complex ways.
- Want to centralize communication logic.
- Reducing dependencies between communicating components is important.

#### 1. Mediator Interface
```java
    public interface ChatMediator {
        void showMessage(User user, String message);
    }
```

#### 2. Concrete Mediator
```java
    public class ChatRoom implements ChatMediator {
        private List<User> users = new ArrayList<>();

        public void addUser(User user) {
            users.add(user);
        }

        public void showMessage(User sender, String message) {
            for (User user : users) {
                // message should not be received by the user sending it
                if (user != sender) {
                    user.receive(message, sender.getName());
                }
            }
        }
    }
```

#### 3. Colleague
```java
    public class User {
        private String name;
        private ChatMediator mediator;

        public User(String name, ChatMediator mediator) {
            this.name = name;
            this.mediator = mediator;
        }

        public String getName() {
            return name;
        }

        public void send(String message) {
            System.out.println(this.name + " sends: " + message);
            mediator.showMessage(this, message);
        }

        public void receive(String message, String senderName) {
            System.out.println(this.name + " receives from " + senderName + ": " + message);
        }
    }
```

#### 4. Client
```java
    public class MediatorPatternDemo {
        public static void main(String[] args) {
            ChatRoom chatRoom = new ChatRoom();

            User john = new User("John", chatRoom);
            User jane = new User("Jane", chatRoom);
            User alex = new User("Alex", chatRoom);

            chatRoom.addUser(john);
            chatRoom.addUser(jane);
            chatRoom.addUser(alex);

            john.send("Hi everyone!");
            jane.send("Hello John!");
        }
    }
```
---

