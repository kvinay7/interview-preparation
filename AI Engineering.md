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

- #### Based on Capabilities
    - **Narrow AI (Weak AI)** — Designed for specific tasks. Today's practical AI systems are primarily narrow AI.
        - **Examples:** GPT-6 Astra (OpenAI), Claude Fable 5.1 (Anthropic), and Gemini 3.8 Flash (Google).
    - **Artificial General Intelligence (AGI)** — Hypothetical AI capable of broad human-level intelligence across domains.
    - **Artificial Superintelligence (ASI)** — Hypothetical AI exceeding human intelligence across domains.

- ####  Based on Functionality
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

---

## 2. Machine Learning (ML)

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

### Hugging Face Transformers

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

## 9. LangChain

LangChain is a framework for building applications powered by Large Language Models (LLMs). It helps developers build dynamic, context-aware LLM applications and workflows rather than simple single-prompt applications. It provides reusable components for:

- Models
- Prompt templates
- LCEL / Runnables
- Structured output
- State / memory
- Tools
- Retrieval
- Agents

### Models

LangChain provides a common interface for interacting with different model providers.

```python
from langchain_openai import ChatOpenAI

model = ChatOpenAI(
    model="gpt-4o-mini",
    temperature=0
)

response = model.invoke("Explain Spring Boot.")

print(response.content)
```

---

## Q21. How Retrieval-Augmented Generation ([RAG](https://youtu.be/r37RoPQBXNU?t=420&si=-VYkYmlo_nSTCjqX)) Works?

### Document Storage

1. **Load** — Read the documents or text corpus into memory
2. **Chunking** — Split large documents into smaller pieces (e.g., 500 tokens with overlap 50)
3. **Embedding** — Convert each chunk into a high-dimensional vector using a pre-trained embedding model
4. **Storage** — Store these vectors in a vector database along with metadata (document ID, chunk info)

### Input Text → Embedding

- When you give a query (like a question), the text is converted into a vector embedding using a pre-trained model
- This embedding captures the semantic meaning of the query

### Semantic Search / Retrieval

- The query embedding is compared with document embeddings using a similarity metric (like cosine similarity)
- The most similar vectors are retrieved → these correspond to relevant documents or chunks

### Augment Context for Generation

- Retrieved documents are added to the prompt/context for the language model
- This allows the LLM to generate text grounded in retrieved knowledge, reducing hallucinations

### Autoregressive Generation

- The LLM now predicts the next token, using both the query and retrieved document embeddings indirectly via the text

---

## Q22. RAG Implementation with LangChain

```python
from langchain.chains import RetrievalQA
from langchain.chains.summarize import load_summarize_chain
from langchain_community.vectorstores import FAISS
from langchain_openai import OpenAIEmbeddings
from langchain.text_splitter import RecursiveCharacterTextSplitter

# Step 1: Load raw text documents
raw_documents = [
    "RAG stands for Retrieval-Augmented Generation. It improves LLM responses.",
    "Chunking is used to split long documents into smaller parts."
]

# Step 2: Chunk and Summarize documents
text_splitter = RecursiveCharacterTextSplitter(chunk_size=500, chunk_overlap=100)
documents = text_splitter.create_documents(raw_documents)
chain = load_summarize_chain(llm=llm, chain_type="map_reduce")
summary = chain.run(documents)

# Step 3: Generate embeddings
embeddings = OpenAIEmbeddings()

# Step 4: Create vector store
vectorstore = FAISS.from_texts(documents, embeddings)

# Step 5: Create retriever
retriever = vectorstore.as_retriever(search_kwargs={"k": 3})

# Step 6: Create RetrievalQA chain
qa = RetrievalQA.from_chain_type(llm=llm, retriever=retriever)

# Step 7: Run a query
response = qa.run("Your question here")
```

---

## Q23. Why is Cost Optimization Important in LLM Apps?

- **LLM inference cost** = #tokens input + #tokens output × $per token rate
- Large context windows + long answers → exponential cost
- Without optimization, costs can scale uncontrollably for production apps

---

## Q24. What are Strategies for LLM Cost Optimization?

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

## Q25. How Do You Monitor LLM Usage & Costs?

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

---

## Q28. What are Tools, Agents and MCP?

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

## Q29. What is Agentic AI?

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

## Q30. What is LangGraph?

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

<h1 align="center">Spring AI</h1>

### Q1. What is Spring AI?

Spring AI is a Spring ecosystem project that simplifies integrating AI models into Java applications. It provides consistent APIs for interacting with different LLM providers such as OpenAI, Azure OpenAI, Anthropic, Ollama, and Bedrock.

---

### Q2. What is ChatModel?

`ChatModel` is Spring AI's abstraction over different chat providers. Instead of writing provider-specific code, developers interact with the `ChatModel` interface.

```
Application
      │
      ▼
 ChatModel
      │
      ▼
OpenAI / Claude / Ollama / Bedrock
```

```java
@Bean
ChatModel chatModel(...) {
    ...
}
```

---

### Q3. What is ChatClient?

ChatClient is a higher-level API built on top of ChatModel. It provides a fluent builder API for sending prompts.

```
User Prompt
      │
      ▼
ChatClient
      │
      ▼
ChatModel
      │
      ▼
LLM Provider
      │
      ▼
AI Response
```

```java
@Bean
ChatClient chatClient(ChatModel chatModel) {
    return ChatClient.create(chatModel);
}
```

#### Example 1 — Simple Prompt

```java
String response = chatClient
        .prompt("Hello")
        .call()
        .content();
```

---

#### Example 2 — Prompt Template

```java
String response = chatClient
        .prompt()
        .user("Tell me about {topic}")
        .param("topic", "Spring AI")
        .call()
        .content();
```

---

#### Example 3 — System Prompt

```java
String response = chatClient
        .prompt()
        .system("You are a Java expert.")
        .user("Explain Dependency Injection.")
        .call()
        .content();
```

---

#### Example 4 — Streaming

```java
chatClient
    .prompt("Explain Spring AI")
    .stream();
```

---

### Q4. What is ChatResponse?

`ChatResponse` represents the complete response returned by the LLM.

It contains:
- Generated content
- Metadata
- Token usage
- Finish reason

```java
ChatResponse response = chatModel.call(prompt);

String content = response.getResult()
                         .getOutput()
                         .getText();
```

---

<h1 align="center">RAG with Java</h1>

# 1. RAG Fundamentals

## What is RAG?

**Retrieval-Augmented Generation** combines information retrieval with LLM generation.

```
User Query
    ↓
[RETRIEVE] Search for relevant documents/chunks
    ↓
[AUGMENT] Add retrieved context to prompt
    ↓
[GENERATE] LLM produces answer grounded in context
    ↓
Response
```

## Why RAG?

| Problem | RAG Solution |
|---------|--------------|
| LLM knowledge outdated | Retrieve current/real-time data |
| LLM doesn't know private data | Retrieve from private knowledge base |
| LLM hallucinates | Ground answer in retrieved facts |
| Fine-tuning is expensive | No retraining needed; update documents |

## RAG vs Fine-tuning

| Aspect | RAG | Fine-tuning |
|--------|-----|-------------|
| **Latency** | Retrieval overhead (~100–200ms) | None; model inference only |
| **Knowledge update** | Change documents; instant effect | Retrain model; hours/days |
| **Cost** | Retrieval + inference | Compute + storage for training |
| **Use case** | Private/changing data | Behavior adaptation |

---

# 2. Embeddings

## What is an Embedding?

A dense vector (typically 384–1536 dimensions) that represents the **semantic meaning** of text. Similar texts have similar embeddings.

```
Text: "How do I reset my password?"
         ↓
Embedding Model (e.g., SBERT)
         ↓
Vector: [0.23, -0.15, 0.88, ..., -0.41]  // 384 dimensions
```

## Embedding Models

| Model | Dimensions | Speed | Quality | Use Case |
|-------|-----------|-------|---------|----------|
| **Sentence-BERT (all-MiniLM-L6-v2)** | 384 | Fast | Good | General purpose, on-prem |
| **OpenAI text-embedding-3-small** | 1536 | Moderate | Excellent | Production, cloud |
| **Cohere Embed** | 1024 | Moderate | Excellent | Multilingual |
| **Ollama (local models)** | 384–768 | Slow | Varies | Privacy, no API keys |

## Java: Computing Embeddings

### Option 1: OpenAI Embeddings API

```java
import com.openai.client.OpenAIClient;
import com.openai.models.CreateEmbeddingResponse;

public class EmbeddingService {
    private final OpenAIClient client;

    public EmbeddingService(String apiKey) {
        this.client = new OpenAIClient(apiKey);
    }

    public double[] embed(String text) {
        CreateEmbeddingResponse response = client.embeddings().create(
            request -> request
                .model("text-embedding-3-small")
                .input(text)
        );
        
        // Extract embedding vector
        return response.data().get(0).embedding().stream()
            .mapToDouble(Double::doubleValue)
            .toArray();
    }
}
```

### Option 2: Spring AI Embeddings

```java
import org.springframework.ai.embedding.EmbeddingClient;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.stereotype.Service;

@Service
public class EmbeddingService {
    private final EmbeddingClient embeddingClient;

    public EmbeddingService(EmbeddingClient embeddingClient) {
        this.embeddingClient = embeddingClient;
    }

    public float[] embed(String text) {
        EmbeddingResponse response = embeddingClient.embedForObject(text);
        return response.getResult().getOutput().stream()
            .mapToFloat(Float::floatValue)
            .toArray();
    }

    public List<float[]> embedBatch(List<String> texts) {
        return texts.stream()
            .map(this::embed)
            .collect(Collectors.toList());
    }
}
```

### Option 3: Local Embeddings (Ollama)

```java
import okhttp3.*;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LocalEmbeddingService {
    private final OkHttpClient httpClient;
    private final ObjectMapper objectMapper;
    private final String ollamaUrl = "http://localhost:11434/api/embeddings";

    public LocalEmbeddingService() {
        this.httpClient = new OkHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public double[] embed(String text) throws Exception {
        String jsonBody = objectMapper.writeValueAsString(Map.of(
            "model", "nomic-embed-text",
            "prompt", text
        ));

        Request request = new Request.Builder()
            .url(ollamaUrl)
            .post(RequestBody.create(jsonBody, MediaType.get("application/json")))
            .build();

        try (Response response = httpClient.newCall(request).execute()) {
            Map<String, Object> result = objectMapper.readValue(
                response.body().string(), 
                new TypeReference<Map<String, Object>>() {}
            );
            List<Double> embedding = (List<Double>) result.get("embedding");
            return embedding.stream().mapToDouble(Double::doubleValue).toArray();
        }
    }
}
```

---

# 3. Vector Similarity Search

## Cosine Similarity

Measures the angle between two vectors. Higher = more similar.

```
cosine_similarity(A, B) = (A · B) / (||A|| × ||B||)
                         = dot_product / (magnitude_A × magnitude_B)

Range: -1 to 1
  1.0 = identical direction
  0.0 = perpendicular
 -1.0 = opposite
```

## Java: Cosine Similarity

```java
public class VectorUtils {
    
    /**
     * Computes cosine similarity between two vectors
     * @param a first vector
     * @param b second vector
     * @return similarity score (-1.0 to 1.0)
     */
    public static double cosineSimilarity(double[] a, double[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Vectors must have same dimension");
        }

        double dotProduct = 0.0;
        double magnitudeA = 0.0;
        double magnitudeB = 0.0;

        for (int i = 0; i < a.length; i++) {
            dotProduct += a[i] * b[i];
            magnitudeA += a[i] * a[i];
            magnitudeB += b[i] * b[i];
        }

        magnitudeA = Math.sqrt(magnitudeA);
        magnitudeB = Math.sqrt(magnitudeB);

        if (magnitudeA == 0.0 || magnitudeB == 0.0) {
            return 0.0; // Handle zero vectors
        }

        return dotProduct / (magnitudeA * magnitudeB);
    }

    /**
     * Batch similarity computation
     */
    public static List<Double> cosineSimilarityBatch(double[] query, List<double[]> documents) {
        return documents.stream()
            .map(doc -> cosineSimilarity(query, doc))
            .collect(Collectors.toList());
    }
}
```

## Other Similarity Metrics

```java
public class VectorMetrics {
    
    // Euclidean Distance (L2)
    public static double euclideanDistance(double[] a, double[] b) {
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            double diff = a[i] - b[i];
            sum += diff * diff;
        }
        return Math.sqrt(sum);
    }

    // Manhattan Distance (L1)
    public static double manhattanDistance(double[] a, double[] b) {
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            sum += Math.abs(a[i] - b[i]);
        }
        return sum;
    }

    // Dot Product (for normalized vectors, ~ cosine sim)
    public static double dotProduct(double[] a, double[] b) {
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i] * b[i];
        }
        return sum;
    }
}
```

---

# 4. Chunking & Document Processing

## What is Chunking?

Split large documents into smaller, overlapping pieces before embedding.

```
Large Document (100 pages)
         ↓
Split into chunks (e.g., 500 tokens each)
         ↓
Add overlap (e.g., 50-token overlap)
         ↓
Embed each chunk
         ↓
Store in vector DB
```

## Why Chunking?

- Embedding long documents is expensive
- Smaller chunks → precise retrieval (exact relevant section found)
- Overlap → preserves context between chunks
- Prevents truncation at logical boundaries

## Chunking Strategies

| Strategy | Pros | Cons |
|----------|------|------|
| **Fixed-size** | Simple, fast | May split mid-sentence |
| **Recursive** | Preserves structure (sentence → paragraph → size) | Slightly slower |
| **Semantic** | Groups related sentences together | Complex, slower |

## Java: Fixed-Size Chunking

```java
public class ChunkingService {
    
    /**
     * Split text into fixed-size chunks with overlap
     * @param text input text
     * @param chunkSize size of each chunk (in characters)
     * @param overlapSize overlap between chunks (in characters)
     * @return list of chunks
     */
    public static List<String> fixedSizeChunking(String text, int chunkSize, int overlapSize) {
        List<String> chunks = new ArrayList<>();
        
        if (text.length() <= chunkSize) {
            chunks.add(text);
            return chunks;
        }

        int step = chunkSize - overlapSize; // How far to move for next chunk
        for (int i = 0; i < text.length(); i += step) {
            int end = Math.min(i + chunkSize, text.length());
            chunks.add(text.substring(i, end));
            
            if (end == text.length()) break; // Reached end
        }

        return chunks;
    }
}

// Usage
String document = "This is a long document...";
List<String> chunks = ChunkingService.fixedSizeChunking(document, 500, 50);
System.out.println("Number of chunks: " + chunks.size());
```

## Java: Recursive Chunking (by Sentence)

```java
public class RecursiveChunkingService {
    
    /**
     * Split text recursively: sentences → paragraphs → fixed size
     */
    public static List<String> recursiveChunking(String text, int chunkSize, int overlapSize) {
        // Step 1: Split by paragraphs (double newline)
        List<String> paragraphs = Arrays.asList(text.split("\n\n+"));
        
        // Step 2: For each paragraph, split by sentences
        List<String> sentences = new ArrayList<>();
        for (String para : paragraphs) {
            String[] paras = para.split("(?<=[.!?])\\s+");
            sentences.addAll(Arrays.asList(paras));
        }
        
        // Step 3: Group sentences into chunks of desired size
        List<String> chunks = new ArrayList<>();
        StringBuilder currentChunk = new StringBuilder();
        
        for (String sentence : sentences) {
            if ((currentChunk.length() + sentence.length()) <= chunkSize) {
                currentChunk.append(" ").append(sentence);
            } else {
                // Start new chunk with overlap
                if (currentChunk.length() > 0) {
                    chunks.add(currentChunk.toString().trim());
                }
                
                // Overlap: keep last N chars from previous chunk
                String overlap = currentChunk.length() > overlapSize 
                    ? currentChunk.substring(currentChunk.length() - overlapSize)
                    : currentChunk.toString();
                    
                currentChunk = new StringBuilder(overlap + " " + sentence);
            }
        }
        
        if (currentChunk.length() > 0) {
            chunks.add(currentChunk.toString().trim());
        }

        return chunks;
    }
}
```

## Document Parsing: Extract Text from PDF

```java
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.File;

public class DocumentParsingService {
    
    /**
     * Extract text from PDF
     */
    public static String extractTextFromPdf(String pdfPath) throws Exception {
        try (PDDocument document = PDDocument.load(new File(pdfPath))) {
            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(document);
        }
    }

    /**
     * Clean extracted text (remove boilerplate, normalize whitespace)
     */
    public static String cleanText(String text) {
        return text
            .replaceAll("\\s+", " ")          // Multiple spaces → single space
            .replaceAll("(?m)^\\s+|\\s+$", "") // Remove leading/trailing whitespace per line
            .trim();
    }

    /**
     * Extract text, clean, and chunk
     */
    public static List<String> extractAndChunk(String pdfPath) throws Exception {
        String rawText = extractTextFromPdf(pdfPath);
        String cleanedText = cleanText(rawText);
        return RecursiveChunkingService.recursiveChunking(cleanedText, 500, 50);
    }
}
```

---

# 5. Retrieval Strategies

## 1. Dense Retrieval (Semantic/Vector Search)

Find documents based on embedding similarity.

```java
public class DenseRetriever {
    private final EmbeddingService embeddingService;
    private final List<Document> documentStore; // In-memory; use vector DB in production

    public DenseRetriever(EmbeddingService embeddingService, List<Document> documentStore) {
        this.embeddingService = embeddingService;
        this.documentStore = documentStore;
    }

    /**
     * Retrieve top-K documents by semantic similarity
     */
    public List<Document> retrieve(String query, int k) {
        double[] queryEmbedding = embeddingService.embed(query);

        // Compute similarity with all documents
        List<DocumentScore> scores = documentStore.stream()
            .map(doc -> new DocumentScore(
                doc,
                VectorUtils.cosineSimilarity(queryEmbedding, doc.getEmbedding())
            ))
            .sorted((a, b) -> Double.compare(b.score, a.score)) // Descending
            .limit(k)
            .collect(Collectors.toList());

        return scores.stream().map(ds -> ds.document).collect(Collectors.toList());
    }

    static class DocumentScore {
        Document document;
        double score;

        DocumentScore(Document document, double score) {
            this.document = document;
            this.score = score;
        }
    }
}

class Document {
    private String id;
    private String content;
    private double[] embedding;
    private String source; // For attribution

    // Getters, setters...
}
```

## 2. Sparse Retrieval (BM25)

Traditional keyword-based ranking.

```java
public class BM25Retriever {
    private final List<Document> documentStore;
    private final Map<String, Map<String, Integer>> invertedIndex; // word → {doc_id → count}

    public BM25Retriever(List<Document> documentStore) {
        this.documentStore = documentStore;
        this.invertedIndex = buildInvertedIndex();
    }

    /**
     * Build inverted index for BM25
     */
    private Map<String, Map<String, Integer>> buildInvertedIndex() {
        Map<String, Map<String, Integer>> index = new HashMap<>();

        for (Document doc : documentStore) {
            String[] tokens = tokenize(doc.getContent());
            for (String token : tokens) {
                index.computeIfAbsent(token, k -> new HashMap<>())
                    .merge(doc.getId(), 1, Integer::sum);
            }
        }

        return index;
    }

    /**
     * BM25 ranking (simplified)
     * BM25(q, D) = sum over terms t in q of:
     *   IDF(t) * (f(t, D) * (k1 + 1)) / (f(t, D) + k1 * (1 - b + b * |D| / avgDocLen))
     */
    public List<Document> retrieve(String query, int k) {
        String[] queryTerms = tokenize(query);
        double avgDocLen = documentStore.stream()
            .mapToInt(d -> d.getContent().split("\\s+").length)
            .average()
            .orElse(100);

        double k1 = 1.2; // Term frequency saturation parameter
        double b = 0.75;  // Length normalization parameter

        Map<String, Double> scores = new HashMap<>();

        for (String term : queryTerms) {
            if (!invertedIndex.containsKey(term)) continue;

            double idf = Math.log((documentStore.size() - invertedIndex.get(term).size() + 0.5) 
                                / (invertedIndex.get(term).size() + 0.5));

            for (Map.Entry<String, Integer> entry : invertedIndex.get(term).entrySet()) {
                String docId = entry.getKey();
                int freq = entry.getValue();
                int docLen = documentStore.stream()
                    .filter(d -> d.getId().equals(docId))
                    .findFirst()
                    .map(d -> d.getContent().split("\\s+").length)
                    .orElse(0);

                double bm25Score = idf * ((freq * (k1 + 1)) 
                    / (freq + k1 * (1 - b + b * (docLen / avgDocLen))));

                scores.merge(docId, bm25Score, Double::sum);
            }
        }

        return scores.entrySet().stream()
            .sorted((a, b) -> Double.compare(b.getValue(), a.getValue()))
            .limit(k)
            .map(e -> documentStore.stream()
                .filter(d -> d.getId().equals(e.getKey()))
                .findFirst()
                .orElse(null))
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    }

    private String[] tokenize(String text) {
        return text.toLowerCase().split("\\W+");
    }
}
```

## 3. Hybrid Retrieval (Semantic + BM25)

Combine both approaches.

```java
public class HybridRetriever {
    private final DenseRetriever denseRetriever;
    private final BM25Retriever bm25Retriever;

    public HybridRetriever(DenseRetriever denseRetriever, BM25Retriever bm25Retriever) {
        this.denseRetriever = denseRetriever;
        this.bm25Retriever = bm25Retriever;
    }

    /**
     * Hybrid retrieval: combine semantic + BM25
     * Use Reciprocal Rank Fusion (RRF) to merge rankings
     */
    public List<Document> retrieve(String query, int k) {
        List<Document> semanticResults = denseRetriever.retrieve(query, k * 2);
        List<Document> bm25Results = bm25Retriever.retrieve(query, k * 2);

        // RRF scoring: score = 1 / (rank + 60)
        Map<String, Double> rrfScores = new HashMap<>();
        
        for (int i = 0; i < semanticResults.size(); i++) {
            String docId = semanticResults.get(i).getId();
            rrfScores.merge(docId, 1.0 / (i + 60), Double::sum);
        }

        for (int i = 0; i < bm25Results.size(); i++) {
            String docId = bm25Results.get(i).getId();
            rrfScores.merge(docId, 1.0 / (i + 60), Double::sum);
        }

        // Merge unique documents, sorted by RRF score
        Set<String> allDocIds = new HashSet<>();
        allDocIds.addAll(semanticResults.stream().map(Document::getId).collect(Collectors.toSet()));
        allDocIds.addAll(bm25Results.stream().map(Document::getId).collect(Collectors.toSet()));

        List<Document> documentStore = new ArrayList<>(semanticResults);
        documentStore.addAll(bm25Results);
        Map<String, Document> docMap = documentStore.stream()
            .distinct()
            .collect(Collectors.toMap(Document::getId, d -> d, (a, b) -> a));

        return rrfScores.entrySet().stream()
            .sorted((a, b) -> Double.compare(b.getValue(), a.getValue()))
            .limit(k)
            .map(e -> docMap.get(e.getKey()))
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    }
}
```

---

# 6. LLM Integration

## What is an LLM?

A transformer-based model that generates text token-by-token based on input prompt + context.

## Java: LLM Integration

### Option 1: OpenAI API

```java
import com.openai.client.OpenAIClient;
import com.openai.models.*;

public class OpenAILLMService {
    private final OpenAIClient client;

    public OpenAILLMService(String apiKey) {
        this.client = new OpenAIClient(apiKey);
    }

    /**
     * Generate text based on prompt + context
     */
    public String generate(String systemPrompt, String userPrompt) {
        ChatCompletion response = client.chat().completions().create(
            ChatCompletionCreateParams.builder()
                .model("gpt-4")
                .messages(Arrays.asList(
                    ChatCompletionMessageParam.ofChatCompletionMessage(
                        ChatCompletionMessage.builder()
                            .role(ChatCompletionMessage.Role.SYSTEM)
                            .content(systemPrompt)
                            .build()
                    ),
                    ChatCompletionMessageParam.ofChatCompletionMessage(
                        ChatCompletionMessage.builder()
                            .role(ChatCompletionMessage.Role.USER)
                            .content(userPrompt)
                            .build()
                    )
                ))
                .temperature(0.0) // Deterministic for factual tasks
                .maxTokens(500)
                .build()
        );

        return response.choices().get(0).message().content();
    }

    /**
     * Streaming response
     */
    public void generateStream(String systemPrompt, String userPrompt) {
        client.chat().completions().create(
            ChatCompletionCreateParams.builder()
                .model("gpt-4")
                .messages(Arrays.asList(
                    ChatCompletionMessageParam.ofChatCompletionMessage(
                        ChatCompletionMessage.builder()
                            .role(ChatCompletionMessage.Role.SYSTEM)
                            .content(systemPrompt)
                            .build()
                    ),
                    ChatCompletionMessageParam.ofChatCompletionMessage(
                        ChatCompletionMessage.builder()
                            .role(ChatCompletionMessage.Role.USER)
                            .content(userPrompt)
                            .build()
                    )
                ))
                .stream(true)
                .build()
        ).stream().forEach(event -> {
            if (event.choices().get(0).delta().content() != null) {
                System.out.print(event.choices().get(0).delta().content());
            }
        });
    }
}
```

### Option 2: Spring AI

```java
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

@Service
public class SpringAILLMService {
    private final ChatClient chatClient;

    public SpringAILLMService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    /**
     * Simple chat response
     */
    public String chat(String userMessage) {
        return chatClient
            .prompt(userMessage)
            .call()
            .content();
    }

    /**
     * Chat with system prompt + user message
     */
    public String chatWithSystem(String systemPrompt, String userMessage) {
        return chatClient
            .prompt()
            .system(systemPrompt)
            .user(userMessage)
            .call()
            .content();
    }

    /**
     * Chat with template variables
     */
    public String chatWithTemplate(String systemPrompt, String userTemplate, Map<String, Object> variables) {
        PromptTemplate promptTemplate = new PromptTemplate(userTemplate);
        Prompt prompt = promptTemplate.create(variables);

        return chatClient
            .prompt()
            .system(systemPrompt)
            .user(prompt.getContents())
            .call()
            .content();
    }

    /**
     * Streaming response
     */
    public void chatStreaming(String userMessage) {
        chatClient
            .prompt(userMessage)
            .stream()
            .content()
            .forEach(System.out::print);
    }
}
```

### Option 3: AWS Bedrock

```java
import software.amazon.awssdk.services.bedrockruntime.BedrockRuntimeClient;
import software.amazon.awssdk.services.bedrockruntime.model.*;

public class BedrockLLMService {
    private final BedrockRuntimeClient client;

    public BedrockLLMService() {
        this.client = BedrockRuntimeClient.builder().build();
    }

    /**
     * Generate text using Claude via AWS Bedrock
     */
    public String generate(String systemPrompt, String userPrompt) {
        String prompt = String.format(
            "<|im_start|>system\n%s\n<|im_end|>\n<|im_start|>user\n%s\n<|im_end|>\n<|im_start|>assistant",
            systemPrompt, userPrompt
        );

        InvokeModelRequest request = InvokeModelRequest.builder()
            .modelId("anthropic.claude-3-5-sonnet-20241022-v2:0") // Model ID varies
            .body(SdkBytes.fromUtf8String(String.format(
                "{\"prompt\": \"%s\", \"max_tokens\": 500, \"temperature\": 0.0}",
                prompt
            )))
            .build();

        InvokeModelResponse response = client.invokeModel(request);
        return new String(response.body().asByteArray());
    }

    public void close() {
        client.close();
    }
}
```

---

# 7. RAG Pipeline

## Complete RAG Flow

```
1. INGESTION (offline)
   ├─ Load documents (PDF, text, etc.)
   ├─ Parse & clean text
   ├─ Chunk into smaller pieces
   ├─ Embed each chunk
   └─ Store in vector DB

2. QUERY (online)
   ├─ Receive user query
   ├─ Embed query
   ├─ Retrieve top-K similar chunks
   ├─ Construct prompt (query + context)
   └─ Call LLM

3. RESPONSE
   └─ Generate grounded answer
```

## Java: Complete RAG Service

```java
@Service
public class RAGService {
    private final EmbeddingService embeddingService;
    private final HybridRetriever retriever;
    private final SpringAILLMService llmService;

    public RAGService(EmbeddingService embeddingService, 
                      HybridRetriever retriever,
                      SpringAILLMService llmService) {
        this.embeddingService = embeddingService;
        this.retriever = retriever;
        this.llmService = llmService;
    }

    /**
     * Ingest documents: parse, chunk, embed, store
     */
    public void ingestDocuments(List<String> filePaths) throws Exception {
        for (String filePath : filePaths) {
            List<String> chunks = DocumentParsingService.extractAndChunk(filePath);

            for (int i = 0; i < chunks.size(); i++) {
                String chunk = chunks.get(i);
                double[] embedding = embeddingService.embed(chunk);

                Document doc = new Document();
                doc.setId(filePath + "_chunk_" + i);
                doc.setContent(chunk);
                doc.setEmbedding(embedding);
                doc.setSource(filePath);

                // Store in vector DB (or in-memory for demo)
                documentStore.add(doc);
            }
        }
    }

    /**
     * Main RAG query: retrieve + generate
     */
    public RAGResponse query(String userQuery) {
        // Step 1: Retrieve top-K relevant documents
        List<Document> retrievedDocs = retriever.retrieve(userQuery, 5);

        // Step 2: Construct context from retrieved documents
        String context = retrievedDocs.stream()
            .map(d -> "Source: " + d.getSource() + "\n" + d.getContent())
            .collect(Collectors.joining("\n\n---\n\n"));

        // Step 3: Construct grounded prompt
        String systemPrompt = "You are a helpful assistant. Answer based ONLY on the provided context. "
            + "If the context doesn't contain the answer, say 'I don't have enough information'.";

        String userPrompt = String.format(
            "Context:\n%s\n\nQuestion: %s",
            context, userQuery
        );

        // Step 4: Call LLM
        String generatedAnswer = llmService.chatWithSystem(systemPrompt, userPrompt);

        // Step 5: Return response with sources
        return new RAGResponse(
            userQuery,
            generatedAnswer,
            retrievedDocs.stream().map(Document::getSource).distinct().collect(Collectors.toList())
        );
    }

    /**
     * Response class with attribution
     */
    static class RAGResponse {
        String query;
        String answer;
        List<String> sources;

        RAGResponse(String query, String answer, List<String> sources) {
            this.query = query;
            this.answer = answer;
            this.sources = sources;
        }

        @Override
        public String toString() {
            return "Answer: " + answer + "\n\nSources: " + String.join(", ", sources);
        }
    }
}
```

## REST Endpoint: RAG Query

```java
@RestController
@RequestMapping("/api/rag")
public class RAGController {
    private final RAGService ragService;

    public RAGController(RAGService ragService) {
        this.ragService = ragService;
    }

    @PostMapping("/ingest")
    public ResponseEntity<String> ingestDocuments(@RequestBody IngestRequest request) throws Exception {
        ragService.ingestDocuments(request.getFilePaths());
        return ResponseEntity.ok("Documents ingested successfully");
    }

    @PostMapping("/query")
    public ResponseEntity<RAGService.RAGResponse> query(@RequestBody QueryRequest request) {
        RAGService.RAGResponse response = ragService.query(request.getQuery());
        return ResponseEntity.ok(response);
    }

    static class IngestRequest {
        List<String> filePaths;
        // Getters, setters...
    }

    static class QueryRequest {
        String query;
        // Getters, setters...
    }
}
```

---

# 8. Evaluation

## RAGAS Metrics

RAG systems need structured evaluation.

| Metric | Measures | Ideal Score |
|--------|----------|------------|
| **Context Precision** | % of retrieved docs that are relevant | 1.0 |
| **Context Recall** | % of relevant docs that were retrieved | 1.0 |
| **Faithfulness** | % of answer supported by context | > 0.8 |
| **Answer Relevancy** | % that answer addresses the query | > 0.8 |

## Java: Basic Evaluation (Manual)

```java
public class RAGEvaluator {
    private final SpringAILLMService llmService;

    /**
     * Evaluate faithfulness: "Is answer supported by context?"
     * Returns score 0–1
     */
    public double evaluateFaithfulness(String context, String answer) {
        String prompt = String.format(
            "Given this context:\n%s\n\nDoes this answer faithfully follow from the context?\n%s\n\n"
            + "Answer with a score 0–1 where 1 means fully supported.",
            context, answer
        );

        String response = llmService.chat(prompt);
        try {
            return Double.parseDouble(response.trim());
        } catch (NumberFormatException e) {
            return 0.5; // Default if parsing fails
        }
    }

    /**
     * Evaluate relevancy: "Does answer address the query?"
     */
    public double evaluateRelevancy(String query, String answer) {
        String prompt = String.format(
            "Query: %s\n\nAnswer: %s\n\n"
            + "Does the answer directly address the query? "
            + "Answer with a score 0–1 where 1 means fully relevant.",
            query, answer
        );

        String response = llmService.chat(prompt);
        try {
            return Double.parseDouble(response.trim());
        } catch (NumberFormatException e) {
            return 0.5;
        }
    }

    /**
     * Evaluate retrieval precision: "Are retrieved docs relevant to query?"
     */
    public double evaluateRetrievalPrecision(String query, List<Document> retrievedDocs) {
        int relevantCount = 0;

        for (Document doc : retrievedDocs) {
            String prompt = String.format(
                "Query: %s\n\nDocument: %s\n\nIs this document relevant to the query? "
                + "Answer yes or no.",
                query, doc.getContent()
            );

            String response = llmService.chat(prompt);
            if (response.toLowerCase().contains("yes")) {
                relevantCount++;
            }
        }

        return (double) relevantCount / retrievedDocs.size();
    }
}
```

---

# 9. Production Considerations

## Caching

Reduce latency by caching embeddings.

```java
@Service
public class CachedEmbeddingService {
    private final EmbeddingService embeddingService;
    private final Cache<String, double[]> cache; // Caffeine, Redis, etc.

    public CachedEmbeddingService(EmbeddingService embeddingService) {
        this.embeddingService = embeddingService;
        this.cache = Caffeine.newBuilder()
            .maximumSize(10000)
            .expireAfterWrite(24, TimeUnit.HOURS)
            .build();
    }

    public double[] embed(String text) {
        return cache.get(text, key -> embeddingService.embed(key));
    }
}
```

## Error Handling & Retries

```java
@Service
public class ResilientRAGService {
    private final RAGService ragService;
    private final RetryTemplate retryTemplate;

    public ResilientRAGService(RAGService ragService) {
        this.ragService = ragService;
        this.retryTemplate = new RetryTemplate();
        this.retryTemplate.setRetryPolicy(new SimpleRetryPolicy(3)); // Retry up to 3 times
        this.retryTemplate.setBackOffPolicy(new ExponentialBackOffPolicy());
    }

    public RAGService.RAGResponse queryWithRetry(String query) {
        try {
            return retryTemplate.execute(ctx -> ragService.query(query));
        } catch (Exception e) {
            log.error("RAG query failed after retries: {}", query, e);
            // Fallback: return direct LLM response without retrieval
            return ragService.fallbackQuery(query);
        }
    }
}
```

## Observability: Logging & Metrics

```java
@Service
public class ObservableRAGService {
    private final RAGService ragService;
    private final MeterRegistry meterRegistry;

    public ObservableRAGService(RAGService ragService, MeterRegistry meterRegistry) {
        this.ragService = ragService;
        this.meterRegistry = meterRegistry;
    }

    public RAGService.RAGResponse query(String userQuery) {
        long startTime = System.currentTimeMillis();

        try {
            // Step 1: Retrieve
            long retrievalStart = System.currentTimeMillis();
            List<Document> docs = retriever.retrieve(userQuery, 5);
            long retrievalTime = System.currentTimeMillis() - retrievalStart;

            // Step 2: Generate
            long generationStart = System.currentTimeMillis();
            String answer = llmService.chatWithSystem(systemPrompt, userPrompt);
            long generationTime = System.currentTimeMillis() - generationStart;

            // Log metrics
            meterRegistry.timer("rag.retrieval.latency").record(retrievalTime, TimeUnit.MILLISECONDS);
            meterRegistry.timer("rag.generation.latency").record(generationTime, TimeUnit.MILLISECONDS);
            meterRegistry.counter("rag.query.success").increment();

            log.info("RAG query completed. Retrieval: {}ms, Generation: {}ms", 
                retrievalTime, generationTime);

            return new RAGService.RAGResponse(userQuery, answer, 
                docs.stream().map(Document::getSource).distinct().collect(Collectors.toList()));

        } catch (Exception e) {
            meterRegistry.counter("rag.query.failure").increment();
            log.error("RAG query failed: {}", userQuery, e);
            throw e;
        }
    }
}
```

---

# 10. Spring AI Integration

Spring AI provides a higher-level abstraction over RAG components.

## Spring AI: RAG with VectorStore

```java
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.ai.document.Document;

@Configuration
public class RAGConfiguration {
    
    /**
     * Configure VectorStore (e.g., FAISS, Pinecone, etc.)
     */
    @Bean
    public VectorStore vectorStore(EmbeddingClient embeddingClient) {
        return new SimpleVectorStore(embeddingClient); // Or use production-grade store
    }

    /**
     * Configure Document loader pipeline
     */
    @Bean
    public DocumentLoader documentLoader(VectorStore vectorStore, EmbeddingClient embeddingClient) {
        return new DocumentLoader() {
            public void load(String filePath) {
                // 1. Load documents
                PagePdfDocumentReader reader = new PagePdfDocumentReader(new File(filePath));
                List<Document> documents = reader.get();

                // 2. Split documents into chunks
                TokenTextSplitter splitter = new TokenTextSplitter();
                List<Document> chunks = splitter.apply(documents);

                // 3. Add to vector store (auto-embedded)
                vectorStore.add(chunks);
            }
        };
    }
}

@Service
public class SpringAIRAGService {
    private final VectorStore vectorStore;
    private final ChatClient chatClient;

    public SpringAIRAGService(VectorStore vectorStore, ChatClient chatClient) {
        this.vectorStore = vectorStore;
        this.chatClient = chatClient;
    }

    /**
     * RAG: retrieve + augment + generate
     */
    public String query(String userQuery) {
        // Step 1: Retrieve similar documents
        List<Document> retrievedDocs = vectorStore.similaritySearch(userQuery, 5);

        // Step 2: Construct context
        String context = retrievedDocs.stream()
            .map(Document::getText)
            .collect(Collectors.joining("\n\n"));

        // Step 3: Generate grounded response
        return chatClient
            .prompt()
            .system("Answer based ONLY on the provided context.")
            .user("Context: " + context + "\n\nQuestion: " + userQuery)
            .call()
            .content();
    }
}
```

## Spring AI: RAG Advisors (Advanced)

```java
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.chat.client.advisor.VectorStoreAdvisor;

@Service
public class SpringAIAdvisorsRAGService {
    private final ChatClient chatClient;
    private final VectorStore vectorStore;

    /**
     * Use VectorStoreAdvisor to automatically handle RAG
     */
    public String queryWithAdvisor(String userQuery) {
        return chatClient
            .prompt(userQuery)
            .advisors(new VectorStoreAdvisor(vectorStore)) // Auto-retrieve + augment
            .call()
            .content();
    }
}
```

