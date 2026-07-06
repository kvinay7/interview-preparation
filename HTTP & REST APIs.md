# HTTP & REST APIs

---

## What is a Backend?

A backend is a long-running, trusted, server-side application that receives requests from untrusted clients, executes deterministic business logic, manages state, controls access to resources, offloads heavy computation, and safely integrates with databases and AI systems.

---

## Why Do We Need a Backend?

A backend is not just CRUD endpoints. A backend system is responsible for:

- **Reliability** — system keeps working correctly over time
- **Scalability** — handles growth in users and load
- **Fault tolerance** — partial failures don't crash the system
- **Maintainability** — easy to change without breaking things

---

## How is Backend Different from Frontend?

### Security

**Concept:**
- Browsers run in a sandbox and cannot access OS resources
- Only the backend can do this securely

**GenAI Application:**
- API Keys: OPENAI_API_KEY must never exist in frontend code
- File Access: RAG requires reading PDFs/docs from server or S3

### Centralization of State (Source of Truth)

**Concept:**
- Frontend state → temporary (per user, per device)
- Backend state → persistent and shared

**GenAI Application:**
- Chat history stored in PostgreSQL/Mongo
- Enables conversation resume across devices

### Connection Pooling (Database Survival)

**Concept:**
- Browsers open a new connection per request
- Databases cannot handle thousands of direct connections

**Example:**
- 10,000 users → 10,000 DB connections → DB crash
- Backend manages this with ~50 pooled connections

### Compute Power (Offloading Heavy Work)

**Concept:** Clients have limited CPU/RAM. Servers can scale compute power vertically and horizontally.

**GenAI Application:**
- Running a 7B Llama model in browser ❌
- Offload inference to GPU servers (AWS EC2 g4/p3) ✅

---

## OSI Model

Open Systems Interconnection (OSI) Model is a 7-layer conceptual model that explains how data travels from one system to another over a network.

| Layer | Name | What It Does | Common Protocols | Backend Usage |
|---|---|---|---|---|
| 7 | Application | User-facing network services | HTTP, HTTPS, REST, GraphQL, WebSocket | API design, request/response handling, headers, auth, JSON payloads, GenAI inference APIs |
| 6 | Presentation | Format, encryption, compression | TLS/SSL, JSON, UTF-8, gzip | HTTPS encryption, serialization/deserialization handled by frameworks |
| 5 | Session | Connection/session management | Cookies, Tokens, Sessions | User sessions, auth tokens, GenAI conversation state |
| 4 | Transport | Reliable data transfer | TCP, UDP | HTTP over TCP, connection reliability, retries, timeouts, streaming responses |
| 3 | Network | Routing, IP addressing | IP, ICMP | Cloud networking awareness (VPCs, subnets, routing) |
| 2 | Data Link | Frames, MAC addresses | Ethernet, ARP | Fully abstracted by OS / network hardware |
| 1 | Physical | Wires, signals | Fiber cables, radio | Hardware-level transmission |

---

## HTTP Basics

### Why Do We Need Statelessness?

- **Scalability:** If Server A crashes, Server B can handle the next request because there is no "session memory" locked on Server A
- **Simplicity:** Servers don't need complex logic to track "where was this user a minute ago?" This reduces server-side complexity and memory usage
- **GenAI Context:** API keys, cookies, sessions or tokens must be sent in the header of every request because HTTP is a stateless client-server communication protocol. Authentication state is not automatically preserved between requests, so each request must independently include all the information needed for the server to process it. HTTPS (HTTP + TLS) ensures those credentials are encrypted in transit

### What Happens When We Hit a URL?

When we hit a URL, the process follows a flow of discovery, connection, and data exchange:

1. **DNS Resolution:** First, the browser checks its cache or asks the local ISP to resolve the domain name. The DNS system finds the correct IP address through a hierarchy of servers

2. **Connection Establishment:** With the IP address, a TCP connection (and a TLS handshake for HTTPS) is established. This 'pipe' is created via multiple network hops across the internet backbone. HTTP relies on TCP at the Transport layer for reliable, connection-based communication using a 3-way handshake

3. **Routing & Abstraction:** The request is routed using IP addresses, where lower-level details like MAC addressing are abstracted away as data moves from router to router

4. **Security & Destination:** The request passes through firewalls and load balancers to reach the server on a specific port

5. **Response & Rendering:** The server processes the request, sends back an HTTP response, and the browser finally renders the resource

---

## HTTP Messages

An HTTP message (Request/Response) is the structured data exchanged between a client and a server.

### HTTP Request Message Structure

```
<Method> <URL> <HTTP Version> (Request Line)
<Headers>
(blank line - Separates headers from body)
<Body> (Optional)
```

### HTTP Response Message Structure

```
<HTTP Version> <Status Code> <Status Text> (Status Line)
<Headers>
(blank line)
<Body>
```

---

## HTTP Versions

### HTTP/0.9
- First HTTP version
- Supports only GET
- No headers, no status codes
- Response contains only HTML
- Limitation: Very basic, no error handling

### HTTP/1.0
- Introduced headers and status codes
- Supports multiple content types (HTML, images, text)
- Each request uses a new TCP connection (reliable, ordered)
- Limitation: Slow due to repeated connections

### HTTP/1.1
- Uses persistent connections (Keep-Alive)
- Mandatory Host header
- Supports more methods: PUT, DELETE
- Better caching and performance
- Limitation: Head-of-line blocking at application layer — One request at a time. If one request is slow → all others wait (packet by packet sequence)

### HTTP/2
- Uses binary protocol (not text)
- Supports multiplexing (multiple requests at once)
- Header compression reduces overhead
- Faster than HTTP/1.1
- Note: Usually used with HTTPS

### HTTP/3
- Uses QUIC protocol on top of UDP
- Faster connection setup
- No head-of-line blocking at transport layer
- Built-in security (TLS 1.3)
- Best for: Mobile and high-latency networks

---

## HTTP Headers

HTTP headers are extensible metadata fields that act as a remote control for client–server communication.

| Category | What It Is | Examples | Purpose |
|---|---|---|---|
| Request Headers | Sent by the client | Authorization, User-Agent, Accept | Authentication, client ID, content preference |
| General Headers | Used in both requests & response | Date, Cache-Control, Connection | Caching, metadata, connection control |
| Response Headers | Describe the body | Content-Type, Content-Length, Content-Encoding, ETag | Parsing, compression, caching, content interpretation |
| Security Headers | Protect against attacks | Strict-Transport-Security, Content-Security-Policy, X-Frame-Options, X-Content-Type-Options | HTTPS downgrade, Prevent XSS, Clickjacking, MIME sniffing |

---

## HTTP Methods (Intent of Requests)

| Method | Intent | Request Body | Idempotent | Why / Key Reason |
|---|---|---|---|---|
| GET | Fetch data from server | ❌ No | ✅ Yes | Fetching multiple times doesn't change server state |
| POST | Create new resource (or) Custom actions | ✅ Yes (Optional) | ❌ No | Each call creates a new resource (different result each time) |
| PATCH | Partial update of resource | ✅ Yes | ❌ Not guaranteed | Selective update; repeated calls may change state incrementally |
| PUT | Replace entire resource | ✅ Yes | ✅ Yes | Replacing with same data gives same result every time |
| DELETE | Delete resource | ❌ No | ✅ Yes | Resource can only be deleted once |
| OPTIONS | Ask server capabilities | ❌ No | ✅ Yes | Pure inquiry; no state change |

---

## CORS (Cross-Origin Resource Sharing)

CORS is a browser-enforced security mechanism (Same-Origin Policy) that controls how web applications interact with resources from different origins (protocol + domain + port) unless the server explicitly allows it via headers.

### Simple CORS Request Flow

**A request is simple if all conditions are true:**
- Method = GET / POST / HEAD
- No custom headers
- Content-Type is one of: application/x-www-form-urlencoded, multipart/form-data, text/plain

**Simple Request Flow:**
1. Browser sends request
2. Browser adds Origin header
3. Server checks CORS policy
4. Server responds with: `Access-Control-Allow-Origin: example.com` (or *)
5. Browser allows response to reach frontend
6. If the server omits the header, the browser blocks the response

### Pre-Flight CORS Request Flow

**A request becomes pre-flighted if any one of these is true:**
- Method is not GET / POST / HEAD
- Has custom headers (e.g., Authorization)
- Content-Type is application/json
- Uses credentials (cookies)

**Pre-Flight Flow:**

1. Browser sends:
```
OPTIONS /resource
Origin: frontend.com
Access-Control-Request-Method: PUT
Access-Control-Request-Headers: Authorization
```

2. Server responds:
```
204 No Content
Access-Control-Allow-Origin: frontend.com
Access-Control-Allow-Methods: GET, POST, PUT, DELETE
Access-Control-Allow-Headers: Authorization, Content-Type
Access-Control-Max-Age: 86400
```

3. Browser validates:
   - Origin allowed
   - Method allowed
   - Headers allowed

4. If valid, browser sends the original request
5. If invalid, browser blocks the request

---

## HTTP Status Codes

HTTP status codes are standardized three-digit numbers sent by the server to indicate the result of a client's request. They quickly tell the client whether the request succeeded, failed, or required further action.

### 1xx — Informational

| Code | Name | Meaning | When to Use | Example |
|---|---|---|---|---|
| 100 | Continue | Server received headers, ready for body | Large uploads | Client sends prompt chunks |
| 101 | Switching Protocols | Server switches protocol | WebSocket upgrade | HTTP → WebSocket chat |

### 2xx — Success

| Code | Name | Meaning | When to Use | Example |
|---|---|---|---|---|
| 200 | OK | Request succeeded | Successful GET / PATCH / PUT | Fetch chat history |
| 201 | Created | New resource created | POST requests | Create new conversation |
| 202 | Accepted | Request accepted but not completed | Processing Async | Background AI job started |
| 204 | No Content | Success, no body | DELETE, OPTIONS | Delete chat, CORS pre-flight |

### 3xx — Redirection

| Code | Name | Meaning | When to Use | Example |
|---|---|---|---|---|
| 301 | Moved Permanently | Resource moved permanently | API version migration | /v1/chat → /v2/chat |
| 302 | Found (Temporary Redirect) | Resource moved temporarily | Campaigns, A/B testing | Temporary UI routing |
| 304 | Not Modified | Resource unchanged | Caching with ETag | Use cached chat history |

### 4xx — Client Error

| Code | Name | Meaning | When to Use | Example |
|---|---|---|---|---|
| 400 | Bad Request | Malformed request | Invalid JSON | Invalid prompt format |
| 401 | Unauthorized | Missing or invalid auth | Missing/expired JWT | User not logged in |
| 403 | Forbidden | No permission | Access denied | User accessing others' chats |
| 404 | Not Found | Resource doesn't exist | Wrong URL / deleted | Chat ID not found |
| 405 | Method Not Allowed | Wrong HTTP method | Route misuse | PUT on GET-only API |
| 409 | Conflict | Resource conflict | Duplicate creation | Folder name exists |
| 422 | Unprocessible Entity | Valid format but validation failed | Validation Error | Prompt too long |
| 429 | Too Many Requests | Rate limit exceeded | Abuse protection | GenAI rate limit |

### 5xx — Server Error

| Code | Name | Meaning | When to Use | Example |
|---|---|---|---|---|
| 500 | Internal Server Error | Unexpected crash | Unhandled exception | Backend error |
| 501 | Not Implemented | Feature not supported yet | Planned feature | Model not available |
| 502 | Bad Gateway | Invalid upstream response | Proxy issues | LLM API failure |
| 503 | Service Unavailable | Server overloaded/down | Maintenance | GenAI API down |
| 504 | Gateway Timeout | Upstream timeout | Slow dependency | LLM API slow |

---

## HTTP Caching

HTTP caching is a mechanism that allows clients (Browser/CDN) to reuse previously fetched responses if the resource has not changed, reducing bandwidth, latency, server load or network calls. In modern systems, HTTP caching exists, but frontend caching libraries (e.g., React Query) often manage caching more reliably.

### Caching Flow

**1. First request:**
- The client sends a GET /resource request to the server
- The server responds with 200 OK and includes:
  - Cache-Control: max-age=10 (How long resource can be cached)
  - ETag: "3141" (Hash of resource version)
  - Last-Modified: <timestamp> (Timestamp of last update)
- The response body and these headers are stored in the client's cache

**2. Subsequent request:**
- When the client needs the same resource again, it sends another GET /resource
- This time, it includes validation headers:
  - If-None-Match: "3141" (using the cached ETag)
  - If-Modified-Since: <timestamp> (using the cached Last-Modified value)

**3. If the resource has not changed:**
- The server compares the validators and determines the resource is unchanged
- It responds with 304 Not Modified and no response body
- The client reuses the cached version of the resource

**4. If the resource has changed:**
- The server detects that the resource has been modified
- It responds with 200 OK, a new response body, and updated headers:
  - New ETag
  - New Last-Modified
- The client replaces the old cached entry with the new one

---

## HTTP Content Negotiation

Content negotiation is a mechanism where clients and servers agree on the best format, language, and encoding to exchange data.

### Why Content Negotiation Exists

- Flexible formats — Allows responses in JSON, XML, HTML
- Language support — Supports multiple languages (English, Spanish, etc.)

### Main Content Negotiation Headers

| Header | Purpose |
|---|---|
| Accept | Specifies preferred media type |
| Accept-Language | Specifies preferred language |
| Accept-Encoding | Specifies supported compression |

### Media Type Negotiation

**Client → Server:** `Accept: application/json`
**Server → Client:** `Content-Type: application/json`

### Language Negotiation

**Client → Server:** `Accept-Language: es`
**Server → Client:** Responds with Spanish content

### Encoding Negotiation (Compression)

**Client → Server:** `Accept-Encoding: gzip`
**Server → Client:** `Content-Encoding: gzip`

---

## REST API Design

### Why Does API Design Matter?

- Backend engineers spend a significant amount of time designing APIs, not just implementing them
- Poor API design leads to:
  - Confusion over HTTP methods (PUT vs PATCH, POST vs custom actions)
  - Inconsistent status codes
  - Ambiguous routes and payloads
- API layer is responsible for: Accept → Validate → Authorize → Delegate → Format → Respond

### What is a REST API?

- [REST](https://github.com/kvinay7/interview-preparation/blob/main/Spring.md#spring-mvc) (Representational State Transfer) is an architectural style used to design backend APIs that are scalable, stateless, and predictable
- A REST API treats everything as a resource and uses standard HTTP methods to operate on those resources
- Routing is the mechanism by which a backend maps an incoming HTTP request (method + URL path) to a specific handler (server-side logic)
- URLs represent nouns, HTTP methods represent actions:
  - POST   /api/chat
  - GET    /api/chats
  - GET    /api/chats/{id}
  - DELETE   /api/chats/{id}
  - PUT   /api/chats/{id}
  - PATCH   /api/chats/{id}
- Pagination, sorting, and filtering apply to collection-based GET APIs, not command-style endpoints

### What is Pagination?

**Pagination splits a large dataset into smaller chunks (pages) to:**
- reduce payload size
- protect database and memory
- improve response time

**Common Parameters:**
- page → page number (0-based)
- size → number of records per page

**Backend Responsibility:**
- Enforce limits
- Translate page/size into DB queries
- Return metadata (total pages, total elements)

### What is Sorting?

**Sorting defines order of returned records:**
- sort=field,asc
- sort=field,desc

**Backend Responsibility:**
- Validate sortable fields
- Apply ordering at DB level (not in memory)

### What is Filtering & Validation?

**Filtering restricts results based on conditions:**
- Never trust client filters blindly
- Apply filters in repository/query layer

