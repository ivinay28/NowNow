package Product;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;

public class CreateProduct_AndDelete extends BaseClass
{
	@Test (groups = {"smoketest","regressiontest","sanitytest"})
	public static void createProduct_AndDelete() throws Throwable 
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
		String proddata = column.getStringCellValue()+ranvalue;
		driver.findElement(By.name("productname")).sendKeys(proddata);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		/*driver.findElement(By.xpath("(//input[@title='Delete [Alt+D]'])[1]")).click();
		Alert pop = driver.switchTo().alert();
		pop.accept();*/
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody//tr//a[text()='"+proddata+"']/../..//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("(//input[@value='Delete'])[2]")).click();
		Alert pop = driver.switchTo().alert();
		pop.accept();
		
		
		boolean flag=false;
		driver.findElement(By.linkText("Products")).click();
		List<WebElement> prod_list = driver.findElements(By.xpath("//a[@title=\"Products\"]"));
		for(WebElement we:prod_list)
		{
			String prod_data = we.getText();
			if(prod_data.equals(proddata))
			{
				flag=true;
				break;
			}
		}
		
		if(flag)
		{
			System.out.println(proddata+" not deleted");
		}
		else
		{
			System.out.println(proddata+" deleted");
		}
		
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
			
	}

}
