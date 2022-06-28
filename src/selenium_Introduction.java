import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class selenium_Introduction {

	public static void main(String[] args) throws InterruptedException {
		// chrome Browser
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\BrowserDrivers\\Chrome\\chromedriver_v100.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Firefox Browser
		// System.setProperty("webdriver.gecko.driver",
		// "E:\\Testing\\BrowserDrivers\\Mozilla\\geckodriver.exe");
		// WebDriver driver = new FirefoxDriver();

		// Microsoft edge Browser
		// System.setProperty("webdriver.edge.driver",
		// "E:\\Testing\\BrowserDrivers\\Edge\\msedgedriver_v100.exe");
		// WebDriver driver = new EdgeDriver();
		error(driver);
		driver.get("https://www.indiainfoline.com/");
		driver.findElement(By.id("open_leadMobileNo")).sendKeys("9553054951");
		driver.findElement(By.name("open_leadEmail")).sendKeys("error");

		// driver.findElement(By.xpath("//div[@class='centerbut']/button[@id='open_sidebarleadFormBtn']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		// driver.findElement(By.name("open_sidebarleadFormBtn")).click();
		// driver.findElement(By.cssSelector("#open_sidebarleadFormBtn")).click();
		//
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@id='open_sidebarleadFormBtn'])[1]")).click();
		// String validate =
		// driver.findElement(By.xpath("//span[@id='request_open_lead_email_error_message']")).getText();
		// boolean yes = validate.equals("Please enter valid Email");
		// System.out.println(yes);
		/*
		 * String msg = driver.findElement(By.xpath(
		 * "//span[@id='request_open_lead_email_error_message']")).getText(); String[]
		 * eachword = msg.split(" "); for (String error : eachword) {
		 * System.out.println(error); } System.out.println(eachword[2]);
		 * driver.findElement(By.name("open_leadEmail")).clear();
		 * driver.findElement(By.name("open_leadEmail")).sendKeys("valid");
		 */
	}

	public static String error(WebDriver driver) throws InterruptedException {
		driver.get("https://www.indiainfoline.com/");
		driver.findElement(By.id("open_leadMobileNo")).sendKeys("9553054951");
		driver.findElement(By.name("open_leadEmail")).sendKeys("sudheer");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@id='open_sidebarleadFormBtn'])[1]")).click();
		String msg = driver.findElement(By.xpath("//span[@id='request_open_lead_email_error_message']")).getText();
		String[] eachword = msg.split(" ");
		String inputs = eachword[2];
		return inputs;
	}

}
