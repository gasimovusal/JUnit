package com.myfirstproject.practice.practice_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class practice02 {

     /*
    ...Exercise...
   // http://the-internet.herokuapp.com/add_remove_elements/
   // click on the "Add Element" button 100 times
   // write a function that takes a number, and clicks the "Delete" button
   // given number of times, and then validates that given number of
   // buttons was deleted

   1.method : createButtons()
   2.deleteButtonsAndValidate()
      */

    WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void test(){
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        createButton(driver, 100);

    }

    public void createButton(WebDriver driver, int number){

        WebElement addButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));

        for(int i = 1 ; i <= number; i++)
            addButton.click();
    }

    @After
    public void quit(){
        driver.quit();
    }
}
