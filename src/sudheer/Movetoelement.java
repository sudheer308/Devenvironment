package sudheer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Movetoelement {
	@Test
	public void movetoelement() {
		
		System.setProperty("webdriver.chrome.driver","E:\\Testing\\BrowserDrivers\\Chrome\\chromedriver_v102.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://in.1x001.com/en/line/cricket/1004937-twenty20-1st-series-twenty20/137932246-canada-nepal");
		WebElement promo =driver.findElement(By.xpath("//header //ul/li/a/span[contains(text(),'PROMO')]"));
		Actions ac = new Actions(driver);
		ac.moveToElement(promo).build().perform();
	}

}
