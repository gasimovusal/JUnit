package com.myfirstproject.day_03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

    @Test
/*
    1. user goes to http://a.testaddressbook.com/sign_in
    2. Locate the elements of email textbox, password textbox, and signin button
    3. Enter below username and password then click sign in button
    4. Username :  testtechproed@gmail.com
    5. Password : Test1234!
    6. Then verify that the expected user id  testtechproed@gmail.com (USE getText() method to get the text from the page)
    7. Verify the Addresses and Sign Out  texts are displayed
    8. Find the number of total link on the page
    9. Sign out from the page
 */
    public void locators() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //1
        driver.get("http://a.testaddressbook.com/sign_in");
        //2
        driver.findElement(By.id("session_email")).sendKeys("testtechproed@gmail.com");
        driver.findElement(By.id("session_password")).sendKeys("Test1234!");
        driver.findElement(By.name("commit")).click();

        //2. way of clicking a button
//        WebElement signIn = driver.findElement(By.name("commit"));
//        signIn.click();

        Thread.sleep(3000);

        driver.quit();

    }
}
