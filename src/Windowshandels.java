import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windowshandels {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\BrowserDrivers\\Chrome\\chromedriver_v100.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> windows = driver.getWindowHandles();  
		Iterator<String> it= windows.iterator();
		String parenId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		String valueOf = driver.findElement(By.xpath("//h3/span")).getText().split("Jmeter,")[1].split(",")[0].trim();
		driver.switchTo().window(parenId);
		driver.findElement(By.id("username")).sendKeys(valueOf);

		
	}

}
