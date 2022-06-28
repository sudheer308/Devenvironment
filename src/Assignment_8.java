import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_8 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\BrowserDrivers\\Chrome\\chromedriver_v102.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,550)");
		System.out.println("Rows count " + driver.findElements(By.xpath("//fieldset/table/tbody/tr")).size());
		System.out.println("Column count " + driver.findElements(By.xpath("//fieldset/table/tbody/tr/th")).size());
		System.out.println(driver.findElement(By.xpath("//fieldset/table/tbody/tr[1]")).getText());
		
		System.out.println(driver.findElement(By.xpath("//fieldset/table/tbody/tr[4]")).getText());

	}

}
