# AI-Assisted Development Lifecycle ([ADLC](https://github.com/kvinay7/interview-preparation/blob/main/ADLC_WORKFLOW.md))

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
│   │   └── R001.md
|   |
│   ├── decisions/
│   │   └── R001_D01.md
|   |
│   ├── design/
│   │   └── R001_D01.md
|   |
│   ├── business-context.md
│   └── technical-context.md
│
├── docs/
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

src/test/                      
    └── java/
        └── com/example/aibackend/
```

## Tech Stack

- **Java**: Basics, Collections, Streams, OOPs, Exceptions, Logging 
- **Spring**: Core, Boot, MVC, REST, OpenAPI, Testing, Security, AOP
- **Databases**: SQL, Database Design, Transactions, Indexing, JPA
- **AI**: Spring AI, RAG, MCP, Agents, Evaluation 
- **UI**: HTML, CSS, JavaScript
- **DevOps**: Git, Linux, Docker, CI/CD, AWS

---

- **Java Developer**: DSA + LLD + Spring + ADLC + STAR
- **FSD**: Java Developer + HLD + GenAI + UI + Cloud


