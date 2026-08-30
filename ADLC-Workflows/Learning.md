# Learning Roadmap

- **Java Developer**: [Java](https://github.com/kvinay7/interview-preparation/blob/main/ADLC-Workflows/Learning.md#java) + [DSA](https://github.com/kvinay7/interview-preparation/blob/main/DSA.md) + [LLD](https://github.com/ashishps1/awesome-low-level-design) + [ADLC](https://github.com/kvinay7/interview-preparation/blob/main/ADLC.md) + [STAR](https://github.com/ashishps1/awesome-behavioral-interviews)
- **FSD**: Java Developer + HLD + [GenAI](https://github.com/kvinay7/interview-preparation/blob/main/AI%20Engineering.md) + UI + Cloud

---

## Tech Stack

- **Java**: Basics, Collections, Streams, OOPs, Exceptions, Logging 
- **Spring**: Core, Boot, MVC, REST, OpenAPI, Testing, Security, AOP
- **Databases**: SQL, Database Design, Transactions, Indexing, JPA
- **AI**: Spring AI, RAG, Memory, Advisor, MCP, Agents, Evaluation 
- **UI**: HTML, CSS, JavaScript, Bootstrap, ReactJS
- **DevOps/Cloud**: Git, Linux, Docker, CI/CD, AWS

---

## JAVA

### A. [Basics](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#introduction) 
- [Variables](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#basics)
- [Data Types](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#variables-and-data-types)
- [Operators](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#operators)
- [Control Flow](https://www.baeldung.com/java-control-structures)
- [Standard I/O](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#standard-io)
- [Questions](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#conceptual-questions)

---

### B. [Collections](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#collections-framework) 
- [Array](https://github.com/kvinay7/DSA/blob/main/Java.md#section-3-arrays--array-methods)
- [String](https://github.com/kvinay7/DSA/blob/main/Java.md#section-4-string--stringbuilder)
- [List](https://github.com/kvinay7/DSA/blob/main/Java.md#arraylist-dynamic-array)
- [Set](https://github.com/kvinay7/DSA/blob/main/Java.md#hashset-unordered-no-duplicates)
- [Map](https://github.com/kvinay7/DSA/blob/main/Java.md#hashmap-key-value-pairs)
- [Stack](https://github.com/kvinay7/DSA/blob/main/Java.md#stack-lifo--last-in-first-out)
- [Queue](https://github.com/kvinay7/DSA/blob/main/Java.md#queue-fifo--first-in-first-out)
- [Heap](https://github.com/kvinay7/DSA/blob/main/Java.md#priorityqueue-min-heap-by-default)
- [Sorting](https://github.com/kvinay7/DSA/blob/main/Java.md#section-6-comparator--sorting)
- [Numerical](https://github.com/kvinay7/DSA/blob/main/Java.md#section-1-numerical--character-methods)
- [Faster I/O](https://github.com/kvinay7/DSA/blob/main/Java.md#fast-io-mandatory-for-interviews)
- [Java-8](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#imperative-vs-declarative)

---

### C. [OOP](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#object-oriented-programming-oop) 
- Classes & Objects
- Methods & Constructors
- Encapsulation 
- Inheritance
- Polymorphism
- Abstraction
- Access Modifiers
- Non-Access Modifiers
- Stack vs Heap memory
- Packages & Libraries
- Enums & Generics
- [Exception Handling](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#exception-handling)
- [Multithreading](https://github.com/kvinay7/interview-preparation/blob/main/OS.md)
- [Practice Problems](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#oop-practice)

---

## 🌱 SPRING (80% Complete → Add 3 Critical Sections)

### A. Spring Core ✅
- IoC (Inversion of Control)
- DI (Dependency Injection) — Constructor, Setter, Field
- Spring Beans (@Component, @Service, @Repository, @Bean)
- ApplicationContext vs BeanFactory
- Bean Lifecycle (instantiation, DI, init, ready, destroy)
- Bean Scopes (Singleton, Prototype, Request, Session)
- Autowiring (@Autowired, @Qualifier, @Primary, @Inject, @Resource)
- Configuration (XML, Java config with @Configuration, @ComponentScan)
- @Value, @PropertySource, environment variables

**Status:** Complete. Ready to use.

---

### B. Spring Boot ✅
- @SpringBootApplication
- Auto-configuration
- Starters (spring-boot-starter-web, spring-boot-starter-data-jpa, etc.)
- application.properties / application.yml
- Profiles (dev, test, prod)
- Embedded server (Tomcat)
- Project structure (Maven, src/main/java, src/main/resources, src/test/java)

**Status:** Complete. Ready to use.

---

### C. Spring MVC / REST APIs ✅
- HTTP Request/Response flow
- DispatcherServlet (front controller)
- HandlerMapping, HandlerAdapter
- @RestController vs @Controller
- Request Mapping (@RequestMapping, @GetMapping, @PostMapping, @PutMapping, @PatchMapping, @DeleteMapping)
- Path Variables (@PathVariable)
- Query Parameters (@RequestParam)
- Request Body (@RequestBody)
- ResponseEntity, HTTP status codes (200, 201, 204, 400, 401, 403, 404, 500)
- @ModelAttribute (form handling)
- View Resolver (for @Controller, not @RestController)

**Status:** Complete. Ready to use.

---

### D. Spring Data JPA ✅
- JPA/Hibernate concepts, ORM
- @Entity, @Table, @Id, @GeneratedValue, @Column
- JpaRepository interface
- CRUD operations
- Derived query methods (findByXxx, findAllByXxx)
- @Query (JPQL)
- @Modifying (updates/deletes)
- Pagination & Sorting (Pageable, Page<T>)
- Relationships (@OneToOne, @OneToMany, @ManyToOne, @ManyToMany)
  - Owning side, mappedBy
  - Cascade types (PERSIST, MERGE, REMOVE, DETACH, ALL)
  - Fetch types (LAZY, EAGER — LAZY preferred by default)
- Entity lifecycle

**Status:** Complete. Ready to use.

---

### E. Testing ✅
- JUnit 5 (@Test, assertions, lifecycle)
- Mockito (@Mock, @InjectMocks, when/thenReturn, verify)
- Unit testing (service layer)
- @SpringBootTest (integration testing)
- MockMvc (REST endpoint testing)
- @ExtendWith(SpringExtension.class)
- @ContextConfiguration
- @DirtiesContext
- @ActiveProfiles
- Testcontainers basics

**Status:** Complete. Ready to use.

---

### F. AOP (Aspect-Oriented Programming) ✅ (Brief)
- Cross-cutting concerns (logging, security, transactions)
- Separation of concerns
- Mentioned with reference links

**Status:** Brief coverage. Sufficient for SDE-1 (detailed code not required).

---

### G. 🔴 CRITICAL MISSING — Must Add Before Spring Projects

#### 1. **DTOs & Validation** ❌ Missing

**What to add:**
- DTO Pattern (Request DTO, Response DTO)
- DTO vs Entity (why separate)
- Bean Validation annotations (@Valid, @Validated)
- Common annotations (@NotNull, @NotBlank, @NotEmpty, @Email, @Size, @Min, @Max, @Pattern)
- Validation error handling (MethodArgumentNotValidException)
- Custom validation (@Constraint, @Documented)
- Code examples with @RestController + @Valid

**Importance:** CRITICAL — used in every Spring REST API project.

**Example needed:**
```java
@Data
public class UserDTO {
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50)
    private String name;
    
    @Email(message = "Email must be valid")
    private String email;
    
    @Min(value = 18, message = "Age must be >= 18")
    private Integer age;
}

@PostMapping("/users")
public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO dto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(dto));
}
```

---

#### 2. **Global Exception Handling** ❌ Missing

**What to add:**
- @ControllerAdvice
- @RestControllerAdvice
- @ExceptionHandler (specific exception handling)
- Consistent error response design (ErrorResponse class)
- Handling MethodArgumentNotValidException (validation errors)
- Handling ResourceNotFoundException (custom exceptions)
- Error codes, messages, timestamps
- HTTP status code mapping

**Importance:** CRITICAL — every REST API needs centralized exception handling. Interview standard.

**Example needed:**
```java
@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(
            "NOT_FOUND",
            ex.getMessage(),
            System.currentTimeMillis()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationError(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getFieldErrors().stream()
            .map(e -> e.getField() + ": " + e.getDefaultMessage())
            .collect(Collectors.joining(", "));
        ErrorResponse error = new ErrorResponse("VALIDATION_ERROR", message, System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String code;
    private String message;
    private Long timestamp;
}
```

---

#### 3. **Transactions** ❌ Missing

**What to add:**
- @Transactional annotation
- ACID properties (Atomicity, Consistency, Isolation, Durability)
- Rollback (automatic on RuntimeException)
- Transaction boundaries
- Propagation modes (REQUIRED, REQUIRES_NEW, NESTED, SUPPORTS, NOT_SUPPORTED, NEVER, MANDATORY)
- Isolation levels (READ_UNCOMMITTED, READ_COMMITTED, REPEATABLE_READ, SERIALIZABLE)
- Declarative vs Programmatic transactions
- Best practices (apply at Service layer, not Repository)

**Importance:** CRITICAL — every service modifying data needs @Transactional. Interview standard.

**Example needed:**
```java
@Service
@Transactional
public class OrderService {
    
    private final OrderRepository orderRepo;
    private final UserRepository userRepo;
    
    @Transactional(rollbackFor = Exception.class)
    public Order placeOrder(Long userId, OrderDTO dto) {
        User user = userRepo.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        
        Order order = new Order();
        order.setUser(user);
        order.setOrderNumber(dto.getOrderNumber());
        
        return orderRepo.save(order);
        // Automatic commit on success, rollback on exception
    }
    
    @Transactional(readOnly = true)
    public Order getOrder(Long id) {
        return orderRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
    }
}
```

---

### H. Bonus Sections (Brief, Can Defer)
- Spring Security basics (Authentication, Authorization, Password hashing, JWT basics, RBAC)
- API Documentation (OpenAPI, Swagger UI)
- Spring Boot Actuator (Health checks, metrics)
- Logging (SLF4J, log levels, structured logging, MDC)

**Status:** Mentioned. Sufficient for SDE-1 awareness. Depth → SDE-2.

---

## 🏗️ LLD (Complete Syllabus)

### A. OOP Design Fundamentals ✅
- Encapsulation, Abstraction, Inheritance, Polymorphism
- Composition vs Inheritance
- Interfaces as contracts
- Dependency Injection (DI)
- Coupling & Cohesion (tight vs loose, low vs high)

**Status:** Complete.

---

### B. SOLID Principles ✅
- S: Single Responsibility Principle
- O: Open/Closed Principle
- L: Liskov Substitution Principle
- I: Interface Segregation Principle
- D: Dependency Inversion Principle

**With code examples for each.**

**Status:** Complete.

---

### C. UML (Class Diagrams) ✅
- Class boxes (attributes, methods)
- Relationships:
  - Association (arrow, dependency)
  - Aggregation (hollow diamond, loose ownership)
  - Composition (filled diamond, tight ownership)
  - Inheritance (arrow with empty triangle)
- Multiplicity (1:1, 1:N, N:M)
- Example class diagrams (E-Commerce, Library)

**Status:** Complete.

---

### D. Design Patterns ✅
**Learn Deeply (6 core patterns):**
1. **Singleton** — one instance globally
2. **Factory** — create objects without hardcoding classes
3. **Builder** — construct complex objects step-by-step
4. **Strategy** — encapsulate interchangeable algorithms
5. **Observer** — notify multiple objects on state change
6. **State** — alter behavior based on object state

**Understand Well (5 secondary patterns):**
7. Adapter — make incompatible interfaces compatible
8. Decorator — add behavior dynamically
9. Facade — simplify complex subsystem
10. Command — encapsulate operations as objects
11. Template Method — define algorithm skeleton

**With code examples for each.**

**Status:** Complete.

---

### E. Domain Modeling ✅
- Identify Entities (things with identity)
- Identify Value Objects (immutable, represent values)
- Define Relationships (1:1, 1:N, N:M)
- Assign Responsibilities (which class owns which method)
- Business Rules & Constraints
- Aggregates (basics)

**With E-Commerce example.**

**Status:** Complete.

---

### F. LLD Process ✅
**Step-by-step for every problem:**
1. Understand requirements (functional, constraints, assumptions)
2. Identify use cases (user actions, system responses)
3. Identify core entities (User, Order, Product, Payment)
4. Define relationships (1:1, 1:N, N:N)
5. Assign responsibilities (SRP)
6. Apply SOLID principles
7. Select design patterns (only if they solve a real problem)
8. Create class diagram (UML)
9. Write clean Java code (implementation)
10. Test (business scenarios)

**Status:** Complete.

---

### G. Practice Problems ✅
**Level 1 — Java Syntax (5 problems):**
1. Student Grade Management System
2. Employee Salary Calculator
3. Inventory Stock Tracker
4. Library Book Management
5. Bank Account Operations

**Topics:** OOP, Collections, Streams, Exceptions, Java-8

**Status:** Defined. Ready to code.

---

**Level 2 — Spring + LLD (3 problems):**
1. E-Commerce Order Management System
2. User Management & Authentication API
3. Task Management & Notification System

**Topics:** REST APIs, JPA, DTOs, Validation, Exception Handling, Services, Transactions, Testing

**Status:** Defined. Ready to code.

---

**Level 3 — Core LLD Systems (5 problems):**
1. Parking Lot System
2. Library Management System
3. Vending Machine
4. Restaurant Ordering System
5. Movie Ticket Booking System

**Topics:** Domain Modeling, SOLID, Design Patterns, State Machines, Notifications

**Status:** Defined. Ready to code.

---

## 📊 SUMMARY TABLE

| Component | Status | Action |
|-----------|--------|--------|
| **Java Basics** | ✅ Complete | Use as is |
| **Java OOPs** | ✅ Complete | Use as is |
| **Java Collections** | ✅ Complete | Use as is |
| **Java Exceptions** | ✅ Complete | Use as is |
| **Java-8** | ✅ Complete | Use as is |
| **Java Generics** | ✅ Complete | Use as is |
| **Concurrency (Java)** | ⚠️ Missing | Defer to SDE-2 |
| **JVM Memory (Java)** | ⚠️ Missing | Defer to SDE-2 |
| **Spring Core** | ✅ Complete | Use as is |
| **Spring Boot** | ✅ Complete | Use as is |
| **Spring MVC / REST** | ✅ Complete | Use as is |
| **Spring JPA** | ✅ Complete | Use as is |
| **Spring Testing** | ✅ Complete | Use as is |
| **DTOs & Validation** | 🔴 **MISSING** | **ADD before 3 Spring projects** |
| **Global Exception Handling** | 🔴 **MISSING** | **ADD before 3 Spring projects** |
| **Transactions** | 🔴 **MISSING** | **ADD before 3 Spring projects** |
| **Spring Security** | ⚠️ Brief | Sufficient for SDE-1 |
| **Spring AOP** | ⚠️ Brief | Sufficient for SDE-1 |
| **LLD (SOLID, Patterns, UML)** | ✅ Complete | Use as is |
| **LLD Practice (13 problems)** | ✅ Complete | Ready to code |

---

## 🎯 EXECUTION ROADMAP

### **Phase 1: Add 3 Missing Sections to Spring Notes** (1 hour)
- DTOs & Validation (with code examples)
- Global Exception Handling (with code examples)
- Transactions (with code examples)

### **Phase 2: Code 5 Java Problems** (1–2 weeks)
- Focus: OOP, Collections, Exceptions, Java-8
- No Spring needed yet
- Apply: Basics + Collections + OOPs + Exceptions syllabus

### **Phase 3: Learn Spring Concepts** (1 week)
- Core, Boot, MVC, REST, JPA, Testing
- Practice: Small Spring Boot CRUD app
- Reference: Updated Spring notes with 3 new sections

### **Phase 4: Code 3 Spring Projects** (2–3 weeks)
- E-Commerce Orders API
- User Management & Auth API
- Task Management API
- Apply: All Spring concepts + 3 new sections (DTOs, Validation, Exception Handling, Transactions)

### **Phase 5: Learn LLD** (1 week)
- SOLID, UML, Design Patterns (6 core)
- Domain Modeling
- LLD Process (10 steps)

### **Phase 6: Code 5 LLD System Design Problems** (2–3 weeks)
- Parking Lot, Library, Vending Machine, Restaurant, Movie Tickets
- Apply: SOLID, Patterns, Domain Modeling, UML

---

## ✅ FINAL VERDICT

**Java:** Complete. Ready to use.

**Spring:** 80% complete. **Add 3 critical sections** (DTOs, Exception Handling, Transactions) before coding projects.

**LLD:** Complete. Ready to use.

**13 Problems:** Complete syllabus defined. Ready to execute.

---

**Next action:** Add 3 Spring sections, then execute Phase 2 (5 Java problems). ✅
---

## JAVA Learning Order

### SDE-1 Now (Before Building Features)

**Week 1-2: Fundamentals**
1. ✅ **Basics** (syntax, variables, operators, control flow)
   - Data types, primitives, wrappers, type casting
   - if-else, loops (for, while), switch

2. ✅ **OOP (Object-Oriented Programming)** (classes, objects, inheritance, polymorphism)
   - Classes, objects, constructors
   - Inheritance (extends), interfaces (implements)
   - Encapsulation (public, private, protected)
   - Polymorphism (method overriding, overloading)

3. ✅ **Exceptions**
   - try-catch-finally
   - Custom exceptions (extends Exception, RuntimeException)
   - Throws clause

4. ✅ **Collections Framework**
   - List, Set, Map, Queue
   - ArrayList, HashMap, HashSet, LinkedList
   - Iteration (for-each loop)

5. ✅ **Generics**
   - Generic types: `List<String>`, `Map<String, Integer>`
   - Generic methods, bounded types
   - Wildcards (`? extends T`, `? super T`)

6. ✅ **Java 8 Features**
   - Lambda expressions: `(x, y) -> x + y`
   - Method references: `ClassName::methodName`
   - Functional interfaces: `@FunctionalInterface`

7. ✅ **Stream API**
   - `stream()`, `filter()`, `map()`, `reduce()`
   - `Collectors.toList()`, `Collectors.groupingBy()`
   - Optional: `Optional<T>`, `.orElse()`, `.orElseThrow()`

8. ✅ **Logging**
   - SLF4J, log4j2
   - Log levels: DEBUG, INFO, WARN, ERROR
   - MDC (Mapped Diagnostic Context) basics

---

### SDE-2/System Design Later

**Concurrency & Multithreading**
- Thread basics, Runnable, Thread class
- Synchronization, volatile, synchronized blocks
- Thread-safe collections: ConcurrentHashMap, CopyOnWriteArrayList
- Locks: ReentrantLock, ReadWriteLock
- ExecutorService, ThreadPool
- Time: 10 days (~50 hours)

**JVM Internals**
- Heap, stack, memory layout
- Garbage collection (GC algorithms, tuning)
- JVM profiling, monitoring tools
- Performance optimization
- Time: 5 days (~25 hours)

**Reflection & Annotations**
- Class.forName(), Method invocation, Reflection API
- Custom annotations, @Retention, @Target
- Annotation processing
- Design Patterns
- Time: 3 days (~15 hours)

**Advanced Features**
- Records, sealed classes, pattern matching
- Var type inference (Java 10+)
- Text blocks (Java 13+)
- Time: 2 days (~10 hours)

---

## SPRING Learning Order

### SDE-1 Now (Before Building Features)

**Week 1: Core Spring Concepts**

1. ✅ **Spring Core (IoC & DI)**
   - Inversion of Control (IoC) principle
   - Dependency Injection (DI) via constructors, setters, fields
   - Spring Beans: @Bean, @Component
   - ApplicationContext, BeanFactory

2. ✅ **Spring Boot Auto-config**
   - @SpringBootApplication
   - application.properties / application.yml
   - @Value, @ConfigurationProperties
   - Environment variables, profiles (dev, test, prod)

**Week 2: Web Layer**

3. ✅ **Spring MVC**
   - @RestController, @Controller
   - @RequestMapping, @GetMapping, @PostMapping, @PutMapping, @DeleteMapping
   - @PathVariable, @RequestParam, @RequestBody
   - ResponseEntity, HTTP status codes

4. ✅ **Request/Response Handling**
   - RequestBody deserialization (JSON → DTO)
   - ResponseBody serialization (object → JSON)
   - Data validation: @Valid, @Validated
   - Validation annotations: @NotBlank, @Email, @Size, @Min, @Max, @Pattern

5. ✅ **HTTP Status Codes & Error Handling**
   - 200 OK, 201 Created, 204 No Content
   - 400 Bad Request, 404 Not Found, 500 Internal Server Error
   - @ControllerAdvice, @ExceptionHandler
   - GlobalExceptionHandler

**Week 3: Data Access**

6. ✅ **Spring Data JPA**
   - JpaRepository interface, extending it
   - Derived query methods: `findByXxx`, `findAllByXxx`
   - @Query with JPQL: `@Query("SELECT u FROM User u WHERE ...")`
   - @Modifying for UPDATE/DELETE
   - Pagination: Pageable, Page<T>

7. ✅ **JPA Entity Mapping**
   - @Entity, @Table, @Id, @GeneratedValue
   - @Column constraints: nullable, unique, length
   - @Temporal, @CreationTimestamp, @UpdateTimestamp
   - @OneToMany, @ManyToOne, @OneToOne, @ManyToMany
   - Cascade, FetchType (LAZY, EAGER), orphanRemoval

8. ✅ **SQL Basics**
   - SELECT, INSERT, UPDATE, DELETE
   - WHERE, ORDER BY, LIMIT, OFFSET
   - JOIN (INNER, LEFT, RIGHT)
   - GROUP BY, aggregate functions (COUNT, SUM, AVG, MAX, MIN)

**Week 4: Testing & Configuration**

9. ✅ **Testing Framework**
   - JUnit 5, @Test, assertions
   - Mockito: @Mock, @InjectMocks, verify()
   - @SpringBootTest (full context)
   - MockMvc for REST endpoint testing
   - Testcontainers: @Testcontainers, @Container
   - PostgreSQL in tests (not H2)

10. ✅ **Configuration**
    - @Configuration, @Bean methods
    - SecurityFilterChain (basic setup)
    - CorsConfigurationSource
    - RestTemplate or WebClient (HTTP client)

11. ✅ **Swagger/OpenAPI**
    - @Operation, @ApiResponse annotations
    - Swagger UI for API documentation

---

### SDE-2/System Design Later

**Spring Security (Deep)**
- Authentication & Authorization
- SecurityContext, Authentication, Principal
- Password encoding, credential management
- JWT token validation in filters
- Role-based access control (RBAC)
- BOLA (Break Object-Level Access) prevention
- OAuth2, OIDC
- Time: 10 days (~50 hours)

**Spring Data (Advanced)**
- Entity graphs, lazy loading optimization
- Criteria API, QueryDSL
- Custom repositories, @Query optimization
- Named queries, stored procedures
- Batch processing, bulk operations
- Time: 5 days (~25 hours)

**Spring Transactions (Deep)**
- @Transactional isolation levels, propagation
- Dirty checking, persistence context
- Transaction rollback scenarios
- Optimistic vs pessimistic locking
- Time: 3 days (~15 hours)

**Spring Cloud (Microservices)**
- Service discovery (Eureka)
- Load balancing (Ribbon)
- Circuit breaker (Resilience4j)
- API Gateway, service-to-service communication
- Time: 5 days (~25 hours)

**Spring WebFlux (Reactive)**
- Project Reactor, Mono, Flux
- Non-blocking I/O, async streams
- Reactive repositories
- Time: 3 days (~15 hours)

**Spring Batch**
- Job configuration, step execution
- ItemReader, ItemProcessor, ItemWriter
- Large-scale data processing
- Time: 2 days (~10 hours)

**Spring Integration**
- Message-driven architecture, EIP patterns
- Channels, gateways, message routing
- Time: 2 days (~10 hours)

**AOP (Aspect-Oriented Programming)**
- @Aspect, @Pointcut, @Around, @Before, @After
- Cross-cutting concerns (logging, metrics, caching)
- Time: 2 days (~10 hours)

**Spring Cache**
- @Cacheable, @CacheEvict, @CachePut
- Cache invalidation strategy
- Time: 1 day (~5 hours)

**Logging & Monitoring**
- SLF4J + MDC (deep)
- Structured logging, JSON logs
- Micrometer metrics, custom metrics
- Health checks, actuator endpoints
- Time: 2 days (~10 hours)

---

## How to Use This Learning Order

1. **Read each topic** in order (use Java docs, Spring docs)
2. **Code along** with examples
3. **Build features** simultaneously using DEVELOPMENT_FRAMEWORK.md
4. **Test knowledge** with unit/integration tests

