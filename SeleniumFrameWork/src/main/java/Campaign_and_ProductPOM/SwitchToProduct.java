package Campaign_and_ProductPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwitchToProduct 
{
	public SwitchToProduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "search_text")
	private WebElement nametf;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	public void switchtoprod(WebDriver driver, String data, String pr) throws Throwable
	{
		nametf.sendKeys(data);
		searchBtn.click();	
		driver.findElement(By.xpath("//a[text()='"+pr+"']")).click();
		
	}
}
