# JDBC - Result Sets

The SQL statements that read data from a database query, return the data in a result set. The SELECT statement is the standard way to select rows from a database and view them in a result set. The java.sql.ResultSet interface represents the result set of a database query.

A ResultSet object maintains a cursor that points to the current row in the result set. The term "result set" refers to the row and column data contained in a ResultSet object.

The methods of the ResultSet interface can be broken down into three categories −

* Navigational methods − Used to move the cursor around. 
* Get methods − Used to view the data in the columns of the current row being pointed by the cursor. 
* Update methods − Used to update the data in the columns of the current row. The updates can then be updated in the underlying database as well.

The cursor is movable based on the properties of the ResultSet. These properties are designated when the corresponding Statement that generates the ResultSet is created.

JDBC provides the following connection methods to create statements with desired ResultSet −

* createStatement(int RSType, int RSConcurrency);
* prepareStatement(String SQL, int RSType, int RSConcurrency); 
* prepareCall(String sql, int RSType, int RSConcurrency);

The first argument indicates the type of a ResultSet object and the second argument is one of two ResultSet constants for specifying whether a result set is read-only or updatable.

## Type of ResultSet

The possible RSType are given below. If you do not specify any ResultSet type, you will automatically get one that is TYPE_FORWARD_ONLY.

| Type	 | Description |
| -----  | ----------- |
| ResultSet.TYPE_FORWARD_ONLY| The cursor can only move forward in the result set. |
| ResultSet.TYPE_SCROLL_INSENSITIVE |	The cursor can scroll forward and backward, and the result set is not sensitive to changes made by others to the database that occur after the result set was created.|
| ResultSet.TYPE_SCROLL_SENSITIVE.	| The cursor can scroll forward and backward, and the result set is sensitive to changes made by others to the database that occur after the result set was created. |

## Navigating a Result Set

There are several methods in the ResultSet interface that involve moving the cursor, including −

| S.N. | Methods | Description           |
| ---- |---------|-----------------------|
| 1	| public void beforeFirst() throws SQLException| Moves the cursor just before the first row. |
|2	| public void afterLast() throws SQLException | Moves the cursor just after the last row.|
| 3	 |public boolean first() throws SQLException |Moves the cursor to the first row. |
| 4 |	public void last() throws SQLException |Moves the cursor to the last row. |
| 5 |	public boolean absolute(int row) throws SQLException | Moves the cursor to the specified row.|
|6	| public boolean relative(int row) throws SQLException | Moves the cursor the given number of rows forward or backward, from where it is currently pointing.|
| 7|	public boolean previous() throws SQLException | Moves the cursor to the previous row. This method returns false if the previous row is off the result set.|
| 8 |	public boolean next() throws SQLException | Moves the cursor to the next row. This method returns false if there are no more rows in the result set.|
| 9 |	public int getRow() throws SQLException | Returns the row number that the cursor is pointing to.|
| 10 |	public void moveToInsertRow() throws SQLException | Moves the cursor to a special row in the result set that can be used to insert a new row into the database. The current cursor location is remembered.|
| 11 |	public void moveToCurrentRow() throws SQLException |Moves the cursor back to the current row if the cursor is currently at the insert row; otherwise, this method does nothing|