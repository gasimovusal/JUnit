package com.myfirstproject.day_02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox_Browser_Demo {

    /*

abayram.techproed  7:53 PM
https://www.mozilla.org/en-US/firefox/new/
https://github.com/mozilla/geckodriver/releases
Create a new class under : DAY01_FirefoxBrowserDemo
Create main method
Set Path
Create gecko driver
Open google home page https://www.google.com/
Maximize the window
Close/Quit the browser
     */

    public static void main(String[] args) {

        // set path
        System.setProperty("webdriver.gecko.driver","./drivers/geckodriver");

        // create gecko driver
        WebDriver driver = new FirefoxDriver();

        // open google home page
        driver.get("https://www.google.com/");

        // maximize the window
        driver.manage().window().maximize();

    }
}
