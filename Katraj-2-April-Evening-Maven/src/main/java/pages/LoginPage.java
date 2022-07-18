package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(id="txtUsername")
	private WebElement username;
	
	@FindBy(id="txtPassword")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='btnLogin']")
	private WebElement button;
	
	 public LoginPage (WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void enterCred(String user, String pass) {
		
		username.sendKeys(user);
		password.sendKeys(pass);
	}
	
	public void clcikButton() {
		
		button.click();
	}
	
	public String getText() {
		
		return button.getText();
	}

}
