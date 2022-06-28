import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class Brokenlinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\BrowserDrivers\\Chrome\\chromedriver_v102.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//single URL status code
		/*
		 * driver.findElement(By.linkText("REST API")).click();
		 * System.out.println(driver.getCurrentUrl()); String aurl =
		 * driver.getCurrentUrl(); URL url = new URL(aurl); HttpURLConnection conn =
		 * (HttpURLConnection) url.openConnection(); conn.setRequestMethod("HEAD");
		 * conn.connect(); int resCode = conn.getResponseCode();
		 * System.out.println(resCode);
		 */

//ALL URLs status condes
		SoftAssert sa = new SoftAssert();
		List<WebElement> links = driver.findElements(By.xpath("//table[@class='gf-t'] //ul/li/a"));
		System.out.println(links.size());
		for (WebElement link : links) {
			System.out.println(link.getAttribute("href"));
			String eachlink = link.getAttribute("href");
			
			URL url = new URL(eachlink);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
	        //HttpURLConnection   conn= (HttpURLConnection)new URL(eachlink).openConnection();
			
			con.setRequestMethod("HEAD");
			con.connect();
			int rescode = con.getResponseCode();
			System.out.println(rescode);
			sa.assertTrue(rescode < 400, "the URL is broken link " + link.getText() + "with status code is " + rescode);

		}
		sa.assertAll();

	}
}