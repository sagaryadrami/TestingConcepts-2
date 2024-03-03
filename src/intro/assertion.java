package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class assertion {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		String name="shravan";
		String password = getpassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.cssSelector("input[placeholder$='Username']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText(), "Hello "+name+",");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.close();
	}
	
	public static String getpassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[class='reset-pwd-btn']")).click();
		String PasswordText = driver.findElement(By.cssSelector("form p")).getText();
		String[] passwordArray = PasswordText.split("'");
		String[] passwordarray1 = passwordArray[1].split("'");
		String password = passwordarray1[0];
		return password;
		

		
	}

}
