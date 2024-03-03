package Section_13;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Broken_link {

	public static void main(String[] args) throws MalformedURLException, IOException {
 WebDriver driver = new ChromeDriver();
 driver.get("https://rahulshettyacademy.com/AutomationPractice/");
 
 //this is for only one particular link which we took from selenium
 //String url = driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
 
 //to check every link in the page 
 List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
 SoftAssert a = new SoftAssert();
 
 for(WebElement link :links) {
	 String url = link.getAttribute("href");
		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
	 	conn.setRequestMethod("HEAD");
	 	conn.connect();
	 	int code = conn.getResponseCode();
	 	System.out.println(code);
	 	a.assertTrue(code>400, "the link with the Text "+link.getText()+" is broken and the code for it is "+code);
	 	
	 
 }
 
 
//now calling java method will call URL and gets the status code if it is 200 its ok and if its above 400 notok
 
 
 	

 	
	}

}
