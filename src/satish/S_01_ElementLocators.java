package satish;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class S_01_ElementLocators {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\BrowserDrivers\\Chrome\\chromedriver_v100.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("satish");
		driver.findElement(By.name("inputPassword")).sendKeys("dummy");
		driver.findElement(By.className("signInBtn")).click();
				
		//Compare Error message both are equal or not
		String dynamicErrorMsg = driver.findElement(By.xpath("//p[@class='error']")).getText();
		String staticErrorMsg = "* Incorrect username or password";
		if(dynamicErrorMsg.equals(staticErrorMsg)) {
			System.out.println("Both are equal");
		}
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//form/input[@placeholder='Name']")).sendKeys("satish");
		driver.findElement(By.xpath("//form/input[@placeholder='Email']")).sendKeys("satish@gmail.com");
		driver.findElement(By.xpath("//form/input[@placeholder='Phone Number']")).sendKeys("9177267370");
		driver.findElement(By.className("reset-pwd-btn")).click();

		Thread.sleep(500);
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[contains(@class,'login')]")).click();
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[class*,'logi')]")).click();

		Thread.sleep(500);
		driver.findElement(By.id("inputUsername")).sendKeys("satish");
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.id("chkboxTwo")).click();
		driver.findElement(By.className("signInBtn")).click();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class='logout-btn']")).click();
	
		//visit website
		driver.findElement(By.xpath("//button[@id='visitUsTwo']")).click();
		
	}
}
