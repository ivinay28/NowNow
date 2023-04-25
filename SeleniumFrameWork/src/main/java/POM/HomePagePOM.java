package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePOM 
{
	public HomePagePOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement orglink;
	
	@FindBy(linkText = "Products")
	private WebElement prdtlink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactslink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement moredd;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignlink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement profilBtn;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutlink;
	
	@FindBy(linkText = "Sales Order")
	private WebElement saleslink;
	
	public void orgclick()
	{
		orglink.click();
	}
	public void prodcutclick()
	{
		prdtlink.click();	
	}
	public void contactclick()
	{
		contactslink.click();
	}
	public void moreclick()
	{
		moredd.click();
	}
	public void salesclick()
	{
		saleslink.click();
	}
	public void campaignclick()
	{
		moredd.click();
		campaignlink.click();
	}
	public void signout(WebDriver driver)
	{
		profilBtn.click();
		signoutlink.click();
	}
}
