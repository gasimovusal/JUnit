package com.myfirstproject.day_02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework1 {

    /*
        Create a new class : Homework1
        Using ChromeDriver, Go to facebook and verify if page title is “facebook”, If not, print the correct title.
        Verify if the page URL contains facebook  if not, print the right url.
        Then Navigate to https://www.walmart.com/
        Verify if the walmart page title includes “Walmart.com”
        Navigate back to facebook
        Refresh the page
        Maximize the window
        Close the browser
     */

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com/");

        String actualResult = driver.getTitle();
        String expectedResult = "facebook";

        if(actualResult.equals(expectedResult)){
            System.out.println("passed");
        }else {
            System.out.println("failed");
            System.out.println("Actual title: " + actualResult);
            System.out.println("expected title: " + expectedResult);
        }

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "facebook";
        if(actualUrl.contains(expectedUrl)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
            System.out.println("Actual url: " + actualUrl);
            System.out.println("Expected url: " + expectedUrl);
        }

        driver.get("https://www.walmart.com/");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Walmart.com";

        if(actualTitle.contains(expectedTitle)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
            System.out.println("Actual title: " + actualTitle);
            System.out.println("expected title: " + expectedTitle);
        }

        driver.navigate().back();
        driver.navigate().refresh();
        driver.manage().window().maximize();

        driver.quit();

        /*
        failed
        Actual title: Facebook - log in or sign up
        expected title: facebook
        passed
        passed
         */


    }
}
