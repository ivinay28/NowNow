package Campaign_and_ProductPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.WebDriver_Utility;

public class CampaignDetailsPOM
{
	public CampaignDetailsPOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "campaignname")
	private WebElement camptf;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement producticon;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public void campdetails(WebDriver driver, String data)
	{
		camptf.sendKeys(data);
		producticon.click();
			
	}
	
	public void switchtoprod(WebDriver driver)
	{
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.switchToWindow(driver, "Products&action");
	}
	
	public void switchtocamp(WebDriver driver)
	{
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.switchToWindow(driver, "Campaigns&action");
	}
	
	public void campsave()
	{
		saveBtn.click();
	}
}
