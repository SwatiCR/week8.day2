package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadData {

	public static String[][] readData(String excelFileName) throws IOException {
		XSSFWorkbook wbook = new XSSFWorkbook("data/"+excelFileName+".xlsx");
		XSSFSheet sheet = wbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		short cellCount = sheet.getRow(0).getLastCellNum();

		System.out.println(rowCount);
		System.out.println(cellCount);

		String[][] data = new String[rowCount][cellCount];

		for(int i=1 ; i<=rowCount ; i++) {
			XSSFRow row = sheet.getRow(i);
			for(int j=0 ; j<cellCount ; j++) {
				XSSFCell cell = row.getCell(j);
				String value = cell.getStringCellValue();
				//System.out.println(value);
				data[i-1][j] = value;
			}
		}
		wbook.close();
		return data;

	}

}
