package com.prestashop.test;

import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class LoginPositiveScenarios {
	WebDriver d;
Faker f;
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/seleniumDependancy/drivers/chromedriver.exe");
		d = new ChromeDriver();
	}

 @Test
public void  loginTest() throws InterruptedException {
 d.get("http://automationpractice.com");
 Thread.sleep(3000);
 Random n= new Random();
 Faker f=new Faker();
 String email=f.ancient().god().toLowerCase()+n.nextInt(20)+"@gmail.com";
 String name= f.ancient().hero().toLowerCase();
 String lastname=f.ancient().god().toLowerCase();
 String password="ar"+n.nextInt(10)+"g"+n.nextInt(10);
 String address=""+n.nextInt(2000)+" w Granville";
 String city= f.address().city();
 
 
 int day=f.number().numberBetween(1, 31);
 int month2=f.number().numberBetween(1, 12);
 int year2=f.number().numberBetween(1950, 2000);
 int state=f.number().numberBetween(1, 50);
 String zip = "" + f.number().numberBetween(1, 9) + f.number().numberBetween(11, 99)
         + f.number().numberBetween(11, 99);
 String phoneNumber = f.phoneNumber().cellPhone();
 
 
 d.findElement(By.xpath("//a[@class='login']")).click();
 d.findElement(By.xpath("//input[@id='email_create']")).sendKeys(email);
 d.findElement(By.xpath("//button[@class='btn btn-default button button-medium exclusive']")).click();
 String curTab = d.getWindowHandle();
	Set<String> windows = d.getWindowHandles();
	for (String newTab : windows) {
		d.switchTo().window(newTab);}
 Thread.sleep(3000);
 d.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys(name);
 Thread.sleep(5000);
 d.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys(lastname); Thread.sleep(5000);

 d.findElement(By.xpath("//input[@id='passwd']")).sendKeys(password);
 Thread.sleep(6000);
/////
 WebElement dayClick = d.findElement(By.xpath("//select[@id='days']"));
	Thread.sleep(1000);
	dayClick.click();
	Thread.sleep(1000);
	Select day1 = new Select(d.findElement(By.xpath("//select[@id='days']")));
	day1.selectByValue("" + day);
	WebElement month = d.findElement(By.xpath("//select[@id='months']"));
	Thread.sleep(1000);
	month.click();
	Thread.sleep(1000);
	Select month1 = new Select(d.findElement(By.xpath("//select[@id='months']")));// //input[@id='postcode']
	month1.selectByValue("" + month2);
	WebElement yaer = d.findElement(By.xpath("//select[@id='years']"));//   //input[@id='phone_mobile']
	Thread.sleep(1000);
	yaer.click();                       //      //button[@id='submitAccount']/span
	Thread.sleep(1000);
	Select year1 = new Select(d.findElement(By.xpath("//select[@id='years']")));// //select[@id='id_country']
	year1.selectByValue("" + year2);
d.findElement(By.xpath("//input[@id='address1']")).sendKeys(address);//  //input[@id='city'] //select[@id='id_state'] 
	d.findElement(By.xpath("//input[@id='city']")).sendKeys(city);
	 WebElement state1 = d.findElement(By.xpath("//select[@id='id_state']"));
		Thread.sleep(1000);
		state1.click();
		Thread.sleep(1000);
		Select state2 = new Select(d.findElement(By.xpath("//select[@id='id_state']")));
		state2.selectByValue("" + state);
		
		d.findElement(By.xpath("//input[@id='postcode']")).sendKeys(zip);
		d.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys( phoneNumber);
	d.findElement(By.xpath(" //button[@id='submitAccount']/span")).click();
	
		d.findElement(By.xpath("//div[@id='page']/div/header/div[2]/div/div/nav/div[2]")).click();
		
		d.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
		
		d.findElement(By.xpath("//input[@id='passwd']")).sendKeys(password);
		d.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
		String atualres=d.findElement(By.xpath("//div[@id='page']/div/header/div[2]/div/div/nav/div[1]")).getText();
		String expecres=name+" "+lastname;
		Assert.assertEquals(atualres, expecres);
		
 }
}
