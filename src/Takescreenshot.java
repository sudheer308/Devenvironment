import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Takescreenshot {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\BrowserDrivers\\Chrome\\chromedriver_v102.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");

		Object js = ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");

		File SrcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(SrcFile, new File("E:\\Testing\\Screenshots\\google1.png"));

		// or

		TakesScreenshot src = ((TakesScreenshot) driver);
		File srcFile = src.getScreenshotAs(OutputType.FILE);
		File desFile = new File("E:\\Testing\\Screenshots\\google2.png");
		FileUtils.copyFile(srcFile, desFile);

	}

}
