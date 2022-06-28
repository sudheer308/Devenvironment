package sudheer;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Screenshot {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\BrowserDrivers\\Chrome\\chromedriver_v102.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://kubernetes.io/docs/tasks/tls/manual-rotation-of-ca-certificates/");
		getscroll(driver);
		getscreenshot(driver);
	    driver.findElement(By.name("q")).sendKeys("pod" + "\n");
        driver.findElement(By.xpath("//div[@class='gsc-webResult gsc-result'][1] //a[@class='gs-title'][1]")).click();
      
     
        
        
		 
		
		

		
		
	}
	public static void getscreenshot(WebDriver driver) throws IOException {
		File windowScrollsnap = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(windowScrollsnap, new File("E:\\Testing\\Screenshots\\scrollpng.png"));
		
		WebElement scrollWeb = driver.findElement(By.xpath("(//div/pre)[1]"));
		File src = scrollWeb.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("E:\\Testing\\Screenshots\\scrollpng2.png"));
		
	}
	
	
	public static void getscroll(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1600)");
		
		js.executeScript("document.querySelector('.collapse').scrollBy(0,3000)");
		js.executeScript("document.querySelector('.highlight pre').scrollLeft=3000");
	}

}


