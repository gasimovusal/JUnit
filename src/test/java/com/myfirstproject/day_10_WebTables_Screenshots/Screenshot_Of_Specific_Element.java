package com.myfirstproject.day_10_WebTables_Screenshots;

import com.myfirstproject.utilities.Test_Base;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class Screenshot_Of_Specific_Element extends Test_Base {

    @Test
    public void screenshotTest() throws IOException {

        driver.get("https://google.com");
//        WebElement googleLogo = driver.findElement(By.xpath("//img[@class='lnXdpd']"));
//        File logoImage = googleLogo.getScreenshotAs(OutputType.FILE);
//        File finalPath = new File("./test_output/Screenshots/googleLogo.png");
//        FileUtils.copyFile(logoImage, finalPath);

        WebElement signIn = driver.findElement(By.linkText("Sign in"));
        File signInImage = signIn.getScreenshotAs(OutputType.FILE);
        File singInPath = new File("./test_output/Screenshots/signIn.png");
        FileUtils.copyFile(signInImage, singInPath);
    }
}
