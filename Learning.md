# Learning Roadmap: Java, Spring, JPA

---

## JAVA

### Covered in DEVELOPMENT_FRAMEWORK

| Feature | Covered? | Example |
|---|---|---|
| **Primitives & Wrappers** | ✅ Yes | `int`, `Long`, `String`, boxing/unboxing |
| **OOP Basics** | ✅ Yes | Classes, constructors, inheritance (`extends`), interfaces |
| **Encapsulation** | ✅ Yes | Lombok @Data (auto getters/setters), @Getter/@Setter |
| **Polymorphism** | ✅ Yes | Service interfaces, repository extends JpaRepository |
| **Exceptions** | ✅ Yes | try-catch, throw custom exceptions (UserNotFoundException), finally |
| **Collections** | ✅ Yes | List, Set, Map, Optional, Page (pagination) |
| **Generics** | ✅ Yes | `JpaRepository<User, Long>`, `Page<UserResponse>`, `Optional<User>` |
| **Lambda Expressions** | ✅ Partial | `.orElseThrow(...)`, `.stream().filter()` basic usage |
| **Stream API** | ✅ Partial | `.stream()`, `.filter()`, `.map()` basic usage |
| **Annotations** | ✅ Yes | @Entity, @Service, @Autowired, @Transactional, @Valid, etc. |
| **Reflection** | ⚠️ Indirect | Spring uses it (@Autowired, @Bean), you don't write it |
| **Records** | ✅ Yes | DTOs as `public record CreateUserRequest(...)` |
| **Sealed Classes** | ❌ No | Not needed for SDE-1 |

---

### Learn Now (SDE-1 Interview Prep)

| Topic | Why | How to Learn | Time |
|---|---|---|---|
| **Concurrency Basics** | Transactions require understanding isolation, threads | Read Chapter 14-15 in "Effective Java"; understand isolation levels (READ_UNCOMMITTED, READ_COMMITTED, REPEATABLE_READ, SERIALIZABLE) | 3 hours |
| **Stream API Depth** | Service logic often needs complex transformations (filter, map, reduce) | Practice: Convert loops to streams; use `Collectors.groupingBy()`, `partitioningBy()` | 2 hours |
| **Lambda Expressions** | Used in repository queries, service logic, testing | Write 10 lambda-based solutions to Blind75 problems in Java | 2 hours |
| **Optional Usage** | Repositories return Optional; must handle non-null correctly | Practice: `Optional.orElseThrow()`, `.map()`, `.flatMap()`, `.ifPresent()` | 1 hour |
| **Generics Depth** | Understand wildcard types (`<? extends T>`), bounded types for service methods | Read Effective Java Item 26-33; write generic Service<T> | 2 hours |
| **Exception Handling** | Custom exceptions, exception hierarchies (extends Exception, RuntimeException) | Design exception hierarchy for your feature; practice throwing/catching | 1 hour |
| **Method References** | Shorthand for lambdas; used in streams | Learn `ClassName::methodName`, `this::method`, constructor references | 1 hour |

**Total:** ~12 hours

---

### Learn Later (SDE-2+)

| Topic | Why | When |
|---|---|---|
| **JVM Internals** | Memory management, garbage collection, heap/stack; needed for optimization | After SDE-1, if working on high-throughput systems |
| **Concurrency (Deep)** | ThreadLocal, synchronized blocks, ReentrantLock, ConcurrentHashMap, happens-before semantics | SDE-2+ for concurrent data structures, producer-consumer patterns |
| **Reflection** | Meta-programming, custom annotations, proxies (Spring uses this internally) | SDE-2+ if building frameworks or advanced Spring features |
| **Performance Tuning** | Boxing/unboxing costs, string interning, method inlining, profiling | SDE-2+ for performance-critical systems |
| **Java Modules (Java 9+)** | Module system for large projects | SDE-2+ if modularizing large codebases |
| **Sealed Classes & Records (Deep)** | Pattern matching, advanced type hierarchies | SDE-2+ for domain modeling in larger systems |

---

## SPRING BOOT & SPRING

### Covered in DEVELOPMENT_FRAMEWORK

| Feature | Covered? | Example |
|---|---|---|
| **Dependency Injection** | ✅ Yes | @Autowired, constructor injection (@Service @Autowired UserRepository) |
| **Spring Boot Auto-config** | ✅ Yes | application.properties, @Value, @ConfigurationProperties |
| **Spring MVC** | ✅ Yes | @RestController, @RequestMapping, @PostMapping, @GetMapping |
| **Request Mapping** | ✅ Yes | @RequestBody, @PathVariable, @RequestParam, @Valid |
| **Response Handling** | ✅ Yes | ResponseEntity, @RestController, status codes (201, 400, 401, 403, 404) |
| **Spring Data JPA** | ✅ Yes | JpaRepository, derived queries, @Query, Pageable |
| **Transactions** | ✅ Yes | @Transactional, isolation levels, propagation |
| **Exception Handling** | ✅ Yes | @ControllerAdvice, @ExceptionHandler, GlobalExceptionHandler |
| **Validation** | ✅ Yes | @Valid, @NotBlank, @Email, @Size, @Min, @Max, @Pattern |
| **Testing** | ✅ Yes | @SpringBootTest, @Mock, @InjectMocks, MockMvc, @Testcontainers |
| **Filters** | ✅ Yes | OncePerRequestFilter, @Order, doFilterInternal |
| **Security (Basic)** | ✅ Partial | SecurityFilterChain, PasswordEncoder (BCrypt), JWT validation in filter |
| **CORS** | ✅ Yes | CorsConfigurationSource, @CrossOrigin |
| **Swagger/OpenAPI** | ✅ Partial | @Operation, @ApiResponse (configuration assumed) |
| **Logging** | ✅ Yes | @Slf4j, SLF4J, MDC (Mapped Diagnostic Context) |
| **Actuator** | ✅ Partial | /actuator/health endpoint (basic) |
| **Aspect-Oriented Programming (AOP)** | ❌ No | @Aspect, @Pointcut, @Around not covered |
| **Spring Cloud** | ❌ No | Not in scope (microservices = SDE-2) |
| **WebFlux/Reactive** | ❌ No | Not in scope (blocking REST only) |
| **Spring Cache** | ❌ No | @Cacheable, @CacheEvict not covered |

---

### Learn Now (SDE-1 Interview Prep)

| Topic | Why | How to Learn | Time |
|---|---|---|---|
| **Spring Security (Deep)** | Authorization, authentication, JWT, BOLA checks; every interview asks this | Read Spring Security docs; build login/auth flow with JWT in `genai-backend-app`; understand SecurityContext, Authentication, Principal | 6 hours |
| **Request/Response Cycle** | Understand how @RequestBody → DTO → @Valid → Service → ResponseEntity flows | Trace a POST request end-to-end; draw diagram of request/response flow | 1 hour |
| **HTTP Status Codes** | 200 vs 201, 401 vs 403, when to use each | Memorize status code semantics; use in every controller method | 1 hour |
| **Pagination (Deep)** | Pageable, Page, Slice, offset-based vs cursor-based | Implement pagination in repository; test with large datasets | 2 hours |
| **Transactions (Deep)** | Isolation levels (READ_COMMITTED, REPEATABLE_READ), propagation (REQUIRED, NESTED, NEW) | Write service methods with @Transactional; understand when isolation matters | 3 hours |
| **Bean Lifecycle** | Constructor → @PostConstruct → ready → @PreDestroy; when beans are created | Read Spring docs on bean lifecycle; use @PostConstruct for initialization | 1 hour |
| **Property Management** | @Value, @ConfigurationProperties, environment variables, profiles (dev/test/prod) | Use @Value in SecurityConfig; externalize JWT secret, CORS origin | 2 hours |
| **MockMvc Testing** | Test endpoints without starting full application context | Write 5+ MockMvc tests for your controller endpoints | 2 hours |
| **Testcontainers** | Real PostgreSQL in tests (not H2); @Container setup | Set up Testcontainers in your test class; run integration tests | 1 hour |
| **Logging + MDC** | SLF4J, structured logging, MDC for request tracking (requestId, userId) | Implement logging in filters; use MDC in service methods | 1 hour |
| **CORS Configuration** | Cross-origin requests, allowed origins, credentials | Configure CORS in SecurityConfig; test with frontend on different port | 1 hour |

**Total:** ~21 hours

---

### Learn Later (SDE-2+)

| Topic | Why | When |
|---|---|---|
| **Spring Security (Advanced)** | OAuth2, OIDC, custom security filters, pre/post method authorization | SDE-2+ for complex auth scenarios |
| **Spring Cloud** | Service discovery, load balancing, circuit breaker (Resilience4j), API Gateway | SDE-2+ for microservices architecture |
| **WebFlux/Reactive** | Non-blocking I/O, Project Reactor, async streams | SDE-2+ if building high-concurrency systems |
| **Spring Batch** | Large-scale data processing, job scheduling | SDE-2+ for batch jobs (data pipelines) |
| **Spring Integration** | Message-driven architectures, EIP patterns | SDE-2+ for event-driven systems |
| **AOP (Aspect-Oriented Programming)** | Cross-cutting concerns via @Aspect, @Pointcut, @Around | SDE-2+ for advanced logging, metrics, caching |
| **Spring Cache** | @Cacheable, @CacheEvict, cache invalidation strategy | SDE-2+ for performance optimization |
| **Spring for Apache Kafka** | Message streaming, event sourcing | SDE-2+ for real-time data pipelines |
| **Spring Metrics** | Micrometer, custom metrics, monitoring integration | SDE-2+ for observability |
| **Scheduled Tasks** | @Scheduled, ScheduledExecutorService | SDE-2+ for background jobs |

---

## JPA (Java Persistence API)

### Covered in DEVELOPMENT_FRAMEWORK

| Feature | Covered? | Example |
|---|---|---|
| **Entity Mapping** | ✅ Yes | @Entity, @Table, @Id, @GeneratedValue(strategy = IDENTITY) |
| **Column Constraints** | ✅ Yes | @Column(nullable=false, unique=true, length=100) |
| **Data Types** | ✅ Yes | @Temporal(TIMESTAMP), @Enumerated(EnumType.STRING), LocalDateTime |
| **Relationships** | ✅ Yes | @OneToMany, @ManyToOne, @OneToOne, @ManyToMany with fetch strategy |
| **Cascade & Orphan Removal** | ✅ Yes | cascade = CascadeType.ALL, orphanRemoval = true |
| **Validation** | ✅ Yes | @NotNull, @NotBlank, @Email, @Size on Entity fields |
| **Soft Delete** | ✅ Yes | isDeleted boolean flag, @Query with soft-delete filter |
| **Inheritance** | ✅ Partial | Single table inheritance (Entity extends Entity) |
| **Spring Data JPA** | ✅ Yes | JpaRepository, derived queries (findByXxx), @Query, @Modifying |
| **Pagination** | ✅ Yes | Pageable, Page<>, findByXxx(Pageable pageable) |
| **Custom Queries** | ✅ Yes | @Query("SELECT ..."), @Query(nativeQuery=true) |
| **Indexes** | ✅ Yes | @Index on @Table or @Column |
| **Transient Fields** | ✅ Partial | @Transient (not persisted) |
| **Fetch Strategy** | ✅ Partial | @OneToMany(fetch = FetchType.LAZY), @ManyToOne(fetch = FetchType.EAGER) |
| **Lazy Loading** | ⚠️ Indirect | Mentioned (N+1 problem, EAGER vs LAZY), but not deep implementation |
| **Query Optimization** | ✅ Partial | EXPLAIN PLAN, indexes mentioned but not deep |
| **JPA Callbacks** | ❌ No | @PrePersist, @PostPersist, @PreUpdate, @PostUpdate not covered |
| **Entity Graphs** | ❌ No | @EntityGraph, @NamedEntityGraph not covered |
| **Criteria API** | ❌ No | CriteriaBuilder, CriteriaQuery not covered |
| **Projection** | ❌ No | Interface-based projections, @Query("SELECT new ...") not covered |

---

### Learn Now (SDE-1 Interview Prep)

| Topic | Why | How to Learn | Time |
|---|---|---|---|
| **Query Optimization** | Indexes, EXPLAIN PLAN, avoiding N+1 queries; interview asks "optimize slow query" | Run EXPLAIN ANALYZE on your repository queries; add indexes to frequently-queried fields | 2 hours |
| **Fetch Strategies (Depth)** | EAGER vs LAZY loading; when to use each; N+1 problem | Write code that demonstrates N+1; use EAGER fetch to fix it; understand lazy loading exceptions | 2 hours |
| **Relationship Management** | @OneToMany, @ManyToOne bidirectional vs unidirectional; cascade rules | Model a complex domain (User → Order → Item) with proper relationships | 2 hours |
| **Transactions in JPA** | How @Transactional works with JPA; flush, commit, rollback; dirty checking | Write code that demonstrates transaction rollback; understand persistence context | 2 hours |
| **Index Strategy** | When to add single vs composite indexes; query cost analysis | Identify slow queries in your code; add indexes; verify with EXPLAIN PLAN | 2 hours |
| **Soft Delete Pattern** | Implement soft delete (isDeleted flag); always filter in queries | Add isDeleted to all entities; use @Query to filter; verify no hard deletes happen | 1 hour |
| **SQL Basics for JPA** | Write native SQL queries; understand SQL JOIN, GROUP BY, aggregate functions | Write 5 native SQL queries in @Query(nativeQuery=true) | 2 hours |
| **Isolation Levels** | READ_COMMITTED prevents dirty reads; REPEATABLE_READ prevents phantom reads | Understand when each isolation level matters; set in @Transactional | 1 hour |
| **Locking Strategy** | Optimistic (version) vs pessimistic (@Lock(LockModeType.PESSIMISTIC_WRITE)) | Understand when to use each; implement version-based optimistic locking | 1 hour |
| **JPA Validation** | Difference between JPA validation (@NotNull) and Spring validation (@Valid) | Use both; understand which runs when (pre-persist vs controller validation) | 1 hour |

**Total:** ~16 hours

---

### Learn Later (SDE-2+)

| Topic | Why | When |
|---|---|---|
| **Entity Graphs** | Optimize fetching strategies using @EntityGraph | SDE-2+ for complex query optimization |
| **Criteria API** | Dynamic query building; type-safe queries | SDE-2+ for complex search/filter APIs |
| **Projection** | Interface-based or DTO projections in @Query | SDE-2+ for performance (fetch only needed columns) |
| **JPA Callbacks** | @PrePersist, @PostPersist, @PreUpdate, @PostUpdate for domain logic | SDE-2+ for complex domain models |
| **Inheritance Strategies** | Joined table, table-per-class, single table tradeoffs | SDE-2+ for large domain hierarchies |
| **Native Queries (Deep)** | Raw SQL when JPA can't express it; SQL dialects | SDE-2+ for database-specific optimizations |
| **Change Tracking** | Dirty checking, flush strategies, detached entities | SDE-2+ for advanced transaction management |
| **Batch Processing** | JPA batch inserts/updates for large datasets | SDE-2+ for bulk operations |
| **Caching Strategies** | L1 (Session) vs L2 (App-level) caching; cache invalidation | SDE-2+ for performance optimization |
| **Stored Procedures** | Call DB stored procedures from JPA | SDE-2+ if integrating with legacy DBs |

---

## Summary Table: SDE-1 Interview Prep Path

| Category | Topics to Master | Time | Priority |
|---|---|---|---|
| **Java** | Concurrency basics, Stream API, Lambda, Optional, Generics, Exceptions | 12 hours | 🔴 High |
| **Spring Boot** | Security (JWT), HTTP semantics, Transactions, Testing (MockMvc), Logging+MDC | 21 hours | 🔴 High |
| **JPA/SQL** | Query optimization, Fetch strategies, Relationships, Indexes, Soft delete | 16 hours | 🔴 High |
| **Total** | | **49 hours** | |

---

## Quick Checklist: What to Focus On (SDE-1)

### Java
- [ ] Concurrency: isolation levels, thread safety, synchronized
- [ ] Stream API: filter, map, reduce, Collectors
- [ ] Lambda: syntax, method references
- [ ] Generics: wildcards, bounded types
- [ ] Optional: orElseThrow, map, flatMap
- [ ] Exception handling: custom exceptions, try-catch-finally

### Spring Boot
- [ ] Security: JWT token generation/validation, BOLA checks
- [ ] HTTP: Status codes (201, 400, 401, 403, 404), ResponseEntity
- [ ] Transactions: isolation levels, propagation, @Transactional
- [ ] Testing: MockMvc, @Mock, Testcontainers
- [ ] Logging: SLF4J, MDC (requestId, userId)
- [ ] Filters: AuthFilter, LoggingFilter, @Order

### JPA/SQL
- [ ] Query optimization: EXPLAIN PLAN, indexes
- [ ] Fetch strategies: EAGER vs LAZY, N+1 problem
- [ ] Relationships: 1:N, N:1, N:N modeling
- [ ] Soft delete: isDeleted pattern, filter in queries
- [ ] SQL: SELECT, JOIN, WHERE, GROUP BY, aggregate functions
- [ ] Isolation levels: READ_COMMITTED, REPEATABLE_READ

---

## Timeline Suggestion (8 Weeks to SDE-1 Interview)

| Week | Focus | Hours/Day |
|---|---|---|
| 1-2 | Java: Streams, Lambda, Generics, Concurrency basics | 2-3 |
| 2-3 | Spring Security: JWT, BOLA, @Transactional depth | 3-4 |
| 3-4 | JPA: Query optimization, fetch strategies, indexes | 2-3 |
| 4-5 | DEVELOPMENT_FRAMEWORK: Implement 2-3 features end-to-end | 3-4 |
| 5-6 | Testing: MockMvc, Testcontainers, BOLA tests | 2-3 |
| 6-7 | Interview prep: Mock interviews, LLD walkthrough of your code | 2-3 |
| 7-8 | Polish: DSA (Blind75), STAR behavioral, system design | 2-3 |

---

## Post-SDE-1 (SDE-2+ Path)

Once hired as SDE-1, spend 1-2 years building:

1. **High-concurrency systems** → Learn JVM internals, concurrency patterns
2. **Microservices** → Spring Cloud, Service discovery, circuit breaker
3. **Real-time systems** → WebFlux, Kafka, message streaming
4. **Large-scale optimization** → Advanced indexing, caching, sharding
5. **Advanced Spring** → AOP, custom annotations, Spring integration

---

This roadmap is locked for your prep. Stick to the SDE-1 checklist.
