import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_6 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\BrowserDrivers\\Chrome\\chromedriver_v102.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		WebElement middel = driver.findElement(By.xpath("//frameset"));
		driver.switchTo().frame(0);
		List<WebElement> middel2 = driver.findElements(By.tagName("frame"));
		System.out.println(middel2.size());
		driver.switchTo().frame(1);
		System.out.println(driver.findElement(By.id("content")).getText());

	}

}
