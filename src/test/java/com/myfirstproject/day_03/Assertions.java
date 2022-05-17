package com.myfirstproject.day_03;

import org.junit.Assert;
import org.junit.Test;

public class Assertions {

    @Test
    public void assertions(){

        /*
         * *****ASSERTIONS*****
         * if expected = actual
         * if assertion fails we see red error
         * if assertion pass we see green checkmark
         *
         * What is difference between Assertion and Verification?
         * -When assertion fails, test stops execution. Assertion means Hard Assert
         * -Verification means, test continue to execute even after verification fails
         * In TestNG there is SoftAssert. It means verification.
         * -In verification, we can mark more than one result as failed or passed
        *
         */

       // Assert.assertEquals("test case if failed", "Java", "javascript");
        Assert.assertEquals("test case failed", 5, 5);

        //Assert.assertTrue("java".contains("e")); ==> fails
        Assert.assertTrue("selenium".contains("e")); // pass

        Assert.assertFalse("java".contains("f")); // pass
        //Assert.assertFalse("java".contains("a")); == fail





    }
}
