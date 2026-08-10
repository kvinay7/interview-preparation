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
|   |   └── instructions.md   # Orchestration
|   |
│   ├── workflows/
│   │   └── adlc-workflow.md
|   |
│   ├── requirements/
│   │   └── requirements.md
|   |
│   ├── business-context.md
│   └── technical-context.md
│
├── docs/
│   ├── DESIGN.md
│   ├── DECISION.md
│   ├── CONTRIBUTING.md
│   └── star/
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
Update Context
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
    │       │   ├── evals/
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

## Tech Stack

- **Java**: Basics, Collections, Streams, OOPs, Exceptions & Logging
- **Spring**: Core, Boot, MVC, HTTP & REST APIs, Swagger, Testing
- **Databases**: SQL, JPA
- **AI**: Spring AI, RAG, MCP, Agents
- **UI**: HTML, CSS, JavaScript
- **DevOps**: Git, Linux, Docker, CI/CD, AWS
