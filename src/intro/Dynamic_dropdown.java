package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Dynamic_dropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		//// div[@id="ctl00_mainContent_ddl_originStation1_CTNR"]//a[@value="BLR"]
		//// another way of
		// writing using parent traverse

		Thread.sleep(2000);

		// driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']"))
				.click();
		//// div[@id="glsctl00_mainContent_ddl_destinationStation1_CTNR"]//a[@value="MAA"]parent
		//// child xpath relationship

		// calender ui
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

		// checking ui of round trip wheather the return date is enabled or disabled

		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {

			System.out.println("its enabled");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

}
