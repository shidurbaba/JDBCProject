package jdbctestpackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsert extends JDBCTest {

	public static JDBCInsert getObj() {
		return new JDBCInsert();
	}

	public static void main(String[] args) throws SQLException {

		Connection con = null;
		Statement statement = null;
		ResultSet results = null;

		String mysqlUrl = "jdbc:mysql://localhost:3306/demo?useSSL=false";
		String username = "qastudent";
		String password = "qastudent";

		con = JDBCTest.getConnection(mysqlUrl, username, password);
		statement = con.createStatement();

		System.out.println("Inserting new employee");

		int mysqlRows = statement
				.executeUpdate("insert into employees" + "(last_name, first_name, email, department, salary)" + "values"
						+ "('Panther', 'Jay', 'jaypather001@gmail.com', 'SS', '132000.00')");
		results = statement.executeQuery("select * from employees");

		while (results.next()) {
			System.out.println(results.getString("last_name") + ", " + results.getString("first_name"));
		}

		results.close();
	}

}
