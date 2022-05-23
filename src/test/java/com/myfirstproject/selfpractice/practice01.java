package com.myfirstproject.selfpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class practice01 {
    /*
Go to https://the-internet.herokuapp.com/javascript_alerts
Create a class: AlertTest
Create setUp method
Create 3 test methods:
acceptAlert() => click on the first alert, verify the text “I am a JS Alert” , click OK , and Verify “You successfully clicked an alert”
dismissAlert()=> click on the second alert, verify text "I am a JS Confirm”, click cancel, and Verify “You clicked: Cancel”
sendKeysAlert()=> click on the third alert, verify text “I am a JS prompt”, type “Hello World”, click OK, and Verify “You entered: Hello Word”
 */
    protected WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void test(){
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        String actualText = driver.switchTo().alert().getText();
        String expectedText = "I am a JS prompt";
        Assert.assertEquals(expectedText, actualText);
        driver.switchTo().alert().sendKeys("“Hello World");
        driver.switchTo().alert().accept();
        String actualMessage = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedMessage = "You entered: Hello Word";
        Assert.assertEquals(expectedMessage, actualMessage);
    }

}
