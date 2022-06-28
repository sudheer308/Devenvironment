import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Usingstreams {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\BrowserDrivers\\Chrome\\chromedriver_v102.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		driver.findElement(By.xpath("//a[text()='Top Deals']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> veg = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		List<String>original = veg.stream().map(v->v.getText()).collect(Collectors.toList());
		List<String>sorted = original.stream().sorted().collect(Collectors.toList());
		sorted.stream().forEach(f->System.out.println(f));
		Assert.assertEquals(original, sorted);
		List<String> price;
		do {
			List<WebElement> row = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		 price = row.stream().filter(s->s.getText().contains("Pineapple")).map(s->getprice(s)).collect(Collectors.toList());
		price.forEach(p->System.out.println(p));
		
		if(price.size()<1) {
			driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
		}
		}while(price.size()<1);
		
	}	
		
		

	private static String getprice(WebElement s) {
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}



}
