package com.myfirstproject.practice.practice_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q02 {

    //  ...Exercise2...
// Create a new class under Q02
// Set Path
// Create chrome driver
// Maximize the window
// Open google home page https://www.google.com/.
// Wait for 3 seconds
// Go to the "https://www.sahibinden.com"
// Get the title and URL of the page
// Check if the title contains the word "oto" print console "Title contains oto" or "Title does not contain oto"
// Check if the URL contains the word "oto" print console "URL contains oto" or "URL does not contain oto"
// Then go to "https://www.gittigidiyor.com"
// Get the title and check if it contains the word "site" and print "Title contains site" or "Title does not contain site"
// Back to the previous webpage, sahibinden.com
// Refresh the page
// Navigate to gittigidiyor.com
// Wait for 3 seconds
// Close the browser

    WebDriver driver;

    @Before
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.google.com/");
        Thread.sleep(3000);
        driver.get("https://www.amazon.com/");
        String amazonTitle = driver.getTitle();
        String amazonUrl = driver.getCurrentUrl();

        if (amazonTitle.contains("auto")){
            System.out.println("Title contains auto");
        }else {
            System.out.println("Title does not contain auto");
        }

        driver.get("https://www.gittigidiyor.com");
        String gittiGidiyorTitle = driver.getTitle();
        if(gittiGidiyorTitle.contains("site")){
            System.out.println("Title contains site");
        }else {
            System.out.println("Title does not contain site");
        }

        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
        Thread.sleep(3000);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
