package satish;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class S_02_ElementLocatorsValidation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String username = "Satish";
        String password = "rahulshettyacademy";
        String sucessMsg = "You are successfully logged in.";
        
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\BrowserDrivers\\Chrome\\chromedriver_v100.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(username);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		
		String successMessage = driver.findElement(By.tagName("p")).getText();
		Assert.assertEquals(successMessage, sucessMsg);
		
	}

}
