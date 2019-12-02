package com.test.BaseUrl;

import java.net.URL;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.test.MainPage.Registration;
//import MainPage.Registration;

public class LaunchUrl {

	RemoteWebDriver driver;

	String email = RandomStringUtils.randomAlphabetic(8)+"@gmail.com";
	protected String psw = "Welcome@ptg99";

	@Test
	public void LaunchBrowser() throws Exception {

		System.setProperty("webdriver.chrome.driver", "G:\\Selenium Drivers\\Drivers\\chromedriver.exe");
		DesiredCapabilities dc=new DesiredCapabilities().chrome();
		
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WINDOWS);
		//selenium-remote must be updated in '/etc/hosts' 
		URL url=new URL("http://selenium-remote:4444/wd/hub");
		
		RemoteWebDriver driver=new RemoteWebDriver(url,dc);
		
		driver.get("http://15.206.16.180/");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		System.out.println("WHYgere Application launched sucessfully");

		Registration re = new Registration(driver);
		re.regDetails(email, psw);

	}

}
