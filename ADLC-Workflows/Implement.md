# Implementation Template

- **Input:**
  - `/ai-context/requirements/R001.md`
  - `/ai-context/analysis/R001_A01.md`
  - `/ai-context/design/R001_D01.md`
- **Output:** `/src`

---

## 1. Implementation Objective

> [What needs to be implemented according to the approved design.]

---

## 2. Implementation Scope

### Files to Create

- `[path]`
- `[path]`

### Files to Modify

- `[path]`
- `[path]`

### Files Not to Change

- `[path]`
- `[path]`

---

## 3. Implementation Order

```text
1. [Foundation / model]
       ↓
2. [Repository / data access]
       ↓
3. [Service / business logic]
       ↓
4. [Controller / API]
       ↓
5. [Exception / validation]
       ↓
6. [Tests]
````

---

## 4. Coding Standards

### General

* Follow the approved Design/LLD.
* Follow existing project conventions.
* Keep classes focused on a single responsibility.
* Prefer clear, readable code over unnecessary complexity.
* Avoid unnecessary abstractions.
* Do not introduce new technologies without justification.
* Do not modify unrelated code.

### Java

* Follow standard Java naming conventions.
* Use appropriate access modifiers.
* Prefer constructor injection.
* Use interfaces where they provide a meaningful abstraction.
* Use `final` where appropriate.
* Use generics safely.
* Avoid unnecessary `static` state.
* Avoid magic numbers and strings.
* Use `Optional` appropriately; do not use it indiscriminately.
* Use Streams/Lambdas when they improve readability, not merely to shorten code.

### Spring

* Follow the project's established package structure.
* Keep Controller, Service, Repository and DTO responsibilities separated.
* Use DTOs at API boundaries where required.
* Keep business logic in the Service layer.
* Keep persistence logic in the Repository/Data layer.
* Use validation at the appropriate boundary.
* Use centralized exception handling.
* Use configuration rather than hard-coded environment-specific values.

### Database

* Follow the approved data design.
* Use appropriate constraints and indexes.
* Avoid unnecessary queries.
* Avoid exposing persistence entities directly when DTOs are required.
* Follow transaction boundaries defined in the design.

### Logging

* Use the project's logging framework.
* Log meaningful business/system events.
* Use appropriate log levels.
* Do not log passwords, tokens, credentials, or sensitive data.
* Avoid excessive logging.

### Error Handling

* Handle expected errors explicitly.
* Use project-standard exceptions.
* Return appropriate HTTP status codes.
* Do not expose internal implementation details to clients.
* Preserve useful diagnostic information in server-side logs.

---

## 5. Implementation

### Component 1 — [Name]

**File:**

> `[path]`

**Responsibility:**

> [What this component does.]

**Implementation:**

> [Implement according to Design/LLD.]

---

### Component 2 — [Name]

**File:**

> `[path]`

**Responsibility:**

> [What this component does.]

**Implementation:**

> [Implement according to Design/LLD.]

---

## 6. Test Implementation

### Unit Tests

* [Test class]
* [Test scenario]

### Integration Tests

* [Test class]
* [Test scenario]

### API Tests

* [Endpoint]
* [Scenario]

### Test Coverage

* [ ] Happy path
* [ ] Validation failure
* [ ] Business-rule failure
* [ ] Not-found scenario
* [ ] Exception scenario
* [ ] Boundary cases
* [ ] Relevant integration scenarios

---

## 7. Implementation Verification

Before considering implementation complete:

* [ ] Code compiles
* [ ] Application starts successfully
* [ ] Required dependencies resolve
* [ ] Database changes work
* [ ] APIs work as designed
* [ ] Validation works
* [ ] Error handling works
* [ ] Logging works
* [ ] Unit tests pass
* [ ] Integration tests pass
* [ ] No unrelated functionality was changed
* [ ] Implementation matches Design/LLD

---

## 8. Implementation Status

**Status:** `In Progress`

### Completed

* [Item]

### Remaining

* [Item]

### Blockers

* [Blocker]

---

## Handoff

```text
Implement
    ↓
Validate → /src/test
    ↓
Review
    ↓
Document
    ↓
Prepare
    ↓
Deliver
```
