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

### B. [OOP](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#object-oriented-programming-oop) 
- [Classes & Objects](https://github.com/ashishps1/awesome-low-level-design/tree/main/oop/java/classesandobjects)
- [Enums](https://github.com/ashishps1/awesome-low-level-design/blob/main/README.md#-oop-fundamentals)
- [Encapsulation](https://github.com/ashishps1/awesome-low-level-design/tree/main/oop/java/encapsulation) 
- [Inheritance](https://github.com/ashishps1/awesome-low-level-design/tree/main/oop/java/inheritance)
- [Polymorphism](https://github.com/ashishps1/awesome-low-level-design/tree/main/oop/java/polymorphism)
- [Abstraction](https://github.com/ashishps1/awesome-low-level-design/tree/main/oop/java/abstraction)
- [Interfaces](https://github.com/ashishps1/awesome-low-level-design/tree/main/oop/java/interfaces)
- [Relationships](https://github.com/ashishps1/awesome-low-level-design/tree/main#-class-relationships)
- [Design Principles](https://github.com/ashishps1/awesome-low-level-design/tree/main#-design-principles)
- [UML Diagrams](https://github.com/ashishps1/awesome-low-level-design/tree/main#%EF%B8%8F-uml)
- [Design Patterns](https://github.com/ashishps1/awesome-low-level-design/blob/main/README.md#-design-patterns)
- [Practice Problems](https://github.com/ashishps1/awesome-low-level-design/blob/main/README.md#-how-to-answer-a-lld-interview-problem)

---

### C. [Collections](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#collections-framework) 
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
- [Stream API](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#imperative-vs-declarative)

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

