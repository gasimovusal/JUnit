package com.myfirstproject.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class practice {

    // ...Exercise4...
    // Navigate to  https://testpages.herokuapp.com/styled/index.html
    // Click on  Calculate under Micro Apps
    // Type any number in the first input
    // Type any number in the second input
    // Click on Calculate
    // Get the result
    // Verify the result
    // Print the result

    WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws InterruptedException {

        driver.get("https://testpages.herokuapp.com/styled/index.html");
        driver.findElement(By.xpath("//a[@id='calculatetest']")).click();
        driver.findElement(By.xpath("//input[@id='number1']")).sendKeys("10");
        driver.findElement(By.xpath("//input[@id='number2']")).sendKeys("15");
        driver.findElement(By.xpath("//input[@id='calculate']")).click();

        String actualResult = driver.findElement(By.xpath("//span[@id='answer']")).getText();
        String expectedResult = "25";

        if(actualResult.equals(expectedResult)){
            System.out.println("Result is: " + actualResult);
        }else {
            System.out.println("Actual result does not match with expected result");
        }

        Thread.sleep(2000);
    }

    @After
    public void quit(){

        driver.quit();
    }
}
