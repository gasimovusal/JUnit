package com.myfirstproject.day_12_JSExecutor_Synchronization;

import com.myfirstproject.utilities.Test_Base;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JSExecutor_01 extends Test_Base {
    @Test
    public void jsExecutorTests() throws InterruptedException {

        driver.get("https://www.carettahotel.com/");
        Thread.sleep(2000);
        WebElement ourRooms = driver.findElement(By.xpath("//*[.='Our Rooms']"));
        // creating js executor object
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", ourRooms);
        Thread.sleep(2000);
        WebElement email = driver.findElement(By.xpath("//span[.='info@carettahotel.com']"));
        js.executeScript("arguments[0].scrollIntoView(true)", email);
        Thread.sleep(2000);
        //optionally, we can put it in one line
        js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//input[@type='submit']")));
        Thread.sleep(2000);

    }
}
