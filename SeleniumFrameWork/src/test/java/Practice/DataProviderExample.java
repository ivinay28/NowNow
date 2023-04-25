package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProviderExample
{
	@Test(dataProvider = "dataprovider")
	public void ticketBooking(String src, String dest)
	{
		System.out.println("Book tickets from "+src+" to "+dest);
	}
	
	@DataProvider
	public Object[][] dataprovider()
	{
		Object[][] objar = new Object[3][2];
		
		objar[0][0]= "Bangalore";
		objar[0][1]= "Goa";
				
		objar[1][0]= "Bangalore";
		objar[1][1]= "Mumbai";

		objar[2][0]= "Bangalore";
		objar[2][1]= "Hyderabad";

		return objar;
		
	}
}
