package com.myfirstproject.day_13_Exceptions_Log4J;

import com.myfirstproject.utilities.Test_Base;
import org.junit.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class Log4J extends Test_Base {

    private static Logger logger = LogManager.getLogger(Log4J.class.getName());
    @Test
    public void log4JTest(){
        logger.info("Opening the URL");
        driver.get("https://www.carettahotel.com/");
        logger.info("Clicking on Login Button");
        driver.findElement(By.linkText("Log in")).click();
        logger.fatal("Fatal Log");//PRINTS by default with no configuration
        logger.error("Error Log");//ERROR by default with no configuration
        logger.debug("Debug Log");
    }
}
