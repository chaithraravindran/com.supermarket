package com.supermarket.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Excel {
	HSSFSheet sheet;
	HSSFWorkbook workbook;

	HSSFRow row;
	HSSFCell cell;

	public void setExcelFile(String workBookName, String sheetName) 
	{
		String path = System.getProperty("user.dir") + "\\src\\main\\resources\\ExcelFiles\\" + workBookName + ".xls";
		try 
		{
			File src = new File(path);
			FileInputStream fi = new FileInputStream(src);

			workbook = new HSSFWorkbook(fi);
			sheet = workbook.getSheet(sheetName);

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public String getCellData(int rowNo, int columnNo) 
	{
		row = sheet.getRow(rowNo);
		cell = row.getCell(columnNo);

		switch (cell.getCellType()) 
		{
		case STRING: 
		{
			String x;
			x = cell.getStringCellValue();
			return x;
		}
		case NUMERIC: 
		{
			long d = (long) cell.getNumericCellValue();
			return String.valueOf(d);
		}

		default:
			return null;

		}

	}

}
