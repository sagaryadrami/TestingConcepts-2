package section_11;

//package section_11;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//
//
//public class Calender_Ui {
//
//	public static void main(String[] args) throws InterruptedException {
//		WebDriver driver = new ChromeDriver();
//	driver.manage().window().maximize();
//	driver.get("https://www.path2usa.com/travel-companion");
//	Thread.sleep(5000);
//	WebElement element = driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']"));
//	Actions a = new Actions(driver);
//	a.click(element).build().perform();
//	}
//
//}
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calendar {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "C://work//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
//April 23
		driver.findElement(By.xpath(".//*[@id='travel_date']")).click();

		while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText()
				.contains("May")) {
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
		}

		List<WebElement> dates = driver.findElements(By.className("day"));
//Grab common attribute//Put into list and iterate
		int count = driver.findElements(By.className("day")).size();

		for (int i = 0; i < count; i++) {
			String text = driver.findElements(By.className("day")).get(i).getText();
			if (text.equalsIgnoreCase("21")) {
				driver.findElements(By.className("day")).get(i).click();
				break;
			}

		}
	}

}
