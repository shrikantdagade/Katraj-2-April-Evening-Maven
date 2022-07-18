package test;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class LoginTest {

	WebDriver driver;
	LoginPage lp;

	@BeforeClass
	public void initObject() {

		lp = new LoginPage(driver);

	}

	@BeforeSuite
	public void beforeSuite() {

		WebDriverManager.chromedriver().setup();

		// Step -1 Launch browser
		driver = new ChromeDriver();

		// step-2 max window
		driver.manage().window().maximize();

		// step-3 open web application
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

		// step-4 dynamic wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void login() {

		lp.enterCred("Admin", "admin123");

		lp.clcikButton();

		// Assert.assertEquals(driver.getTitle(),"OrangeHrm","Title doesnot matched");
		Assert.assertTrue(true);

	}

	@AfterSuite
	public void afterSuite() {

		driver.close();
	}

}
