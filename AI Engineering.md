<h1 align="center">AI Engineering</h1>

## 1. Artificial Intelligence (AI)

AI is a field of computer science that builds systems capable of performing tasks that normally require human-like intelligence, such as **perception, learning, reasoning, problem-solving, language understanding, and decision-making**. AI enables software systems to:

- Automate complex tasks
- Learn patterns from data
- Make predictions and decisions
- Understand and generate language
- Analyze images, audio, and other data
- Assist humans in knowledge and decision-making tasks

### Examples
- **NLP** — ChatGPT, voice assistants
- **Recommendation** — Netflix, YouTube
- **Computer Vision** — Image/object recognition
- **Fraud Detection** — Detect suspicious transactions
- **Autonomous Systems** — Driving/robotics

### Types of AI 

- **Based on Capabilities**
    - **Narrow AI (Weak AI)** — Designed for specific tasks. **Examples:** GPT-6 Astra (OpenAI) & Claude Fable 5.1 (Anthropic).
    - **Artificial General Intelligence (AGI)** — Hypothetical AI capable of broad human-level intelligence across domains.
    - **Artificial Superintelligence (ASI)** — Hypothetical AI exceeding human intelligence across domains.

- **Based on Functionality**
    - **Reactive Machines** — Respond only to current input; no persistent memory.
    - **Limited Memory** — Uses information from previous observations/interactions for a limited period.
    - **Theory of Mind** — Hypothetical systems capable of understanding beliefs, intentions, and emotions.
    - **Self-Aware AI** — Hypothetical systems with consciousness/self-awareness.

### Advantages of AI
- Automates repetitive and complex tasks
- Personalization (e.g., Spotify, YouTube)
- Faster pattern detection (e.g., fraud, disease diagnosis)
- Scalable and consistent decision-making
- Improves accuracy with data

### Challenges of AI
- **Bias & Fairness** — Biased data → biased predictions
- **Privacy & Security** — Data misuse, surveillance
- **Explainability** — "Black-box" problem in deep learning
- **Job Displacement** — Automates some roles
- **Ethical Concerns** — Deepfakes, misinformation
- **Energy Use** — Large models require heavy computation
- **Regulation** — Compliance with laws like GDPR, AI Act

### Major work areas & roles

| Work Area                                         | Example Products / Platforms                                                                       | Typical Roles                                                   |
| ------------------------------------------------- | -------------------------------------------------------------------------------------------------- | --------------------------------------------------------------- |
| **Foundation Models & APIs**                   | OpenAI models/API, Anthropic Claude, Google Gemini, Hugging Face models                            | AI/ML Researchers, ML Engineers                                 |
| **AI Applications & Agents**                   | ChatGPT, Claude, Gemini, GitHub Copilot, coding agents, AI assistants                              | AI Engineers, Software/Backend Engineers                        |
| **Enterprise AI & Integration**                | Microsoft Copilot, Salesforce Einstein, ServiceNow AI, enterprise RAG/agent platforms              | AI Systems Engineers, AI Solutions / Forward-Deployed Engineers |
| **Tools, Integrations & Developer Platforms**  | LangChain, Spring AI, Hugging Face, MCP-based tools, model APIs                                    | AI Engineers, Software/Platform Engineers                       |
| **Infrastructure, Data, Evaluation & Safety** | GPU/cloud infrastructure, ML pipelines, observability/evaluation platforms, AI security/guardrails | MLOps, Data, AI Evaluation, Security Engineers                  |

**AI Systems Engineer** — use existing AI models and tools with **business data, backend systems, business logic, and workflows** to build, test, deploy, and maintain reliable AI solutions.

---

## 2. [Machine Learning (ML)](https://github.com/rohitg00/ai-engineering-from-scratch)

ML is a subset of AI in which systems **learn patterns from data to make predictions, classifications, or decisions**, rather than relying entirely on explicitly programmed rules. ML enables systems to:

- Learn from historical data
- Make predictions on new/unseen data
- Detect patterns and anomalies
- Automate data-driven decisions
- Improve performance as better data becomes available

### ML Workflow
```
Data
 ↓
Preprocessing
 ↓
Feature Engineering
 ↓
Model Training
 ↓
Evaluation
 ↓
Deployment
 ↓
Prediction
 ↓
Monitoring & Feedback
```

### Types of Machine Learning

| Type                            | Data                                        | How it works                                                 | Examples                                                              | Common Tasks                                                                        |
| ------------------------------- | ------------------------------------------- | ------------------------------------------------------------ | --------------------------------------------------------------------- | ----------------------------------------------------------------------------------- |
| **Supervised Learning**         | **Labeled data**                            | Input + Correct Output → Model → Predicted Output            | Spam vs. non-spam, house-price prediction, disease classification     | **Classification** — predict a category; **Regression** — predict a numerical value |
| **Unsupervised Learning**       | **Unlabeled data**                          | Model discovers patterns/structure in the data               | Customer segmentation, clustering, anomaly detection, topic discovery | Clustering, dimensionality reduction, pattern discovery                             |
| **Semi-Supervised Learning**    | **Small labeled + large unlabeled dataset** | Model learns from both labeled and unlabeled data            | Speech recognition, image classification with limited labels          | Classification/prediction when labeled data is expensive                            |
| **Reinforcement Learning (RL)** | **Experience + rewards/penalties**          | Agent → Action → Environment → State + Reward → Agent learns | Game-playing agents, robotics, sequential decision-making             | Sequential decision-making and control                                              |


### Advantages

* Learns complex patterns from data
* Handles large datasets
* Automates prediction/decision tasks
* Can improve with better data and training
* Useful across many domains

### Challenges / Limitations

* Requires quality data
* Can inherit data bias
* Overfitting / underfitting
* Training and inference costs
* Model interpretability can be difficult
* Distribution/data drift after deployment
* Requires continuous evaluation and monitoring

---

## 3. Deep Learning (DL)

Deep Learning (DL) is a subset of Machine Learning that uses **multi-layered neural networks** to automatically learn complex patterns and representations from data.

- Learns complex patterns automatically
- Reduces dependence on manual feature engineering
- Performs well with large datasets
- Scales effectively with GPUs/accelerators
- Powers modern **computer vision, speech, NLP, and many Generative AI systems**

### Neural Network

- A neural network consists of layers of interconnected computational units (neurons).
    - **Input Layer** — Raw data (e.g., pixels)
    - **Hidden Layers** — Weighted transformations + activation functions
    - **Output Layer** — Final prediction (e.g., cat/dog)

- Each neuron applies a weighted sum + activation function to introduce non-linearity, allowing neural networks to learn complex relationships.

### Training Loop

```
Input Data
    ↓
Forward Pass — produces predictions.
    ↓
Prediction
    ↓
Loss Function — measures prediction error.
    ↓
Backpropagation — calculates gradients of the loss with respect to model parameters.
    ↓
Gradients
    ↓
Optimizer — uses gradients to update the parameters.
    ↓
Update Weights
    ↓
Repeat
```

### Advantages

* Automatic feature/representation learning
* Strong performance on complex problems
* Excellent scalability with large datasets and compute
* Supports modern AI applications such as LLMs and generative models

### Challenges / Limitations

* Requires substantial data for many tasks
* High training/inference compute requirements
* Can require significant GPU memory
* Training can be expensive and time-consuming
* Often difficult to interpret
* Can inherit bias and errors from training data

---

## 4. Natural Language Processing (NLP)

NLP is a subfield of AI that enables computers to **process, understand, interpret, and generate human language**. NLP enables software to work with human language at scale:

- Understand user queries
- Extract information from text
- Classify and analyze text
- Translate languages
- Summarize documents
- Generate text
- Build conversational systems

### Core Tasks 

| Task                    | Purpose                    | Example                  |
| ----------------------- | -------------------------- | ------------------------ |
| **Tokenization**        | Split text into tokens     | `"Hello world"` → tokens |
| **POS Tagging**         | Identify grammatical roles | `run → verb`             |
| **NER**                 | Identify entities          | `Apple → Organization`   |
| **Sentiment Analysis**  | Determine sentiment        | Positive / Negative      |
| **Text Classification** | Assign categories          | Spam / Not spam          |
| **Machine Translation** | Translate languages        | English → Telugu         |
| **Text Summarization**  | Condense text              | Article → Summary        |
| **Question Answering**  | Answer questions from text | Document → Answer        |
| **Text Generation**     | Generate text              | Prompt → Response        |
| **Chatbots**            | Conversational interaction | User ↔ AI                |


### Architecture Evolution

| Architecture    | Key Idea                                  | Limitation / Improvement                                  |
| --------------- | ----------------------------------------- | --------------------------------------------------------- |
| **RNN**         | Processes sequential data                 | Difficult long-range dependencies; sequential computation |
| **LSTM / GRU**  | Better handling of long-term dependencies | More complex than basic RNNs; still sequential            |
| **Transformer** | Self-attention + parallel processing      | Became the foundation for modern NLP/LLMs                 |

### Transformers

- Transformers use **self-attention** to capture relationships between tokens, allowing the model to determine which parts of the input are relevant to each other.
- They enabled highly scalable NLP architectures such as:
  
    - **BERT** — primarily encoder-based, strong for language understanding, classification, and search.
    - **GPT** — decoder-based, strong for autoregressive, open-ended text and code generation.
    - **BART** — encoder-decoder hybrid, strong for sequence-to-sequence tasks like summarization and translation.

### Advantages

* Automates language processing
* Handles large-scale text
* Supports many language tasks
* Modern Transformer-based systems scale effectively
* Foundation for LLMs and Generative AI

### Challenges

* Language ambiguity
* Context and meaning can be difficult to interpret
* Multilingual complexity
* Bias in training data
* Computational cost of modern Transformer models
* Hallucinations in generative NLP systems

---

## 5. Generative AI (GenAI)

**Generative AI** is a category of AI systems that **learn patterns from data and generate new content** such as text, code, images, audio, and video. Unlike traditional predictive AI, which primarily **classifies, predicts, or decides**, GenAI focuses on **creating new outputs**.

* Automates content generation
* Enables natural-language interfaces
* Accelerates software development
* Supports document analysis and summarization
* Enables AI assistants and copilots
* Powers RAG and agentic applications
* Allows enterprises to build AI-powered workflows

### Generative Model Families

| Model family              | Basic idea                                                     | Typical generation   |
| ------------------------- | -------------------------------------------------------------- | -------------------- |
| **Autoregressive Models** | Generate output sequentially, predicting the next token/item   | Text, code           |
| **VAEs**                  | Learn a latent representation and reconstruct/generate samples | Images, data         |
| **GANs**                  | Generator competes with discriminator                          | Images               |
| **Diffusion Models**      | Learn to generate data by reversing a gradual noise process    | Images, audio, video |


### Typical GenAI Application Flow

```text
User
 ↓
Application
 ↓
Prompt + Context
 ↓
LLM / Generative Model
 ↓
Tools / RAG / External Systems
 ↓
Validation / Guardrails
 ↓
Response
```

### Advantages

* Natural-language interaction
* Flexible content generation
* Reduces repetitive knowledge-work
* Can handle many tasks with one model
* Enables new AI-powered applications and workflows

### Challenges / Limitations

* Hallucinations
* Bias
* Non-deterministic outputs
* High inference cost
* Latency
* Security risks such as prompt injection
* Copyright/data-governance concerns
* Requires evaluation and monitoring
* Model output may require human or programmatic verification

---

## 6. Large Language Model (LLM)

LLMs are **Transformer-based models** trained on massive data with billions of parameters to understand and generate natural language. LLMs provide a general-purpose language capability that can be integrated into software applications for:

- Question answering
- Text generation
- Summarization
- Translation
- Code generation
- Classification
- Information extraction
- Conversational applications
- Reasoning and problem solving
- AI agents

### Terminology & Key Concepts

| Term                                | Meaning                                                                                                      |
| ----------------------------------- | ------------------------------------------------------------------------------------------------------------ |
| **LLM**                             | Large Language Model trained on large-scale text data to understand and generate language                    |
| **Parameter**                       | Learned numerical value that determines model behavior                                                       |
| **Inference**                       | Using a trained model to generate predictions or outputs                                                     |
| **Prompt**                          | Instructions, question, or context provided to the model                                                     |
| **Token**                           | Basic unit of text processed by an LLM; may be a word, subword, character, or symbol                         |
| **Context**                         | Information available to the model for generating the current response                                       |
| **Context Window**                  | Maximum number of tokens the model can process in a single request                                           |
| **Temperature**                     | Controls randomness in token selection; lower = more deterministic, higher = more diverse                    |
| **Top-k**                           | Limits token selection to the k highest-probability tokens                                                   |
| **Top-p**                           | Limits token selection to the smallest set of tokens whose cumulative probability reaches p                  |
| **Logits**                          | Raw model scores for possible next tokens before converting them into probabilities                          |
| **Probability / Softmax**           | Converts logits into a probability distribution over possible next tokens                                    |
| **Embedding**                       | Dense vector representation capturing semantic information                                                   |
| **Vector Store**                    | Storage system for embeddings and associated metadata, commonly used for semantic retrieval                  |
| **Chunking**                        | Splitting documents into smaller pieces for processing and retrieval                                         |
| **Chunk Overlap**                   | Repeating content between adjacent chunks to preserve contextual continuity                                  |
| **RAG**                             | Retrieves relevant external information and provides it to an LLM as context before generation               |
| **Fine-Tuning**                     | Further training a pretrained model on task/domain-specific data                                             |
| **PEFT**                            | Parameter-Efficient Fine-Tuning; updates a small portion/additional parameters instead of the entire model   |
| **LoRA**                            | PEFT technique that trains low-rank adapter matrices instead of modifying all model weights                  |
| **Hallucination**                   | Generation of incorrect or unsupported information presented as if it were true                              |
| **Guardrails**                      | Rules, validation, or controls that constrain model inputs/outputs and behavior                              |
| **Moderation**                      | Detecting or preventing harmful, unsafe, or policy-violating content                                         |
| **System Prompt**                   | High-priority instructions defining the model/application's behavior and constraints                         |
| **User Prompt**                     | User-provided request or instruction                                                                         |
| **Assistant Message**               | Model-generated response in a conversational interaction                                                     |
| **Tool Calling / Function Calling** | Allows an LLM to request execution of external tools or functions                                            |
| **Structured Output**               | Constraining model output to a defined format such as JSON/schema                                            |
| **Multimodal LLM**                  | LLM capable of processing or generating multiple modalities such as text, images, audio, or video            |
| **Reasoning Model**                 | Model optimized to spend additional inference computation on complex reasoning tasks                         |
| **Agent**                           | AI system that uses an LLM with planning, tools, memory, feedback, and iterative actions to accomplish goals |

### Prompt Components

| Component                      | Purpose                                            |
| ------------------------------ | -------------------------------------------------- |
| **Role / System Instructions** | Define behavior, responsibilities, and constraints |
| **Task**                       | Explain what the model should do                   |
| **Context**                    | Provide relevant information                       |
| **Examples**                   | Demonstrate expected behavior                      |
| **Constraints**                | Define rules and limitations                       |
| **Output Format**              | Specify the expected response structure            |
| **Input**                      | Actual user data/question                          |

### LLMs Execution Flow

```
Text
 ↓
Tokenization
 ↓
Token IDs
 ↓
Embedding Lookup
 ↓
Token Embeddings
 +
Positional Information
 ↓
Transformer Blocks
 │
 ├─ Self-Attention
 │    ├─ Query
 │    ├─ Key
 │    ├─ Value
 │    ├─ Attention Scores
 │    └─ Multi-Head Attention
 │
 ├─ Residual Connection
 │
 ├─ Layer Normalization
 │
 ├─ Feed-Forward Network
 │
 └─ Residual Connection
 ↓
Final Hidden States
 ↓
LM Head
 ↓
Logits
 ↓
Probability Distribution
 ↓
Sampling / Selection
 ↓
Next Token
 ↓
KV Cache + Updated Context
 ↓
Repeat
 ↓
Generated Response
```

### Production Trade-offs

| Concern     | Important concept                                      |
| ----------- | ------------------------------------------------------ |
| Quality     | Model size, prompting, reasoning, RAG                  |
| Latency     | Model size, KV cache, batching, inference optimization |
| Cost        | Tokens, GPU compute, model size                        |
| Memory      | Model weights + KV cache                               |
| Context     | Context-window limitations                             |
| Throughput  | Batching, parallelism                                  |
| Accuracy    | RAG, tools, verification, evaluation                   |
| Reliability | Guardrails, retries, fallbacks                         |
| Scalability | Distributed serving, batching, model optimization      |

---

## 7. Tokenization

Tokenization is the process of converting text into smaller units called tokens, which are then converted into numerical token IDs that an LLM can process.

- LLMs process tokens, not raw text.
- Token count affects context-window usage.
- Token count affects inference cost and latency in many APIs.
- Different tokenizers can produce different token counts for the same text.

### Tokenization Algorithms
- **Word-level tokenization** — splits text into words
- **Character-level tokenization** — splits text into individual characters
- **Subword tokenization** — splits words into smaller meaningful pieces (Primarily used by modern LLMs)

---

## 8. Hugging Face

Hugging Face is an AI/ML platform and ecosystem that provides **pre-trained models, datasets, tokenizers, and libraries** for building and deploying machine-learning and Generative AI applications.

### Components

| Component            | Purpose                                                 |
| -------------------- | ------------------------------------------------------- |
| **Hugging Face Hub** | Repository for models, datasets, and other AI artifacts |
| **Transformers**     | Library for working with Transformer-based models       |
| **Tokenizers**       | Converts text into tokens/token IDs                     |
| **Datasets**         | Provides datasets for training and evaluation           |
| **Pipelines**        | High-level API for common inference tasks               |
| **Models**           | Pre-trained or fine-tuned neural networks               |

### Tokenizer

```python
from transformers import AutoTokenizer
import pandas as pd

# Load GPT-2 tokenizer
tokenizer = AutoTokenizer.from_pretrained("gpt2")

# Define your input prompt
prompt = "Large language models process text by converting it into tokens."

# Tokenize the input
tokens = tokenizer.tokenize(prompt)
token_ids = tokenizer.convert_tokens_to_ids(tokens)

# Create a DataFrame to show tokens and their IDs
df = pd.DataFrame({
    "Token": tokens,
    "Token ID": token_ids
})

# Display the result
print(df)
```

---

## 9. Framework & Tools

AI frameworks provide reusable abstractions and components for integrating AI models with application logic, data, retrieval systems, tools, and workflows. AI frameworks help developers:

- Integrate different AI model providers
- Build reusable AI application components
- Manage prompts and model interactions
- Connect AI models with application data
- Implement retrieval and tools
- Build workflows and agents
- Reduce low-level integration code
- Integrate AI capabilities into production applications

### Common Framework Architecture

```
Application
     ↓
AI Framework
     ↓
 ┌───┼──────────┬───────────┐
 ↓   ↓          ↓           ↓
Model Prompt   Data        Tools
 ↓      ↓       ↓            ↓
LLM   Context  Retrieval   External Systems
              ↓
             RAG
              ↓
           Response
```

### Common Components

| Component             | Purpose                                                                |
| --------------------- | ---------------------------------------------------------------------- |
| **Model Interface**   | Connect application to AI models                                       |
| **Prompt Templates**  | Create reusable dynamic prompts                                        |
| **Structured Output** | Convert model responses into defined schemas                           |
| **Documents**         | Represent application knowledge/data                                   |
| **Embeddings**        | Convert data into vector representations                               |
| **Vector Store**      | Store and search embeddings                                            |
| **Retrieval**         | Find relevant information                                              |
| **Tools**             | Allow models to interact with external systems                         |
| **Memory / State**    | Maintain relevant conversation/workflow state                          |
| **Workflows**         | Compose multiple AI/application steps                                  |
| **Agents**            | Use models with tools, state and iterative actions to accomplish goals |
| **Evaluation**        | Measure AI application quality                                         |
| **Observability**     | Monitor AI application behavior and performance                        |

### Framework Trade-offs

| Concern                  | Trade-off                                              |
| ------------------------ | ------------------------------------------------------ |
| **Abstraction**          | Easier development vs. less low-level control          |
| **Provider portability** | Easier model switching vs. provider-specific features  |
| **Productivity**         | Faster development vs. framework dependency            |
| **Flexibility**          | Reusable components vs. framework constraints          |
| **Performance**          | Convenience vs. abstraction overhead                   |
| **Maintenance**          | Less custom integration code vs. framework/API changes |

### Framework Selection
```python
Python
   ↓
LangChain → Python LLM application components and workflows
   ↓
LangGraph → Stateful and complex agent/workflow orchestration
   ↓
RAG / Agents
```
```java
Java
   ↓
Spring AI → Java/Spring-based AI applications and enterprise backend integration
   ↓
RAG / Tool Calling / MCP / Agents
```
---

## 10. LangChain

LangChain is a framework for building applications powered by Large Language Models (LLMs). It helps developers build dynamic, context-aware LLM applications and workflows rather than simple single-prompt applications.

### i. Models

LangChain provides a common interface for interacting with different model providers.

**Model Flow**

```
Application
     ↓
LangChain Model Interface
     ↓
LLM Provider
     ↓
Model
     ↓
Response
```

**Example**

```python
from langchain_openai import ChatOpenAI

model = ChatOpenAI(
    model="gpt-4o-mini",
    temperature=0
)

response = model.invoke("Explain Spring Boot.")

print(response.content)
```

### ii. Prompt templates

Prompt templates create reusable prompts with dynamic inputs.

```python
from langchain_core.prompts import ChatPromptTemplate

prompt = ChatPromptTemplate.from_template(
    "Explain {topic} in simple terms."
)

messages = prompt.invoke({
    "topic": "Spring AI"
})

print(messages)
```

### iii. LangChain Expression Language

LCEL (LangChain Expression Language) allows LangChain components to be composed into reusable workflows using the `|` operator.

```python
chain = prompt | model

response = chain.invoke({
    "topic": "Spring AI"
})

print(response.content)
```

### iv. Structured Output

Structured output constrains an LLM response to a predefined structure or schema instead of returning arbitrary text.

```python
from pydantic import BaseModel

class Product(BaseModel):
    name: str
    category: str

structured_model = model.with_structured_output(Product)

result = structured_model.invoke(
    "The iPhone is a smartphone."
)

print(result)
```

---

## 11. Spring AI

Spring AI is a Spring framework for building **AI-powered applications in Java**, providing abstractions and integrations for LLMs, embeddings, vector stores, RAG, tool calling, MCP, memory, and AI application workflows. 

### i. ChatModel

Represents the underlying chat-capable AI model.

```text
Application
     ↓
ChatModel
     ↓
LLM Provider
     ↓
Model
     ↓
Response
```

### ii. ChatClient

Higher-level fluent API for interacting with chat models.

```java
ChatClient chatClient = ChatClient.builder(chatModel).build();

String response = chatClient
        .prompt()
        .user("Explain Spring Boot")
        .call()
        .content();

System.out.println(response);
```

### iii. Prompting

Spring AI allows prompts to be constructed dynamically.

```java
String response = chatClient
        .prompt()
        .system("You are a Java expert.")
        .user("Explain {topic}.")
        .call()
        .content();
```

### iv. Structured Output

Instead of receiving arbitrary text, you can request a structured Java object.

```java
public record Product(
        String name,
        String category
) {}
```

---

<h1 align="center">RAG Systems</h1>

## 1. Retrieval-Augmented Generation (RAG)

RAG is an AI architecture that retrieves relevant information from an external knowledge source and provides current, private, or domain-specific information to an LLM as context before generating an answer. An LLM's internal knowledge has limitations:

* Knowledge can become outdated.
* The model may not know private/company-specific information.
* Relevant information may not have been included in training.
* The model can hallucinate when information is unavailable.
* Updating model knowledge through retraining/fine-tuning is expensive and slow.

### RAG vs Fine-Tuning

| RAG                                       | Fine-Tuning                                             |
| ----------------------------------------- | ------------------------------------------------------- |
| Adds external knowledge at inference time | Changes model parameters                                |
| Knowledge remains outside model           | Knowledge/patterns are incorporated into model behavior |
| Easier to update documents                | Updating requires another training/fine-tuning process  |
| Good for private/current knowledge        | Good for changing model behavior/style/task performance |
| Retrieval required at runtime             | No retrieval required for the learned behavior          |
| Can provide source context                | Does not inherently provide source grounding            |

### RAG Architecture

A RAG system has an indexing pipeline that processes documents into searchable vector representations, and a query pipeline that converts the user's question into a vector, retrieves relevant chunks, augments the prompt with that context, and sends it to the LLM to generate the answer.

```text
                RAG SYSTEM
                    │
          ┌─────────┴─────────┐
          ↓                   ↓
   INDEXING PIPELINE     QUERY PIPELINE
          │                   │
          ↓                   ↓
     Documents             Question
          ↓                   ↓
       Chunking          Query Embedding
          ↓                   ↓
      Embeddings         Similarity Search
          ↓                   ↓
     Vector Store        Retrieved Chunks
                              ↓
                       Prompt Augmentation
                              ↓
                     LLM Response Generation
```

---

<h1 align="center">Agentic Systems</h1>

## What are Tools, Agents and MCP?

- **Tools** — LangChain provides a framework to build tools (deterministic functions that perform a single, well-defined task) that extend LLMs' capabilities such as accessing live data, executing tasks, and interfacing with APIs
- **Agents (LLMs)** — Can decide when and which tool to use based on user queries. Performs specific predefined tasks automatically
- **MCP (Model Context Protocol)** - MCP refers to the design pattern or strategy for managing the inputs (prompts, data, memory, tools, instructions) and outputs (responses, parsed results) that flow into and out of an LLM within a larger system.
- **MCP Purpose:** Safe bridge between LLM reasoning and real-world tools. It prevents N×M integration complexity and creates a standardized tool invocation boundary while protecting enterprise systems from uncontrolled LLM behavior.

```python
from langchain.agents import initialize_agent, load_tools, AgentType
from langchain.chat_models import ChatOpenAI
from langchain.agents.agent import AgentExecutor

def get_llm():
    return ChatOpenAI(
        temperature=0, 
        streaming=True  # Streaming gives a live output feel
    )

def get_tools(llm):
    return load_tools(
        tool_names=["ddg-search", "wolfram-alpha", "arxiv", "wikipedia"],
        llm=llm
    )

def load_agent() -> AgentExecutor:
    llm = get_llm()
    tools = get_tools(llm)
    return initialize_agent(
        tools=tools,
        llm=llm,
        agent=AgentType.ZERO_SHOT_REACT_DESCRIPTION,
        verbose=True
    )

if __name__ == "__main__":
    agent = load_agent()
    query = "What is the solution to 2x + 5 = -3x + 7."
    response = agent.run(query)
    print("\nFinal Answer:\n", response)
```

---

## What is Agentic AI?

Agentic AI refers to artificial intelligence systems (state machines, not just chatbots) that act autonomously to achieve specific goals by perceiving their environment, reasoning, making decisions, and taking actions — often without continuous human oversight. Unlike general-purpose AI, Agentic AI is specialized, goal-driven, and capable of tool use and adaptation.

**Agentic Loop** — Think, Act, Observe and Repeat

| Agent Type | Main Strength | Limitations | Best For | Example |
|---|---|---|---|---|
| Simple Reflex Agent | Instant reaction based on fixed rules | No memory or learning; fails in dynamic environments | Fully observable, stable and simple environments | Traffic light timers |
| Model-Based Reflex Agent | Handles partial observability with internal state | More computational demand; depends on model accuracy | Dynamic or partially observable environments | Robot vacuum cleaners |
| Goal-Based Agent | Plans ahead to achieve specific objectives | Needs clear goals and planning algorithms | Strategic tasks with defined goals | Logistics route planning |
| Utility-Based Agent | Balances multiple factors for best outcome | Requires complex utility functions | Multi-criteria decision-making | Financial portfolio management |
| Learning Agent | Improves over time via experience | Needs data and training time | Dynamic environments with changing conditions | AI chatbots |
| Multi-Agent System (MAS) | Distributed problem-solving with cooperation or competition | Complex interactions; unpredictable behaviors | Decentralized, multi-entity systems | Smart traffic control |
| Hierarchical Agent | Breaks complex tasks into levels for efficiency | Requires well-defined interfaces between layers | Large-scale, multi-level operations | Drone delivery management |

---

## What is LangGraph?

LangGraph is a graph-based stateful orchestration framework used to build explicit, controllable agent workflows. It allows connecting LLMs, agents, tools, APIs, and memory nodes in a directed graph to design complex workflows.

```python
from langgraph.graph import Graph, Node, Edge
from setup_rag_base import llm, memory, retriever, rag_chain

# Define Nodes - State is a shared data object passed between nodes 
# and a node is a python function that reads, updates, returns state.

user_input = Node(
    id="user_input",
    function=lambda input_text: {"query": input_text},
    description="Accepts user query"
)

retriever_node = Node(
    id="retriever",
    function=lambda inputs: {"context": retriever.get_relevant_documents(inputs["query"])},
    description="Retrieves context from vector DB"
)

rag_node = Node(
    id="rag_qa",
    function=lambda inputs: {"answer": rag_chain.run(inputs["query"])},
    description="Generates final grounded answer"
)

# Define Edges - defines execution order between nodes
edges = [
    Edge(source="user_input", target="retriever"),
    Edge(source="retriever", target="rag_qa")
]

# Build Graph
graph = Graph(nodes=[user_input, retriever_node, rag_node], edges=edges)

# Execute
query = "What is LangGraph and how is it related to LangChain?"
output = graph.invoke({"input_text": query})
print(f"Graph Output: {output}")
```

---

## Why is Cost Optimization Important in LLM Apps?

- **LLM inference cost** = #tokens input + #tokens output × $per token rate
- Large context windows + long answers → exponential cost
- Without optimization, costs can scale uncontrollably for production apps

---

## What are Strategies for LLM Cost Optimization?

### Prompt Optimization

- Keep prompts concise (reduce unnecessary tokens)
- Use structured instructions (JSON schema) to avoid verbose outputs

### Model Selection

- Use smaller/cheaper models (GPT-3.5, LLaMA 3-8B) for simple tasks
- Reserve larger models (GPT-4, Claude Opus) for complex reasoning

### Hybrid Pipelines

- Preprocess with rules / embeddings before calling the LLM
- Use RAG (RAGAS) → narrows context → fewer tokens

### Token Control

- Limit max output tokens
- Use summarization to compress documents before feeding

### Open-Source Models (Self-Hosting)

- For high-volume workloads, host LLaMA / Mistral on GPUs

---

## How Do You Monitor LLM Usage & Costs?

### Custom Logging

Log token usage per request.

```python
from langchain.callbacks import get_openai_callback

with get_openai_callback() as cb:
    response = chain.invoke(query)

print(f" - Prompt Tokens: {cb.prompt_tokens}")
print(f" - Completion Tokens: {cb.completion_tokens}")
print(f" - Total Tokens: {cb.total_tokens}")
print(f" - Total Cost (USD): ${cb.total_cost:.6f}")
```

### Dashboards

LangSmith, or custom dashboards.

