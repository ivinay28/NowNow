package Organization;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import POM.LoginPagePOM;

public class CreateOrganization {

	public static void main(String[] args) throws Throwable 
	{
		String key = "webdriver.chrome.driver";
		String value="C:\\Users\\Vinay\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		/*FileInputStream fis = new FileInputStream("./src/test/resources/PropertyFile.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
				*/
		
		
		
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Property_Utility plib = new Property_Utility();
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD = plib.getKeyValue("password");
		String URL = plib.getKeyValue("url");
		driver.get(URL);
		// POM usage
		LoginPagePOM login= new LoginPagePOM(driver);
		login.loginToApp(USERNAME, PASSWORD);
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		
		/*Random ran = new Random();
		int ranNum = ran.nextInt(1000);*/
		
		//GenericFunction
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		
		
		/*FileInputStream fes = new FileInputStream("C:\\Users\\Vinay\\Desktop\\Adv Selenium\\22-03-2023\\Book1.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sh = book.getSheet("Organization");
		Row row = sh.getRow(1);
		Cell column = row.getCell(1);
		String exceldata = column.getStringCellValue()+ranNum;*/
		
		Excel_Utility elib = new Excel_Utility();
		//String excelData = elib.getExcelData("Organization", 1, 1)+ranNum;
		String excelData = elib.getExcelDataFormatter("Organization", 1, 1)+ranNum;
		
		driver.findElement(By.name("accountname")).sendKeys(excelData);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Thread.sleep(2000);
		String actdata = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actdata.contains(excelData))
		{
			System.out.println("Validation pass");
		}
		else
		{
			System.out.println("Validation fail");
		}

		
		WebElement ele2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act= new Actions(driver);
		act.moveToElement(ele2).perform();
		driver.findElement(By.linkText("Sign Out")).click();
	}

}
