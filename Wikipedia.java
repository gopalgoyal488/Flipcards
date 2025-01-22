package scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Wikipedia {
	
	WebDriver driver;
	 WebElement element ;
		/* @Test
		public void assigment() throws InterruptedException {
			driver.get("https://www.wikipedia.org/");
			
			driver.findElement(By.xpath("//div/a/strong[text()='English']")).click();
			 Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@placeholder='Search Wikipedia']")).sendKeys("Selenium");
			driver.findElement(By.xpath("//button[text()='Search']")).click();
		System.out.println( driver.getTitle());
			
			if(driver.getTitle().equals("Selenium - Wikipedia")) {
				
				System.out.println("pass");
				
			} else {
				
				System.out.println("fail");
			}
		} 
		
  @Test

public void googlelist() {
	
	driver.get("https://www.flipkart.com/");
	
	List<WebElement> alllinks = driver.findElements(By.xpath("//a"));
	
	if(!alllinks.isEmpty())
	{
		
	System.out.println("flipcard liks" + alllinks.size());

for(WebElement alllink:alllinks)
{
     String url =alllink.getAttribute("href");
	String tx =alllink.getText();
	System.out.println(tx);
	  //alllink.click();
	System.out.println(url);
}
	}
	else {
		
		System.out.print("list is empty");
	}
	
}
*/


@Test

public void flipkart() throws InterruptedException {
	
	
	driver.get("https://www.flipkart.com/");
	
	List<WebElement> allinks = driver.findElements(By.xpath("//input[@placeholder='Search for Products, Brands and More']"));
	
	if(!allinks.isEmpty())
	{
		
	System.out.println("flipcard liks" + allinks.size());

for(WebElement allink:allinks)
{
	
	Thread.sleep(5000);
	allink.sendKeys("mumbai");
	Thread.sleep(3000);
	allink.getText();

}
	
}}
		@BeforeMethod(alwaysRun = true)
		public void beforeMethod() {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
			
		}
		@AfterMethod(alwaysRun = true)
		public void closeDriver() {
			driver.manage().deleteAllCookies();
			driver.quit();
		}



}
