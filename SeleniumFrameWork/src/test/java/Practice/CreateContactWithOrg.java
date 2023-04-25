package Practice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;

public class CreateContactWithOrg {

	public static void main(String[] args) throws Throwable 
	{
		String key = "webdriver.chrome.driver";
		String value="C:\\Users\\Vinay\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Property_Utility plib = new Property_Utility();
		String URL = plib.getKeyValue("url");
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD = plib.getKeyValue("password");
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Java_Utility jlib=new Java_Utility();
		int ranNum = jlib.getRandomNum();
		
		Excel_Utility elib = new Excel_Utility();
		
		//organization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		String orgData = elib.getExcelDataFormatter("Organization", 0, 0);
		
		driver.findElement(By.name("accountname")).sendKeys(orgData);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(1000);
		
		//contact
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		String conData = elib.getExcelData("Contact", 0, 0)+ranNum;
		driver.findElement(By.name("lastname")).sendKeys(conData);
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
		
		Set<String> allIds = driver.getWindowHandles();
		Iterator<String> id = allIds.iterator();
		
		while(id.hasNext())
		{
			String wid = id.next();
			driver.switchTo().window(wid);
			String title = driver.getTitle();
			
			if (title.contains("Accounts&action"))
			{
				break;
			}
		}
		
		Thread.sleep(1000);
		driver.findElement(By.name("search_text")).sendKeys(orgData);
		driver.findElement(By.name("search")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='"+orgData+"']")).click();
		
		Set<String> allIds2 = driver.getWindowHandles();
		Iterator<String> id2 = allIds2.iterator();
		while(id2.hasNext())
		{
			String wid2 = id2.next();
			driver.switchTo().window(wid2);
			String title2 = driver.getTitle();
			if (title2.contains("Contacts&action")) 
			{
				break;
			}	
		}
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String ele = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
		String ele2 = driver.findElement(By.xpath("(//a[text()='"+orgData+"'])[2]")).getText();
		
		if (ele.contains(conData)) 
		{
			System.out.println("contact validation pass");
		}
		else
		{
			System.out.println("contact validation fail");
		}
		if (ele2.contains(orgData)) 
		{
			System.out.println("organization validation pass");
		}
		else
		{
			System.out.println("organization validation fail");
		}
		
		
		
	}
}
