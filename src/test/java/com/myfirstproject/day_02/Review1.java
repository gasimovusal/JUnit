package com.myfirstproject.day_02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Review1 {

    /*
        Create a new class : Review1
        Using ChromeDriver, Go to youtube and verify if page title is “youtube”, If not, print the correct title.
        Verify if the page URL contains youtube if not, print the right url.
        Then Navigate to https://www.amazon.com/
        Navigate back to youtube
        Refresh the page
        Navigate forward to amazon
        Maximize the window
        Then verify if page title includes “Amazon”, If not, print the correct title.
        Verify if the page URL is https://www.amazon.com/, if not print the correct url
        Quit the browser
     */

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.youtube.com/");

        String actualTitle = driver.getTitle();
        String expectedTitle = "youtube";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("passed");
        }else {
            System.out.println("failed");
            System.out.println("Actual title: " + actualTitle);
            System.out.println("Expected title: " + expectedTitle);
        }

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "youtube";

        if(actualUrl.contains(expectedUrl)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
            System.out.println("actual result: " + actualUrl);
            System.out.println("expcted result " + expectedUrl);
        }

        driver.get("https://www.amazon.com/");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
        driver.manage().window().maximize();

        String actualtitle = driver.getTitle();
        String expectedtitle = "Amazon";

        if(actualtitle.contains(expectedtitle)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
            System.out.println("actual result: " + actualtitle);
            System.out.println("expected result " + expectedtitle);
        }

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.amazon.com/";

        if(actualURL.equals(expectedURL)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
            System.out.println("actual result: " + actualURL);
            System.out.println("expected result " + expectedURL);
        }

        driver.quit();
        /*
        failed
        Actual title: YouTube
        Expected title: youtube
        passed
        passed
        passed
         */



    }
}
