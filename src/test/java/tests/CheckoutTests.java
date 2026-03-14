package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {

    @Test(groups = "regression")
    public void testSuccessfulCheckout() throws InterruptedException {

        login("standard_user", "secret_sauce");


        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.id("checkout")).click();


        Thread.sleep(3000);


        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.click();
        firstName.sendKeys("Petar");

        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.click();
        lastName.sendKeys("Petrovski");

        WebElement postCode = driver.findElement(By.id("postal-code"));
        postCode.click();
        postCode.clear();
        postCode.sendKeys("7000");


        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();

        String successMessage = driver.findElement(By.className("complete-header")).getText();
        Assert.assertEquals(successMessage, "Thank you for your order!");
    }
}
