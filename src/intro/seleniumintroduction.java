package intro;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class seleniumintroduction {
	public static void main(String[] args) throws InterruptedException {
		// ChromeDriver driver = new ChromeDriver();
//	WebDriver driver = new EdgeDriver();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("sagar");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.className("submit")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();

		// to avoid element intercepted we use thread
		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("shravan");

		// experimenting with the index
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("sh@gmail..com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("sh@gmail.com");

		// using parent child tag
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9945274839");

		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

		// parenttag name and child tagname is used for css selector:
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());

		driver.findElement(By.className("go-to-login-btn")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("shravan");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");

		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

		Thread.sleep(2000);
		// tag locator with assertion
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");

	}
}
