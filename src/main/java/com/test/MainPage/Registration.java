package com.test.MainPage;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Registration {

	RemoteWebDriver driver;

	By email = By.xpath("//input[@id='email']");
	By pswd = By.xpath("//input[@id='password']");

	public Registration(RemoteWebDriver driver) {

		this.driver = driver;
	}

	public void regDetails(String emailid, String password) throws Exception {

		// Click on Register link in Login page
		driver.findElement(
				By.xpath("/html/body/app-root/app-register/section/div/div[2]/app-login/div/div/form/div[4]/a"))
				.click();
		Thread.sleep(2000);

		// Registration details
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("PtgGroup");
		driver.findElement(email).sendKeys(emailid);
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Chicago");
		driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("123456");
		driver.findElement(pswd).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='utility_company']")).sendKeys("PeopleTech"); // Company utility data
		driver.findElement(By.xpath("//input[@id='account_number']")).sendKeys("1305563290020");

		// Click on Register button
		driver.findElement(By.xpath("//button[@class='btn btn-success float-right']")).click();

		EventFiringWebDriver we1 = new EventFiringWebDriver(driver);
		File src = we1.getScreenshotAs(OutputType.FILE);
		File desc = new File("./Screenshots/registration.png");
		FileUtils.copyFile(src, desc);

		Thread.sleep(2000);

		// Click on Login button
		driver.findElement(By.xpath("//button[@class='btn text-success mt-4']")).click();

		System.out.println("New user registered sucessfully");

		// Screenshot for Successful registration

		// Calling login from main
		Login login = new Login(driver);
		login.Loginpage(emailid, password);
		Thread.sleep(2000);
	}
}
