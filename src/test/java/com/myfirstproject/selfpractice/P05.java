package com.myfirstproject.selfpractice;

import com.myfirstproject.utilities.Test_Base;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class P05 extends Test_Base {
    @Test
    public void checkbox() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        Actions actions = new Actions(driver);
        checkbox1.click();
        Thread.sleep(1500);
        actions.contextClick(checkbox2).perform();
        Thread.sleep(1500);
    }

}
