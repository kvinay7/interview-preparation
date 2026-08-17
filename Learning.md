# Backend Engineering Learning Roadmap

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

## JPA (Java Persistence API)

### SDE-1 Now (Before Building Features)

**Week 3-4: JPA Basics (covered in Spring Data section above)**

1. ✅ **Entity Mapping** (covered: @Entity, @Table, @Id, @Column, relationships)
   - Constraints: nullable, unique, length
   - Validation: @NotNull, @NotBlank, @Email
   - Time: 2 days

2. ✅ **Relationships** (covered: @OneToMany, @ManyToOne, @OneToOne, @ManyToMany)
   - Cascade rules, fetch strategies (LAZY, EAGER)
   - Orphan removal
   - Time: 2 days

3. ✅ **Queries** (covered: derived queries, @Query, Pageable)
   - JPQL: `@Query("SELECT u FROM User u WHERE ...")`
   - Native SQL: `@Query(nativeQuery=true)`
   - Pagination with Page<T>
   - Time: 2 days

4. ✅ **SQL Basics** (covered: SELECT, JOIN, WHERE, ORDER BY, GROUP BY)
   - Time: 1 day

**Total SDE-1 JPA:** ~7 days (covered in Spring Data section)

---

### SDE-2/System Design Later (After 6+ months working)

**Query Optimization**
- EXPLAIN PLAN analysis
- N+1 problem identification and fixes
- Index strategies: single, composite, partial
- Query cost analysis
- Time: 3 days (~15 hours)

**Fetch Strategies (Deep)**
- LazyInitializationException handling
- Entity graphs: @NamedEntityGraph, @EntityGraph
- Explicit JOINs vs lazy loading
- Batch fetching
- Time: 2 days (~10 hours)

**Locking**
- Optimistic locking: @Version
- Pessimistic locking: @Lock(LockModeType.PESSIMISTIC_WRITE)
- Deadlock prevention
- Time: 2 days (~10 hours)

**Inheritance Strategies**
- Single table, joined table, table-per-class
- Polymorphic queries
- Time: 1 day (~5 hours)

**Advanced Features**
- Criteria API, QueryDSL for dynamic queries
- JPA Callbacks: @PrePersist, @PostPersist, @PreUpdate, @PostUpdate
- Projections (interface-based, DTO)
- Stored procedures, database functions
- Time: 3 days (~15 hours)

**Bulk Operations**
- Batch inserts, updates, deletes
- flush(), clear() strategies
- Bulk DELETE/UPDATE via @Modifying
- Time: 1 day (~5 hours)

**Caching**
- L1 (Session) caching
- L2 (Application-level) caching
- Cache invalidation
- Time: 1 day (~5 hours)

---

## How to Use This Learning Order

1. **Read each topic** in order (use Java docs, Spring docs)
2. **Code along** with examples
3. **Build features** simultaneously using DEVELOPMENT_FRAMEWORK.md
4. **Test knowledge** with unit/integration tests

