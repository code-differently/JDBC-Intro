# JDBC: Query the Database

Querying a database means searching through its data. You do so be sending SQL statements to the database. To do so, you first need an open database connection. Once you have an open connection, you need to create a Statement object, like this:

```
Statement statement = connection.createStatement();
```

Once you have created the Statement you can use it to execute SQL queries, like this:

```
String sql = "select * from People";
```

ResultSet result = statement.executeQuery(sql);
When you execute an SQL query you get back a ResultSet. The ResultSet contains the result of your SQL query. The result is returned in rows with columns of data. You iterate the rows of the ResultSet like this:

```
while(result.next()) {

    String firstName = result.getString("first_name");
    String lastname  = result.getString("last_name");

}
```

The ResultSet.next() method moves to the next row in the ResultSet, if there are anymore rows. If there are anymore rows, it returns true. If there were no more rows, it will return false.

You need to call next() at least one time before you can read any data. Before the first next() call the ResultSet is positioned before the first row.

You can get column data for the current row by calling some of the getXXX() methods, where XXX is a primitive data type. For instance:

```
result.getString    ("columnName");
result.getLong      ("columnName");
result.getInt       ("columnName");
result.getDouble    ("columnName");
result.getBigDecimal("columnName");
etc.
```

The column name to get the value of is passed as parameter to any of these getXXX() method calls.

You can also pass an index of the column instead, like this:

```
result.getString    (1);
result.getLong      (2);
result.getInt       (3);
result.getDouble    (4);
result.getBigDecimal(5);
etc.
```

For that to work you need to know what index a given column has in the ResultSet. You can get the index of a given column by calling the ResultSet.findColumn() method, like this:

```
int columnIndex = result.findColumn("columnName");
```
    
If iterating large amounts of rows, referencing the columns by their index might be faster than by their name.

When you are done iterating the ResultSet you need to close both the ResultSet and the Statement object that created it (if you are done with it, that is). You do so by calling their close() methods, like this:

```
result.close();
statement.close();
```

Of course you should call these mehtods inside a finally block to make sure that they are called even if an exception occurs during ResultSet iteration.

Full Example
Here is a full query code example:

```
Statement statement = connection.createStatement();

String sql = "select * from People";

ResultSet result = statement.executeQuery(sql);

while(result.next()) {

    String firstName = result.getString("first_name");
    String lastname  = result.getString("last_name");

    System.out.println(firstName);
    System.out.println(lastname);
}

result.close();
statement.close();
```

And here the example is again, with try-finally blocks added. Notice, I have left out the catch blocks to make the example shorter.

```
Statement statement = null;

try{
statement = connection.createStatement();
ResultSet result    = null;
try{
String sql = "select * from People";
ResultSet result = statement.executeQuery(sql);

        while(result.next()) {

            String firstName = result.getString("first_name");
            String lastname  = result.getString("last_name");

            System.out.println(firstName);
            System.out.println(lastname);
        }
    } finally {
        if(result != null) result.close();
    }
} finally {
if(statement != null) statement.close();
}
```
