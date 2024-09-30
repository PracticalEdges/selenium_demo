package com.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class EcommerceDemoTest {
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
	    System.setProperty("webdriver.gecko.driver", "/home/siddharth/drive/pe_selenium/driver/geckodriver");

	    // Set up FirefoxOptions for headless mode
	    FirefoxOptions options = new FirefoxOptions();
	    options.addArguments("--headless");  // Run in headless mode
	    options.addArguments("--no-sandbox");
	    options.addArguments("--disable-dev-shm-usage");

	    // Instantiate the FirefoxDriver with the options
	    driver = new FirefoxDriver(options);

	    // Maximize the browser window (optional in headless mode)
	    driver.manage().window().maximize();
	}
	
	@Test
    public void testGoogleSearch() {
        // Navigate to Google
        driver.get("https://www.google.com");
        System.out.println("Title of the page is: " + driver.getTitle());
    }

	@AfterTest
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
