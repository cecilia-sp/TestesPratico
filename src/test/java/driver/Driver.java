package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	static WebDriver driver;

	public static void createDriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public static WebDriver getDriver() {
		if (driver == null)
			createDriver();
		return driver;
	}

	public static void closedDriver() {
		if (driver != null) {
			driver.close();
		}
	}


	public void quitDriver() {
		if (null != driver) {
			driver.quit();
			driver = null;
		}
	}



}
