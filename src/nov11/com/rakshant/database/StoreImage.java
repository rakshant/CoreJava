package nov11.com.rakshant.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StoreImage {

	public static void main(String[] args) throws SQLException,
			ClassNotFoundException, IOException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE", "system", "root");

		// Save image
		PreparedStatement pstmt = con
				.prepareStatement("insert into person values(?,?)");
		pstmt.setString(1, "Alex");
		File file = new File("flower.jpg");
		FileInputStream fis_1 = new FileInputStream(file);
		pstmt.setBinaryStream(2, fis_1, (int) file.length());
		pstmt.executeUpdate();

		// Read Image
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery("select * from Person");
		InputStream fis_2 = null;
		while (resultSet.next()) {
			fis_2 = resultSet.getBinaryStream("Image");
		}
		FileOutputStream fos = new FileOutputStream("newflower.jpg");

		int i = 0;

		do {
			i = fis_2.read();
			if (i != -1) {
				fos.write(i);
			}
		} while (i != -1);

		pstmt.close();
		resultSet.close();
		stmt.close();
		fis_1.close();
		fis_2.close();
		fos.close();

	}

}
