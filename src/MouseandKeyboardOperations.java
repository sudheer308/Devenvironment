import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseandKeyboardOperations {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\BrowserDrivers\\Chrome\\chromedriver_v102.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.get("https://www.amazon.in/");
		Actions move = new Actions(driver);
		//move to specific Element
		move.moveToElement(driver.findElement(By.id("nav-link-prime"))).build().perform();
		driver.findElement(By.id("multiasins-img-link")).click();
		
		
		WebElement inpubox = driver.findElement(By.cssSelector("input[id=twotabsearchtextbox]"));
        move.moveToElement(inpubox).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
        
	}

}
