package com.myfirstproject.tests;

import com.myfirstproject.day_13_Exceptions_Log4J.Log4J;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class Day_14_Log4j {

    private static Logger logger = LogManager.getLogger(Log4J.class.getName());
    @Test
    public void log4JDemo(){
        logger.info("Info log");
        logger.debug("Debug log");
        logger.error("Error log");
        logger.fatal("Fatal log");
        logger.warn("Warn log");

//        1. change the level to trace to see all logs
//        2. log the information on a file
//        3. do all there for the tests package only
    }
}
