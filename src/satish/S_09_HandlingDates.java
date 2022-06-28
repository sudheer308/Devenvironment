package satish;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class S_09_HandlingDates {

	public static void main(String[] args) throws InterruptedException {

		String noOfPassengers = "3 Adult";
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\BrowserDrivers\\Chrome\\chromedriver_v100.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@value='HYD']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='IXL']"))
				.click();
		driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight ui-state-hover']")).click();

		// getAttribute styles & check attribute value present or not
		Assert.assertTrue((driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style")).contains("0.5"));

		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		for (int i = 1; i <= 2; i++) {
			driver.findElement(By.xpath("//div[@id='divAdult'] //span[@id='hrefIncAdt']")).click();
		}

		Assert.assertEquals(noOfPassengers, driver.findElement(By.id("divpaxinfo")).getText());
		driver.findElement(By.xpath("//input[@id='btnclosepaxoption']")).click();

		Thread.sleep(1000);
		driver.findElement(By.cssSelector("option[value='AED']")).click();
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']")).click();

	}

}
