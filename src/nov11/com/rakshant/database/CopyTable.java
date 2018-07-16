package nov11.com.rakshant.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CopyTable {

	public static void main(String[] args) throws SQLException,
			ClassNotFoundException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE", "system", "root");
		
		Statement stmt = con.createStatement();
		stmt.executeUpdate("Create table DEPT_COPY (ID number(2), Dept_name varchar2(10))");
		PreparedStatement pstmt = con.prepareStatement("insert into dept_copy select * from dept");
		pstmt.executeUpdate();

	}

}
