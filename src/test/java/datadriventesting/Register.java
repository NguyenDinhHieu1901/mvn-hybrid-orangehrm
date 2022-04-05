package datadriventesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Register {
	private WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test(priority = 1, description = "Verify Register function of system", enabled = true, invocationCount = 5)
	public void TC_01_Login(String userName, String password) throws InterruptedException {
		driver.findElement(By.cssSelector("a.ico-login")).click();
		driver.findElement(By.cssSelector("input#Email")).sendKeys(userName);
		driver.findElement(By.cssSelector("input#Password")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getTitle().matches("nopCommerce demo store"));
		System.out.println("Login successful");
		driver.findElement(By.cssSelector("a.ico-logout")).click();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}
}
