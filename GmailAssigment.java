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
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GmailAssigment {

	WebDriver driver;
 WebElement element ;
 
 WebDriverWait wait;
 
@Test
 
 public void gmail() throws InterruptedException {
	 
	
	String gmaillink ="Gmail";
	String url="https://workspace.google.com/intl/en-US/gmail/";
    String singin="(//a/span[text()='Sign in'])[2]";
    String gmail="//input[@type='email']";
    String text="//input[@id='identifierId']";
    String Password="//input[@type='password']";
    String nextbutton="//span[text()='Next']";
    
    String Username ="gopalgoyal488@gmail.com";
    
	 String Passwords="abc123";
	 driver.get("https://www.google.com/");
	 
	 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 
	 WebElement gmailurl=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(gmaillink)));
	String url1= gmailurl.getAttribute("href");
	 
	 Actions actions = new Actions(driver);
     actions.keyDown(Keys.CONTROL).click(gmailurl).keyUp(Keys.CONTROL).perform();
	// wait.until(ExpectedConditions.urlToBe(url));

		 // wait.until(ExpectedConditions.);
	
		 String mainwindow = driver.getWindowHandle();
			 
		  Set<String> allwindows=	 driver.getWindowHandles();

		  for(String allwindow:allwindows) {
		  	
		  	if(!allwindow.equals(mainwindow)) {
		  		
		  		driver.switchTo().window(allwindow);
		  		driver.get(url1);
		  		
		  		
		  		break;
		  	}
		  }
		 
		  System.out.println(" new Window title   " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Gmail: Private and secure email at no cost | Google Workspace");	
		driver.findElement(By.xpath(singin)).click();
		driver.findElement(By.xpath(gmail)).click();
		driver.findElement(By.xpath(text)).sendKeys(Username);
		driver.findElement(By.xpath(nextbutton)).click();
		driver.findElement(By.xpath(Password)).click();
		
		//input[@type='password']
		//input[@id='identifierId']
		//span[text()='Next']
		
	
	 
 }
  

		
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
 