package Practice;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class LaunchBrowser 
{
	public static void main(String[] args) throws Throwable 
	{
		String key = "webdriver.chrome.driver";
		String value="C:\\Users\\Vinay\\Downloads\\chromedriver_win32\\chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver = new ChromeDriver();

		FileInputStream fis = new FileInputStream("./src/test/resources/PropertyFile.properties");
		Properties pro = new Properties();
		pro.load(fis);
		
		String URl = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		driver.get(URl);
		
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.name("pwd")).sendKeys(PASSWORD);
		driver.findElement(By.id("loginButton")).click();
		
		System.out.println(URl);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);				
	}
}
