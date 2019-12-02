package com.test.MainPage;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

	RemoteWebDriver driver;

	By username = By.xpath("//input[@id='email']");
	By password = By.xpath("//input[@id='password']");
	By LoginButton = By.xpath("//button[@class='btn']");

	public Login(RemoteWebDriver driver) {

		this.driver = driver;

	}

	public void Loginpage(String userid, String pswd) throws Exception {

		driver.findElement(username).sendKeys(userid);
		driver.findElement(password).sendKeys(pswd);

		// Login button method calling
		clickLogin();
	}

	public void clickLogin() throws Exception {

		// Click on Login button
		driver.findElement(LoginButton).click();
		System.out.println("User login sucessfully");
		Thread.sleep(2000);
		
		EventFiringWebDriver we1 = new EventFiringWebDriver(driver);
		File src = we1.getScreenshotAs(OutputType.FILE);
		File desc = new File("./Screenshots/loggedin.png");
		FileUtils.copyFile(src, desc);

		// Settings class method calling
		Settings settings = new Settings();
		settings.settingsPage(driver);

	}

	public void Logout() throws Exception {


		WebDriverWait wb = new WebDriverWait(driver, 20);
		wb.until(ExpectedConditions.elementToBeClickable(By.id("logout-menu"))).click();

		System.out.println("Click on logout link");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		System.out.println("Logout successfully");
		Thread.sleep(2000);
//		driver.close();
	
		driver.quit();
	}

}
