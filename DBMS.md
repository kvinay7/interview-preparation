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

## Relational Model
A relation is basically a table in a relational database.
 - **Rows**: Tuples (each row represents a record)
 - **Columns**: Attributes (each column represents a field)
 - **Schema**: The structure or definition of the database. E.g., STUDENT(ID int, Name varchar, Age int)
 - **Instance**: The actual data stored at a given time (i.e., the rows).
 - **Degree**: Number of attributes (columns) in a relation.
 - **Cardinality**: Number of tuples (rows) in a relation.

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
