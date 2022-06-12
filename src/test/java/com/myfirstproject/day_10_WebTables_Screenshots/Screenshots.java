package com.myfirstproject.day_10_WebTables_Screenshots;

import com.myfirstproject.utilities.Test_Base;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Screenshots extends Test_Base {

    @Test
    public void screenshotTest() throws Exception {
        driver.get("https://google.com");
        // create a reusable method
        //takeScreenshot();
        //  locating input, typing tesla cybertruck, and clicking enter
        driver.findElement(By.name("q")).sendKeys("tesla model s"+ Keys.ENTER);
        takeScreenshot();
    }


    /*
     * How do you capture screenshot in your automation framework?/How do you get screenshot in selenium?
     * I use getScreenshots method to capture teh screenshot.
     * Actually we have a reusable methods to capture the screenshot
     *
     */
}
