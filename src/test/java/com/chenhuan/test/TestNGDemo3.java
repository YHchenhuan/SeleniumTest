package com.chenhuan.test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemo3 {

	private WebDriver driver;

	@BeforeMethod
	public void openChro() {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\SeleniumTest\\src\\main\\resources\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
//		System.setProperty("webdriver.ie.driver", "D:\\selenium\\SeleniumTest\\src\\main\\resources\\driver\\IEDriverServer.exe");
//		driver = new InternetExplorerDriver();
	}

	@Test
	public void findById() throws InterruptedException {
		driver.get("https://www.baidu.com");
		WebElement webElement = driver.findElement(By.id("kw"));
		
	}
	
	@Test
	public void findByName() throws InterruptedException {
		driver.get("https://www.baidu.com");
		WebElement webElement = driver.findElement(By.name("wd"));
		
	}
	
	@Test
	public void findByClassName() throws InterruptedException {
		driver.get("https://www.baidu.com");
		WebElement webElement = driver.findElement(By.className("bg s_btn"));
		Thread.sleep(5000);
	}
	
	@Test
	public void findLinkText() throws InterruptedException {
		driver.get("https://www.baidu.com");
		WebElement webElement = driver.findElement(By.linkText("hao123"));
	}
	
	@Test
	public void findPartialLinkText() throws InterruptedException {
		driver.get("https://www.baidu.com");
		WebElement webElement = driver.findElement(By.partialLinkText("hao"));
	}
	
	@Test
	public void findTagName() throws InterruptedException {
		driver.get("https://www.baidu.com");
		List<WebElement> findElements = driver.findElements(By.tagName("input"));
		System.out.println("多少个input?" + findElements.size());
	}
	
	@Test
	public void findByXPath() throws InterruptedException {
		driver.get("https://www.baidu.com");
		WebElement findElement = driver.findElement(By.xpath("//input[@id='kw']"));
		findElement.sendKeys("test");
		Thread.sleep(5000);
	}
	
	@Test
	public void findByXPath2() throws InterruptedException {
		driver.get("https://www.baidu.com");
		WebElement findElement = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[5]/div[1]/div[1]/form[1]/span[1]/input[1]"));
		findElement.sendKeys("test");
		Thread.sleep(5000);
	}
	
	@Test
	public void findByCss() throws InterruptedException {
		driver.get("https://www.baidu.com");
		WebElement findElement = driver.findElement(By.cssSelector("#kw"));
		findElement.sendKeys("test");
		Thread.sleep(5000);
	}
	
	@Test
	public void findByAllXPath() throws InterruptedException {
		driver.get("https://www.baidu.com");
		List<WebElement> findElements = driver.findElements(By.xpath("/html/body/div[1]/div[1]/div/div[3]/a"));
		for (WebElement webElement : findElements) {
			System.out.println(webElement.getText());
		}
	}
	
	@Test
	public void testClick() throws InterruptedException {
		driver.get("https://www.baidu.com");
		driver.findElement(By.xpath("//a[contains(text(),'新闻')]")).click();
		Thread.sleep(5000);
	}
	
	@Test
	public void testYsb() throws InterruptedException {
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
	
	@Test
	public void clickNews(){
		driver.get("https://www.baidu.com");
		driver.findElement(By.xpath("//a[contains(text(),'新闻')]")).click();
		String currentUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(currentUrl, "http://news.baidu.com/");
	}
	
	@Test
	public void sendKeys() throws InterruptedException{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://www.baidu.com");
		driver.findElement(By.id("kw")).sendKeys("selenium");
		driver.findElement(By.id("su")).click();
		String title = driver.getTitle();
		Assert.assertEquals(title, "selenium_百度搜索");
		
	}
	
	@Test
	public void clear() throws InterruptedException{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://www.baidu.com");
		WebElement findElement = driver.findElement(By.id("kw"));
		findElement.sendKeys("selenium");
		driver.findElement(By.id("su")).click();
		Thread.sleep(3000);
		findElement.clear();
		Thread.sleep(3000);
	}
	
	@Test
	public void tagname() throws InterruptedException{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://www.baidu.com");
		WebElement findElement = driver.findElement(By.id("kw"));
		String tagName = findElement.getTagName();
		System.out.println(tagName);
		Assert.assertEquals(tagName, "input");
	}
	
	@Test
	public void attribute() throws InterruptedException{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://www.baidu.com");
		WebElement findElement = driver.findElement(By.id("kw"));
		findElement.sendKeys("selenium");
		Thread.sleep(3000);
		String attribute = findElement.getAttribute("value");
		Assert.assertEquals(attribute, "selenium");
	}
	@Test
	public void isDisplayed() throws InterruptedException{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://www.baidu.com");
		WebElement button = driver.findElement(By.id("su"));
		
		boolean displayed = button.isDisplayed();
		
		Assert.assertTrue(displayed);
	}
	
	@Test
	public void isSelected() throws InterruptedException{
		driver.manage().window().maximize();
		driver.get("file:///F:/BaiduNetdiskDownload/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
		
		WebElement findElement = driver.findElement(By.xpath("//*[@id=\"radio\"]/input[2]"));
		Thread.sleep(3000);
		findElement.click();
		Thread.sleep(3000);
		boolean selected = findElement.isSelected();
		
		
		Assert.assertTrue(selected);
	}
	
	@Test
	public void isEnabled() throws InterruptedException{
		driver.manage().window().maximize();
		driver.get("file:///F:/BaiduNetdiskDownload/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
		
		WebElement findElement = driver.findElement(By.xpath("//*[@id=\"button\"]/input[1]"));
		Thread.sleep(3000);
		boolean selected = findElement.isEnabled();
		
		
		Assert.assertFalse(selected);
	}
	
	@Test
	public void isEnabled2() throws InterruptedException{
		driver.manage().window().maximize();
		driver.get("file:///F:/BaiduNetdiskDownload/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
		
		WebElement findElement = driver.findElement(By.xpath("//*[@id=\"id01\"]"));
		Thread.sleep(3000);
		boolean selected = findElement.isEnabled();
		
		
		Assert.assertTrue(selected);
	}
	
	@Test
	public void jietu() throws InterruptedException, IOException{
		driver.manage().window().maximize();
		driver.get("https://www.baidu.com");
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.getFileUtils().copyFile(file, new File("D://360.png"));
	}
	

	@AfterMethod
	public void quit() {
		driver.quit();
	}
}
