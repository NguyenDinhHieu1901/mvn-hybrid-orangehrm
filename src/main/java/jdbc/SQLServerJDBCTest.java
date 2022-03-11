package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLServerJDBCTest {

	public static Connection getMyConnection() {
		return SQLServerJDBCConnection.getConnectionSQLServer();
	}

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		String sqlServer = "Select * From nguyentestdb.dbo.EMPLOYEE emp where emp.FIRST_NAME like ? and emp.DEPT_ID=?;";
		try {
			connection = getMyConnection();
			PreparedStatement preStatement = connection.prepareStatement(sqlServer);
			preStatement.setString(1, "s%");
			preStatement.setInt(2, 1);
			ResultSet result = preStatement.executeQuery();
			while (result.next()) {
				int empID = result.getInt(1);
				String firstName = result.getString("FIRST_NAME");
				String lastName = result.getString("LAST_NAME");
				int deptID = result.getInt("DEPT_ID");
				System.out.println(empID);
				System.out.println(firstName);
				System.out.println(lastName);
				System.out.println(deptID);
				System.out.println("============================");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				System.out.println("Disconnect to Database");
				connection.close();
			}
		}

	}

}
