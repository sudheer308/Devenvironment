import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadData {

	public static void main(String[] args) throws IOException {
		Properties pro = new Properties();
	    FileInputStream fis = new FileInputStream("E:\\Testing\\Selenium\\01_Basic\\src\\Sample.properties");
	    pro.load(fis);
	    System.out.println(pro.getProperty("Browser"));
        System.out.println(pro.getProperty("url"));
       
        pro.setProperty("browser", "FireFox");
        System.out.println(pro.getProperty("browser"));
        
        FileOutputStream fos = new FileOutputStream("E:\\Testing\\Selenium\\01_Basic\\src\\Sample.properties");
        pro.store(fos, null);
        
        
        
	}

}
