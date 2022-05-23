package com.myfirstproject.day_08;

import com.myfirstproject.utilities.Test_Base;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Actions_01 extends Test_Base {
    /*
            Create a class: Actions1
            Create a test method : contextClickMethod() and test the following scenario:
            Given user is on the https://the-internet.herokuapp.com/context_menu
            When use Right clicks on the box
            Then verify the alert message is “You selected a context menu”
            Then accept the alert
             */

    @Test
    public void contextClick() throws InterruptedException { // contextclick means right click
        // Given user is on the https://the-internet.herokuapp.com/context_menu
        driver.get("https://the-internet.herokuapp.com/context_menu");
        // When use Right clicks on the box
        WebElement box = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        // box.click(); normal click does not work in this case, we need a double click
        // create action object
        Actions actions = new Actions(driver);
        // perform the action
        Thread.sleep(1500);
        actions.contextClick(box).perform();
        Thread.sleep(1500);
        // Then verify the alert message is “You selected a context menu”
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals("You selected a context menu", alertText);
        // Then accept the alert
        driver.switchTo().alert().accept();
        Thread.sleep(1500);

    }
}
