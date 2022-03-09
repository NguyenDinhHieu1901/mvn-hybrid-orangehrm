package com.hrm.employees;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import environmentConfig.Environment;

public class Level_22_Multiple_Environment extends BaseTest {
	Environment environment;
	
	@Parameters({ "browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		String envMaven = System.getProperty("envMaven");
		ConfigFactory.setProperty("env", envMaven);
		environment = ConfigFactory.create(Environment.class);
		
		driver = getBrowserDriver(browserName, environment.getApplicationUrl());
		log.info("Env Maven: " + envMaven);
		log.info("Current URL: " + driver.getCurrentUrl());
		log.info("Username: " + environment.getUserName());
		log.info("Password: " + environment.getPassword());
		verifyEquals(driver.getCurrentUrl(), "https://demo.guru99.com/v1/");
	}

	@Test
	public void Employee_01_Add_New_Employee() {
	}

	@Test
	public void Employee_02_Upload_Avatar() {

	}

	@Test
	public void Employee_03_Personal_Details() {

	}

	@Test
	public void Employee_04_Contact_Details() {

	}

	@Test
	public void Employee_05_Emergency_Contacts() {

	}

	@Test
	public void Employee_06_Assigned_Dependents() {

	}

	@Test
	public void Employee_07_Edit_View_Job() {

	}

	@Test
	public void Employee_08_Edit_View_Salary() {

	}

	@Test
	public void Employee_09_Edit_View_Tax() {

	}

	@Test
	public void Employee_10_Qualifications() {

	}

	@Test
	public void Employee_11_Search_Employee() {

	}

	@Parameters("browser")
	@AfterClass(alwaysRun = true)
	public void afterClass(String browserName) {
		log.info("Post-Condition: Cleaning the browser '" + browserName + "'");
		closeBrowserAndDriver();
	}

	private WebDriver driver;
}