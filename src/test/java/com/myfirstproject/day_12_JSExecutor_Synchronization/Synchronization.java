package com.myfirstproject.day_12_JSExecutor_Synchronization;

import com.myfirstproject.utilities.Test_Base;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Synchronization extends Test_Base {

    @Test
    public void synchronization01(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
//        When user clicks on the Start button
        driver.findElement(By.xpath("//div[@id='start']//button")).click();
//        Using explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        /*
        Hello World is visible in HTML code but its not displayed when you load the page
        we need explicit wait for hidden elements
        explicit wait can handle hidden elements, implicit wait is not enough for hidden elements
         */
        //div[@id='finish']//h4 is the xpath of the Hello World! element
//        1. Waits for the element DYNAMICALLY
//        2. returns the element. So no need to use findElement with explicit wait
        WebElement helloWord = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        Assert.assertEquals("Hello World!",helloWord.getText());

//        Thread.sleep(5000);//works but this is not recommended



    }
}
