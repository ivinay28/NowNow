package Campaign_and_ProductPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPOM
{
	public ProductDetailsPOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name = "productname")
	private WebElement producttf;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public void product(WebDriver driver, String data)
	{
		producttf.sendKeys(data);
		saveBtn.click();
	}
}
