package com.myfirstproject.day_02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Get_Page_Source {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
//        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");//WINDOWS
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        Navigate to amazon homepage
        driver.get("https://www.amazon.com");

//        Test if amazon contains “Registry” on the homepage

        String pageSource = driver.getPageSource();
        System.out.println(pageSource);

        if(pageSource.contains("Registry")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        driver.switchTo().newWindow(WindowType.TAB).get("https://www.amazon.com");
        //driver.get("https://www.amazon.com");

        driver.quit();

    }
}
