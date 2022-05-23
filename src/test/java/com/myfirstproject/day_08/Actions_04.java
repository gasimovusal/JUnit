package com.myfirstproject.day_08;

import com.myfirstproject.utilities.Test_Base;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Actions_04 extends Test_Base {
    /*
    Create a class: Action4
    Create a method dragAndDropTest
    Given user is on https://jqueryui.com/droppable/
    And user moves the target element(Drag me to my target) in to  destination(Drop here)
     */
    @Test
    public void dragAndDrop() throws InterruptedException {

        driver.get("https://jqueryui.com/droppable/");
        //user moves the target element(Drag me to my target) in to  destination(Drop here)
        // element is inside the iframe, we need to go to inside of iframe
        driver.switchTo().frame(0);
        WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions actions = new Actions(driver);
        Thread.sleep(1500);
        actions.dragAndDrop(source, target).perform();
        Thread.sleep(1500);

        /*
         * Why your test case MIGHT FAIL?
         * 1. Incorrect Locator.
         * 2. Timing. Sysncronizated. - we already have enough timeout
         * 3. New Window
         * 4. JS Alerts
         * 5. IFrame ==> in our case, test will fail if we dont go inside of iFrame
         * */
    }
}
