package com.myfirstproject.utilities;

import com.myfirstproject.day_03.Web_Driver_Manager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class Test_Base {
    /*
    Test_Base is a classs that has repeated pre condition and post condition
    we hvae @Before and @After methods
    Test_Base should be abstract. we just want to implement the methods in Test_Base. we are hiding the details.
    we dont want to create of object of Test_Base
     */
    protected static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    /*
     * Create a reusable method for clicking checkbox
     * @param checkboxElement : WebElement of the checkbox
     * @param checked : boolean of the checkbox element
     *
     * Example: if you want to click when checkbox is checked then checked = true
     *         if you want to click when checkbox is not checked then checked = false
     *
     *         selectCheckBox(checkbox1, true); make sure the checkbox1 is checked
     *         selectCheckBox(checkbox1, false); make sure the checkbox1 is unchecked
     */
    public static void selectCheckBox(WebElement checkboxElement, boolean checked) {
        if (checked) {
            if (!checkboxElement.isSelected()) { // if checkbox is not selected, click to select it
                checkboxElement.click();
            }
        } else {
            if (checkboxElement.isSelected()) { // if checkbox is selected, click to unselect it
                checkboxElement.click();
            }
        }
    }

    /*
   Accepts windowHandle as parameter
   And switches to that window
   * */
    public static void switchToTargetWindow(String targetTitle) {
        for (String handle : driver.getWindowHandles()) {
            String title = driver.switchTo().window(handle).getTitle();
            if (title.equals(targetTitle)) {
                System.out.println("Page found : "+driver.getTitle());
                return;
            }
        }
    }
}
