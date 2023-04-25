package Generic_Utility;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Java_Utility 
{
	/**
	 * //this file is used to avlid duplicates by generating random values
	 * @return
	 * @author Vinay
	 */
	
	public int getRandomNum()
	{
		Random ran = new Random();
		int RanNum = ran.nextInt(1000);
		
		return RanNum;
	}
	
	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
}
