package com.myfirstproject.day_05;

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

public class Homework_Amazon_Dropdown {

    /*
    Create A Class: AmazonDropdown
    Create A Method dropdownTest
    Go to https://www.amazon.com/
    Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
    Print the first selected option and assert if it equals “All Departments”.If it fails, then comment that code out and continue rest of the test case.
    Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.(after you select you need to use get first selected option method). If it fails, then comment that code out and continue rest of the test case.
    Print all of the dropdown options-getOptions(); method returns the List<WebElement>. Using loop, print all options.
    Print the the total number of options in the dropdown
    Assert if ‘Appliances’ is a drop down option. Print true if “Appliances” is an option. Print false otherwise.
    BONUS: Assert if the dropdown is in Alphabetical Order
     */

    WebDriver driver;
    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");

    }

    @Test
    public void test() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("All Departments");
        WebElement firstSelectedOption = select.getFirstSelectedOption();
        System.out.println("First selected option: " + firstSelectedOption.getText());
        Assert.assertEquals("All Departments", firstSelectedOption.getText());
        List<WebElement> listOfOptions = select.getAllSelectedOptions();
        for (WebElement eachSelectedOption : listOfOptions){
            System.out.println(eachSelectedOption.getText());
        }
        //String fourthOption = listOfOptions.get(3).toString();
//        Assert.assertEquals("Amazon Devices", fourthOption);
        List<WebElement> allOptions = select.getOptions();
        for(WebElement printALLOptions : allOptions){
            System.out.println("Dropdown option " + printALLOptions.getText());
        }
        boolean flag = false;
        for (WebElement appliances : allOptions){
            if (appliances.getText().equals("Appliances")){
                flag = true;
                System.out.println("Appliances");
            }
        }
        Assert.assertTrue(flag);
    }

    @After
    public void quit(){
        driver.quit();
    }


}
