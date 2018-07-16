package nov11.com.rakshant.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BatchUpdates {

	public static void main(String[] args) throws Exception{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE", "system", "root");
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from DEPT");
		
		PreparedStatement pstmt=con.prepareStatement("insert into dept_copy values(?,?)");
		
		while(rs.next()){
			pstmt.setInt(1, rs.getInt("ID"));
			pstmt.setString(2, rs.getString("dept_name"));
			pstmt.addBatch();
		}		
		
		
		try{
			con.setAutoCommit(false);
			pstmt.executeBatch();
			con.commit();
		}
		catch(Exception e){
			con.rollback();
		}
		finally{
			con.setAutoCommit(true);
		}
		


	}

}
