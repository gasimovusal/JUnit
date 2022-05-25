package com.myfirstproject.practice.practice_02;

import com.myfirstproject.utilities.Test_Base;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q01 extends Test_Base {
    // go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
    // click on the second emoji
    // click all the second emoji elements
    // fill the form,(Fill the form with the texts you want)
    // press the apply button
    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        // all emojis are inside iframe tag, we need to switch iframe tag first
        WebElement allEmojis = driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(allEmojis);
        WebElement emoji = driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]"));
        emoji.click();
        Thread.sleep(1500);
        List<WebElement> listOfEmojis = driver.findElements(By.xpath("//div[@id='nature']/div/img"));
        for(WebElement w : listOfEmojis){
            w.click();
        }
        Thread.sleep(1500);
        WebElement smile = driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[1]"));
        smile.click();
        List<WebElement> smileEmojis = driver.findElements(By.xpath("//div[@id='smiles']//img[@class='emoji']"));
        for(WebElement w : smileEmojis){
            w.click();
        }
        // we need to get out of iframe tag
        // fill the form,(Fill the form with the texts you want)
        driver.switchTo().defaultContent();
        List<WebElement> textBoxes = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
        List<String> words = new ArrayList<>(Arrays.asList("This","iframe","example","looks","very","funny","does","not","it","?","!"));//11
//                                                           1        2        3        4       5      6       7     8     9   10  11
        for(int i = 0; i<textBoxes.size(); i++){
            textBoxes.get(i).sendKeys(words.get(i));
        }
        Thread.sleep(1500);

    }
}
