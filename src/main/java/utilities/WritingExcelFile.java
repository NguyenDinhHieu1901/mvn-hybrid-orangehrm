package utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingExcelFile {

	public static void main(String[] args) throws IOException {
		WritingExcelFile writingExcelFile = new WritingExcelFile();
		writingExcelFile.writingExcelFile(System.getProperty("user.dir") + File.separator + "excelFile" + File.separator + "Register Data.xlsx");
	}

	public void writingExcelFile(String filePathExcel) throws IOException {
		int rowNum = 0;

		// 1 - Create a blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();

		// 2 - Create a sheet and named it
		XSSFSheet sheet = workbook.createSheet("Register Data");

		// 3 - Create a row
		XSSFRow row;

		// This data needs to be written Object[]
		Map<String, Object[]> registerData = new HashMap<>();
		registerData.put("1", new Object[] { "First Name", "Last Name", "Email", "Password", "Confirm Password" });
		registerData.put("2", new Object[] { "as1", "as1", "asas1@gmail.net", "123456", "123456" });
		registerData.put("3", new Object[] { "as1", "as1", "asas2@gmail.net", "123456", "123456" });
		registerData.put("4", new Object[] { "as1", "as1", "asas3@gmail.net", "123456", "123456" });
		registerData.put("5", new Object[] { "as1", "as1", "asas4@gmail.net", "123456", "123456" });
		registerData.put("6", new Object[] { "as1", "as1", "asas5@gmail.net", "123456", "123456" });

		Set<String> keyId = registerData.keySet();

		// 4 - Add cell to sheet

		for (String key : keyId) {
			row = sheet.createRow(rowNum++);
			Object[] objectArr = registerData.get(key);
			int cellId = 0;

			for (Object obj : objectArr) {
				Cell cell = row.createCell(cellId++);
				cell.setCellValue((String) obj);
			}
		}

		// 5 - Writing the workbook into the file
		FileOutputStream output = new FileOutputStream(new File(filePathExcel));
		workbook.write(output);
		output.close();
	}

}
