package nov11.com.rakshant.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BasicCRUD {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE", "system", "root");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from DEPT");
		while (rs.next()) {
			System.out.print(rs.getInt("ID") + "  ");
			System.out.println(rs.getString("Dept_name"));
		}

		// Update
		PreparedStatement pstmt = con
				.prepareStatement("update DEPT set Dept_name=? where id=?");
		pstmt.setString(1, "Finance");
		pstmt.setInt(2, 2);
		System.out.println(pstmt.executeUpdate());
		System.out.println("records updated");

		// Delete
		pstmt = con.prepareStatement("delete from DEPT where id=?");
		pstmt.setInt(1, 2);
		System.out.println(pstmt.executeUpdate());
		System.out.println("records deleted");

		rs.close();
		stmt.close();
		con.close();

	}

}
