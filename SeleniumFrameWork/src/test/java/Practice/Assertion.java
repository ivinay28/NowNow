package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertion 
{
	@Test
	public void CreateContact()
	{
		System.out.println("Step1");
		System.out.println("Step2");
		Assert.assertEquals(false, true);
		System.out.println("Step3");
		System.out.println("Step4");
	}
	public void DeleteContact()
	{
		System.out.println("Step5");
		System.out.println("Step6");

	}
}