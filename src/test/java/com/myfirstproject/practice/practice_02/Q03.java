package com.myfirstproject.practice.practice_02;

import com.myfirstproject.utilities.Test_Base;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Q03 extends Test_Base {
    /*
    // go to amazon homepage
    // hover mouse over the hello,signIn element at the top right
    // Click on the Create list link in the menu that opens
    // and verify that title is equal to "Your List"
     */
    @Test
    public void test(){
        driver.get("https://amazon.com");
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        actions.moveToElement(element).perform();
        WebElement createList = driver.findElement(By.linkText("Create a List"));
        createList.click();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Your List";
        Assert.assertEquals(expectedTitle, actualTitle);
    }
}
