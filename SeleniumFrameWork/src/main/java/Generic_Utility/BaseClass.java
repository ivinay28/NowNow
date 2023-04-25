package Generic_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import POM.HomePagePOM;
import POM.LoginPagePOM;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public static WebDriver sdriver;
	public WebDriver driver;
	Property_Utility plib = new Property_Utility();
	
	@BeforeSuite(groups = {"smoketest","regressiontest","sanitytest"})
	public void BS()
	{
		System.out.println("DataBase Connection Started");
	}
	
	@BeforeTest(groups = {"smoketest","regressiontest","sanitytest"})
	public void BT()
	{
		System.out.println("Parallel Execution");
	}
	
	@Parameters ("BROWSER")
	@BeforeClass (groups = {"smoketest","regressiontest","sanitytest"})
	//public void BC() throws Throwable
	public void BC(String BROWSER) throws Throwable
	{
		
		//String BROWSER = plib.getKeyValue("browser");
		
		if (BROWSER.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} 
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}	
		else if(BROWSER.equalsIgnoreCase("opera"))
		{
			WebDriverManager.operadriver();
			driver = new OperaDriver();
		}	
		else
		{
			driver= new ChromeDriver();
		}
		//sdriver=driver;
		//driver.manage().window().maximize();
		System.out.println("Browser Opened");
	}
	
	@BeforeMethod(groups = {"smoketest","regressiontest","sanitytest"})
	public void BM() throws Throwable
	{
		Property_Utility plib = new Property_Utility();
		String URL = plib.getKeyValue("url");
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD = plib.getKeyValue("password");
		driver.get(URL);
		LoginPagePOM login = new LoginPagePOM(driver);
		login.loginToApp(USERNAME, PASSWORD);
		System.out.println("Logged into App");
	}	
	
	@AfterMethod(groups = {"smoketest","regressiontest","sanitytest"})
	public void AM()
	{
		HomePagePOM home = new HomePagePOM(driver);
		home.signout(driver);
		System.out.println("Logged out of App");
	}
	
	@AfterClass(groups = {"smoketest","regressiontest","sanitytest"})
	public void AC()
	{
		driver.quit();
		System.out.println("Browser Closed");
	}
	
	@AfterTest(groups = {"smoketest","regressiontest","sanitytest"})
	public void AT()
	{
		System.out.println("Parallel Execution done");
	}
	
	@AfterSuite(groups = {"smoketest","regressiontest","sanitytest"})
	public void AS()
	{
		System.out.println("DataBase Connection Closed");
	}
}
