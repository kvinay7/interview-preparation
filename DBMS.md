<h1 align="center">Database Management System</h1>

## Data and Information
 - **Data**: Raw, unorganized facts that by themselves may have no meaning. Data becomes meaningful only when processed.
 - **Information**: Processed data that is meaningful and useful for decision-making.

**Example**: Consider the string “orange”. Here, it could mean a color or a fruit. This term “orange” is data. However, if we say “color orange” or “fruit orange”, it becomes information.

## Database
A structured collection of related data that can be easily accessed, managed, and updated.
- Example: A table of students with fields like ID, Name, Marks.
- Characteristics:
  - Organized using tables
  - Supports relationships between entities
  - Supports queries and transactions

## File System
A system used by OS to store and organize files on storage devices.
- Example: Storing student records in a .txt or .csv file
- Characteristics:
  - Manual data management (no SQL, no automatic indexing)
  - Poor support for relationships between data
  - More prone to data redundancy, inconsistency, integrity and security issues

## DBMS (Database Management System)
Software used to manage databases by providing an interface for data insertion, deletion, updating, and retrieval. Database management systems were developed to handle the difficulties of typical File-processing systems supported by conventional operating systems.
 - Examples: MySQL, PostgreSQL, Oracle, MongoDB
 - Features:
   - Data abstraction
   - Querying with SQL
   - Transaction management (ACID)
   - Concurrency control
   - Backup and recovery
 
 - 3-tier architecture:
   - Presentation Layer - Handles the user interface
   - Application Layer - Manages business logic
   - Data Layer - Manages data storage and processing

---

## ER Model

It is a logical tool which is used for database schema design.
 
 - **Entity**: An object or concept that can be distinctly identified in the real world.
 
 - **Entity Set**: A collection of similar types of entities.
   - **Strong Entity Set**: contains sufficient attributes (primary key) to uniquely identify all its entities.
   - **Weak Entity Set**: not contain sufficient attributes to uniquely identify its entities. Its existence is dependent on other strong entity sets.

 - **Attributes**: Properties of an entity.
   - **Simple**: Cannot be divided further (e.g., Age)
   - **Composite**: Made of sub-parts (e.g., Name → FirstName, LastName)
   - **Derived**: Can be calculated from other attributes (e.g., Age from DOB)
   - **Multivalued**: Can have multiple values (e.g., PhoneNumbers)

 - **Relationship**: A relationship is an association among several entities.
   - **Unary Relationship Set**: is a relationship set where only one entity set participates in a relationship set.
   - **Binary Relationship Set**: is a relationship set where two entity sets participate in a relationship set.
   - **Ternary Relationship Set**: is a relationship set where three entity sets participate in a relationship set.
   - **N-ary Relationship Set**: is a relationship set where ‘n’ entity sets participate in a relationship set.
 
 - **Participation**:
   - **Total** : Every entity must participate in the relationship
   - **Partial** : Some entities participate

 - **Keys**: A key is a set of attributes that can identify each tuple uniquely in the given relation.
   - **Super Key**: is a set of attributes that can identify each tuple uniquely in the given relation. It may consist of any no.of attributes.
   - **Candidate Key**: A set of minimal attribute(s) that can identify each tuple uniquely in the given relation is called a candidate key.
   - **Primary Key**: is a candidate key that the database designer selects while designing the database. It is unique and NOT NULL.
   - **Alternate Key**: Candidate keys that are left unimplemented or unused after implementing the primary key are called as alternate keys.
   - **Composite Key**: A primary key composed of multiple attributes and not just a single attribute is called a composite key.
   - **Unique Key**: It is unique for all the records of the table. Once assigned, its value cannot be changed. It may have a NULL value.
   - **Foreign Key**: An attribute ‘X’ is called as a foreign key to some other attribute ‘Y’ when its values are dependent on the values of attribute ‘Y’. The relation in which attribute ‘Y’ is present is called as the referenced relation. The relation in which attribute ‘X’ is present is called as the referencing relation.

---

## Relational Model
A relation is basically a table in a relational database.
 - **Rows**: Tuples (each row represents a record)
 - **Columns**: Attributes (each column represents a field)
 - **Schema**: The structure or definition of the database. E.g., STUDENT(ID int, Name varchar, Age int)
 - **Instance**: The actual data stored at a given time (i.e., the rows).
 - **Degree**: Number of attributes (columns) in a relation.
 - **Cardinality**: Number of tuples (rows) in a relation.

## Constraints
Constraints are rules enforced on data in a database to ensure accuracy and integrity.
 - **Domain Constraint**: Restricts the type of data (e.g., age must be an integer).
 - **Entity Integrity**: Primary key must be unique and not null.
 - **Referential Integrity**: Foreign key must match a primary key in another table or be null.
 - **Key Constraint**: No two rows can have the same value for a primary key.
 - **Tuple Uniqueness**: Specifies that all the tuples must be necessarily unique in any relation.

---

## SQL & NoSQL

## Caching & Indexing

## [Database Design](https://blog.algomaster.io/i/142880142/step-database-design)

---

## Transactions & Concurrency Control
### 1. ACID Properties
In SQL and database systems, **ACID** is a set of properties that ensure reliable processing of database transactions. The acronym stands for:
 - **Atomicity**: A transaction (sequence of operations) is treated as a single, indivisible unit, which either **completes entirely** or **does not happen at all**.
   - **Example**: If you're transferring money from Account A to Account B, both the debit and credit must succeed. If one fails, the entire transaction is rolled back.

 - **Consistency**: A transaction must bring the database from one valid state to another, maintaining all **data integrity constraints**.
   - **Example**: If a column is defined as `NOT NULL`, a transaction inserting a `NULL` value will fail and preserve consistency.

 - **Isolation**: Concurrent transactions should not interfere with each other. The outcome should be the same as if the transactions were executed **sequentially**.

   - **Concurrency Issues**:
     - Lost Update: One transaction overwrites another’s changes.
     - Dirty Read: Reading uncommitted data.
     - Non-Repeatable Read: Inconsistent reads within a transaction.
     - Phantom Read: New rows appear in subsequent queries.

   - Concurrent transactions controlled using **isolation levels** like:
     - **`READ UNCOMMITTED`**: Allows all transactions.
     - **`READ COMMITTED`**: Prevents only dirty reads.
     - **`REPEATABLE READ`**: Allows only phantom reads.
     - **`SERIALIZABLE`**: Ensures complete isolation but may reduce concurrency.

   - Lower isolation: better performance, but more risk of inconsistent data. Higher isolation: safer data, but more locking and slower performance.

 - **Durability**: Once a transaction is committed, the changes are **permanent**, even in the case of a system crash.
   - **SQL Mechanism**: Ensured by the database engine using **write-ahead logs** and **disk flushing**.

---

### 2. lifecycle of a database transaction
 - **Begin Transaction**
   - The system starts a new transaction.
   - SQL: `BEGIN TRANSACTION;` or `START TRANSACTION;`
 
 - **Execute Operations**
   - The transaction performs one or more operations like `INSERT`, `UPDATE`, `DELETE`, or `SELECT`.
   - These changes are **not yet permanent**.

 - **Write-Ahead Logging (WAL)**
   - Before applying changes to the database, the system logs the operations to a **transaction log**.
   - Ensures recovery in case of failure.

 - **Validation / Constraint Checking**
   - The system checks for **data integrity**, **constraints**, and **consistency**.
   - If any rule is violated, the transaction is **rolled back**.

 - **Commit or Rollback**
   - If all operations succeed:
     - SQL: `COMMIT;` → Changes are **permanently saved**.
   - If any operation fails:
     - SQL: `ROLLBACK;` → All changes are **undone**.

 - **Disk Flushing**
   - The committed data is **flushed to disk** to ensure **durability**.
  
 - **Example**
   ```sql
   BEGIN TRANSACTION;

   BEGIN TRY
      -- Step 1: Deduct ₹1000 from Account A
      UPDATE accounts
      SET balance = balance - 1000
      WHERE account_id = 'A';

      -- Optional: Check if balance is negative
      IF EXISTS (
          SELECT 1 FROM accounts WHERE account_id = 'A' AND balance < 0
      )
      BEGIN
          THROW 50001, 'Insufficient funds in Account A.', 1;
      END

      -- Step 2: Add ₹1000 to Account B
      UPDATE accounts
      SET balance = balance + 1000
      WHERE account_id = 'B';

      -- Step 3: Commit the transaction
      COMMIT;
   END TRY
   BEGIN CATCH
      -- If any error occurs, rollback the transaction
      ROLLBACK;

      -- Optional: Print the error
      PRINT ERROR_MESSAGE();
   END CATCH;
   ```    
---
