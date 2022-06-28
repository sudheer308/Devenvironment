import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Sslcertificate {

	public static void main(String[] args) {
		/*
		 * ChromeOptions option = new ChromeOptions();
		 * option.setAcceptInsecureCerts(true);
		 * System.setProperty("webdriver.chrome.driver",
		 * "E:\\Testing\\BrowserDrivers\\Chrome\\chromedriver_v102.exe"); WebDriver
		 * driver = new ChromeDriver(option);
		 */

		 //Handle SSL Certificates
		  FirefoxOptions options = new FirefoxOptions();
		  options.setAcceptInsecureCerts(true);
		  
		  
		  //set proxy
		  Proxy pro = new Proxy();
		  pro.setHttpProxy("172.19.96.4:30443");
		  options.setCapability("proxy", pro);
		  System.setProperty("webdriver.gecko.driver","E:\\Testing\\BrowserDrivers\\Mozilla\\geckodriver.exe"); 
		  WebDriver driver = new FirefoxDriver();
		 
		
			/*
			 * EdgeOptions options = new EdgeOptions();
			 * options.setAcceptInsecureCerts(true);
			 * System.setProperty("webdriver.edge.driver",
			 * "E:\\Testing\\BrowserDrivers\\Edge\\msedgedriver_v102.exe"); WebDriver driver
			 * = new EdgeDriver(options);
			 */
		

		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());

	}

}
