package com.myfirstproject.practice.practice_02;

import com.myfirstproject.utilities.Test_Base;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Q02 extends Test_Base {
    /*
    // 1. Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
    // 2. Click "CLICK ME" of JavaScript Alert
    // 3. Get the pop-up text
    // 4. Verify that message is "I am an alert box!"
    // 5. Accept pop-up
     */

    @Test
    public void test(){
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        WebElement alert = driver.findElement(By.xpath("//span[@id='button1']"));
        alert.click();
        String alertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals("I am an alert box!", alertMessage);
        driver.switchTo().alert().accept();

    }
}
