package BigBasket;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PractiseTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		//String[] veggie={"Cauliflower","Ginger (Loose)"};

		// selecting the location
		driver.findElement(By.cssSelector(
				"button[id='headlessui-menu-button-:r8:'] span[class='Label-sc-15v1nk5-0 AddressDropdown___StyledLabel-sc-i4k67t-2 gJxZPQ ZzWRb']"))
				.click();

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[1]/header[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]"))
				.sendKeys("Ban");
		Thread.sleep(2000);
		List<WebElement> locations = driver.findElements(By.cssSelector(
				"div[class='grid grid-flow-col gap-x-6 h-9 mt-3.5 mb-2.5'] li:nth-child(1) span:nth-child(1)"));
		for (WebElement location : locations) {
			if (location.getText().equalsIgnoreCase("Banashankari"));{
			Thread.sleep(2000);
			location.click();
			break;
			}
		}
		
		//driver.findElement(By.xpath("//span[normalize-space()='View All']")).click();
		
	}
	
}
