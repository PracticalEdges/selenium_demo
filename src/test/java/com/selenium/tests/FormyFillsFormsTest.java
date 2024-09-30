package com.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class FormyFillsFormsTest {
    WebDriver driver;
    int timeToWaitInSeconds = 10;
    String firstName;
    String lastName;
    String jobTitle;

    FormyFillsFormsTest(){
        this.firstName = "John";
        this.lastName = "Doe";
        this.jobTitle = "IT Engineer";
    }

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "/home/siddharth/drive/pe_selenium/driver/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void fillFirstForm(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWaitInSeconds));

            driver.get("https://formy-project.herokuapp.com");

            WebElement fullFormTag = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/li[14]/a")));
            fullFormTag.click();
            
            WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
            firstNameField.sendKeys(this.firstName);

            WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("last-name")));
            lastNameField.sendKeys(this.lastName);

            WebElement jobTitleField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("job-title")));
            jobTitleField.sendKeys(this.jobTitle);

            WebElement collegeEducationRadioButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("radio-button-2")));
            collegeEducationRadioButton.click();

            WebElement genderCheckBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("checkbox-1")));
            genderCheckBox.click();

            WebElement experienceDropDown = wait.until(ExpectedConditions.elementToBeClickable(By.id("select-menu")));
            experienceDropDown.click();
            WebElement experienceOptions = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[@value='2']")));
            experienceOptions.click();

            WebElement dateField = wait.until(ExpectedConditions.elementToBeClickable(By.id("datepicker")));
            dateField.sendKeys("09/30/2024");

            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Submit')]")));
            submitButton.click();

            WebElement confirmationText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert")));
            if(confirmationText.isDisplayed()){
                System.out.println("Form Submitted successfully");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 2)
    public void openCloseModal(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWaitInSeconds));

            driver.get("https://formy-project.herokuapp.com");

            WebElement modalTag = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/li[10]/a")));
            modalTag.click();

            WebElement openModalButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("modal-button")));
            openModalButton.click();

            WebElement closeModalButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("close-button")));
            closeModalButton.click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @AfterTest
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
