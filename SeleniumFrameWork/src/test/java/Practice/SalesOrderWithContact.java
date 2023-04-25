package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import OrganizationPOM.CreateOrgPOM;
import OrganizationPOM.OrgDetailsPOM;
import POM.HomePagePOM;
import POM.LoginPagePOM;

public class SalesOrderWithContact {

	public static void main(String[] args) throws Throwable 
	{
		String key = "webdriver.chrome.driver";
		String value="C:\\Users\\Vinay\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Property_Utility plib = new Property_Utility();
		String URL = plib.getKeyValue("url");
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD = plib.getKeyValue("password");
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		LoginPagePOM login= new LoginPagePOM(driver);
		login.loginToApp(USERNAME, PASSWORD);
		
		//contact creation 
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		Excel_Utility elib = new Excel_Utility();
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		String conData = elib.getExcelData("Contact", 0, 0)+ranNum;
		driver.findElement(By.name("lastname")).sendKeys(conData);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//Org Creation
		HomePagePOM home = new HomePagePOM(driver);
		home.orgclick();
		CreateOrgPOM createOrg = new CreateOrgPOM(driver);
		createOrg.createneworg();
		String orgData = elib.getExcelDataFormatter("Organization", 0, 0)+ranNum;
		OrgDetailsPOM orgDet= new OrgDetailsPOM(driver);
		orgDet.orgtextdetails(driver, orgData);
		
		//sales creation
		home.moreclick();
		home.salesclick();
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		String saledata = elib.getExcelDataFormatter4("Sheet1", 0, 0)+ranNum;
		driver.findElement(By.name("subject")).sendKeys(saledata);
//		driver.findElement(By.xpath("(//img[@src=\"themes/softed/images/select.gif\"])[3]")).click();
//		
//		
//		
//		WebDriver_Utility wlib = new WebDriver_Utility();
//		wlib.switchToWindow1(driver, "Contacts&action");
//		driver.findElement(By.name("search_text")).sendKeys(conData);
//		driver.findElement(By.name("search")).click();
//		driver.findElement(By.xpath("//a[text()=' "+conData+"']")).click();
//		Alert pop = driver.switchTo().alert();
//		pop.accept();
//		wlib.switchToWindow2(driver, "Sales");
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//		driver.findElement(By.xpath("(//img[@src=\"themes/softed/images/select.gif\"])[4]")).click();
//		wlib.switchToWindow(driver, "Accounts&action");
//		driver.findElement(By.name("search_text")).sendKeys(orgData);
//		driver.findElement(By.name("search")).click();
//		
//		
	}

}
