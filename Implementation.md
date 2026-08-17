# Development Framework Template

- **For:** Any Java Spring Boot REST API project with PostgreSQL + JPA
- **Scope:** Backend REST APIs only (no UI, AI integration, DevOps/Cloud)
- **Target Level:** SDE-1 interview prep
- **Stack (Locked):** Java 21 + Spring Boot 3 + PostgreSQL + JPA + JUnit + Mockito

---

## Overview: 9-Layer Architecture

Every feature follows the same pattern:

```
1. Entity (Data Model)
   ↓
2. DTO (API Contract)
   ↓
3. Repository (Database Queries)
   ↓
4. Service (Business Logic)
   ↓
5. Controller (REST Endpoints)
   ↓
6. Exception Handler (Global Error Mapping)
   ↓
7. Config (Spring Beans & Settings)
   ↓
8. Filters (HTTP Interceptors)
   ↓
9. Tests (Unit + Integration)
```

**Key Principle:** Same structure for every feature. Only business logic and entity fields change.

---

## ADLC Integration
 
Each layer maps to ADLC phases:
 
| Layer | ADLC Phase | Interview Talking Point |
|---|---|---|
| Entity | **Understand** | "I understood the data model and relationships" |
| DTO | **Analyze** | "I analyzed the API contract requirements" |
| Repository | **Decide** | "I decided on query patterns and indexing" |
| Service | **Learn** + **Implement** | "I learned Spring patterns and implemented secure business logic" |
| Controller | **Implement** | "I implemented clean REST endpoints" |
| Tests | **Validate** | "I validated happy paths, error cases, and authorization (BOLA)" |
| Docs | **Document** | "I documented the feature with API examples" |

---

## LAYER 1: Entity (Data Model)

**Purpose:** Define persistent data structures with JPA annotations

**Template:**
```
Generate JPA Entity for [feature name]:

Domain: [Your domain: E-commerce, HR, Banking, etc]
Requirements: [Reference requirement ID]

Data needed:
- [Field 1]: [type], [constraints]
- [Field 2]: [type], [constraints]
- [Field 3]: [type], [constraints]

Relationships:
- [Entity A] has many [Entity B]
- [Entity C] belongs to [Entity D]

Constraints:
- [Field X] is unique
- [Field Y] is required
- [Field Z] has max length / valid range

Database considerations:
- Indexes needed: [composite keys, lookup columns]
- Soft delete (isDeleted) or hard delete?
- Audit fields (createdAt, updatedAt)?

Include:
- @Entity @Table with custom name if needed
- @Id @GeneratedValue(strategy = IDENTITY)
- @Column with nullable, unique, length constraints
- @Enumerated(EnumType.STRING) for enums
- @Temporal(TIMESTAMP) or @CreationTimestamp/@UpdateTimestamp
- Relationships: @OneToMany, @ManyToOne, @ManyToMany, @OneToOne
- Lombok @Data (or @Getter @Setter if need control)
- No constructors, no getters/setters (Lombok handles)
- JPA validation: @NotNull, @NotBlank, @Email, @Size, @Min, @Max
```

**Example Output:**
```java
@Entity
@Table(name = "users", indexes = {
    @Index(name = "idx_email", columnList = "email", unique = true),
    @Index(name = "idx_created_at", columnList = "created_at")
})
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false, length = 100)
    @NotBlank
    @Email
    private String email;
    
    @Column(nullable = false)
    @NotBlank
    private String passwordHash; // BCrypt
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role; // USER, ADMIN
    
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;
    
    @Column(nullable = false)
    private Boolean isDeleted = false;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> orders = new HashSet<>();
}
```

---

## LAYER 2: DTO (Request/Response)

**Purpose:** Define API contracts (what clients send/receive)

**Template:**
```
Generate DTOs for [feature] API:

Controller path: /api/v1/[resource]
Requirements: [Reference requirement]

Request DTO:
- Endpoint: [METHOD /path]
- Fields: [field1: type, validation], [field2: type, validation]
- Example: {"field1": "value", "field2": "value"}

Response DTO:
- Success: [field1: type], [field2: type]
- Example: {"id": 123, "status": "success"}
- Error: Standard error structure (defined once globally)

Validations:
- @NotBlank on required strings
- @Email on email fields
- @Size(min=, max=) for strings/collections
- @Min/@Max for numbers
- @Pattern(regexp=) for formats (phone, UUID)
- @Valid on nested objects

Include:
- Request DTO(s) with @Valid annotations
- Response DTO(s)
- Use record (if no complex logic) or @Data
- @JsonProperty for field mapping if needed
- Javadoc on fields for API docs (Swagger)
```

**Example Output:**
```java
public record CreateUserRequest(
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    String email,
    
    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 128, message = "Password must be 8-128 characters")
    String password,
    
    @NotNull(message = "Role is required")
    Role role
) {}

public record UserResponse(
    Long id,
    String email,
    Role role,
    LocalDateTime createdAt
) {}

public record ErrorResponse(
    Integer status,
    String error,
    String message,
    LocalDateTime timestamp,
    String requestId
) {}
```

---

## LAYER 3: Repository (Database Access)

**Purpose:** Define database queries using Spring Data JPA

**Template:**
```
Generate Spring Data JPA Repository for [entity]:

Entity: [EntityName]
Database: PostgreSQL
Requirements: [Reference requirement]

Queries needed:
- Find by [field]: [description] → return Optional<Entity>
- Find all by [field]: [description with sorting/pagination]
- Delete by [field]: [soft delete or hard delete?]
- Count by [field]: [for validation/limiting]

Custom queries (JPQL or native SQL):
- [Query 1 name]: [Description] → return List<Entity>
- [Query 2 name]: [Description] → return long (count)

Indexes needed:
- Single index: ([field]) for WHERE clauses
- Composite index: ([field1], [field2]) for joint lookups

Pagination:
- Which queries support pagination? [List queries]

Include:
- Extend JpaRepository<[Entity], [IdType]>
- Derived query methods (findByXxx, deleteByXxx)
- @Query(value="...") for complex JPQL
- @Query(value="... (native SQL)", nativeQuery=true) for advanced DB features
- @Modifying @Transactional for DELETE/UPDATE
- @Param("paramName") for named parameters
- Pageable parameter for pagination (Page<Entity> return type)
- Javadoc on each method (for interview walkthrough)
```

**Example Output:**
```java
public interface UserRepository extends JpaRepository<User, Long> {
    // Derived queries (Spring generates SQL automatically)
    Optional<User> findByEmail(String email);
    
    Optional<User> findByIdAndIsDeletedFalse(Long id);
    
    Page<User> findByRoleAndIsDeletedFalse(Role role, Pageable pageable);
    
    boolean existsByEmailAndIsDeletedFalse(String email);
    
    long countByRole(Role role);
    
    // Custom JPQL query
    @Query("SELECT u FROM User u WHERE u.role = :role AND u.isDeleted = false ORDER BY u.createdAt DESC")
    List<User> findRecentUsersByRole(@Param("role") Role role);
    
    // Soft delete (UPDATE instead of DELETE)
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.isDeleted = true WHERE u.id = :id")
    void softDeleteById(@Param("id") Long id);
    
    // Native SQL for complex queries
    @Query(value = "SELECT * FROM users WHERE role = :role AND created_at >= :since", nativeQuery = true)
    List<User> findUsersSince(@Param("role") String role, @Param("since") LocalDateTime since);
}
```

---

## LAYER 4: Service (Business Logic)

**Purpose:** Implement feature logic with proper error handling, transactions, logging

**Template:**
```
Generate Service for [feature]:

Class: [FeatureName]Service
Requirements: [Reference R00X]

Responsibilities:
- [Responsibility 1]: [description]
- [Responsibility 2]: [description]
- [Responsibility 3]: [description]

Methods:
- public [ReturnType] [methodName]([params]): [description]
  - Input validation: [@Valid param types]
  - Business logic: [Step-by-step]
  - Database transaction: [PROPAGATION?, ISOLATION?]
  - Return: [DTO or Entity]
  - Throws: [Custom exceptions]

Authorization (BOLA - Break Object Level Access):
- Method 1: [Verify user owns resource]
- Method 2: [Verify user has role ADMIN]

Error scenarios:
- [Scenario 1]: Throw [CustomException] with message
- [Scenario 2]: Throw [CustomException] with message

Logging & Observability:
- Log successful operations: [fields to log]
- Log errors: [include context, exclude PII]
- MDC context: [userId, resourceId, requestId]

Performance:
- Database calls: [List queries made]
- N+1 prevention: [Explicit joins if needed]

Include:
- @Service annotation
- @Autowired [Repository], [OtherService]
- @Transactional(isolation = READ_COMMITTED, propagation = REQUIRED)
- Structured logging with SLF4J + MDC
- Custom exception throwing
- Input validation (@Valid + explicit checks)
- BOLA authorization checks
- Javadoc on each method
```

**Example Output:**
```java
@Service
@Slf4j
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public UserResponse createUser(@Valid CreateUserRequest request) {
        // Input validation
        if (userRepository.existsByEmailAndIsDeletedFalse(request.email())) {
            log.warn("Attempted to create user with existing email: {}", request.email());
            throw new DuplicateEmailException("Email already exists");
        }
        
        // Create entity
        User user = new User();
        user.setEmail(request.email());
        user.setPasswordHash(passwordEncoder.encode(request.password()));
        user.setRole(request.role());
        
        // Save
        User savedUser = userRepository.save(user);
        log.info("User created. UserId: {}, Email: {}", savedUser.getId(), savedUser.getEmail());
        
        // Return DTO
        return new UserResponse(
            savedUser.getId(),
            savedUser.getEmail(),
            savedUser.getRole(),
            savedUser.getCreatedAt()
        );
    }
    
    @Transactional(readOnly = true)
    public UserResponse getUserById(Long userId, Long requestingUserId) {
        // Authorization: BOLA check
        if (!userId.equals(requestingUserId)) {
            log.warn("Unauthorized access attempt. RequestingUserId: {}, TargetUserId: {}", 
                requestingUserId, userId);
            throw new UnauthorizedException("Access denied");
        }
        
        // Fetch
        User user = userRepository.findByIdAndIsDeletedFalse(userId)
            .orElseThrow(() -> new UserNotFoundException("User not found"));
        
        return new UserResponse(user.getId(), user.getEmail(), user.getRole(), user.getCreatedAt());
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUser(Long userId) {
        userRepository.softDeleteById(userId);
        log.info("User soft-deleted. UserId: {}", userId);
    }
}
```

---

## LAYER 5: Controller (REST API)

**Purpose:** Expose features via HTTP REST endpoints

**Template:**
```
Generate Controller for [feature]:

Class: [FeatureName]Controller
Base path: /api/v1/[resource]
Requirements: [Reference R00X]

Endpoints:
- [METHOD /path]: [description]
  - Auth: [Bearer token required? Yes/No]
  - Request body: [DTO name]
  - Response: [DTO name, status code]
  - Error codes: [400, 401, 403, 404, 500]
  - Example curl: [Include JWT if required]

Request validation:
- @Valid on @RequestBody
- @PathVariable, @RequestParam constraints

Response status codes:
- 200 OK: [When returned]
- 201 Created: [When returned]
- 204 No Content: [When returned]
- 400 Bad Request: [Input validation failed]
- 401 Unauthorized: [Missing/invalid token]
- 403 Forbidden: [BOLA check failed]
- 404 Not Found: [Resource not found]
- 500 Server Error: [Unexpected error]

Headers:
- Authorization: Bearer <JWT>
- X-Request-Id: <UUID> (auto-populated by AuthFilter)

Include:
- @RestController @RequestMapping("/api/v1/[resource]")
- @Valid on @RequestBody DTOs
- Extract userId from HttpServletRequest (set by AuthFilter)
- Use ResponseEntity<> for status control
- Javadoc + @Operation @ApiResponse for Swagger
- No business logic (delegate to Service)
- No try-catch (let GlobalExceptionHandler handle)
```

**Example Output:**
```java
@RestController
@RequestMapping("/api/v1/users")
@Slf4j
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody CreateUserRequest request) {
        UserResponse response = userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUser(
            @PathVariable Long userId,
            HttpServletRequest request) {
        Long requestingUserId = (Long) request.getAttribute("userId");
        UserResponse response = userService.getUserById(userId, requestingUserId);
        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable Long userId,
            HttpServletRequest request) {
        Long requestingUserId = (Long) request.getAttribute("userId");
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
```

---

## LAYER 6: Exception Handler (Global)

**Purpose:** Map exceptions to standardized HTTP responses (One per project)

**Template:**
```
Generate GlobalExceptionHandler:

Exceptions to handle:
- [CustomException1]: HTTP status [4xx], message [user-friendly]
- [CustomException2]: HTTP status [4xx], message [user-friendly]
- ValidationException (Spring): HTTP 422, include field errors
- Generic Exception: HTTP 500, Internal Server Error

Response format:
{
  "status": [HTTP code],
  "error": "[ErrorType]",
  "message": "[User-friendly message]",
  "timestamp": "[ISO 8601]",
  "requestId": "[from MDC]"
}

Security:
- Never include stack traces
- Never expose internal details
- Log full exception server-side
- Include requestId for audit trail

Include:
- @ControllerAdvice annotation
- @ExceptionHandler methods for each exception type
- @ExceptionHandler(Exception.class) as catch-all
- Return ResponseEntity<ErrorResponse>
```

**Example Output:**
```java
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFound(
            UserNotFoundException ex, HttpServletRequest request) {
        String requestId = MDC.get("request_id");
        ErrorResponse response = new ErrorResponse(
            404, "UserNotFound", "User not found", LocalDateTime.now(), requestId);
        log.error("User not found. RequestId: {}", requestId);
        return ResponseEntity.status(404).body(response);
    }
    
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorResponse> handleUnauthorized(
            UnauthorizedException ex, HttpServletRequest request) {
        String requestId = MDC.get("request_id");
        ErrorResponse response = new ErrorResponse(
            403, "Forbidden", "Access denied", LocalDateTime.now(), requestId);
        log.warn("Authorization failed. RequestId: {}", requestId);
        return ResponseEntity.status(403).body(response);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationError(
            MethodArgumentNotValidException ex, HttpServletRequest request) {
        String requestId = MDC.get("request_id");
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
            errors.put(error.getField(), error.getDefaultMessage()));
        ErrorResponse response = new ErrorResponse(
            422, "ValidationFailed", "Input validation failed", 
            LocalDateTime.now(), requestId);
        log.warn("Validation failed. RequestId: {}, Errors: {}", requestId, errors);
        return ResponseEntity.status(422).body(response);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(
            Exception ex, HttpServletRequest request) {
        String requestId = MDC.get("request_id");
        ErrorResponse response = new ErrorResponse(
            500, "InternalServerError", "Unexpected error", 
            LocalDateTime.now(), requestId);
        log.error("Unexpected exception. RequestId: {}. Exception: ", requestId, ex);
        return ResponseEntity.status(500).body(response);
    }
}
```

---

## LAYER 7: Config (Spring Beans & Settings)

**Purpose:** Wire Spring beans and configure application-wide settings

**Template:**
```
Generate Configuration class for [feature]:

Class: [FeatureName]Config
Requirements: [Reference requirement]

Beans to create:
- [Bean 1]: [Description]
- [Bean 2]: [Description]
- [Bean 3]: [Description]

Environment properties:
- [Property 1]: from application.properties
- [Property 2]: from @Value("${property.name}")

Security settings:
- [Setting 1]
- [Setting 2]

Include:
- @Configuration annotation
- @Bean methods
- @Value("${property.from.application.properties}")
- Javadoc on each bean
```

**Example Output:**
```java
@Configuration
public class SecurityConfig {
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/**").permitAll()
                .requestMatchers("/actuator/health").permitAll()
                .anyRequest().authenticated())
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .csrf(csrf -> csrf.disable())
            .build();
    }
    
    @Bean
    public CorsConfigurationSource corsConfigurationSource(
            @Value("${app.allowed-origins}") String allowedOrigins) {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList(allowedOrigins.split(",")));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(Arrays.asList("*"));
        config.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}

@Configuration
public class WebConfig {
    
    @Bean
    public RestTemplate restTemplate() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(5000); // 5 seconds
        factory.setReadTimeout(5000);
        return new RestTemplate(factory);
    }
}
```

---

## LAYER 8: Filters & Interceptors (HTTP)

**Purpose:** Cross-cutting concerns (logging, auth, request tracking)

**Template:**
```
Generate Filter for [purpose]:

Purpose: [What does this filter do?]
Order: [When in chain? e.g., @Order(1), @Order(2)]

Before processing:
- [Capture request data]
- [Validate something]

After response:
- [Clean up resources]

Data flow:
- Extract [Data] → store in [MDC/attribute]

Include:
- Extend OncePerRequestFilter
- @Component @Order([priority])
- MDC.put() for context
- request.setAttribute()
- No business logic
```

**Example Output:**
```java
@Component
@Order(1)
@Slf4j
public class LoggingFilter extends OncePerRequestFilter {
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, 
            HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        String requestId = UUID.randomUUID().toString();
        String clientIp = request.getHeader("X-Forwarded-For") != null ?
            request.getHeader("X-Forwarded-For") : request.getRemoteAddr();
        
        MDC.put("request_id", requestId);
        MDC.put("client_ip", clientIp);
        MDC.put("method", request.getMethod());
        MDC.put("uri", request.getRequestURI());
        
        long startTime = System.currentTimeMillis();
        try {
            filterChain.doFilter(request, response);
        } finally {
            long duration = System.currentTimeMillis() - startTime;
            log.info("Response: {} in {}ms", response.getStatus(), duration);
            MDC.clear();
        }
    }
}

@Component
@Order(2)
@Slf4j
public class AuthFilter extends OncePerRequestFilter {
    
    @Autowired
    @Qualifier("jwtTokenProvider")
    private TokenProvider tokenProvider;
    
    private static final List<String> PUBLIC_PATHS = Arrays.asList(
        "/auth/", "/actuator/health");
    
    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        // Skip public paths
        if (isPublicPath(request.getRequestURI())) {
            filterChain.doFilter(request, response);
            return;
        }
        
        // Extract token
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Missing token");
            return;
        }
        
        String token = authHeader.substring(7);
        try {
            // Validate token
            JwtClaims claims = tokenProvider.validateToken(token);
            
            // Extract claims
            Long userId = claims.getSubject() != null ? Long.parseLong(claims.getSubject()) : null;
            String role = claims.getStringClaimValue("role");
            String email = claims.getStringClaimValue("email");
            
            // Set request attributes
            request.setAttribute("userId", userId);
            request.setAttribute("role", role);
            request.setAttribute("email", email);
            
            // Set MDC
            MDC.put("user_id", userId.toString());
            MDC.put("user_role", role);
            
            filterChain.doFilter(request, response);
        } catch (Exception ex) {
            log.warn("Token validation failed: {}", ex.getMessage());
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
        }
    }
    
    private boolean isPublicPath(String uri) {
        return PUBLIC_PATHS.stream().anyMatch(uri::startsWith);
    }
}
```

---

## LAYER 9: Tests (Unit & Integration)

**Purpose:** Verify code correctness (interview signal: "I test my code")

**Template:**
```
Generate Tests for [class]:

Class under test: [ClassName]
Requirements: [Reference R00X]

Unit Tests (with mocks):
- Test: [Happy path]
  - Setup: [Mock setup]
  - Action: [Call method]
  - Assert: [Verify result]

- Test: [Error case]
  - Setup: [Mock to fail]
  - Action: [Call method]
  - Assert: [Verify exception]

Integration Tests (with real DB):
- Test: [API endpoint happy path]
  - Setup: [Insert test data]
  - Action: [Call endpoint via MockMvc]
  - Assert: [Verify response + DB state]

- Test: [BOLA authorization]
  - Setup: [Two users, one resource]
  - Action: [User2 accesses User1's resource]
  - Assert: [Verify 403 Forbidden]

Include:
- @ExtendWith(MockitoExtension.class) for unit
- @SpringBootTest @AutoConfigureMockMvc for integration
- @Testcontainers PostgreSQLContainer (real DB, not H2)
- @Mock, @InjectMocks for unit tests
- ArgumentCaptor for verifying calls
- Javadoc on each test
```

**Example Output:**
```java
@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    
    @Mock
    UserRepository userRepository;
    
    @Mock
    PasswordEncoder passwordEncoder;
    
    @InjectMocks
    UserService userService;
    
    @Test
    void testCreateUserSuccess() {
        // Setup
        CreateUserRequest request = new CreateUserRequest(
            "test@example.com", "password123", Role.USER);
        User savedUser = new User();
        savedUser.setId(1L);
        savedUser.setEmail("test@example.com");
        savedUser.setRole(Role.USER);
        
        when(userRepository.existsByEmailAndIsDeletedFalse("test@example.com"))
            .thenReturn(false);
        when(passwordEncoder.encode("password123"))
            .thenReturn("hashed_password");
        when(userRepository.save(any(User.class)))
            .thenReturn(savedUser);
        
        // Action
        UserResponse response = userService.createUser(request);
        
        // Assert
        assertEquals(1L, response.id());
        assertEquals("test@example.com", response.email());
        verify(userRepository).save(any(User.class));
    }
    
    @Test
    void testCreateUserDuplicateEmail() {
        // Setup
        CreateUserRequest request = new CreateUserRequest(
            "test@example.com", "password123", Role.USER);
        when(userRepository.existsByEmailAndIsDeletedFalse("test@example.com"))
            .thenReturn(true);
        
        // Action & Assert
        assertThrows(DuplicateEmailException.class, () -> userService.createUser(request));
    }
    
    @Test
    void testGetUserByIdBOLA_Unauthorized() {
        // Setup
        Long userId = 1L;
        Long requestingUserId = 2L; // Different user
        
        // Action & Assert
        assertThrows(UnauthorizedException.class, 
            () -> userService.getUserById(userId, requestingUserId));
    }
}

@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
class UserControllerTest {
    
    @Container
    static PostgreSQLContainer<?> postgres = 
        new PostgreSQLContainer<>("postgres:15");
    
    @Autowired
    MockMvc mockMvc;
    
    @Autowired
    UserRepository userRepository;
    
    @Test
    void testCreateUserEndpoint_Success() throws Exception {
        // Action
        mockMvc.perform(post("/api/v1/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content("""
                {
                  "email": "test@example.com",
                  "password": "password123",
                  "role": "USER"
                }
                """))
            // Assert
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").isNumber())
            .andExpect(jsonPath("$.email").value("test@example.com"));
        
        // Verify DB state
        User savedUser = userRepository.findByEmail("test@example.com").orElseThrow();
        assertNotNull(savedUser);
    }
    
    @Test
    void testGetUserEndpoint_BOLA_Forbidden() throws Exception {
        // Setup
        User user1 = userRepository.save(new User(/* user1 data */));
        User user2 = userRepository.save(new User(/* user2 data */));
        String token = jwtGenerator.generateToken(user2.getId(), "USER");
        
        // Action
        mockMvc.perform(get("/api/v1/users/" + user1.getId())
            .header("Authorization", "Bearer " + token))
            // Assert
            .andExpect(status().isForbidden());
    }
}
```

---

## Development Workflow

### For Each Feature, Follow This Order:

```
1. Entity (10 min)
   → @Entity, @Table, relationships, constraints
   Interview signal: "Modeled data with proper constraints and indexes"

2. DTO (5 min)
   → Request/Response records, @Valid annotations
   Interview signal: "Defined clear API contracts with validation"

3. Repository (5 min)
   → Extend JpaRepository, @Query methods, pagination
   Interview signal: "Wrote efficient queries with proper indexing"

4. Service (20 min) ⭐ Most important
   → Business logic, error handling, logging, @Transactional
   Interview signal: "Implemented secure, transactional logic with BOLA checks"

5. Controller (10 min)
   → REST endpoints, @Valid, ResponseEntity, status codes
   Interview signal: "Exposed clean REST APIs with proper HTTP semantics"

6. Exception Handler (5 min) - Once per project
   → GlobalExceptionHandler, @ControllerAdvice
   Interview signal: "All errors mapped to user-friendly responses"

7. Config (5 min)
   → @Configuration, @Bean methods, security settings
   Interview signal: "Properly configured Spring components"

8. Filters (5 min)
   → LoggingFilter, AuthFilter for cross-cutting concerns
   Interview signal: "Implemented request tracking and authentication"

9. Tests (30 min) ⭐ Interview loves this
   → Unit (Mockito) + Integration (Testcontainers + PostgreSQL)
   → BOLA tests, happy paths, error cases
   Interview signal: "Tested authorization, edge cases, and real database"

Total per feature: ~1.5 hours (with AI assistance)
Total per feature: ~3-4 hours (self-implemented from template)
```

---

## Self-Implementation Pattern

If building without AI prompts:

1. **Copy existing feature folder** (e.g., copy `user/` as template for `product/`)
2. **Rename all classes and files** to match new feature
3. **Update Entity fields** (add domain-specific fields)
4. **Update Repository queries** (for new fields)
5. **Update Service business logic** (new domain rules)
6. **Update Controller endpoints** (new paths, new DTOs)
7. **Copy test file** and rename; update test data and assertions
8. **Run tests locally** (`mvn test`)
9. **Git commit** with feature branch name

---

## Project Structure 

```
src/main/java/com/example/yourapp/
├── [feature1]/
│   ├── entity/
│   │   ├── User.java
│   │   ├── Order.java
│   │   └── Role.java (enum)
│   ├── dto/
│   │   ├── CreateUserRequest.java
│   │   ├── UserResponse.java
│   │   └── ErrorResponse.java
│   ├── repository/
│   │   ├── UserRepository.java
│   │   └── OrderRepository.java
│   ├── service/
│   │   ├── UserService.java
│   │   └── OrderService.java
│   ├── controller/
│   │   ├── UserController.java
│   │   └── OrderController.java
├── config/
│   ├── SecurityConfig.java
│   ├── WebConfig.java
│   └── JpaConfig.java
├── filter/
│   ├── LoggingFilter.java
│   ├── AuthFilter.java
│   └── RequestIdFilter.java
├── exception/
│   ├── GlobalExceptionHandler.java
│   ├── UserNotFoundException.java
│   ├── UnauthorizedException.java
│   └── DuplicateEmailException.java
└── util/
    └── TokenProvider.java

src/test/java/com/example/yourapp/
├── [feature1]/
│   ├── UserServiceTest.java
│   ├── UserControllerTest.java
│   └── OrderServiceTest.java

src/main/resources/
├── application.properties
└── application-test.properties

pom.xml
```

---

