package scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Dropdown {

	WebDriver driver;
 WebElement element ;

	/*@Test
	
	public void dropdowntest(){
		
		
		driver.get("https://nichethyself.com/tourism/explore.html");
		
	WebElement dropdown= driver.findElement(By.xpath("//select[@multiple='multiple']"));
		
	Select optionvalue= new Select(dropdown);
	
	optionvalue.selectByVisibleText("Mumbai");
	optionvalue.selectByVisibleText("Kolkata");
	optionvalue.selectByVisibleText("Jaipur");
	
	}
	
	@Test 
	
	public void dropdownsecond() throws InterruptedException {
		
		driver.get("https://the-internet.herokuapp.com/dropdown");
		
		WebElement dropdown= driver.findElement(By.id("dropdown"));
		Select optionvalue= new Select(dropdown);
		optionvalue.selectByVisibleText("Option 1");
		optionvalue.selectByVisibleText("Option 2");
	}*/
	
	@Test
	
	public void dropdownthired() throws InterruptedException {
		
		 driver.get("https://demoqa.com/automation-practice-form");
			
	/*	
	String FirstName="//input[@placeholder='First Name']";
		String LastName="//input[@placeholder='Last Name']";
		String Email="//input[@placeholder='name@example.com']";
		String Gender = "//label[text()='Female']";
	   String MobileNumber= "//input[@placeholder='Mobile Number']"	;
	   String Subject ="//div[@id='subjectsContainer']";
	   String Hobbise ="//label[text()='Reading']";
	   String CurrentAddress ="//textarea[@placeholder='Current Address']";
	   String State="//div[text()='Select State']";
	   String submitbutton="//button[@type='submit']";
	   
	   driver.get("https://demoqa.com/automation-practice-form");
		
		driver.findElement(By.xpath(FirstName)).sendKeys("Gopal");
		driver.findElement(By.xpath(LastName)).sendKeys("Goyal");
		driver.findElement(By.xpath(Email)).sendKeys("gopalgoyal488@gmail.com");
		Thread.sleep(2000);
	WebElement genders  = 	driver.findElement(By.xpath(Gender));
	Thread.sleep(2000);
		if(!genders.isSelected()) {
			
			genders.click();
		} 
		else{
			
		System.out.println("have checked already");
		}
		driver.findElement(By.xpath("MobileNumber")).sendKeys("9826985516");
		driver.findElement(By.xpath("Subject")).sendKeys("QA test only");
		
		WebElement hobbises= driver.findElement(By.xpath("Hobbise"));
		
		if(!hobbises.isSelected()){
			hobbises.click();
			
		}
		else{
			
			System.out.println("have checked already");
			}
		
		
		
	System.out.println(hobbises.getText());
	driver.findElement(By.xpath("CurrentAddress")).sendKeys("testinaddress");
	driver.findElement(By.xpath(State)).sendKeys("Madhya Pradesh");*/
	
     WebElement selectcity= driver.findElement(By.id("city"));
	Assert.assertFalse(selectcity.isEnabled(), "City field should be disabled.");
	//driver.findElement(By.xpath(submitbutton)).click();
	
	
		
		//input[@placeholder='First Name']
		//input[@placeholder='Last Name']
		//input[@placeholder='name@example.com']
		//label[text()='Male']
		//input[@placeholder='Mobile Number']
		//div[@id='subjectsContainer']
		//label[text()='Reading']
		//textarea[@placeholder='Current Address']
		//div[text()='Select State']
		//button[@type='submit']
		
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
		//driver.quit();
	}


}
 