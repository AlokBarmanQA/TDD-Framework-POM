package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test_Base {

	public static Properties prop;
	public static WebDriver driver;

	public Test_Base() {
		try {
			FileInputStream fis = new FileInputStream("../TDD-Framework-POM/src/test/resources/config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		String url = prop.getProperty("url");
		Long implicit_wait = Long.parseLong(prop.getProperty("IMPLICIT_WAIT"));
		Long pageload_time = Long.parseLong(prop.getProperty("PAGE_LOAD_TIMEOUT"));
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("There is no supported browser");
		}
		driver.manage().timeouts().implicitlyWait(implicit_wait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(pageload_time, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
	}
// add comment, change reflected
}
