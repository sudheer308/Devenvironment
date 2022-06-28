import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Autosuggistivedropdown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\BrowserDrivers\\Chrome\\chromedriver_v102.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.get("https://www.amazon.in/");
		driver.navigate().refresh();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop");
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='autocomplete-results-container']/div/div"));
		System.out.println(list.size());

		try {
			for (int i = 0; i < list.size(); i++) {
				System.out.println("list.get(i).getText : " + list.get(i).getText());
				if (list.get(i).getText().equalsIgnoreCase("laptop")) {
					list.get(i).click();
					break;
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		/*
		 * driver.get("https://www.swiggy.com/");
		 * driver.findElement(By.id("location")).sendKeys("mandapeta");
		 * List<WebElement>locations =
		 * driver.findElements(By.xpath("//div[@class='_1oLDb']/div/span")); for(int
		 * i=0;i<locations.size();i++) { System.out.println(locations.get(i).getText());
		 * if(locations.get(i).getText().contains("Ramachandrapuram Road")){
		 * locations.get(i).click(); } }
		 */

	}
}
