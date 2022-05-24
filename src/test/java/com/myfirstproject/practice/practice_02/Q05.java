package com.myfirstproject.practice.practice_02;

import com.myfirstproject.utilities.Test_Base;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Q05 extends Test_Base {

    //Signup For Facebook by using Actions class
    //Go to Facebook
    //Click on Create New Account
    //fill all the boxes by using keyboard actions
    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        WebElement nameBox = driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions = new Actions(driver);
        actions.click(nameBox)
                .sendKeys("Ali")
                .sendKeys(Keys.TAB)
                .sendKeys("Can")
                .sendKeys(Keys.TAB)
                .sendKeys("alican@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("alican@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("alican")//password
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB) // Date of Birth => 15 January 2010
                .sendKeys("15")
                .sendKeys(Keys.TAB)
                .sendKeys("Jan")
                .sendKeys(Keys.TAB)
                .sendKeys("2010")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .sendKeys("Special Gender")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
        Thread.sleep(1500);
    }
}
