package com.dina.devops;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DinaWebAppTest {
    private ChromeDriver driver;

    @BeforeTest
    public void init() {
        System.out.println("Initializing Chrome driver");
        System.setProperty("webdriver.chrome.driver", "/Users/dgnaneswaran/Downloads/chromedriver");
        driver = new ChromeDriver();
        System.out.println("Starting the test...");
        driver.get("http://10.198.35.223:1256/addressbook/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void verifyTheTitleOfApplication() {
        System.out.println("Starting validate the title of the application test");
        
        String expectedTitle = "Addressbook";
        String actualTitle = driver.getTitle();
        System.out.println("Title is :" + actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "The title of the application is wrong...");
        
        System.out.println("Successfully validated the title of the application");
    }
    
    @Test
    public void verifyUserAbleToClickNewContact() {
        System.out.println("Starting validate user is able to click new contact test");
        String expectedFirstNameText = "First name";
        
        driver.findElement(By.cssSelector(".v-button")).click();
        String acutalFirstNameText = driver.findElement(By.id("gwt-uid-4")).getText();
        System.out.println("Firstname Text is " + acutalFirstNameText);
        Assert.assertEquals(acutalFirstNameText, expectedFirstNameText, "The First Name text is wrong after clicking the Add New Contact button...");
        
        System.out.println("Successfully validated user is able to click new contact test");
    }
    
    @AfterTest
    public void afterTestRun() {
        System.out.println("Closing the application");
        driver.close();
    }
}
