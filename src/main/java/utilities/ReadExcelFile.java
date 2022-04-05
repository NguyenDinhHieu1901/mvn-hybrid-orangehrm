package utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	XSSFWorkbook workBook;
	XSSFSheet sheet;

	public ReadExcelFile(String excelFilePath) {
		try {
			File s = new File(excelFilePath);
			FileInputStream stream = new FileInputStream(s);
			workBook = new XSSFWorkbook(stream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getData(int sheetNumber, int row, int column) {
		sheet = workBook.getSheetAt(sheetNumber);
		DataFormatter formatter = new DataFormatter();
		Cell cell = sheet.getRow(row).getCell(column);
		String data = formatter.formatCellValue(cell);
		System.out.println(data);
		return data;
	}

	public String getData(String sheetName, int row, int column) {
		sheet = workBook.getSheet(sheetName);
		DataFormatter formatter = new DataFormatter();
		Cell cell = sheet.getRow(row).getCell(column);
		String data = formatter.formatCellValue(cell);
		return data;
	}

	public int getRowCount(int sheetIndex) {
		int row = workBook.getSheetAt(sheetIndex).getLastRowNum();
		row = row + 1;
		return row;
	}
}
