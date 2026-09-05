# Spring Framework
The Spring Framework is a comprehensive and modular framework for building Java-based enterprise applications. It's designed to simplify development by providing a wide range of features, making it one of the most popular frameworks in the Java ecosystem.

## Spring Core
Spring Core is the foundational module of the Spring Framework. It provides essential functionality for managing objects and their dependencies. The core concepts and components in Spring Core are primarily Inversion of Control (IoC) and Dependency Injection (DI). These concepts form the foundation for building flexible, maintainable, and loosely-coupled applications.

- **Inversion of Control (IoC):** is a design principle where the control of object creation and their dependencies is transferred to an external container or framework, such as the Spring IoC container.
  
- **Dependency Injection (DI):** is a form of IoC where the dependencies of a class are provided (injected) by the Spring container rather than the class creating them itself. DI helps in achieving loose coupling and improves testability.

- **Spring IoC container:** is responsible for managing the lifecycle of objects and handling their dependencies. `ApplicationContext` (eager) is the central interface to the Spring IoC container. It is an extended version of the `BeanFactory` (lazy) interface, which is a basic container for managing objects.

  #### 1. Without IoC / DI (Tightly Coupled)

  ```java
  public class Engine {
      public void start() {
          System.out.println("Engine Started");
      }
  }
  ```

  ```java
  public class Car {

      private Engine engine;

      public Car() {
          this.engine = new Engine();      // Car creates its own dependency
      }

      public void drive() {
          engine.start();
          System.out.println("Car Moving");
      }
  }
  ```

  ```java
  public class Main {
    public static void main(String[] args) {
          Car car = new Car();
          car.drive();
      }
  }
  ```

  #### Problems

  - Tight Coupling
  - Hard to replace dependency
  - Hard to unit test
  - Object creation is inside the class

  ----

  #### 2. With IoC / DI (Manual Dependency Injection)

  ```java
  public class Engine {
      public void start() {
          System.out.println("Engine Started");
      }
  }
  ```

  ```java
  public class Car {

      private Engine engine;

      public Car(Engine engine) {
          this.engine = engine;
      }

      public void drive() {
          engine.start();
          System.out.println("Car Moving");
      }
  }
  ```

  ```java
  public class Main {
      public static void main(String[] args) {
          Engine engine = new Engine();
          Car car = new Car(engine);
          car.drive();
      }
  }
  ```

  #### Advantages

  - Loose Coupling
  - Easy to replace dependency
  - Easy to test
  - Dependency Injection done manually

  ----

  #### 3. With Spring IoC / DI

  #### i. Constructor Injection (Recommended)

  ```java
  @Component
  public class Engine {
      public void start() {
          System.out.println("Engine Started");
      }
  }
  ```

  ```java
  @Service
  public class Car {

      private final Engine engine;

      public Car(Engine engine) {
          this.engine = engine;
      }

      public void drive() {
          engine.start();
          System.out.println("Car Moving");
      }
  }
  ```

  ----

  #### ii. Setter Injection

  ```java
  @Component
  public class Engine {
      public void start() {
          System.out.println("Engine Started");
      }
  }
  ```

  ```java
  @Service
  public class Car {

      private Engine engine;

      @Autowired
      public void setEngine(Engine engine) {
          this.engine = engine;
      }

      public void drive() {
          engine.start();
          System.out.println("Car Moving");
      }
  }
  ```

  ----

  #### iii. Field Injection

  ```java
  @Component
  public class Engine {
      public void start() {
          System.out.println("Engine Started");
      }
  }
  ```

  ```java
  @Service
  public class Car {

      @Autowired
      private Engine engine;

      public void drive() {
          engine.start();
          System.out.println("Car Moving");
      }
  }
  ```

  #### Main Application

  ```java
  @SpringBootApplication
  public class MainApplication {
      public static void main(String[] args) {
          ApplicationContext context = SpringApplication.run(MainApplication.class, args);
          Car car = context.getBean(Car.class);
          car.drive();

          BeanFactory factory = context;
          Car car = factory.getBean(Car.class);
      }
  }
  ```

  #### Advantages

  - Loose Coupling
  - Automatic Dependency Injection
  - Better Testability
  - Better Maintainability
  - Object lifecycle managed by Spring
  - No manual object creation

----

### Bean Management

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
  - `Singleton` - `@Scope("singleton")`: The default scope; only one instance of the bean is created and shared across the entire Spring container.
  - `Prototype` - `@Scope("prototype")`: A new instance of the bean is created every time it is requested.
  - `Request` - `@RequestScope`: A bean is created once per HTTP request. This is typically used in web applications.
  - `Session` - `@SessionScope`: A bean is created once per HTTP session.
  - `Global Session`: A bean is created once per global HTTP session (used in portlet-based applications).

---

### Autowiring

- **Autowiring:** is a feature that allows Spring to automatically inject dependencies into beans, eliminating the need to explicitly specify dependencies through setter or constructor injection. 

  - **Autowire with `@Autowired` Annotation (Java-based Configuration)**: The `@Autowired` annotation can be applied to fields, constructors, or setter methods to automatically inject the required dependency. By default true and can't apply for static fields or methods. `@Inject` is part of Java’s standard dependency injection mechanism (JSR-330). `@Resource` is JSR-250 annotation equivalent to `@Auttowired` but can't be applied on constructor level.

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

### Configuration

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

    <bean id="car" class="com.example.Car" autowire="byName" /> <!-- class must have a property name as bean and a corresponding setter -->
    <bean id="car" class="com.example.Car" autowire="byType" /> <!-- byType is default behavior in Java config -->
    <bean id="car" class="com.example.Car" autowire="constructor" /> <!-- A matching constructor must be available in the class -->
  
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
    @Bean(name = "carWithSetters", initMethod = "init", destroyMethod = "cleanup")
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
  
  @Component // Equivalent JSR-330 annotation - @Named
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

    public void setEngine(Engine engine) {
        this.engine = engine;
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

    public void init() {
        System.out.println("Custom init-method: Car initialized");
    }

    public void cleanup() {
        System.out.println("Custom destroy-method: Car cleaned up");
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

        Car setterCar = contextJava.getBean("carWithSetters", Car.class);
        setterCar.printCarDetails();

        // Retrieve the Car bean with external properties
        Car carWithExternalProps = contextJava.getBean("carWithExternalProps", Car.class);
        carWithExternalProps.printCarDetails();  // Print details for the Car bean with external properties

        // Close context
        contextXml.close();
        contextJava.close();
    }
  }
  ```
  
---

## Spring Boot
Spring Boot is designed to make it easy to get started with Spring development by minimizing manual configuration and automatically resolving dependency conflicts. It provides auto-configuration, an embedded HTTP server, and many features out of the box, making it very developer-friendly.

- **Maven:** is a build automation tool for Java projects. It simplifies dependency management, project building, and deployment by using a Project Object Model (POM) defined in an XML file. Maven handles tasks like downloading libraries, compiling code, running tests, and packaging applications into artifacts (e.g., JARs).

- **Spring Application Project Structure:** [Example](https://github.com/darbyluv2code/spring-boot-3-spring-6-hibernate-for-beginners/tree/main/01-spring-boot-overview/01-spring-boot-demo)

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

## Core Annotations

### 1. Application Bootstrap

- **`@SpringBootApplication`**: Main entry point of a Spring Boot application. Combines `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`.
- **`@EnableAutoConfiguration`**: Automatically configures Spring beans based on the project's dependencies and configuration.
- **`@ComponentScan`**: Scans the specified packages for Spring-managed components such as `@Component`, `@Service`, and `@Repository`.

---

### 2. Bean Registration

- **`@Configuration`**: Marks a class as a source of Spring bean definitions.
- **`@Bean`**: Registers a bean explicitly inside a `@Configuration` class.
- **`@Component`**: Generic annotation for registering a Spring-managed bean.
- **`@Service`**: Specialized `@Component` used for the service (business logic) layer.
- **`@Repository`**: Specialized `@Component` used for the data access layer. Also enables Spring's exception translation.
- **`@Controller`**: Marks a class as a Spring MVC controller that typically returns views.
- **`@RestController`**: Combination of `@Controller` and `@ResponseBody`; used to build REST APIs that return JSON or XML.
- **`@Scope`**: Defines the lifecycle and visibility of a Spring bean (Singleton, Prototype, Request, Session, etc.).

---

### 3. Dependency Injection

- **`@Autowired`**: Automatically injects a dependency by type.
- **`@Qualifier`**: Specifies which bean should be injected when multiple beans of the same type exist.
- **`@Primary`**: Marks a bean as the default choice when multiple candidates are available for injection.

---

### 4. External Configuration

- **`@Value`**: Injects a single value from `application.properties`, `application.yml`, or environment variables.
- **`@PropertySource`**: Loads additional property files into the Spring Environment.
- **`@ConfigurationProperties`**: Binds a group of related configuration properties into a strongly typed Java class.

---

### 5. Bean Lifecycle

- **`@PostConstruct`**: Executes a method immediately after the bean is created and dependency injection is completed.
- **`@PreDestroy`**: Executes a method just before the bean is removed from the Spring container.

---

## Spring MVC
Spring MVC (Model-View-Controller) is a powerful framework within the Spring ecosystem designed to build robust and scalable web applications.
- **Model**: Represents the application's data and business logic. It is often backed by service and persistence layers.
- **View**: The presentation layer that displays data from the model to the user. It can use technologies like JSP, Thymeleaf, or other templating engines.
- **Controller**: Handles user input, processes requests, interacts with the model, and determines which view to render.

### 1. **[HTTP](https://github.com/kvinay7/interview-preparation/blob/main/HTTP%20%26%20REST%20APIs.md) Request/Response Flow**
 - **Client sends HTTP request** (browser/frontend/Postman -> DNS/TCP/TLS -> IP -> Server Port).
 - Request reaches the **embedded servlet container (Tomcat)**.
 - The request passes through the **Servlet Filter Chain**, where:
   - Security headers are added.
   - Logging and correlation IDs are generated.
   - JWT authentication is validated.
 - The request then enters **Spring Security** for authorization checks.
 - The **DispatcherServlet** (front controller) receives the request.
 - **HandlerMapping** determines which controller should handle the request.
 - **HandlerAdapter** prepares the method invocation and binds request data.
 - The **Controller** processes the request and calls the **Service layer**.
 - The **Service layer** performs business logic and interacts with the **Repository / Database or external services**.
 - The response travels back to the controller.
 - **HttpMessageConverters** convert Java objects into JSON.
 - Response passes back through filters.
 - **Tomcat sends the HTTP response back to the client**.

### 2. **DispatcherServlet**
- **[Central Controller](https://www.javaguides.net/2020/07/how-spring-mvc-works-internally.html)**: Acts as the front controller in the Spring MVC architecture.
- **Key Tasks**:
  - Receives HTTP requests.
  - Maps requests to the corresponding controller based on configurations.
  - Selects the appropriate view for the response.

### 3. **Handler Mapping**
- Responsible for mapping incoming HTTP requests to the appropriate handler methods in controllers.
- Examples of handler mappings: `@RequestMapping` or `@GetMapping`.
    
### 4. **Controller**
- `@Controller` or `@RestController` to define web request handlers to process incoming HTTP requests.
- `Model` or `ModelMap` objects allow adding attributes to pass data from controllers to the view.
- Example:
  ```java
  @Controller
  public class MyController {
      @GetMapping("/greet")
      public String greet(Model model) {
          model.addAttribute("message", "Hello, Spring MVC!");
          return "greet"; // Logical view name
      }
  }
  ```

### 5. **View Resolver**
- Responsible for resolving the logical view name returned by a controller into an actual view.
- Example:
  - **InternalResourceViewResolver** maps logical view names to JSP files in a specific directory.
  ```java
  @Configuration
  @EnableWebMvc
  @ComponentScan(basePackages = "com.example.controller")
  public class WebConfig implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
  }
  ```

### 6. **Deployment Descriptor**
- It is used to configure the `DispatcherServlet`, the context parameters (ApplicationContext), and other settings such as filters or listeners.
```java
  public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // Application-wide configurations like services, repositories
        return new Class[] { AppConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // Web-related configurations like controllers, view resolvers
        return new Class[] { WebConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        // Map DispatcherServlet to "/"
        return new String[] { "/" };
    }
  }
  ```

### 7. **Annotations in Spring MVC**
- **@Controller**: Marks a class as a web controller.
- **@RequestMapping**: Maps web requests to handler methods or classes.
- **@GetMapping, @PostMapping, @PutMapping, @DeleteMapping**: Shortcut annotations for HTTP methods.
- **@RestController**: Combines `@Controller` and `@ResponseBody`. [Example](https://github.com/darbyluv2code/spring-boot-3-spring-6-hibernate-for-beginners/tree/main/04-spring-boot-rest-crud/14-spring-boot-rest-crud-employee-with-spring-data-jpa)
- **@ResponseBody**: Directly returns data (e.g., JSON or XML) instead of a view.

### 8. **Request and Response Handling** - [Example](https://github.com/darbyluv2code/spring-boot-3-spring-6-hibernate-for-beginners/tree/main/07-spring-boot-spring-mvc-crud/04-02-thymeleaf-demo-employees-delete-alternate-solution-post-all-data)
- **@RequestParam**: Extract query parameters from the request.
  ```java
  @GetMapping("/search")
  public String search(@RequestParam("query") String query, Model model) {
      model.addAttribute("result", "You searched for: " + query);
      return "result";
  }
  ```
- **@PathVariable**: Extract values from URI templates.
  ```java
  @GetMapping("/user/{id}")
  public String getUser(@PathVariable("id") int userId, Model model) {
      model.addAttribute("user", userService.getUserById(userId));
      return "userDetails";
  }
  ```

### 9. **Form Handling**
- Spring MVC provides features to handle forms.
- Use `@ModelAttribute` to bind form data to an object.
  ```java
  @PostMapping("/submit")
  public String submitForm(@ModelAttribute("user") User user, Model model) {
      // Process form data
      model.addAttribute("message", "Form submitted successfully!");
      return "result";
  }
  ```

### 10. **Exception Handling**
- `@ControllerAdvice` to handle exceptions globally and `@ExceptionHandler` to handle specific exceptions in controller classes.
  ```java
  @ControllerAdvice
  public class GlobalExceptionHandler {
      @ExceptionHandler(Exception.class)
      public String handleException(Exception ex, Model model) {
          model.addAttribute("error", ex.getMessage());
          return "error";
      }
  }
  ```

---

## Spring ORM:
Spring ORM (Object-Relational Mapping) is a module of the Spring Framework that simplifies the integration of ORM frameworks such as JPA and Hibernate with Spring. It provides support for working with relational databases using ORM tools while managing transactions and resources efficiently.

### 1. **Integration with ORM Frameworks**
- **Java Persistence API (JPA)**: A standard API for ORM.
- **Hibernate**: A widely used ORM framework. In Spring Boot, Hibernate is the default implementation of JPA. Based on configs, spring boot will automatically create the beans such as DataSource, EntityManager, ...

### 2. **Spring ORM with Hibernate**: 
```java
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.example")
public class AppConfig {

    @Bean
    public DataSource dataSource() { // DataSource is a key component that provides the database connection details to the application.
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
        dataSource.setUsername("root");
        dataSource.setPassword("password");
        return dataSource;
    }

    @Bean
    // SessionFactory injected into DaoImpl class to perform database transactions.
    public LocalSessionFactoryBean sessionFactory() { // SessionFactory is a central factory class that creates Session instances, which are used to interact with the database. It is a heavyweight object, so it's typically created once and reused throughout the application.
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.example.models");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager() { // It manages transactions for Hibernate sessions, allows to use @Transactional annotation at Service Layer to handle commit/rollback automatically.
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory().getObject());
        return txManager;
    }

    private Properties hibernateProperties() { // Hibernate properties are configuration settings that control how Hibernate behaves.
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "update");
        return properties;
    }
}
```

---

## Spring Data JPA

**Purpose:** CRUD operations, data persistence, and database interaction in Spring Boot applications.

### 1. Entity Mapping
 
**Purpose:** Define persistent data structures using JPA annotations.
 
#### 1.1 Core Annotations
 
```java
@Entity                    // Mark class as JPA entity (mapped to DB table)
@Table(name = "users")     // Specify table name (optional, defaults to class name)
@Data                      // Lombok: auto-generate getters/setters/toString/equals/hashCode
@NoArgsConstructor         // Lombok: no-arg constructor (required by JPA)
public class User {
    
    @Id                    // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment ID
    private Long id;
    
    @Column(
        nullable = false,  // NOT NULL constraint
        unique = true,     // UNIQUE constraint
        length = 100       // VARCHAR(100)
    )
    @NotBlank              // Validation: must not be blank
    @Email                 // Validation: must be valid email
    private String email;
    
    @Column(nullable = false, length = 100)
    @NotBlank
    @Size(max = 100)
    private String name;
    
    @Column(length = 20)
    @Size(max = 20)
    private String phone;
    
    @CreationTimestamp     // Auto-populate on INSERT
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp       // Auto-populate on UPDATE
    @Column(nullable = false)
    private LocalDateTime updatedAt;
    
    @Column(nullable = false)
    private Boolean isDeleted = false;  // Soft delete pattern
    
    @Enumerated(EnumType.STRING)  // Store enum as string (not numeric)
    @Column(nullable = false)
    private UserRole role = UserRole.USER;  // Default role
}
```
 
#### 1.2 Data Types Mapping
 
| Java Type | SQL Type | JPA Annotation |
|---|---|---|
| `Long` | `BIGINT` | @Id @GeneratedValue |
| `String` | `VARCHAR(n)` | @Column(length=n) |
| `Integer` | `INT` | - |
| `BigDecimal` | `DECIMAL(10,2)` | @Column(precision=10, scale=2) |
| `LocalDateTime` | `TIMESTAMP` | @CreationTimestamp / @UpdateTimestamp |
| `Boolean` | `BOOLEAN` | - |
| `Enum` | `VARCHAR(50)` | @Enumerated(EnumType.STRING) |
| `UUID` | `UUID` (PostgreSQL) | - |
 
#### 1.3 Constraints
 
```java
// Field constraints
@Column(nullable = false)          // NOT NULL
@Column(unique = true)             // UNIQUE
@Column(length = 100)              // VARCHAR(100)
@Column(precision = 10, scale = 2) // DECIMAL(10,2)
 
// Validation constraints
@NotNull                 // Value must not be null
@NotBlank               // String must not be blank
@Email                  // Valid email format
@Size(min=1, max=100)   // String length 1-100
@Min(0)                 // Number >= 0
@Max(100)               // Number <= 100
@Positive               // Number > 0
@Negative               // Number < 0
@Pattern(regexp="...")  // Regex validation
```
 
#### 1.4 Lombok Benefits
 
```java
// WITHOUT Lombok (verbose)
public class User {
    private Long id;
    private String email;
    
    // 20+ lines of getters, setters, toString, equals, hashCode
}
 
// WITH Lombok @Data (clean)
@Data
public class User {
    private Long id;
    private String email;
    // All getters/setters/toString/equals/hashCode auto-generated
}
```

---
 
### 2. Relationships
 
**Purpose:** Define associations between entities (User ↔ Order, Order ↔ OrderItem, etc.)
 
#### 2.1 One-to-Many (1:N)
 
**One User has many Orders**
 
```java
@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String email;
    
    // One user can have many orders
    @OneToMany(
        mappedBy = "user",           // Inverse side (Order.user)
        cascade = CascadeType.ALL,   // Delete user → delete orders
        orphanRemoval = true,        // Delete order from list → delete from DB
        fetch = FetchType.LAZY       // Load orders only when accessed
    )
    private Set<Order> orders = new HashSet<>();
}
 
@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private BigDecimal total;
    
    // Many orders belong to one user (owning side)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)  // Foreign key
    private User user;
}
```
 
**Database Schema Generated:**
```sql
CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(100) NOT NULL UNIQUE
);
 
CREATE TABLE orders (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);
```
 
#### 2.2 Many-to-One (N:1)
 
**Inverse of 1:N (simpler, usually on child side)**
 
```java
@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // Many orders belong to one user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
```
 
#### 2.3 One-to-One (1:1)
 
**One User has one Profile**
 
```java
@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String email;
    
    @OneToOne(
        mappedBy = "user",
        cascade = CascadeType.ALL,
        orphanRemoval = true,
        fetch = FetchType.LAZY
    )
    private UserProfile profile;
}
 
@Entity
@Table(name = "user_profiles")
@Data
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String bio;
    private String profilePicUrl;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;
}
```
 
#### 2.4 Many-to-Many (N:N)
 
**Many Users can belong to many Groups (junction table)**
 
```java
@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String email;
    
    @ManyToMany(
        cascade = {CascadeType.PERSIST, CascadeType.MERGE},
        fetch = FetchType.LAZY
    )
    @JoinTable(
        name = "user_groups",              // Junction table name
        joinColumns = @JoinColumn(name = "user_id"),      // FK to users
        inverseJoinColumns = @JoinColumn(name = "group_id")  // FK to groups
    )
    private Set<Group> groups = new HashSet<>();
}
 
@Entity
@Table(name = "groups")
@Data
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    @ManyToMany(mappedBy = "groups", fetch = FetchType.LAZY)  // Inverse side
    private Set<User> users = new HashSet<>();
}
```
 
**Database Schema:**
```sql
CREATE TABLE users (id BIGINT PRIMARY KEY, email VARCHAR(100));
CREATE TABLE groups (id BIGINT PRIMARY KEY, name VARCHAR(100));
CREATE TABLE user_groups (
    user_id BIGINT NOT NULL,
    group_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, group_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (group_id) REFERENCES groups(id)
);
```

---
 
### 3. Cascade & Fetch Strategies
 
**Purpose:** Control how related entities are loaded and persisted
 
#### 3.1 Cascade Types
 
```java
@OneToMany(cascade = CascadeType.ALL)  // ALL = PERSIST, MERGE, REMOVE, REFRESH, DETACH
 
// Specific cascades:
@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
// When saving User, also save new orders (PERSIST)
// When merging detached User, also merge orders (MERGE)
// But don't delete orders when user is deleted
 
@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
// Equivalent to above for delete scenario
// If you remove an order from user.orders list, delete from DB (orphan removal)
```
 
#### 3.2 Fetch Strategies
 
```java
// LAZY (Default) - Load relationship only when accessed
@OneToMany(fetch = FetchType.LAZY)
public Set<Order> orders;
 
// Usage:
User user = userRepository.findById(1L).get();
// orders NOT loaded yet
 
List<Order> orders = user.getOrders();  // Now orders loaded (separate query)
```
 
**Problem: LazyInitializationException**
```java
// WRONG
@Transactional  // ← Missing!
public User getUser(Long id) {
    return userRepository.findById(id).get();  // Session closes after return
}
 
// In controller
User user = getUser(1L);
List<Order> orders = user.getOrders();  // ERROR: LazyInitializationException!
// Session is closed, can't load lazy orders
 
// CORRECT
@Transactional
public User getUser(Long id) {
    User user = userRepository.findById(id).get();
    user.getOrders().size();  // Eager load while session open
    return user;
}
```
 
#### 3.3 EAGER Loading
 
```java
// EAGER - Load relationship immediately
@OneToMany(fetch = FetchType.EAGER)
public Set<Order> orders;
 
// Usage:
User user = userRepository.findById(1L).get();
// orders loaded automatically (same query or JOIN)
List<Order> orders = user.getOrders();  // No extra query
```
 
**Trade-off:**
- EAGER: Always load (slower queries, but safe)
- LAZY: Load on demand (faster initial query, but risk of LazyInitializationException)
  
#### 3.4 orphanRemoval
 
```java
@OneToMany(orphanRemoval = true)
private Set<Order> orders;
 
// Usage:
user.getOrders().remove(order);  // Removes from list
userRepository.save(user);        // Deletes order from DB (orphan)
 
// Equivalent to cascade REMOVE for this case
```

---
 
### 4. JPA Callbacks
 
**Purpose:** Execute logic automatically at entity lifecycle events
 
#### 4.1 Lifecycle Events
 
```java
@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String email;
    
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;
    
    private Boolean isDeleted = false;
    
    // Called before INSERT
    @PrePersist
    private void prePersist() {
        System.out.println("Before saving user: " + email);
        // Initialize defaults, validate, etc.
        if (this.isDeleted == null) {
            this.isDeleted = false;
        }
    }
    
    // Called after INSERT
    @PostPersist
    private void postPersist() {
        System.out.println("User saved with ID: " + id);
        // Logging, send event, etc.
    }
    
    // Called before UPDATE
    @PreUpdate
    private void preUpdate() {
        System.out.println("Before updating user: " + email);
        // Validation, audit trail, etc.
    }
    
    // Called after UPDATE
    @PostUpdate
    private void postUpdate() {
        System.out.println("User updated: " + email);
        // Logging, cache invalidation, etc.
    }
    
    // Called before DELETE
    @PreRemove
    private void preRemove() {
        System.out.println("Before deleting user: " + email);
    }
    
    // Called after DELETE
    @PostRemove
    private void postRemove() {
        System.out.println("User deleted: " + email);
    }
}
```
 
#### 4.2 Lifecycle Sequence
 
```
1. User user = new User("alice@example.com");
   ↓
2. userRepository.save(user);
   ↓
3. @PrePersist called
   ↓
4. INSERT into database
   ↓
5. @PostPersist called
   ↓
6. Return saved user with ID
 
---
 
1. user.setEmail("alice2@example.com");
   ↓
2. userRepository.save(user);  // Call save again
   ↓
3. @PreUpdate called
   ↓
4. UPDATE database
   ↓
5. @PostUpdate called
   ↓
6. Return updated user
```
 
#### 4.3 Common Use Cases
 
```java
// Auto-populate audit fields
@PrePersist
private void prePersist() {
    this.createdAt = LocalDateTime.now();
    this.updatedAt = LocalDateTime.now();
}
 
@PreUpdate
private void preUpdate() {
    this.updatedAt = LocalDateTime.now();
}
 
// Validate state
@PrePersist
private void validateBeforeSave() {
    if (email == null || email.isBlank()) {
        throw new IllegalArgumentException("Email is required");
    }
}
 
// Logging
@PostPersist
private void logCreation() {
    logger.info("User created: {} at {}", email, createdAt);
}
```

---

### 5. Pagination
 
**Purpose:** Retrieve large datasets in pages to improve performance and UX
 
#### 5.1 Pageable Interface
 
```java
// Controller
@GetMapping("/users")
public ResponseEntity<Page<UserResponse>> listUsers(
    @RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "10") int size,
    @RequestParam(defaultValue = "createdAt,desc") String sort,
    Pageable pageable  // Spring auto-constructs from params
) {
    Page<User> users = userService.listUsers(pageable);
    return ResponseEntity.ok(users.map(UserResponse::from));
}
 
// Example requests:
GET /users?page=0&size=20&sort=createdAt,desc
GET /users?page=1&size=10
GET /users (uses defaults: page=0, size=20)
```
 
#### 5.2 Repository Query
 
```java
public interface UserRepository extends JpaRepository<User, Long> {
    
    // Return Page<User> for pagination
    Page<User> findByIsDeletedFalse(Pageable pageable);
    
    // Multiple fields sorting
    Page<User> findByRoleAndIsDeletedFalse(
        Role role,
        Pageable pageable
    );
}
 
// Service
@Transactional(readOnly = true)
public Page<UserResponse> listUsers(Pageable pageable) {
    return userRepository.findByIsDeletedFalse(pageable)
        .map(user -> new UserResponse(
            user.getId(),
            user.getEmail(),
            user.getCreatedAt()
        ));
}
```
 
#### 5.3 Page<T> vs Slice<T>
 
```java
// Page<T> - includes total count (heavier query)
Page<User> users = userRepository.findAll(pageable);
users.getTotalElements();  // Total records (runs COUNT query)
users.getTotalPages();     // Total pages
users.getNumber();         // Current page (0-indexed)
users.getSize();           // Page size
 
// Slice<T> - no total count (lighter query)
Slice<User> users = userRepository.findAllByIdGreaterThan(1L, pageable);
users.hasNext();           // Is there a next page?
users.hasPrevious();       // Is there a previous page?
// No total count calculation, faster for large datasets
```
 
#### 5.4 Response Format
 
```json
{
  "content": [
    {"id": 1, "email": "alice@example.com"},
    {"id": 2, "email": "bob@example.com"}
  ],
  "pageable": {
    "pageNumber": 0,
    "pageSize": 10,
    "sort": {
      "empty": false,
      "sorted": true
    }
  },
  "totalElements": 100,
  "totalPages": 10,
  "numberOfElements": 10,
  "first": true,
  "last": false,
  "empty": false
}
```

---

### 6. Custom Validators
 
**Purpose:** Implement complex validation logic beyond standard annotations
 
#### 6.1 Standard Validators (JPA/Spring)
 
```java
@Entity
public class User {
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Size(min = 5, max = 100, message = "Email must be 5-100 chars")
    private String email;
    
    @NotNull(message = "Role is required")
    @Enumerated(EnumType.STRING)
    private UserRole role;
    
    @Positive(message = "Age must be positive")
    @Min(18)
    @Max(120)
    private Integer age;
}
```
 
#### 6.2 Custom Validator - UniqueEmail
 
**Problem:** Need to validate email uniqueness at DB level
 
```java
// Step 1: Create custom annotation
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueEmailValidator.class)
@Documented
public @interface UniqueEmail {
    String message() default "Email already exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
 
// Step 2: Implement ConstraintValidator
@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public void initialize(UniqueEmail annotation) {
        // Initialize if needed
    }
    
    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null) {
            return true;  // Let @NotBlank handle null
        }
        
        boolean exists = userRepository.existsByEmailAndIsDeletedFalse(email);
        return !exists;  // Valid if email doesn't exist
    }
}
 
// Step 3: Use annotation on entity/DTO
@Entity
public class User {
    @UniqueEmail  // Custom validator
    @Email
    @NotBlank
    private String email;
}
```
 
#### 6.3 Custom Validator - ValidUserRole
 
```java
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidUserRoleValidator.class)
public @interface ValidUserRole {
    String message() default "Invalid user role";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
 
public class ValidUserRoleValidator implements ConstraintValidator<ValidUserRole, UserRole> {
    
    @Override
    public boolean isValid(UserRole role, ConstraintValidatorContext context) {
        if (role == null) {
            return true;
        }
        
        // Only ADMIN and USER allowed (not DELETED role)
        return role == UserRole.ADMIN || role == UserRole.USER;
    }
}
 
@Entity
public class User {
    @ValidUserRole
    private UserRole role;
}
```
 
#### 6.4 Nested Validation
 
```java
public record CreateUserRequest(
    @NotBlank
    @Email
    String email,
    
    @NotNull
    @Valid  // ← Validate nested object
    CreateAddressRequest address
) {}
 
public record CreateAddressRequest(
    @NotBlank
    String street,
    
    @NotBlank
    String city,
    
    @NotBlank
    String postalCode
) {}
 
// When CreateUserRequest validated via @Valid:
// 1. Email validated
// 2. Address object validated
// 3. All fields inside address validated
```

---
 
### 7. Propagation
 
**Purpose:** Control transaction behavior when methods call other methods
 
#### 7.1 Propagation Types
 
```java
@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private UserService userService;
    
    // REQUIRED (default) - Use current transaction or create new
    @Transactional(propagation = Propagation.REQUIRED)
    public void createOrder(Long userId, Order order) {
        userService.validateUser(userId);  // Uses same transaction
        orderRepository.save(order);
        // All changes committed together
    }
    
    // REQUIRES_NEW - Always create new transaction
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void logAudit(String action) {
        // If createOrder rolls back, audit log still saved
        // (separate transaction)
    }
    
    // SUPPORTS - Use transaction if exists, otherwise none
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Order getOrder(Long id) {
        // Can be called from transactional or non-transactional context
    }
    
    // MANDATORY - Must have transaction, throw error if none
    @Transactional(propagation = Propagation.MANDATORY)
    public void updateOrder(Long id, Order order) {
        // Must be called from within a transaction
    }
    
    // NOT_SUPPORTED - Run without transaction
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void generateReport() {
        // Read-only operation, no transaction overhead
    }
    
    // NEVER - Throw error if transaction exists
    @Transactional(propagation = Propagation.NEVER)
    public void testMethod() {
        // Should never be called from transaction
    }
    
    // NESTED - Create savepoint within current transaction
    @Transactional(propagation = Propagation.NESTED)
    public void saveOrder(Order order) {
        // Can rollback to savepoint without rolling back outer transaction
    }
}
```
 
#### 7.2 Common Scenarios
 
**Scenario 1: Audit logging should always save**
```java
@Transactional
public void createOrder(Order order) {
    orderRepository.save(order);
    logAudit("Order created");  // Should succeed even if order creation fails? NO
}
 
// Better: Log in separate transaction
@Transactional
public void createOrder(Order order) {
    orderRepository.save(order);
    logAuditAsync("Order created");  // Separate transaction via @Async/@REQUIRES_NEW
}
 
@Transactional(propagation = Propagation.REQUIRES_NEW)
public void logAuditAsync(String action) {
    auditRepository.save(new AuditLog(action));
}
```
 
**Scenario 2: Read-only doesn't need transaction**
```java
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public User getUser(Long id) {
    // No transaction overhead for read
    return userRepository.findById(id).get();
}
```

---

### 8. Dirty Checking & Persistence Context
 
**Purpose:** Understand how JPA tracks entity changes and persists them
 
#### 8.1 Persistence Context (L1 Cache)
 
```java
// Persistence context = session-level cache
// Tracks all entities loaded in current session
 
@Transactional
public void updateUser(Long id, String newEmail) {
    User user = userRepository.findById(id).get();  // Load from DB
    // user now in persistence context (managed state)
    
    user.setEmail(newEmail);  // Change tracked automatically
    
    // No explicit save() needed!
    userRepository.save(user);  // Redundant but safe
    
}  // @Transactional ends here → flush() & commit()
```
 
#### 8.2 Entity States
 
```
Transient → Managed → Detached → Removed
 
Transient: new User("alice@example.com")
           (not yet saved, not in persistence context)
 
Managed:   userRepository.findById(1L).get()
           (loaded from DB, tracked by JPA)
           Changes automatically flushed on commit
 
Detached:  User user = ...;
           entityManager.detach(user);
           OR session ends (outside @Transactional)
           (was managed, now not tracked)
 
Removed:   userRepository.deleteById(1L);
           (marked for deletion, flushed on commit)
```
 
#### 8.3 Dirty Checking
 
```java
@Transactional
public void updateUserDirtyChecking(Long id) {
    User user = userRepository.findById(id).get();  // 1 query: SELECT
    
    user.setEmail("newemail@example.com");  // Change tracked
    user.setName("New Name");               // Change tracked
    
}  // Transaction ends → flush()
   // 1 query: UPDATE user SET email=?, name=? WHERE id=?
   
// Total: 2 queries (1 SELECT, 1 UPDATE)
// No explicit userRepository.save() needed!
```
 
#### 8.4 merge() for Detached Entities
 
```java
@Transactional
public void updateDetachedUser(User detachedUser) {
    // detachedUser not in persistence context
    
    // Option 1: merge() re-attaches and loads fresh state
    User managedUser = entityManager.merge(detachedUser);
    managedUser.setEmail("newemail@example.com");
    // Changes tracked and flushed on commit
    
    // Option 2: Use repository.save()
    User savedUser = userRepository.save(detachedUser);
    // If detached: performs UPDATE
    // If new: performs INSERT
}
```
 
#### 8.5 flush() vs commit()
 
```java
@Transactional
public void flushExample() {
    User user = userRepository.findById(1L).get();
    user.setEmail("email@example.com");  // Tracked but not yet in DB
    
    entityManager.flush();  // Write changes to DB NOW (but not committed)
    // User can see changes in same session
    
    // ... more logic ...
    
}  // @Transactional ends → commit()
   // All changes persisted permanently
```
 
#### 8.6 LazyInitializationException Revisited
 
```java
// WRONG
public User getUser(Long id) {
    return userRepository.findById(id).get();  // No @Transactional
    // Session closes after method returns
}
 
// In controller
User user = getUser(1L);
List<Order> orders = user.getOrders();  // ERROR!
// Session is closed, can't load lazy orders
 
// CORRECT
@Transactional(readOnly = true)
public User getUser(Long id) {
    User user = userRepository.findById(id).get();
    user.getOrders().size();  // Force load while session open
    return user;  // Now it's safe to access in controller
}
 
// OR use JOIN FETCH
@Query("SELECT u FROM User u LEFT JOIN FETCH u.orders WHERE u.id = :id")
Optional<User> findByIdWithOrders(@Param("id") Long id);
```

---

## Spring TEST
- **`@ExtendWith`**: is used in JUnit 5 to register extensions (also known as "test instance post-processors"). When we use `@ExtendWith(SpringExtension.class)` at class level, we're essentially telling JUnit to enable Spring support for the test class.

- **`@ContextConfiguration`**: in Spring test framework is used to specify the locations of the configuration files that define the application context for the test. The Application context is loaded only once, and cached for all the test methods. `@ContextConfiguration(locations = "path")` - at class level.

- **`@DirtiesContext`**: is used to indicate that the ApplicationContext associated with a test is dirty and should be recreated before running a specific test method. When methodMode is set to BEFORE_METHOD, it indicates that the context should be marked as dirty and recreated before the execution of the test method.
  - `@DirtiesContext(methodMode = MethodMode.BEFORE_METHOD)`
  - `@DirtiesContext(methodMode = MethodMode.AFTER_METHOD)`
  - `@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)`
  - `@DirtiesContext(classMode = ClassMode.AFTER_CLASS)`
 
- **`@ActiveProfiles({"test"})`** is an annotation used to activate one or more profiles when running tests.
- **[Spring AOP](https://www.geeksforgeeks.org/advance-java/aspect-oriented-programming-aop-in-spring-framework/)**: It separates cross-cutting concerns like logging, security, transactions from the main business logic. Instead of adding them inside every class, AOP allows to write it once and apply it wherever needed.

---

