package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLTest {
	public static Connection getMyConnection() {
		return MySQLConnection.getMySQLConnection();
	}
	
	public static void main(String[] args) throws SQLException {
		System.out.println("Get connection .....");
		
		Connection connection = MySQLTest.getMyConnection();
		Statement statement = connection.createStatement();
		String sqlCommand = "select emp.EMP_ID, emp.FIRST_NAME, emp.LAST_NAME, emp.DEPT_ID from EMPLOYEE emp where emp.DEPT_ID='1';";
		ResultSet resultSet = statement.executeQuery(sqlCommand);
		
		while(resultSet.next()) {
			int empID = resultSet.getInt(1);
			String firstName = resultSet.getString("FIRST_NAME");
			String lastName = resultSet.getString(3);
			int deptID = resultSet.getInt("DEPT_ID");
			System.out.println("Emp ID: " + empID);
			System.out.println("First Name: " + firstName);
			System.out.println("Last Name: " + lastName);
			System.out.println("Department ID: " + deptID);
			System.out.println("=======================");
		}
		
		connection.close();
		System.out.println("Close connection.");
	}
}
