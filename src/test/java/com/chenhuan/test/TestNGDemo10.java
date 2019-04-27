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
import org.testng.annotations.Test;

public class TestNGDemo10 {

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

	@Test
	public void login163() throws InterruptedException, AWTException {
		driver.get("https://mail.163.com/");
		
		WebElement iframe = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[3]/div[3]/div[1]/div[1]/iframe[1]"));
		
		driver.switchTo().frame(iframe);
		
		driver.findElement(By.name("email")).sendKeys("meyoungtester");
		driver.findElement(By.name("password")).sendKeys("meyoung123");
		driver.findElement(By.id("dologin")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));
		
		String loginSucMsg = driver.findElement(By.xpath("//*[@id=\\\"nerror\\\"]/div[2]")).getText();
		System.out.println(loginSucMsg);
		
		Assert.assertEquals(loginSucMsg, "退出");
		
	}
	
	@Test
	public void loginErr163() throws InterruptedException, AWTException {
		driver.get("https://mail.163.com/");
		
		WebElement iframe = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[3]/div[3]/div[1]/div[1]/iframe[1]"));
		
		driver.switchTo().frame(iframe);
		
		driver.findElement(By.name("email")).sendKeys("meyoungtester");
		driver.findElement(By.name("password")).sendKeys("meyoung1233");
		driver.findElement(By.id("dologin")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"nerror\"]/div[2]")));
		
		String err = driver.findElement(By.xpath("//*[@id=\"nerror\"]/div[2]")).getText();
		System.out.println(err);
		
		Assert.assertEquals(err, "帐号或密码错误");
		
	}

	@Test
	public void reg163() throws InterruptedException, AWTException {
		driver.get("https://mail.163.com/");
		
		WebElement iframe = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[3]/div[3]/div[1]/div[1]/iframe[1]"));
		
		driver.switchTo().frame(iframe);
		
		String time = String.valueOf(System.currentTimeMillis()/100);
		driver.findElement(By.id("nameIpt")).sendKeys("ss"+time);
		driver.findElement(By.id("mainPwdIpt")).sendKeys("a123123");
		driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("a123123");
		driver.findElement(By.id("vcodeIpt")).sendKeys("123123");
		driver.findElement(By.id("vcodeIpt")).sendKeys("123123");
		driver.findElement(By.id("mainMobileIpt")).sendKeys("18911111111");
		driver.findElement(By.id("mainRegA")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"m_mainPwd\"]/span")));
		
		String errorMsg = driver.findElement(By.xpath("//*[@id=\"m_mainPwd\"]/span")).getText();
		System.out.println(errorMsg);
		
		Assert.assertEquals(errorMsg, "  密码过于简单，请尝试“字母+数字”的组合");
		
	}
	
	@Test
	public void sendEmail() throws InterruptedException, MalformedURLException {
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		
		driver = new RemoteWebDriver(new URL("http://172.22.130.1:4444/wd/hub"), dc);
		
		driver.get("https://mail.163.com/");
		TestNGDemo10.login163Util(driver, "meyoungtester", "meyoung123");
		
		//获取写信按钮，并点击
		driver.findElement(By.xpath("//*[@class='js-component-component ra0 mD0']")).click();
		
		//填写收件人
		driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("meyoungtester@163.com");
		//填写主题
		driver.findElement(By.xpath("//*[@aria-label='邮件主题输入框，请输入邮件主题']/input")).sendKeys("selenium test");
		//添加附件
		driver.findElement(By.xpath("//input[@class='O0']")).sendKeys("C:\\Users\\Administrator\\Desktop\\电子卡03.xls");
		
		//添加内容
		driver.switchTo().frame(driver.findElement(By.className("APP-editor-iframe")));
		
		driver.findElement(By.xpath("//body[@class='nui-scroll']")).sendKeys("test selenium");
		
		driver.switchTo().defaultContent();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='jp0']/div[1]")));
		
		driver.findElement(By.xpath("//*[@class='jp0']/div[1]")).click();;
		
//		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='发送成功']")));
		
		String sucMsg = driver.findElement(By.xpath("//*[text()='发送成功']")).getText();
		System.out.println(sucMsg);
		Assert.assertEquals(sucMsg, "发送成功可用手机接收回复");
	}
	
	public static void login163Util(WebDriver driver, String userName, String passWord) {
		WebElement iframe = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[3]/div[3]/div[1]/div[1]/iframe[1]"));
		
		driver.switchTo().frame(iframe);
		
		driver.findElement(By.name("email")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(passWord);
		driver.findElement(By.id("dologin")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String loginSucMsg = driver.findElement(By.linkText("退出")).getText();
		System.out.println(loginSucMsg);
		
		Assert.assertEquals(loginSucMsg, "退出");
	}
	
	@AfterMethod
	public void quit() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
