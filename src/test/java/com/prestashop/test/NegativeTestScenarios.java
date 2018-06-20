package com.prestashop.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class NegativeTestScenarios {

	WebDriver d;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/seleniumDependancy/drivers/chromedriver.exe");
		d = new ChromeDriver();
	}

 @Test
public void wrongCredentialTest() {
 d.get("http://automationpractice.com");
 d.findElement(By.xpath("//a[@class='login']")).click();
 d.findElement(By.xpath("//input[@id='email']")).sendKeys("nari-1006@mail.ru");
 d.findElement(By.xpath("//input[@id='passwd']")).sendKeys("n10064a5665");
 d.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
 WebElement failed=d.findElement(By.xpath("//div[@class='alert alert-danger']/ol/li"));
 failed.getText();

 Assert.assertTrue(failed.isDisplayed());
 
 }
	@Test
	public void invalidEmailTest() {
		d.get("http://automationpractice.com");
		d.findElement(By.xpath("//a[@class='login']")).click();
		d.findElement(By.xpath("//input[@id='email']")).sendKeys("nari-1006@.ru");
		d.findElement(By.xpath("//input[@id='passwd']")).sendKeys("n10064a5665");
		d.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
		WebElement failed= d.findElement(By.xpath("//div[@class='alert alert-danger']/ol/li"));
		failed.getText();
		Assert.assertTrue(failed.isDisplayed());
	}
	
	@Test
	public void blankEmailTest() {
		d.get("http://automationpractice.com");
		d.findElement(By.xpath("//a[@class='login']")).click();
		d.findElement(By.xpath("//input[@id='email']"));
		d.findElement(By.xpath("//input[@id='passwd']")).sendKeys("n10064a5665");
		d.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
		WebElement failed= d.findElement(By.xpath("//div[@class='alert alert-danger']/ol/li"));
		failed.getText();
		Assert.assertTrue(failed.isDisplayed());

}
	@Test
	public void blankPasswordTest() {
		d.get("http://automationpractice.com");
		d.findElement(By.xpath("//a[@class='login']")).click();
		d.findElement(By.xpath("//input[@id='email']")).sendKeys("nari-1006@mail.ru");;
		d.findElement(By.xpath("//input[@id='passwd']"));
		d.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
		WebElement failed= d.findElement(By.xpath("//div[@class='alert alert-danger']/ol/li"));
		failed.getText();
		Assert.assertTrue(failed.isDisplayed());

	}@AfterClass
	public void close() {
		
		d.quit();
	}
	}
