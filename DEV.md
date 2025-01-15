# Application Development
Application development is the process of designing, building, and maintaining software applications for various platforms such as web, mobile, desktop, and embedded systems. It encompasses a wide range of tasks including requirement gathering, architecture design, coding, testing, deployment, and maintenance.

## Spring Framework
The Spring Framework is a comprehensive and modular framework for building Java-based enterprise applications. It's designed to simplify development by providing a wide range of features, making it one of the most popular frameworks in the Java ecosystem.

## Spring Core
Spring Core is the foundational module of the Spring Framework. It provides essential functionality for managing objects and their dependencies. The core concepts and components in Spring Core are primarily Inversion of Control (IoC) and Dependency Injection (DI). These concepts form the foundation for building flexible, maintainable, and loosely-coupled applications.

- **Inversion of Control (IoC):** is a design principle where the control of object creation and their dependencies is transferred to an external container or framework, such as the Spring IoC container.
  
- **Dependency Injection (DI):** is a form of IoC where the dependencies of a class are provided (injected) by the Spring container rather than the class creating them itself. DI helps in achieving loose coupling and improves testability.
  - Constructor-based DI
  - Setter-based DI
  - Field-based DI 
  
- **Spring IoC container:** is responsible for managing the lifecycle of objects and handling their dependencies. `ApplicationContext` (eager) is the central interface to the Spring IoC container. It is an extended version of the `BeanFactory` (lazy) interface, which is a basic container for managing objects.

- **Bean:** A bean in Spring is an object that is managed by the Spring IoC container. Beans are created, configured, and assembled by the container. Beans are defined in configuration files (XML, annotations, or Java configuration).

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

- **Configuration in XML:**
  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Enable component scanning for beans annotated with @Component -->
    <context:component-scan base-package="com.example"/>

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
        <constructor-arg value="#{T(java.lang.Integer).parseInt('${car.year}') + 1}" />
        <property name="engineType" value="${car.engineType}" />
    </bean>

  </beans>
  ```

- **Configuration in Java:**
  ```java
  import org.springframework.context.annotation.Bean;
  import org.springframework.context.annotation.Configuration;
  import org.springframework.context.annotation.PropertySource;

  @Configuration
  @ComponentScan(basePackages = "com.example")  // Automatically scans for @Component beans
  @PropertySource("classpath:application.properties")
  public class AppConfig {

    // Define the Car bean with constructor-based DI
    @Bean
    public Car car() {
        return new Car(engine(), "BMW", 2023);
    }

    // Define the Features bean (List of Strings for setter-based injection)
    @Bean
    public List<String> features() {
        List<String> features = new ArrayList<>();
        features.add("Leather seats");
        features.add("Sunroof");
        features.add("Bluetooth");
        return features;
    }

    // Define the Specifications bean (Map for setter-based injection)
    @Bean
    public Map<String, String> specifications() {
        Map<String, String> specifications = new HashMap<>();
        specifications.put("Color", "Red");
        specifications.put("Transmission", "Automatic");
        return specifications;
    }

    // Define Car bean with setter-based injection
    @Bean
    public Car carWithSetterInjection() {
        Car car = new Car(engine(), "BMW", 2023);
        car.setFeatures(features());
        car.setSpecifications(specifications());
        return car;
    }

    // Define Car bean with external properties (using @Value annotation)
    @Bean
    public Car carWithExternalProps(@Value("${car.model}") String model,
                                    @Value("#{T(java.lang.Integer).parseInt('${car.year}') + 1}") int year,
                                    @Value("${car.engineType}") String engineType) {
        Car car = new Car(engine(), model, year);
        car.setEngineType(engineType);
        return car;
    }
  }
  ```
  
  ```properties
  # application.properties
  car.model=BMW
  car.year=2024
  car.engineType=V8
  ```

- **Java Classes:**
  ```java
  import org.springframework.stereotype.Component;
  
  @Component
  public class Engine {
    public void start() {
        System.out.println("Engine is starting...");
    }
  }
  ```
  
  ```java
  public class Car {

    private String model;
    private int year;
    private Engine engine; // Dependency
    private List<String> features; // Collection injection
    private Map<String, String> specifications; // Map injection
    private String engineType;
  
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

    // Setter for Map-based injection
    public void setSpecifications(Map<String, String> specifications) {
        this.specifications = specifications;
    }
  
    public void setEngineType(String engineType) {
        this.engineType = engineType;
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
  import org.springframework.context.ApplicationContext;
  import org.springframework.context.support.ClassPathXmlApplicationContext;
  import org.springframework.context.support.AnnotationConfigApplicationContext;

  public class Main {
    public static void main(String[] args) {
        // Load Spring context from XML configuration
        ApplicationContext contextXml = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Load Spring context from Java configuration
        ApplicationContext contextJava = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve the Car bean with constructor-based injection
        Car car = contextJava.getBean("car", Car.class);
        car.printCarDetails();  // Print details for constructor-based Car bean

        // Retrieve the Car bean with setter-based injection
        Car carWithSetterInjection = contextXml.getBean("carWithSetterInjection", Car.class);
        carWithSetterInjection.printCarDetails();  // Print details for setter-based Car bean

        // Retrieve the Car bean with external properties
        Car carWithExternalProps = contextJava.getBean("carWithExternalProps", Car.class);
        carWithExternalProps.printCarDetails();  // Print details for the Car bean with external properties

        // Close context
        contextXml.close();
        contextJava.close();
    }
  }
  ```

### Autowiring
Autowiring is a feature that allows Spring to automatically inject dependencies into beans, eliminating the need to explicitly specify dependencies through setter or constructor injection. 

  - **Autowire with `@Autowired` Annotation (Java-based Configuration)**: The `@Autowired` annotation can be applied to fields, constructors, or setter methods to automatically inject the required dependency. By default true and can't apply for static fields or methods.

  - **Autowire with `@Qualifier` (In case of multiple beans of the same type)**
     ```java
     @Autowired
     @Qualifier("electricEngine")
     private Engine engine;
     ```

  - **Autowire with `@Primary` (When multiple candidates are available)**: The `@Primary` annotation is used to mark one of the beans as the primary candidate for injection when multiple beans of the same type are available.
     ```java
     @Bean
     @Primary
     public Engine v8Engine() {
       return new Engine("V8");
     }

     @Bean
     public Engine electricEngine() {
       return new Engine("Electric");
     }
     ```
---

## Spring Boot
Spring Boot is designed to make it easy to get started with Spring development by minimizing manual configuration and automatically resolving dependency conflicts. It provides auto-configuration, an embedded HTTP server, and many features out of the box, making it very developer-friendly.

### Maven
Maven is a build automation tool for Java projects. It simplifies dependency management, project building, and deployment by using a Project Object Model (POM) defined in an XML file. Maven handles tasks like downloading libraries, compiling code, running tests, and packaging applications into artifacts (e.g., JARs).
   
#### Spring Application Project Structure: [Example](https://github.com/darbyluv2code/spring-boot-3-spring-6-hibernate-for-beginners/tree/main/01-spring-boot-overview/01-spring-boot-demo)
   ```
   my-spring-boot-app/
   ├── .mvn/                        		     	# Maven wrapper (if using Maven)
   ├── mvnw                         		     	# Maven wrapper script (if using Maven)
   ├── mvnw.cmd                     			# Maven wrapper for Windows (if using Maven)
   ├── pom.xml                     			# Maven Project Object Model (POM) file
   ├── src/                         			# Source code directory
   │   ├── main/
   │   │   ├── java/                			# Java source code
   │   │   │   └── com/example/demo/  		       	# Main application package
   │   │   │       ├── DemoApplication.java  	       	# Main Spring Boot application class
   |   |   |       ├── controller/                     	# Controller layer (for handling HTTP requests)
   │   |   |       ├── service/                        	# Service layer (business logic)
   │   |   |       ├── repository/                     	# Data access layer (usually interacting with DB)
   │   |   |       ├── model/                          	# Model classes (entities, DTOs)
   │   |   |       └── config/                         	# Configuration classes (optional for custom beans)
   │   │   ├── resources/           			# Resources like application.properties, static files, templates
   │   │   │   ├── application.properties  		# Configuration properties for the application
   │   │   │   ├── static/          			# Static resources (CSS, JS, images)
   │   │   │   └── templates/       			# Template files (for Thymeleaf, etc.)
   │   ├── test/                    			# Unit and integration tests
   │   │   ├── java/                			# Test code
   │   │   │   └── com/example/demo/   			# Test classes
   │   │   │       └── DemoApplicationTests.java  	# Test class for the Spring Boot application
   ├── target/                      			# Compiled classes and packaged artifacts (JAR/WAR)
   ├── .gitignore                   			# Git ignore file (to ignore compiled files, etc.)
   └── README.md                    			# Project documentation (optional)
   ```
---

### Spring ORM: [Hibernate](https://github.com/darbyluv2code/spring-boot-3-spring-6-hibernate-for-beginners/tree/main/03-spring-boot-hibernate-jpa-crud/08-cruddemo-create-db-tables-automatically), [Data JPA](https://www.javaguides.net/p/spring-data-jpa-tutorial.html)

### **Phase 1: Building the Web Layer**  
**Goal:** Learn **Spring MVC** and basic **Spring REST** for handling HTTP requests.

1. **Week 1: Spring MVC**
   - **What to Learn:**
     - Controllers (`@Controller`, `@RequestMapping`, `@GetMapping`, etc.).
     - Model and View (`Model`, `ModelAndView`).
     - View templates with **Thymeleaf**.
     - Form handling and validation (`@Valid`, `BindingResult`).
   - **Tasks:**
     - Build a web page to display all books (connect to the database via JPA).
     - Add a form to create a new book and validate user input.

2. **Week 2: Spring REST**
   - **What to Learn:**
     - REST controllers (`@RestController`).
     - Serving JSON/XML responses.
     - Handling request parameters and path variables (`@RequestParam`, `@PathVariable`).
     - HTTP methods (`GET`, `POST`, `PUT`, `DELETE`).
     - Testing REST APIs with Postman or cURL.
   - **Tasks:**
     - Expose REST endpoints for CRUD operations on books.
     - Write endpoints like `/books/{id}`, `/books/category/{id}`, etc.

### **Phase 2: Integrating Spring MVC and REST with JPA**  
**Goal:** Combine the data layer, MVC, and REST in one application.

1. **What to Learn:**
   - Service layer: Writing business logic in a service class (`@Service`).  
   - Controller-Service-Repository pattern.  
   - Error handling using `@ControllerAdvice` and `@ExceptionHandler`.  

2. **Tasks:**
   - Refactor the project to use a **three-layer architecture**:
     - **Controller layer**: Handles requests (REST and MVC).  
     - **Service layer**: Contains business logic.  
     - **Repository layer**: Handles database operations.  
   - Add global exception handling for invalid inputs or resource not found errors.

### **Phase 3: Advanced Features**  
**Goal:** Add advanced functionality to make your app production-ready.

1. **Week 1: Pagination, Sorting, and Validation**
   - **What to Learn:**
     - Pagination and sorting with `Pageable` and `Sort`.
     - Validating input data (`@NotNull`, `@Size`, etc.).
     - Custom validation annotations.
   - **Tasks:**
     - Add pagination and sorting to your REST API (e.g., `/books?page=0&size=10&sort=title`).
     - Implement input validation for adding/editing books.

2. **Week 2: Security and Testing**
   - **What to Learn:**
     - Securing your app with **Spring Security** (basic authentication).
     - Writing unit tests for services and controllers using JUnit and Mockito.
     - Testing REST APIs with Spring Boot Test (`MockMvc`).
   - **Tasks:**
     - Add basic authentication to secure your REST endpoints.
     - Write unit and integration tests for your application.

### **Phase 4: Deployment and Optimization**  
**Goal:** Learn how to deploy and optimize your application.

1. **What to Learn:**
   - Using Spring Profiles to manage different environments (e.g., `dev`, `prod`).
   - Externalizing configuration (e.g., database credentials).
   - Deploying the app to AWS, Heroku, or Azure.
   - Monitoring with Spring Actuator.

2. **Tasks:**
   - Configure your app for production (e.g., PostgreSQL database, caching).
   - Deploy your app to a cloud platform.
   - Test live endpoints using Postman.
