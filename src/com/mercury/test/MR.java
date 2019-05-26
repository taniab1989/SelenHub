package com.mercury.test;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.google.common.io.Files;


public class MR {

	WebDriver driver;

	// ===============================================================================

	public void browserAppLaunch() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");
	}
	
	//*********************************************************************************
	/*Simple login process*/
	
	 public void login() throws IOException, InterruptedException {
		WebElement uName = driver.findElement(By.xpath("//input[@name='userName']"));
		uName.sendKeys("dasd");

		WebElement pwd = driver.findElement(By.xpath("//input[@name='password']"));
		pwd.sendKeys("dasd");

		WebElement login = driver.findElement(By.xpath("//input[@value='Login']"));
		login.click();

		Thread.sleep(3000);
	}
	
	/*
	 * Login with screenshot
	 */
	/*public void loginWithScreenShot() throws IOException, InterruptedException, AWTException {
		WebElement uName = driver.findElement(By.xpath("//input[@name='userName']"));
		uName.sendKeys("dasd");

		WebElement pwd = driver.findElement(By.xpath("//input[@name='password']"));
		pwd.sendKeys("dasd");

		//WebElement login = driver.findElement(By.xpath("//input[@value='Login']"));
		//login.click();
		
		
			Robot r1 = new Robot();
			r1.keyPress(KeyEvent.VK_ENTER);

		Thread.sleep(4000);

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File("./screenshots/snap.jpg"));

		Thread.sleep(3000);
	}*/
	
	/*
	 * Login with Robot
	 */
	
	/*public void loginSikuli() throws FindFailed {

		WebElement uName = driver.findElement(By.xpath("//input[@name='userName']"));
		uName.sendKeys("dasd");

		WebElement pwd = driver.findElement(By.xpath("//input[@name='password']"));
		pwd.sendKeys("dasd");

		Screen screen = new Screen();
		Pattern btnLogin = new Pattern("./SikuliFiles/btnLogin.PNG");
		screen.click(btnLogin);
	}
	*/
	
	/*public void sikuliPractise() throws FindFailed 
	
	{
		WebElement uName = driver.findElement(By.xpath("//input[@name='userName']"));
		uName.sendKeys("dasd");
		
		WebElement pwd = driver.findElement(By.xpath("//input[@name='password']"));
		pwd.sendKeys("dasd");
		
		Screen screen = new Screen();
		Pattern btnLogin = new Pattern("./SikuliFiles/btnLogin.PNG");
		screen.click(btnLogin);

	}
	
	/*public void autoITPractise() throws InterruptedException, IOException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://imgbb.com/");
		
		Thread.sleep(4000);

		WebElement btnStartUpload = driver.findElement(By.xpath("//a[@class='btn btn-big blue']"));
		btnStartUpload.click();
		
		Thread.sleep(2000);
		
		Runtime.getRuntime().exec("./autoitexe/Testscript.exe");
		
		Thread.sleep(6000);
		
		WebElement btnUpload = driver.findElement(By.xpath("//button[@class='btn btn-big green']"));
		btnUpload.click();

		Thread.sleep(5000);
	}
	*/
/* Verify Login with boolean return type*/
	
	public boolean verifyLoginWithReturn()
	{
		String actTitle = "Find a Flight: Mercury Tours:";
		String expTitle = driver.getTitle();
		
		System.out.println("System returns the page title: "+ expTitle);
		
		if(actTitle.equals(expTitle))
		{
						System.out.println("Test case passed");
						return true;
		}
		else
		{
			System.out.println("Test case failed");
			return false;
		}
		
	}
	}
