# AI Engineering

---

## Q1. What is Artificial Intelligence (AI)?

AI is a field of computer science that enables machines or systems to mimic human intelligence such as learning, reasoning, problem-solving, and decision-making. Unlike traditional software, AI improves automatically from data and feedback.

**Examples:** Siri (NLP), Netflix recommendations (ML), Tesla Autopilot (CV + RL).

---

## Q2. Types of AI (Based on Capabilities)

1. **Narrow AI (Weak AI)** — Specialized for one task. Example: ChatGPT, Gemini
2. **General AI (Strong AI)** — As intelligent as humans across all domains
3. **Superintelligent AI** — Hypothetical future AI surpassing human intelligence

---

## Q3. Types of AI (Based on Functionality)

1. **Reactive Machines** — No memory, react only to current input
2. **Limited Memory** — Uses short-term memory from past data
3. **Theory of Mind** — Understands human emotions, beliefs, and intentions
4. **Self-Aware AI** — Has consciousness and self-awareness (Hypothetical)

---

## Q4. Advantages of AI

- Automates repetitive and complex tasks
- Personalization (e.g., Spotify, YouTube)
- Faster pattern detection (e.g., fraud, disease diagnosis)
- Scalable and consistent decision-making
- Improves accuracy with data

---

## Q5. Challenges of AI

- **Bias** — Biased data → biased predictions
- **Privacy** — Data misuse, surveillance
- **Explainability** — "Black-box" problem in deep learning
- **Job Displacement** — Automates some roles
- **Ethics** — Deepfakes, misinformation
- **Energy Use** — Large models require heavy computation
- **Regulation** — Compliance with laws like GDPR, AI Act

---

## Q6. What is Machine Learning (ML)?

ML is a subset of AI where algorithms learn patterns from data instead of being explicitly programmed. Enable systems to improve performance automatically through experience.

---

## Q7. Types of Machine Learning

1. **Supervised Learning** — Learns from labeled data. Example: Spam vs. Non-Spam emails
2. **Unsupervised Learning** — Learns from unlabeled data. Example: Customer segmentation, topic modeling
3. **Semi-Supervised Learning** — Mix of labeled + unlabeled data. Example: Speech recognition
4. **Reinforcement Learning** — Learns by trial and error with rewards/penalties. Example: Game bots, robotics

---

## Q8. What is Deep Learning (DL)?

DL is a subset of ML that uses multi-layered neural networks to learn complex hierarchical patterns from raw data.

- Learns directly from pixels, sound, or text
- Uses backpropagation for learning
- Scales efficiently with big data + GPUs

---

## Q9. What is a Neural Network?

A computational model inspired by the human brain:

- **Input Layer** — Raw data (e.g., pixels)
- **Hidden Layers** — Weighted transformations + activation functions
- **Output Layer** — Final prediction (e.g., cat/dog)

Each neuron applies a weighted sum + activation function to introduce non-linearity.

---

## Q10. Why is Deep Learning Powerful?

- Learns nonlinear + complex relationships
- Handles massive unstructured data (text, image, video, audio)
- Achieves state-of-the-art performance in CV, NLP, and Speech
- Supports transfer learning and generalization

---

## Q11. What is Natural Language Processing (NLP)?

NLP is a subfield of AI focused on enabling machines to understand, interpret, and generate human language.

**Core Tasks:** Tokenization, POS tagging, NER, sentiment analysis, translation, summarization, chatbots.

---

## Q12. Key Architectures in NLP Evolution

**For Text/NLP:**
- **RNNs** → handle sequential data
- **LSTMs / GRUs** → solve vanishing gradient issues
- **Transformers (2017)** → Attention-based, parallelized architecture (BERT, GPT)

**For Generative Models:**
- **Autoencoders (2010s)** → Compress + reconstruct data
- **VAEs (2013)** → Learn latent distributions
- **GANs (2014)** → Adversarial generation of images
- **Diffusion Models (2020+)** → Iteratively refine noise to generate images (DALL·E, Stable Diffusion)

---

## Q13. What is Generative AI?

Generative AI models create new content (text, images, audio, code, etc.) that resembles training data. Traditional AI models analyze existing data to make predictions, classifications, or decisions based on learned patterns, without creating new content.

---

## Q14. What is a Large Language Model (LLM)?

LLMs are Transformer-based models trained on massive text corpora with billions of parameters. They understand and generate human-like text.

---

## Q15. How do LLMs Work at a High Level?

1. **Tokenize input text** → convert words into token IDs
2. **Lookup embeddings** → token IDs → dense vectors (token embeddings)
3. **Add positional embeddings** → tell the model the order of tokens
4. **Pass through transformer layers** → use self-attention + feed-forward layers to capture context
5. **Compute logits for next token** → predict probability distribution over vocabulary
6. **Sample or choose next token** → append predicted token to sequence
7. **Repeat autoregressively** → predict tokens one by one until end of sequence
8. **Output text** → convert generated token IDs back to words

---

## Q16. Limitations of LLMs

- **Bias** — Reflect training data bias
- **Hallucinations** — Produce false but confident answers
- **Resource Intensive** — Require GPUs, memory, tokens
- **Limited Context** — Can't remember beyond fixed window (e.g., 128k tokens)
- **Cost** — High inference/training cost

---

## LLM Terminology & Key Concepts

| Term | Meaning |
|---|---|
| **Prompt** | Instructions or query given to the model |
| **Tokens** | Basic units of text the model processes |
| **Context Window** | Max token length model can remember |
| **Hallucination** | False but confident output |
| **Temperature** | Controls randomness (0 = factual, 1 = creative) |
| **Embeddings** | Vector representation of text that capture semantic meaning (similar meaning) |
| **Vector Store** | Database that stores embeddings + metadata |
| **Chunking** | Splitting documents into smaller pieces |
| **Overlapping** | Maintains context between chunks |
| **RAG (Retrieval-Augmented Generation)** | Retrieve external docs + feed to LLM to improve accuracy |
| **Fine-Tuning** | Retrain LLM on domain data |
| **PEFT (LoRA, Prefix-Tuning)** | Lightweight fine-tuning for efficiency |
| **Chatbot** | AI program that simulates conversational interactions with users via text or voice |
| **Guardrails / Moderation** | Prevent harmful output |

---

## Q17. What is LangChain?

A framework to build LLM-powered apps with building blocks:

- Prompts, Chains, Memory, Retrieval, Agents, Tools
- Handles RAG pipelines and production use-cases
- It helps developers create dynamic, context-aware applications rather than static text generators

---

## MCP (Model Context Protocol)

MCP refers to the design pattern or strategy for managing the inputs (prompts, data, memory, tools, instructions) and outputs (responses, parsed results) that flow into and out of an LLM within a larger system.

**Purpose:** Safe bridge between LLM reasoning and real-world tools. It prevents N×M integration complexity and creates a standardized tool invocation boundary while protecting enterprise systems from uncontrolled LLM behavior.

---

## Q18. How to Use LLM and Prompt Templates in LangChain?

```python
from langchain.prompts import PromptTemplate
from langchain_openai import OpenAI

llm = OpenAI(
    model_name = MODEL_NAME,
    openai_api_key = OPENAI_API_KEY,
    openai_api_base = OPENAI_API_BASE,
    temperature = 0
)

template = """
Summarize this in 3 bullet points and return output as JSON:
{
  "bullets": ["point 1", "point 2", "point 3"]
}
Text: {text}
"""

prompt = PromptTemplate(
    template=template, 
    input_variables=["text"]
)
```

---

## Q19. What are Chains and Output Parsers in LangChain?

**Chains** = sequence of steps (prompt → LLM → output parser). Chains define reusable workflows.

```python
from langchain.chains import LLMChain
from langchain.output_parsers import JsonOutputParser

parser = JsonOutputParser()
chain = LLMChain(llm=llm, prompt=prompt)

input_text = """Python is Awesome."""
output = chain.run({"text": input_text})
parsed_output = parser.parse(output)
```

---

## Q20. Why Use Memory?

Memory preserves context and state to enable multi-turn conversations.

- **ConversationBufferMemory** → remembers full history
- **ConversationBufferWindowMemory** → remembers only last n exchanges
- **ConversationSummaryMemory** → summarizes past interactions
- **ConversationKGMemory** → remembers conversations as a knowledge graph
- **CombinedMemory** → combines multiple memory mechanisms in one memory
- **ZepMemory** → provides long-term persistent memory across sessions

```python
from langchain.memory import CombinedMemory, ConversationBufferMemory, ConversationSummaryMemory

buffer_mem = ConversationBufferMemory()
summary_mem = ConversationSummaryMemory()
combined_mem = CombinedMemory(memories={"buffer": buffer_mem, "summary": summary_mem})

combined_mem.chat_memory.add_user_message("Hello!")
combined_mem.chat_memory.add_ai_message("Hi there!")

print(f"Buffer: {buffer_mem.buffer} \nSummary: {summary_mem.buffer}")
```

---

## Q21. How Retrieval-Augmented Generation (RAG) Works?

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

## Q26. What is Hugging Face?

Hugging Face is like GitHub for AI models — it provides a place where developers, researchers, and organizations can share, collaborate on, and use pre-trained machine learning models for tasks like text generation, translation, sentiment analysis, image recognition, and more.

---

## Q27. What is Tokenization?

Tokenization is the process of converting text (like a sentence) into smaller pieces called tokens that a language model can understand and process.

```python
from transformers import AutoTokenizer
import pandas as pd

# Load GPT-2 tokenizer
tokenizer = AutoTokenizer.from_pretrained("gpt2")

# Define your input text
text = "Udacity is the best place to learn about generative AI."

# Tokenize the input
tokens = tokenizer.tokenize(text)
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

## Q28. What are Tools and Agents?

- **Tools** — LangChain provides a framework to build tools (deterministic functions that perform a single, well-defined task) that extend LLMs' capabilities such as accessing live data, executing tasks, and interfacing with APIs
- **Agents (LLMs)** — Can decide when and which tool to use based on user queries. Performs specific predefined tasks automatically

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
