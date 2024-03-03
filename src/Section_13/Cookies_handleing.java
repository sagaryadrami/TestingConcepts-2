package Section_13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cookies_handleing {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.manage().deleteAllCookies();
		//driver.manage().deleteCookieNamed("singn-In");
		driver.get("http://google.com");
	}

}
