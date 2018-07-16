package nov11.com.rakshant.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JDBCRowSetTest {

	public static void main(String[] args) throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE", "system", "root");

		RowSetFactory rowSetFactory = RowSetProvider.newFactory();
		JdbcRowSet jDBCRowset = rowSetFactory.createJdbcRowSet();
		jDBCRowset.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		jDBCRowset.setUsername("system");
		jDBCRowset.setPassword("root");
		jDBCRowset.setCommand("select * from dept");
		jDBCRowset.execute();

		PreparedStatement pstmt = con
				.prepareStatement("insert into dept_copy values(?,?)");

		while (jDBCRowset.next()) {
			pstmt.setInt(1, jDBCRowset.getInt("ID"));
			pstmt.setString(2, jDBCRowset.getString("dept_name"));
			pstmt.addBatch();
		}

		System.out.println("Table copied");
		pstmt.executeBatch();

		pstmt.close();

	}

}
