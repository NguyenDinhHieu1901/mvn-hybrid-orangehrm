package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

	public static Connection getMySQLConnection() {
		String hostname = "localhost";
		String dbName = "mytestdb";
		String userName = "root";
		String password = "123456789a";
		return getMySQLConnection(hostname, dbName, userName, password);
	}

	public static Connection getMySQLConnection(String hostname, String dbName, String userName, String password) {
		Connection connection = null;
		try {
			// Syntax of URL connection for MySQL
			String connectionUrl = "jdbc:mysql://" + hostname + ":3306/" + dbName + "?useSSL=false";
			connection = DriverManager.getConnection(connectionUrl, userName, password);
			System.out.println("Connection: " + connection);
		} catch (SQLException e) {
			System.out.println("Connection to DB failure. Please check again!");
			e.printStackTrace();
		}
		return connection;
	}
}
