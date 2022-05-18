package com.myfirstproject.utilities;

import com.myfirstproject.day_03.Web_Driver_Manager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class Test_Base {
    /*
    Test_Base is a classs that has repeated pre condition and post condition
    we hvae @Before and @After methods
    Test_Base should be abstract. we just want to implement the methods in Test_Base. we are hiding the details.
    we dont want to create of object of Test_Base
     */
    protected WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
