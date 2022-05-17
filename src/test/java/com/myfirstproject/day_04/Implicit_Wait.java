package com.myfirstproject.day_04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Implicit_Wait {

    @Test
    public void implicitWait(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // implicit wait for 30 seconds
        // implicit wait puts DYNAMIC WAIT, meaning wait will be depended on the page speed, it will wait if needed
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        // we can use implicit wait right after creating the driver object

        driver.get("https://www.google.com");
    }

    @Test
    public void threadSleep() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Thread.sleep(2000); // hard wait

        driver.get("https://www.google.com");
    }

    // there are 2 type of path, abselut and relative
    // (/html/body/div/div/div/div/form/div/input)[2]
    // //input[@name='session[email]']
}
