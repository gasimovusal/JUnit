package com.myfirstproject.day_02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Thread_Sleep {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        // wait for 5 second ==> 5000 millisecond
        Thread.sleep(5000);
        driver.get("https://www.amazon.com/");

        // wait for 7 sec and close the driver
        Thread.sleep(7000);
        driver.quit();

        /*
        Thread.sleep is a Java wait
        it does not come from selenium
        it is a HARD WAIT
        it means driver will wait for 5 seconds no matter what
        tester should avoid using Thread.sleep because it puts unnecessary waits
        we will learn selenium implicit and explicit waits in the upcoming class
        this will throw some exception so add InterruptedException to method signature or use try-catch
         */
    }
}
