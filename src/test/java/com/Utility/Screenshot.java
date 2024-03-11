package com.Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	public static void getScreenshot(WebDriver driver) throws IOException {
		File s= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File d= new File("C://Users//monik//eclipse-workspace//api_testing//QDTASHRM//Screenshots//.png");
		FileUtils.copyFile(s, d);
	}

}
