import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Fileuplod {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\BrowserDrivers\\Chrome\\chromedriver_v102.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.docfly.com/word-to-pdf");
		driver.manage().window().maximize();
		driver.navigate().refresh();
		Thread.sleep(1000);
	
	
		driver.findElement(By.xpath("//form[@id='s3-uploader']//div//div//i")).click();
		Runtime.getRuntime().exec("E:\\Testing\\Autoit\\wordtopdf.exe");
		
	}

}
