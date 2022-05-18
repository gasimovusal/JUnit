package com.myfirstproject.day_04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Radio_Button {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }
    @Test
    public void radio() throws InterruptedException {
//        Create a class : RadioButton
//        Complete the following task
//        Go to https://www.facebook.com/
//
//        TEST CASE:
//        Click on Create new account
        driver.findElement(By.linkText("Create new account")).click();
//        Enter first name
        driver.findElement(By.name("firstname")).sendKeys("fname"); // fake firstname
//        Enter last name
        driver.findElement(By.name("lastname")).sendKeys("lname"); // fake
//        Enter mobile number or email
        driver.findElement(By.name("reg_email__")).sendKeys("7804075355"); // fake
//        Enter new password
        driver.findElement(By.name("reg_passwd__")).sendKeys("secretPass!"); // fake
//        Enter birthday(LATER)
//        Enter gender
        driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
//        Click Sign Up
        driver.findElement(By.name("websubmit")).click();
//        Enter birthday : month
        // 1. locate the dropdown element
        WebElement month = driver.findElement(By.xpath("//select [@aria-label='Month']"));
//        // 2. create select object
        Select selectMonth = new Select(month);
//        // select Jan
        selectMonth.selectByValue("1");
        // select day
        WebElement day = driver.findElement(By.xpath("//select [@aria-label='Day']"));
        Select selectDay = new Select(day);
        selectDay.selectByValue("10");
        // select year
        WebElement year = driver.findElement(By.xpath("//select [@aria-label='Year']"));
        Select selectYear = new Select(year);
        selectYear.selectByValue("2000");

        WebElement submit = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        submit.click();


        Thread.sleep(2000);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
