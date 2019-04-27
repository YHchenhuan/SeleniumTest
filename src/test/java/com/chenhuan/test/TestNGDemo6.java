package com.chenhuan.test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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

public class TestNGDemo6 {

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
	public void action1() throws InterruptedException {
		driver.get("https://www.baidu.com");
		
		WebElement findElement = driver.findElement(By.id("su"));
		
		Actions action = new Actions(driver);
		
		action.contextClick(findElement).perform();
		
		Thread.sleep(3000);
		
		action.doubleClick(findElement).perform();
	}
	
	@Test
	public void mouseMoveTo() throws InterruptedException {
		driver.get("file:///F:/BaiduNetdiskDownload/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
		
		WebElement findElement = driver.findElement(By.xpath("//*[@id=\"action\"]/input"));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(findElement).perform();
		Thread.sleep(3000);
		
		String text = driver.findElement(By.xpath("//*[@id=\"over\"]/div")).getText();
		System.out.println(text);
		Assert.assertEquals(text, "Hello World!");
	}

	@Test
	public void dragTo() throws InterruptedException {
		driver.get("file:///F:/BaiduNetdiskDownload/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/dragAndDrop.html");
		
		WebElement findElement = driver.findElement(By.id("drag"));
		
		Actions action = new Actions(driver);
		action.dragAndDropBy(findElement, 500, 500).perform();
		
		Thread.sleep(5000);
		
	}
	
	@Test
	public void dragTo2() throws InterruptedException {
		driver.get("file:///F:/BaiduNetdiskDownload/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/dragAndDrop.html");
		
		WebElement start = driver.findElement(By.id("drag"));
		WebElement end = driver.findElement(By.xpath("/html/body/h1"));
		
		Thread.sleep(2000);
		
		Actions action = new Actions(driver);
		
		action.dragAndDrop(start, end).perform();
		
		Thread.sleep(3000);
	}
	
	@Test
	public void dragTo3() throws InterruptedException {
		driver.get("file:///F:/BaiduNetdiskDownload/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/dragAndDrop.html");
		
		WebElement start = driver.findElement(By.id("drag"));
		WebElement end = driver.findElement(By.xpath("/html/body/h1"));
		
		Thread.sleep(2000);
		
		Actions action = new Actions(driver);
		
		action.clickAndHold(start).moveToElement(end).release(start).perform();
		
		Thread.sleep(3000);
	}
	
	@Test
	public void selectDoubles() throws InterruptedException {
		driver.get("file:///F:/BaiduNetdiskDownload/Web自动化selenium+java/源码/webdriver_demo/selenium_html/index.html");
		Thread.sleep(2000);
		WebElement selectElement = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
		
		List<WebElement> optionList = selectElement.findElements(By.tagName("option"));
		
		Actions action = new Actions(driver);
		
		action.keyDown(Keys.SHIFT)
				.click(optionList.get(0))
				.click(optionList.get(2))
				.keyUp(Keys.SHIFT)
				.perform();
		
		Thread.sleep(3000);
	}
	
	@Test
	public void selectDoubles2() throws InterruptedException {
		driver.get("file:///F:/BaiduNetdiskDownload/Web自动化selenium+java/源码/webdriver_demo/selenium_html/index.html");
		Thread.sleep(2000);
		WebElement selectElement = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
		
		List<WebElement> optionList = selectElement.findElements(By.tagName("option"));
		
		Actions action = new Actions(driver);
		
		action.keyDown(Keys.CONTROL)
				.click(optionList.get(2))
				.click(optionList.get(3))
				.keyUp(Keys.CONTROL)
				.perform();
		
		Thread.sleep(3000);
	}


	@AfterMethod
	public void quit() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
