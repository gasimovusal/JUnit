package com.myfirstproject.day_02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Verify_Title_Test {

    /*
    1.Create a new class: VerifyTitleTest
	2.Navigate to google homepage
	3.Verify if google title is “Google”
     */
    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com/");

        // Verify if google title is “Google”
        String actualTitle = driver.getTitle(); // it will return title of current page
        String expectedTitle = "Google";

        // verify if expected

        if(actualTitle.equals(expectedTitle)) {
            System.out.println("PASS");
        }else{
            System.out.println("Failed");
            System.out.println("Expected : " + expectedTitle);
            System.out.println("Actual : " + actualTitle);
        }

        driver.quit();

    }
}
