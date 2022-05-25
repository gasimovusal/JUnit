package com.myfirstproject.day_04_CheckBox_RadioButton_Xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Locators_02 {

    @Test
/*
    1. user goes to http://a.testaddressbook.com/sign_in
    2. Locate the elements of email textbox, password textbox, and signin button
    3. Enter below username and password then click sign in button
    4. Username :  testtechproed@gmail.com
    5. Password : Test1234!
    6. Then verify that the expected user id  testtechproed@gmail.com (USE getText() method to get the text from the page)
    7. Verify the Addresses and Sign Out  texts are displayed
    8. Find the number of total link on the page
    9. Sign out from the page
 */
    public void locators() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //1
        driver.get("http://a.testaddressbook.com/sign_in");
        //2
        driver.findElement(By.id("session_email")).sendKeys("testtechproed@gmail.com");
        driver.findElement(By.id("session_password")).sendKeys("Test1234!");
        driver.findElement(By.name("commit")).click();

        //2. way of clicking a button
//        WebElement signIn = driver.findElement(By.name("commit"));
//        signIn.click();

        // 6.
        WebElement idElement = driver.findElement(By.className("navbar-text"));
        System.out.println(idElement.getText()); // getting testtechproed@gmail.com
        String idElementText = idElement.getText();
        Assert.assertEquals("testtechproed@gmail.com", idElementText);

        // other way of asserting ==> this is not understandable
        // Assert.assertEquals("esttechproed@gmail.com", driver.findElement(By.className("navbar-text")).getText());

        // Verify the Addresses and Sign Out  texts are displayed
        WebElement addresses = driver.findElement(By.linkText("Addresses")); // FULL text has to match
        //driver.findElement(By.partialLinkText("Add")); ==> we can paste PART of the text, you dont have to paste entire text
        Assert.assertTrue(addresses.isDisplayed());
        WebElement signOut = driver.findElement(By.partialLinkText("out")); // FULL text has to match
        //driver.findElement(By.partialLinkText("Add")); ==> we can paste PART of the text, you dont have to paste entire text
        Assert.assertTrue(signOut.isDisplayed());

        // Find the number of total link on the page
        // number pf link = num of a tag
        List<WebElement> allLinks = driver.findElements(By.tagName("a")); // return all elements whose tag is a
        int numOfLinks = allLinks.size();
        System.out.println("there are " + numOfLinks + " links on website");

        //Sign out from the page
        driver.findElement(By.linkText("Sign out")).click();

        // after sign out, we must do verification to make sure if we successfully signed out
        boolean isSignedOut = driver.getCurrentUrl().equals("http://a.testaddressbook.com/sign_in");
        Assert.assertTrue(isSignedOut);

        /*
         * What is the difference between linkText and partialLinkText?
         *
         * Similarities : both accept the full text of a name of link
         * They both should be used only links
         *
         * Differences: linkText looks for EXACT text
         * partialLinkText looks for PART OF A text
         *
         * Note: When using partialLinkText, BE CAREFUL!!!!
         * if there is other partial matches, it returns the first partial link
         * Best practice is use linkText
         * If you use partialLinkText, use enough words
         *
         * When is partialLinkText is use full?
         * - if link text is too long
         * - if there is a space before or after the text
         *
         * isDisplayed is used to verify isf an element is displayed on the page
         * It returns true if element is exists, return false if elements does not exist


         */

        Thread.sleep(1500);

        driver.quit();

    }
}
