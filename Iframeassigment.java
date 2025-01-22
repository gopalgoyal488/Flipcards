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

public class Iframeassigment {

	WebDriver driver;
 WebElement element ;
 
 WebDriverWait wait;
 
@Test
 
 public void Indiatoday() throws InterruptedException {
	 
	 
String iframid="google_ads_iframe_/1007232/IT_HP_Desktop_MTF_1_300x250_0";
String link="(//img[@class='i-amphtml-fill-content i-amphtml-replaced-content'])[1]";
String projectUrl="https://www.indiatoday.in/";

driver.get(projectUrl);

driver.switchTo().frame(iframid);
wait =new WebDriverWait(driver, Duration.ofSeconds(10));


wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(link))).click();

 

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
 