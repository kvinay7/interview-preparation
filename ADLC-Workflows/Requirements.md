# Requirement Template

## 1. Requirement

### Original Requirement

> [Paste the requirement exactly as received]

### Business Goal

> [Why is this requirement needed?]

### Problem

> [What problem does it solve?]

### Expected Outcome

> [What should happen when this requirement is completed?]

---

## 2. Scope

### In Scope

- [Item]
- [Item]

### Out of Scope

- [Item]
- [Item]

---

## 3. Functional Requirements

| ID | Requirement | Priority |
|---|---|---|
| FR001 | [Requirement] | P1 |
| FR002 | [Requirement] | P1 |

---

## 4. Business Rules

| ID | Rule |
|---|---|
| BR001 | [Business rule] |
| BR002 | [Business rule] |

---

## 5. Workflow

```text
Input
  ↓
Process
  ↓
Business Rules
  ↓
Expected Outcome
````

[Describe the required business workflow]

---

## 6. Acceptance Criteria

* [ ] [Criterion 1]
* [ ] [Criterion 2]
* [ ] [Criterion 3]

> Acceptance criteria must be objectively verifiable.

---

## 7. Dependencies

### Existing Features

* [Feature]

### External Systems

* [System]

### Other Requirements

* [Rxxx]

---

## 8. Constraints

* [Business constraint]
* [Timeline constraint]
* [Existing-system constraint]
* [Known technical constraint]

---

## 9. Known Information

* [Confirmed fact]
* [Confirmed fact]

---

## 10. Unknowns / Clarification Questions

### Unknowns

* [Unknown]
* [Unknown]

> Do not convert unknowns into assumptions.

### Clarification Questions

* [ ] [Question for Lead/Manager]
* [ ] [Question for Lead/Manager]

---

## Handoff

When requirement framing is complete:

```text
Requirement Framing
      ↓
Understanding     → /ai-context/requirements/R001.md
                                              ├── Requirement Framing
      ↓                                       └── Understanding
Analyze/Decide    → /ai-context/analysis/R001_A01.md
      ↓
Design/Learn      → /ai-context/design/R001_D01.md
      ↓
Implementation    → /src/main
      ↓
Validation/Review → /src/test
      ↓
Document/Prepare  → /docs
      ↓
Deliver/Deploy    → Git & CI/CD
```

> **Requirement Framing defines WHAT is required. It does not define HOW the system will be technically implemented.**
