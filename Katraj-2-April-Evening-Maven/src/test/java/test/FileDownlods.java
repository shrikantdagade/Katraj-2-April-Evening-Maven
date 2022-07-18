package test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileDownlods {

	public static void main(String[] args) throws InterruptedException {
       
		String location=System.getProperty("user.dir")+"\\Downlods\\";
		
		//for chrome
		HashMap preferences=new HashMap();
		preferences.put("download.default_directory", location);
		
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", preferences);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("https://chromedriver.chromium.org/downloads");
		driver.manage().window().maximize();

		String tab1=driver.getWindowHandle();

		WebElement link1=driver.findElement(By.xpath("//a[text()='ChromeDriver 104.0.5112.29']"));
		link1.click();
		Set<String> handles=driver.getWindowHandles();
		for(String tabs:handles) {
			if(!tabs.equals(tab1)) {
				driver.switchTo().window(tabs);

			//	driver.findElement(By.xpath("//a[text()='chromedriver_win32.zip']"));
				WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='chromedriver_win32.zip']")));
				element.click();
				Thread.sleep(10000);
				driver.close();
			}
		}
		
		driver.switchTo().window(tab1);
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		driver.close();
		
		
		
		
	}

}
