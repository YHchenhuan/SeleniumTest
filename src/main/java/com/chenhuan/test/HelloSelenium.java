package com.chenhuan.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelloSelenium {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("srart selenium");
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		System.setProperty("webdriver.gecko.driver", "/driver/geckoDriver.exe");
		WebDriver driver = new FirefoxDriver();
//		System.setProperty("webdriver.chrome.driver", "/driver/chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		

//		DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
//        dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//        dc.setCapability("ignoreProtectedModeSettings", true);
//		System.setProperty("webdriver.ie.driver", "/driver/IEDriverServer.exe");
//		WebDriver driver = new InternetExplorerDriver();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
		driver.get("http://115.47.119.217:1025/nn-ysb-web");
		driver.findElement(By.id("loginName")).sendKeys("admin");;
		driver.findElement(By.id("loginPwd")).sendKeys("admin");;
		driver.findElement(By.id("loginBtn")).click();
		System.out.println("end selenium");
		driver.navigate().refresh();
		driver.quit();

	}
}
