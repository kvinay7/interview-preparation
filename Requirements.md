# Requirements Understanding Template

- **Phase:** ADLC Step 2 (Understand)
- **Owner:** You (SDE-1 Backend)
- **Input:** Requirement document (from PM/designer/stakeholder)
- **Output:** Organized requirement details in structured format

**Goal:** Extract all necessary details to move to Analyze phase without blocking.

---

## Part 1: Requirement Overview

**Requirement ID:** R001 (from JIRA/ticket)

**Title:** [One-line description]
Example: "User authentication with JWT and refresh tokens"

**Description (from spec):**
[Copy/paste the full requirement text]

**Acceptance Criteria (from spec):**
- [ ] [Criterion 1]
- [ ] [Criterion 2]
- [ ] [Criterion 3]

**Related Requirements:**
- R002 (dependency - must understand first)
- R010 (related, but separate implementation)

**Priority:** P0 (blocking) / P1 (high) / P2 (medium) / P3 (low)

**Estimated Effort:** [Provided by PM or your estimate]

---

## Part 2: Data Model Questions

**Fill these out by asking PM/designer or inferring from spec:**

### 2.1 What entities are involved?

| Entity | Example Fields | Relationships | Notes |
|---|---|---|---|
| User | id, email, password, role, createdAt | 1:N with Order | Primary actor |
| Order | id, userId, total, status, createdAt | N:1 with User | What business data? |
| [Entity 3] | [Fields] | [Relationships] | [Notes] |

**Questions to ask:**
- What entities need to be created/modified in this requirement?
- Are there existing entities we reuse?
- What fields are required vs optional?
- Are there enum fields (status, role, type)?
- Do we soft-delete or hard-delete?

### 2.2 What are the relationships?

```
User (1) ──── (N) Order
User (1) ──── (N) RefreshToken
Order (1) ──── (N) OrderItem
```

**Questions to ask:**
- Is it one-to-many, many-to-one, many-to-many?
- Is the relationship bidirectional (both sides reference)?
- Cascade rules? If User is deleted, delete Orders?
- Are there composite keys or foreign key constraints?

### 2.3 What constraints/validations exist?

| Field | Constraint | Example |
|---|---|---|
| email | Unique, Required, Email format | user@example.com |
| password | Min 8 chars, max 128, Required | hashed (BCrypt) |
| status | Enum (PENDING, APPROVED, REJECTED) | PENDING |
| amount | Positive number, Required | 100.50 |
| createdAt | Auto-populated, Not null | 2025-01-15T10:30:00Z |

**Questions to ask:**
- What fields are mandatory?
- What uniqueness constraints? (email, username, external ID)
- What format validations? (email, phone, UUID, date range)
- Min/max values for numbers/strings?
- Are there database-level constraints or application-level only?

---

## Part 3: API Contract Questions

**Fill these out by reading spec or asking PM:**

### 3.1 What API endpoints are needed?

| Method | Path | Purpose | Request DTO | Response DTO | Status | Errors |
|---|---|---|---|---|---|---|
| POST | /api/v1/auth/login | User login | LoginRequest (email, password) | LoginResponse (accessToken, expiresIn) | 201 | 400, 401 |
| POST | /api/v1/auth/refresh | Refresh token | RefreshRequest (refreshToken) | LoginResponse | 200 | 401 |
| GET | /api/v1/users/{userId} | Get user profile | - | UserResponse | 200 | 401, 403, 404 |
| [METHOD] | [PATH] | [PURPOSE] | [REQUEST] | [RESPONSE] | [STATUS] | [ERRORS] |

**Questions to ask:**
- What HTTP methods (GET, POST, PUT, DELETE, PATCH)?
- What are the paths? (/api/v1/users, /api/v1/orders, etc.)
- What request body (if POST/PUT)?
- What response body (if any)?
- What HTTP status codes for success and errors?
- Do endpoints require authentication (Bearer token)?
- Are there pagination requirements (page size, sorting)?

### 3.2 Request/Response Details

**For each endpoint, document:**

#### Endpoint: POST /api/v1/auth/login

**Request DTO:**
```json
{
  "email": "user@example.com",
  "password": "password123"
}
```

**Response DTO (Success - 201 Created):**
```json
{
  "accessToken": "eyJhbGc...",
  "expiresIn": 900,
  "tokenType": "Bearer",
  "refreshToken": "refresh_token_here"
}
```

**Error Responses:**
- 400 Bad Request: Missing email or password
- 401 Unauthorized: Email not found or password incorrect
- 500 Internal Server Error: Database error

**Questions to ask:**
- Exact field names in request/response?
- Are there nested objects?
- What are field types and formats?
- Optional vs required fields?
- Example values?

### 3.3 Authentication & Authorization

| Question | Answer |
|---|---|
| Is authentication required? | Yes, Bearer JWT token |
| Token type? | JWT |
| Token expiry? | 15 minutes (900 seconds) |
| Refresh token? | Yes, 7 days |
| Authorization type? | Role-based (USER, ADMIN) |
| BOLA checks? | Yes, user can only access own profile/orders |

**Questions to ask:**
- Is this endpoint public or authenticated?
- What token format (JWT, OAuth2, API key)?
- What roles/permissions are needed?
- BOLA check: Can user A access user B's data? (Answer: NO)
- Rate limiting? (e.g., 100 requests/hour per user)

### 3.4 Pagination & Sorting

| Question | Answer |
|---|---|
| Are list endpoints paginated? | Yes, for /users, /orders |
| Default page size? | 20 |
| Max page size? | 100 |
| Sortable fields? | createdAt, updatedAt, name |
| Default sort order? | createdAt DESC |

**Questions to ask:**
- Which endpoints return lists?
- Default and max page size?
- Which fields can be sorted?
- Cursor-based or offset-based pagination?

---

## Part 4: Business Logic Questions

**Fill these out by understanding the "why" behind the requirement:**

### 4.1 Workflows & Sequences

**Example: User Login Flow**
```
User submits email + password
→ Verify email exists in DB
→ Compare password with BCrypt hash
→ Generate JWT access token (15 min expiry)
→ Generate refresh token (7 day expiry, store in DB, hash before storing)
→ Return both tokens to user
→ User includes access token in Authorization header for future requests
→ When access token expires, use refresh token to get new pair
→ On logout, delete refresh token from DB (invalidate it)
```

**Questions to ask:**
- What is the step-by-step flow?
- What data transformations happen?
- What external APIs are called (if any)?
- Are there async operations?
- What happens on error/retry?

### 4.2 Business Rules

| Rule | Constraint | Example |
|---|---|---|
| Email uniqueness | Each user has unique email | user@example.com can only register once |
| Password hashing | Never store plain passwords | Must use BCrypt with cost 12 |
| Token expiry | Access token valid 15 min | After 15 min, user must refresh |
| Refresh token storage | Store hashed in DB | Compare against hash on refresh |
| BOLA | User can only access own data | User 1 cannot GET /users/2/orders |

**Questions to ask:**
- Are there business rules that prevent certain operations?
- What validations must pass before proceeding?
- Are there rate limits or quotas?
- Are there audit/compliance requirements?

### 4.3 Error Handling

| Error Scenario | Response | Status | Message |
|---|---|---|---|
| Email not found | 401 Unauthorized | "Invalid credentials" (don't reveal email doesn't exist) |
| Password wrong | 401 Unauthorized | "Invalid credentials" (same message, prevent user enumeration) |
| Token expired | 401 Unauthorized | "Token expired, please refresh" |
| User doesn't own resource | 403 Forbidden | "Access denied" |
| Input validation fails | 400 Bad Request | "Email format invalid" |

**Questions to ask:**
- What error cases must be handled?
- What should the error message say (user-friendly vs technical)?
- Should we reveal or hide details (e.g., "user not found" vs "invalid credentials")?
- Should errors be logged and monitored?

---

## Part 5: Performance & Scale Questions

**Fill these out for production readiness:**

### 5.1 Database

| Question | Answer | Impact |
|---|---|---|
| How many users expected? | 100K initially | Indexing strategy |
| How many requests/sec? | 100 req/sec during peak | Connection pool size |
| Are queries complex? | Yes, JOIN with multiple tables | Need query optimization |
| Soft delete or hard delete? | Soft delete (keep audit trail) | Always filter isDeleted=false |
| Backup/retention policy? | 30 days backup, 1 year retention | Storage & compliance |

**Questions to ask:**
- Expected data volume?
- Query complexity (simple lookups vs complex joins)?
- Do we need indexes (and on which fields)?
- Backup/recovery requirements?
- Data retention policies?

### 5.2 Caching

| Question | Answer |
|---|---|
| Should we cache user profiles? | No, frequently changes |
| Should we cache roles/permissions? | Yes, rarely change |
| Cache TTL? | 1 hour |
| Cache strategy? | Invalidate on role update |

**Questions to ask:**
- What data is read-heavy and rarely changes?
- How long can data be stale?
- Invalidation strategy (TTL, event-based)?

### 5.3 Monitoring

| Metric | Alert Threshold |
|---|---|
| API latency (p99) | > 500ms |
| Error rate | > 1% |
| Login success rate | < 99% |
| Database connection pool | > 80% utilization |

**Questions to ask:**
- What should we monitor (latency, error rate, throughput)?
- What are acceptable SLAs?
- Alert thresholds?

---

## Part 6: Dependencies & Blockers

**Identify what you need from others:**

### 6.1 Dependencies

| Item | Owner | Status | Notes |
|---|---|---|---|
| User entity design (R000) | PM/Backend | ✅ Done | Already implemented |
| PasswordEncoder configuration | Ops/Security | ⏳ In Progress | Need password policy doc |
| JWT secret management | Ops/Security | ❌ Blocked | Need KMS setup |
| CORS configuration | Frontend/PM | ⏳ Waiting | Need frontend origin |

**Questions to ask:**
- Does this requirement depend on other requirements?
- Are upstream dependencies complete?
- Do we need secrets/config from Ops?
- Do we need API/library from another team?

### 6.2 Blockers

| Blocker | Resolution | Owner | ETA |
|---|---|---|---|
| JWT secret location (file vs environment) | Need security policy | Ops | Jan 20 |
| Refresh token storage location (in-memory vs DB) | Architecture decision needed | Tech Lead | Jan 18 |

**Questions to ask:**
- What unknown unknowns could block you?
- What decisions haven't been made?
- What needs architectural review?

---

## Part 7: Non-Functional Requirements

**Document cross-cutting concerns:**

### 7.1 Security

| Requirement | How | Example |
|---|---|---|
| No plain passwords | Hash with BCrypt | BCryptPasswordEncoder(12) |
| Token in headers | Authorization Bearer | Authorization: Bearer <JWT> |
| HTTPS only | Configure in prod | Secure=true on cookies |
| BOLA checks | Verify user owns resource | if (!userId.equals(requestingUserId)) throw Unauthorized |
| Rate limiting | 100 req/min per user | Use Spring Security rate limit |
| No PII in logs | Mask sensitive data | Log email but never password |

### 7.2 Logging & Observability

| Requirement | How | Example |
|---|---|---|
| Request tracking | X-Request-Id header | MDC.put("request_id", uuid) |
| User context | Log userId | MDC.put("user_id", userId) |
| Error logging | Full exception + context | log.error("Login failed. UserId: {}", userId, ex) |
| Audit trail | Log all auth events | log.info("User logged in. UserId: {}", userId) |

### 7.3 Testing

| Requirement | How | Example |
|---|---|---|
| Unit tests | JUnit + Mockito | @Mock UserRepository in test |
| Integration tests | Testcontainers + PostgreSQL | @SpringBootTest with @Testcontainers |
| BOLA tests | Verify 403 on unauthorized access | User 2 accessing User 1's resource returns 403 |
| Happy path | Test success case | Login with valid credentials returns 201 |
| Error cases | Test all error paths | Login with invalid password returns 401 |

---

## Part 8: Clarification Checklist

**Before moving to Analyze phase, confirm you understand:**

### Data Model
- [ ] All entities identified
- [ ] All relationships documented
- [ ] All constraints/validations known
- [ ] Soft delete vs hard delete decision made
- [ ] Audit fields (createdAt, updatedAt) understood

### API Contract
- [ ] All endpoints listed (method, path, status codes)
- [ ] Request/response DTOs documented with examples
- [ ] Authentication & authorization requirements clear
- [ ] Pagination/sorting details known
- [ ] Error responses documented

### Business Logic
- [ ] Workflows/sequences understood
- [ ] Business rules & validations known
- [ ] Error handling strategy clear
- [ ] BOLA checks identified

### Technical
- [ ] Performance expectations known
- [ ] Database indexing strategy understood
- [ ] Monitoring/alerting thresholds set
- [ ] Dependencies/blockers identified
- [ ] Security requirements clear

### If ANY checkbox unchecked → Ask PM/designer for clarification

---

## Part 9: Open Questions

**Document questions to ask PM/designer:**

| Question | Answer | Resolved? |
|---|---|---|
| Should we store refresh tokens in DB or in-memory cache? | DB (for logout support) | ✅ |
| What's the password complexity requirement? | Min 8 chars, uppercase, digit | ✅ |
| Can users change email? | No, email is immutable | ✅ |
| Should we send confirmation email on signup? | Yes (async, out of scope for this req) | ✅ |
| What happens if token is compromised? | Logout invalidates all tokens | ⏳ Need to clarify scope |

---

## Part 10: Example Use Case

**One user journey through the requirement:**

```
1. Alice (new user) goes to signup page
   → POST /api/v1/auth/register with email=alice@example.com, password=MyPass123
   → Backend creates User entity, hashes password with BCrypt
   → Response: 201 Created, userId=5

2. Alice logs in
   → POST /api/v1/auth/login with email=alice@example.com, password=MyPass123
   → Backend verifies password against BCrypt hash
   → Generates JWT access token (15 min), refresh token (7 days)
   → Stores refresh token in DB (hashed)
   → Response: 201 Created, accessToken=..., refreshToken=...

3. Alice accesses her profile
   → GET /api/v1/users/5
   → Headers: Authorization: Bearer {accessToken}
   → AuthFilter validates JWT, extracts userId=5
   → Request attribute: userId=5
   → Controller: Verify request.getAttribute("userId") == 5 (BOLA check)
   → Response: 200 OK, UserResponse(id=5, email=alice@example.com, role=USER)

4. Alice's access token expires (after 15 min)
   → Frontend tries to GET /api/v1/users/5
   → Gets 401 Unauthorized (expired token)
   → Frontend calls POST /api/v1/auth/refresh with refreshToken=...
   → Backend hashes token, looks up in DB
   → Generates new accessToken (15 min), new refreshToken (7 days)
   → Deletes old refresh token from DB
   → Response: 200 OK, new tokens

5. Alice logs out
   → POST /api/v1/auth/logout with refreshToken=...
   → Backend hashes token, deletes from DB
   → Response: 204 No Content
   → Refresh token now invalid, cannot use anymore
```

---

## Output: Summary Document

**Once completed, create a 1-page summary:**

```markdown
# R001: User Authentication - Requirement Summary

## Entities
- User (id, email, password_hash, role, created_at, updated_at, is_deleted)
- RefreshToken (id, user_id, token_hash, expires_at, is_deleted)

## Endpoints
- POST /auth/login → LoginResponse (accessToken, refreshToken, expiresIn)
- POST /auth/refresh → LoginResponse
- POST /auth/logout → 204 No Content

## Key Rules
- Password: BCrypt hash, min 8 chars
- Access token: 15 min expiry
- Refresh token: 7 days expiry, stored hashed in DB
- BOLA: User can only refresh own tokens
- Error messages: Same for "user not found" and "password wrong" (prevent enumeration)

## Dependencies
- ✅ User entity complete
- ⏳ JWT secret setup (blocked on Ops)

## Questions
- None (all clarified)

## Effort Estimate
- 8 hours (1 day sprint)
```

Save this summary and move to **Analyze** phase.

---

## Tips for Using This Template

1. **Fill top-to-bottom** (Part 1 → Part 10)
2. **Ask PM/designer** if anything is unclear (don't assume)
3. **Use examples** (actual data values, JSON samples)
4. **Mark blockers** with ❌ (don't proceed until resolved)
5. **Update as you learn** (this document evolves)
6. **Share with PM** (confirm understanding before implementing)

---

**End Goal:** Move to Analyze phase with zero unknowns about what to build.
