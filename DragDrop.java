package scripts;

import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragDrop {

	
	WebDriver driver; 
	WebElement elemet;
	
	WebDriverWait wait;

	
	@Test
	
	public void dragdroptest() throws InterruptedException{
		
		driver.get("https://icefaces-showcase.icesoft.org/showcase.jsf");
		
		wait= new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Miscellaneous']"))).click();
		
		
		//driver.findElement(By.xpath("//a[text()='Miscellaneous']")).click();
		
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/span[contains(text(),'ace:draggable/droppable')]"))).click();
		
		//driver.findElement(By.xpath("//span[text()='ace:draggable/droppable']")).click();
	
		//a[text()='Miscellaneous']
	
//div/span[contains(text(),'ace:draggable/droppable')]
		//span[text()='ace:draggable/droppable']
	}
		
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//driver.manage().deleteAllCookies();
		
	}
		
		
	}

