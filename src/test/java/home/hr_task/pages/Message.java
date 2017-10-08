package home.hr_task.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Message extends PageObject{
	
	@FindBy(xpath=".//*[@class='b-letter__head__subj__text']")
	WebElement head;
	
	@FindBy(xpath=".//*[@class='js-helper js-readmsg-msg']")
	WebElement body;
	
	@FindBy(xpath=".//a[@id='PH_logoutLink']")
	WebElement exit;
	
	public Message(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String getEmailHeader(){
		return head.getText();
	}
	
	public String getEmailBody(){
		return body.getText();
	}
	
	public void goExit(){
		exit.click();
	}
}
