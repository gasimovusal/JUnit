package com.myfirstproject.day_08_Actions_FileUploadDownload;
import com.myfirstproject.utilities.Test_Base;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class Checkbox_Util extends Test_Base {

    @Test
    public void checkboxTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        Thread.sleep(1500);
        selectCheckBox(checkbox1, true); // it will click on checkbox to make sure its checked, if its already clicked, it will not click again
        Thread.sleep(1500);
        selectCheckBox(checkbox2, false); // it will click on checkbox to make sure its unchecked, if its already unclicked, it will not click again
        Thread.sleep(1500);
    }

}
