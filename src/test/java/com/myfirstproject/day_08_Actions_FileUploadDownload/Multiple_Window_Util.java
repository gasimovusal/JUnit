package com.myfirstproject.day_08_Actions_FileUploadDownload;

import com.myfirstproject.utilities.Test_Base;
import org.junit.Test;
import org.openqa.selenium.By;

public class Multiple_Window_Util extends Test_Base {

    @Test
    public void multipleWindowTest(){
        driver.get("https://the-internet.herokuapp.com/windows");
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.linkText("Click Here")).click();

//        driver is currently on window 1

//        Pass the title of the window that you want to switch to
        switchToTargetWindow("New Window");//Switch to the window whose TITLE = New Window
        System.out.println(driver.getCurrentUrl());

        // ????????????????????????? What iff I want switch to window which has same title as previous window
    }

}
