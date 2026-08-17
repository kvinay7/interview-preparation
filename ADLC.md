# AI-Assisted Development Lifecycle (ADLC)

## [ADLC Workflow](https://github.com/kvinay7/interview-preparation/blob/main/ADLC_WORKFLOW.md)

1. [Learn](https://github.com/kvinay7/interview-preparation/blob/main/Learning.md)
2. [Understand](https://github.com/kvinay7/interview-preparation/blob/main/Requirements.md) 
3. Analyze
4. Design
5. [Implement](https://github.com/kvinay7/interview-preparation/blob/main/Implementation.md)
6. Validate
7. Review
8. Document
9. Prepare
10. Deliver

---

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

```
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

pom.xml
```

## Tech Stack

- **Java**: Basics, Collections, Streams, OOPs, Exceptions, Logging 
- **Spring**: Core, Boot, MVC, REST, OpenAPI, Testing, Security, AOP
- **Databases**: SQL, Database Design, Transactions, Indexing, JPA
- **AI**: Spring AI, RAG, Memory, Advisor, MCP, Agents, Evaluation 
- **UI**: HTML, CSS, JavaScript, Bootstrap, ReactJS
- **DevOps/Cloud**: Git, Linux, Docker, CI/CD, AWS

---

- **Java Developer**: DSA + LLD + Spring + ADLC + STAR
- **FSD**: Java Developer + HLD + GenAI + UI + Cloud

---

