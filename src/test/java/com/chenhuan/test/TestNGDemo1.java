package com.chenhuan.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGDemo1 {
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("调用beforeTest");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("调用beforeMethod");
	}
	
	@Test
	public void testCase1() {
		System.out.println("调用testCase1");
	}
	
	@Test
	public void testCase11() {
		System.out.println("调用testCase2");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("调用afterTest");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("调用afterMethod");
	}
	
	@Test
	public void assertTest() {
		System.out.println("assert");
		String a = "1234";
		String b = "1234";
		Assert.assertEquals(a, b, "不符合预期");
		
	}
}
