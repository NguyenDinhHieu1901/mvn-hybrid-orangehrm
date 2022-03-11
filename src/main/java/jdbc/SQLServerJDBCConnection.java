package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerJDBCConnection {
	public static Connection getConnectionSQLServer(String serverName, String tableName, String userName, String password) {
		Connection connection = null;
		try {
			String connectionUrl = "jdbc:sqlserver://" + serverName + ":1433;DatabaseName=" + tableName + ";encrypt=true;TrustServerCertificate=true;";
			connection = DriverManager.getConnection(connectionUrl, userName, password);
			System.out.println("Connection: " + connection);
		} catch (SQLException e) {
			System.out.println("Connection to Database failed. Please check again!");
			e.printStackTrace();
		}
		return connection;
	}

	public static Connection getConnectionSQLServer() {
		String serverName = "localhost";
		String tableName = "nguyentestdb";
		String userName = "sa";
		String password = "123456789a";
		return getConnectionSQLServer(serverName, tableName, userName, password);
	}
}
