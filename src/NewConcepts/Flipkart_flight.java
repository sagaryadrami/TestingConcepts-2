package NewConcepts;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flipkart_flight {

	public static void main(String[] args) throws InterruptedException {
		//WebDriver driver = new ChromeDriver();
		 WebDriver driver = new FirefoxDriver();
		 driver.manage().deleteAllCookies();
		 //driver.switchTo().alert().accept();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://www.flipkart.com/travel/flights?otracker=nmenu_Flights");
		
//		 Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//		alert.accept();
		
		Thread.sleep(2000);

		WebElement from = driver.findElement(By.xpath("//input[@name='0-departcity']"));
		from.sendKeys("Bangalore, BLR - Kempegowda International Airport, India");
		 Actions actions = new Actions(driver);
	}

}
