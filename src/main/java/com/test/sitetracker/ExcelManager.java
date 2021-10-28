package com.test.sitetracker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelManager {

	public void readExcel() throws FileNotFoundException{
		
		File file = new File("/sitetracker/src/main/resource/testdata.xlsx");
		FileInputStream ins = new FileInputStream(file);
		HSSFWorkbook wb = HSSFWorkbook(ins);
		HSSFSheet sheet = wb.getSheet("testdata");
		HSSFRow row = sheet.getRow(1);
		HSSFCell cell = row.getCell(2);
		String url = cell.getStringCellValue();
		
	}

	private HSSFWorkbook HSSFWorkbook(FileInputStream ins) {
		// TODO Auto-generated method stub
		return null;
	}





	


	
}
