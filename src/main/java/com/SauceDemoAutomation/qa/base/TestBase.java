package com.SauceDemoAutomation.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.SauceDemoAutomation.qa.util.TestUtil;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:/Users/User/Desktop/eclipse/SauceDemoAutomation"
					+ "/src/main/java/com/SauceDemoAutomation/qa/config/config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browser_name = prop.getProperty("browser");
		
		if (browser_name.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browser_name.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browser_name.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "D:\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		driver.get(prop.getProperty("url"));
		
	}	
}
