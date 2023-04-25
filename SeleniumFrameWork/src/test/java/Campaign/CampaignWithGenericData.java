package Campaign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;

public class CampaignWithGenericData extends BaseClass
{

	@Test (groups = "smoketest")
	public void campaignWithGenericData() throws Throwable 
	{
//		Property_Utility plib = new Property_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();
		Java_Utility jlib = new Java_Utility();
		driver.manage().window().maximize();
		jlib.implicitWait(driver);	
//		String URL = plib.getKeyValue("url");
//		String USERNAME = plib.getKeyValue("username");
//		String PASSWORD = plib.getKeyValue("password");
//		driver.get(URL);
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.xpath("//input[@type='submit']")).click();
//		driver.findElement(By.linkText("Products")).click();
		int ranvalue = jlib.getRandomNum();
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		Excel_Utility elib = new Excel_Utility();
		String prddata = elib.getExcelDataFormatter2("Product", 3, 2)+ranvalue;
		
		driver.findElement(By.name("productname")).sendKeys(prddata);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		WebElement ele = driver.findElement(By.linkText("More"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		String camData = elib.getExcelDataFormatter3("Sheet1", 0, 0)+ranvalue;
		driver.findElement(By.name("campaignname")).sendKeys(camData);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		
		wlib.switchToWindow2(driver, "Products&action");
		
		driver.findElement(By.name("search_text")).sendKeys("prddata");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+prddata+"']")).click();
		
		wlib.switchToWindow(driver, "Campaigns&action");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actdata = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
		String actdata2 = driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();
		if (actdata.contains(camData)) 
		{
			System.out.println("campaign pass");
		}
		else
		{
			System.out.println("campaign fail");
		}
		if (actdata2.contains(prddata)) 
		{
			System.out.println("product pass");
		} else 
		{
			System.out.println("product fail");
		}
		WebElement ele2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		wlib.hovering(driver, ele2);
		
		driver.findElement(By.linkText("Sign Out")).click();
	}
	
	

}
