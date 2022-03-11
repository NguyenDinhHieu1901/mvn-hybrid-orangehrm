package com.hrm.employees;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.hrm.DashboardPO;
import pageObjects.hrm.LoginPO;
import pageObjects.hrm.PageGeneratorManager;

public class Level_23_Database_Testing extends BaseTest {

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		log.info("Pre-condition - Step 01: Login to system as Admin role");
		dashboardPage = loginPage.loginToSystem("Admin", "admin123");
	}

	@Test
	public void TC_01_Verify_Database_With_UI() throws SQLException {
		log.info("TC_01 - step 01: Get Employee list number at Dashboard page");
		int employeeNumberInUI = dashboardPage.getEmployeeListNumberInUI();
		
		log.info("TC_01 - step 02: Get Employee list number in Database");
		int employeeNumberInDB = dashboardPage.getEmployeeListNumberInDB();
		
		log.info("TC_01 - step 03: Verify employee number in UI and DB is equal");
		verifyEquals(employeeNumberInUI, employeeNumberInDB);
	}

	@Parameters("browser")
	@AfterClass(alwaysRun = true)
	public void afterClass(String browserName) {
		log.info("Post-Condition: Cleaning the browser '" + browserName + "'");
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private LoginPO loginPage;
	private DashboardPO dashboardPage;
}