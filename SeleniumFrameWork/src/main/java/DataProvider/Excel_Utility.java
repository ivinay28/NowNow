package DataProvider;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility 
{
	public String getExcelData(String sh, int r, int cellNUm) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/DataP.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sh);
		Row row = sheet.getRow(r);
		Cell cell = row.getCell(cellNUm);
		String exceldata = cell.getStringCellValue();
		return exceldata;
	}
	
	public Object[][] readMultipleData(String sheetName) throws Throwable
	{
		FileInputStream fes = new FileInputStream("./src/test/resources/DataP.xlsx");
		Workbook book=WorkbookFactory.create(fes);
		Sheet sh = book.getSheet(sheetName);
		int lastrow = sh.getLastRowNum()+1;
		short lastcell = sh.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[lastrow][lastcell];
		
		for(int i=0;i<lastrow;i++)
		{
			for(int j=0;j<lastcell;j++)
			{
				obj[i][j]	=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj ;
	}
		
	}

