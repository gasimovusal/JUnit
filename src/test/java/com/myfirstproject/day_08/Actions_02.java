package com.myfirstproject.day_08;

import com.myfirstproject.utilities.Test_Base;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Actions_02 extends Test_Base {

    /*
    Create a class: Actions2
    Create test method : hoverOver() and test the following scenario:
    Given user is on the https://www.amazon.com/
    When use click on “Account” link
    Then verify the page title contains “Your Account”
     */
    @Test
    public void hoverOver() throws InterruptedException {
        // Given user is on the https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        // when use click on Account
        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountList).perform();
        Thread.sleep(1500);
        // clicking on account link
        driver.findElement(By.linkText("Account")).click();
        // Then verify the page title contains “Your Account”
        Assert.assertTrue(driver.getTitle().contains("Your Account"));
        Thread.sleep(1000);

    }
}
