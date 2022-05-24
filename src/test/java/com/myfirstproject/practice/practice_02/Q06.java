package com.myfirstproject.practice.practice_02;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Q06 {
    @Test
    public void test() {
        //Verify that we have pom.xml file in our project

        String homePath = System.getProperty("user.home");

        String filePath = homePath + "/Documents/TechProEducation/SeleniumProjects/selenium_project/pom.xml";

        Assert.assertTrue(Files.exists(Paths.get(filePath)));
    }
}
