package com.myfirstproject.selfpractice;

import com.myfirstproject.utilities.Test_Base;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class P04 extends Test_Base {
    /*
    Create a class: Action4
    Create a method dragAndDropTest
    Given user is on https://jqueryui.com/droppable/
    And user moves the target element(Drag me to my target) in to  destination(Drop here)
     */

    @Test
    public void test() throws InterruptedException {
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);
        WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
        Thread.sleep(2500);

    }

}
