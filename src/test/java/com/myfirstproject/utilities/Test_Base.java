package com.myfirstproject.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class Test_Base {
    /*
    Test_Base is a classs that has repeated pre-condition and post condition
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // whenever this driver is used and need time to wait, then wait
        driver.manage().window().maximize();

        // report path create the html report right under test-output package in project
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

    //  ******************* JS Executor Methods *******************

    //  Scrolls onto a specific element. Param : webelement
    public void scrollIntoViewByJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }
    //    Scroll all the way down of a page
    public void scrollAllDownByJS(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    //    Scroll al the way up of a page
    public void scrollAllUpByJS(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)"); // dont forget to put - before document
    }
    //    Click on a specific element. Param: WebElement
    public void clickByJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",element);
    }
    //    Set the value of an input using js executor. Params: WebElement element, String text
//    This method changes the value attribute of an element.
//    It changes the input text
    public void setValueByJS(WebElement element, String text){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('value','"+text+"')",element);
    }

    //    get the value of an input. param: idOfElement
    public void getValueByJS(String idOfElement){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String value=js.executeScript("return document.getElementById('"+idOfElement+"').value").toString();
        System.out.println(value);
//        How you get the value of an input box?
//        We can js executor.
//        How?
//        I can get the element using js executor, and get the value of the element.
//        For example, I can get the element by id, and use value attribute to get the value of in an input
//        I have to do this, cause getText in this case does not return teh text in an input
    }

    //    Changes the changeBackgroundColorByJS of an element. Params: WebElement element, String color
    public void changeBackgroundColorByJS(WebElement element, String color){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].style.backgroundColor='"+color+"'",element);
    }
    public void addBorderWithJS(WebElement element, String borderStyle){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].style.border='"+borderStyle+"'",element);
    }
}
