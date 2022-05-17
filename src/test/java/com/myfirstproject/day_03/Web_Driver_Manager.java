package com.myfirstproject.day_03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Web_Driver_Manager {

    @Test
    public void googleSearch(){
        // search for a porcelain teapot in google search box

        //        We no longer need to use System.setProperty
        //        Instead use WebDriverManager
        //        Calling and setting up chromedriver
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        Navigate to amazon homepage
        driver.get("https://www.google.com");
        Assert.assertTrue(driver.getTitle().equals("Google"));
        driver.quit();
    }
}
