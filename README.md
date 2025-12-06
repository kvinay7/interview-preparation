AI-Powered Trade Reconciliation
________________________________________
1. Application Overview: 
How Reconciliation Currently Works in Firms
Traditional financial reconciliation relies heavily on brittle rules defined in ETL (Extract, Transform, Load) processes or legacy systems.
1.	Schema Alignment: Files from different counterparties (brokers, custodians) must be manually mapped to an internal format, requiring operations staff to maintain complex lookup tables (TradeID in Source A maps to TransactionRef in Source B).
2.	Matching: Exact string matching is performed on keys. Minor differences (extra spaces, currency casing like 'USD' vs 'usd') immediately result in a "break".
3.	Exception Handling: Analysts spend up to 80% of their time manually investigating breaks, comparing source JSON/records to determine if a discrepancy is a substantive difference (wrong amount) or a semantic difference (typo in counterparty name).
The Problem
The traditional system is inflexible, slow, and expensive to scale. Any minor change in a counterparty's file format or data entry practice generates immediate operational friction.
Our GenAI Solution
The Trade Reconciliation Workbench leverages LLMs to introduce semantic intelligence into the process, focusing on the highest-value pain points:
1.	AI-Native Mapping: Automatically maps disparate source schemas to a Canonical Standard using LLMs, eliminating manual mapping maintenance.
2.	Explainable Matching: Instead of just flagging a break, the LLM provides a real-time explanation and confidence score for discrepancies, turning partial matches into actionable insights.
3.	Human-in-the-Loop (HILT) Control: The system enforces analyst review and required remarks for auditability, ensuring compliance while drastically reducing investigation time.

2. Architecture Design
The architecture follows a Decoupled Three-Layer Design where the Intelligence Layer (LLM) acts as the cognitive engine for data preparation and initial exception analysis, leaving the Core Processing Layer (Pandas) to handle the high-speed deterministic matching.
2.1 Data Flow and Component Interaction
The system operates in a three-stage pipeline triggered by the user:
1.	Ingestion & Schema Discovery: Raw data is loaded. The LLM processes the central dataset to create the canonical schema and derives normalization rules (e.g., mapping canonical trade_id to normalized trade_id).
2.	Preparation & Mapping: The LLM maps all source columns to the Canonical Schema. The Pandas engine applies these mappings and cleans/normalizes data types (dates, currencies, etc.).
3.	Reconciliation & Analysis: The Pandas engine performs a Strict Primary Key Join (Hash Map lookup). For any resulting Value Break (same ID, different data), the records are passed back to the LLM for real-time explanation and scoring.
2.2 Strict Reconciliation Principle
The design prioritizes safety by enforcing a strict rule: trade_id MUST be an exact string match.
•	No Fuzzy ID Matching: The LLM is prohibited from making a decision on ID similarity (e.g., not allowed to say "TRD-101" is close to "TRD-101-B").
•	LLM Target: The LLM is only tasked with analyzing Value Breaks (where the ID is guaranteed identical) to determine if the differences in non-key fields are material or semantic.

2.3 LLM as a Semantic Filter
By pre-filtering using the strict primary key rule, the LLM is transformed from a general-purpose text generator into an Agentic Quality Assurance (QA) Tool.
•	LLM Target: The LLM's only task is to determine if a value break (e.g., $1,000.00$ vs $1000$) is a substantive difference (material error) or a semantic difference (formatting error).


 



3. Component Explanation
Component	Technology	Role
Presentation Layer	Streamlit	Manages user interaction, file upload, state (st.session_state), and the final record-by-record review dashboard.
Intelligence Layer	Gemini 2.0 Flash	Schema Inference, Column Mapping, Normalization Rule Derivation, and Partial Match Analysis (llm_explain_and_score).
Processing Layer	Python, Pandas	Handles high-speed data loading, deterministic reconciliation (hash map lookups), data cleaning (normalize_df), and final export to Excel.
Orchestration Layer	LangChain	Provides structured prompting (Pydantic Output Parsers) to ensure the LLM returns predictable JSON objects that the Python code can consume reliably.

4. Technical Specifications & APIs
Specification	Details
Primary Language	Python 3.9+
Tech Stack	Streamlit, Pandas
LLM Provider	Google Gemini (via langchain-google-genai)
LLM Model	gemini-2.0-flash
APIs Used	Gemini API (ChatGoogleGenerativeAI), Streamlit API, Pandas API, openpyxl (for Excel export)
Data Storage	In-memory (Pandas DataFrames)

5. Prompt Engineering Strategy
The success of the application relies on using structured, high context prompts that force the LLM into the correct persona for a financial task.
Prompts Used in Solution Development
Phase	Prompt Example	Purpose
Understanding Problem	"As a financial architect, detail the process flaws when reconciling trade files where column names and data formatting differ between counterparties."	Established the need for Semantic Mapping over brittle ETL rules.
Requirements Gathering	"Define a structured JSON format for an LLM to output a column mapping. Ensure the output is consumable directly by a Pandas script."	Led to the design of the Pydantic Models (MappingOutput) for reliable output parsing.
Design/Code	"Develop a Python function that uses a Pandas hash map to join two dataframes strictly on trade_id, then loop only through mismatched records. 	Guided the implementation of the Strict O(1) Lookup logic in the run_reconciliation function.

Prompts Used in Code
Function	Goal	Persona/Technique
infer_canonical_schema	Schema Discovery	Financial Data Architect. Input: Raw data sample. Output: SchemaOutput (JSON structure).
map_columns_to_canonical	Schema Mapping	Reconciliation Expert. Input: Source columns vs. Target list. Output: Strict mapping dictionary (JSON).
infer_normalization_mapping	Rule Derivation	Data Engineer. Input: Canonical field names. Output: Map to internal normalized fields (trade_id, amount, etc.).
llm_explain_and_score	Exception Analysis	Trade Operations Analyst. Input: Source JSON + Central JSON + List of Mismatch fields. Output: JSON containing verdict (yes/no/maybe) and confidence.
