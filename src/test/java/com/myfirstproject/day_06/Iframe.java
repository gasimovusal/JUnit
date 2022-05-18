package com.myfirstproject.day_06;

import com.myfirstproject.utilities.Test_Base;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Iframe extends Test_Base {
    /*
           Create a class: IFrameTest
           Create a method: iframeTest
           Go to https://the-internet.herokuapp.com/iframe
           Verify the Bolded text contains “Editor”
           Locate the text box
           Delete the text in the text box
           Type “This text box is inside the iframe”
           Verify the text Elemental Selenium text is displayed on the page
            */
    @Test
    public void iframeTest() throws InterruptedException {

        //    Go to https://the-internet.herokuapp.com/iframe
        driver.get("https://the-internet.herokuapp.com/iframe");
//    Verify the Bolded text contains “Editor”
        String boldedText = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(boldedText.contains("Editor"));
//    Locate the text box
        // textbox is inside an iframe. so i have to switch ro that iframe
        // ways to switch to iframe: 1. index, 2. id, name ; 3. webelement
        // driver.switchTo().frame(0); => index starts at 0
        // driver.switchTo().frame("mce_0_ifr"); => using id or name
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);

        WebElement textBox = driver.findElement(By.xpath("//p"));
//    Delete the text in the text box
        textBox.clear(); // clear deletes text from an input
        Thread.sleep(2000);
//    Type “This text box is inside the iframe”
        textBox.sendKeys("This text box is inside the iframe");
        Thread.sleep(2000);
//    Verify the text Elemental Selenium text is displayed on the page
        driver.switchTo().parentFrame();//get 1 upper level using parentFrame
        driver.switchTo().defaultContent();//gets all the way to the root level
        WebElement elementalSelenium = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementalSelenium.isDisplayed());

        /* QUESTION!!!
        How do you find the number of iframe on a page?
        Sample Answer: iframes are created using iframe tag. I can use findElements by tag name that will return all of the element with iframe tags as List. Then I use size method to find the number of iframe in the list
        Can you five me the exact syntax?
        Sure.
        driver.findElements(By.tagName(“iframe”)).size();
         */
    }
}
