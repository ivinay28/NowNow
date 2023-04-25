package Generic_Utility;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility 
{
	/**
	 * //this file is used to fetch excel data value
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 * @author Vinay
	 */ 
	
	public String getExcelData(String sheetName, int rowNum, int cellNum) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/Book1.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String conData = cell.getStringCellValue();
		return conData;
	}
	
	public String getExcelDataFormatter(String sheetName, int rowNum, int cellNum) throws Throwable 
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/Book1.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		DataFormatter format = new DataFormatter();
		String data = format.formatCellValue(book.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
		return data;	
	}


	public String getExcelDataFormatter2(String sh, int r, int c) throws Throwable
	{
		FileInputStream fis2=new FileInputStream("./src/test/resources/Product.xlsx");
		Workbook book2 = WorkbookFactory.create(fis2);
		DataFormatter format2 = new DataFormatter();
		String data2 = format2.formatCellValue(book2.getSheet(sh).getRow(r).getCell(c));
		return data2;
	}
	
	public String getExcelDataFormatter3(String sh, int r, int c) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/Campaign.xlsx");
		Workbook book2 = WorkbookFactory.create(fis);
		DataFormatter format = new DataFormatter();
		String data = format.formatCellValue(book2.getSheet(sh).getRow(r).getCell(c));
		return data;
	}
	public String getExcelDataFormatter4(String sh, int r, int c) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/SalesOrder.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		DataFormatter format = new DataFormatter();
		String value = format.formatCellValue(book.getSheet(sh).getRow(r).getCell(c));
		return value;
		
	}
}

	