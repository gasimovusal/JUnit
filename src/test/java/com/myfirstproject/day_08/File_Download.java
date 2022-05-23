package com.myfirstproject.day_08;

import com.myfirstproject.utilities.Test_Base;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class File_Download extends Test_Base {

    /*
    Create a class:FileDownloadTest
    downloadTest()
    In the downloadTest() method, do the following test:
    Go to https://the-internet.herokuapp.com/download
    Download sample.png file
    Then verify if the file downloaded successfully
     */
    @Test
    public void downloadTest() throws InterruptedException {
    // Go to https://the-internet.herokuapp.com/download
        driver.get("https://the-internet.herokuapp.com/download");
        // Download sample.png file
        driver.findElement(By.linkText("sample.png")).click();
        // it takes about a second to download the filed thats why we need to add thread.sleep
        Thread.sleep(3000);
        // Then verify if the file downloaded successfully
        String path = System.getProperty("user.home") + "/Downloads/sample.png";
        boolean isExists = Files.exists(Paths.get(path));
        Assert.assertTrue(isExists);
    }
}
