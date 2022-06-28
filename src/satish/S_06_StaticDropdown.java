package satish;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class S_06_StaticDropdown {

	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\BrowserDrivers\\Chrome\\chromedriver_v100.exe");
		WebDriver driver = new ChromeDriver();		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement dropdownValues = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(dropdownValues);
		dropdown.selectByIndex(3); // Select based on Index
		dropdown.selectByVisibleText("AED"); // Select based on what ever text showing in dropdown
		dropdown.selectByValue("USD");  // Select based on value which is present in option tag
		                    // or
		driver.findElement(By.xpath("//select/option[@value='USD']")).click();

		System.out.println(driver.findElement(By.xpath("//div[@class='row1 adult-infant-child']/*[@id='divpaxinfo']")).getText());
		driver.findElement(By.xpath("//div[@class='row1 adult-infant-child']/*[@id='divpaxinfo']")).click();
		Thread.sleep(500);
		for(int i=1;i<=3;i++) {
			driver.findElement(By.xpath("//div[@id='divAdult']/div[2]/span[3]")).click();			
		}
		for(int i=1;i<=2;i++) {
			driver.findElement(By.xpath("//div[@id='divChild']/div[2]/span[3]")).click();			
		}
		for(int i=1;i<=3;i++) {
			driver.findElement(By.xpath("//div[@id='divInfant']/div[2]/span[3]")).click();			
		}
		
		
		Thread.sleep(1000);
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='row1 adult-infant-child']/*[@id='divpaxinfo']")).getText());
	}
}
