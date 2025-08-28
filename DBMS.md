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

 - **Relationship**: A relationship is an association among several entities. A relationship between two entities of the same entity set is called a recursive relationship.
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

### 1. Constraints
Constraints are rules enforced on data in a database to ensure accuracy and integrity.
 - **Domain Constraint**: Restricts the type of data (e.g., age must be an integer).
 - **Entity Integrity**: Primary key must be unique and not null.
 - **Referential Integrity**: Foreign key must match a primary key in another table or be null.
 - **Key Constraint**: No two rows can have the same value for a primary key.
 - **Tuple Uniqueness**: Specifies that all the tuples must be necessarily unique in any relation.

### 2. Relational Algebra 
Relational Algebra operations take one or more relations as input and produce a new relation as output.
 - **Select (σ)**: Filters rows. E.g., σ_salary>50000(Employees) → SELECT * FROM Employees WHERE salary > 50000;.
 - **Project (π)**: Selects columns, removes duplicates. E.g., π_name,age(Employees) → SELECT DISTINCT name, age FROM Employees;.
 - **Union (∪)**: Combines, removes duplicates. E.g., Employees ∪ Contractors → SELECT * FROM Employees UNION SELECT * FROM Contractors;.
 - **Difference (−)**: Rows in one, not other. E.g., Employees − Retired → SELECT * FROM Employees EXCEPT SELECT * FROM Retired;.
 - **Cartesian Product (×)**: All pairs. E.g., Employees × Departments → SELECT * FROM Employees CROSS JOIN Departments;.
 - **Rename (ρ)**: Renames table/attributes. E.g., ρ_Staff(Employees) → AS Staff in SQL.
 - **Intersection (∩)**: Common rows. E.g., Employees ∩ Managers → SELECT * FROM Employees INTERSECT SELECT * FROM Managers;.
 - **Division (÷)**: Values paired with all in another relation. E.g., π_student(Courses_Taken) ÷ π_course(Required_Courses) → Students completing all required courses.

### 3. Normalization
It is the process of organizing data in a database to reduce redundancy and improve data integrity. It involves dividing large tables into smaller tables and defining relationships among them.

 - **First Normal Form (1NF)**: Each table cell contains a single value (atomicity). No repeating groups or arrays.
 - **Second Normal Form (2NF)**: In 1NF + Every non-key attribute is fully functionally dependent on the PRIMARY KEY (no partial dependency).
 - **Third Normal Form (3NF)**: In 2NF + No transitive dependency: Non-key attributes do not depend on other non-key attributes.
 - **Boyce-Codd Normal Form (BCNF)**: In 3NF + For every non-trivial functional dependency, the left side is a super key.

### 4. Denormalization
 - Sometimes, for performance reasons (faster reads), tables are merged back together, partially reversing normalization.
---

## Structured Query Language (SQL)

### 1. SQL Data Types

#### **i. Numeric Types**

  | Data Type | Description                                     |
  | --------- | ----------------------------------------------- |
  | `BIT`     | Bit-field (binary values; often used for flags) |
  | `INT`     | Integer number                                  |
  | `FLOAT`   | Approximate decimal number (floating point)     |
  | `DECIMAL` | Fixed precision decimal (useful for money)      |

#### **ii. String (Character/Text) Types**

  | Data Type | Description                                            |
  | --------- | ------------------------------------------------------ |
  | `CHAR`    | Fixed-length string (e.g., `CHAR(10)`)                 |
  | `VARCHAR` | Variable-length string (e.g., `VARCHAR(255)`)          |
  | `TEXT`    | Large text block (used for long strings or paragraphs) |

#### **iii. Enumerated/Set Types**

  | Data Type | Description                                                                    |
  | --------- | ------------------------------------------------------------------------------ |
  | `ENUM`    | One value from a predefined list (e.g., `ENUM('small','medium','large')`)      |
  | `SET`     | Multiple values from a predefined list (e.g., `SET('A','B','C')`) – MySQL only |

#### **iv. Date & Time Types**

  | Data Type   | Description                                   |
  | ----------- | --------------------------------------------- |
  | `DATE`      | Date only (YYYY-MM-DD)                        |
  | `TIME`      | Time only (HH\:MM\:SS)                        |
  | `YEAR`      | Year only (e.g., 2025) – MySQL-specific       |
  | `DATETIME`  | Date and time (no time zone)                  |
  | `TIMESTAMP` | Date and time (may include time zone support) |

---

### 2. SQL commands

#### **i. Data Definition Language (DDL)** – *Define or modify structure*

| Command    | Description                   | Example                          |
| ---------- | ----------------------------- | -------------------------------- |
| `CREATE`   | Create database/table/index   | `CREATE TABLE users (name CHAR(10) NOT NULL);`      |
| `ALTER`    | Modify existing schema        | `ALTER TABLE users ADD age INT;`, `ALTER TABLE users MODIFY name VARCHAR(10);` |
| `DROP`     | Delete database/table/index   | `DROP TABLE users;`              |
| `TRUNCATE` | Delete all data (reset table) | `TRUNCATE TABLE orders;`         |

---

#### **ii. Data Manipulation Language (DML)** – *Manage data records*

| Command  | Description          | Example                                                               |
| -------- | -------------------- | --------------------------------------------------------------------- |
| `INSERT` | Add new data         | `INSERT INTO users (name, email) VALUES ('Alice', 'a@example.com');`  |
| `UPDATE` | Modify existing data | `UPDATE users SET is_active = FALSE WHERE last_login < '2024-01-01';` |
| `DELETE` | Remove data          | `DELETE FROM users WHERE is_active = FALSE;`                          |

#### **iii. Data Control Language (DCL)** – *Manage access*

| Command  | Description       | Example                                    |
| -------- | ----------------- | ------------------------------------------ |
| `GRANT`  | Give privileges   | `GRANT SELECT ON employees TO analyst;`    |
| `REVOKE` | Remove privileges | `REVOKE SELECT ON employees FROM analyst;` |

#### **iv. Transaction Control Language (TCL)** – *Control transactions*

| Command                       | Description              | Example          |
| ----------------------------- | ------------------------ | ---------------- |
| `BEGIN` / `START TRANSACTION` | Start a transaction      | `BEGIN;`         |
| `COMMIT`                      | Save changes             | `COMMIT;`        |
| `ROLLBACK`                    | Undo changes             | `ROLLBACK;`      |
| `SAVEPOINT`                   | Set a point for rollback | `SAVEPOINT sp1;` |

#### **v. Data Query Language (DQL)** – *Retrieve data*

| Command  | Description                        | Example                                            |
| -------- | ---------------------------------- | -------------------------------------------------- |
| `SELECT` | Fetch data from one or more tables | `SELECT name FROM employees WHERE salary > 50000;` |

---

### 3. SQL Operators

#### **i. Comparison Operators**

| Operator      | Description                | Example                        |
| ------------- | -------------------------- | ------------------------------ |
| `BETWEEN`     | Within a range (inclusive) | `age BETWEEN 18 AND 25`        |
| `IN`          | Matches a list of values   | `country IN ('India', 'USA')`  |
| `NOT IN`      | Not in a list              | `country NOT IN ('UK', 'USA')` |
| `IS NULL`     | Is NULL                    | `email IS NULL`                |
| `IS NOT NULL` | Is not NULL                | `email IS NOT NULL`            |
| `LIKE`        | Pattern match              | `name LIKE 'A%'`               |
| `NOT LIKE`    | Not matching pattern       | `name NOT LIKE '%son'`         |

#### **ii. Logical Operators**

| Operator | Description                    | Example                           |
| -------- | ------------------------------ | --------------------------------- |
| `AND`    | All conditions must be true    | `age > 18 AND is_active = TRUE`   |
| `OR`     | At least one condition is true | `role = 'admin' OR is_vip = TRUE` |
| `NOT`    | Reverses condition             | `NOT is_active`                   |

#### **iii. Set Operators** *(combine query results)*

| Operator           | Description                                | Example                                                    |
| ------------------ | ------------------------------------------ | ---------------------------------------------------------- |
| `UNION`            | Combine and remove duplicates              | `SELECT city FROM users UNION SELECT city FROM employees;` |
| `UNION ALL`        | Combine and keep duplicates                | `... UNION ALL ...`                                        |
| `EXCEPT` / `MINUS` | Return rows from first query not in second | `SELECT ... EXCEPT SELECT ...`                             |

#### **iv. Special Operators**

| Operator | Description                          | Example                                                    |
| -------- | ------------------------------------ | ---------------------------------------------------------- |
| `EXISTS` | Checks if subquery returns rows      | `WHERE EXISTS (SELECT 1 FROM orders WHERE user_id = u.id)` |
| `ANY`/`SOME`    | Compares to any value from subquery  | `price > ANY (SELECT price FROM products)`          |
| `ALL`    | Compares to all values from subquery | `price < ALL (SELECT price FROM discounts)`                |

---

### 4. [SQL Joins](https://dk81.github.io/dkmathstats_site/set-theory-sql.html)

### 5. Conditional Statement
 - **Syntax**:
   ```sql
   CASE
       WHEN condition1 THEN result1
       WHEN condition2 THEN result2
       ...
       ELSE default_result
   END
   ```
   
 - | Use Case               | Example Use                                   |
   | ---------------------- | --------------------------------------------- |
   | Select computed column | `SELECT CASE WHEN ... THEN ... END`           |
   | Conditional filter     | `WHERE col = CASE WHEN ... THEN ... END`      |
   | Custom sort order      | `ORDER BY CASE WHEN ... THEN ... END`         |
   | Conditional update     | `UPDATE SET col = CASE WHEN ... THEN ... END` |

 - **Example**:
   ```sql
   SELECT 
     department, 
     COUNT(*) AS employee_count, 
     AVG(salary) AS avg_salary,
     CASE 
       WHEN AVG(salary) > 80000 THEN 'High Paying'
       WHEN AVG(salary) BETWEEN 65000 AND 80000 THEN 'Medium Paying'
       ELSE 'Low Paying'
     END AS salary_category
   FROM employees
   WHERE salary > 50000
   GROUP BY department
   HAVING COUNT(*) >= 5
   ORDER BY avg_salary DESC;
   ```
---

## [SQL Practice](https://leetcode.com/studyplan/top-sql-50/)
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
   BEGIN TRY
     BEGIN TRANSACTION;
     UPDATE accounts SET balance = balance - 1000 WHERE id = 'A';
     IF (SELECT balance FROM accounts WHERE id = 'A') < 0 THROW 50001, 'Insufficient funds', 1;
     UPDATE accounts SET balance = balance + 1000 WHERE id = 'B';
     COMMIT;
   END TRY
   BEGIN CATCH
     ROLLBACK;
     PRINT ERROR_MESSAGE();
   END CATCH;
   ```
---

## Indexing

**Indexing** is a technique to speed up data retrieval operations in a database at the cost of extra space and slower writes.

### **What is an Index?**
- An index is a data structure (often a B-Tree or Hash) that allows quick lookup of rows in a table by one or more columns.

### **Types of Indexes**

- **Primary Index**: Automatically created on the primary key.
- **Unique Index**: Ensures all values in the indexed column are unique.
- **Composite Index**: Index on multiple columns.
- **Clustered Index**: Alters the table's physical storage order to match the index.
- **Non-Clustered Index**: Separate from the table’s storage, contains pointers to data rows.
- **Full-text Index**: Used for efficient text searches.

### **Advantages**
- Faster SELECT queries, especially with WHERE, JOIN, ORDER BY, and GROUP BY clauses.

### **Disadvantages**
- Slower INSERT, UPDATE, DELETE operations (index needs to be updated).
- Takes up extra disk space.

### **Index Creation Example**
```sql
CREATE INDEX idx_employee_name ON employees(name);
```
- Use indexes on columns frequently searched, joined, or sorted.

### **How Indexing Works**
- The DBMS uses the index to locate rows quickly instead of scanning the entire table.
- Similar to an index in a book: it directs you to the right page without reading the whole book.

### **Index Maintenance**
- Regularly review and drop unused indexes to optimize performance.

---
