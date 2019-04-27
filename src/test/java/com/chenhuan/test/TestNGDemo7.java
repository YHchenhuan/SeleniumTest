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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemo7 {

	private WebDriver driver;

	@BeforeMethod
	public void openChro() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\selenium\\SeleniumTest\\src\\main\\resources\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// System.setProperty("webdriver.ie.driver",
		// "D:\\selenium\\SeleniumTest\\src\\main\\resources\\driver\\IEDriverServer.exe");
		// driver = new InternetExplorerDriver();
	}

	@Test
	public void action1() throws InterruptedException, AWTException {
		driver.get("https://www.baidu.com");
		
		Robot robot = new Robot();
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_S);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//		robot.keyRelease(KeyEvent.VK_S);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//		Thread.sleep(5000);
		
	}
	
	@Test
	public void upload() throws InterruptedException, AWTException {
		driver.get("file:///F:/BaiduNetdiskDownload/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
		
		driver.findElement(By.id("load")).sendKeys("C:\\Users\\Administrator\\Pictures\\QQ½ØÍ¼20190318161506.png");
		
		Thread.sleep(5000);
	}
	
	@Test
	public void download() throws InterruptedException, AWTException {
		driver.get("https://shouji.baidu.com/software/25861398.html");
		
		driver.findElement(By.xpath("//div[@class='yui3-u content-main']//a[@class='apk']")).click();
		
		
		Thread.sleep(5000);
	}
	
	@Test
	public void baiduJs() throws InterruptedException, AWTException {
		driver.get("https://www.baidu.com");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("document.getElementById(\"kw\").value=\"selenium\"");
		
		Thread.sleep(3000);
		
	}

	@AfterMethod
	public void quit() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
