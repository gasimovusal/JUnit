package com.myfirstproject.day_11;

import com.myfirstproject.utilities.Test_Base;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


public class Extent_Report extends Test_Base {

    @Test
    public void extentReportTest(){

        // logging the test steps in the report

        extentTest.info("User goes to google home page");
        extentTest.pass("User goes to google home page");
        extentTest.fail("User goes to google home page");
        extentTest.skip("User goes to google home page");
        extentTest.warning("User goes to google home page");
        driver.get("https://www.google.com");

        extentTest.info("User search for cybertruck release date");
        driver.findElement(By.name("q")).sendKeys("Tesla cybertruck release date" + Keys.ENTER);

        // end the report and generate the report
        extentReports.flush();

    }
}
