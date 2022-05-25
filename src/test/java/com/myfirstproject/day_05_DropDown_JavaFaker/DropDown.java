package com.myfirstproject.day_05_DropDown_JavaFaker;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DropDown {

    //Go to https://the-internet.herokuapp.com/dropdown
//1.Create method selectByIndexTest and Select Option 1 using index
//2.Create method selectByValueTest Select Option 2 by value
//3.Create method selectByVisibleTextTest Select Option 1 value by visible text
//4.Create method printAllTest Print all dropdown value
//5.Create method printFirstSelectedOptionTest Print first selected option
//6.Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 4 elements in the dropdown.

    WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void test() throws InterruptedException {

        //driver.findElement(By.xpath("//select[@id='dropdown']")).click();
        //1.Create method selectByIndexTest and Select Option 1 using index
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        Thread.sleep(2000);
        select.selectByIndex(1);

        Thread.sleep(2000);
        select.selectByIndex(2);
    }

    @Test
    public void selectByValueTest() throws InterruptedException {
        //2.Create method selectByValueTest Select Option 2 by value
        //1-Locate the dropDown
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        //2-Create a a select object
        Select select = new Select(dropDown);
        //3-Select any option by using selectByValue
        Thread.sleep(3000);
        select.selectByValue("2");

    }

    @Test
    public void selectByValue() throws InterruptedException {
        //2.Create method selectByValueTest Select Option 2 by value

        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        Thread.sleep(2000);
        select.selectByValue("2");
    }

    @Test
    public void selectByVisibleTextTest() throws InterruptedException {
        // 3.Create method selectByVisibleTextTest
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        Thread.sleep(2000);
        select.selectByVisibleText("Option 1");
    }

    @Test
    public void printAllTest() throws InterruptedException {
        //4.Create method printAllTest Print all dropdown value
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        Thread.sleep(2000);
        List<WebElement> allOptions = select.getOptions(); // return list of the web element in dropdown
        for(WebElement eachOption : allOptions){
            // System.out.println(eachOption); // eachOption is web element, when we print webElement will give you codes
            System.out.println(eachOption.getText()); // because it will print you codes, we need to use getText to get the text
        }

        // verify that dropdown has option 2 text
        boolean flag = false;
        for(WebElement eachoption : allOptions){
            if (eachoption.getText().equals("Option 2")){
                // Assert.assertTrue(true);
                flag = true;
            }
        }
        Assert.assertTrue(flag); // pass when flag = true ; it will fail when flag = false
    }

    @Test
    public void printFirstSelectedOptionTest() throws InterruptedException {
        // 6.Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 4 elements in the dropdown.
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        Thread.sleep(2000);
        WebElement firstSelectedOption = select.getFirstSelectedOption();
        System.out.println("Default selected option: " + firstSelectedOption.getText());
        select.selectByVisibleText("Option 2");
        System.out.println("selected option: " + firstSelectedOption.getText());

        // this will return all the options al list of web element
        List<WebElement> allOption = select.getAllSelectedOptions();
        for(WebElement eachSelectedOption : allOption){
            System.out.println(eachSelectedOption.getText());
        }
    }

    @Test
    public void sizeTest() throws InterruptedException {
        //7.Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        Thread.sleep(2000);
        List<WebElement> allOption = select.getOptions();
        int numberOfDropdownOptions = allOption.size();
        Assert.assertEquals("Expected is not equal to actual", numberOfDropdownOptions, 3);
    }

    @After
    public void quit(){
        driver.quit();
    }
}
