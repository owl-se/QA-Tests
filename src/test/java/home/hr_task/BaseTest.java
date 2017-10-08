package home.hr_task;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import home.hr_task.pages.BasePage;
import home.hr_task.pages.Inbox;
import home.hr_task.pages.Message;

/**
 * Unit test for simple App.
 */
public class BaseTest {
	private WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.gecko.driver","C:\\jva\\geckodriver\\geckodriver.exe");  // depends on environment 
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.mail.ru"); 
		driver.manage().window().maximize();  
	}
	
	@DataProvider(name = "test1")
	   public static Object[][] testSubjects() {
	      return new Object[][] {{"hr_asked_me", "12345qwerty"}};
	   }
	
	@Test(dataProvider = "test1")
	public void testEmail(String name, String password){
		
		BasePage page = new BasePage(driver);
		Message message = page.goEnter(name, password).clickOnMessage();
		System.out.println("Header is '" + message.getEmailHeader() + "'");
		System.out.println("And the body is '" + message.getEmailBody()+"'");
		message.goExit();
		assert true;
	}
	
	@AfterMethod
	public void tearDown() {
	driver.quit();
	}
}
