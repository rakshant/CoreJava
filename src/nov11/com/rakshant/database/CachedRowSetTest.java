package nov11.com.rakshant.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class CachedRowSetTest {

	public static void main(String[] args) throws Exception{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE", "system", "root");
		
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM DEPT");
		
		RowSetFactory rowSetFactory=RowSetProvider.newFactory();
		CachedRowSet cachedRowSet = rowSetFactory.createCachedRowSet();
		cachedRowSet.populate(rs);
		con.close();
		while(cachedRowSet.next()) {
			int id = cachedRowSet.getInt("ID");
			String deptName = cachedRowSet.getString("DEPT_NAME");			
			System.out.println(id + " - "+deptName);
		}
		
		rs.close();
		stmt.close();
		con.close();
		cachedRowSet.close();

	}

}
