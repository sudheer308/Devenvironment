import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Scrolldown {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","E:\\Testing\\BrowserDrivers\\Chrome\\chromedriver_v102.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,550)");
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTo(0,500)");
		int ep = 296;
		
		List<WebElement>values =driver.findElements(By.xpath("//table[@id='product'] //td[4]"));
		int sum= 0;
		for(int i=0;i<values.size();i++) {
		System.out.println(values.get(i).getText());
		 sum = sum + Integer.parseInt(values.get(i).getText());
		
		}
		System.out.println(sum);
		int ap = Integer.parseInt(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim());
		Assert.assertEquals(ap,ep);
	
	}

}
