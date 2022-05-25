package com.myfirstproject.day_06_Alert_Iframe;

import com.myfirstproject.utilities.Test_Base;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Alerts extends Test_Base {
/*
Go to https://the-internet.herokuapp.com/javascript_alerts
Create a class: AlertTest
Create setUp method
Create 3 test methods:
acceptAlert() => click on the first alert, verify the text “I am a JS Alert” , click OK , and Verify “You successfully clicked an alert”
dismissAlert()=> click on the second alert, verify text "I am a JS Confirm”, click cancel, and Verify “You clicked: Cancel”
sendKeysAlert()=> click on the third alert, verify text “I am a JS prompt”, type “Hello World”, click OK, and Verify “You entered: Hello Word”
 */

    @Test
    public void acceptAlert() throws InterruptedException {
//    acceptAlert() => click on the first alert, verify the text “I am a JS Alert” ,
//    click OK ,and Verify “You successfully clicked an alert”
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        String actualAlertText = driver.switchTo().alert().getText();
        Thread.sleep(1500);
        String expectedAlertText = "I am a JS Alert";
        Assert.assertEquals(expectedAlertText, actualAlertText);
        // click ok
        driver.switchTo().alert().accept();
        String actualResultText = driver.findElement(By.id("result")).getText();
        String expectedResultText = "You successfully clicked an alert";
        Assert.assertEquals(expectedResultText, actualResultText);
    }

    @Test
    public void dismissAlert() throws InterruptedException {
//    dismissAlert()=> click on the second alert,
//    verify text "I am a JS Confirm”,
//    click cancel,
//    and Verify “You clicked: Cancel”
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//        click on the second alert,
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Thread.sleep(2000);
//    verify text "I am a JS Confirm”,
        String actualAlertText = driver.switchTo().alert().getText();
        String expectedAlertText = "I am a JS Confirm";
        Assert.assertEquals(expectedAlertText,actualAlertText);
//    click cancel
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);
//    and Verify “You clicked: Cancel”
        String expectedResultText="You clicked: Cancel";
        String actualResultText = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(expectedResultText,actualResultText);
    }

    @Test
    public void sendKeys() throws InterruptedException {
//    sendKeysAlert()
//    => click on the third alert,
//    verify text “I am a JS prompt”,
//    type “Hello World”,
//    click OK,
//    and Verify “You entered: Hello Word”
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//    => click on the third alert,
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Thread.sleep(5000);
//    verify text “I am a JS prompt”,
        Assert.assertEquals("I am a JS prompt",driver.switchTo().alert().getText());
//    type “Hello World”,
        driver.switchTo().alert().sendKeys("Hello World");
//    click OK,
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
//    and Verify “You entered: Hello World”
        Assert.assertEquals("You entered: Hello World",driver.findElement(By.id("result")).getText());
    }
}
