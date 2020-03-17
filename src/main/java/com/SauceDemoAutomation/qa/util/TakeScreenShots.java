package com.SauceDemoAutomation.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.SauceDemoAutomation.qa.base.TestBase;

public class TakeScreenShots extends TestBase {

	
	public static void main(String[] args) throws IOException {
		
	// Take screenshot(.getScreenshotAs method) and store as a file format
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
			// Now copy the screenshot to desired location using .copyFile method
			FileUtils.copyFile(src, new File("C:/Users/User/Desktop/eclipse/SauceDemoAutomation/src"
					+ "/ScreenShots.png"));
			
			System.out.println("Screenshots taken");
}
}
