# Requirements Understanding Template (SDE-1)

- **Phase:** ADLC Step 2 (Understand)
- **Owner:** You (SDE-1 Backend)
- **Input:** Requirement document (from PM/designer/stakeholder)
- **Output:** Organized requirement details in structured format

**Scope:** Pure CRUD - data models, endpoints, validation, testing. Nothing else.

---

## Part 1: Requirement Overview

**Requirement ID:** R001

**Title:** [One-line description]
Example: "User management API"

**Description:**
[Copy/paste requirement text]

**Acceptance Criteria:**
- [ ] [Criterion 1]
- [ ] [Criterion 2]
- [ ] [Criterion 3]

**Priority:** P0 / P1 / P2 / P3

**Effort Estimate:** [hours]

---

## Part 2: Data Model

### 2.1 What entities?

| Entity | Fields | Example |
|---|---|---|
| User | id, name, email, createdAt | id=1, name="Alice", email="alice@example.com" |
| Order | id, userId, total, status, createdAt | id=101, userId=1, total=100.50, status="PENDING" |
| [Entity 3] | [fields] | [example] |

**Ask PM:**
- What entities (tables) need to be created/modified?
- What fields on each?
- Required vs optional fields?
- Enums? (e.g., status: PENDING, CONFIRMED, SHIPPED)

### 2.2 Relationships

```
User (1) ──── (N) Order
User (1) ──── (N) Address
Order (1) ──── (N) OrderItem
```

**Ask PM:**
- Is it 1:N, N:1, N:N, or 1:1?
- Cascade delete? (if User deleted, delete Orders?)
- Soft delete or hard delete?

### 2.3 Field Constraints

| Field | Constraint | Validation |
|---|---|---|
| email | Unique, Required | @Email, @NotBlank, @Column(unique=true) |
| name | Required, max 100 chars | @NotBlank, @Size(max=100) |
| total | Positive number | @Positive, @DecimalMin("0.01") |
| status | Enum (PENDING, SHIPPED) | @Enumerated(EnumType.STRING) |
| createdAt | Auto-populated, not null | @CreationTimestamp |

**Ask PM:**
- Which fields are required?
- Unique constraints? (email, username, etc.)
- Format validation? (email, phone, etc.)
- Min/max values? (length, numbers)
- Auto-populate fields? (createdAt, updatedAt)

---

## Part 3: API Endpoints

### 3.1 List all endpoints

| Method | Path | Purpose | Status | Request | Response |
|---|---|---|---|---|---|
| GET | /api/v1/users | List all users (paginated) | 200 | - | Page<UserResponse> |
| POST | /api/v1/users | Create user | 201 | CreateUserRequest | UserResponse |
| GET | /api/v1/users/{userId} | Get user by ID | 200 | - | UserResponse |
| PUT | /api/v1/users/{userId} | Update user | 200 | UpdateUserRequest | UserResponse |
| DELETE | /api/v1/users/{userId} | Delete user | 204 | - | (empty) |
| POST | /api/v1/orders | Create order | 201 | CreateOrderRequest | OrderResponse |
| GET | /api/v1/orders/{orderId} | Get order by ID | 200 | - | OrderResponse |
| [METHOD] | [PATH] | [PURPOSE] | [STATUS] | [REQUEST] | [RESPONSE] |

**Ask PM:**
- What CRUD operations needed? (Create, Read, Update, Delete, List)
- Pagination on list endpoints?
- What HTTP status codes?
- Any search/filter endpoints?

### 3.2 Request/Response Examples

#### POST /api/v1/users

**Request DTO:**
```json
{
  "name": "Alice",
  "email": "alice@example.com",
  "phone": "+1234567890"
}
```

**Response DTO (201 Created):**
```json
{
  "id": 1,
  "name": "Alice",
  "email": "alice@example.com",
  "phone": "+1234567890",
  "createdAt": "2025-01-15T10:30:00Z"
}
```

**Errors:**
- 400 Bad Request: Missing required fields, invalid email format, email already exists
- 500 Server Error: Database error

#### GET /api/v1/users (paginated list)

**Request:**
```
GET /api/v1/users?page=0&size=10&sort=createdAt,desc
```

**Response (200 OK):**
```json
{
  "content": [
    {"id": 1, "name": "Alice", "email": "alice@example.com", "createdAt": "2025-01-15T10:30:00Z"},
    {"id": 2, "name": "Bob", "email": "bob@example.com", "createdAt": "2025-01-14T09:15:00Z"}
  ],
  "totalElements": 2,
  "totalPages": 1,
  "size": 10,
  "number": 0
}
```

#### PUT /api/v1/users/{userId}

**Request DTO:**
```json
{
  "name": "Alice Updated",
  "phone": "+9876543210"
}
```

**Response DTO (200 OK):**
```json
{
  "id": 1,
  "name": "Alice Updated",
  "email": "alice@example.com",
  "phone": "+9876543210",
  "createdAt": "2025-01-15T10:30:00Z",
  "updatedAt": "2025-01-15T11:45:00Z"
}
```

**Ask PM:**
- Exact field names in requests/responses?
- Are all fields returned or only some?
- What's included in list vs detail response?
- Date/time format? (ISO 8601)

### 3.3 Pagination & Sorting

| Question | Answer |
|---|---|
| Paginate list endpoints? | Yes, default 10 per page, max 100 |
| Sortable fields? | id, name, createdAt, updatedAt |
| Default sort? | createdAt DESC (newest first) |

**Ask PM:**
- Default page size? Max page size?
- Which fields sortable?
- Default sort order?

### 3.4 Error Responses

**Format:**
```json
{
  "status": 400,
  "error": "BadRequest",
  "message": "Email format invalid",
  "timestamp": "2025-01-15T10:30:00Z"
}
```

| Error Scenario | Status | Message |
|---|---|---|
| Missing required field | 400 | "Field 'name' is required" |
| Invalid email format | 400 | "Email format invalid" |
| User not found | 404 | "User not found" |
| Duplicate email | 400 | "Email already exists" |
| Database error | 500 | "Internal server error" |

**Ask PM:**
- What error cases can happen?
- User-friendly error messages?
- Include field names in validation errors?

---

## Part 4: Business Logic

### 4.1 Workflows

**Create User:**
```
1. Receive CreateUserRequest (name, email, phone)
2. Validate fields (required, format)
3. Check if email already exists → if yes, return 400
4. Create User entity
5. Save to database
6. Return UserResponse with generated id and createdAt
```

**List Users (Paginated):**
```
1. Receive query params (page, size, sort)
2. Query database (ORDER BY sort, LIMIT size OFFSET (page * size))
3. Return Page<UserResponse> with pagination metadata
```

**Update User:**
```
1. Receive UpdateUserRequest (name, phone)
2. Look up User by id → if not found, return 404
3. Update fields (only provided ones)
4. Save to database
5. Return updated UserResponse
```

**Delete User:**
```
1. Look up User by id → if not found, return 404
2. Soft delete (set isDeleted=true) OR hard delete
3. Return 204 No Content
```

**Ask PM:**
- Step-by-step for each operation?
- Validations at each step?
- What to do on error?
- Soft delete or hard delete?

### 4.2 Business Rules

| Rule | Example |
|---|---|
| Email uniqueness | Can't have two users with same email |
| Name required | User must have a name |
| Email format | Must be valid email (user@domain.com) |
| Phone optional | Phone can be null/empty |
| Order status flow | Can go PENDING → CONFIRMED → SHIPPED → DELIVERED (not backwards) |
| Soft delete | Don't hard delete; mark isDeleted=true, filter in queries |

**Ask PM:**
- What must always be true?
- What transitions are allowed?
- What validations must pass?

### 4.3 Data Validation

| Field | Validation | Rule |
|---|---|---|
| email | @Email, @NotBlank | Must be valid email, required |
| name | @NotBlank, @Size(max=100) | Required, max 100 chars |
| phone | @Pattern(regex) | Optional, but if provided must match format |
| total (Order) | @Positive, @DecimalMin("0.01") | Must be > 0 |
| status (Order) | @Enumerated | Must be one of: PENDING, CONFIRMED, SHIPPED, DELIVERED |

**Ask PM:**
- Validation rules for each field?
- Min/max lengths?
- Regular expressions for format?
- Enum values?

---

## Part 5: Database

### 5.1 Data Volume & Performance

| Question | Answer | Impact |
|---|---|---|
| Expected # of users? | 10K initially | Indexing on email for lookup |
| Expected # of orders? | 50K initially | Index on userId for filtering |
| Query complexity? | Simple lookups (by id, email) | No complex JOINs needed |
| Soft delete needed? | Yes, keep audit trail | Always filter isDeleted=false |

**Ask PM:**
- How many records expected?
- Simple lookups or complex queries?
- Need to keep deleted records?

### 5.2 Indexes

| Table | Index | Reason |
|---|---|---|
| users | (email) UNIQUE | Fast lookup by email, prevent duplicates |
| users | (created_at) | Sorting by creation date |
| orders | (user_id) | Filter orders by user |
| orders | (status) | Filter by order status |
| orders | (user_id, created_at) | Composite: find recent orders per user |

**Ask PM:**
- Which fields queried most?
- Need compound indexes?

---

## Part 6: Validation & Testing

### 6.1 Unit Tests (JUnit + Mockito)

**Test happy path:**
- [ ] Create user with valid data → returns UserResponse
- [ ] Get user by id → returns UserResponse
- [ ] Update user → updates fields correctly
- [ ] Delete user → soft delete sets isDeleted=true
- [ ] List users → returns paginated Page<UserResponse>

**Test error cases:**
- [ ] Create user with duplicate email → returns 400
- [ ] Get non-existent user → returns 404
- [ ] Create user missing required field → returns 400
- [ ] Invalid email format → returns 400

**Mock dependencies:**
- @Mock UserRepository
- Test Service layer (UserService)

### 6.2 Integration Tests (Spring Boot + Testcontainers)

**Test with real database (PostgreSQL):**
- [ ] Create user → verify saved in DB
- [ ] Query user → verify correct data retrieved
- [ ] Update user → verify DB updated
- [ ] Delete user → verify isDeleted=true in DB
- [ ] List users paginated → verify pagination metadata

**Use:**
- @SpringBootTest (full Spring context)
- @Testcontainers with PostgreSQL (real DB, not H2)
- MockMvc to call REST endpoints
- Verify both response and database state

---

## Part 7: Checklist (Before Analyze Phase)

**Data Model:**
- [ ] All entities identified
- [ ] All fields documented
- [ ] Relationships understood
- [ ] Field constraints known
- [ ] Soft delete vs hard delete decided

**API:**
- [ ] All endpoints listed (method, path, status)
- [ ] Request/response examples provided
- [ ] Pagination documented
- [ ] Error cases documented

**Business Logic:**
- [ ] Workflows understood
- [ ] Business rules documented
- [ ] Validations clear

**Testing:**
- [ ] Unit test cases identified
- [ ] Integration test cases identified
- [ ] Error cases to test listed

**Database:**
- [ ] Data volume understood
- [ ] Index strategy identified

### If ANY unchecked → Ask PM for clarification

---

## Part 8: Summary (1 Page)

```markdown
# R001: User Management API - Summary

## Entities
- User (id, name, email, phone, createdAt, updatedAt, isDeleted)

## Endpoints
- GET /api/v1/users → Page<UserResponse> (paginated)
- POST /api/v1/users → UserResponse (201)
- GET /api/v1/users/{userId} → UserResponse (200)
- PUT /api/v1/users/{userId} → UserResponse (200)
- DELETE /api/v1/users/{userId} → 204 No Content

## Key Rules
- Email unique
- Email format validation
- Soft delete (isDeleted=true)
- Pagination: default 10, max 100
- Sort by: id, name, createdAt, updatedAt

## Indexes
- (email) UNIQUE
- (created_at)

## Dependencies
- None (standalone feature)

## Effort
- 8 hours (1 day sprint)
```

---

## Tips

1. **Fill top-to-bottom** (Part 1 → 8)
2. **Ask PM** if unclear
3. **Use real examples** (actual JSON, field values)
4. **Mark unknowns** with ❓
5. **Share with PM** before Analyze

---

**End Goal:** Zero unknowns before Analyze phase.
