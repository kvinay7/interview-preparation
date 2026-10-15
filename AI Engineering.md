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

### Types of AI 

- **Based on Functionality**
    - **Reactive Machines** — Respond only to current input; no persistent memory.
    - **Limited Memory** — Uses information from previous observations/interactions for a limited period.
    - **Theory of Mind** — Hypothetical systems capable of understanding beliefs, intentions, and emotions.
    - **Self-Aware AI** — Hypothetical systems with consciousness/self-awareness.
      
- **Based on Capabilities**
    - **Narrow AI (Weak AI)** — Designed for specific tasks. **Examples:** GPT-6 Astra (OpenAI) & Claude Fable 5.1 (Anthropic).
    - **Artificial General Intelligence (AGI)** — Hypothetical AI capable of broad human-level intelligence across domains.
    - **Artificial Superintelligence (ASI)** — Hypothetical AI exceeding human intelligence across domains.

### State of AI — Evolution & Progression

```text
                 ARTIFICIAL INTELLIGENCE (AI)
                            │
          ┌─────────────────┴─────────────────┐
          ▼                                   ▼
     CLASSICAL AI                       MACHINE LEARNING
 (Search, Logic, Planning)             (Learning from Data)
          │                                    │
          ├── Knowledge-Based AI               ├── Supervised Learning
          ├── Probabilistic AI                 ├── Unsupervised Learning
          └── Evolutionary AI                  ├── Self-Supervised Learning
                                               └── Reinforcement Learning
                                                      │
                                                      ▼
                                              DEEP LEARNING
                                          (Neural Networks)
                                                      │
                    ┌─────────────────┬───────────────┼────────────────┐
                    ▼                 ▼               ▼                ▼
                   NLP           COMPUTER VISION   AUDIO AI      SCIENTIFIC AI
                    │                 │               │                │
                    └─────────────────┴───────────────┴────────────────┘
                                                      │
                                       ┌──────────────┴──────────────┐
                                       ▼                             ▼
                                PREDICTIVE AI                 GENERATIVE AI
                            (Classification, Forecasting)  (Text, Code, Images,
                                                            Audio, Video)
                                                                      │
                                                                      ▼
                                                          FOUNDATION MODELS
                                                      (LLMs, VLMs, Multimodal)
                                                                      │
                                                                      ▼
                                                          AI APPLICATION ENGINEERING
                                                       ┌──────────────┼──────────────┐
                                                       ▼              ▼              ▼
                                                      RAG        TOOL CALLING   FINE-TUNING
                                                       │              │
                                                       └──────┬───────┘
                                                              ▼
                                                        AGENTIC AI
                                                   (Goals, Planning, Actions,
                                                    Memory, Feedback, Tools)
                                                              │
                                            ┌─────────────────┼─────────────────┐
                                            ▼                 ▼                 ▼
                                      DIGITAL AGENTS     PHYSICAL AI         EDGE AI
                                      (Software, APIs)  (Robots, Vehicles) (On-Device AI)
```

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
| Deployment  |	API, cloud, self-hosted, edge                          |

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

### Type of RAG

| Type | Core Idea |
|---|---|
| **Naive / Basic RAG** | Basic retrieve → augment → generate pipeline |
| **Advanced RAG** | Improves retrieval and generation quality using techniques such as reranking and query transformation |
| **Modular RAG** | Builds RAG from replaceable, independently configurable components |
| **Graph RAG** | Uses knowledge graphs and relationships between entities for retrieval |
| **Agentic RAG** | Uses agents to dynamically decide when, what, and how to retrieve information |
| **Hybrid RAG** | Combines multiple retrieval methods, commonly semantic/vector search + keyword search |

---

## 2. RAG Implementation

### Stage 1 — Document Loading

**Q1. Why is document loading necessary in RAG?**

Document loading ingests external knowledge and converts it into a processable representation before chunking, embedding, indexing, and retrieval.

- **Design decisions and Trade-offs**

    - Local files are simple to implement but offer limited integration with enterprise data sources.
    - Object storage supports larger collections but requires additional integration and access management.
    - Database and API connectors enable enterprise ingestion but introduce authentication and synchronization complexity.

- **Failure modes and Solutions**

    - Unsupported formats → route documents to format-specific loaders.
    - Corrupted files → validate parsing and isolate failures.
    - Missing or outdated content → implement validation and incremental ingestion.

- **Production and Scalability**

    - Use asynchronous or bounded parallel ingestion for large collections.
    - Monitor ingestion success, failure, throughput, and processing time.
    - Support document updates and deletions.

- **Business Impact**: Reliable ingestion reduces missing or stale knowledge, which improves the reliability of downstream RAG answers.

**Q2. What is a `Document` in a RAG system?**

A `Document` is a representation of a source item containing extracted text and metadata.

```java
Document document = new Document(content, metadata);
```

- **Design decision**: Use a common document representation so downstream components do not depend on the original source format.
- **Production consideration**: Preserve source identity, version information, and trusted access-control metadata through subsequent stages.
- **Trade-off**: A common representation simplifies the pipeline, but format-specific information—such as PDF page numbers or document headings—must be retained explicitly if it is needed later.

**Q3. Why preserve metadata?**

Metadata enables source attribution, filtering, traceability, and document lifecycle management.

| Metadata field    | Purpose                                    |
| ----------------- | ------------------------------------------ |
| `documentId`      | Identifies the source document             |
| `source`          | Identifies the filename or source location |
| `documentType`    | Identifies the format                      |
| `lastModified`    | Helps detect changes                       |
| `contentHash`     | Helps detect content changes               |
| `tenantId`        | Supports tenant-specific filtering         |
| `documentVersion` | Identifies a particular version            |

- **Design decision**: Preserve source metadata when chunking and indexing; add chunk-specific fields without losing document-level information.
- **Failure mode**: If metadata is lost, source citations, filtering, and document updates become difficult.
- **Production consideration**: Metadata alone does not enforce security. Authorization must be enforced during retrieval, and tenant filters must not be bypassable by user-supplied values.
- **Business impact**: Traceability supports auditing, while correct filtering reduces the risk of exposing information to unauthorized users.

**Q4. What metadata should we store, and how do we choose it?**

Store metadata based on the capabilities the application requires: source attribution, filtering, updates, security, and auditing.

- **Design trade-offs**: Minimal metadata reduces storage and ingestion complexity. Rich metadata supports more sophisticated filtering and lifecycle management but increases maintenance requirements.
- **Production consideration**: Validate required fields, use stable identifiers, and avoid placing sensitive information in logs or unrestricted metadata fields.

**Q5. How do you handle errors during document loading?**

A robust loader distinguishes between configuration errors, unreadable files, empty content, unsupported formats, and malformed documents.

- **Design decision**: Choose the failure policy based on the ingestion workflow.

    - For a small prototype, failing fast may be appropriate.
    - For a production batch, isolate failures so one bad document does not block all valid documents.

- **Failure handling**

    - Transient errors → retry with bounded backoff.
    - Permanent parsing errors → record the failure and route for investigation.
    - Empty documents → skip or reject according to an explicit policy.
    - Missing source directory → report a clear configuration error.

- **Production consideration**: Track failed documents and retries. Ensure retries do not create duplicate index entries.

- **Trade-off**: Continuing after individual failures improves ingestion throughput, but it requires failure tracking and recovery procedures to prevent silent data gaps.

**Q6. Why use UTF-8 when reading text files?**

UTF-8 provides consistent character encoding and avoids relying on the machine's default encoding.

```java
String content = new String(
    Files.readAllBytes(file),
    StandardCharsets.UTF_8
);
```

- **Design decision**: Specify the expected encoding and use format-specific parsers for PDF and DOCX sources.
- **Failure mode**: Incorrect encoding or poor text extraction can introduce corrupted characters and reduce retrieval quality.
- **Production consideration**: Reading an entire file into memory is reasonable for small text files. For large documents or large ingestion workloads, use bounded-memory or streaming approaches where supported.
- **Business impact**: Consistent extraction prevents avoidable loss of important information before embedding and retrieval.

**Q7. Why should a document loader be an interface?**

An interface separates the loading contract from the source-specific implementation. We can implement `TextDocumentLoader`, `PdfDocumentLoader`, or `DatabaseDocumentLoader` while preserving the same downstream document representation.

```java
public interface DocumentLoader {
    List<Document> load() throws IOException;
}
```

- **Design decision**: Use a shared interface when multiple source types must feed the same pipeline.
- **Trade-off**: The abstraction makes new loaders easier to add, but an overly generic contract can hide source-specific capabilities such as pagination, streaming, or change notifications.
- **Production consideration**: Larger systems may need additional contracts for incremental synchronization, batch processing, and structured error reporting.

**Q8. What is the difference between document loading and chunking?**

| Document loading                 | Document chunking                           |
| -------------------------------- | ------------------------------------------- |
| Reads or extracts source content | Splits extracted content into smaller units |
| Produces document objects        | Produces chunk objects                      |
| Preserves source-level metadata  | Adds chunk-level metadata                   |
| Prepares data for processing     | Prepares data for embedding and retrieval   |

- **Design decision**: Keep the two stages separate so document parsers and chunking strategies can evolve independently.
- **Failure mode**: If extraction loses headings, tables, or page information, chunking may produce semantically incomplete pieces.
- **Production consideration**: Preserve useful structural metadata for citations, debugging, and retrieval quality.

**Q9. Should document loading happen at query time?**

Usually, no. RAG separates the indexing pipeline from the query pipeline.

- **Design decision**: Perform routine ingestion asynchronously or ahead of time to keep query processing responsive.
- **Trade-off**: Pre-indexing improves query latency but introduces index freshness and synchronization requirements.
- **Production consideration**: Support updates and deletions. Stale or deleted content must not remain retrievable indefinitely. On-demand ingestion can still be appropriate for particular use cases.
- **Business impact**: Separating the pipelines improves responsiveness and allows ingestion workloads to scale independently.

**Q10. How do you prevent duplicate documents?**

Use stable document IDs and content hashes to identify new, unchanged, and modified documents.

- **Design decision**

    - Stable ID: identifies the logical source document.
    - Content hash: detects whether the document's content changed.
    - Version: tracks a particular revision when version history is required.

- **Failure mode**: Re-ingesting the same document without deduplication can create duplicate chunks and distort retrieval results.

- **Production solution**: Make ingestion idempotent. When content changes, replace or remove outdated chunks as the new version is indexed. Handle interrupted updates so the index does not remain partially updated.

- **Trade-off**: Hashing and version tracking introduce processing and metadata overhead but reduce duplicate storage and stale retrieval.

**Q11. How would you design incremental ingestion?**

Incremental ingestion processes only documents that are new, modified, or deleted.

- **Workflow**
    
    - Discover source changes.
    - Compare IDs, timestamps, versions, or content hashes.
    - Parse and chunk changed documents.
    - Generate embeddings for their chunks.
    - Update or remove outdated indexed entries.
    - Record the outcome.

- **Design decision**: Use timestamps as an inexpensive change signal when reliable; use content hashes when content-level verification is important.

- **Failure modes and solutions**

    - Missed changes → use reliable source synchronization and verification.
    - Partial updates → track ingestion state and implement recovery.
    - Concurrent updates → use version checks or suitable synchronization.
    - Deletion events missed → synchronize deletions as well as additions.

- **Production consideration**: Re-index only affected documents, and ensure old content is not exposed after a required deletion or access revocation.

- **Business impact**: Incremental ingestion reduces redundant parsing and embedding work, lowering operating cost and improving freshness.

**Q12. How would you scale document ingestion?**

For small collections, sequential processing from a local directory is often sufficient. Larger systems may ingest from object storage, enterprise repositories, databases, or event streams.

- **Design decision**

    - Sequential processing → simplest operational model.
    - Bounded parallel processing → higher throughput with controlled resource usage.
    - Streaming or pagination → avoids loading an entire collection into memory.
    - Event-driven ingestion → reacts to source changes without repeatedly scanning everything.

- **What breaks at scale?**

    - Memory exhaustion from loading too much content.
    - Embedding API rate limits.
    - Excessive parser concurrency.
    - Growing ingestion backlogs.
    - Repeated processing of unchanged documents.

- **Production solutions**: Apply bounded concurrency, batching, backpressure, retry limits, and incremental change detection. Monitor throughput, failures, queue depth, and processing latency.

- **Business impact**: The objective is not maximum throughput at any cost; it is meeting freshness and reliability requirements within budget.

**Q13. How do you secure document ingestion?**

Enterprise documents may contain confidential company information, customer data, or other sensitive content.

- **Design decision**: Define trusted source boundaries and preserve ownership, tenant identity, and access-control information through indexing.

- **Failure modes and solutions**

    - Untrusted metadata → validate it against authoritative sources.
    - Cross-tenant retrieval → enforce tenant-scoped filters and authorization.
    - Sensitive content in logs → redact or avoid logging document contents.
    - Revoked access → propagate permission changes to retrieval controls.

- **Production consideration**: Restrict access to source documents, vectors, credentials, and ingestion logs. Enforce authorization at retrieval time; simply storing an access-control field is not sufficient.

- **Business impact**: Proper controls reduce data leakage, compliance risk, and the potential impact of unauthorized access.


**Q14. RAG system ingests 100,000 documents, and users report that answers sometimes cite outdated policies. How to investigate and fix the issue?**

- **Diagnose**: Check source modification events, ingestion logs, document versions, and index freshness.
- **Identify the root cause**: Determine whether changes were not detected, ingestion failed, or stale chunks were not removed.
- **Design the fix**: Introduce reliable change detection, idempotent updates, version tracking, and deletion handling.
- **Protect correctness**: Avoid exposing stale content during updates where freshness or security requirements prohibit it.
- **Measure success**: Track ingestion lag, failed updates, stale retrieval incidents, and indexing cost.
- **Business trade-off**: Balance update freshness against re-indexing cost and operational complexity.

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

