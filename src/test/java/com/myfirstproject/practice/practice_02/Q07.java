package com.myfirstproject.practice.practice_02;

import com.myfirstproject.utilities.Test_Base;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Q07 extends Test_Base {
    /*
     * Navigate to  https://www.saucedemo.com/
     * Enter the username  as standard_user
     * Enter the password as   secret_sauce
     * Click on login button
     * Choose price low to high and verify
     */

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Actions action = new Actions(driver);
        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        action.click(username)
                .sendKeys("standard_user")
                .sendKeys(Keys.TAB)
                .sendKeys("secret_sauce").perform();

        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        WebElement options = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select select = new Select(options);
        Thread.sleep(2500);
        select.selectByVisibleText("Price (low to high)");

        String expected = "PRICE (LOW TO HIGH)";
        String actual = driver.findElement(By.className("active_option")).getText();

        Assert.assertEquals(expected,actual);

//        action.click(options)
//                .sendKeys(Keys.ARROW_DOWN)
//                .sendKeys(Keys.ARROW_DOWN)
//                .sendKeys(Keys.ARROW_DOWN)
//                .sendKeys(Keys.ENTER).perform();

        Thread.sleep(2000);


    }
}
