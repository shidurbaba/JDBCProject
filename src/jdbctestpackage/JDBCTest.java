package jdbctestpackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTest {
	static Connection con1 = null;
	static Statement statement1 = null;
	static ResultSet resultset1 = null;

	/*public JDBCTest() throws IOException {
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "/PracticeJDBC/Properties/Environment.properties");
		Properties prop = new Properties();
		prop.load(file);
	}*/

	public static JDBCTest getObj() throws IOException {
		return new JDBCTest();
	}

	public static Connection getConnection(String url, String user, String password) throws SQLException {
		con1 = DriverManager.getConnection(url, user, password);
		return con1;
	}

	public static Statement getStatement() throws SQLException {
		statement1 = con1.createStatement();
		return statement1;
	}
	

	public static void main(String[] args) throws IOException, SQLException {

		JDBCTest test = JDBCTest.getObj();
		
		String mysqlUrl = "jdbc:mysql://localhost:3306/demo?useSSL=false";
		String username = "qastudent";
		String password = "qastudent";
		
		Connection con = JDBCTest.getConnection(mysqlUrl, username, password);
		Statement statement = JDBCTest.getStatement();
		ResultSet resultset = statement.executeQuery("select * from employees");
		
		while(resultset.next()) {
			System.out.println(resultset.getString("first_name") + " " + resultset.getString("last_name"));
		}
		resultset.close();

	}
}
