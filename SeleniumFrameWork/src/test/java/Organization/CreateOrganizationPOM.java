package Organization;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import OrganizationPOM.CreateOrgPOM;
import OrganizationPOM.OrgDetailsPOM;
import OrganizationPOM.OrgVerificationPOM;
import POM.HomePagePOM;
//@Listeners(Generic_Utility.ListenerClass.class)
@Test (groups = "sanitytest")
public class CreateOrganizationPOM extends BaseClass
{
	public void createOrganizationPOM() throws Throwable
	{
		Java_Utility jlib = new Java_Utility();
		jlib.implicitWait(driver);
		HomePagePOM home = new HomePagePOM(driver);
		home.orgclick();
		Assert.assertEquals(true, true);
		CreateOrgPOM create=new CreateOrgPOM(driver);
		create.createneworg();
		Excel_Utility elib = new Excel_Utility();
		int ranNum = jlib.getRandomNum();
		String exceldata = elib.getExcelDataFormatter("Organization", 0, 0)+ranNum;
		OrgDetailsPOM orgdet = new OrgDetailsPOM(driver);
		orgdet.orgtextdetails(driver, exceldata);
		OrgVerificationPOM orgverification=new OrgVerificationPOM(driver);
		Object actData = orgverification.orgverify(driver, exceldata);
		Assert.assertEquals(actData, exceldata);
	}
}
