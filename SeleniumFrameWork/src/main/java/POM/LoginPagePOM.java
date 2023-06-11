package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePOM 
{
	public LoginPagePOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	private WebElement usernametf;
	
	@FindBy(name="user_password")
	private WebElement passwordtf;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitBtn;

	public WebElement getUsernametf() {
		return usernametf;
	}

	public WebElement getPasswordtf() {
		return passwordtf;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public void loginToApp(String name, String word)
	{
		usernametf.sendKeys(name);
		passwordtf.sendKeys(word);
		submitBtn.click();
	}
}
