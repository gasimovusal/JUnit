package com.myfirstproject.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class Test_Base {
    /*
    Test_Base is a classs that has repeated pre condition and post condition
    we hvae @Before and @After methods
    Test_Base should be abstract. we just want to implement the methods in Test_Base. we are hiding the details.
    we dont want to create of object of Test_Base
     */
    protected static WebDriver driver;
    protected ExtentReports extentReports;
    protected ExtentTest extentTest;
    protected ExtentHtmlReporter extentHtmlReporter;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // report path creater the html report right under test-output package in project
        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test_output/Reports/"+currentDate+"test_report.html";

        // create html reporter using the path
        extentHtmlReporter = new ExtentHtmlReporter(path);

        // create extent report
        extentReports = new ExtentReports();

        // add custom information
        extentReports.setSystemInfo("Environment", "Test Environment");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Application", "TechPro");
        extentReports.setSystemInfo("SQA", "Vusal");

        // this info will be seen on screen
        extentHtmlReporter.config().setDocumentTitle("TechProEd Blue Car");
        extentHtmlReporter.config().setReportName("TechProEd extent report");

        // attach html and extent reports
        extentReports.attachReporter(extentHtmlReporter);

        // report is complete. now we need to reate test using extentTest ogject
        extentTest = extentReports.createTest("My project extent report", "This is for smoke test report");

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

    public void takeScreenshot() throws IOException {
        // taking screenshot using getScreenshotAs as method
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        /* alternatively
        TakesScreenshot ts = (TakesScreenshot)driver;
        File img = ts.getScreenshotAs(OutputType.FILE);
         */

        // saving the screenshot in this path
        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test_output/Screenshots/"+currentDate+"test-image.png";
        File finalPath = new File(path);
        FileUtils.copyFile(image, finalPath); // copyingfile accepts source and destination
    }
}
