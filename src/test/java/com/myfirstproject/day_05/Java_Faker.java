package com.myfirstproject.day_05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Java_Faker {
    /* fake data = mack data => data that is not real
    fake ssn, fake ame, fake address
    we can use fake data to test
    we can use java faker class to generate fake data

    where do you get your data
    1. BA business analyst
    2. test lead
    manual tester
    4. tech lead - team teach - dev lead
     */



    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    // faker does not come from selenium, we have to import from meaven library
    @Test
    public void faker(){

    }
}
