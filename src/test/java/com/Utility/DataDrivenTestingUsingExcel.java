package com.Utility;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTestingUsingExcel {
 
	@DataProvider (name="empDataProvider")
    public String[][] dataDrivenTest() throws IOException {
  	 String path= System.getProperty("user.dir")+"/src/test/resources/excelData.xlsx";
    int rownum= XLUtils.getRowCount(path, "Sheet1");
    int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
    String empdata [][] =new String[rownum][colcount];
    for(int i =1; i<=rownum;i++) {
  	  for (int j= 0; j<colcount;j++) {
  		  empdata [i-1][j]= XLUtils.getCellData(path,"Sheet1",i,j);
  	  }
    }
    return(empdata);

    
    }
}