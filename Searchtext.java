package scripts;

import static org.testng.Assert.fail;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Searchtext {

	WebDriver driver;
 WebElement element ;
 
 WebDriverWait wait;
 
@Test
 
 public void goibigo() throws InterruptedException {
	 
	 
String cross=	"//div/span/span[@class='logSprite icClose']";
String from= "//span[text()='From']";
String To="//span[text()='To']";
String entertext="//input[@type='text']";
String citylist ="//p"; 
	 
	 driver.get("https://www.goibibo.com/");
	 
	 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 
element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cross)));
element.click();

element= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(from)));
//element=driver.findElement(By.xpath(from));
element.click();

driver.findElement(By.xpath(entertext)).sendKeys("Ban");
	 
	 List<WebElement> alllinks = driver.findElements(By.xpath(citylist));
	 if(!alllinks.isEmpty()) {
		 
		 
		 System.out.println("Total links..."+ alllinks.size() );
		 
	 }
		
	 for(WebElement alllink: alllinks) {
		  
		  if(alllink.getText().contains("Bengaluru")) {
			 
			  alllink.click();		  
			  break;
		  }
		  
	  }
	 
 }
  
/* @Test
 
 public void manageAlert() throws InterruptedException {
	
	 driver.get("https://www.goibibo.com/");
	 
	 String link="//span[@class='autoCompleteTitle '] ";
	 String closs=	"//div/span/span[@class='logSprite icClose']";
	 String from= "//div/div/input[@type='text']";
	
	 driver.findElement(By.xpath(closs)).click();
	 driver.findElement(By.xpath(from)).sendKeys("Ben");
	 
	 
List<WebElement> alllinks = driver.findElements(By.xpath(link));
	 if(!alllinks.isEmpty()) {
		 
		 
		 System.out.println("Total links..."+ alllinks.size() );
	 }
	  for(WebElement alllink: alllinks) {
		  
		  if(alllink.getText().equals("JavaScript Alerts")) {
			  
			  alllink.click();
			  
			  break;
		  }
		  
	  }
	  
 }*/
 

		
		@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@AfterMethod(alwaysRun = true)
	public void closeDriver() {
		driver.manage().deleteAllCookies();
		// driver.close();
		//driver.quit();
	}


}
 