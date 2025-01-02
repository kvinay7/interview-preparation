# Java-Based Web Application Development

## Spring Framework
The Spring Framework is a comprehensive and modular framework for building Java-based enterprise applications. It's designed to simplify development by providing a wide range of features, making it one of the most popular frameworks in the Java ecosystem.

## Spring Core
Spring Core is the foundational module of the Spring Framework. It provides essential functionality for managing objects and their dependencies. The core concepts and components in Spring Core are primarily Inversion of Control (IoC) and Dependency Injection (DI). These concepts form the foundation for building flexible, maintainable, and loosely-coupled applications.

- **Inversion of Control (IoC):** is a design principle where the control of object creation and their dependencies is transferred to an external container or framework, such as the Spring IoC container.
  
- **Dependency Injection (DI):** is a form of IoC where the dependencies of a class are provided (injected) by the Spring container rather than the class creating them itself. DI helps in achieving loose coupling and improves testability.
  
- **Bean:** A bean in Spring is an object that is managed by the Spring IoC container. Beans are created, configured, and assembled by the container. Beans are defined in configuration files (XML, annotations, or Java configuration).
  
- **Spring IoC container:** is responsible for managing the lifecycle of beans and handling their dependencies. `ApplicationContext` is the central interface to the Spring IoC container. It is an extended version of the `BeanFactory` interface, which is a basic container for managing beans.

- **Bean Lifecycle:**

      +-------------------+       +-------------------+       +---------------------------+       +----------------------------+
      | Container Started | ----> | Bean Instantiated | ----> | Dependency Injection (DI) | ----> | Internal Spring Processing |
      +-------------------+       +-------------------+       +---------------------------+       +----------------------------+
                                                                                                            |
                                                                 +--------------------+                     |
                               Bean is Ready for Use      <----- | Custom Init method | <-------------------- 
                            ----------------------------         +--------------------+  
                               Container is Shutdown
                                       |
                                       |
                                       V
                             +-----------------------+       +------+
                             | Custom Destroy method | ----> | Stop |
                             +-----------------------+       +------+
                                                        
- **Bean Scopes:** The scope of a Spring bean defines the lifecycle and visibility of that bean within the container:
  - `Singleton`: The default scope; only one instance of the bean is created and shared across the entire Spring container.
  - `Prototype`: A new instance of the bean is created every time it is requested.
  - `Request`: A bean is created once per HTTP request. This is typically used in web applications.
  - `Session`: A bean is created once per HTTP session.
  - `Global Session`: A bean is created once per global HTTP session (used in portlet-based applications).

- **Example in XML:**
  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Define the Engine bean -->
    <bean id="engine" class="com.example.Engine" />

    <!-- Define the Car bean with constructor-based DI -->
    <bean id="car" class="com.example.Car">
        <constructor-arg ref="engine" />
        <constructor-arg value="BMW" />
        <constructor-arg value="2023" />
    </bean>

    <!-- Define the Features bean (List of Strings for setter-based injection) -->
    <bean id="features" class="java.util.ArrayList">
        <constructor-arg>
            <list>
                <value>Leather seats</value>
                <value>Sunroof</value>
                <value>Bluetooth</value>
            </list>
        </constructor-arg>
    </bean>

    <!-- Define the Specifications bean (Map for setter-based injection) -->
    <bean id="specifications" class="java.util.HashMap">
        <constructor-arg>
            <map>
                <entry key="Color" value="Red" />
                <entry key="Transmission" value="Automatic" />
            </map>
        </constructor-arg>
    </bean>

    <!-- Inject the Features and Specifications using setter methods -->
    <bean id="carWithSetterInjection" class="com.example.Car">
        <property name="features" ref="features" />
        <property name="specifications" ref="specifications" />
    </bean>

    <!-- Inject external values using property files -->
    <context:property-placeholder location="classpath:application.properties" />
    <bean id="carWithExternalProps" class="com.example.Car">
        <constructor-arg ref="engine" />
        <constructor-arg value="${car.model}" />
        <constructor-arg value="${car.year}" />
        <property name="engineType" value="${car.engineType}" />
    </bean>

  </beans>
  ```

  ```properties
  # application.properties
  car.model=BMW
  car.year=2023
  car.engineType=V8
  ```
  
  ```java
  public class Car {

    private String model;
    private int year;
    private Engine engine; // Dependency
    private List<String> features; // Collection injection
    private Map<String, String> specifications; // Map injection

    // Constructor-based Injection
    public Car(Engine engine, String model, int year) {
        this.engine = engine;
        this.model = model;
        this.year = year;
    }

    // Setter-based Injection (Optional values)
    public void setFeatures(List<String> features) {
        this.features = features;
    }

    // Field-based Injection (Automatic injection via @Value)
    private String engineType;

    // Setter for Map-based injection
    public void setSpecifications(Map<String, String> specifications) {
        this.specifications = specifications;
    }

    public void printCarDetails() {
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Engine Type: " + engineType);
        System.out.println("Features: " + features);
        System.out.println("Specifications: " + specifications);
    }
  }
  ```

  ```java
  public class Engine {

    public void start() {
        System.out.println("Engine is starting...");
    }
  }
  ```

  ```java
  import org.springframework.context.support.ClassPathXmlApplicationContext;

  public class Main {
    public static void main(String[] args) {
        // Load Spring context from XML configuration
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the Car bean with constructor-based injection
        Car car = context.getBean("car", Car.class);
        car.printCarDetails();  // Print details for constructor-based Car bean

        // Retrieve the Car bean with setter-based injection
        Car carWithSetterInjection = context.getBean("carWithSetterInjection", Car.class);
        carWithSetterInjection.printCarDetails();  // Print details for setter-based Car bean

        // Retrieve the Car bean with external properties
        Car carWithExternalProps = context.getBean("carWithExternalProps", Car.class);
        carWithExternalProps.printCarDetails();  // Print details for the Car bean with external properties

        // Close context
        context.close();
    }
  }
  ```

  - **Output:**

  ```plaintext
  Model: BMW
  Year: 2023
  Engine Type: null
  Features: null
  Specifications: null

  Model: BMW
  Year: 2023
  Engine Type: null
  Features: [Leather seats, Sunroof, Bluetooth]
  Specifications: {Color=Red, Transmission=Automatic}

  Model: BMW
  Year: 2023
  Engine Type: V8
  Features: null
  Specifications: null
  ```


### **Example: Car Bean with Various Types of Dependency Injection and Values Passing**

#### 1. **Car Class (with constructor-based, setter-based, and field-based injection)**

```java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

@Component
public class Car {

    private String model;
    private int year;
    private Engine engine; // Dependency
    private List<String> features; // Collection injection
    private Map<String, String> specifications; // Map injection

    // Constructor-based Injection
    public Car(Engine engine, @Value("${car.model}") String model, @Value("${car.year}") int year) {
        this.engine = engine;
        this.model = model;
        this.year = year;
    }

    // Setter-based Injection (Optional values)
    public void setFeatures(List<String> features) {
        this.features = features;
    }

    // Field-based Injection (Automatic injection via @Autowired and @Value)
    @Value("${car.engineType}")
    private String engineType;

    // Setter for Map-based injection
    public void setSpecifications(Map<String, String> specifications) {
        this.specifications = specifications;
    }

    public void printCarDetails() {
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Engine Type: " + engineType);
        System.out.println("Features: " + features);
        System.out.println("Specifications: " + specifications);
    }
}
```

#### 2. **Engine Class (dependency for injection)**

```java
import org.springframework.stereotype.Component;

@Component
public class Engine {

    public void start() {
        System.out.println("Engine is starting...");
    }
}
```

#### 3. **Spring Configuration (Java-based)**

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig {

    @Bean
    public Engine engine() {
        return new Engine(); // Engine bean creation
    }

    @Bean
    public List<String> features() {
        return Arrays.asList("Leather seats", "Sunroof", "Bluetooth");
    }

    @Bean
    public Map<String, String> specifications() {
        Map<String, String> specs = new HashMap<>();
        specs.put("Color", "Red");
        specs.put("Transmission", "Automatic");
        return specs;
    }
}
```

#### 4. **Property File (Externalized Configuration)**

`application.properties` or `application.yml` would contain externalized values.

```properties
# application.properties
car.model=BMW
car.year=2023
car.engineType=V8
```

#### 5. **Main Class to Initialize Spring Context and Test Bean**

```java
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Create Spring context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve the Car bean
        Car car = context.getBean(Car.class);
        
        // Print car details
        car.printCarDetails();

        // Close context
        context.close();
    }
}
```

---

### **Explanation of the Example**

1. **Constructor-based Injection**:  
   The `Car` class constructor takes an `Engine` object and other literal values (like model and year) that are injected through constructor arguments. This is done through `@Value` for the model and year, which pulls from the `application.properties`.

   ```java
   public Car(Engine engine, @Value("${car.model}") String model, @Value("${car.year}") int year)
   ```

2. **Setter-based Injection**:  
   The `features` field is injected using a setter method (`setFeatures`) where a list of features is passed from a configuration class. 

   ```java
   public void setFeatures(List<String> features) {
       this.features = features;
   }
   ```

3. **Field-based Injection**:  
   The `engineType` is injected directly into the field using the `@Value` annotation to fetch the value from an external properties file.

   ```java
   @Value("${car.engineType}")
   private String engineType;
   ```

4. **Collection-based Injection**:  
   The list of features is injected into the `Car` bean via the `setFeatures` method, using `@Bean` in the configuration to pass a collection of feature strings.

   ```java
   @Bean
   public List<String> features() {
       return Arrays.asList("Leather seats", "Sunroof", "Bluetooth");
   }
   ```

5. **Map-based Injection**:  
   The `specifications` field is injected with a map of key-value pairs using the `setSpecifications` method. This is configured in the `AppConfig` class via a `@Bean` method that returns a `Map<String, String>`.

   ```java
   @Bean
   public Map<String, String> specifications() {
       Map<String, String> specs = new HashMap<>();
       specs.put("Color", "Red");
       specs.put("Transmission", "Automatic");
       return specs;
   }
   ```

