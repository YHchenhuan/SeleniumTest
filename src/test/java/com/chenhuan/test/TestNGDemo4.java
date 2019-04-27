package com.chenhuan.test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemo4 {

	private WebDriver driver;

	@BeforeMethod
	public void openChro() {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\SeleniumTest\\src\\main\\resources\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
//		System.setProperty("webdriver.ie.driver", "D:\\selenium\\SeleniumTest\\src\\main\\resources\\driver\\IEDriverServer.exe");
//		driver = new InternetExplorerDriver();
	}

	@Test
	public void alert() throws InterruptedException {
		driver.get("file:///F:/BaiduNetdiskDownload/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
		WebElement findElement = driver.findElement(By.xpath("//*[@id=\"alert\"]/input"));
		findElement.click();
		
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		alert.accept();
		Thread.sleep(3000);
		Assert.assertEquals(text, "请点击确定");
	}
	
	@Test
	public void confirm() throws InterruptedException {
		driver.get("file:///F:/BaiduNetdiskDownload/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
		WebElement findElement = driver.findElement(By.xpath("//*[@id=\"confirm\"]/input"));
		findElement.click();
		
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
//		alert.accept();
		alert.dismiss();
		Thread.sleep(3000);
		alert.accept();
		Thread.sleep(3000);
	}
	
	@Test
	public void prompt() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver","D:\\selenium\\SeleniumTest\\src\\main\\resources\\driver\\geckoDriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("file:///F:/BaiduNetdiskDownload/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
		WebElement findElement = driver.findElement(By.xpath("//*[@id=\"prompt\"]/input"));
		findElement.click();
		
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
		
		alert.sendKeys("test");
		Thread.sleep(3000);
		alert.accept();
		Thread.sleep(3000);
		alert.accept();
	}
	
	@Test
	public void iframe() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("file:///F:/BaiduNetdiskDownload/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
//		WebElement findElement = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[15]/td[2]/iframe"));
		
		driver.switchTo().frame("aa");
		
		driver.findElement(By.xpath("//*[@id=\"link\"]/a")).click();
		
		Thread.sleep(5000);
		
	}
	
	@Test
	public void iframeRet() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("file:///F:/BaiduNetdiskDownload/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
//		WebElement findElement = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[15]/td[2]/iframe"));
		
		driver.switchTo().frame("aa");
		
		driver.findElement(By.xpath("//*[@id=\"link\"]/a")).click();
		
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("登陆界面")).click();
		
		Thread.sleep(5000);
	}
	
	@Test
	public void select() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("file:///F:/BaiduNetdiskDownload/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
	
		WebElement selectElement = driver.findElement(By.xpath("//*[@id=\"moreSelect\"]"));
		
		Select select = new Select(selectElement);
		
		select.selectByIndex(2);
		Thread.sleep(5000);
		select.selectByValue("huawei");
		Thread.sleep(5000);
		select.selectByVisibleText("xiaomi");
		Thread.sleep(5000);
	}
	
	@Test
	public void doubleWin() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("file:///F:/BaiduNetdiskDownload/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
	
		WebElement openWinEle = driver.findElement(By.xpath("//*[@id=\"open\"]/a"));
		openWinEle.click();
		
		String handle = driver.getWindowHandle();
		System.out.println(handle);
		for(String handles : driver.getWindowHandles()) {
			if(handles.equals(handle))
				continue;
				driver.switchTo().window(handles);
		}
		driver.findElement(By.linkText("baidu")).click();
		
		Thread.sleep(3000);
		
		driver.close();
		
//		driver.switchTo().window(handle);
//		
		Thread.sleep(3000);
		
		
		
	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}
}
