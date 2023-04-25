package Product;

import org.testng.annotations.Test;

import Campaign_and_ProductPOM.CreateAndProductDeletePOM;
import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import POM.HomePagePOM;

@Test(groups = "regressiontest")
public class CreateAndDeletePOM extends BaseClass
{
	public void createAndDeletePOM() throws Throwable 
	{
		Java_Utility jlib= new Java_Utility();
		jlib.implicitWait(driver);
		HomePagePOM home = new HomePagePOM(driver);
		home.prodcutclick();
		int ranNum = jlib.getRandomNum();
		Excel_Utility elib = new Excel_Utility();
		String prodData = elib.getExcelDataFormatter2("Product", 3, 2)+ranNum;
		CreateAndProductDeletePOM prod = new CreateAndProductDeletePOM(driver);
		prod.createProduct();
		prod.product(driver, prodData);
		prod.deleteprod(driver);
	}
}
