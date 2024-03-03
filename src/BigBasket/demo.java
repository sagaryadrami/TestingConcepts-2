package BigBasket;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		String[] veggie={"Cauliflower","Ginger (Loose)"};
		
	}
	public static void additems(WebDriver driver,String[] veggie) throws InterruptedException {
		List<WebElement> allprod = driver.findElements(By.xpath("//div/h3"));
		int j=0;
		for(int i=0;i<allprod.size();i++) {
			List<String> buylist = Arrays.asList(veggie);	
			if(allprod.contains(buylist)) {
				driver.findElement(By.cssSelector("button[color='rossoCorsa']")).click();
				// selecting the location
				driver.findElement(By.cssSelector(
						"button[id='headlessui-menu-button-:r8:'] span[class='Label-sc-15v1nk5-0 AddressDropdown___StyledLabel-sc-i4k67t-2 gJxZPQ ZzWRb']"))
						.click();

		
			    if(j==veggie.length) {
			    	break;	
			    }
				
			}
		}
		
	}
}
