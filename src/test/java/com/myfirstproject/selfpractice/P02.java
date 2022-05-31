package com.myfirstproject.selfpractice;

import com.myfirstproject.utilities.Test_Base;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class P02 extends Test_Base {
    /*
            Create a class: Actions1
            Create a test method : contextClickMethod() and test the following scenario:
            Given user is on the https://the-internet.herokuapp.com/context_menu
            When use Right clicks on the box
            Then verify the alert message is “You selected a context menu”
            Then accept the alert
             */

    @Test
    public void test() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement box = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions action = new Actions(driver);
        action.contextClick(box).perform();
        Thread.sleep(2000);
        String actualAlert = driver.switchTo().alert().getText();
        String expectedAlert = "You selected a context menu";
        Assert.assertEquals(expectedAlert, actualAlert);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

    }
}
