import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Waitconditions {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\BrowserDrivers\\Chrome\\chromedriver_v100.exe");
		WebDriver driver = new ChromeDriver();
		// Waitconditions place = new Waitconditions();
		// placeorder(driver);

		driver.get("https://the-internet.herokuapp.com/dynamic_loading");
		driver.findElement(By.xpath("//a[text()='Example 1: Element on page that is hidden']")).click();
		driver.findElement(By.cssSelector("div[id='start'] button")).click();

		// Fluent Wait code
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				if (driver.findElement(By.xpath("//div[@id='finish']/h4")).isDisplayed()) {
					return driver.findElement(By.xpath("//div[@id='finish']/h4"));
				} else
					return null;
			}
		});

		System.out.println(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText());

	}

	public static void placeorder(WebDriver driver) throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		String[] selectedVeggies = { "Cucumber", "Almonds", "Brocolli" };
		List<String> selected = new ArrayList<String>(Arrays.asList(selectedVeggies));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {
			String[] allProducts = products.get(i).getText().split("-");
			String trimVeggie = allProducts[0].trim();
			int j = 0;
			if (selected.contains(trimVeggie)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				j++;
				if (j == selectedVeggies.length) {
					break;
				}

			}

		}
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		WebDriverWait w = new WebDriverWait(driver, 5);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		Assert.assertTrue(driver.findElement(By.cssSelector("span.promoInfo")).isDisplayed());
		
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		List<WebElement> drop = new Select(driver.findElement(By.xpath("//div/select"))).getOptions();
		for (int i = 0; i < drop.size(); i++) {
			String options = drop.get(i).getText();
			if (options.equalsIgnoreCase("india")) {
				drop.get(i).click();
				break;
			}

		}
		driver.findElement(By.cssSelector("input.chkAgree")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();

	}
}
