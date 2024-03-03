package Section_10;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChildWindowHandle {

	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.rahulshettyacademy.com/loginpagePractise/#");
	driver.findElement(By.cssSelector(".blinkingText")).click();
//	Set<String> windows = driver.getWindowHandles();
//	Iterator<String> it = windows.iterator();
//	String parentId = it.next();
//	String chilId = it.next();
//	driver.switchTo().window(chilId);
	
	Set<String> window = driver.getWindowHandles();
	Iterator<String> it = window.iterator();
	String parentId = it.next();
	String childId = it.next();
	driver.switchTo().window(childId);
	
	System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
	String emaiLId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
	driver.switchTo().window(parentId);
	driver.findElement(By.id("username")).sendKeys(emaiLId);
	}

}
