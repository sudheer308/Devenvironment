package codingstuff;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperations {
	public static ArrayList<String> getdata(String TestcaseName) throws IOException {

		ArrayList<String> str = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("E:\\Testing\\ExcelSampleData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("testdata1")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				while (rows.hasNext()) {
					Row r = rows.next();
					Iterator<Cell> cell = r.cellIterator();
					int k = 0;
					int col = 0;
					while (cell.hasNext()) {
						Cell value = cell.next();
						if (value.getStringCellValue().equalsIgnoreCase("Testcases")) {
							col = k;
						}
						k++;
					}
					System.out.println(col);
					while (rows.hasNext()) {
						Row r1 = rows.next();
						if (r1.getCell(col).getStringCellValue().equalsIgnoreCase(TestcaseName)) {
							Iterator<Cell> c = r1.cellIterator();
							while (c.hasNext()) {
                                 Cell e= c.next();
								str.add(c.next().getStringCellValue());
							}
						}
					}
				}

			}
		}
		return str;

	}

	public static void main(String[] args) throws IOException {
		System.out.println(getdata("pipes"));
		List data = getdata("pipes");
	
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		
		
	}

}
