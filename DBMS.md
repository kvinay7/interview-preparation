<h1 align="center">Database Management System</h1>

## Data and Information
 - **Data**: Raw, unorganized facts that by themselves may have no meaning. Data becomes meaningful only when processed.
 - **Information**: Processed data that is meaningful and useful for decision-making.
 - **Example**: Consider the string “orange”. Here, it could mean a color or a fruit. This term “orange” is data. However, if we say “color orange” or “fruit orange”, it becomes information.

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

