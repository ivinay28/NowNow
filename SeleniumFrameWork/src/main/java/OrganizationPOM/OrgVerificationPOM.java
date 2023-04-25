package OrganizationPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgVerificationPOM 
{
	public OrgVerificationPOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getHeading() {
		return orgverifylink;
	}

	@FindBy(xpath = "//span[@id=\"dtlview_Organization Name\"]")
	private WebElement orgverifylink;
	
	public Object orgverify(WebDriver driver, String data) throws Throwable
	{	
		String expdata = orgverifylink.getText();
		if(expdata.contains(data))
		{
			System.out.println("Validation passed");
		}
		else
		{
			System.out.println("Validation Failed");
		}
		return expdata;		
	}
}
