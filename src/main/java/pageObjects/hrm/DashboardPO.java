package pageObjects.hrm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import commons.BagePage;
import jdbc.MySQLConnection;

public class DashboardPO extends BagePage {
	private WebDriver driver;

	public DashboardPO(WebDriver driver) {
		this.driver = driver;
	}

	public int getEmployeeListNumberInUI() {
		// waitForELementVisible
		// get Element Size ....
		return 18;
	}

	public int getEmployeeListNumberInDB() throws SQLException {
		Connection connection = null;
		List<String> listEmployee = new ArrayList<>();
		String sqlCommand = "select emp.EMP_ID, emp.FIRST_NAME, emp.LAST_NAME, emp.DEPT_ID from EMPLOYEE emp;";
		try {
			connection = MySQLConnection.getMySQLConnection();
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sqlCommand);
			while (result.next()) {
				listEmployee.add(result.getString("FIRST_NAME"));
				System.out.println(result.getString("FIRST_NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.close();
			}
		}

		return listEmployee.size();
	}
}
