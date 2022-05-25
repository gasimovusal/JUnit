package com.myfirstproject.day_04_CheckBox_RadioButton_Xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath_CSS {

    WebDriver driver;

    @Before
    public void setUp(){
//        Prerequisites
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        user goes to http://a.testaddressbook.com/sign_in
        driver.get("http://a.testaddressbook.com/sign_in");
    }

    @Test
    public void xpath_css(){
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("testtechproed@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Test1234!");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Test
    public void css(){
        /*
        there is no // and @ symbol on css
         */
        driver.findElement(By.cssSelector("input[type='email']")).sendKeys("testtechproed@gmail.com");
//        Alternative cssLocator for email : input#session_email  OR   #session_email
//        Alternative cssLocator for email : input.form-control   OR   .form-control
//        Note: # = id    and     . = class
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Test1234!");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
