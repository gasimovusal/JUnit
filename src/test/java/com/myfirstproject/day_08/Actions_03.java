package com.myfirstproject.day_08;

import com.myfirstproject.utilities.Test_Base;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class Actions_03 extends Test_Base {
    /*
    Create a class: ActionClass3
    Create test method : scrollUpDown()
    Go to amazon
    Scroll the page down
    Scroll the page up
     */
    @Test
    public void scrollDown() throws InterruptedException {
        /* we may need to scroll the page, when the page is long or element is not displayed properly because element is at the buttom of the page
        Then we have to scroll the page
        With Actions class, we can scroll down, up, left, right.
        link may not load entirely thats why we need to go down on page so it can load the page
         */
        driver.get(" https://www.amazon.com/");
        // use actions to scroll the page
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform(); // we use Keys to move up, down, left, and right in page
        Thread.sleep(1500);
        actions.sendKeys(Keys.PAGE_DOWN).perform(); // we use Keys to move up, down, left, and right in page
        Thread.sleep(1500);
        actions.sendKeys(Keys.ARROW_DOWN).perform(); // we use Arrow down a little bit on page
        Thread.sleep(1500);
        // scrolling up
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(1500);
        // arrow up
        actions.sendKeys(Keys.ARROW_UP).perform(); // we use Arrow down a little bit on page
        Thread.sleep(1500);
    }
}
