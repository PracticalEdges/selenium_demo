package com.selenium.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EcommerceDemo {
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
	}
	
	@Test
    public void testGoogleSearch() {
        // Navigate to Google
        driver.get("https://www.google.com");
        System.out.println("Title of the page is: " + driver.getTitle());
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
