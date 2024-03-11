package com.QDTAS_HRM;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.Utility.XLUtils;

public class ExcelUtils {
	/*@DataProvider (name="empDataProviderUpdate")
	public static String getDataProviderExcelSheet(int row, int cell) throws IOException {
		String data;
		FileInputStream excel = new FileInputStream("C://Users//monik//eclipse-workspace//api_testing//QDTASHRM//src//test//resources//excelData.xlsx/");
		Sheet Inputdata = WorkbookFactory.create(excel).getSheet("Sheet1");
		try {
			data = Inputdata.getRow(row).getCell(cell).getStringCellValue();
			
		}catch (Exception e) {
			Long intdata = (long) Inputdata.getRow(row).getCell(cell).getNumericCellValue();
		
		data = "" +intdata;}
		return data;}
	*/
	/*@DataProvider (name="empDataProviderUpdate")
    public String [][]dataDrivenTest() throws IOException {
  	 String path= System.getProperty("user.dir")+"/src/test/resources/excelData.xlsx";
    int rownum= XLUtils.getRowCount(path, "Sheet1");
    int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
    String[][] empdata =new String[rownum][colcount];
  	    	empdata[rownum][colcount] = XLUtils.getCellData(path, "Sheet1", 4, 1);
    return(empdata);
    */
    
	
	
	
	
	
	
	
	
	
	
	
	/* public ExcelUtils (String excelsheetpath, String sheetname) {
		 
	 try {
	 
	 wb = new XSSFWorkbook (excelsheetpath);
	 ws = wb.getSheet(sheetname); }
	 catch(Exception e) {
		 System.out.println("Exception message :" + e.getMessage());
		 System.out.println("Exception Cause :"+ e.getCause());
	 }}
	 @DataProvider (name="empDataProviderUpdate")
	public static Object getCellData (int rowNum, int colNum) {
		DataFormatter formatter = new DataFormatter();
		Object value = formatter.formatCellValue(ws.getRow(rowNum).getCell(colNum));
		
		return value;
	}*/
}
