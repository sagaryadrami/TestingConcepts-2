package section_11;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class no_of_links {

	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	
	//give the number of links in the page
	System.out.println(driver.findElements(By.tagName("a")).size());
	
	//limiting web driver scope
	WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
	System.out.println(footerdriver.findElements(By.tagName("a")).size());
	
	
	//get the number of column in a single row
	WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
	System.out.println(columndriver.findElements(By.tagName("a")).size());
	
	
	//click on each link to see if they are working
	for(int i=1;i<columndriver.findElements(By.tagName("a")).size();i++) {
		
		//below line of code is used to press control key so that the link open in a new tab otherwise we get error
		String ClickOnLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
		columndriver.findElements(By.tagName("a")).get(i).sendKeys(ClickOnLinkTab);
	}
	
	//get the title of each link opened
	Set<String> abc = driver.getWindowHandles();
	Iterator<String> it = abc.iterator();
	while(it.hasNext())
	{
		driver.switchTo().window(it.next());
		System.out.println(driver.getTitle());
	}
	
	}

}
