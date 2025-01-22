package scripts;

import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class flipcard {

	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	WebElement element;
	Alert alert;

	@BeforeMethod(alwaysRun = true)
	public void brawserlouch() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();
		driver.get("https://www.flipkart.com/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

@Test(enabled=false)
	public void flipcardsignup() throws InterruptedException {
		action = new Actions(driver);

		WebElement loginin = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Login']")));

		// WebElement loginin1 = driver.findElement(By.xpath("//span[text()='Login']"));
		action.moveToElement(loginin).perform();
		driver.findElement(By.xpath("//span[text()='Sign Up']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='r4vIwl BV+Dqf']")))
				.sendKeys("9285031447");
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='CONTINUE']"))).click();
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='CONTINUE']"))).click();

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='r4vIwl
		// BV+Dqf']"))).sendKeys("417634");

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Signup']"))).click();

		driver.navigate().back();
		// driver.manage().
		Thread.sleep(10);
		Alert alert = driver.switchTo().alert();

		alert.dismiss();

	}

	@Test(enabled=false)
	public void Groceryiteams() {

		driver.findElement(By.linkText("Grocery")).click();

		action = new Actions(driver);
		element = driver.findElement(By.xpath("//div[text()='Select city']"));
		action.moveToElement(element).build().perform();
		driver.findElement(By.xpath("//input[@name='pincode']")).sendKeys("452005");
		// driver.findElement(")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='QqFHMw UhdyNX M5XAsp']")))
				.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Login"))).click();
		try {
			alert = driver.switchTo().alert();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@Class='r4vIwl BV+Dqf']")))
					.sendKeys("9826985516");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Request OTP']")))
					.click();
//alert.accept();
		} catch (NoAlertPresentException e) {

			e.getMessage();
		}

		// input[@name='pincode']
		// button[@class='QqFHMw UhdyNX M5XAsp']

	}

 @Test(enabled=true)
	public void searchiteam() throws InterruptedException {

		element = driver.findElement(By.name("q"));
		element.sendKeys("Mobile");
		element.submit();

		driver.findElement(By.xpath("//div[text()='Apple iPhone 15 Plus (Black, 128 GB)']")).click();

		String homepage = driver.getWindowHandle();
		Set<String> productdetails = driver.getWindowHandles();

		for (String productdetail : productdetails) {

			if (!homepage.equals(productdetail)) {
				try {
					driver.switchTo().window(productdetail);
					System.out.println(driver.getTitle());
					Assert.assertEquals(driver.getTitle(), "Apple iPhone 15 Plus (Black, 128 GB)");
				} catch (NoSuchWindowException e) {
					e.getMessage();
				}
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//button[@class='QqFHMw vslbG+ _3Yl67G _7Pd1Fp']")))
						.click();
				// driver.findElement(By.xpath("")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@Class='r4vIwl Jr-g+f']")))
						.sendKeys("9826985516");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='CONTINUE']")))
						.click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='r4vIwl BV+Dqf']")))
						.sendKeys("417634");

				// Thread.sleep(20);
			}
		}
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Search for Products, Brands and More']"))).sendKeys("Mo");
		
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='Mobiles']"))).click();
		
		
		
		
		

//		if (!searchiteams.isEmpty()) {
//			System.out.println("list size" + searchiteams.size());
//		} else {
//			System.out.print("not found");
//		}
//
//		for (WebElement searchiteam : searchiteams) {
//			if (searchiteam.getText().equalsIgnoreCase("mobile")) {
//
//				searchiteam.click();
//
//				searchiteam.getText();
//			}
//
//		}

	}

	
	@Test(enabled=false)
	
	public void mobile() {
		
		driver.findElement(By.linkText("Mobiles")).click();
		List<WebElement> mobilelinks =driver.findElements(By.tagName("a"));
		if(mobilelinks.isEmpty()) {
			
			System.out.println(mobilelinks.size());
		}
		for(WebElement mobilelink: mobilelinks ) {
			if(mobilelink.getText().equalsIgnoreCase("OPPO Find X8")) {
				mobilelink.click();
				
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='checkbox'])[4]"))).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Add 2 Items to Cart']"))).click();
			//driver.findElement()).click();
			//driver.findElement(By.xpath("")).click();
				
				
			}
		}
	}
	@Test(enabled=false)

	public void login() {
		action = new Actions(driver);

		WebElement loginin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Login")));

		loginin.click();
		
		
		

		// WebElement loginin1 = driver.findElement(By.xpath("//span[text()='Login']"));

		// action.doubleClick(loginin).perform();

	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		// driver.quit();

	}

}
