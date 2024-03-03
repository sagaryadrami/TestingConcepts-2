package NewConcepts;

import java.lang.reflect.Array;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AddToCart {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
	
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		//WebDriverWait w = new WebDriverWait(driver, 5);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		
		
		//Thread.sleep(3000);
		String[] items = { "Cucumber", "Brocolli", "Beetroot", "Brinjal" };
		additems(driver, items);
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

	}

	public static void additems(WebDriver driver, String[] items) {
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < products.size(); i++) {
			// we need to remove -1kg from the name and to remove space
			String[] name = products.get(i).getText().split("-");
			String formattedname = name[0].trim();

			List<String> allitems = Arrays.asList(items);

			if (allitems.contains(formattedname)) {
				j++;
				// Add to cart and xpath used here is just from text
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == items.length) {
					break;
				}
			}
		}

	}

}
