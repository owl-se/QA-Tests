package home.hr_task.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import home.hr_task.pages.PageObject;

public class BasePage extends PageObject{
	
	@FindBy(xpath=".//input[@id='mailbox__login']")
	private WebElement userNameField;
	
	@FindBy(xpath=".//input[@id='mailbox__password']")
	private WebElement passwordField;
	
	@FindBy(xpath=".//input[@id='mailbox__auth__button']")
	private WebElement enterButton;
	
	@FindBy(xpath=".//input[@id='mailbox__auth__remember__checkbox']")
	private WebElement rememberMe;
	
	public BasePage(WebDriver driver){
		super(driver);
	}
	
	public void fill(){
		userNameField.clear();
		userNameField.sendKeys("sss");
	}
	
	public Inbox goEnter(String user, String password){
		userNameField.clear();
		userNameField.sendKeys(user);
		
		passwordField.clear();
		passwordField.sendKeys(password);
		
		if(rememberMe.isSelected()){ //disable remember me option
			rememberMe.click();
		}
		
		enterButton.click();
		return new Inbox(driver);
	}
}
