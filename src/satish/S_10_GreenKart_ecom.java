package satish;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class S_10_GreenKart_ecom {

	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\BrowserDrivers\\Chrome\\chromedriver_v100.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		//addToCart functionality
		addToCartUI(driver);
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//div[@class='action-block']/button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

		//promoCode page
		promoCode(driver);
		
		//Handle country static dropdown
		handleContryDropdown(driver);
		
		driver.findElement(By.cssSelector("input[class='chkAgree']")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		
	}
	
	public static void addToCartUI(WebDriver driver) {
		String[] reqProducts = {"Cucumber","Beetroot","Tomato","Potato"};
		ArrayList<String> requiredProducts = new ArrayList<String>(List.of(reqProducts));
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0;i<products.size();i++) {
			String[] productName = products.get(i).getText().split("-");
			String formattedProduct = productName[0].trim();
			if(requiredProducts.contains(formattedProduct)) {
				List<WebElement> incrementBtn = driver.findElements(By.xpath("//a[@class='increment']"));
				if(!formattedProduct.equals("Cucumber")) {
					for(int j=1;j<=3;j++) {
						incrementBtn.get(i).click();
					}
				}else {
					incrementBtn.get(i).click();
				}
				List<WebElement> addToCart = driver.findElements(By.xpath("(//div[@class='product'] //div[@class='product-action']/button[@type='button'])"));
				addToCart.get(i).click();
			}			
		}
	}
	
	public static void promoCode(WebDriver driver) throws InterruptedException{
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[contains(.,'Apply')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
	}
	
	public static void handleContryDropdown(WebDriver driver) {
		WebElement dropdownValues = driver.findElement(By.xpath("//select"));
		Select dropdown = new Select(dropdownValues);
		dropdown.selectByVisibleText("India");
		
		Boolean checkAgreeField = driver.findElement(By.cssSelector("input[class='chkAgree']")).isSelected();
		Assert.assertFalse(checkAgreeField);
	}

}
