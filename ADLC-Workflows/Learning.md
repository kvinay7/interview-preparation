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

### 1. [Basics](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#introduction) 
- [Variables](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#basics)
- [Data Types](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#variables-and-data-types)
- [Operators](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#operators)
- [Control Flow](https://www.baeldung.com/java-control-structures)
- [Standard I/O](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#standard-io)
- [Questions](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#conceptual-questions)

---

### 2. [Collections](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#collections-framework) 
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
- [Blind 75](https://algomaster.io/practice/dsa-patterns?tab=am-75)

---

### 3. [OOP](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#object-oriented-programming-oop) 
- [Classes & Objects](https://github.com/ashishps1/awesome-low-level-design/tree/main/oop/java/classesandobjects)
- [Enums & Generics](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#enums)
- [Encapsulation](https://github.com/ashishps1/awesome-low-level-design/tree/main/oop/java/encapsulation) 
- [Inheritance](https://github.com/ashishps1/awesome-low-level-design/tree/main/oop/java/inheritance)
- [Polymorphism](https://github.com/ashishps1/awesome-low-level-design/tree/main/oop/java/polymorphism)
- [Abstraction](https://github.com/ashishps1/awesome-low-level-design/tree/main/oop/java/abstraction)
- [Interfaces](https://github.com/ashishps1/awesome-low-level-design/tree/main/oop/java/interfaces)
- [Relationships](https://github.com/ashishps1/awesome-low-level-design/tree/main#-class-relationships)
- [Exceptions](https://github.com/kvinay7/interview-preparation/blob/main/Java.md#exception-handling)
- [Design Principles](https://github.com/ashishps1/awesome-low-level-design/tree/main#-design-principles)
- [UML Diagrams](https://github.com/ashishps1/awesome-low-level-design/tree/main#%EF%B8%8F-uml)
- [Design Patterns](https://github.com/ashishps1/awesome-low-level-design/blob/main/README.md#-design-patterns)
- [Design Practice](https://github.com/ashishps1/awesome-low-level-design/blob/main/README.md#-how-to-answer-a-lld-interview-problem)

---

## Backend Engineering

### 1. [Spring Framework](https://github.com/kvinay7/interview-preparation/blob/main/Spring.md#spring-framework)
 
#### [Spring Core](https://github.com/kvinay7/interview-preparation/blob/main/Spring.md#spring-core)
- **IoC (Inversion of Control)**
  - IoC Container
  - Dependecy Injection
  - [Without IoC/DI](https://github.com/kvinay7/interview-preparation/blob/main/Spring.md#1-without-ioc--di-tightly-coupled)
  - [Manual DI](https://github.com/kvinay7/interview-preparation/blob/main/Spring.md#2-with-ioc--di-manual-dependency-injection)
  - [Spring DI](https://github.com/kvinay7/interview-preparation/blob/main/Spring.md#3-with-spring-ioc--di)
    - [Constructor injection](https://github.com/kvinay7/interview-preparation/blob/main/Spring.md#i-constructor-injection-recommended)
    - [Setter injection](https://github.com/kvinay7/interview-preparation/blob/main/Spring.md#ii-setter-injection)
    - [Field injection](https://github.com/kvinay7/interview-preparation/blob/main/Spring.md#iii-field-injection)
  
- **[Bean Management](https://github.com/kvinay7/interview-preparation/blob/main/Spring.md#bean-management)**
  - Bean Lifecycle
  - Bean scopes

- **[Autowiring](https://github.com/kvinay7/interview-preparation/blob/main/Spring.md#autowiring)**
  
- **[Configuration](https://github.com/kvinay7/interview-preparation/blob/main/Spring.md#configuration)**
  - XML configuration 
  - Java-based configuration

---
    
### 2. [Spring Boot](https://github.com/kvinay7/interview-preparation/blob/main/Spring.md#spring-boot)
- **Auto-Configuration**
  - @SpringBootApplication
  - @EnableAutoConfiguration
  - spring.factories
  - Conditional beans (@ConditionalOnClass, @ConditionalOnProperty)
  
- **Embedded Server**
  - Tomcat, Jetty, Undertow
  - Server configuration (port, context-path, compression)
  - Custom server configuration
  
- **Application Properties**
  - application.properties vs application.yml
  - Profiles (dev, staging, prod)
  - @Value annotation
  - @ConfigurationProperties (type-safe config binding)
  - Property override precedence
  
- **Starters**
  - spring-boot-starter-web
  - spring-boot-starter-data-jpa
  - spring-boot-starter-security
  - spring-boot-starter-test
  - spring-boot-starter-logging
  
- **Maven/Gradle**
  - POM structure
  - Dependency management
  - Maven lifecycle (clean, compile, test, package, deploy)
  - Spring Boot Maven plugin
  
- **Logging**
  - SLF4J (Simple Logging Facade)
  - Logback (default implementation)
  - Log levels (TRACE, DEBUG, INFO, WARN, ERROR)
  - Rolling file appenders
  - Pattern configuration
  
- **Actuator Basics**
  - /actuator/health
  - /actuator/metrics
  - Custom health indicators
  - Endpoints exposure
### C. Best Practices
- Constructor injection over field injection
- Immutable beans (final fields)
- Loose coupling with interfaces
- Bean naming conventions
- Package structure (controller, service, repository, model, config)
---
 
## 2. HTTP & APIs & STANDARDS
 
### A. HTTP Fundamentals
- **HTTP Methods**
  - GET (retrieve data, idempotent, cacheable)
  - POST (create resource, non-idempotent)
  - PUT (replace entire resource, idempotent)
  - PATCH (partial update, may not be idempotent)
  - DELETE (remove resource, idempotent)
  - HEAD (like GET but no body)
  - OPTIONS (describe communication options)
  
- **HTTP Status Codes**
  - 1xx (Informational): 100 Continue, 101 Switching Protocols
  - 2xx (Success): 200 OK, 201 Created, 202 Accepted, 204 No Content, 206 Partial Content
  - 3xx (Redirection): 301 Moved Permanently, 302 Found, 304 Not Modified, 307 Temporary Redirect
  - 4xx (Client Error): 400 Bad Request, 401 Unauthorized, 403 Forbidden, 404 Not Found, 409 Conflict, 422 Unprocessable Entity, 429 Too Many Requests
  - 5xx (Server Error): 500 Internal Server Error, 502 Bad Gateway, 503 Service Unavailable, 504 Gateway Timeout
  
- **HTTP Headers**
  - Request headers: Host, User-Agent, Accept, Content-Type, Authorization, Cookie, X-* headers
  - Response headers: Content-Type, Set-Cookie, Cache-Control, ETag, Location, Server
  - Custom headers for tracking (X-Request-ID, X-Correlation-ID)
  
- **Request/Response Body**
  - JSON serialization/deserialization
  - XML (understanding, not primary)
  - Form data (application/x-www-form-urlencoded, multipart/form-data)
  - Content negotiation
### B. REST API Principles
- **RESTful Design**
  - Resource-based URLs (/users, /users/{id}, not /getUser)
  - Stateless communication
  - Standard HTTP methods for CRUD
  - Meaningful status codes
  - Hypermedia (HATEOAS basics)
  
- **Routing & URL Design**
  - Path parameters (/users/{id})
  - Query parameters (/users?status=active&limit=10)
  - Matrix parameters (less common)
  - URL versioning (/api/v1/users, /api/v2/users)
  - Header-based versioning (Accept: application/vnd.api+json;version=2)
  - Content negotiation versioning
  
- **Idempotency**
  - GET, PUT, DELETE are idempotent
  - POST is not idempotent
  - Idempotency keys for non-idempotent operations
  
- **Pagination & Sorting**
  - Limit/offset pagination
  - Cursor-based pagination
  - Sorting parameters (?sort=name&sort=-created_at)
  - Total count in response headers or body
### C. API Standards & Documentation
- **OpenAPI / Swagger**
  - OpenAPI specification (3.0, 3.1)
  - @ApiOperation, @ApiResponse, @ApiParam annotations
  - Swagger UI for API exploration
  - Auto-generated documentation
  
- **API Versioning Strategies**
  - URL path versioning (/v1/, /v2/)
  - Header versioning (Accept header with version)
  - Parameter versioning (query string)
  - Subdomain versioning (api.v1.example.com)
  - Best practices & trade-offs
  
- **API Standards**
  - JSON:API specification
  - HAL (Hypertext Application Language)
  - GraphQL basics (awareness, not deep dive)
### D. Best Practices
- Consistent naming conventions (camelCase in JSON, snake_case in URLs)
- Meaningful error messages with error codes
- CORS configuration
- API rate limiting headers (X-RateLimit-*)
- Request ID tracking for debugging
---
 
## 3. SPRING MVC & REST
 
### A. DispatcherServlet & Request Flow
- **DispatcherServlet**
  - Front controller pattern
  - Request routing
  - Servlet filter chain
  - Central request handling
  
- **Request/Response Lifecycle**
  - Client sends HTTP request
  - DispatcherServlet receives request
  - HandlerMapping identifies controller
  - HandlerAdapter invokes controller method
  - Controller processes request
  - Service layer handles business logic
  - Repository layer accesses data
  - Response converted to JSON/XML
  - Response sent to client
### B. Controllers & Annotations
- **@Controller vs @RestController**
  - @Controller returns views (Model-View)
  - @RestController returns data directly (REST APIs)
  - Combination of @Controller + @ResponseBody
  
- **Request Mapping**
  - @RequestMapping (general purpose)
  - @GetMapping, @PostMapping, @PutMapping, @DeleteMapping, @PatchMapping
  - Method-level & class-level mapping
  - Wildcard path matching
  - Regex in paths
  
- **Method Parameters**
  - @RequestParam (query/form parameters)
  - @PathVariable (URI template variables)
  - @RequestBody (JSON/XML body binding)
  - @RequestHeader (HTTP headers)
  - @CookieValue (cookies)
  - @SessionAttribute (session variables)
  - @ModelAttribute (form object binding)
  
- **Return Types**
  - String (view name for @Controller)
  - ResponseEntity<T> (full control over status, headers, body)
  - Direct object/List (auto-serialized to JSON)
  - Void (for DELETE operations)
  - HttpEntity<T> (similar to ResponseEntity but without status)
### C. Spring MVC Components
- **HandlerMapping**
  - Maps requests to handler methods
  - Priority-based if multiple matches
  
- **HandlerAdapter**
  - Invokes handler methods
  - Binds request parameters to method arguments
  - Handles return value processing
  
- **ViewResolver**
  - Not needed for REST APIs
  - Resolves logical view names to actual views
  
- **Interceptors**
  - HandlerInterceptor interface (preHandle, postHandle, afterCompletion)
  - Use cases: logging, security checks, request tracking
  - Registering interceptors via WebMvcConfigurer
### D. Best Practices
- Use @RestController for all new APIs
- Constructor injection in controllers
- Validate input with @Valid
- Return appropriate HTTP status codes
- Use ResponseEntity for fine-grained control
- Consistent URL naming conventions
---
 
## 4. EXCEPTIONS & VALIDATION
 
### A. Exception Handling
- **Exception Hierarchy**
  - Throwable (base)
  - Exception (checked exceptions)
  - Error (JVM errors, avoid catching)
  - RuntimeException (unchecked exceptions)
  
- **Checked vs Unchecked**
  - Checked: must catch or declare (IOException, SQLException)
  - Unchecked: optional to catch (NullPointerException, IllegalArgumentException)
  - Java best practice: prefer unchecked for business logic
  
- **Try-Catch-Finally**
  - Multiple catch blocks (catch specific exceptions first)
  - Finally block (cleanup, always executes)
  - Never swallow exceptions silently
  - Log exceptions properly
  
- **Try-with-Resources**
  - AutoCloseable resources (database connections, file streams)
  - Automatic resource cleanup
  - Suppressed exceptions handling
  
- **Custom Exceptions**
  - Extend RuntimeException (unchecked, preferred)
  - Extend Exception (checked, use sparingly)
  - Meaningful exception names (suffix with Exception)
  - Include error context (message, cause)
  - Custom exception hierarchy
### B. Spring Exception Handling
- **@ControllerAdvice**
  - Global exception handler class
  - Applied to all controllers
  - @RestControllerAdvice for REST APIs
  
- **@ExceptionHandler**
  - Method-level annotation
  - Handles specific exception types
  - Can be in controller or @ControllerAdvice
  - Support multiple exceptions: @ExceptionHandler({Exc1.class, Exc2.class})
  
- **Standard Response Format**
  - Error response object (timestamp, status, message, errors)
  - HTTP status mapping (4xx for client errors, 5xx for server errors)
  - Include error codes for API consumers
  
- **Exception Handling Best Practices**
  - Log all exceptions with context
  - Don't expose internal stack traces to clients
  - Return meaningful error messages
  - Use appropriate HTTP status codes
  - Provide error codes for client-side handling
### C. Validation
- **Bean Validation (JSR-380)**
  - @Valid annotation (triggers validation)
  - @Validated (Spring's enhanced validation)
  - Nested validation (@Valid on nested objects)
  
- **Common Validators**
  - @NotNull, @NotEmpty, @NotBlank
  - @Size(min=, max=)
  - @Min, @Max, @DecimalMin, @DecimalMax
  - @Email (email format)
  - @Pattern (regex pattern)
  - @Future, @Past (date validation)
  - @AssertTrue, @AssertFalse (boolean assertions)
  
- **Custom Validators**
  - Implement ConstraintValidator interface
  - Create custom annotations
  - Reusable across projects
  
- **Validation Scopes**
  - Input validation (request body, path/query parameters)
  - Business logic validation (service layer)
  - Database constraint validation (not recommended in API layer)
  
- **Error Handling for Validation**
  - MethodArgumentNotValidException (invalid @Valid objects)
  - ConstraintViolationException (invalid @Validated objects)
  - BindingResult for programmatic access to errors
  - Field-level error messages
### D. Best Practices
- Fail fast, validate at entry point
- Use @Valid for REST request bodies
- Create custom validators for complex rules
- Return validation errors in standard format
- Include field-level error messages
- Log unexpected exceptions
---
 
## 5. DATABASES
 
### A. SQL Fundamentals
- **CRUD Operations**
  - SELECT (retrieval, filtering, aggregation)
  - INSERT (single & bulk inserts)
  - UPDATE (with WHERE clause)
  - DELETE (with WHERE clause)
  
- **Joins**
  - INNER JOIN (matching rows from both tables)
  - LEFT JOIN (all rows from left, matching from right)
  - RIGHT JOIN (all rows from right, matching from left)
  - FULL OUTER JOIN (all rows from both)
  - CROSS JOIN (Cartesian product)
  - Self-join
  
- **Filtering & Aggregation**
  - WHERE clause (conditions)
  - GROUP BY (grouping results)
  - HAVING (filtering grouped results)
  - ORDER BY (sorting, ASC/DESC)
  - LIMIT & OFFSET (pagination)
  - Aggregate functions (COUNT, SUM, AVG, MIN, MAX)
  
- **Subqueries**
  - Scalar subqueries
  - Correlated subqueries
  - Subqueries in WHERE, FROM, SELECT
  - IN, EXISTS operators
### B. Database Design
- **Relational Model**
  - Tables, rows, columns
  - Primary keys (unique identifier)
  - Foreign keys (referential integrity)
  - Constraints (UNIQUE, NOT NULL, CHECK)
  
- **Normalization**
  - 1NF: Atomic values, no repeating groups
  - 2NF: 1NF + no partial dependencies
  - 3NF: 2NF + no transitive dependencies
  - BCNF: 3NF + no anomalies
  - Trade-off: normalization vs performance (denormalization)
  
- **Relationships**
  - One-to-One (1:1)
  - One-to-Many (1:N, most common)
  - Many-to-Many (M:N, junction table)
  - Hierarchical (tree structures, self-referencing)
  
- **Schema Design Best Practices**
  - Choose appropriate data types (INT, VARCHAR, DATE, DECIMAL)
  - Set default values
  - Use NOT NULL wisely
  - Meaningful column names
  - Logical table organization
### C. Transactions
- **ACID Properties**
  - Atomicity (all-or-nothing)
  - Consistency (valid state before & after)
  - Isolation (concurrent transaction independence)
  - Durability (persisted after commit)
  
- **Isolation Levels**
  - READ UNCOMMITTED (dirty reads possible)
  - READ COMMITTED (default in most DBs, no dirty reads)
  - REPEATABLE READ (no dirty or non-repeatable reads)
  - SERIALIZABLE (complete isolation, potential deadlocks)
  - Trade-off: isolation level vs performance
  
- **Transaction Management in Spring**
  - @Transactional annotation
  - Propagation levels (REQUIRED, SUPPORTS, MANDATORY, NEVER, NOT_SUPPORTED, REQUIRES_NEW, NESTED)
  - Isolation specification
  - Read-only transactions
  - Rollback rules (checked vs unchecked exceptions)
  - Timeout configuration
  
- **Deadlock Prevention**
  - Lock ordering (consistent order of table access)
  - Keep transactions short
  - Reduce transaction scope
  - Deadlock detection & recovery
### D. Indexing
- **Index Types**
  - B-tree (default, balanced search tree)
  - Hash (fast equality, not range queries)
  - Bitmap (low-cardinality columns)
  - Full-text (text search)
  
- **When to Index**
  - Frequently queried columns (WHERE, JOIN conditions)
  - Foreign keys
  - Columns in ORDER BY
  - Trade-off: faster queries vs slower writes & more storage
  
- **Composite Indexes**
  - Multiple columns in single index
  - Column order matters (leftmost prefix rule)
  - Can cover entire query (covering index)
  
- **Index Best Practices**
  - Don't over-index (diminishing returns)
  - Monitor index usage
  - Remove unused indexes
  - Analyze EXPLAIN plans to verify index usage
### E. JPA & Hibernate
- **Entities**
  - @Entity annotation
  - @Table (table name)
  - @Id (primary key)
  - @GeneratedValue (auto-increment strategies: AUTO, IDENTITY, SEQUENCE, TABLE)
  - @Column (column configuration)
  - Immutability best practice
  
- **Entity Relationships**
  - @OneToOne (with mappedBy for bidirectional)
  - @OneToMany (collection, usually List)
  - @ManyToOne (inverse of @OneToMany)
  - @ManyToMany (junction table)
  - Bidirectional vs unidirectional
  - Cascade types (PERSIST, MERGE, REMOVE, REFRESH, ALL)
  - Fetch strategies (LAZY vs EAGER)
  
- **JPA Repository**
  - CrudRepository (basic CRUD)
  - JpaRepository (pagination, sorting, batch operations)
  - Custom repository methods (derived queries)
  
- **Query Methods**
  - Derived query names: findBy, findAllBy, countBy, deleteBy
  - Complex conditions: And, Or, Is, Equals, Between, LessThan, GreaterThan, Like
  - Sorting: OrderBy, Sort parameter
  - Pagination: Pageable parameter
  - Example: findByNameAndAgeGreaterThan
  
- **@Query Annotation**
  - JPQL queries (object-oriented)
  - Native SQL queries (database-specific)
  - Named parameters (:name)
  - Positional parameters (?1)
  - Update/delete queries with @Modifying
  
- **EntityManager**
  - persist() (insert)
  - merge() (update, re-attach detached entity)
  - refresh() (reload from DB)
  - remove() (delete)
  - find() (retrieve by ID)
  - Entity states (transient, managed, detached, removed)
  
- **Common Issues & Solutions**
  - N+1 query problem: use @EntityGraph or JOIN FETCH
  - LazyInitializationException: initialize collection in service layer
  - DetachedException: merge before update
  - Circular references: use DTOs
### F. Connection Pooling
- **HikariCP** (default in Spring Boot)
  - Connection pool size configuration
  - Connection timeout
  - Idle timeout
  - Leak detection
  
- **Benefits**
  - Reuse database connections
  - Reduce connection creation overhead
  - Improve performance
  - Resource management
### G. Database Best Practices
- Normalize schema but denormalize for performance when needed
- Use indexes strategically
- Write efficient queries (avoid SELECT *)
- Use pagination for large result sets
- Connection pooling mandatory
- Transaction scope should be minimal
- Test database performance with realistic data
---
 
## 6. TESTING
 
### A. Testing Pyramid
- **Unit Tests** (largest layer)
  - Test single method/function in isolation
  - No external dependencies (mock them)
  - Fast execution
  - JUnit + Mockito
  
- **Integration Tests** (middle layer)
  - Test multiple components together
  - Use real or test database
  - Test API endpoints (MockMvc)
  - @SpringBootTest
  
- **E2E Tests** (top layer)
  - Test entire application flow
  - Use real infrastructure (DB, external services)
  - Slow, expensive, minimal coverage
  - Selenium, REST Assured, TestContainers
### B. Unit Testing with JUnit 5
- **@Test** annotation
- **Assertions**
  - assertEquals, assertNotEquals
  - assertTrue, assertFalse
  - assertNull, assertNotNull
  - assertThrows (exception testing)
  - assertTimeout
  
- **Test Lifecycle**
  - @BeforeEach (setup before each test)
  - @AfterEach (cleanup after each test)
  - @BeforeAll (one-time setup)
  - @AfterAll (one-time cleanup)
  
- **Parameterized Tests**
  - @ParameterizedTest
  - @ValueSource, @CsvSource, @MethodSource
  - Multiple test cases in one method
  
- **Test Organization**
  - Clear test names (testMethodName_condition_expectedResult)
  - One assertion per test (or related assertions)
  - Arrange-Act-Assert (AAA) pattern
### C. Mocking with Mockito
- **@Mock** (create mock object)
- **@InjectMocks** (inject mocks into object under test)
- **when().thenReturn()** (stub method calls)
- **verify()** (verify method was called)
- **ArgumentCaptor** (capture arguments)
- **doThrow()** (throw exceptions from mocks)
- **ArgumentMatcher** (any(), eq(), etc.)
### D. Integration Testing with Spring Boot
- **@SpringBootTest**
  - Load full application context
  - Slow but comprehensive
  - Use @ActiveProfiles("test") for test config
  
- **@WebMvcTest**
  - Test only web layer (controllers)
  - Mock service layer
  - Fast and focused
  - MockMvc for testing endpoints
  
- **@DataJpaTest**
  - Test only repository layer
  - Auto-configure H2 in-memory database
  - MockMvc not available
  
- **MockMvc**
  - Perform HTTP requests: perform(get("/users"))
  - Assert status: andExpect(status().isOk())
  - Assert content: andExpect(content().json(...))
  - Extract response body
  
- **TestRestTemplate**
  - Integration test external APIs or full app
  - Returns ResponseEntity
  - Can make real HTTP calls
  
- **Test Data Setup**
  - @Sql (run SQL before test)
  - Builders for test objects
  - Database state assertion
### E. Testing Best Practices
- Test behavior, not implementation
- Meaningful test names
- One responsibility per test
- Independent tests (no test order dependency)
- Fast execution (mock external dependencies)
- High coverage for critical paths
- Test edge cases and error conditions
- Use test fixtures for common data
- AAA pattern (Arrange-Act-Assert)
### F. AssertJ (Fluent Assertions)
- **Alternative to JUnit assertions**
  - Readable: assertThat(actual).isEqualTo(expected)
  - Rich assertions: contains(), hasSize(), isNull(), etc.
  - Better error messages
  - Chain assertions
  
---
 
## 7. AI/GENAI
 
### A. Spring AI Framework
- **Integration with LLMs**
  - RestTemplate / WebClient for API calls
  - Timeout & retry configuration
  - Error handling for API failures
  
- **Supported LLM Providers**
  - OpenAI (GPT-3.5, GPT-4)
  - Azure OpenAI
  - AWS Bedrock (Claude, Llama, etc.)
  - Google Vertex AI
  - Ollama (local models)
  
- **Model Configuration**
  - API keys management (environment variables)
  - Model selection (gpt-4, claude-3, etc.)
  - Temperature (creativity/randomness)
  - Max tokens (response length)
  - Top-p, top-k sampling
### B. RAG (Retrieval-Augmented Generation)
- **RAG Pattern**
  - Retrieve relevant context from data
  - Augment prompt with retrieved context
  - Generate response using LLM
  
- **Retrieval Component**
  - Query understanding
  - Vector similarity search (embeddings)
  - Keyword search (Elasticsearch, OpenSearch)
  - BM25 algorithm basics
  
- **Data Preparation**
  - Document chunking (300-1000 tokens)
  - Metadata extraction
  - Embedding generation
  
- **Prompt Augmentation**
  - Context injection into prompt
  - Prompt templates
  - Chain-of-Thought prompting
  - Few-shot examples
  
- **Implementation in Spring**
  - Service layer orchestration
  - Async calls with @Async
  - Error handling & fallbacks
### C. Memory Management
- **Conversation Memory**
  - Sliding window (keep recent messages)
  - Summary-based (compress old messages)
  - Vector store (semantic similarity)
  
- **Memory Types**
  - Short-term (current conversation)
  - Long-term (persistent storage)
  - External memory (database)
  
- **Implementation**
  - Store conversation history
  - Retrieve relevant history
  - Manage token limits
### D. Advisor Pattern
- **Advisor Concept**
  - Combines different AI capabilities
  - Route queries to appropriate handlers
  - Multi-step problem solving
  
- **Components**
  - Query analyzer
  - Tool selector
  - Tool executor
  - Response formatter
### E. MCP (Model Context Protocol)
- **Protocol Basics**
  - Standardized way for LLMs to interact with tools
  - Tool definition & invocation
  - Context management
  
- **Tool Integration**
  - Define tools available to LLM
  - LLM selects appropriate tool
  - Tool execution & result return
  - LLM uses results to answer query
### F. Agents
- **Agent Concept**
  - Autonomous system that takes actions
  - Perceive environment → decide → act
  - Loop until goal reached
  
- **Simple Agent Pattern** (for Phase 1)
  - Accept user query
  - Decide action (query LLM, fetch data, etc.)
  - Execute action
  - Return result
  
- **Agent Types**
  - Reactive agents (no memory)
  - Deliberative agents (plan before acting)
  - Learning agents (improve over time)
### G. Evaluation
- **Evaluation Metrics**
  - Accuracy (correct answers)
  - Precision & Recall (in search results)
  - Latency (response time)
  - Cost (API usage)
  
- **Quality Assessment**
  - Human evaluation
  - Automated testing
  - A/B testing different prompts/models
  
- **Monitoring**
  - Track API response times
  - Monitor error rates
  - Log queries & responses for analysis
  - Adjust based on metrics
### H. Best Practices
- Use RAG for factual accuracy
- Implement memory for context-aware conversations
- Handle API failures gracefully
- Rate limiting & cost control
- Test prompts with real data
- Monitor & evaluate performance
- Secure API keys
- Cache embeddings & frequent queries
---
 
## Learning Path & Timeline
 
### Month 1-2: Foundations
1. Java Basics, Collections, OOP (2-3 weeks)
2. HTTP & APIs (1 week)
3. Spring Core & Boot (2 weeks)
### Month 2-3: Core Backend
4. Spring MVC & REST (2 weeks)
5. Exceptions & Validation (1 week)
6. Databases (SQL, Design, JPA) (3 weeks)
### Month 3-4: Testing & AI
7. Testing (2 weeks)
8. AI/GenAI (2 weeks)
### Month 4+: Projects & Practice
- Build 2-3 production REST APIs
- Deploy on cloud
- Integrate AI features
- Production monitoring
---
 
## Project Progression
 
### Project 1: Basic REST API (Week 3-4)
- CRUD operations
- JPA + MySQL
- Unit & integration tests
- Error handling
### Project 2: REST API with Search (Week 5-6)
- Advanced queries
- Pagination & sorting
- Validation
- Input sanitization
### Project 3: REST API with Authentication (Week 7-8)
- JWT auth
- Role-based access
- Security best practices
### Project 4: REST API with AI Integration (Week 9-10)
- OpenAI/Bedrock integration
- RAG pattern
- Prompt engineering
- Response formatting
---
 
## Quick Self-Check (SDE-1 Readiness)
 
- [ ] Build Spring Boot REST API in 2-3 hours
- [ ] Write unit + integration tests
- [ ] Design database schema (1NF minimum)
- [ ] Optimize SQL queries (understand EXPLAIN)
- [ ] Handle errors gracefully with custom exceptions
- [ ] Implement JWT authentication
- [ ] Call external LLM APIs
- [ ] Deploy to cloud (Heroku, AWS, GCP)
