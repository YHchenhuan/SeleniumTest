package com.chenhuan.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDemo11 {

	private WebDriver driver;

	@BeforeMethod
	public void openChro() {
//		System.setProperty("webdriver.chrome.driver",
//				"D:\\selenium\\SeleniumTest\\src\\main\\resources\\driver\\chromedriver.exe");
//		driver = new ChromeDriver();
//		System.setProperty("webdriver.gecko.driver",
//				"D:\\selenium\\SeleniumTest\\src\\main\\resources\\driver\\geckodriver.exe");
//		driver = new FirefoxDriver();
//		driver.manage().window().maximize();
	}

	@DataProvider(name = "urlData")
	public Object[][] getData(){
		return new Object[][] {
			{"https://www.baidu.com","chrom"},{"https://www.360.cn","firefox"}
		};
	}

	@Test(dataProvider = "urlData")
	public void provideTest(String url, String browser) {
		if(browser.equals("chrom")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\selenium\\SeleniumTest\\src\\main\\resources\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"D:\\selenium\\SeleniumTest\\src\\main\\resources\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		System.out.println("地址为："+url);
		driver.get(url);
	}
	
	@AfterMethod
	public void quit() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
