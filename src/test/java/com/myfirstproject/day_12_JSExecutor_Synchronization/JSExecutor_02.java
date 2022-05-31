package com.myfirstproject.day_12_JSExecutor_Synchronization;

import com.myfirstproject.utilities.Test_Base;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class JSExecutor_02 extends Test_Base {

    @Test
    public void jsExecutorTest() throws InterruptedException {
        driver.get("https://www.carettahotel.com/");
//        scroll to Our Room
        WebElement ourRooms = driver.findElement(By.xpath("//*[.='Our Rooms']"));
        scrollIntoViewByJS(ourRooms);
        Thread.sleep(3000);
    }

    @Test
    public void scrollAllDownByJSTest() throws InterruptedException {
        driver.get("https://www.carettahotel.com/");
//        scrolling all the way down
        scrollAllDownByJS();
        Thread.sleep(2000);
//        scrolling all the way up
        scrollAllUpByJS();
        Thread.sleep(2000);
    }

    @Test
    public void clickByJSTest() throws InterruptedException {
        driver.get("https://www.carettahotel.com/");
//click on check availability
        WebElement checkAvailability = driver.findElement(By.xpath("//input[@type='submit']"));
        clickByJS(checkAvailability);
        Thread.sleep(2000);
//click on search button
        WebElement searchButton = driver.findElement(By.xpath("//input[@type='submit']"));
        clickByJS(searchButton);
        Thread.sleep(2000);
    }

    @Test
    public void setValueByJS() throws InterruptedException {
        driver.get("https://www.carettahotel.com/");
        WebElement checkOutDate = driver.findElement(By.id("checkout_date"));
//        Updating the text of checkout date
        setValueByJS(checkOutDate,"6/25/2022");//js type
        // Traditional selenium type
//        checkOutDate.clear();
//        checkOutDate.sendKeys("6/25/2022");
        Thread.sleep(3000);
    }

    @Test
    public void getValueByJS() throws InterruptedException {
        driver.get("https://www.carettahotel.com/");
        Thread.sleep(3000);
//        WebElement checkOutDate = driver.findElement(By.id("checkout_date"));
//        System.out.println(checkOutDate.getText());//returns empty string because "Checkout Data" is not a text, it is a value
        getValueByJS("checkout_date");//5/29/2022
    }

    @Test
    public void changeBackgroundColorByJSTest() throws InterruptedException, IOException {
        driver.get("https://www.carettahotel.com/");
        WebElement checkAvailability = driver.findElement(By.xpath("//input[@type='submit']"));
        changeBackgroundColorByJS(checkAvailability,"orange");
        Thread.sleep(2000);
        takeScreenshot();
    }
    @Test
    public void addBorderWithJSTest() throws InterruptedException, IOException {
        driver.get("https://www.carettahotel.com/");
        WebElement loginButton = driver.findElement(By.xpath("//a[.='Log in']"));
        addBorderWithJS(loginButton,"3px solid red");
        Thread.sleep(2000);
        takeScreenshot();
    }

}
