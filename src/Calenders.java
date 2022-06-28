import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calenders {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\BrowserDrivers\\Chrome\\chromedriver_v100.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		String date = "Sep";
		String eDate = "24";
		driver.findElement(By.className("text-trans-uc")).click();
		WebElement month = driver.findElement(By.xpath("//div[@class='rb-calendar'] //td[@class='monthTitle']"));
		//String monthTitle = month.getText();
        
		while(!driver.findElement(By.xpath("//div[@class='rb-calendar'] //td[@class='monthTitle']")).getText().contains(date)) {
		driver.findElement(By.xpath("//div[@class='rb-calendar'] //td[@class='next']")).click();	
		}
	
		
		List<WebElement> alld =driver.findElements(By.xpath("//div[@class='rb-calendar'] //tbody/tr/td"));
		System.out.println(alld.size());
		for(int i=2;i<alld.size();i++) {
			String d = alld.get(i).getText();
			if(d.equals(eDate)){
				alld.get(i).click();
				break;
			}
		}

	}

}
