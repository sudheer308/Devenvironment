import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment_4 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\BrowserDrivers\\Chrome\\chromedriver_v102.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.get("https://www.abhibus.com/");
		String expected = "Mandapeta";
		String month = "June";
		String dates = "25";

		driver.findElement(By.id("source")).sendKeys("hyd");
		List<WebElement> source = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
		System.out.println(source.size());
		for (int i = 0; i < source.size(); i++) {
			System.out.println(source.get(i).getText());
			if (source.get(i).getText().equals("Hyderabad Airport RGIA")) {
				source.get(i).click();
				break;
			}
		}
		driver.findElement(By.id("destination")).sendKeys("man");
		List<WebElement> destination = driver.findElements(By.xpath("//ul[@id='ui-id-2']/li"));
		System.out.println(destination.size());
		for (int i = 0; i < destination.size(); i++) {
			System.out.println(destination.get(i).getText());
			if (destination.get(i).getText().equals("Mandapeta")) {
				destination.get(i).click();
				break;
			}
		}
		driver.findElement(By.xpath("//a[@class='twowaychang']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("source")).click();
		String actual = driver.findElement(By.id("source")).getAttribute("value");
		System.out.println("the value of " + actual);
		Assert.assertEquals(actual, expected);

		driver.findElement(By.id("datepicker1")).click();
		driver.findElement(By.className("ui-datepicker-title")).getText();

		while (!driver.findElement(By.className("ui-datepicker-title")).getText().contains(month)) {
			driver.findElement(By.className("ui-icon-circle-triangle-e")).click();
		}

		List<WebElement> date = driver.findElements(
				By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table/tbody/tr/td"));
		for (int i = 0; i < date.size(); i++) {
			if (date.get(i).getText().equals(dates)) {
				date.get(i).click();
				break;
			}
		}
	}

}
