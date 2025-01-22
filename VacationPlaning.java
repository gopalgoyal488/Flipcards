package scripts;

import static org.testng.Assert.fail;

import java.time.Duration;
import java.util.List;
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

public class VacationPlaning {

	WebDriver driver;
 WebElement element ;
	WebDriverWait wait;
	String mainwindow ;
 
@SuppressWarnings("unlikely-arg-type")
@Test
 
 public void mouseovertest() throws InterruptedException {
	 
	wait=new WebDriverWait(driver,Duration.ofSeconds(10));
String url=	"https://www.triphobo.com/";
String PlanyourNextvacation ="//a[text()='Plan Your Next Vacation']";
String Destinationlocation="//input[@placeholder='Where do you want to go?']";
String enterlocationname ="//input[@placeholder='Enter City, Country or Region']";
String city=".city-list-i.js_suggestions.js_add_country span";
//String Startdate= "(//td[@data-handler='selectDay']/a[text()='3']";
String cityname="//div/img[@alt='London']";
String Enddate="(//td[@data-handler='selectDay']/a[text()='9']";
String StartPlanning="//span[@class='button p-color full-width start-planning']";



//String departmentname ="//a[text()='AU-FRG Institute for CAD/CAM']";

driver.get(url);

wait=new WebDriverWait(driver,Duration.ofSeconds(10));

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PlanyourNextvacation))).click();

driver.findElement(By.xpath(Destinationlocation)).click();

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(enterlocationname))).sendKeys("united");


//List<WebElement> allinks=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(city)));

List<WebElement> allinks=driver.findElements(By.cssSelector(city));
if(!allinks.isEmpty()) {
	
	System.out.println("list size"+ allinks.size());
}

for(WebElement allink: allinks ) {
	
	if(allink.getText().equals("United Kingdom")) {
		
		
		allink.click();
		
	}
}

element = driver.findElement(By.xpath(cityname));
Actions builder= new Actions(driver);
builder.moveToElement(element).click().perform();

//(//span[@class='ui-datepicker-month'])[1]
		
		//(//span[@class='ui-datepicker-month'])[2]
				
			//	(//span[@class='ui-datepicker-year'])[1]
						//(//span[@class='ui-datepicker-year'])[2]

driver.findElement(By.xpath("//input[@placeholder='Start Date']")).click();

String vactionstarmonth =driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]")).getText();
String vactionstaryear =driver.findElement(By.xpath("(//span[@class='ui-datepicker-year'])[1]")).getText();
String vactionendmonth =driver.findElement(By.xpath("(//span[@class='ui-datepicker-year'])[1]")).getText();
String vactionendyear =driver.findElement(By.xpath("(//span[@class='ui-datepicker-year'])[1]")).getText();
  

/*WebElement test = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='ui-datepicker-month'])[1]")));
test=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(vactionstaryear)));


if(!(test.equals("February") &&test.equals("2025"))) {
	
	WebElement nextbutton=driver.findElement(By.xpath("//a[@data-handler='next']"));
	nextbutton.click();
}*/

//WebElement stdate =driver.findElement(By.xpath("//input[@placeholder='Start Date']"));

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Start Date']"))).click();

wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("4"))).click();

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='End Date']"))).click();

wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("9"))).click();

//driver.findElement(By.xpath("//input[@placeholder='End Date']")).click();

//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Enddate))).click();

driver.findElement(By.xpath(StartPlanning)).click();

wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']"))).click();

//driver.findElement(By.xpath("//span[text()='Next']")).click();

wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Skip to']"))).click();
Thread.sleep(3000);

wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='step_title next-btn-dsk']"))).click();

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
 