# SQL CRUD

**S**tructured **Q**uery **L**anguage (SQL) is a standardized language that allows you to perform operations on a database, such as creating entries, reading content, updating content, and deleting entries.

SQL is supported by almost any database you will likely use, and it allows you to write database code independently of the underlying database.

This chapter gives an overview of SQL, which is a prerequisite to understand JDBC concepts. After going through this chapter, you will be able to: 

* Create
* Read
* Update
* Delete 

Often referred to as **CRUD** operations) data from a database.

# Databases

## Create Database
The CREATE DATABASE statement is used for creating a new database. The syntax is −

```
CREATE DATABASE DATABASE_NAME;
```

#### Example 

```
CREATE DATABASE EMP;
```

## Drop Database

The DROP DATABASE statement is used for deleting an existing database. The syntax is −

```
DROP DATABASE DATABASE_NAME;
```

Note − To create or drop a database you should have administrator privilege on your database server. Be careful, deleting a database would loss all the data stored in the database.

#Tables

## Create Table
The CREATE TABLE statement is used for creating a new table. The syntax is −

```
CREATE TABLE table_name
(
	column_name column_data_type,
	column_name column_data_type,
	column_name column_data_type
	...
);
```

### Example

The following SQL statement creates a table named Employees with four columns −

```
CREATE TABLE Employees
(
   id INT NOT NULL,
   age INT NOT NULL,
   first VARCHAR(255),
   last VARCHAR(255),
   PRIMARY KEY ( id )
);
```

## Drop Table

The DROP TABLE statement is used for deleting an existing table. The syntax is −

```
DROP TABLE table_name;
```

### Example

The following SQL statement deletes a table named Employees −

```
DROP TABLE Employees;
```

## INSERT Data

The syntax for INSERT, looks similar to the following, where column1, column2, and so on represents the new data to appear in the respective columns −

```
INSERT INTO table_name VALUES (column1, column2, ...);
```

### Example

The following SQL INSERT statement inserts a new row in the Employees database created earlier:

```
INSERT INTO Employees VALUES (100, 18, 'Zara', 'Ali');
```

## SELECT Data

The SELECT statement is used to retrieve data from a database. The syntax for SELECT is −

```
SELECT column_name, column_name, ...
FROM table_name
WHERE conditions;
```

The WHERE clause can use the comparison operators such as =, !=, <, >, <=,and >=, as well as the BETWEEN and LIKE operators.

### Example

The following SQL statement selects the age, first and last columns from the Employees table, where id column is 100 −

```
SELECT first, last, age 
FROM Employees 
WHERE id = 100;
```

The following SQL statement selects the age, first and last columns from the Employees table where first column contains Zara −

```
SELECT first, last, age 
FROM Employees 
WHERE first LIKE '%Zara%';
```

## UPDATE Data

The UPDATE statement is used to update data. The syntax for UPDATE is −


```
UPDATE table_name
SET column_name = value, column_name = value, ...
WHERE conditions;
```

The WHERE clause can use the comparison operators such as =, !=, <, >, <=,and >=, as well as the BETWEEN and LIKE operators.

### Example

The following SQL UPDATE statement changes the age column of the employee whose id is 100 −

```
UPDATE Employees SET age=20 WHERE id=100;
```

## DELETE Data

The DELETE statement is used to delete data from tables. The syntax for DELETE is −

```
DELETE FROM table_name WHERE conditions;
```

The WHERE clause can use the comparison operators such as =, !=, <, >, <=,and >=, as well as the BETWEEN and LIKE operators.

### Example

The following SQL DELETE statement deletes the record of the employee whose id is 100 −

```
DELETE FROM Employees WHERE id=100;
```


| Previous                     | Current | Next                         |
|------------------------------| ------- |------------------------------|
| [Docker Setup](01-Docker.md) | Sql and Crud |  |