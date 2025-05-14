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

  - **Autowire with `@Autowired` Annotation (Java-based Configuration)**: The `@Autowired` annotation can be applied to fields, constructors, or setter methods to automatically inject the required dependency. By default true and can't apply for static fields or methods. `@Inject` is part of Java’s standard dependency injection mechanism (JSR-330).

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
    @Bean(initMethod = "init", destroyMethod = "cleanup")
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

## Project Setup with Github and AWS

### **Step 1: Spring Boot Project Setup in IntelliJ IDEA**

#### 1.1 **Create a Spring Boot Project using Maven**

1. **Open IntelliJ IDEA**.

2. Select **File** → **New** → **Project**.

3. In the **New Project** wizard:

   * Choose **Spring Initializr** (for a Spring Boot project).
   * Select **Maven** as the build tool.
   * Choose **Java** as the language.
   * Choose the **Spring Boot version** (e.g., `2.7.x`).
   * Set the **Group** (e.g., `com.example`) and **Artifact** (e.g., `springboot-demo`).
   * Select dependencies such as **Spring Web**, **Spring Boot DevTools**, and **Spring Boot Actuator** (you can customize this as needed).

4. Click **Finish**, and IntelliJ will generate the project with `pom.xml` and the necessary Spring Boot configuration.

#### 1.2 **Project Structure Overview**:

After creating the project, the structure should look like this:

```text
springboot-demo/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── springbootdemo/
│   │   │               └── SpringbootDemoApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── springbootdemo/
│                       └── SpringbootDemoApplicationTests.java
├── pom.xml
```

#### 1.3 **Test Your Application Locally**

1. Open the `SpringbootDemoApplication.java` file, which contains the `@SpringBootApplication` annotation and a `main` method.
2. Run the application via **Run** → **Run 'SpringbootDemoApplication'** in IntelliJ.
3. Open your browser and go to `http://localhost:8080`. You should see a default Spring Boot page or API response.

---

### **Step 2: Push the Project to GitHub**

#### 2.1 **Create a GitHub Repository**

1. Go to [GitHub](https://github.com) and create a **new repository** (e.g., `springboot-demo`).
2. Do not initialize the repository with a README or `.gitignore` because we'll use IntelliJ IDEA's built-in Git integration.

#### 2.2 **Push Code from IntelliJ to GitHub**

1. Open **Terminal** in IntelliJ IDEA (located at the bottom).
2. Run the following commands to initialize Git, add the remote, and push:

   ```bash
   git init
   git remote add origin https://github.com/yourusername/springboot-demo.git
   git add .
   git commit -m "Initial commit"
   git push -u origin main
   ```

   This pushes the code to GitHub, linking your IntelliJ IDEA project to the repository.

---

### **Step 3: Set Up CI/CD with GitHub Actions**

#### 3.1 **Create GitHub Actions Workflow**

1. In your GitHub repository, create the following folder structure:

   ```
   .github/
   └── workflows/
       └── ci-cd.yml
   ```

2. Inside the `ci-cd.yml` file, add the following YAML configuration for building and deploying the Spring Boot app to **AWS Elastic Beanstalk**:

   ```yaml
   name: Build and Deploy Spring Boot to AWS Elastic Beanstalk

   on:
     push:
       branches:
         - main  # Trigger on pushes to the main branch

   jobs:
     build-and-deploy:
       runs-on: ubuntu-latest

       steps:
         # Checkout the code
         - name: Checkout code
           uses: actions/checkout@v3

         # Set up Java 17
         - name: Set up Java 17
           uses: actions/setup-java@v3
           with:
             java-version: '17'
             distribution: 'temurin'

         # Build with Maven
         - name: Build with Maven
           run: ./mvnw clean package --no-transfer-progress

         # Install AWS Elastic Beanstalk CLI
         - name: Install EB CLI
           run: |
             python3 -m pip install --upgrade pip
             pip3 install awsebcli

         # Deploy to AWS Elastic Beanstalk
         - name: Deploy to AWS Elastic Beanstalk
           env:
             AWS_ACCESS_KEY_ID: ${{ secrets.AWS_ACCESS_KEY_ID }}
             AWS_SECRET_ACCESS_KEY: ${{ secrets.AWS_SECRET_ACCESS_KEY }}
             AWS_REGION: us-east-1  # Your AWS region
           run: |
             eb init springboot-demo --platform java-17 --region $AWS_REGION
             eb deploy springboot-env
   ```

#### 3.2 **Add AWS Credentials as GitHub Secrets**

For the **GitHub Actions** to deploy to **AWS Elastic Beanstalk**, you need to set up AWS credentials securely.

1. Go to **Settings** in your GitHub repository.
2. Under the **Secrets** section, add two new repository secrets:

   * `AWS_ACCESS_KEY_ID`
   * `AWS_SECRET_ACCESS_KEY`

These secrets allow GitHub Actions to authenticate to AWS.

#### 3.3 **Push the Workflow File to GitHub**

Once you've added the `ci-cd.yml` file and set up AWS secrets, **push** the changes to GitHub:

```bash
git add .
git commit -m "Add GitHub Actions CI/CD workflow"
git push origin main
```

This will trigger the **GitHub Actions** pipeline to build and deploy your application.

---

### **Step 4: Deploy to AWS Elastic Beanstalk**

#### 4.1 **Create an AWS Elastic Beanstalk Environment**

1. Log in to the **AWS Management Console** and navigate to **Elastic Beanstalk**.
2. Click **Create a new application**.

   * Set the **Application Name** (e.g., `springboot-demo`).
   * Set **Platform** as **Java** (ensure it's Java 17).
   * Set **Region** where you want to deploy your app (e.g., **US East (N. Virginia)**).
3. Once the application is created, click **Create environment** and choose **Web server environment**.
4. Follow the prompts to create the environment.

#### 4.2 **Configure EB CLI for Deployment**

The GitHub Actions workflow automatically handles the EB CLI installation and deployment for you, so **no manual steps are needed** here, but you can always check the status of your Elastic Beanstalk environment.

* The **Elastic Beanstalk environment URL** will be available after deployment is complete (e.g., `http://springboot-demo.us-east-1.elasticbeanstalk.com`).

---

### **Step 5: Monitor the GitHub Actions Workflow**

1. After pushing the changes, go to your GitHub repository's **Actions** tab.
2. You will see the workflow running.
3. Monitor each step of the workflow (checkout, build, install dependencies, deploy).
4. If the build and deploy are successful, you’ll see the logs for each action. You can click into each step to see more details.

#### 5.1 **Check AWS Elastic Beanstalk for Your Application**:

Once the GitHub Action completes, visit the **Elastic Beanstalk URL** to see your application running live.     

---

## Spring ORM:
Spring ORM (Object-Relational Mapping) is a module of the Spring Framework that simplifies the integration of ORM frameworks such as JPA and Hibernate with Spring. It provides support for working with relational databases using ORM tools while managing transactions and resources efficiently.

### 1. **Integration with ORM Frameworks**
- **Java Persistence API (JPA)**: A standard API for ORM.
- **Hibernate**: A widely used ORM framework. In Spring Boot, Hibernate is the default implementation of JPA. Based on configs, spring boot will automatically create the beans such as DataSource, EntityManager, ...

### 2. **Spring ORM with Hibernate**: [JDBC](https://github.com/RameshMF/JDBC-Tutorial), [Spring JPA](https://github.com/darbyluv2code/spring-boot-3-spring-6-hibernate-for-beginners/tree/main/03-spring-boot-hibernate-jpa-crud/08-cruddemo-create-db-tables-automatically), [Data JPA](https://www.javaguides.net/p/spring-data-jpa-tutorial.html)
```java
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.example")
public class AppConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
        dataSource.setUsername("root");
        dataSource.setPassword("password");
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.example.models");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory().getObject());
        return txManager;
    }

    private Properties hibernateProperties() {
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
- **Request Handling**: Delegates requests to appropriate handlers (controllers).
- **Key Tasks**:
  - Receives HTTP requests.
  - Maps requests to the corresponding controller based on configurations.
  - Selects the appropriate view for the response.

### 3. **Handler Mapping**
- Responsible for mapping incoming HTTP requests to the appropriate handler methods in controllers.
- Examples of handler mappings: `@RequestMapping` or `@GetMapping`.
    
### 4. **Controller**
- Annotated with `@Controller` or `@RestController` to define web request handlers.
- Defines handler methods to process incoming HTTP requests.
- Example:
  ```java
  @Controller
  public class MyController {
      @GetMapping("/welcome")
      public String showWelcomePage() {
          return "welcome"; // View name
      }
  }
  ```

### 5. **View Resolver**
- Responsible for resolving the logical view name returned by a controller into an actual view.
- Example:
  - **InternalResourceViewResolver** maps logical view names to JSP files in a specific directory.
  ```java
  @Bean
  public InternalResourceViewResolver viewResolver() {
      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
      resolver.setPrefix("/WEB-INF/views/");
      resolver.setSuffix(".jsp");
      return resolver;
  }
  ```

### 6. **Model and ModelMap**
- Used to pass data from controllers to the view.
- `Model` or `ModelMap` objects allow adding attributes:
  ```java
  @GetMapping("/greet")
  public String greet(Model model) {
      model.addAttribute("message", "Hello, Spring MVC!");
      return "greet"; // Logical view name
  }
  ```
  
### 7. **Interceptors**
- Allow pre- and post-processing of requests.
- Configure interceptors by implementing `HandlerInterceptor` or extending `HandlerInterceptorAdapter`.

### 8. **Spring MVC Configuration**
- Configured using:
  - **XML-based**: Configuration in `web.xml` and Spring beans in XML files.
  - **Java-based**: Using `@Configuration` and `@EnableWebMvc`.

### 9. **Annotations in Spring MVC**
- **@Controller**: Marks a class as a web controller.
- **@RequestMapping**: Maps web requests to handler methods or classes.
- **@GetMapping, @PostMapping, @PutMapping, @DeleteMapping**: Shortcut annotations for HTTP methods.
- **@RestController**: Combines `@Controller` and `@ResponseBody`. [Example](https://github.com/darbyluv2code/spring-boot-3-spring-6-hibernate-for-beginners/tree/main/04-spring-boot-rest-crud/14-spring-boot-rest-crud-employee-with-spring-data-jpa)
- **@ResponseBody**: Directly returns data (e.g., JSON or XML) instead of a view.

### 10. **Request and Response Handling** - [Example](https://github.com/darbyluv2code/spring-boot-3-spring-6-hibernate-for-beginners/tree/main/07-spring-boot-spring-mvc-crud/04-02-thymeleaf-demo-employees-delete-alternate-solution-post-all-data)
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

### 11. **Form Handling**
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

### 12. **Exception Handling**
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

