
# Design / LLD Template

## Design R001_D01 — [Feature / Solution Name]

- **Requirement:** R001
- **Decision:** R001_D01
- **Phase:** Design
- **Input:** 
  - `/ai-context/requirements/R001.md`
  - `/ai-context/decisions/R001_D01.md`
- **Output:** `/ai-context/design/R001_D01.md`

---

## 1. Design Objective

> [What are we designing and what should the design achieve?]

---

## 2. Solution Overview

> [Briefly describe the selected technical solution.]

```text
[Client]
   ↓
[Controller]
   ↓
[Service]
   ↓
[Repository]
   ↓
[Database]
````

---

## 3. Architecture / Component Design

### Components

| Component   | Responsibility   |
| ----------- | ---------------- |
| [Component] | [Responsibility] |

### Component Interactions

```text
[Component A]
      ↓
[Component B]
      ↓
[Component C]
```

---

## 4. LLD

### Classes

| Class   | Responsibility   |
| ------- | ---------------- |
| [Class] | [Responsibility] |

### Interfaces

| Interface   | Responsibility   |
| ----------- | ---------------- |
| [Interface] | [Responsibility] |

### Relationships

```text
[Class A]
     │
     ├── uses
     ↓
[Class B]
```

### Methods

| Class   | Method       | Purpose   |
| ------- | ------------ | --------- |
| [Class] | `[method()]` | [Purpose] |

### Design Patterns

| Pattern   | Where Used  | Reason   |
| --------- | ----------- | -------- |
| [Pattern] | [Component] | [Reason] |

> Use a design pattern only when it solves an actual design problem. Do not add patterns for the sake of using patterns.

---

## 5. API Design

> Define new APIs here when the requirement needs them.

### Endpoint

| Method | Endpoint      | Purpose   |
| ------ | ------------- | --------- |
| POST   | `/api/v1/...` | [Purpose] |

### Request

```json
{
  "field": "value"
}
```

### Response

```json
{
  "id": 1,
  "status": "..."
}
```

### HTTP Status Codes

| Status | Condition   |
| ------ | ----------- |
| 200    | [Condition] |
| 201    | [Condition] |
| 400    | [Condition] |
| 404    | [Condition] |
| 500    | [Condition] |

---

## 6. Data Design

### Entities

| Entity   | Purpose   |
| -------- | --------- |
| [Entity] | [Purpose] |

### Entity Fields

| Entity   | Field   | Type   | Constraints   |
| -------- | ------- | ------ | ------------- |
| [Entity] | [Field] | [Type] | [Constraints] |

### Relationships

```text
[Entity A] 1 ───── * [Entity B]
```

### Database Changes

* [Table]
* [Column]
* [Index]
* [Constraint]

---

## 7. Validation & Error Handling Design

### Input Validation

* [Validation rule]

### Business Validation

* [Business rule]

### Error Handling

| Error   | HTTP Status | Handling   |
| ------- | ----------- | ---------- |
| [Error] | 400         | [Handling] |
| [Error] | 404         | [Handling] |

---

## 8. Logging & Observability

### Logging

* [Important events to log]
* [Error conditions to log]

### Metrics

* [Metric if required]

### Monitoring

* [Health/monitoring requirement]

---

## 9. Testing Design

### Unit Tests

* [Class/service to test]

### Integration Tests

* [Integration to test]

### API Tests

* [Endpoint to test]

### Test Scenarios

| Scenario   | Expected Result |
| ---------- | --------------- |
| [Scenario] | [Result]        |

---

## 10. Implementation Structure

### Files / Packages

```text
src/
├── main/
|    ├── java/
|    │   └── com/example/.../
|    │       ├── controller/
|    │       ├── service/
|    │       ├── repository/
|    │       ├── entity/
|    │       ├── dto/
|    │       ├── exception/
|    │       ├── config/
|    │       ├── util/
|    │       └── Main.java
|    │
|    └── resources/
|        └── application.properties
|
├── test/                      
|    └── java/
|        └── com/example/.../
|
└──pom.xml
```

### Files to Create

* `[path]`
* `[path]`

### Files to Modify

* `[path]`
* `[path]`

