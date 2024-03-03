package Section_10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PractiseActionClass {

	public static void main(String[] args) throws InterruptedException  {
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.amazon.com/");
	
	Actions a = new Actions(driver);
	WebElement move = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
	
	//contextclick will perform single right click action
	a.moveToElement(move).contextClick().build().perform();
	Thread.sleep(4000);
	a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
	}

}
