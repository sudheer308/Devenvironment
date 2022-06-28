import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment_2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\BrowserDrivers\\Chrome\\chromedriver_v100.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		// Thread.sleep(1000);
		driver.findElement(By.name("name")).sendKeys("sudheer");
		driver.findElement(By.name("email")).sendKeys("contact@rahulshettyacademy.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("form-check-input")).click();
		WebElement genders = driver.findElement(By.id("exampleFormControlSelect1"));
		Select gender = new Select(genders);
		List<WebElement> categior = gender.getOptions();
		for (int i = 0; i < categior.size(); i++) {
			if (categior.get(i).getText().equals("Female")) {
				categior.get(i).click();
				break;
			}
		}
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("12-04-1995");
		driver.findElement(By.cssSelector("input.btn.btn-success")).click();
		String successMessage = (driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"))
				.getText().split("\n"))[1];
		Assert.assertEquals(successMessage, "Success! The Form has been submitted successfully!.");
	}

}
