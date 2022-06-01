package com.myfirstproject.homework;

import com.myfirstproject.utilities.Test_Base;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class StageMovement_Test extends Test_Base {

    /*
    When a user is on the page
    Click on Add To Cart
    And verifies the product is added to the cart
    And verifies the color, size, quantity, price, shipping, Total Price
     */

    @Test
    public void test() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php");
        WebElement item = driver.findElement(By.xpath("(//a[@class='product_img_link'])[2]"));
        scrollIntoViewByJS(item);
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.moveToElement(item).perform();
        WebElement addToCart = driver.findElement(By.xpath("(//span[.='Add to cart'])[2]"));
        actions.click(addToCart).perform();
        Thread.sleep(2000);
        WebElement verifyAddition = driver.findElement(By.xpath("//span[@class='ajax_cart_product_txt ']"));
        Assert.assertTrue(verifyAddition.isDisplayed());
        WebElement verifyColorSize = driver.findElement(By.xpath("//span[.='Black, S']"));
        Assert.assertEquals("Black, S", verifyColorSize.getText());
        WebElement verifyCartQuantity = driver.findElement(By.xpath("(//span[.='1'])[1]"));
        Assert.assertEquals("1", verifyCartQuantity.getText());
        WebElement price = driver.findElement(By.xpath("//span[@id='layer_cart_product_price']"));
        Assert.assertEquals("$27.00", price.getText());
        WebElement totalProducts = driver.findElement(By.xpath("(//span[.='$27.00'])[4]"));
        Assert.assertEquals("$27.00", totalProducts.getText());
        WebElement totalShipping = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[2]/span"));
        Assert.assertEquals("$2.00", totalShipping.getText());
        WebElement totalPrice = driver.findElement(By.xpath("//span[@class='ajax_block_cart_total']"));
        Assert.assertEquals("$29.00", totalPrice.getText());

        WebElement proceedToCheckout = driver.findElement(By.xpath("//a[@class='btn btn-default button button-medium']"));
        proceedToCheckout.click();
        WebElement titleOfCheckoutPage = driver.findElement(By.xpath("//h1[@id='cart_title']"));
        Assert.assertTrue(titleOfCheckoutPage.isDisplayed());
        WebElement verifyItemInStock = driver.findElement(By.xpath("//span[@class='label label-success']"));
        Assert.assertEquals("In stock", verifyItemInStock.getText());

        WebElement increaseQuantity = driver.findElement(By.xpath("//a[@class='cart_quantity_up btn btn-default button-plus']"));
        increaseQuantity.click();
        WebElement proceedToCheckOut = driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']"));
        proceedToCheckOut.click();

        WebElement enterEmail = driver.findElement(By.id("email"));
        enterEmail.sendKeys("james_battey95@hotmail.com");
        WebElement enterPassword = driver.findElement(By.id("passwd"));
        enterPassword.sendKeys("75b7uow5");
        WebElement addressPage = driver.findElement(By.xpath("//h1[@class='page-heading']"));
        Assert.assertTrue(addressPage.isDisplayed());
        driver.findElement(By.id("SubmitLogin")).click();
        WebElement proceedtocheckout = driver.findElement(By.xpath("//button[@name='processAddress']"));
        proceedtocheckout.click();
        WebElement shippingPage = driver.findElement(By.xpath("//h1[@class='page-heading']"));
        Assert.assertTrue(shippingPage.isDisplayed());
        driver.findElement(By.name("processCarrier")).click();
        WebElement alertTitle = driver.findElement(By.xpath("//p[@class='fancybox-error']"));
        Assert.assertTrue(alertTitle.isDisplayed());
        driver.findElement(By.xpath("//a[@class='fancybox-item fancybox-close']")).click();
        driver.findElement(By.xpath("//*[@id='cgv']")).click();
        driver.findElement(By.name("processCarrier")).click();
        WebElement paymentTitle = driver.findElement(By.xpath("//h1[@class='page-heading']"));
        Assert.assertTrue(paymentTitle.isDisplayed());

        Thread.sleep(2000);
    }
}
