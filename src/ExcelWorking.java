import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWorking {
//	ArrayList<String> a = new ArrayList<String>();
	public ArrayList<String> getdata(String testcaseName) throws IOException {
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("E:\\Testing\\ExcelSampleData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetAt(i).getSheetName().equalsIgnoreCase("testdata1")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				while (rows.hasNext()) {
					Row row = rows.next();
					Iterator<Cell> cell = row.cellIterator();
					int k = 0;
					int col = 0;
					while (cell.hasNext()) {
						Cell value = cell.next();
						if (value.getStringCellValue().equalsIgnoreCase("Testcases")) {
							col = k;
						}
						k++;
					}
					while (rows.hasNext()) {
						Row row1 = rows.next();
						if (row1.getCell(col).getStringCellValue().equalsIgnoreCase(testcaseName)) {
							Iterator<Cell> c = row1.cellIterator();
							while (c.hasNext()) {
								Cell c1 = c.next();
								if(c1.getCellType() == CellType.STRING) {
									a.add(c1.getStringCellValue());
								}else 
								{
									a.add(NumberToTextConverter.toText(c1.getNumericCellValue()));				
								}
							}
						}
					}
				}
			}
		}
		return a;
	}

	public static void main(String[] args) throws IOException {
	ExcelWorking ew = new ExcelWorking();
	ArrayList excelData = ew.getdata("Pipes");
	System.out.println(excelData.get(0));
	System.out.println(excelData.get(1));
	System.out.println(excelData.get(2));
	
	
	
	////Without return values from method
	//  ew.getdata("Pipes");
	//	System.out.println(ew.a.get(0));
	//	System.out.println(ew.a.get(1));
	//	System.out.println(ew.a.get(2));
	//	System.out.println(ew.a.get(3));
	//	System.out.println(ew.a.get(4));

	}

}
