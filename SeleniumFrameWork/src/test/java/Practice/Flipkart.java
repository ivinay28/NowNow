package Practice;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Flipkart {

	public static void main(String[] args) 
	{
		File file = new File("D:\\output.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sh = wb.createSheet();
		sh.createRow(0).createCell(0).setCellValue("Age");
		
		try 
		{
			FileOutputStream fos = new FileOutputStream(file);
			wb.write(fos);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
