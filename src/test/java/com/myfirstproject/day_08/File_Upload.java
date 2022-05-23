package com.myfirstproject.day_08;

import com.myfirstproject.utilities.Test_Base;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class File_Upload extends Test_Base {
    /*
    Class Name: FileUploadTest
    Method Name: fileUploadTest
    When user goes to https://the-internet.herokuapp.com/upload
    When user selects an image from the desktop
    And click on the upload button
    Then verify the File Uploaded!  Message displayed
     */
    @Test
    public void fileUploadTest(){
        driver.get("https://the-internet.herokuapp.com/upload");
        // locate choose file input button
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        // we cannot click on it because we need to choose from our computer
        // when you inspect, you will see that choose file is an input thats why we can use sendKeys instead of clicking
        String filePath = "/Users/VG/Desktop/Views/dumbo.jpeg";
        chooseFile.sendKeys(filePath);
        //click on upload button
        WebElement upload = driver.findElement(By.id("file-submit"));
        upload.click();

        // werify the upload message
        String uploadMessage = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("File Uploaded!", uploadMessage);
    }
}
