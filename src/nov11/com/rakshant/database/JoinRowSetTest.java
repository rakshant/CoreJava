package nov11.com.rakshant.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JoinRowSetTest {

	public static void main(String[] args) throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE", "system", "root");

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM EMP");

		RowSetFactory rowSetFactory = RowSetProvider.newFactory();
		CachedRowSet cachedRowSetEmp = rowSetFactory.createCachedRowSet();
		cachedRowSetEmp.populate(rs);

		rs = stmt.executeQuery("SELECT * FROM DEPT");
		CachedRowSet cachedRowSetDept = rowSetFactory.createCachedRowSet();
		cachedRowSetDept.populate(rs);
		con.close();

		cachedRowSetEmp.setMatchColumn(6);
		cachedRowSetDept.setMatchColumn(1);
		JoinRowSet joinRowSet = rowSetFactory.createJoinRowSet();
		joinRowSet.populate(cachedRowSetEmp);
		joinRowSet.populate(cachedRowSetDept);
		while (joinRowSet.next()) {
			if (joinRowSet.getString("DEPT_NO").equals("ID")) {
				String empName = joinRowSet.getString("NAME");
				System.out.println(empName);
			}
		}
	}

}
