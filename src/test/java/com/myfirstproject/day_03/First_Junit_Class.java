package com.myfirstproject.day_03;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class First_Junit_Class {

    /*
       *****JUNIT*****
     * Junit is a testing framework
     * Testers can use Junit for creating automation framework
     * Devs can use Junit for creating Unit test framework

       *****ANNOTATIONS******
     * There are 6 annotations
     * 1. @Test -> marks a method as a TEST CASE
     * All test methods are VOID
     * B/C we create test cases for assertion, not to return a value
     * We no longer need main method for Creating or Running test cases
     * We can run test methods form the method level or class level

     * 2. @Before : Runs before EACH @Test annotation

     * 3. @After : runs after EACH test annotation

     * 4. @BeforeClass : runs before class only once

     * 5. @After class : runs after class only once

     * 6. @Ignore : skipping a test case

     */

    @Before
    public void setUp(){
        System.out.println("before method");
    }

    @After
    public void setUP(){
        System.out.println("after method");
    }

    @Test
    public void test1() { // all test methods w
        System.out.println("this is test 1");
    }

    @Test
    public void test2(){
        System.out.println("this is test 2");
    }

    @Ignore
    @Test
    public void test3(){
        System.out.println("this is test 3");
    }

    @Test
    public void test4(){
        System.out.println("this is test 4");
    }
}