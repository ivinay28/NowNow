package Generic_Utility;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriver_Utility 
{
	/**
	 *  // this is used to switch between windows
	 * @param driver
	 * @author Vinay
	 */
	
	
	public void switchToWindow(WebDriver driver,String PartialWindowTitle)
	{
		Set<String> allIds1 = driver.getWindowHandles();
		Iterator<String> id1 = allIds1.iterator();
		while (id1.hasNext())
		{
			String wid1 = id1.next();
			driver.switchTo().window(wid1);
			String title = driver.getTitle();
			
			if (title.contains(PartialWindowTitle))
			{
				break;
			}
		}
	}
	
	public void switchToWindow2(WebDriver driver,String PartialWindowTitle)
	{
		Set<String> allIds2 = driver.getWindowHandles();
		Iterator<String> id2 = allIds2.iterator();
		while (id2.hasNext())
		{
			String wid2 = id2.next();
			driver.switchTo().window(wid2);
			String title = driver.getTitle();
			
			if (title.contains(PartialWindowTitle))
			{
				break;
			}
		}
	}

	public void hovering(WebDriver driver, WebElement data)
	{
		Actions act2= new Actions(driver);
		act2.moveToElement(data).perform();
	}
	
	public void switchToWindow1(WebDriver driver,String PartialWindowTitle)
	{
		Set<String> allIds = driver.getWindowHandles();
		Iterator<String> id = allIds.iterator();
		
		while(id.hasNext())
		{
			String wid = id.next();
			driver.switchTo().window(wid);
			String title = driver.getTitle();
			if (title.contains(PartialWindowTitle))
			{
				break;
			}
		}
	}
	
	public void popup(WebDriver driver)
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
}
