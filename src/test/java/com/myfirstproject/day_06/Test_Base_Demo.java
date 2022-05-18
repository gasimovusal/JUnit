package com.myfirstproject.day_06;
import com.myfirstproject.utilities.Test_Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Test_Base_Demo extends Test_Base {

//    WebDriver driver;
//    @Before
//    public void setUp(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//    }
    @Test
    public void test1(){
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
    }
    @Test
    public void test2(){
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
    }

//    @After
//    public void tearDown(){
//        driver.quit();
//    }

    /*
    how to handle the alert?
    accept() => seame as clicking ok of an alaert
    dimiss() -> caneling an alert
    getText() -> to tget the alert messages of the alert
    sendKeys("text") -> to send a text into alert textbox
     */
}
