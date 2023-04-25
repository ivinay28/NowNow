package Organization;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;

public class CreateOrganization_AndDelete extends  BaseClass
{
	@Test (groups = "regressiontest")
	public void createOrganization_AndDelete() throws Throwable 
	{
		Property_Utility plib = new Property_Utility();
		String URL = plib.getKeyValue("url");
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD = plib.getKeyValue("password");
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		
		Excel_Utility elib = new Excel_Utility();
		String orgData = elib.getExcelDataFormatter("Organization", 0, 0)+ranNum;
		
		driver.findElement(By.name("accountname")).sendKeys(orgData);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody//a[text()='"+orgData+"']/../..//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@value=\"Delete\"]")).click();
		Alert popup = driver.switchTo().alert();
		popup.accept();
		
		boolean flag= false;
		driver.findElement(By.linkText("Organizations")).click();
		List<WebElement> org_list = driver.findElements(By.xpath("//a[@title='Organizations']"));
		for(WebElement we:org_list)
		{
			String org_data = we.getText();
			if (org_data.equals(orgData))
			{
				flag=true;
				break;
			}
		}
		
		if (flag) 
		{
			System.out.println(orgData+" not deleted");
		} else 
		{
			System.out.println(orgData+" deleted");
		}
		
		WebElement ele2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act= new Actions(driver);
		act.moveToElement(ele2).perform();
		driver.findElement(By.linkText("Sign Out")).click();

	}

	
	}


