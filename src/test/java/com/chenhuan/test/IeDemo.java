package com.chenhuan.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IeDemo {

	private WebDriver driver;

	@BeforeMethod
	public void openChro() {
		
//		DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
//		dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//		dc.setCapability("ignoreProtectedModeSettings", true);
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);

		System.setProperty("webdriver.ie.driver", "C:\\Program Files (x86)\\Internet Explorer\\IEDriverServer.exe");
		driver = new InternetExplorerDriver(8080);
	}
	
	@Test
	public void testIe() throws InterruptedException {
		driver.manage().window().maximize();
		driver.navigate().to("https://www.so.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.findElement(By.id("input")).sendKeys("ssss");
	}
	
	@Test
	public void testIeYsb() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("http://115.47.119.217:1025/nn-ysb-web");
		
		driver.findElement(By.xpath("//input[@id='loginName']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='loginPwd']")).sendKeys("admin");
		driver.findElement(By.xpath("//button[@id='loginBtn']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("body.page-header-fixed.page-sidebar-closed-hide-logo.page-content-white:nth-child(2) div.page-wrapper div.page-container div.page-sidebar-wrapper div.page-sidebar.navbar-collapse.collapse ul.page-sidebar-menu.page-header-fixed li.nav-item:nth-child(3) > a.nav-link.nav-toggle:nth-child(1)")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//ul[7]//li[1]//a[1]")).click();
		Thread.sleep(1000);
		WebElement iframe = driver.findElement(By.id("coby"));
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//div[@class='form-inline py-2']//div[1]//input[1]")).sendKeys("SK122713232900000523");
		driver.findElement(By.xpath("//div[2]//button[1]")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm']")).click();
		driver.findElement(By.xpath("//tr[1]//td[10]")).click();
		
		
		Thread.sleep(10000);
	}
	
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
}
