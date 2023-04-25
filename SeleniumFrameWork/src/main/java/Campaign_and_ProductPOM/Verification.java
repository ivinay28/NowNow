package Campaign_and_ProductPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Verification 
{
	public Verification(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "dtlview_Campaign Name")
	private WebElement camplink;
	
	@FindBy(id = "dtlview_Product")
	private WebElement prodlink;
	
	public void verify(WebDriver driver, String camp,String prod)
	{	
		String campData = camplink.getText();
		String prodData = prodlink.getText();
		if (camp.contains(campData)) 
		{
			System.out.println("Campaign Validation Passed");
		}
		else 
		{
			System.out.println("Campaign Validation Failed");
		}
		
		if (prod.contains(prodData)) 
		{
			System.out.println("Product Validation Passed");
		}
		else 
		{
			System.out.println("Product Validation Failed");
		}
	}
}
