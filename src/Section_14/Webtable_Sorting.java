package Section_14;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Webtable_Sorting {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//click on the column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//capture all the webelement into the list
		List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));
		
		//capture text of all webelement into new(original) list
		List<String> originalList = elementList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//sort the originalList 
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		//compare originalList vs sortedList
		Assert.assertTrue(originalList.equals(sortedList));
		
		
		//another problem
		//scan the name column with getText ->Beans ->print the price of the bean
		List<String> price;
		do {
			List<WebElement> row = driver.findElements(By.xpath("//tr/td[1]"));

		price = row.stream().filter(s->s.getText().contains("Rice"))
				.map(s->getPriceVeggie(s)).collect(Collectors.toList());
		price.forEach(s->System.out.println(s));
		if(price.size()<1) {
			driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
		}
		}while(price.size()<1); 
			
		
		
	}


	
	

	
	
private static String getPriceVeggie(WebElement s) {
	String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
	return priceValue;

}}
