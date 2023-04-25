package TestNg;

import org.testng.annotations.Test;


public class SampleTestNg 
{
	@Test
	public void createContact()
	{
		System.out.println("Contact Created");
	}
	
	@Test(dependsOnMethods = "createContact")
	public void modifyContact()
	{
		System.out.println("Contact Modified");
	}
	
	@Test(dependsOnMethods = "createContact")
	public void deleteContact()
	{
		System.out.println("Contact Deleted");
	}
}
