package scripts;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo {

	private static final @Nullable String OrangeHRM = null;
	WebDriver driver; 
	
	@Test
	
	public void hrms() throws InterruptedException{
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println( driver.getTitle());
	if((driver.getTitle())==(OrangeHRM)) {
		
		System.out.println("pass");
		}
	
	else {
		
		System.out.println("fail");
	}
		 driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		 driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		 driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		 driver.findElement(By.xpath("//a/span[text()='Admin']")).click();
		 driver.findElement(By.xpath("//div/ul/li/span[@Class='oxd-userdropdown-tab']")).click();
		 driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
			
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

