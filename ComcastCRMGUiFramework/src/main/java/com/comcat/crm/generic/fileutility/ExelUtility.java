package com.comcat.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExelUtility {
	public String getDataFromExcel(String sheetName,int rowNum,int celNum) throws Throwable {
		 FileInputStream fis=new FileInputStream("./testData/organization.xlsx");
		    Workbook wb=WorkbookFactory.create(fis);
		    String data=wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		    wb.close();
		return data;
	}

	
	
	
	
	
	

public int getLastRowCount(String sheetName) throws Throwable, IOException {
	 FileInputStream fis=new FileInputStream("./testData/organization.xlsx");
	    Workbook wb=WorkbookFactory.create(fis);
	    int lastrw = wb.getSheet(sheetName).getLastRowNum();
	    wb.close();
	    return lastrw;
}

public void setdataIntoExel(String sheetName,int rowNum,int celNum,String data) throws Throwable {
	FileInputStream fis=new FileInputStream("./testData/organization.xlsx");
    Workbook wb=WorkbookFactory.create(fis);
    Cell cell = wb.getSheet(sheetName).getRow(rowNum).createCell(celNum);
    cell.setCellType(CellType.STRING);
	cell.setCellValue(data);
    
    FileOutputStream fos=new FileOutputStream("./testData/organization.xlsx");
    wb.write(fos);
    wb.close();
    
}
}