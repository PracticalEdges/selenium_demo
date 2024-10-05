package com.selenium.tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;

public class GoogleSearchTest {
    WebDriver driver;
    int timeToWait;

    GoogleSearchTest(){
        this.timeToWait = 3;
    }

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.gecko.driver", "/home/siddharth/drive/pe_selenium/driver/geckodriver");
        driver = new FirefoxDriver();
    }

    @Test(priority = 2)
    public void SearchAndGoToPageNotTheBestWay(){
        driver.get("https://www.google.com");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium Webdriver Tutorial");
        searchBox.sendKeys(Keys.RETURN);

        // Not a good way to this!
        try{
            Thread.sleep(10000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        List<WebElement> searchResults = driver.findElements(
                By.cssSelector("h3")
        );

        System.out.println("Search Results: ");
        for(WebElement result: searchResults){
            System.out.println(result.getText());
        }

        try{
            Thread.sleep(5000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 1)
    public void searchAndGoToPageGoodWay(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(this.timeToWait));

        driver.get("https://www.google.com");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Vscode tips?");
        searchBox.sendKeys(Keys.RETURN);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3")));

        List<WebElement> searchResults = driver.findElements(By.cssSelector("h3"));
        System.out.println("Search Results: ");
        for(WebElement result: searchResults){
            System.out.println(result.getText());
        }
    }

    @AfterClass
    public void shutDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
