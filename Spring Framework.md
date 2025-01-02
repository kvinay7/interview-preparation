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

- **Example:**
  ```xml
  <!-- applicationContext.xml (Spring configuration) -->
  <beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
                           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Define Engine bean -->
    <bean id="engine" class="com.example.Engine" />
    
    <!-- Define Car bean with dependency injection -->
    <bean id="car" class="com.example.Car">
        <property name="engine" ref="engine" />
    </bean>

  </beans>
  ```
  
  ```java
  // Engine class
  public class Engine {
      public void start() {
          System.out.println("Engine is starting...");
      }
  }

  // Car class (With IoC)
  public class Car {
      private Engine engine;  // Dependency

      // Setter-based dependency injection
      public void setEngine(Engine engine) {
          this.engine = engine;
      }

      public void drive() {
          engine.start();
          System.out.println("Driving the car...");
      }
  }

  // Main application (using Spring)
  import org.springframework.context.ApplicationContext;
  import org.springframework.context.support.ClassPathXmlApplicationContext;

  public class MainApp {
      public static void main(String[] args) {
          // Spring container loads configuration and manages object creation
          ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
          // Spring container injects the Engine bean into the Car bean
          Car car = (Car) context.getBean("car"); // Loose coupling via IoC
          car.drive();
      }
  }
  ```

