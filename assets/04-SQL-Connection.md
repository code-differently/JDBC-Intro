# JDBC - Database Connections

After you've installed the appropriate driver, it is time to establish a database connection using JDBC.

The programming involved to establish a JDBC connection is fairly simple. Here are these simple four steps −

* Import JDBC Packages − Add import statements to your Java program to import required classes in your Java code. 
* Register JDBC Driver − This step causes the JVM to load the desired driver implementation into memory so it can fulfill your JDBC requests. 
* Database URL Formulation − This is to create a properly formatted address that points to the database to which you wish to connect. 
* Create Connection Object − Finally, code a call to the DriverManager object's getConnection( ) method to establish actual database connection.

##  Import JDBC Packages

The Import statements tell the Java compiler where to find the classes you reference in your code and are placed at the very beginning of your source code.

To use the standard JDBC package, which allows you to select, insert, update, and delete data in SQL tables, add the following imports to your source code −

```
import java.sql.* ;  // for standard JDBC programs
import java.math.* ; // for BigDecimal and BigInteger support
```

## Register JDBC Driver

You must register the driver in your program before you use it. Registering the driver is the process by which the Oracle driver's class file is loaded into the memory, so it can be utilized as an implementation of the JDBC interfaces.

You need to do this registration only once in your program. You can register a driver in one of two ways.

## Approach I - Class.forName()

The most common approach to register a driver is to use Java's Class.forName() method, to dynamically load the driver's class file into memory, which automatically registers it. This method is preferable because it allows you to make the driver registration configurable and portable.

The following example uses Class.forName( ) to register the Oracle driver −

```
try {
   Class.forName("oracle.jdbc.driver.OracleDriver");
}
catch(ClassNotFoundException ex) {
   System.out.println("Error: unable to load driver class!");
   System.exit(1);
}
```

You can use getInstance() method to work around noncompliant JVMs, but then you'll have to code for two extra Exceptions as follows −

```
try {
   Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
}
catch(ClassNotFoundException ex) {
   System.out.println("Error: unable to load driver class!");
   System.exit(1);
catch(IllegalAccessException ex) {
   System.out.println("Error: access problem while loading!");
   System.exit(2);
catch(InstantiationException ex) {
   System.out.println("Error: unable to instantiate driver!");
   System.exit(3);
}
```

## Approach II - DriverManager.registerDriver()

The second approach you can use to register a driver, is to use the static DriverManager.registerDriver() method.

You should use the registerDriver() method if you are using a non-JDK compliant JVM, such as the one provided by Microsoft.

The following example uses registerDriver() to register the Oracle driver −

```
try {
   Driver myDriver = new oracle.jdbc.driver.OracleDriver();
   DriverManager.registerDriver( myDriver );
}
catch(ClassNotFoundException ex) {
   System.out.println("Error: unable to load driver class!");
   System.exit(1);
}
```

## Database URL Formulation

After you've loaded the driver, you can establish a connection using the DriverManager.getConnection() method. For easy reference, let me list the three overloaded DriverManager.getConnection() methods −

* getConnection(String url)
* getConnection(String url, Properties prop)
* getConnection(String url, String user, String password)

Here each form requires a database URL. A database URL is an address that points to your database.

Formulating a database URL is where most of the problems associated with establishing a connection occurs.

Following table lists down the popular JDBC driver names and database URL.


| RDBMS | JDBC driver name | URL format                                              |
| ----- | ---------------- |---------------------------------------------------------|
|MySQL	|com.mysql.jdbc.Driver | 	**jdbc:mysql:**//hostname/ databaseName                |
|ORACLE |	oracle.jdbc.driver.OracleDriver	| **jdbc:oracle:**thin:@hostname:port Number:databaseName |
|  H2   |org.h2.Driver | **jdbc:h2:**~/test                                      |

All the highlighted part in URL format is static and you need to change only the remaining part as per your database setup.

## Create Connection Object

We have listed down three forms of DriverManager.getConnection() method to create a connection object.

## Using a Database URL with a username and password

The most commonly used form of getConnection() requires you to pass a database URL, a username, and a password −

Assuming you are using Oracle's thin driver, you'll specify a host:port:databaseName value for the database portion of the URL.

If you have a host at TCP/IP address 192.0.0.1 with a host name of amrood, and your Oracle listener is configured to listen on port 1521, and your database name is EMP, then complete database URL would be −

```
jdbc:mysql://localhost:3306/sampledatabase
```

Now you have to call getConnection() method with appropriate username and password to get a Connection object as follows −

```
String URL = "jdbc:mysql://localhost:3306/sampledatabase";
String USER = "username";
String PASS = "password"
Connection conn = DriverManager.getConnection(URL, USER, PASS);
```

## Closing JDBC Connections

At the end of your JDBC program, it is required explicitly to close all the connections to the database to end each database session. However, if you forget, Java's garbage collector will close the connection when it cleans up stale objects.

Relying on the garbage collection, especially in database programming, is a very poor programming practice. You should make a habit of always closing the connection with the close() method associated with connection object.

To ensure that a connection is closed, you could provide a 'finally' block in your code. A finally block always executes, regardless of an exception occurs or not.

To close the above opened connection, you should call close() method as follows −

```
conn.close();
```

Explicitly closing a connection conserves DBMS resources, which will make your database administrator happy.

## Full example
```
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCExample {
    static final String DB_URL = "jdbc:mysql://localhost:3306/sampledatabase;
    static final String USER = "root";
    static final String PASS = "tdd-cd";

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("Connecting to a selected database...");

        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
            System.out.println("Connected database successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```


| Previous                     | Current     | Next                                              |
|------------------------------|-------------|---------------------------------------------------|
| [Drivers](03-SQL-DRIVERS.md) | Connections | [Querying the database](06-Query-the-Database.md) |
