import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment_5 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\BrowserDrivers\\Chrome\\chromedriver_v102.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	    String alertTextExpected = "Hello option3, share this practice page and share your knowledge";
		driver.findElement(By.id("checkBoxOption3")).click();
		String checkboxValue = driver.findElement(By.id("checkBoxOption3")).getAttribute("value");
		Select dropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
		List<WebElement> dropOptions = dropdown.getOptions();
		System.out.println(dropOptions.size());
		for (WebElement option : dropOptions) {
			String dropOption3 = option.getText().trim();
			if (checkboxValue.trim().equalsIgnoreCase(dropOption3)) {
				option.click();
				break;
			}
		}
         driver.findElement(By.name("enter-name")).sendKeys(checkboxValue);
         driver.findElement(By.id("alertbtn")).click();
         String alertTextactual = driver.switchTo().alert().getText();
         Assert.assertEquals(alertTextactual, alertTextExpected);
         driver.switchTo().alert().accept();
         
	}

}
