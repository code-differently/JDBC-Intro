# SQL Commands

## The SQL CREATE DATABASE Statement

The CREATE DATABASE statement is used to create a new SQL database.

```
CREATE DATABASE databasename;
```

## CREATE DATABASE Example

The following SQL statement creates a database called "testDB":

```
CREATE DATABASE myFirstDb;
```

## CREATE TABLE

The CREATE TABLE statement is used to create a new table in a database.

Syntax

```
CREATE TABLE table_name (
    column1 datatype,
    column2 datatype,
    column3 datatype,
   ....
);
```

The column parameters specify the names of the columns of the table.

The datatype parameter specifies the type of data the column can hold (e.g. varchar, integer, date, etc.).

## SQL CREATE TABLE Example

```
CREATE TABLE People (
    id int NOT NULL AUTO_INCREMENT,
    last_name varchar(255),
    first_name varchar(255),
    address varchar(255),
    city varchar(255),
    PRIMARY KEY (id),
);
```

## SQL Insertion example

```
INSERT INTO People (last_name, first_name) VALUES ('Tariq', 'Hook');
```


| Previous                     | Current     | Next                                              |
|------------------------------|-------------|---------------------------------------------------|
| [Connections](04-SQL-Connection.md)| Connections | [Querying the database](06-Query-the-Database.md) |
