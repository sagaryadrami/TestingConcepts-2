package Section_10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramePractise {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		//driver.switchTo().frame();
		
		//we are using this step find the total number of frame
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		//we are using frame index
		//driver.switchTo().frame(0);
		driver.switchTo().frame(0);
		
		//we are using the frame of webelement
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
		//driver.findElement(By.id("draggable")).click();
		Actions a = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
	
		a.dragAndDrop(source, target).build().perform();
		
		//to come out of the frame
		driver.switchTo().defaultContent();
	}

}
