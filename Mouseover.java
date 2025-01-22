package scripts;

import static org.testng.Assert.fail;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Mouseover {

	WebDriver driver;
 WebElement element ;
	WebDriverWait wait;
	String mainwindow ;
 
@Test
 
 public void mouseovertest() throws InterruptedException {
	 
	wait=new WebDriverWait(driver,Duration.ofSeconds(10));
String url=	"https://www.annauniv.edu/";
String Department ="//a[text()='Departments']";
String Mechanicaldepartment="//a[text()='Mechanical Engineering ']";
String Facilitiesdepartment ="//a/span[text()='Facilities']";
String departmentname ="//a[text()='AU-FRG Institute for CAD/CAM']";

driver.get(url);

element =driver.findElement(By.xpath(Department));
Actions builder= new Actions(driver);

builder.moveToElement(element).perform();

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Mechanicaldepartment))).click();

String mainwindow = driver.getWindowHandle();

Set<String> allwindows=	 driver.getWindowHandles();

for(String allwindow:allwindows) {
	
	if(!allwindow.equals(mainwindow)) {
		
		driver.switchTo().window(allwindow);
		
		break;
	}
}
	
System.out.println(" new Window title   " + driver.getTitle());
Assert.assertEquals(driver.getTitle(), "Mechanical Engineering");

element =driver.findElement(By.xpath(Facilitiesdepartment));
  
builder.moveToElement(element).perform();

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(departmentname))).click();

driver.close();

driver.switchTo().window(mainwindow);
 
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
		//driver.switchTo().window(mainwindow);
		 //driver.close();
		//driver.quit();
	}


}
 