package test2;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import page2.BasePage;

@Listeners(page2.Listenerpage.class)
public class TestClass1 extends BasePage{
	
	@Test(testName = "testGoogle")
	public void testGoogle() throws InterruptedException {
		
		driver.get("https://www.google.com/");
	    WebElement searchElement=  driver.findElement(By.name("q"));
	    searchElement.sendKeys("HYR Tutorials");
	    searchElement.sendKeys(Keys.ENTER);
	    String expectedTitle="HYR Tutorials - Google Search";
	    String actualTitle=driver.getTitle();
	    Assert.assertEquals(actualTitle, expectedTitle,"title is mismatched");
	    
		
	}
	
	@Test(testName = "testFacebook")
	public void testFacebook() throws InterruptedException {
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys("abbc@",Keys.ENTER);
	    Thread.sleep(3000);
	    
	    SoftAssert assert1= new SoftAssert();
        //title matched
	    String actualTitle=driver.getTitle();
	    String expectedTitle="Log in to Facebook";
	    assert1.assertEquals(actualTitle, expectedTitle,"Title is mismatced");
	    
	    //URL matched
    
	    String actURL=driver.getCurrentUrl();
	    String expURL="https://www.facebook.com/";
	    assert1.assertEquals(actURL, expURL, "URL is mismatched");
	    
	    //text assertion
	    String actualText=driver.findElement(By.name("email")).getText();
	    String expectedText="";
	    assert1.assertEquals(actualText, expectedText, "Username text is mismatched");
	    
	    //border assertion
	    String actborder=driver.findElement(By.name("email")).getCssValue("border");
	    String expborder="1px solid rgb(240, 40, 73)";
            System.out.println(actborder);
        assert1.assertEquals(actborder, expborder, "Username border is mismatched");
        
        //error message
        String acterrormsg=driver.findElement(By.xpath("//div[@class='_9ay7']")).getText();
        System.out.println(acterrormsg);
        String expErrormsg="The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
        assert1.assertEquals(acterrormsg, expErrormsg, "Username error msg is mismatched");
        assert1.assertAll();
		
	}
	
	@Test(testName = "testOrangeHRM")
	public void testOrangeHRM() {
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).sendKeys(Keys.ENTER);
		Assert.assertTrue(driver.findElement(By.id("welcome")).isDisplayed());


		
	}

}
