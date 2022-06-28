import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Practice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\BrowserDrivers\\Chrome\\chromedriver_v102.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://kubernetes.io");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.findElement(By.id("navbarDropdown")).click();
		List<WebElement> versiondrop = driver
				.findElements(By.xpath("//div[@class='dropdown-menu dropdown-menu-right show']/a"));
		System.out.println(versiondrop.size());
		for (int i = 0; i < versiondrop.size(); i++) {
			String version = versiondrop.get(i).getText();
			if (version.contains("v1.21")) {
				versiondrop.get(i).click();
				break;
			}
		}
		Assert.assertTrue(
				driver.findElement(By.xpath("//div[@class='content deprecation-warning'] //h3")).isDisplayed());
		driver.findElement(
				By.xpath("//div[@class='td-navbar-nav-scroll ml-md-auto'] //li/a[contains(text(),'Documentation')]"))
				.click();
		driver.findElement(By.id("m-docs-tasks")).click();
		JavascriptExecutor scroll = ((JavascriptExecutor) driver);
		scroll.executeScript("document.querySelector('.collapse').scrollTo(0,600)");

		driver.findElement(By.id("m-docs-tasks-tls")).click();
		// driver.navigate().refresh();
		List<WebElement> tlsLinks = driver.findElements(By.xpath("//div[@class='section-index']/div/h5/a"));

		for (int i = 0; i < tlsLinks.size(); i++) {
			String tls = Keys.chord(Keys.CONTROL, Keys.ENTER);
			tlsLinks.get(i).sendKeys(tls);
		}
		Set<String> title = driver.getWindowHandles();
		java.util.Iterator<String> it = title.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
			String childTitle = driver.getTitle();

			if (childTitle.contains("Manual Rotation of CA Certificates | Kubernetes")) {
				JavascriptExecutor js = ((JavascriptExecutor)driver);
				js.executeScript("window.scrollBy(0,2500)");
				Thread.sleep(1000);
			    js.executeScript("document.querySelector('ol ol pre').scrollLeft=200");
				
				break;
			}
		}
	}

}
