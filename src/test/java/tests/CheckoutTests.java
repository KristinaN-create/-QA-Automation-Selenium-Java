package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import pages.LoginPage;
import pages.InventoryPage;
import pages.CheckoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {

    @Test
    public void testCompleteCheckout() {

        new LoginPage(driver).login("standard_user", "secret_sauce");


        InventoryPage inventory = new InventoryPage(driver);
        inventory.addToCart("Sauce Labs Backpack");
        inventory.goToCart();
        driver.findElement(By.id("checkout")).click();


        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.fillInformation("Petar", "Petrovski", "7000");
        checkout.finishCheckout();


        Assert.assertEquals(checkout.getSuccessMessage(), "Thank you for your order!");
    }
}
