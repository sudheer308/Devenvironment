package sudheer;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframes {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\BrowserDrivers\\Chrome\\chromedriver_v102.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://kubernetes.io/training/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2700)");
		driver.switchTo().frame(0);
	    js.executeScript("document.querySelector('.sidebar-scroll').scrollTo(0,100)");
	    driver.switchTo().defaultContent();
	    
		

	}

}
