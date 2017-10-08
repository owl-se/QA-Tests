package home.hr_task.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Inbox extends PageObject{
	
	@FindBy(xpath=".//*[@id='UYe9H4E']/div[1]/div[1]/div[1]/a[1]/div[4]/div[3]/div[2]")
	private WebElement letter;
	
	@FindBy(xpath=".//*[@id='UYe9H4E']/div[1]/div[1]")
	private WebElement news;
	
	public Inbox(WebDriver driver){
		super(driver);
	}
	
	public Message clickOnMessage(){
		List<WebElement> a = driver.findElements(By.xpath(".//*[@class='b-datalist__item__body']/a")); // get all emails
		a.get(0).click();	// let's open the first one
		return new Message(driver);
	}
}
