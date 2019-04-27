package com.chenhuan.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemo8 {

	private WebDriver driver;

	@BeforeMethod
	public void openChro() {
		System.setProperty("phantomjs.binary.path", "D:\\drivers\\phantomjs.exe");
		driver = new PhantomJSDriver();
		// System.setProperty("webdriver.ie.driver",
		// "D:\\selenium\\SeleniumTest\\src\\main\\resources\\driver\\IEDriverServer.exe");
		// driver = new InternetExplorerDriver();
	}

	@Test
	public void phantjs() throws InterruptedException, AWTException {
		driver.get("https://www.baidu.com");
		
		driver.findElement(By.xpath("//a[contains(text(),'新闻')]")).click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		System.out.println(title);
		
	}

	@AfterMethod
	public void quit() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
