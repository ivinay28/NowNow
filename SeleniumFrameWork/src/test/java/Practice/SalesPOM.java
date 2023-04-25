package Practice;

import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import OrganizationPOM.CreateOrgPOM;
import OrganizationPOM.OrgDetailsPOM;
import POM.HomePagePOM;
import POM.LoginPagePOM;

@Test
public class SalesPOM extends BaseClass
{
	public void salesPOM() throws Throwable
	{
		Property_Utility plib = new Property_Utility();
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD = plib.getKeyValue("password");
		String URL = plib.getKeyValue("url");
		driver.get(URL);
		Java_Utility jlib = new Java_Utility();
		jlib.implicitWait(driver);
		LoginPagePOM login= new LoginPagePOM(driver);
		login.loginToApp(USERNAME, PASSWORD);
		HomePagePOM home = new HomePagePOM(driver);
		Excel_Utility elib = new Excel_Utility();
		int rannum = jlib.getRandomNum();
		
		home.orgclick();
		CreateOrgPOM createOrg = new CreateOrgPOM(driver);
		createOrg.createneworg();
		String orgData = elib.getExcelDataFormatter("Organization", 0, 0)+rannum;
		OrgDetailsPOM orgDet= new OrgDetailsPOM(driver);
		orgDet.orgtextdetails(driver, orgData);
		createOrg.createneworg();
//		home.campaignclick();
//		driver.findElement(By.linkText("Contacts")).click();
//		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
//		String conData = elib.getExcelData("Contact", 0, 0)+rannum;
//		driver.findElement(By.name("lastname")).sendKeys(conData);
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		
		
	}
}
