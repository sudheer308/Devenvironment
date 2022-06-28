package satish;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class S_05_DriverManagement {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\BrowserDrivers\\Chrome\\chromedriver_v100.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.getTitle();
		driver.navigate().to("https://rahulshettyacademy.com/");
		Thread.sleep(1000);
		driver.navigate().back();
		driver.navigate().forward();
	}
}
