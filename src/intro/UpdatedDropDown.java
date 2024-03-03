package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);

		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='chk_friendsandfamily'")).isSelected());

		// System.out.println(driver.findElement(By.cssSelector("input[id*='chk_friendsandfamily'")).isSelected());
		driver.findElement(By.cssSelector("input[id*='chk_friendsandfamily'")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='chk_friendsandfamily'")).isSelected());

		// System.out.println(driver.findElement(By.cssSelector("input[id*='chk_friendsandfamily'")).isSelected());

		// count the number of check box
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

//	int i=1;
//	while(i<5) {
//		driver.findElement(By.id("hrefIncAdt")).click();
//		i++;
//	}

		for (int i = 1; i < 5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	}

}
