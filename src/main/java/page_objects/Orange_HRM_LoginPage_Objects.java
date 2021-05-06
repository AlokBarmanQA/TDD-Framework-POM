package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Test_Base;

public class Orange_HRM_LoginPage_Objects extends Test_Base{
	
	@FindBy(id="txtUsername")
	WebElement txt_usename;
	
	@FindBy(id="txtPassword")
	WebElement txt_password;
	
	@FindBy(id="btnLogin")
	WebElement btn_login;
	
	@FindBy(id="welcome")
	WebElement txt_welcome;
	
	public Orange_HRM_LoginPage_Objects() {
		super();
		PageFactory.initElements(driver, this);
	}
	public String get_page_title() {
		return driver.getTitle();
	}
	public Orange_HRM_HomePage_Objects login_application(String un, String pwd) {
		txt_usename.sendKeys(un);
		txt_password.sendKeys(pwd);
		btn_login.click();
		return new Orange_HRM_HomePage_Objects();
	}

	public String verify_welcome_text() {
		return txt_welcome.getText();
	}
}
