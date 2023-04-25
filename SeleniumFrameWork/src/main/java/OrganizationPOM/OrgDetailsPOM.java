package OrganizationPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgDetailsPOM 
{
	public OrgDetailsPOM(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "accountname")
	private WebElement namelink;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveBtn;
	
	public void orgtextdetails(WebDriver driver, String data) throws Throwable
	{
		namelink.sendKeys(data);
		saveBtn.click();
	}
}
