package Campaign;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateCampaign {

	public static void main(String[] args) throws Throwable 
	{
		String key = "webdriver.chrome.driver";
		String value="C:\\Users\\Vinay\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		FileInputStream fis = new FileInputStream("./src/test/resources/PropertyFile.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.linkText("Products")).click();
		
		Random ran = new Random();
		int ranvalue = ran.nextInt(1000);
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		FileInputStream fes = new FileInputStream("./src/test/resources/Product.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sh = book.getSheet("Product");
		Row row = sh.getRow(3);
		Cell column = row.getCell(2);
		String prddata = column.getStringCellValue()+ranvalue;
		driver.findElement(By.name("productname")).sendKeys(prddata);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		WebElement ele = driver.findElement(By.linkText("More"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		FileInputStream fcs = new FileInputStream("./src/test/resources/Campaign.xlsx");
		Workbook book2 = WorkbookFactory.create(fcs);
		Sheet sheet = book2.getSheet("Sheet1");
		Row row2 = sheet.getRow(0);
		Cell column2 = row2.getCell(0);
		String camdata = column2.getStringCellValue()+ranvalue;
		driver.findElement(By.name("campaignname")).sendKeys(camdata);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		
		Set<String> allIds = driver.getWindowHandles();
		Iterator<String> id = allIds.iterator();
		while (id.hasNext())
		{
			String wid = id.next();
			driver.switchTo().window(wid);
			String title = driver.getTitle();
			
			if (title.contains("Products&action"))
			{
				break;
			}
		}
		driver.findElement(By.name("search_text")).sendKeys("prddata");
		driver.findElement(By.name("search")).click();
		
		driver.findElement(By.xpath("//a[text()='"+prddata+"']")).click();
		
		Set<String> allIds1 = driver.getWindowHandles();
		Iterator<String> id1 = allIds1.iterator();
		while (id1.hasNext())
		{
			String wid1 = id1.next();
			driver.switchTo().window(wid1);
			String title = driver.getTitle();
			
			if (title.contains("Campaigns&action"))
			{
				break;
			}
		}
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actdata = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
		String actdata2 = driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();
		if (actdata.contains(camdata)) 
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
		Actions act2= new Actions(driver);
		act2.moveToElement(ele2).perform();
		driver.findElement(By.linkText("Sign Out")).click();
	
	
	}

}
