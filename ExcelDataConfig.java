package newTestScript;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig 
{

	XSSFWorkbook wb;
	XSSFSheet sheet1;
	
	public ExcelDataConfig (String excelpath)
	{
	    try 
	    {
			File src=new File(excelpath);
			
			FileInputStream fls=new FileInputStream(src);	
			
			wb=new XSSFWorkbook(fls);
		} 
	    catch (Exception e) 
	    {
			System.out.println(e.getMessage());
		} 
	    
	}
	
	public String getData(int SheetNumber,int row,int column) 
	{
	    sheet1=wb.getSheetAt(SheetNumber);
	    
	    String data;
	    
	    data=sheet1.getRow(row).getCell(column).getStringCellValue();
	    
	    return data;

	}
	
	public int rowCount(int SheetIndex) 
	{
		int row=wb.getSheetAt(SheetIndex).getLastRowNum();
		
		row=row+1;
		
		return row;
	}
	
}