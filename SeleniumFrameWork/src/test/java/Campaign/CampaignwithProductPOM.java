package Campaign;
import org.testng.annotations.Test;


import Campaign_and_ProductPOM.CampaignDetailsPOM;
import Campaign_and_ProductPOM.CreateCampaignPOM;
import Campaign_and_ProductPOM.CreateProductPOM;
import Campaign_and_ProductPOM.ProductDetailsPOM;
import Campaign_and_ProductPOM.SwitchToProduct;
import Campaign_and_ProductPOM.Verification;
import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import POM.HomePagePOM;

@Test(groups = "smoketest")
public class CampaignwithProductPOM extends BaseClass
{
	public void campaignwithProductPOM() throws Throwable 
	{
		driver.manage().window().maximize();
		Java_Utility jlib = new Java_Utility();
		jlib.implicitWait(driver);
		HomePagePOM home = new HomePagePOM(driver);
		home.prodcutclick();
		CreateProductPOM product = new CreateProductPOM(driver);
		product.createProduct();
		int ranNum = jlib.getRandomNum();
		Excel_Utility elib = new Excel_Utility();
		String prodData = elib.getExcelDataFormatter2("Product", 3, 2)+ranNum;
		ProductDetailsPOM prodDetails = new ProductDetailsPOM(driver);
		prodDetails.product(driver, prodData);
		home.campaignclick();
		CreateCampaignPOM newCampaign = new CreateCampaignPOM(driver);
		newCampaign.createcamp();
		String campData = elib.getExcelDataFormatter3("Sheet1", 0, 0)+ranNum;
		CampaignDetailsPOM campdet = new CampaignDetailsPOM(driver);
		campdet.campdetails(driver, campData);
		campdet.switchtoprod(driver);
		SwitchToProduct prdswitch = new SwitchToProduct(driver);
		prdswitch.switchtoprod(driver, prodData, prodData);
		campdet.switchtocamp(driver);
		campdet.campsave();
		Verification verify=new Verification(driver);
		verify.verify(driver, campData, prodData);	
	}
}
