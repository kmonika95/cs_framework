package com.Base;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility {

	public static String getDataProviderExcelSheet(int row, int cell) throws EncryptedDocumentException, IOException  {
		String data;
		FileInputStream excel = new FileInputStream("C://Users//monik//eclipse-workspace//api_testing//QDTASHRM//src//test//resources//excelData.xlsx");
		Sheet Inputdata = WorkbookFactory.create(excel).getSheet("Sheet1");
		try {
			data = Inputdata.getRow(row).getCell(cell).getStringCellValue();
		}catch (Exception e) {
			Long intdata = (long) Inputdata.getRow(row).getCell(cell).getNumericCellValue();
		
		data = "" +intdata;}
		return data;}

}
