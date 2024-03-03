package NewConcepts;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitTest {

	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	
	//WebDriverWait w = new WebDriverWait(driver,5);
	driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
	driver.findElement(By.cssSelector("div[id='start'] button")).click();
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofSeconds(30))
			.pollingEvery(Duration.ofSeconds(3))
			.ignoring(NoSuchElementException.class);
	
	}

}
