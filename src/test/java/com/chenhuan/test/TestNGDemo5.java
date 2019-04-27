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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemo5 {

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
	public void waitTest() throws InterruptedException {
		driver.get(
				"file:///F:/BaiduNetdiskDownload/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
		driver.findElement(By.className("wait")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement findElement = driver.findElement(By.xpath("//*[@id=\"display\"]/div"));
		String text = findElement.getText();
		System.out.println(text);
		Assert.assertEquals(text, "wait for display");

	}

	@Test
	public void waitTest2() throws InterruptedException {
		driver.get("file:///F:/BaiduNetdiskDownload/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
		driver.findElement(By.className("wait")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"display\"]/div")));

		WebElement findElement = driver.findElement(By.xpath("//*[@id=\"display\"]/div"));
		String text = findElement.getText();
		System.out.println(text);
		Assert.assertEquals(text, "wait for display");

	}

	@AfterMethod
	public void quit() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
