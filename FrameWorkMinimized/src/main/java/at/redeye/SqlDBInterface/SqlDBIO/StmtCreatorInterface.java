package at.redeye.SqlDBInterface.SqlDBIO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import at.redeye.SqlDBInterface.SqlDBIO.impl.ColumnAttribute;
import at.redeye.SqlDBInterface.SqlDBIO.impl.TableBindingNotRegisteredException;

/**
 *
 * @author Mario Mattl
 *
 */
public interface StmtCreatorInterface {

	/**
	 *
	 * @param tablenames
	 *            The tables names
	 * @param whereStmt
	 *            Statement to identify the affected rows. It also has to
	 *            contain join-clauses, <br>
	 *            if more than one table is being selected.
	 * @param columnNames
	 * @return The created statement
	 */
    String buildStmtForTable(String[] tablenames, String whereStmt,
                             HashMap<String, ColumnAttribute> columnNames);

	/**
	 *
	 * @param tablename
	 *            The tablename
	 * @param values
	 *            Filled Primary Key data for rows that shall be read
	 * @return The created statement
	 */
    String buildStmtForTable(String tablename,
                             HashMap<String, Object> values);

	/**
	 *
	 * @param table
	 *            The table's name
	 * @param values
	 *            Columns and associated values
	 * @return The created statement.
	 */
    String buildInsertStmtForTable(String table,
                                   HashMap<String, Object> values);

	/**
	 *
	 * @param table
	 *            The table's name
	 * @param values
	 *            Columns and associated values.
	 * @param whereStmt
	 *            Optional, but if not specified all PrimaryKey elements must
	 *            exist <br>
	 *            in the given map "values".
	 * @return The created statement.
	 */
    String buildUpdateStmtForTable(String table,
                                   HashMap<String, Object> values, String whereStmt)
	;

	String markTableName(String tableName);

	String markColumnName(String columnName);

	/**
	 * Get names of columns that are bound to {@link PreparedStatement} with an
	 * "?". <br>
	 * Those have to be post-processed
	 *
	 * @return The where-column names of the recent statements creation
	 */
    List<String> getCols2Handle();

	/**
	 * @param date
	 *            The given date
	 * @return Formatted date string
	 */
    String toDateString(Date date);

}
