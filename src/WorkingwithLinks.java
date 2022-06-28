import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingwithLinks {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\BrowserDrivers\\Chrome\\chromedriver_v100.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		
		//get the size of links in a total page
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//get the size of links in a footer
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));   
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		
		//click on first column links
		WebElement columnLinks = footerdriver.findElement(By.xpath("(//table/tbody/tr/td/ul)[1]"));
		System.out.println(columnLinks.findElements(By.tagName("a")).size());
		
		for(int i=1;i<columnLinks.findElements(By.tagName("a")).size();i++) {
			
			String clickLink=Keys.chord(Keys.CONTROL,Keys.ENTER);
			columnLinks.findElements(By.tagName("a")).get(i).sendKeys(clickLink);
			
		}
			Set<String> fLinks = driver.getWindowHandles(); //4
			Iterator<String> iLinks = fLinks.iterator();
			
			while(iLinks.hasNext()) {
			       driver.switchTo().window(iLinks.next());
			       System.out.println(driver.getTitle());
			}
			
		}
		
		
	
		

	}


