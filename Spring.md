# Spring Framework
The Spring Framework is a comprehensive and modular framework for building Java-based enterprise applications. It's designed to simplify development by providing a wide range of features, making it one of the most popular frameworks in the Java ecosystem.

## [Spring Core](https://www.udemy.com/course/spring-certified-tutorial/)
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

## Spring TEST
- **`@ExtendWith`**: is used in JUnit 5 to register extensions (also known as "test instance post-processors"). When we use `@ExtendWith(SpringExtension.class)` at class level, we're essentially telling JUnit to enable Spring support for the test class.

- **`@ContextConfiguration`**: in Spring test framework is used to specify the locations of the configuration files that define the application context for the test. The Application context is loaded only once, and cached for all the test methods. `@ContextConfiguration(locations = "path")` - at class level.

- **`@DirtiesContext`**: is used to indicate that the ApplicationContext associated with a test is dirty and should be recreated before running a specific test method. When methodMode is set to BEFORE_METHOD, it indicates that the context should be marked as dirty and recreated before the execution of the test method.
  - `@DirtiesContext(methodMode = MethodMode.BEFORE_METHOD)`
  - `@DirtiesContext(methodMode = MethodMode.AFTER_METHOD)`
  - `@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)`
  - `@DirtiesContext(classMode = ClassMode.AFTER_CLASS)`
 
- **`@ActiveProfiles({"test"})`** is an annotation used to activate one or more profiles when running tests. 
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

### Core Annotations
  - **`@SpringBootApplication`**: Main entry point for a Spring Boot application. Combines `@EnableAutoConfiguration`, `@ComponentScan` and `@Configuration`.
  - **`@EnableAutoConfiguration`**: Enables Spring Boot’s auto-configuration mechanism.
  - **`@ComponentScan`**: Enables component scanning for `@Component`, `@Service`, etc.
  - **`@Configuration`**: Marks the class as a source of bean definitions.
  - **`@Bean`**: Used inside a `@Configuration` class to define a bean manually.
  - **`@Component`**: Generic stereotype for any Spring-managed component (bean).
  - **`@Scope`**: Specifies the bean scope of a component.
  - **`@Service`**: Specialization of `@Component` for service layer classes.
  - **`@Repository`**: Specialization of `@Component` for DAO (data access) layer classes.
  - **`@Controller`**: Marks a class as a Spring MVC controller (typically returns views).
  - **`@RestController`**: Combination of `@Controller` and `@ResponseBody` (returns data as JSON/XML).
  - **`@Autowired`**: Automatically injects dependencies by type.
  - **`@Qualifier`**: Used alongside `@Autowired` to specify which bean to inject when multiple beans of the same type exist.
  - **`@Primary`**: Marks a bean as primary candidate when multiple beans match for injection.
  - **`@Value`**: Injects values into fields from application properties or environment.
  - **`@PropertySource`**: Load custom property files
  - **`@ConfigurationProperties`**: Bind groups of related properties into a POJO
  - **`@PostConstruct`**: Marks a method to be executed after the bean has been created and dependency injection is done.
  - **`@PreDestroy`**: Marks a method to be executed before the bean is removed from the context.
  - **[Spring AOP](https://www.geeksforgeeks.org/advance-java/aspect-oriented-programming-aop-in-spring-framework/)**: It separates cross-cutting concerns like logging, security, transactions from the main business logic. Instead of adding them inside every class, AOP allows to write it once and apply it wherever needed.
---

## Spring ORM:
Spring ORM (Object-Relational Mapping) is a module of the Spring Framework that simplifies the integration of ORM frameworks such as JPA and Hibernate with Spring. It provides support for working with relational databases using ORM tools while managing transactions and resources efficiently.

### 1. **Integration with ORM Frameworks**
- **Java Persistence API (JPA)**: A standard API for ORM.
- **Hibernate**: A widely used ORM framework. In Spring Boot, Hibernate is the default implementation of JPA. Based on configs, spring boot will automatically create the beans such as DataSource, EntityManager, ...

### 2. **Spring ORM with Hibernate**: [DBMS](https://github.com/kvinay7/interview-preparation/blob/main/DBMS.md), [JDBC](https://github.com/RameshMF/JDBC-Tutorial), [Spring JPA](https://github.com/darbyluv2code/spring-boot-3-spring-6-hibernate-for-beginners/tree/main/03-spring-boot-hibernate-jpa-crud/08-cruddemo-create-db-tables-automatically), [Data JPA](https://www.javaguides.net/p/spring-data-jpa-tutorial.html)
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

## Spring MVC
Spring MVC (Model-View-Controller) is a powerful framework within the Spring ecosystem designed to build robust and scalable web applications.

### 1. **Model-View-Controller (MVC) Pattern**
- **Model**: Represents the application's data and business logic. It is often backed by service and persistence layers.
- **View**: The presentation layer that displays data from the model to the user. It can use technologies like JSP, Thymeleaf, or other templating engines.
- **Controller**: Handles user input, processes requests, interacts with the model, and determines which view to render.

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

