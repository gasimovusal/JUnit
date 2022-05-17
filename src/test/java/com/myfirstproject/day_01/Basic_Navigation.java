package com.myfirstproject.day_01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basic_Navigation {

    /*
        Create a new class under : BasicNavigations
        Create main method
        Set Path
        Create chrome driver
        Maximize the window
        Open google home page https://www.google.com/.
        On the same class, Navigate to amazon home page https://www.amazon.com/
        Navigate back to google
        Navigate forward to amazon
        Refresh the page
        Close/Quit the browser
     */

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // this maximises driver, we should always automate in full screen
        driver.get("https://www.google.com/");

        /*
        There are 2 ways to open a page:
        1. get.url("URL");
        2. navigate().to("URL");
        What is the differences between get and navigate method?
        get is easier to use, its shorter, a little faster, get takes only string as parameter
        navigate has more option, go back, forward and refresh.
         */

        driver.navigate().to("https://www.amazon.com/");

        // navigate back to page
        driver.navigate().back();

        // refresh te page
        driver.navigate().refresh();

        // close/quit the browser
        // what is the difference between close and quit
        // they both close the driver
        // close closes ONLY current active driver
        // quit closes all browser that open during test run
        driver.quit();

    }
}
