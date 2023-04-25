package Campaign_and_ProductPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.WebDriver_Utility;

public class CreateAndProductDeletePOM 
{
	public CreateAndProductDeletePOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createBtn;
	
	@FindBy (name = "productname")
	private WebElement producttf;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name = "Delete")
	private WebElement deleteBtn;
	
	public void createProduct()
	{
		createBtn.click();
	}
	
	public void product(WebDriver driver, String data)
	{
		producttf.sendKeys(data);
		saveBtn.click();
	}
	
	public void deleteprod(WebDriver driver)
	{
		deleteBtn.click();
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.popup(driver);
	}
	
}
