import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class end_to_end_testing {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\BrowserDrivers\\Chrome\\chromedriver_v100.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#search.aspx?mode=search");
		/*driver.navigate().to("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.findElement(By.id("autosuggest")).sendKeys("Ind");
		List<WebElement> country = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
		System.out.println(country.size());
		for (WebElement eachcountry : country) {
                   if(eachcountry.getText().equalsIgnoreCase("India")) {
                	   eachcountry.click();
                	   break;
                   }
			}
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).isDisplayed());
		driver.findElement(By.name("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@class='dropdownDiv']/ul/li/a[@value='BOM']")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='VGA']")).click();
		driver.findElement(By.className("ui-state-highlight")).click();
		driver.findElement(By.id("divpaxinfo")).click();
		for(int i=1;i<3;i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
			}
		for(int i=0;i<3;i++) {
			driver.findElement(By.id("hrefIncChd")).click();
		}
			driver.findElement(By.id("btnclosepaxoption")).click();
			WebElement element = driver.findElement(By.cssSelector("#ctl00_mainContent_DropDownListCurrency"));
			Select options = new Select(element);
			options.selectByVisibleText("USD");
			driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']")).click();*/
		
		//driver.findElement(By.id("ctl00_mainContent_chk_Unmr")).isSelected();
		//System.out.println(driver.findElement(By.className("paxinfo")).getText());
		Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_Unmr")).isSelected());
		driver.findElement(By.id("ctl00_mainContent_chk_Unmr")).click();
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_Unmr")).isSelected());
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "1 Child");
		
		}
	

	}


