package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @Test
    public void testAddSingleItem() {
        login("standard_user", "secret_sauce");
        addToCart("Sauce Labs Backpack");
        String badge = driver.findElement(By.className("shopping_cart_badge")).getText();
        Assert.assertEquals(badge, "1");
    }

    @Test
    public void testAddMultipleItems() {
        login("standard_user", "secret_sauce");
        addToCart("Sauce Labs Backpack");
        addToCart("Sauce Labs Bike Light");
        addToCart("Sauce Labs Bolt T-Shirt");
        String badge = driver.findElement(By.className("shopping_cart_badge")).getText();
        Assert.assertEquals(badge, "3");
    }

    @Test
    public void testRemoveFromCart() {
        login("standard_user", "secret_sauce");
        addToCart("Sauce Labs Backpack");
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
        int count = driver.findElements(By.className("shopping_cart_badge")).size();
        Assert.assertEquals(count, 0, "Кошничката треба да биде празна!");
    }
}