package com.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class EcommerceDemoTest {
	WebDriver driver;
	int timeWait = 10000;
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "/home/siddharth/drive/pe_selenium/driver/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
    public void goToTheEcommerceApp() {
        driver.get("https://www.demoblaze.com/");
        System.out.println("Title of the page is: " + driver.getTitle());
    }

	@Test(priority = 2)
	public void login(){
		Dotenv dotenv = Dotenv.load();
		String username = dotenv.get("WEB_USERNAME");
		String password = dotenv.get("PASSWORD");

        try {
            Thread.sleep(timeWait);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.get("https://www.demoblaze.com/");

		WebElement loginButton = driver.findElement(By.id("login2"));
		loginButton.click();

        try {
            Thread.sleep(timeWait);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

		WebElement usernameField = driver.findElement(By.id("loginusername"));
		usernameField.sendKeys(username);

		WebElement passwordField = driver.findElement(By.id("loginpassword"));
		passwordField.sendKeys(password);

		WebElement confirmLoginButton = driver.findElement(By.xpath("//button[contains(text(), 'Log in')]"));
		confirmLoginButton.click();

        try {
            Thread.sleep(timeWait);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

		WebElement logoutButton = driver.findElement(By.id("logout2"));
		if (logoutButton.isDisplayed()) {
			System.out.println("Login successful!");
		} else {
			System.out.println("Login failed!");
		}
    }

	@Test(priority = 3)
	public void AddToCart(){
		String Category = "Laptops";
		String Product = "MacBook air";

		try {
			Thread.sleep(timeWait);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		driver.get("https://www.demoblaze.com/");

		try {
			Thread.sleep(timeWait);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		WebElement categoryElement = driver.findElement(
				By.xpath(
						"//*[@id='itemc' and text()='" + Category + "']"
				)
		);
		categoryElement.click();

		try {
			Thread.sleep(timeWait);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		WebElement productElement = driver.findElement(
			By.linkText(Product)
		);

		productElement.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

		WebElement productTitle = driver.findElement(
				By.className("name")
		);

		if(productTitle.isDisplayed()){
			System.out.println("Product page for " + productTitle + " loaded");
		} else {
			System.out.println("It doesn't loaded properly");
		}

		WebElement addToCartButton = driver.findElement(
				By.xpath("//a[text()='Add to cart']")
		);
		addToCartButton.click();
		System.out.println("Added to Cart");
    }

	@AfterTest
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
