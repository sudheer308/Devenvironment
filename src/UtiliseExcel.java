import java.io.IOException;
import java.util.List;

public class UtiliseExcel {

	public static void main(String[] args) throws IOException {
	ExcelWorking utilise = new ExcelWorking();
	List li = utilise.getdata("Stocks");
	System.out.println(li.get(0));
	System.out.println(li.get(1));
	System.out.println(li.get(2));
	}

}
