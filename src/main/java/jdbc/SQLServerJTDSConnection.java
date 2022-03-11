package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerJTDSConnection {
	public static Connection SQLServerConnection() throws ClassNotFoundException {
		String serverName = "localhost";
		String databaseName = "nguyentestdb";
		String instanceName = "SQLExpress";
		String userName = "sa";
		String password = "123456789a";
		return SQLServerConnection(serverName, databaseName, instanceName, userName, password);
	}

	public static Connection SQLServerConnection(String serverName, String databaseName, String instanceName, String userName, String password) throws ClassNotFoundException {
		Connection connection = null;

		try {
			String connectionUrl = "jdbc:jtds:sqlserver://" + serverName + ":1433/" + databaseName + ";instance=" + instanceName;
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			connection = DriverManager.getConnection(connectionUrl, userName, password);
			System.out.println("Connection: " + connection);
		} catch (SQLException e) {
			System.out.println("Connection to Database failed. Please check again!");
			e.printStackTrace();
		}
		return connection;
	}
}
