import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class creatingmethod_dynamicvaluespassing {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\BrowserDrivers\\Chrome\\chromedriver_v100.exe");
		WebDriver driver = new ChromeDriver();
		geterrormsg(driver);
		driver.get("https://www.timeanddate.com/custom/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
	    //Thread.sleep(1000);
		driver.findElement(By.xpath("//i[@class='i-font i-account_circle site-nav__desktop-title']")).click();
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sudheer.andra@gmail.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("geterrormsg");
        //driver.findElement(By.id("create")).click();
        //Thread.sleep(1000);
        //System.out.println(driver.findElement(By.id("errormessage")).getText());
	}
	
	public static String geterrormsg(WebDriver driver) throws InterruptedException {
		driver.get("https://www.timeanddate.com/custom/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.findElement(By.xpath("//i[@class='i-font i-account_circle site-nav__desktop-title']")).click();
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sudheer.andra@gmail.com");
        driver.findElement(By.id("create")).click();
        Thread.sleep(1000);
        String msg = driver.findElement(By.id("errormessage")).getText();
        String[] splittingwords = msg.split("-");
        String values = splittingwords[1];
        return values;
        
	}

}
