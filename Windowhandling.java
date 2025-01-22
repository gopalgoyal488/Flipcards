package scripts;

import static org.testng.Assert.fail;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchContextException;
import org.openqa.selenium.NoSuchCookieException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Windowhandling {

	WebDriver driver;
	WebElement element;

	@Test

	public void multiplewindow() throws InterruptedException {

		String customizedtours = "//a[text()='Customized tours']";
		String hotaltype = "//select[@id='days']";
		String England = "//label[text()='England']/input";
		String contactus = "//button[text()='Contact us!']";
		String search = "//span[@class='glyphicon glyphicon-search']";
		String submit = "(//button[@type='submit'])[3]";
		driver.get("https://nichethyself.com/tourism/home.html");

		driver.findElement(By.xpath(customizedtours)).click();

		String mainwindow = driver.getWindowHandle();

		Set<String> allwindows = driver.getWindowHandles();

		for (String allwindow : allwindows) {

			if (!allwindow.equals(mainwindow)) {

				try {
					driver.switchTo().window(allwindow);
				} catch (NoSuchWindowException e) {

					fail("contact us window is not present");
				}catch (NoSuchElementException e) {
					
					e.getMessage();
				}catch (NoSuchCookieException e) {
					e.getMessage();
				}
			} 
		}

		System.out.println(" new Window title   " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Customised tour");

		WebElement prefestay = driver.findElement(By.xpath(hotaltype));

		Select dropdown = new Select(prefestay);
		dropdown.selectByVisibleText("Home Stay");

		WebElement countryvisit = driver.findElement(By.xpath(England));

		if (!countryvisit.isSelected()) {

			countryvisit.click();
		}

		driver.findElement(By.xpath(contactus)).click();

		try {
			driver.switchTo().window("Contact");
		} catch (NoSuchWindowException e) {

			fail("contact us window is not present");
		}

		driver.findElement(By.xpath(search)).click();
		Alert alert = driver.switchTo().alert();
		try {
			// Alert alert= driver.switchTo().alert();

			alert.sendKeys("Londone");
			alert.accept();

		} catch (NoAlertPresentException e) {

			fail("Alert is not present");
		}

		driver.switchTo().window(mainwindow);

		driver.findElement(By.xpath(submit)).click();
		Thread.sleep(5000);
		alert.accept();

		// 8. Close "Contact Us" window and click on "Submit" button on customized tour
		// (switch) pending will discuss on call

	}

	//@Test

	public void goibigo() {

		String closs = "//div/span/span[@class='logSprite icClose']";
		String from = "//div/div/input[@type='text']";

		String AlertURLText = "JavaScript Alerts";
		driver.get("https://www.goibibo.com/");

		driver.findElement(By.xpath(closs)).click();
		driver.findElement(By.xpath(from)).sendKeys("Ben");

	}

	//@Test

	public void manageAlert() throws InterruptedException {

		driver.get("https://the-internet.herokuapp.com/");

		String link = "//a";
		String jsAlert = "//button[text()='Click for JS Alert']";
		String Jstext = "//p[@id='result']";
		String jsExpectedtext = "You successfully clicked an alert";

		List<WebElement> alllinks = driver.findElements(By.xpath(link));
		if (!alllinks.isEmpty()) {

			System.out.println("Total links..." + alllinks.size());
		}
		for (WebElement alllink : alllinks) {

			if (alllink.getText().equals("JavaScript Alerts")) {

				alllink.click();

				break;
			}

		}
		driver.findElement(By.xpath(jsAlert)).click();
		// WebElement actualtext= driver.findElement(By.xpath(Jstext));

		Alert alert = driver.switchTo().alert();
		try {

			alert.accept();

			WebElement jsactualtext = driver.findElement(By.xpath(Jstext));
			Assert.assertEquals(jsactualtext.getText(), jsExpectedtext);
			System.out.println(jsactualtext.getText());

		} catch (NoAlertPresentException e) {

			fail("Alert is not present");
		}
	}

	//@Test

	public void jsconfirmok() throws InterruptedException {

		String JsconfirmAlert = "//button[text()='Click for JS Confirm']";
		// String JsPromptAlert="//button[text()='Click for JS Prompt']";
		String JSconfirmtextok = "//p[@id='result']";
		String JSconfirmtextcancel = "//p[@id='result']";
		String JsconfirmExpectedtextok = "You clicked: Ok";
		String JsconfirmExpectedtextcancel = "You clicked: cancel";

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		driver.findElement(By.xpath(JsconfirmAlert)).click();

		Alert alert = driver.switchTo().alert();
		try {

			alert.accept();

			WebElement Jsconfirmactualtextok = driver.findElement(By.xpath(JSconfirmtextok));
			Assert.assertEquals(Jsconfirmactualtextok.getText(), JsconfirmExpectedtextok);
			System.out.println(Jsconfirmactualtextok.getText());

		} catch (NoAlertPresentException e) {

			fail("Alert is not present");
		}

	}

	//@Test

	public void jsconfirmcancel() {
		String JSconfirmtextcancel = "//p[@id='result']";
		String JsconfirmExpectedtextcancel = "You clicked: Cancel";
		String JsconfirmAlert = "//button[text()='Click for JS Confirm']";

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		driver.findElement(By.xpath(JsconfirmAlert)).click();

		Alert alert = driver.switchTo().alert();
		try {

			alert.dismiss();

			WebElement Jsconfirmactualtextcancel = driver.findElement(By.xpath(JSconfirmtextcancel));
			Assert.assertEquals(Jsconfirmactualtextcancel.getText(), JsconfirmExpectedtextcancel);
			System.out.println(Jsconfirmactualtextcancel.getText());

		} catch (NoAlertPresentException e) {

			fail("Alert is not present");
		}
	}

	//@Test

	public void jspromptok() {
		String Jjsprompttextok = "//p[@id='result']";
		String jspromptExpectedok = "You entered: Gopal";
		String jspromptAlert = "//button[text()='Click for JS Prompt']";

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		driver.findElement(By.xpath(jspromptAlert)).click();

		Alert alert = driver.switchTo().alert();
		try {

			alert.sendKeys("Gopal");
			alert.accept();

			WebElement jspromptok = driver.findElement(By.xpath(Jjsprompttextok));
			Assert.assertEquals(jspromptok.getText(), jspromptExpectedok);
			System.out.println(jspromptok.getText());

		} catch (NoAlertPresentException e) {

			fail("Alert is not present");
		}
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@AfterMethod(alwaysRun = true)
	public void closeDriver() {
		driver.manage().deleteAllCookies();

		// driver.close();
		// driver.quit();
	}

}
