package com.myfirstproject.day_07_Cookies_Authent_NewWindow;

import com.myfirstproject.utilities.Test_Base;
import org.junit.Test;
import org.openqa.selenium.WindowType;

public class New_Tabes_Selenium4 extends Test_Base {

    @Test
    public void newTabe() {
        // open google on window 1
        driver.get("https://www.google.com");
        String googleWindowHandle = driver.getWindowHandle();
        System.out.println("Google Title: " + driver.getTitle());
        // open window on window 2
        driver.switchTo().newWindow(WindowType.TAB); // creating new window and switch to that window
        driver.get("https://www.amazon.com");
        String amazonWindowHandle = driver.getWindowHandle();
        System.out.println("Amazon Title: " + driver.getTitle());
        // open linkdin on window 3
        driver.switchTo().newWindow(WindowType.TAB); // creating new window and switch to that window
        driver.get("https://www.linkedin.com");
        String linkedinWindowHandle = driver.getWindowHandle();
        System.out.println("Linkedin Title: " + driver.getTitle());

        // switch between windows
        // switch to amazon
        driver.switchTo().window(googleWindowHandle);
        System.out.println("Amazon: " + driver.getTitle());
        // switch to amazon
        driver.switchTo().window(amazonWindowHandle);
        System.out.println("Amazon: " + driver.getTitle());
        // switch to linkedin
        driver.switchTo().window(linkedinWindowHandle);
        System.out.println("Amazon: " + driver.getTitle());
    }
}
