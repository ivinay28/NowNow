package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DataProvider.Excel_Utility;

public class DataProviderWithExcel 
{
	
	@Test(dataProvider="dataProvider")
	public void bookTickets(String src,String dest)
	{
		System.out.println("Book tickets from "+src+" to "+dest);
	}
	
	@DataProvider
	public Object[][] dataProvider() throws Throwable
	{
		
		/*
		 * objarr[0][0]=ex.getExcelData("DataProvider", 1, 0);
		 * objarr[0][1]=ex.getExcelData("DataProvider", 1, 1);
		 * 
		 * objarr[1][0]=ex.getExcelData("DataProvider", 2, 0);
		 * objarr[1][1]=ex.getExcelData("DataProvider", 2, 1);
		 * 
		 * objarr[2][0]=ex.getExcelData("DataProvider", 3, 0);
		 * objarr[2][1]=ex.getExcelData("DataProvider", 3, 1);
		 */
		
		
		Excel_Utility excel=new Excel_Utility();
//		Object[][] objar=new Object[3][2];
//		for(int i=0;i<3;i++)
//		{
//			for(int j=0;j<2;j++)
//			{
//				objar[i][j]=excel.getExcelData("Sheet1", i, j);
//			}
//		}
		
		Object[][] objar = excel.readMultipleData("Sheet1");
		return objar;
	}
}
