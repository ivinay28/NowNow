package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sikuli {

	public static void main(String[] args) throws Throwable
	{
//		WebDriver driver;
//		WebDriverManager.chromedriver().setup();
//		driver= new ChromeDriver();
//		driver.get("https://www.google.com/");
		Screen s = new Screen();
//		Pattern img = new Pattern("C:\\Users\\Vinay\\git\\repository\\SeleniumFrameWork\\iconYT.JPG");
//		s.click(img);
		Pattern img1 = new Pattern("C:\\Users\\Vinay\\git\\repository\\SeleniumFrameWork\\iconSearch.jpg");
		s.click(img1);
		Pattern img2 = new Pattern("C:\\Users\\Vinay\\git\\repository\\SeleniumFrameWork\\iconPaint.jpg");
		s.click(img2);
		Pattern img3 = new Pattern("C:\\Users\\Vinay\\git\\repository\\SeleniumFrameWork\\iconAlphabet.jpg");
		s.click(img3);
		
	}

}
