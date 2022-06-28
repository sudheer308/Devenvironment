package satish;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class S_03_ExtractPassword {

	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\BrowserDrivers\\Chrome\\chromedriver_v100.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		driver.findElement(By.xpath("//form/input[@placeholder='Name']")).sendKeys("Satish");
		driver.findElement(By.cssSelector("form input[placeholder='Email']")).sendKeys("satish@gmail.com");
		driver.findElement(By.xpath("//form/*[@placeholder='Phone Number']")).sendKeys("9999999999");
		driver.findElement(By.xpath("//button[contains(@class,'reset-pwd-btn')]")).click();
		
		String passwordText = getPassword(driver);
		
		driver.findElement(By.xpath("//button[starts-with(text(),'Go to Login')]")).click();
		
		Thread.sleep(500);
		driver.findElement(By.id("inputUsername")).sendKeys("Satish");
		driver.findElement(By.name("inputPassword")).sendKeys(passwordText);
		driver.findElement(By.xpath("//input[@id='chkboxOne']")).click();
		driver.findElement(By.id("chkboxTwo")).click();
		
		driver.findElement(By.cssSelector("button.signInBtn")).click();
	}
	
	public static String getPassword(WebDriver driver) {
		String getPasswordText = driver.findElement(By.cssSelector("form p.infoMsg")).getText();
		String[] passwordArr = getPasswordText.split("'");
		return passwordArr[1];
	}
}
