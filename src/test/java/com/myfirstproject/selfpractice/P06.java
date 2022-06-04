package com.myfirstproject.selfpractice;

import com.myfirstproject.utilities.Test_Base;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class P06 extends Test_Base {

    @Test
    public void test() throws IOException {

        driver.get("https://automationexercise.com/");
        WebElement homePage = driver.findElement(By.linkText("Home"));
        Assert.assertTrue(homePage.isDisplayed());
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement subscription = driver.findElement(By.xpath("//h2[.='Subscription']"));
        Assert.assertTrue(subscription.isDisplayed());
        driver.findElement(By.xpath("//a[@id='scrollUp']")).click();
        takeScreenshot();
    }
}
