package freddie.frameworks;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import freddie.utilities.DriverFactory;
import freddie.utilities.GlobalSettings;

public class JUnitLoginTest {
	private WebDriver driver;
	private String email = "rachel.simmons@testemail.com";
	private String password = "password";

	@Before
	public void setUp() throws Exception {
		// Initialize the Driver
		driver = DriverFactory.start("chrome");
		driver.get(GlobalSettings.AMSWebURL);
	}

	@After
	public void tearDown() throws Exception {
		// Close the Driver
		driver.quit();
	}

	@Test
	public void loginTest() {
		String pageTitle = driver.getTitle();
		Assert.assertTrue("Login Page Title Checkpoint", pageTitle.contains("SDET"));
		
		// Implement the UI test steps		
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys(email);
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
		driver.findElement(By.id("MainContent_btnLogin")).click();
		
		// Assert a correct login
		/*
		// The Normal Way
		String message = driver.findElement(By.id("conf_message")).getText();
		Assert.assertTrue(message.contains("success"));
		
		// Solution 1: Use Try-Catch Block
		try {
			String message = driver.findElement(By.id("conf_message")).getText();
		} catch (NoSuchElementException e) {
			fail("COULD NOT FIND THE CONFIRMATION MESSAGE WEB ELEMENT");
		}
		
		// Solution 2: Test to see which page you are own (via Page Title or URL) and then develop Assert statement
		String pageURL = driver.getCurrentUrl();
		if (pageURL.equals("http://sdettraining.com/trguitransactions/Dashboard.aspx")) {
			String message = driver.findElement(By.id("conf_message")).getText();
			Assert.assertTrue("Login Message Fail", message.contains("success"));
		}
		else {
			fail("COULD NOT FIND THE CONFIRMATION MESSAGE WEB ELEMENT");
		}
		*/
		// Solution 3: Change item locator to xpath html/body
		String pageText = driver.findElement(By.xpath("html/body")).getText();
		Assert.assertTrue("Login Message Present", pageText.contains("Logged in successfully"));
	}

}
