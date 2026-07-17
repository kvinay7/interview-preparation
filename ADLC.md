# AI-Assisted Development Lifecycle (ADLC)

## Project Structure

```text
project-root/
│
├── AGENTS.md
├── README.md
│
├── .gitignore
├── .copilotignore
│
├── .vscode/
│   └── settings.json
│
├── .github/
│   └── workflows/
│
├── ai-context/
│   ├── instructions/
│   ├── prompts/
│   ├── requirements/
│   ├── business-context.md
│   └── technical-context.md
│
├── docs/
│   ├── DESIGN.md
│   ├── decision-log.md
│   ├── tasks/
│   ├── reviews/
│   ├── star/
│   └── deployment/
│
│
└── src/
```

## ADLC Workflow

```text
Requirement
↓
Understand
↓
Analyze
↓
Decide
↓
Learn
↓
Design
↓
Implement
↓
Validate
↓
Review
↓
Document
↓
Prepare
↓
Deliver
```

## AI Orchestration

```text
Load Context
↓
Load Requirements
↓
Follow Workflow
↓
Iterate
```

## AI/Backend Project Structure

```
ai-backend/

README.md
pom.xml

src/
└── main/
    ├── java/
    │   └── com/example/aibackend/
    │       ├── controller/
    │       ├── service/
    │       ├── repository/
    │       ├── entity/
    │       ├── dto/
    │       ├── exception/
    │       ├── logging/
    │       ├── config/
    │       ├── util/
    │       ├── ai/
    │       │   ├── chat/
    │       │   ├── prompt/
    │       │   ├── document/
    │       │   ├── embedding/
    │       │   ├── vectorstore/
    │       │   ├── retrieval/
    │       │   ├── memory/
    │       │   ├── advisor/
    │       │   ├── rag/
    │       │   ├── tool/
    │       │   ├── mcp/
    │       │   └── agent/
    │       └── Main.java
    │
    └── resources/
        ├── application.properties
        ├── documents/
        ├── prompts/
        └── static/
            ├── index.html
            ├── css/
            └── js/
```

