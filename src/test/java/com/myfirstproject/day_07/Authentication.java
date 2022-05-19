package com.myfirstproject.day_07;

import com.myfirstproject.utilities.Test_Base;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Authentication extends Test_Base {

    @Test
    public void basicAuthentication(){
        driver.get("https://the-internet.herokuapp.com/basic_auth");
        String message = driver.findElement(By.xpath("//p")).getText();
        Assert.assertTrue(message.contains("Congratulations"));

    }
}
