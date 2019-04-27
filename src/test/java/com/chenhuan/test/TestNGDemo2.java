package com.chenhuan.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemo2 {

	private WebDriver driver;

	@BeforeMethod
	public void openChro() {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\SeleniumTest\\src\\main\\resources\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void firefox() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver",
				"D:\\selenium\\SeleniumTest\\src\\main\\resources\\driver\\geckoDriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.baidu.com");
		driver.get("https://www.360.cn");
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();
		Thread.sleep(3000);
		Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void google() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\selenium\\SeleniumTest\\src\\main\\resources\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.baidu.com");
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void ie() throws InterruptedException {
		System.setProperty("webdriver.ie.driver",
				"D:\\selenium\\SeleniumTest\\src\\main\\resources\\driver\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.get("https://www.baidu.com");
		driver.findElement(By.id("kw")).sendKeys("test");
		Thread.sleep(5000);

		driver.quit();

	}

	@Test
	public void window() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\selenium\\SeleniumTest\\src\\main\\resources\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Dimension dimension = new Dimension(300, 300);
		driver.manage().window().setSize(dimension);
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		String currentUrl = driver.getCurrentUrl();
		System.out.println("当前url为：" + currentUrl);
		driver.quit();
	}

	@Test
	public void getCurrentUrl() throws InterruptedException {
		driver.get("https://www.google.com");
		String currentUrl = driver.getCurrentUrl();
		Thread.sleep(3000);
		Assert.assertEquals(currentUrl, "https://www.baidu.com/", "居然不是百度");
		driver.quit();
	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}
}
