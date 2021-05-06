package test_cases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Test_Base;
import page_objects.Orange_HRM_HomePage_Objects;
import page_objects.Orange_HRM_LoginPage_Objects;

public class Orange_HRM_Homepage_Test extends Test_Base{

	Orange_HRM_HomePage_Objects orange_HRM_HomePage_Objects;
	Orange_HRM_LoginPage_Objects orange_HRM_LoginPage_Objects;
	String actual;
	String expected_page_title = "OrangeHRM";
	
	public Orange_HRM_Homepage_Test() {
		super();
	}
	@BeforeMethod
	public void launch_browser() {
		initialization();
		orange_HRM_HomePage_Objects = new Orange_HRM_HomePage_Objects();
		orange_HRM_HomePage_Objects.login_to_application(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=1)
	public void verify_page_title() {
		actual = orange_HRM_HomePage_Objects.get_page_title();
		Assert.assertEquals(actual, expected_page_title);
	}
	@Test(priority=2)
	public void verify_existing_user() {
		orange_HRM_HomePage_Objects.click_on_admin_tab();
		orange_HRM_HomePage_Objects.click_on_users_link();
		orange_HRM_HomePage_Objects.enter_search_name("Admin");
		orange_HRM_HomePage_Objects.click_on_search_button();
		actual = "Admin";
		Assert.assertEquals(actual, orange_HRM_HomePage_Objects.validate_name_present());
	}

	@AfterMethod
	public void close_browser() {
		driver.quit();
	}
}
