package orangeHRM.utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] getExcelData(String fileName)  {
		
		XSSFWorkbook wbook = null;
		try {
			wbook = new XSSFWorkbook("./data/"+fileName+".xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = wbook.getSheetAt(0);
		int noOfRows = sheet.getLastRowNum(); //excludes the header row.
		int noOfRowsWithHeader = sheet.getPhysicalNumberOfRows(); //includes the header row
		System.out.println("No of rows exclusive of the header is "+noOfRows);
		System.out.println("No of rows inclusive of the header is "+noOfRowsWithHeader);
		short noOfColumns = sheet.getRow(0).getLastCellNum();
		System.out.println("No of columns is "+noOfColumns);
		String[][] data = new String[noOfRows][noOfColumns];
		for (int i = 1; i <=noOfRows; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < noOfColumns; j++) {
				XSSFCell cell = row.getCell(j);
				  DataFormatter dft = new DataFormatter();
				  String value =dft.formatCellValue(cell);
				//String value2 = cell.getStringCellValue();
				//System.out.println(value);
				  data[i-1][j]=value; //since i is initialised as 1, to get i value as 0, we provide i-1
			} 
		}
		try {
			wbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
			
	}

}
