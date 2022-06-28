package sudheer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperations {

	public static void main(String[] args) throws IOException {

	}

	public ArrayList<String> getData() throws IOException {

		ArrayList<String> str = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("E:\\Testing\\ExcelSampleData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("TestData2")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> row = sheet.iterator();
				while (row.hasNext()) {
					Row FirstRow = row.next();
					Iterator<Cell> ce = FirstRow.cellIterator();
					int k = 0;
					int coloumn = 0;
					while (ce.hasNext()) {
						Cell value = ce.next();
						if (value.getStringCellValue().equalsIgnoreCase("testcases")) {
							coloumn = k;
						}
						k++;
					}
					System.out.println(coloumn);
					while (row.hasNext()) {
						Row r = row.next();
						if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase("Machines")) {
							Iterator<Cell> cel = r.cellIterator();
							while (cel.hasNext()) {

								str.add(cel.next().getStringCellValue());
							}
						}
					}
				}

			}
		}
		return str;
	}
}
