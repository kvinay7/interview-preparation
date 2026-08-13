# ADLC Quick Reference — Plan, Setup, Execute

## PHASE 1: PLAN 

### What to Create
1. **PROJECT_CHARTER.md** — Vision, stakeholders, constraints, success metrics
2. **ROADMAP.md** — Epics, features, timeline, prioritization
3. **BUSINESS_CONTEXT.md** — Problem statement, current state, desired state
4. **TECHNICAL_CONTEXT.md** — Tech stack, architecture decisions (ADRs)

### Checklist
- [ ] Vision statement clear
- [ ] Stakeholders identified
- [ ] Timeline & budget realistic
- [ ] Success metrics quantified
- [ ] Epics & features listed
- [ ] Risks documented
- [ ] Stakeholder sign-off obtained

### Output
Folder: `ai-context/project-preparation/` with all 4 documents signed off

---

## PHASE 2: SETUP 

### What to Create
1. **Repository** — Clone/create repo with folder structure
2. **CI/CD Pipeline** — GitHub Actions: test, build, deploy
3. **Development Environment** — JDK, Maven, PostgreSQL, IDE setup
4. **Documentation Templates** — Contributing guide, PR template, code review checklist
5. **Team Onboarding** — Onboarding guide, getting started steps

### Checklist
- [ ] Repository created with folder structure
- [ ] .gitignore, .copilotignore configured
- [ ] CI/CD workflow running (test on every push)
- [ ] Dev environment documented (build locally in 30 min)
- [ ] Contributing guide written
- [ ] PR template created
- [ ] Team onboarded (can build locally)

### Output
Working repository + CI/CD + documented setup process

---

## PHASE 3: [EXECUTE](https://github.com/kvinay7/interview-preparation/blob/main/ADLC.md#adlc-workflow) 

### Per-Feature Cycle

#### Step 1-3: Create Artifacts
```bash
# Requirement
touch ai-context/requirements/R001.md

# Decision
touch ai-context/decisions/R001_D01.md

# Design
touch ai-context/design/R001_D01.md
```

#### Step 4-6: Plan & Learn
- Make technical decisions
- Learn new frameworks if needed
- Design implementation

#### Step 7-9: Code & Review
```bash
# Create feature branch
git checkout -b feature/R001

# Implement code following 12-step workflow
# Step 7: Implement
# Step 8: Validate (write tests)
# Step 9: Review:
    - Team project → PR + required approvals
    - Solo project → self-review + tests + PR/checklist

git push origin feature/R001
```

#### Step 10-12: Finalize & Deliver
```bash
# Step 10: Document (update docs, API spec)
# Step 11: Prepare (staging deployment, smoke tests)
# Step 12: Deliver (merge to main, tag release)

git checkout main
git merge feature/R001
git tag v1.0.0
git push origin main --tags
```

### Checklist Per Feature
- [ ] Requirement written (R00X.md)
- [ ] Decision documented (R00X_D01.md)
- [ ] Design created (R00X_D01.md)
- [ ] Code written in feature branch
- [ ] Tests written (>80% coverage)
- [ ] Code review completed (2 approvals)
- [ ] Documentation updated
- [ ] Staging deployment successful
- [ ] Merged to main

### Weekly Cadence
```
Mon:   Sprint planning (which features)
Tue:   Create requirement/decision/design files
Wed:   Implement (Steps 7-8)
Thu:   Code review (Step 9)
Fri:   Merge & release (Steps 10-12)
```

### Daily Standup Format
```
1. What completed yesterday?
2. What working on today?
3. Any blockers?

Example: "Merged R001 auth. Working on R002 claims (Step 7). Need API key."
```

---

## File Structure by Phase

### PLAN Phase
```
ai-context/project-preparation/
├── PROJECT_CHARTER.md
├── ROADMAP.md
├── BUSINESS_CONTEXT.md
└── TECHNICAL_CONTEXT.md
```

### SETUP Phase
```
docs/
├── CONTRIBUTING.md
├── DEVELOPMENT_SETUP.md
├── ONBOARDING.md
└── API_SPEC.md

.github/workflows/
├── test.yml
├── deploy-staging.yml
└── deploy-prod.yml
```

### EXECUTE Phase
```
ai-context/
├── requirements/
│   ├── R001.md
│   ├── R002.md
│   └── R00X.md
├── decisions/
│   ├── R001_D01.md
│   ├── R002_D01.md
│   └── R00X_D0Y.md
└── design/
    ├── R001_D01.md
    ├── R002_D01.md
    └── R00X_D0Y.md

src/main/java/...  (code written per feature)
src/test/java/...  (tests per feature)
```

---

## Git Workflow Summary

```bash
# PLAN + SETUP: Push charter, roadmap, setup docs
git add ai-context/project-preparation/
git commit -m "docs: project planning complete"
git push

# EXECUTE: Per-feature cycle
git checkout -b feature/R001
# ... create requirement/decision/design ...
git add ai-context/requirements/R001.md
git commit -m "docs(R001): authentication requirement"
git push

# ... implement code ...
git add src/main/java/...
git commit -m "feat(auth): implement login endpoint"
git push

# ... test & review ...
# Create PR, get approvals

git checkout main
git merge feature/R001
git tag v1.0.0
git push origin main --tags
```

---

## Completion Criteria

**PLAN Complete:**
- [ ] Charter signed off
- [ ] Roadmap approved
- [ ] Stakeholder alignment documented

**SETUP Complete:**
- [ ] Repository working
- [ ] CI/CD running
- [ ] Team can build locally
- [ ] Documentation ready

**EXECUTE Complete (Per Feature):**
- [ ] Code merged to main
- [ ] Tests >80% coverage
- [ ] Documentation updated
- [ ] Staged deployment successful

---

## Key Points to Remember

1. **PLAN once** (charter, roadmap, context)
2. **SETUP once** (repo, CI/CD, docs, onboarding)
3. **EXECUTE repeating** (12-step workflow per feature)
4. **Git structure:** Plan docs → Setup docs → Execute: requirement/decision/design/code per feature
5. **Time:** PLAN 2 weeks + SETUP 1 week + EXECUTE 1 week per feature
6. **AI assist:** Load context → load requirement → follow workflow → update context → iterate

