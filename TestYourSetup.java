package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestYourSetup {

	WebDriver driver;
 WebElement element ;
	@Test
	public void loginToNicheThyselfTourism() throws InterruptedException {
		driver.get("https://nichethyself.com/tourism/home.html");
		element= driver.findElement(By.name("username"));
	       element.sendKeys("stc123");
		 driver.findElement(By.name("password")).sendKeys("12345");
		 driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
		 driver.findElement(By.xpath("//a[text()='About']")).click();
		 driver.navigate().back();
		 driver.findElement(By.xpath("//a[text()='Explore']")).click();
		 driver.navigate().back();
		 //driver.navigate().forward();
		 driver.navigate().refresh();
		 driver.findElement(By.xpath("//a[text()='  Sign out']")).click();
		 Thread.sleep(2000);
		 driver.close();
		 
		// element.submit();
		 //driver.navigate().back();	
		 
	} 
	
	@Test
	
	public void rediobuggtton(){
		
		
		driver.get("https://nichethyself.com/tourism/customised.html");
		
		WebElement rediobuttontest =driver.findElement(By.xpath("(//label[@class='radio-inline']/input[@name='optradio'])[2]"));
		
		if(!rediobuttontest.isSelected()) {
		
		
		rediobuttontest.click();
		}
	 else {
		
		 WebElement rediobuttontest2 =driver.findElement(By.xpath("(//label[@class='radio-inline']/input[@name='optradio'])[3]"));
		 
		 rediobuttontest2.click();
	}
	}
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
 