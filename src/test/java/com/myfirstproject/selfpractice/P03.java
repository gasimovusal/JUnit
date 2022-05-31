package com.myfirstproject.selfpractice;

import com.myfirstproject.utilities.Test_Base;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class P03 extends Test_Base {
    /*
    Create a class: Actions2
    Create test method : hoverOver() and test the following scenario:
    Given user is on the https://www.amazon.com/
    When use click on “Account” link
    Then verify the page title contains “Your Account”
     */

    @Test
    public void hoverOver(){
        driver.get("https://www.amazon.com/");
        WebElement accounts = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accounts).perform();
        WebElement account = driver.findElement(By.linkText("Account"));
        account.click();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Your Account";
        Assert.assertEquals(expectedTitle, actualTitle);
    }
}
