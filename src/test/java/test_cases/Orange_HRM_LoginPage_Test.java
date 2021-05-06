package test_cases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Test_Base;
import page_objects.Orange_HRM_HomePage_Objects;
import page_objects.Orange_HRM_LoginPage_Objects;

public class Orange_HRM_LoginPage_Test extends Test_Base {

	Orange_HRM_LoginPage_Objects orange_HRM_LoginPage_Objects;
	Orange_HRM_HomePage_Objects orange_HRM_HomePage_Objects;
	String actual;
	String expected_loginPage_title = "OrangeHRM";

	public Orange_HRM_LoginPage_Test() {
		super();
	}

	@BeforeMethod
	public void launch_browser() {
		initialization();
		orange_HRM_LoginPage_Objects = new Orange_HRM_LoginPage_Objects();
	}

	@Test(priority=1)
	public void loginPage_title_test() {
		actual = orange_HRM_LoginPage_Objects.get_page_title();
		System.out.println(actual);
		Assert.assertEquals(expected_loginPage_title, actual);
	}

	@Test(priority=2)
	public void login_to_application() {
		orange_HRM_HomePage_Objects = orange_HRM_LoginPage_Objects.login_application(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println(orange_HRM_LoginPage_Objects.verify_welcome_text());
		Assert.assertTrue(orange_HRM_LoginPage_Objects.verify_welcome_text().contains("Welcome"));
	}

	@AfterMethod
	public void close_browser() {
		driver.quit();
	}
}
