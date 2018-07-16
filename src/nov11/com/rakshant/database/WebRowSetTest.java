package nov11.com.rakshant.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class WebRowSetTest {

	public static void main(String[] args) throws Exception {

		//Write to XML
		RowSetFactory rowSetFactory=RowSetProvider.newFactory();
		WebRowSet webRowSet = rowSetFactory.createWebRowSet();
		webRowSet.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		webRowSet.setUsername("system");
		webRowSet.setPassword("root");
		webRowSet.setCommand("SELECT * FROM dept");
		webRowSet.execute();
		
		FileOutputStream fos = new FileOutputStream("employees.xml");
		webRowSet.writeXml(fos);
		
		//Read from XML
		File file=new File("employees.xml");
		FileInputStream fis=new FileInputStream(file);
		webRowSet.readXml(fis);
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE", "system", "root");
		PreparedStatement pstmt = con.prepareStatement("insert into dept values(?,?)");
		
		while (webRowSet.next()){
			pstmt.setInt(1, webRowSet.getInt("ID"));
			pstmt.setString(2, webRowSet.getString("Dept_name"));
			
		}		
	}
}
