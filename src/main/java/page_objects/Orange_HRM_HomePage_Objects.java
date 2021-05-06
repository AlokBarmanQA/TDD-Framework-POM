package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Test_Base;

public class Orange_HRM_HomePage_Objects extends Test_Base{
	@FindBy(id="txtUsername")
	WebElement txt_usename;
	
	@FindBy(id="txtPassword")
	WebElement txt_password;
	
	@FindBy(id="btnLogin")
	WebElement btn_login;
	//--------------------------------------------------------
	@FindBy(xpath="//*[@id='menu_admin_viewAdminModule']/b")
	WebElement tab_admin;
	@FindBy(xpath="//a[@id='menu_admin_UserManagement']")
	WebElement tab_user_management;
	@FindBy(xpath="//a[@id='menu_admin_viewSystemUsers']")
	WebElement link_users;
	@FindBy(xpath="//input[@id='searchSystemUser_userName']")
	WebElement text_box_username;
	@FindBy(xpath="//input[@id='searchBtn']")
	WebElement btn_search;
	@FindBy(xpath="//a[contains(text(),'Admin')]")
	WebElement link_admin;
	public Orange_HRM_HomePage_Objects() {
		super();
		PageFactory.initElements(driver, this);
	}
	public String get_page_title() {
		return driver.getTitle();
	}
	public void login_to_application(String un, String pwd) {
		txt_usename.sendKeys(un);
		txt_password.sendKeys(pwd);
		btn_login.click();
	}
	public void click_on_admin_tab() {
		tab_admin.click();
	}
	public void click_on_users_link() {
		Actions action = new Actions(driver);
		action.moveToElement(tab_user_management).build().perform();
		link_users.click();
	}
	public void enter_search_name(String name) {
		text_box_username.sendKeys(name);
	}
	public void click_on_search_button() {
		btn_search.click();
	}
	public String validate_name_present() {
		return link_admin.getText();
	}
}
