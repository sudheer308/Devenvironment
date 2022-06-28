import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assignment_3 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\BrowserDrivers\\Chrome\\chromedriver_v102.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		String[] totalText = driver.findElement(By.xpath("//p[@class='text-center text-white']")).getText().split(" ");
		String userTxt = totalText[2];
		String passwordTxt = totalText[6].substring(0, totalText[6].length()-1);
		
		
		String[] products = {"iphone X", "Samsung Note 8", "Nokia Edge", "Blackberry"};
		List all = Arrays.asList(products);
		System.out.println(all);
		driver.findElement(By.id("username")).sendKeys(userTxt);
		driver.findElement(By.id("password")).sendKeys(passwordTxt);
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
	    WebDriverWait w = new WebDriverWait(driver,5);
	    w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='okayBtn']")));
        driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
        driver.findElement(By.xpath("//form //select/option[@value='consult']")).click();
        WebElement dropList = driver.findElement(By.xpath("//form //select"));
		Select drop = new Select(dropList);
	    drop.selectByVisibleText("Consultant");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.name("signin")).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());
        
		List<WebElement> allMobiles = driver.findElements(By.xpath("//h4[@class='card-title']"));
		System.out.println(allMobiles.size());
		for(int i=0;i<allMobiles.size();i++) {
			String p = allMobiles.get(i).getText();
			System.out.println(p);
			if(all.get(i).equals(p)) {
				List<WebElement>addButton = driver.findElements(By.xpath("//div[@class='card-footer'] //button"));
				addButton.get(i).click();
				
			}
		}
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
		
		
	}

}
